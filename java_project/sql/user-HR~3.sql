--cross join
--스키마의 합 : 집합의 곱 연산과 같다.

select *
from emp, dept;

--equi join
select *
from emp, dept
where emp.deptno=dept.deptno
;

--이름이 scott인 사람의 부서을 출력하기 . 출력해야 하는 컬럼을 가진 테이블을 확인해보기
--이름:emp, 부서명: dept
select ename, d.dname
