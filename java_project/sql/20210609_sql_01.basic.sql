--2021.06.09
--SQL Basic

--계정 HR이 보유한 테이블 객체 리스트
select * from tab;

--테이블의 정보를 검색 : 컬럼의 이름, null 유무(not null 일 경우에만 표시)
DESC emp;

--데이터 조회를 위한 명렁 : select 
--select {컬럼명,..., *} from 테이블 이름;
select * from emp;

--필요한 컬럼을 출력(select from 의미: 1. 새로운 표를 만든다. 2.표에서 검색해서 출력한다.) 
--select 컬럼명, 컬럼명 from 테이블 이름;
--사원번호와 사원이름을 출력
select empno, ename, sal, deptno
from emp
;

--select 컬럼의 산술연산이 가능 : 컬럼과 숫자의 연산, 컬럼과 컬럼 간의 산술 연산 가능
--사원이름, 월 급여, 연봉계산 결과 값(sal*12)
SELECT ename, sal, sal*12 AS YSAL
FROM emp
;

--null : 정해지지 않은 값 (값이 없는 것이 아님)
SELECT sal, comm, sal*comm , sal*12, sal/10, sal+sal*0.1
FROM emp
;

-- nvl : null값이 있으면 0을 기본값으로 설정해 주기(null value logic)
SELECT comm,nvl(comm,0), sal*comm, sal*nvl(comm,0)
FROM emp
;

--사원의 이름, 직급, 급여, 커미션, 연봉(급여*12), 연봉(급여*12*커미션)
SELECT ename, job, sal, comm, sal*12 as ysal1 , sal*12+comm as ysal2
FROM emp
;

--개선 : null 값을 0으로 치환해서 연산
--nvl(컬럼 이름, 기본값) : 컬럽의 값이 null 일 때 기본값으로 치환
SELECT ename, job, sal, nvl(comm,0), sal*12 as ysal1 , sal*12+nvl(comm,0) as ysal2
FROM emp
;

--컬럼과 문자열을 붙이는 연산에 || 이용
--행단위로 실행 됨
--sql에서 문자열을 표현할 때는 작은 따움표(')를 이용한다. 자바에서는 큰 따움표 (")
SELECT ename ||' is a '|| job
FROM emp
;

--결과 리스트에서 중복된 값을 제거 : distinct 
SELECT deptno
FROM emp
;

--개선 : 
SELECT DISTINCT deptno
FROM emp
;
SELECT distinct deptno, job
FROM emp
order by job --정렬 : 행 줄세우기
;


--특정 데이터를 검색하기 위해서는 
--select ~ from ~구문에 where절을 이용한다.
-- where 뒤에는 조건식이 정의된다. - where 컬럼명 비교연산자 값
-- where sal >= 3000
SELECT *
FROM emp
WHERE sal >= 3000;

-- 전체 속성이 아닌 사원 이름, 사원 번호, 급여만 출력
SELECT ename, empno, sal
FROM emp
WHERE sal >= 3000;
