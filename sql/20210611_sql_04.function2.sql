--2021.06.11

--그룹함수 - 여러 행을 묶어 처리하는 함수
-- 그룹함수는 여러행의 특정 컬럼의 값들을 대상으로 한다.
-- sum, avg, count, max, min - null 값이 있는 행은 제외시킨다.

--사원 테이블에서 다음의 조건의 값을 구하기
--1. 사원의 수
--2. 사원의 급여 총합
--3. 급여 평균 (소수점 자르기)
--4. 최대 급여
--5. 최소 급여
select count(*), sum(sal), trunc(avg(sal))as avg, max(sal), min(sal)
from emp
;

--커미션의 총 합, 커미션의 평균, 커미션을 받는 사원의 수 구하기
select sum(comm), trunc(avg(comm))as avg, count(comm) 
from emp
;

--중복된 업무의 개수 제외한 개수 세기 (distinct)
select count(distinct job)
from emp
;

-- 마당 서적book테이블에서 책을 납품하는 출판사 수 세기
select count(distinct publisher)
from book
;

-- group by -> 특정 컬럼을 이용해서 그룹핑하기
--select 그룹핑 할 기준이 되는 컬럼, 그룹함수
--from 테이블
--where
--group by 그룹핑 할 기준의 칼럼

--부서 별 급여평균 구하기 -소수점 셋째 자리에서 반올림 (1)기존 방식
select round(avg(sal),2) from emp where deptno=10;
select round(avg(sal),2) from emp where deptno=20;
select round(avg(sal),2) from emp where deptno=30;

--부서 별 급여평균 구하기 -소수점 셋째 자리에서 반올림 (2) group by 사용
select deptno, round(avg(sal),2)
from emp
group by deptno
order by deptno
;

-- 부서 별로 사원 수, 급여 총합, 급여 평균, 최대 급여, 최소 급여를 각각 구하기
select deptno, count(*), sum(sal), round(avg(sal),2), max(sal), min(sal)
from emp
group by deptno
order by deptno
;

-- 직급 별 사원의 수 구하기
select  job, count(*)
from emp
group by job
order by job
;

--부서 별로 사원 수와 커미션을 받는 사원들의 수를 계산해서 출력
select deptno, count(*), count(comm)
from emp
group by deptno
order by deptno
;

-- having -> group by의 그룹함수의 결과를 비교 시에는 having 절 사용
--select
--fromo 
--where
--group by
--having 그룹함수 연산자 값(=  !=  <  >  <=  >=)

--HAVING
--부서 별 평균 급여가 2000 이상인 (having)
--부서번호와 부서 별 평균 급여를 출력
select deptno, round(avg(sal),2) as "avg sal"
from emp
group by deptno
having avg(sal)>=2000
order by deptno
;

--부서의 급여에서 최대 급여와 최소 급여를 구하되
--최대 급여가 2900 이상인 부서만 출력하기
select deptno, max(sal), min(sal)
from emp
group by deptno
having max(sal)>=2900
order by deptno
;