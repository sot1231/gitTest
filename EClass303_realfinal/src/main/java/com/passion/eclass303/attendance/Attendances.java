package com.passion.eclass303.attendance;

import java.util.List;

public class Attendances {

	private List<Attendance> attendance;

	public Attendances() {
		// TODO Auto-generated constructor stub
	}

	public Attendances(List<Attendance> attendance) {
		super();
		this.attendance = attendance;
	}

	public List<Attendance> getAttendance() {
		return attendance;
	}

	public void setAttendance(List<Attendance> attendance) {
		this.attendance = attendance;
	}

}
