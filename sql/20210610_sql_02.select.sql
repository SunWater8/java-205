--2021.06.10

--특정 데이터 검색 : 행 검색 -> 컬럼 선택

--10번 부서의 사원 리스트를 출력
--10번 부서 -> where dept =10
select *
from emp
where deptno=10
;

--이름이 'SCOTT'인 사원의 출력
SELECT *
FROM EMP
WHERE ENAME='SCOTT'
;

--데이터 값은 대소문자를 구분한다.
SELECT *
FROM EMP
WHERE ENAME='scott'
;

--날짜타입의 데이터 비교시에도 작은 따움표를 이용해야 한다.
select *
from emp
where hiredate = '96/11/17'
;

--논리 연산자 : and, or, not
--10번 부서의 관리자 (manager)를 찾아 출력
select ename, job, deptno
from emp
where job='MANAGER'and deptno=10
;

--10번 부서의 직원들과 관리자들의 리스트를 출력
select *
from emp
where deptno=10 or job='MANAGER'
;
--10번 부서의 직원을 제외한 나머지 직원들을 출력
select *
from emp
where not deptno=10
;

--범위의 연산을 할 때 -> 논리연산자 이용, between a and b
--between a and b : a이상 ~ ㅠdlgk

--2000이상 3000이하의 급여를 받는 직원의 리스트
select ename, sal
from emp
where sal between 2000 and 3000
;

--between 연산자는 날짜의 연산도 가능
-- 1981년에 입사한 사원들의 리스트를 출력
select ename, hiredate
from emp
where hiredate between '81/01/01' and '81/12/31'
;

--연산자 in -> 여러개의 or 연산자 사용시 대체 할 수 있다.
--commision이 300이거나 500이거나 1400인 사원 출력
select *
from emp
--where comm=300 or comm=500 or comm=1400
where comm in(300,500,1400)
;

--패턴 검색 : 키워드 검색 많이 사용 (게시판)
--컬럼 like '%'
-- ename like 'F%' -> F로 시작하는 문자열 검색
-- ename like '%F' -> F로 끝나는 문자열 검색
-- ename like '%F%' -> F를 포함하는 문자열 검색
--  'java' 단어를 포함하는지 -> title like '%java%'

--F로 시작하는 이름을 가진 사원을 검색
select ename
from emp
where ename like 'F%'
--where ename like'%ES'
--where ename like '%LA%'
;

--자리수 패턴 : 컬럼의 값에 자리 수가 정해져 있고 값에 패턴이 있는 경우 
-- 사원 이름의 두 번째 문자에 A가 들어간 사원 리스트 출력
select *
from emp
where ename like '_A%'
--where ename like '__A%'     -- 세 번째 문자에 A가 들어간 사원의 이름 출력
--where ename not like '__A%' -- not like
;

-- null 값을 확인하는 연산자 -> is null, is not null
-- commision이 등록되지 않은 사원의 리스트
select *
from emp
--where comm is null    -- null 인 사원들
where comm is not null  -- null이 아닌 사원들(commision 등록이 되어 있는 사원들)
order by comm
;

-- 결과 행의 정렬 : order by 컬럼 [asc|desc]
--급여가 적은 사원부터 출력 (오름차순 asc)
select *
from emp
order by sal asc
--order by sal      -- 정렬의 기준은 오름차순이다
;

--급여가 큰 사원부터 출력
select *
from emp
order  by sal desc         -- 급여가 같은 사원 이름은 자동으로 desc 순으로 되어 있다.
;

--급여가 큰 사원부터 출력하고 급여가 같은 사원은 이름을 기준으로 오름차순으로 출력
select *
from emp
order by sal desc, ename asc
;
select * from customer;

