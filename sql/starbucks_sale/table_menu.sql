desc menu;
select * from menu;
--커밋하기 전에 이전 테이블을 drop 해 주세요. 
drop table menu;
drop sequence menu_sq;

-- 메뉴 DB
drop table menu;
create table menu (
menucode integer constraint menu_PK primary key,
mname varchar2(50) not null,
price number(10) not null
);

-- 메뉴 시퀀스
create sequence menu_sq
start with 1;

-- 메뉴 values
insert into menu(menucode, mname, price) values (menu_sq.nextval, 'americano', 4200);
insert into menu(menucode, mname, price) values (menu_sq.nextval, 'latte', 4700);
insert into menu(menucode, mname, price) values (menu_sq.nextval, 'sandwich', 4800);
insert into menu(menucode, mname, price) values (menu_sq.nextval, 'bagel', 2300);
insert into menu(menucode, mname, price) values (menu_sq.nextval, 'cake', 4800);
insert into menu(menucode, mname, price) values (menu_sq.nextval, 'cake', 4800);

commit;

