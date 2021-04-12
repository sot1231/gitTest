package com.passion.eclass303.member;

public class Member {

	private String m_id;
	private String m_pw;
	private String m_name;
	private String m_birth;
	private String m_addr;
	private String m_mail;
	private String m_img;
	private String m_role;

	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String m_id, String m_pw, String m_name, String m_birth, String m_addr, String m_mail, String m_img,
			String m_role) {
		super();
		this.m_id = m_id;
		this.m_pw = m_pw;
		this.m_name = m_name;
		this.m_birth = m_birth;
		this.m_addr = m_addr;
		this.m_mail = m_mail;
		this.m_img = m_img;
		this.m_role = m_role;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getM_pw() {
		return m_pw;
	}

	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getM_birth() {
		return m_birth;
	}

	public void setM_birth(String m_birth) {
		this.m_birth = m_birth;
	}

	public String getM_addr() {
		return m_addr;
	}

	public void setM_addr(String m_addr) {
		this.m_addr = m_addr;
	}

	public String getM_mail() {
		return m_mail;
	}

	public void setM_mail(String m_mail) {
		this.m_mail = m_mail;
	}

	public String getM_img() {
		return m_img;
	}

	public void setM_img(String m_img) {
		this.m_img = m_img;
	}

	public String getM_role() {
		return m_role;
	}

	public void setM_role(String m_role) {
		this.m_role = m_role;
	}

}
