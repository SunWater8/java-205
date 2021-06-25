insert into member
values(0,'관리자', 'admin', '5678' , '신촌점', '0212345678',0);
select * from member;
commit;

select * from sale;
desc sale;
drop table sale;

create sequence sale_sq;

select address, phone from member where id ='admin';

update member set pw = '333' where id = 'e';