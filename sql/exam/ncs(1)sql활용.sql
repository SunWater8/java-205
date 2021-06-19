--1. 아래 조건에 맞는 DDL을 작성하시오.
create table Contact(
    idx number(6) primary key,
    name varchar(20) not null,
    phonenum varchar(20) not null,
    address varchar(20) default ' - ' not null,
    email varchar(20) default ' - 'not null,
    category varchar(10) constraint Contact_category_ck CHECK (constraint in('univ','com','cafe')),
    major varchar(20),
    univyear number(1),
    companyname varchar(20),
    deptname varchar(20),
    job varchar (20),
    groupname varchar(20),
    nickname varchar(20)
);

--2. DEPT 테이블에 데이터를 삽입하는 SQL을 작성하시오. 입력 데이터는 임의로 작성하시오.
select *from dept;
insert into dept(deptno, dname, loc)
            values(50, 'MARKETING', 'BRISTOL')
;

--3. DEPT 테이블에 위에서 삽입한 데이터의 dname, loc 데이터를 변경하는 SQL을 작성하시오.
update dept
set dname='HUMAN RESOURCE', loc='MANCHESTER'
where deptno=50
;


--4. DEPT 테이블에 위에서 삽입한 데이터를 deptno 컬럼의 값을 기반으로 삭제하는 SQL을 작성하시오.
delete from dept
where dname='HUMAN RESOURCE'
;

--5. 사용자가 보유한 테이블 목록을 확인하는 SQL문을 작성하시오.
select * from tab;

--6. EMP 테이블의 구조를 확인하는 SQL을 작성하시오.
desc EMP;

--7. 사용자가 정의한 제약조건들을 확인하는 SQL문을 작성하시오.
select *
from user_constraints
where table_name='DEPT';



--1. EMP 테이블의 ename 컬럼에 인덱스를 생성하는 SQL을 작성하시오. 인덱스의 이름은 emp_index
select * from emp;
create index emp_index
on emp(ename)
;

--2. EMP 테이블과 DEPT 테이블을 조인하는 SQL을 기반으로 view 객체를 생성하는 SQL을 작성하시오.
--view 의 이름은 emp_view 로 하시오. 

create or replace view emp_view
as select *
from emp natural join dept
;

select * from  emp_view ;

--3. EMP 테이블에서 모든 사원의 부서번호를 이름이 'SCOTT'인 사원의 부서번호로 변경하는 SQL을 작성하시오.
update emp 
set deptno = (select deptno from emp where ename='SCOTT')
;


