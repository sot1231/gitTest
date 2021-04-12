package com.passion.eclass303.homework;

import java.math.BigDecimal;
import java.util.Date;

public class Homework {
	private BigDecimal h_seq;
	private String h_writer;
	private Date h_date;
	private String h_startdate;
	private String h_enddate;
	private String h_title;
	private String h_content;
	private String h_file;
	private String h_role;

	public Homework() {
		// TODO Auto-generated constructor stub
	}

	public Homework(BigDecimal h_seq, String h_writer, Date h_date, String h_startdate, String h_enddate,
			String h_title, String h_content, String h_file, String h_role) {
		super();
		this.h_seq = h_seq;
		this.h_writer = h_writer;
		this.h_date = h_date;
		this.h_startdate = h_startdate;
		this.h_enddate = h_enddate;
		this.h_title = h_title;
		this.h_content = h_content;
		this.h_file = h_file;
		this.h_role = h_role;
	}

	public BigDecimal getH_seq() {
		return h_seq;
	}

	public void setH_seq(BigDecimal h_seq) {
		this.h_seq = h_seq;
	}

	public String getH_writer() {
		return h_writer;
	}

	public void setH_writer(String h_writer) {
		this.h_writer = h_writer;
	}

	public Date getH_date() {
		return h_date;
	}

	public void setH_date(Date h_date) {
		this.h_date = h_date;
	}

	public String getH_startdate() {
		return h_startdate;
	}

	public void setH_startdate(String h_startdate) {
		this.h_startdate = h_startdate;
	}

	public String getH_enddate() {
		return h_enddate;
	}

	public void setH_enddate(String h_enddate) {
		this.h_enddate = h_enddate;
	}

	public String getH_title() {
		return h_title;
	}

	public void setH_title(String h_title) {
		this.h_title = h_title;
	}

	public String getH_content() {
		return h_content;
	}

	public void setH_content(String h_content) {
		this.h_content = h_content;
	}

	public String getH_file() {
		return h_file;
	}

	public void setH_file(String h_file) {
		this.h_file = h_file;
	}

	public String getH_role() {
		return h_role;
	}

	public void setH_role(String h_role) {
		this.h_role = h_role;
	}

}
