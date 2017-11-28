package br.com.racl.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Device {

	@Id
	private String id;
	private String name;
	private String information;
	private double last_latitude;
	private double last_longitude;

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

	public double getLast_latitude() {
		return last_latitude;
	}

	public void setLast_latitude(double last_latitude) {
		this.last_latitude = last_latitude;
	}

	public double getLast_longitude() {
		return last_longitude;
	}

	public void setLast_longitude(double last_longitude) {
		this.last_longitude = last_longitude;
	}
	
	public Device populate(Device old) {
		if (hadMoved()) {
			this.name = old.getName();
			this.information = old.getInformation();
		}
		return this;
	}

	public boolean validate() {
		return id != null && !(id = id.trim()).isEmpty();
	}
	
	public boolean hadMoved() {
		return this.last_latitude != 0 && this.last_longitude != 0;
	}
}
