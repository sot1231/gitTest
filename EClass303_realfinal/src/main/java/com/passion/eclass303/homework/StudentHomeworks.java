package com.passion.eclass303.homework;

import java.util.List;

public class StudentHomeworks {
	
	private List<StudentHomework> studentHomework;
	
	public StudentHomeworks() {
		// TODO Auto-generated constructor stub
	}

	public StudentHomeworks(List<StudentHomework> studentHomework) {
		super();
		this.studentHomework = studentHomework;
	}

	public List<StudentHomework> getStudentHomework() {
		return studentHomework;
	}

	public void setStudentHomework(List<StudentHomework> studentHomework) {
		this.studentHomework = studentHomework;
	}
	
}
