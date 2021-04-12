package com.passion.eclass303.homework;

import java.math.BigDecimal;
import java.util.Date;

public class StudentHomework {
	private BigDecimal s_seq;
	private String s_id;
	private BigDecimal s_no;
	private String s_name;
	private Date s_date;
	private String s_title;
	private String s_file;
	private String s_submit;

	public StudentHomework() {
		// TODO Auto-generated constructor stub
	}

	public StudentHomework(BigDecimal s_seq, String s_id, BigDecimal s_no, String s_name, Date s_date, String s_title,
			String s_file, String s_submit) {
		super();
		this.s_seq = s_seq;
		this.s_id = s_id;
		this.s_no = s_no;
		this.s_name = s_name;
		this.s_date = s_date;
		this.s_title = s_title;
		this.s_file = s_file;
		this.s_submit = s_submit;
	}

	public BigDecimal getS_seq() {
		return s_seq;
	}

	public void setS_seq(BigDecimal s_seq) {
		this.s_seq = s_seq;
	}

	public String getS_id() {
		return s_id;
	}

	public void setS_id(String s_id) {
		this.s_id = s_id;
	}

	public BigDecimal getS_no() {
		return s_no;
	}

	public void setS_no(BigDecimal s_no) {
		this.s_no = s_no;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public Date getS_date() {
		return s_date;
	}

	public void setS_date(Date s_date) {
		this.s_date = s_date;
	}

	public String getS_title() {
		return s_title;
	}

	public void setS_title(String s_title) {
		this.s_title = s_title;
	}

	public String getS_file() {
		return s_file;
	}

	public void setS_file(String s_file) {
		this.s_file = s_file;
	}

	public String getS_submit() {
		return s_submit;
	}

	public void setS_submit(String s_submit) {
		this.s_submit = s_submit;
	}

}
