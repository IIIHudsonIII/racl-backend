package br.com.racl.service.rest;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.racl.controller.RouteController;
import br.com.racl.model.Point;
import br.com.racl.model.Route;

@RestController
@RequestMapping("/route")
@CrossOrigin(origins = "*")
public class RouteRest {

	@Autowired
	private RouteController routeController;

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Route save(@RequestBody Route route) {
		if (route.getId() == null || route.getId().isEmpty()) {
			route.setId(UUID.randomUUID().toString());
		}
		calculateLimits(route);
		return routeController.save(route);
	}

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Route> list() {
		try {
			return routeController.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error on retrieve.");
		}
	}

	@RequestMapping(method = RequestMethod.GET, params = "name")
	public @ResponseBody Route list(String name) {
		try {
			return routeController.findByName(name);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error on retrieve.");
		}
	}

	@RequestMapping(method = RequestMethod.GET, params = { "latitude", "longitude" })
	public @ResponseBody Route findByLatLng(Double latitude, Double longitude) {
		try {
			List<Route> routes = routeController.list();

			for (Route route : routes) {
				calculateLimits(route);

				System.out.println("######### latitude : " + latitude + " ############ longitude : " + longitude);

				if (route.getLatitude_min() <= latitude && latitude <= route.getLatitude_max()
						&& route.getLongitude_min() <= longitude && longitude <= route.getLongitude_max()) {
					return route;
				}
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error on retrieve.");
		}
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public @ResponseBody void deleteById(@RequestBody Route device) {
		try {
			routeController.delete(device.getId());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error on retrieve.");
		}
	}

	public void calculateLimits(Route route) {
		List<Point> points = route.getPoints();
		Point p1, p2;

		Double maxLatPoint = null;
		Double minLatPoint = null;
		Double maxLgnPoint = null;
		Double minLgnPoint = null;

		for (int i = 1; i < points.size(); i++) {
			p1 = points.get(i - 1);
			p2 = points.get(i);

			double max = 0;
			double min = 0;

			if (p1.getLatitude() < p2.getLatitude()) {
				if (p1.getLatitude() < 0) {
					min = p1.getLatitude();
					max = p2.getLatitude();
				} else {
					max = p1.getLatitude();
					min = p2.getLatitude();
				}
			} else {
				if (p2.getLatitude() < 0) {
					max = p1.getLatitude();
					min = p2.getLatitude();
				} else {
					min = p1.getLatitude();
					max = p2.getLatitude();
				}
			}

			min = new BigDecimal(String.valueOf(min)).setScale(3, BigDecimal.ROUND_FLOOR).doubleValue();
			max = new BigDecimal(String.valueOf(max)).setScale(3, BigDecimal.ROUND_CEILING).doubleValue();

			if (minLatPoint == null || minLatPoint > min) {
				minLatPoint = min;
			}
			if (maxLatPoint == null || maxLatPoint < max) {
				maxLatPoint = max;
			}
			// LONGITUDE
			if (p1.getLongitude() < p2.getLongitude()) {
				if (p1.getLongitude() < 0) {
					min = p1.getLongitude();
					max = p2.getLongitude();
				} else {
					max = p1.getLongitude();
					min = p2.getLongitude();
				}
			} else {
				if (p2.getLongitude() < 0) {
					max = p1.getLongitude();
					min = p2.getLongitude();
				} else {
					min = p1.getLongitude();
					max = p2.getLongitude();
				}
			}

			min = new BigDecimal(String.valueOf(min)).setScale(3, BigDecimal.ROUND_FLOOR).doubleValue();
			max = new BigDecimal(String.valueOf(max)).setScale(3, BigDecimal.ROUND_CEILING).doubleValue();

			if (minLgnPoint == null || minLgnPoint > min) {
				minLgnPoint = min;
			}
			if (maxLgnPoint == null || maxLgnPoint < max) {
				maxLgnPoint = max;
			}
		}

		route.setLatitude_min(minLatPoint);
		route.setLatitude_max(maxLatPoint);

		route.setLongitude_min(minLgnPoint);
		route.setLongitude_max(maxLgnPoint);

		System.out.println("Info do CÁLCULO:" + "\nlat: " + minLatPoint + "/" + maxLatPoint + "\nlng: " + minLgnPoint
				+ "/" + maxLgnPoint);
	}
}
