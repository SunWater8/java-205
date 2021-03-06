desc sale;
select * from sale;

--커밋하기 전에 이전 테이블을 drop 해 주세요. 
drop table sale;
drop sequence sale_sq;

--sale테이블
create table sale (
salecode integer constraint sale_PK primary key,
sname varchar2(50) not null,
price integer not null,
saledate date default sysdate,
id varchar2(50) constraint sale_FK references member(id)
);

create table sale (
salecode integer constraint sale_PK primary key,
sname varchar2(50) not null,
price integer not null,
saledate date default sysdate,
id varchar2(50)
);


-- sale 시퀀스
create sequence sale_sq
start with 1;

-- sale 값

insert into sale(salecode, sname, price,saledate, id) values (sale_sq.nextval, 'latte', 4600, '21/06/21', 'a');
insert into sale(salecode, sname, price,saledate, id) values (sale_sq.nextval, 'salad', 5000, '21/06/21', 'a');
insert into sale(salecode, sname, price,saledate, id) values (sale_sq.nextval, 'cake', 5500, '21/06/22', 'b');
insert into sale(salecode, sname, price,saledate, id) values (sale_sq.nextval, 'Amerciano', 4100, '21/06/22', 'a');
insert into sale(salecode, sname, price, id) values(sale_sq.nextval, 'americano', 4100, 'a');
insert into sale(salecode, sname, price, id) values (sale_sq.nextval, 'latte', 4600, 'c');
insert into sale(salecode, sname, price, id) values (sale_sq.nextval, 'sandwich', 6200, 'a');

select * from sale;
commit;