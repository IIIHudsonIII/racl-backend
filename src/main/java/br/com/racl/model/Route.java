package br.com.racl.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Route {

	@Id
	private String id;
	private String name;
	private double latitude_min;
	private double latitude_max;
	private double longitude_min;
	private double longitude_max;
	private String week_days;
	private List<Point> points;
	private List<Schedule> schedules;

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

	public double getLatitude_min() {
		return latitude_min;
	}

	public void setLatitude_min(double latitude_min) {
		this.latitude_min = latitude_min;
	}

	public double getLatitude_max() {
		return latitude_max;
	}

	public void setLatitude_max(double latitude_max) {
		this.latitude_max = latitude_max;
	}

	public double getLongitude_min() {
		return longitude_min;
	}

	public void setLongitude_min(double longitude_min) {
		this.longitude_min = longitude_min;
	}

	public double getLongitude_max() {
		return longitude_max;
	}

	public void setLongitude_max(double longitude_max) {
		this.longitude_max = longitude_max;
	}

	public String getWeek_days() {
		return week_days;
	}

	public void setWeek_days(String week_days) {
		this.week_days = week_days;
	}

	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}

	public List<Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}
}
