create table member_33(
	m_id varchar2(15 char) primary key,
	m_pw varchar2 (20 char) not null,
	m_name varchar2 (10 char) not null,
	m_birth varchar2 (8 char) not null,
	m_addr varchar2 (200 char) not null,
	m_mail varchar2(30 char) not null,
	m_img varchar2(200 char) not null,
	m_role varchar2 (2 char) not null

);

select * from MEMBER_33;
drop table member_33 cascade constraint purge;
update	MEMBER_33 set  m_role='t' where  m_name like '송원택';


select m_id from MEMBER_33 where m_id != 'a'and m_id!= 'b' and m_id!='c' and m_role!= 't';


select m_id from MEMBER_33 where not exists (
	select distinct a_id from ATTEND_33 where m_id in (
			select a_id from ATTEND_33 where a_date = to_date(sysdate, 'yy-mm-dd')	
	)
) and m_role !='t';

select m_id from MEMBER_33 where not exists (
	select distinct a_id from ATTEND_33 where m_id = a_id and a_date = to_date(sysdate, 'yy-mm-dd')
) and m_role !='t';

update member_33 set m_name = '김길동'
		where m_id= 'b';
