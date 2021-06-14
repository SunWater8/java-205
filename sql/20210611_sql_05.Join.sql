--2021.06.11

--JOIN

--CROSS JOIN
--스키마의 합 : 테이블과 테이블의 합이다. 집합의 곱 연산과 같다. 

select *
From emp, dept; ---56개의 행이 나옴. (14행 X 4행 = 56행) 모든 경우의 수가 나오는 것과 같음 - 크로스 조인

--Equi JOIN
--14개 행이 나옴.
--외래키와 기본키를 참조 비교함.

SELECT *
FROM EMP, DEPT
WHERE EMP.DEPTNO = DEPT.DEPTNO
;

--이름이 SCOTT인 사람의  --> where e.ename = 'SCOTT'
--부서명을 출력해 봅시다.
--출력해야하는 컬럼을 가지는 테이블을 확인해보자.

-- 이름 : EMP, 부서명: DEPT
--부서 이름별로 정렬하기
SELECT ename, d.dname, d.deptno
FROM EMP e, DEPT d
WHERE e.DEPTNO = d.DEPTNO AND ENAME = 'SCOTT'
order by d.dname, e.ename;

-- self join : 자기 자신을 조인(참조)
-- emp -> mgr 컬럼이 emp.empno 참조
select e.empno,e.ename, e.mgr,m.ename 
from emp e, emp m
where e.mgr = m.empno(+) --(+)를 써 줌으로써 null 값이어도 출력해준다. 
;

--------------------------------------------------------------
-- 2021.06.14
--------------------------------------------------------------

--NON EQUI JOIN
--동등 비교가 아닌 크다 작다와 같은 비교로 조인의 조건을 작성

select * from salgrade;

select e.ename, e.sal, s.grade, s.losal, s.hisal
from emp e, salgrade s
order by e.ename
;

-- 급여 금액에 따라서 등급을 매기는 조건 넣어서 14개 행으로 만들기
select e.ename, e.sal, s.grade, s.losal, s.hisal
from emp e, salgrade s
where e.sal>s.losal and e.sal<=s.hisal
--where sal between s.losal and s.hisal  --위와 의미가 같은 문장
order by e.ename
;
-- ansi cross join
select *
from emp cross join dept
;




-- --ansi inner join 하기 전 마당서점 테이블 살펴보기 (세 개의 테이블 조인하기)

select * from orders;
select * from customer;
select *from book;
-- orderid를 기본키로 하고 custid와 bookid 를 외래키로 하는 세개의 테이블 조인 하기.

--1. 모든 테이블을 붙여보기 (모든 경우의 수) - 500개 행 출력됨
select *
from orders, customer, book
;
--2. orderid 를 기준으로 정렬
select *
from orders, customer, book
order by orderid
;

--3. 100개 행으로 출력
select *
from orders o, customer c, book b
where o.custid = c.custid
order by o.orderid
;

--4. 10행으로 출력
select *
from orders o, customer c, book b
where o.custid = c.custid and o.bookid = b.bookid
order by o.orderid
;
--5. 칼럼 정리하기
select o.orderid, c.name, b.bookname
from orders o, customer c, book b
where o.custid = c.custid and o.bookid = b.bookid
order by o.orderid
;




--회원별 구매 내역 출력
select c.name, o.orderid
from orders o, customer c
where o.custid = c.custid
order by c.name
;

select * from customer;

--null인 박세리도 포함하는 회원별 구매 내역 출력
select c.name, o.orderid
from orders o, customer c
where o.custid(+) = c.custid
order by c.name
;

-- 회원별로 구매횟수와 총 평균금액 출력하기
-- 이 처리를 가지고 '이 달의 구매왕'을 뽑을 수 있다. 
select c.name, count(o.orderid) as "구매 횟수", avg(saleprice)
from orders o, customer c
where o.custid(+) = c.custid -- +가 있느냐 없느냐로 구매고객의 통계정보를 알 수 있다.
group by c.name
order by c.name
;





--ansi -> inner join
--오라클 EQUI JOIN
select *
from emp, dept
where emp.deptno = dept.deptno
;

select *
from emp e inner join dept d
on e.deptno = d.deptno
;


--scott인 사원의 정보 출력 (두 개의 테이블 조인 후)
select *
from emp e inner join dept d
on e.deptno = d.deptno
where e.ename = 'SCOTT'
;

-- 같은 컬럼의 이름을 하나로 하기 
--on 절을 생략하고 -> using 을 이용하면 조건식을 간략하게 처리 가능
-- 단, 비교하는 컬럼의 이름이 같을 때만 using을 사용할 수 있다.
select *
from emp e inner join dept d
using (deptno)
where e.ename = 'SCOTT'
;

-- natural join
select *
from emp natural join dept
;

--outer join (self join과 연계)
-- 다음은 self join 방식
select e.empno, e.ename, e.mgr, m.ename 
from emp e, emp m
where e.mgr = m.empno(+) --> 표현하고자 하는 컬럼이 테이블의 반대쪽, null 값을 가지는 위치에 (+)를 해준다. 
;
--outer join 방식
--[left | right | full] outer join
select e.empno, e.ename, e.mgr, m.ename 
--from emp e left outer join emp m
from emp e right outer join emp m --emp가 오른쪽으로 가능 경우
on e.mgr = m.empno 
;

