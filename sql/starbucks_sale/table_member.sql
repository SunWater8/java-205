
--커밋하기 전에 이전 테이블을 drop 해 주세요. 
drop table member;
drop sequence member_sq;

-- member 테이블
create table member (
memcode integer constraint mem_PK primary key,
name varchar2(50)  not null,
id varchar2(50) unique not null,
pw varchar2(50) not null,
address varchar2(255),
phone varchar2(30) not null,
point number(10) default 0 not null
);

-- member 시퀀스
create sequence member_sq
start with 1;

-- member 값
-- id는 a,b,c순
-- 비밀번호는 1234 통일
insert into member (memcode, name, id, pw, address, phone, point) values (member_sq.nextval, '김은선', 'a', '1234', '서울', '010-1234-5678', 1000);
insert into member (memcode, name, id, pw, address, phone, point) values (member_sq.nextval, '위세라', 'b', '1234', '서울', '010-2245-1256', 1500);
insert into member (memcode, name, id, pw, address, phone, point) values (member_sq.nextval, '이윤성', 'c', '1234', '서울', '010-2256-6548', 2000);
insert into member (memcode, name, id, pw, address, phone, point) values (member_sq.nextval, '이현우', 'd', '1234', '서울', '010-9853-5631', 5000);
insert into member (memcode, name, id, pw, address, phone, point) values (member_sq.nextval, '박지성', 'e', '1234', '서울', '010-7852-2364', 9000);
insert into member (memcode, name, id, pw, address, phone, point) values (member_sq.nextval, '이강인', 'f', '1234', '서울', '010-9462-6489', 4000);

commit;