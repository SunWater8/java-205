-- cross join


-- cross join (56행 출력 = 14*4)
select *
from emp, dept
;
-- ansi cross join (56행 출력 = 14*4)
select *
from emp cross join dept
;



--equi join
-- 부서 번호를 기준으로 2 테이블 합치기 (14행 출력)
select *
from emp, dept
where emp.deptno = dept.deptno
;

--또 다른 equi join
-- customer, orders, book 이 3 테이블을 합치고 주문번호, 주문한 사람, 책이름을 출력하기
select o.orderid, c.name, b.bookname
from orders o, customer c, book b
where o.custid = c.custid and o.bookid = b.bookid
order  by o.orderid
;

-- equi join 은 ansi inner join과 결과가 같다.(1)
-- 부서번호로 두개의 테이블 합치기 
select * from emp, dept
where emp.deptno=dept.deptno
;
-- ansi inner join
select *
from emp e inner join dept d
on e.deptno = d.deptno
;


--equi join 은 ansi inner join과 결과가 같다.(2)
-- 이름이 SCOTT인 사람의 부서명을 출력하기 . 출력해야 하는 컬럼을 가지는 테이블을 확인해보자.
-- 이름 : emp, 부서명 : dept
select e.ename, d.dname, d.deptno
from emp e, dept d
where e.deptno=d.deptno 
and e.ename='SCOTT'
;

select e.ename, d.dname, d.deptno
from emp e inner join dept d
on e.deptno=d.deptno 
and e.ename='SCOTT'
;

--using
-- ansi inner join 에서 using 사용 : 언제? 비교하는 컬럼의 이름이 같을 때 사용하기
-- on 절을 생략하고 -> using을 이용하면 조건식을 간략하게 처리할 수 있다.
select *
from emp e inner join dept d
using (deptno)
where e.ename='SCOTT'
;

--NATURAL JOIN
--emp테이블 뒤에 natural 하게 dept 테이블 붙이기
select *
from emp NATURAL JOIN dept
;

--self join : 자기 자신을 조인 (참조)
-- emp 테이블의 mgr 컬럼이 자기 자신의 emp.empno 참조
-- 사원 각각의 관리자 이름을 출력하기. 출력할 칼럼: 사원번호, 사원이름, 관리자 사원번호, 관리자 사원이름.
select e.empno, e.ename, e.mgr, m.ename as manager
from emp e, emp m
where e.mgr=m.empno(+)   -- 표현하고자 하는 컬럼이 테이블의 반대쪽, null 값을 가지는 위치에 (+)표시를 하면 null 값이어도 출력해준다.
order by empno
;
--위의 문장들과 비교하기 위해 만듦
select empno,ename, mgr
from emp
order by empno
;

--outer join
-- self join과 결과가 같음.
-- [left || right || full]
select e.empno, e.ename, e.mgr, m.ename as manager
from emp e left outer join emp m
on e.mgr = m.empno
order by empno
;
select e.empno, e.ename, e.mgr, m.ename as manager
from emp e right outer join emp m
on e.mgr = m.empno
order by empno
;
select e.empno, e.ename, e.mgr, m.ename as manager
from emp e full outer join emp m
on e.mgr = m.empno
order by empno
;
--self join과 비교해보기
select e.empno, e.ename, e.mgr, m.ename as manager
from emp e, emp m
where e.mgr=m.empno(+)  
order by empno
;