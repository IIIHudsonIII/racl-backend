package br.com.racl.service.rest;

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

	@RequestMapping(method = RequestMethod.DELETE)
	public @ResponseBody void deleteById(@RequestBody Route device) {
		try {
			routeController.delete(device.getId());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error on retrieve.");
		}
	}
}
