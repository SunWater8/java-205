create table Admin(
    idx number(10) primary key,
    id varchar(20) unique not null,
    pw varchar(20) not null
);
insert into admin
values(1, 'admin1', '1234');

insert into admin
values(2,'admin2','1234');

commit;

select * from admin;