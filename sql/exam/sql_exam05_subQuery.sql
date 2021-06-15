--2021.06.15

--43. 사원 번호가 7788인 사원과 담당 업무가 같은 사원을 표시(사원 이름과 담당업무)하시오.
select ename, job
from emp e
where job = (select job from emp where empno=7788)
;
-- self join 방식


--44. 사원번호가 7499인 사원보다 급여가 많은 사원을 표시하시오. 사원이름과 감당 업무
select ename, job
from emp
where sal>(select sal from emp where empno=7499)
;
--self join 방식

--45. 최소급여를 받는 사원의 이름, 담당업무 및 급여를 표시하시오. (그룹함수 사용)
--비교 연산자 사용
select ename , job, sal
from emp
where sal <= ALL(select sal from emp)
;

--집합함수 사용
 select ename, job, sal
 from emp
 where sal = (select min(sal) from emp)
 ;
--46. 평균급여가 가장 적은 직급의 
--    직급 이름과 직급의 평균을 구하시오.
select job, avg(sal)
from emp
group by job
having avg(sal) <= ALL(select avg(sal) from emp group by job)
;
--인라인 뷰
select min(avg)
from (
    select avg(sal) as avg
    from emp
    group by job
)
;

--비교해서 구하기
select job, avg(sal)
from emp
group by job
having avg(sal) <= ALL(select min(avg) from emp group by job)
;
--47. 각 부서의 최소 급여를 받는 사원의 이름, 급여, 부서번호를 표시하시오.

select ename, sal, deptno
from emp e1
where sal in (
    select min(sal) 
    from emp e2 
    where e1.deptno = e2.deptno 
    group by deptno) 
;
--부서 별 최소급여 구해보기
 select deptno, min(sal)
 from emp
 group by deptno
 ;
--48. 담당업무가 ANALYST 인 사원보다 
--급여가 적으면서 
--업무가 ANALYST가 아닌 사원들을 표시
--(사원번호, 이름, 담당 업무, 급여)하시오.

-- 약간 모자른 답안
select empno, ename, job, sal
from emp
where sal < any (select sal from emp where job='ANALYST')
and deptno in(select deptno from emp where job != 'ANALYST') 
order by sal
;

-- 정확하고 깔끔한 방식
select empno, ename, job, sal
from emp
where sal < all (select sal from emp where job='ANALYST')
and job != 'ANALYST' 
order by sal
;

--49. 부하직원이 없는 사원의 이름을 표시하시오.
select distinct mgr from emp where mgr is not null;

select ename, mgr
from emp
where empno not in (select distinct mgr from emp where mgr is not null)
;

--50. 부하직원이 있는 사원의 이름을 표시하시오.

select ename, mgr
from emp
where empno in (select distinct mgr from emp where mgr is not null)
;

--내가 전에 한 방식
select distinct e.ename, e.mgr
from emp e, emp m
where e.empno=m.mgr
;
select *
from emp e, emp m
where e.empno=m.mgr
;
--51. BLAKE와 동일한 부서에 속한 사원의 이름과 입사일을 표시하는 질의를 작성하시오. ( 단 BLAKE는 제외 )


select ename, hiredate
from emp 
where deptno=(select deptno from emp where ename='BLAKE')
    and ename != 'BLAKE'
;

--52. 급여가 평균 급여보다 많은 사원들의 
--사원 번호와 이름을 표시하되
--결과를 급여에 대해서 오름차순으로 정렬하시오.

select empno, ename, sal
from emp
where sal > (select avg(sal) from emp )
order by sal 
;

--내가 전에 한 방법 (any가 안들어가야 함)
select empno, ename, sal
from emp
where sal > any(select avg(sal) from emp )
order by sal 
;

-- 53. 이름에 K가 포함된 사원과 같은 부서에서 일하는 사원의 사원 번호와 이름을 표시하시오.
select empno, ename
from emp 
where deptno in(select distinct deptno from emp where ename like '%K%')
;

--exists 사용한 방법
-- self join 사용

--54. 부서위치가 DALLAS인 사원의 이름과 부서번호 및 담당업무를 표시하시오.
select e.ename, e.deptno, e.job
from emp e
where e.deptno = (select d.deptno from dept d where d.loc = 'DALLAS')
;
-- join
select e.ename, e.deptno, e.job
from emp e, dept d
where e.deptno = d.deptno and d.loc = 'DALLAS'
;
--55. KING에게 보고하는 사원의 이름과 급여를 표시하시오.
select ename, sal, job
from emp
where mgr = (select empno from emp )
;
select e.ename, e.sal
from emp e, emp m
where e.empno = m.mgr and m.ename = 'KING'
;

select *
from emp
;
select e.ename, e.sal
from emp e
where e.empno = m.mgr and m.mgr = (select m.mgr from emp m where m.ename = 'KING')
;
-- 56. RESEARCH 부서의 사원에 대한 부서번호, 사원이름 및 담당 업무를 표시하시오.
select e.empno, e.ename, e.job
from emp e
where e.deptno = (select d.deptno from dept d where d.dname='RESEARCH')
;

--57. 평균 월급보다 많은 급여를 받고 
--이름에 M이 포함된 사원과 같은 부서에서 근무하는 사원의 
--사원 번호, 이름, 급여를 표시하시오.
select empno, ename, sal
from emp 
where sal > ( select avg(sal) from emp) 
and deptno in(select distinct deptno from emp where ename like '%M%')
;

--58. 평균급여가 가장 적은 업무를 찾으시오.

select job , avg(sal)
from emp 
group by job
having avg(sal) <= ALL(
    select avg(sal)
    from emp
    group by job
)
;

--59. 담당업무가 MANAGER 인 사원이 소속된 부서와 동일한 부서의 사원을 표시하시오.
select ename
from emp
where deptno in(select distinct deptno from emp where job='MANAGER')
;

