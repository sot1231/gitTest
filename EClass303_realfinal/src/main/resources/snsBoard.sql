create table snsboard_33(
	s_num number(6) primary key,
	s_writer varchar2 (20 char) not null,
	s_date date not null,
	s_content varchar2(300 char) not null
);

create sequence sb_seq;
select * from SNSBOARD_33;
drop table snsboard_33 cascade constraint purge;

create table snsboard_reply_33(
	sr_num number(6) primary key,
	sr_s_num number(6) not null,
	sr_writer varchar2 (15 char) not null,
	sr_reply varchar2 (200 char) not null,
	sr_date date not null,
	constraint snsboard_reply foreign key(sr_s_num) references snsboard_33(s_num)
	on delete cascade
);

create sequence sb_r_req;
select * from snsboard_reply_33; 
