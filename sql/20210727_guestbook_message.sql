create table project.guestbook_message(
	-- 자바에서 변수로 써야 하기 때문에 언더바 사용은 하지 않는게 좋다. 
    messageid int not null auto_increment primary key,
    guestname varchar(20) not null,
    password varchar(20) not null,
    message text not null,
    regdate timestamp default current_timestamp
);

-- select
select * from project.guestbook_message limit 0, 3; 
-- 페이징 처리 : (limit index, count) 게시물을 한 페이지 당 3개 씩 보이도록 할 때 사용 됨.

-- 가장 최근 게시물을 위에 보이도록 하기
select * from project.guestbook_message order by regdate desc;

-- 최근 순으로 게시물이 한 페이지에 3개씩 보이게 하기
select * from project.guestbook_message order by regdate desc limit 0, 3;

-- insert
insert into project.guestbook_message (guestname, password, message)
values('king','1111','HELLO');

-- update
update project.guestbook_message 
set guestname='scott', password='0000', message='안녕하세요'
where messageid = 1;