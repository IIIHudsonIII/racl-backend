package br.com.racl.model;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Schedule {

	@Id
	private String id;
	private String week_day;
	private String initial_hour;
	private String final_hour;
	private String information;
	private String id_device;

	public Schedule() {
		this.setId(UUID.randomUUID().toString());
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWeek_day() {
		return week_day;
	}

	public void setWeek_day(String week_day) {
		this.week_day = week_day;
	}

	public String getInitial_hour() {
		return initial_hour;
	}

	public void setInitial_hour(String initial_hour) {
		this.initial_hour = initial_hour;
	}

	public String getFinal_hour() {
		return final_hour;
	}

	public void setFinal_hour(String final_hour) {
		this.final_hour = final_hour;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public String getId_device() {
		return id_device;
	}

	public void setId_device(String id_device) {
		this.id_device = id_device;
	}
}
