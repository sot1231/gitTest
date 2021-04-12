create table homework_33_2021f(
	h_seq number(4) primary key,
	h_writer varchar2(15 char) not null,
	h_date date default sysdate,
	h_startdate varchar2(8 char)not null,
	h_enddate varchar2(8 char)not null,
	h_title varchar2(50 char)not null,
	h_content varchar2(500 char)not null,
	h_file varchar2(200 char)not null,
	h_role varchar2(2char)not null
);

create sequence homework_33_2021f_seq;
select * from homework_33_2021f;
drop sequence homework_33_2021f_seq;
drop table homework_33_2021f cascade constraint purge;

create table student_33_2021f(
	s_seq number(4) primary key,
	s_id varchar2(15 char) not null,
	s_no number(4) not null,
	s_name varchar2(10 char) not null,
	s_date date not null,
	s_title varchar2(50 char)not null,
	s_file varchar2(200 char)not null,
	s_submit varchar2(2 char)not null,
		constraint student_33_2021f
		foreign key(s_id) references member_33(m_id)
		on delete cascade
);

create sequence student_33_2021f_seq;
select * from STUDENT_33_2021F;
drop table student_33_2021f cascade constraint purge;
