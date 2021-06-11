--2021.06.11

--JOIN

--CROSS JOIN
--스키마의 합 : 집합의 곱 연산과 같다.

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
SELECT ename, d.dname
FROM EMP e, DEPT d
WHERE e.DEPTNO = d.DEPTNO AND ENAME = 'SCOTT';

--부서 이름별로 정렬하기
select ename, d.dname
from emp e, dept d
where e.deptno = d.deptno 
order by d.dname, e.ename
;

--self join
--자기 자신을 조인(참조)
--emp -> mgr 컬럼이 emp.empno 참조
select e.empno,e.ename, e.mgr,m.ename 
from emp e, emp m
where e.mgr=m.empno(+) --(+)를 써 줌으로써 null 값이어도 출력해준다. 
;