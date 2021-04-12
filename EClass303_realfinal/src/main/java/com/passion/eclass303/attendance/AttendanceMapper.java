package com.passion.eclass303.attendance;

import java.util.Date;
import java.util.List;

import com.passion.eclass303.member.Member;

public interface AttendanceMapper {

	public abstract int checkAttendance(Attendance ad);
	public abstract Attendance selectAttendance(Attendance ad);
	public abstract int getAttendanceDataCount(Attendance ad);
	
	
	
	
	public abstract int getAttendanceCount(Date d);
	public abstract int getAllMemberCount();

	public abstract List<Member> NotExistMembers(Date d);
	

	
	
	
}
