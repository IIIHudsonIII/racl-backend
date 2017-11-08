package br.com.racl.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class RouteWeekDayTime {

	@Id
	private String id;
	private String week_day;
	private String time_initial;
	private String time_final;
	private String id_device;

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

	public String getTime_initial() {
		return time_initial;
	}

	public void setTime_initial(String time_initial) {
		this.time_initial = time_initial;
	}

	public String getTime_final() {
		return time_final;
	}

	public void setTime_final(String time_final) {
		this.time_final = time_final;
	}

	public String getId_device() {
		return id_device;
	}

	public void setId_device(String id_device) {
		this.id_device = id_device;
	}
}
