create table attend_33(
	a_no number(6)primary key,
	a_id varchar2(15 char)not null,
	a_date date not null,
	a_attend varchar2(2 char)not null
);

insert into attend_33 values(attend_33_seq.nextval, 'aa', to_date(sysdate, 'yy-mm-dd'), 'o');
select * from attend_33 where a_id = 'aa' and a_date = to_date(sysdate, 'yy-mm-dd');
create sequence attend_33_seq;
select * from attend_33;
drop table attend_33 cascade constraint purge;
