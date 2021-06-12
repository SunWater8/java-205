-- 2021.06.11
-- 그룹 함수 - 여러 행을 묶어 처리하는 함수
-- 그룹함수는 여러행의 특정 컬럼의 값들을 대상으로 한다.
-- sum, avg, count, max, min   - null 값이 있는 행은 제외시킨다.

-- 사원 테이블에서
-- 1. 사원의 수   
-- 2. 사원의 급여 총합
-- 3. 급여 평균
-- 4. 최대 급여
-- 5. 최소 급여

select count(*) as "사원의 수", 
        sum(sal) as "급여의 총합", 
        round(avg(sal), 2) as"급여 평균", --소수점 자르기
        max(sal) as "최대 급여",
        min(sal) as "최저 급여"
--        sum(comm) as "커미션의 총 합",   --그룹연산은 null 값을 제외하고 연산한다.
--        avg(comm) as "커미션의 평균",
--        count(comm) as "커미션을 받는 사원의 수"
from emp;

--distinct를 이용해서 중복된 개수 제거
select count(distinct job )
from emp;

--마당 서적 book 테이블에 책을 납품하는 출판사
select count(distinct publisher)
from book;

--특정 컬럼을 이용해서 그룹핑하기 > group by
-- select
-- from 테이블
-- where
-- group by 그룹핑 할 기준의 컬럼

--부서 별 급여 평균 구하기
----기존 방식
select round(avg(sal),2) from emp where deptno = 10;
select round(avg(sal),2) from emp where deptno = 20;
select round(avg(sal),2) from emp where deptno = 30;
----group by 사용
--부서 별 사원 수, 부서 별 급여 총 합, 부서 별 급여 평균
select deptno, count(*) as "부서 인원",
                sum(sal) as "부서의 급여 총합", 
                trunc(avg(sal)) as "부서의 급여 평균" ,
                max(sal) as"부서의 최대 급여 액",
                min(sal) as "부서의 최소 급여 액"
from emp
group by deptno
order by deptno
;

-- group by 응용
select distinct job
from emp;

select job, count(*)
from emp
group by job
;
--16p 부서 별로 
--사원 수와 커미션을 받는 사원들의 수를 계산
select deptno, count(*), count(comm)
from emp
group by deptno
;

-- group by 
-- select
-- from
-- where
-- group by
-- having 그룹함수 연산자 값( = != > < >= <=)

-- 그룹 지어진 부서별 평균 급여가 2000 이상인 
-- 부서변호와 부셔별 평균 급여 출력하기
select deptno, trunc(avg(sal)) as "급여 평균"
from emp
group by deptno
having avg(sal) >= 2000;

--부서의 최대값과 최소값을 구하되 최대 급여가 2900이상인 부서만 출력하기
select deptno, max(sal), min(sal)
from emp
group by deptno
having max(sal)>=2900
order by deptno  --정렬은 마지막에 입력
;