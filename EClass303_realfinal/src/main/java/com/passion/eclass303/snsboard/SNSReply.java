package com.passion.eclass303.snsboard;

import java.math.BigDecimal;
import java.util.Date;

public class SNSReply {

	private BigDecimal sr_num;
	private BigDecimal sr_s_num;
	private String sr_writer;
	private String sr_reply;
	private Date sr_date;

	public SNSReply() {
		// TODO Auto-generated constructor stub
	}

	public SNSReply(BigDecimal sr_num, BigDecimal sr_s_num, String sr_writer, String sr_reply, Date sr_date) {
		super();
		this.sr_num = sr_num;
		this.sr_s_num = sr_s_num;
		this.sr_writer = sr_writer;
		this.sr_reply = sr_reply;
		this.sr_date = sr_date;
	}

	public BigDecimal getSr_num() {
		return sr_num;
	}

	public void setSr_num(BigDecimal sr_num) {
		this.sr_num = sr_num;
	}

	public BigDecimal getSr_s_num() {
		return sr_s_num;
	}

	public void setSr_s_num(BigDecimal sr_s_num) {
		this.sr_s_num = sr_s_num;
	}

	public String getSr_writer() {
		return sr_writer;
	}

	public void setSr_writer(String sr_writer) {
		this.sr_writer = sr_writer;
	}

	public String getSr_reply() {
		return sr_reply;
	}

	public void setSr_reply(String sr_reply) {
		this.sr_reply = sr_reply;
	}

	public Date getSr_date() {
		return sr_date;
	}

	public void setSr_date(Date sr_date) {
		this.sr_date = sr_date;
	}

}
