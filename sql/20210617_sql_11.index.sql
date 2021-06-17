--2021.06.17

-- index : 검색을 빠르게 하기 위한 객체
--         물리적인 저장 공간이 필요
--         생성 시간이 필요
--         너무 많은 인덱스는 dml 작업이 많은 경우 성능 저하기 온다.

--emp01 테이블을 복사 -> 로우들을 계속 복사
drop table emp01;

create table emp01
as select * from emp ;

--자기 자신의 데이터를 복사해서 증가시키기
insert into emp01 select * from emp01;

select * from emp01;


--하나의 행 추가
insert into emp01 (empno, ename) values (7777,'KING');
insert into emp01 (empno, ename) values (7777,'SON');

-- 검색하기
select * from emp01 where ename='KING' order by empno;
select * from emp01 where ename='SON';


--
-- index 만들기
-- emp01 테이블에 ename 컬럼을 index로 설정하기
create index index_emp01_ename
on emp01 (ename)
;

select * from emp01 where ename = 'SON';  --검색이 더 빨라졌다.

-- 주식거래처럼 검색을 많이 하는 경우 이러한 인덱스가 사용된다. 사용빈도 수가 많고 under 5 (5개 이해) 로우에서 사용하기에 성능적으로 좋다.
