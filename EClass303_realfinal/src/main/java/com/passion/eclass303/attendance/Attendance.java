package com.passion.eclass303.attendance;

import java.math.BigDecimal;
import java.util.Date;

public class Attendance {
	private BigDecimal a_no;
	private String a_id;
	private Date a_date;
	private String a_attend;

	public Attendance() {
		// TODO Auto-generated constructor stub
	}

	public Attendance(BigDecimal a_no, String a_id, Date a_date, String a_attend) {
		super();
		this.a_no = a_no;
		this.a_id = a_id;
		this.a_date = a_date;
		this.a_attend = a_attend;
	}

	public BigDecimal getA_no() {
		return a_no;
	}

	public void setA_no(BigDecimal a_no) {
		this.a_no = a_no;
	}

	public String getA_id() {
		return a_id;
	}

	public void setA_id(String a_id) {
		this.a_id = a_id;
	}

	public Date getA_date() {
		return a_date;
	}

	public void setA_date(Date a_date) {
		this.a_date = a_date;
	}

	public String getA_attend() {
		return a_attend;
	}

	public void setA_attend(String a_attend) {
		this.a_attend = a_attend;
	}

}
