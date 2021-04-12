package com.passion.eclass303.homework;

import java.util.List;

public interface StudentHomeworkMapper {
	public abstract int studentRegHomework(StudentHomework shw);
	public abstract List<StudentHomework> selectAllStudentHomework(Homework hw);
}
