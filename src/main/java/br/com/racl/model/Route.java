package br.com.racl.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Route {

	@Id
	private String id;
	private String name;
	private String information;
	private double latitude_minimum;
	private double latitude_maximum;
	private double longitude_minimum;
	private double longitude_maximum;
	private String week_days;
	private RouteWeekDayTime route_week_day_device;
	private RoutePoint route_point;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public double getLatitude_minimum() {
		return latitude_minimum;
	}

	public void setLatitude_minimum(double latitude_minimum) {
		this.latitude_minimum = latitude_minimum;
	}

	public double getLatitude_maximum() {
		return latitude_maximum;
	}

	public void setLatitude_maximum(double latitude_maximum) {
		this.latitude_maximum = latitude_maximum;
	}

	public double getLongitude_minimum() {
		return longitude_minimum;
	}

	public void setLongitude_minimum(double longitude_minimum) {
		this.longitude_minimum = longitude_minimum;
	}

	public double getLongitude_maximum() {
		return longitude_maximum;
	}

	public void setLongitude_maximum(double longitude_maximum) {
		this.longitude_maximum = longitude_maximum;
	}

	public String getWeek_days() {
		return week_days;
	}

	public void setWeek_days(String week_days) {
		this.week_days = week_days;
	}

	public RouteWeekDayTime getRoute_week_day_device() {
		return route_week_day_device;
	}

	public void setRoute_week_day_device(RouteWeekDayTime route_week_day_device) {
		this.route_week_day_device = route_week_day_device;
	}

	public RoutePoint getRoute_point() {
		return route_point;
	}

	public void setRoute_point(RoutePoint route_point) {
		this.route_point = route_point;
	}
}
