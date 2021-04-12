package com.passion.eclass303.member;

import java.util.List;

public interface MemberMapper {

	public abstract List<Member> checkId(Member m);
	public abstract int regMember(Member m);
	public abstract int updateMember(Member m);
	public abstract int deleteMember(Member m);
	public abstract List<Member> getMemeberById(Member m);
	public abstract List<Member> findMemberID(Member m);
	public abstract int findMemberPW(Member m);
}
