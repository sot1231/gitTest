package com.passion.eclass303.snsboard;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class SNSBoard {

	private String m_id;
	private String m_img;

	private BigDecimal s_num;
	private Date s_date;
	private String s_content;

	private List<SNSReply> s_replys;

	public SNSBoard() {
		// TODO Auto-generated constructor stub
	}

	public SNSBoard(String m_id, String m_img, BigDecimal s_num, Date s_date, String s_content,
			List<SNSReply> s_replys) {
		super();
		this.m_id = m_id;
		this.m_img = m_img;
		this.s_num = s_num;
		this.s_date = s_date;
		this.s_content = s_content;
		this.s_replys = s_replys;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getM_img() {
		return m_img;
	}

	public void setM_img(String m_img) {
		this.m_img = m_img;
	}

	public BigDecimal getS_num() {
		return s_num;
	}

	public void setS_num(BigDecimal s_num) {
		this.s_num = s_num;
	}

	public Date getS_date() {
		return s_date;
	}

	public void setS_date(Date s_date) {
		this.s_date = s_date;
	}

	public String getS_content() {
		return s_content;
	}

	public void setS_content(String s_content) {
		this.s_content = s_content;
	}

	public List<SNSReply> getS_replys() {
		return s_replys;
	}

	public void setS_replys(List<SNSReply> s_replys) {
		this.s_replys = s_replys;
	}

}
