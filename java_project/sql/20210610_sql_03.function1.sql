-- 2021.06.10
--function : 단일행 함수, 집합(다중행)함수
-- 단일행 함수 : 하나의 행이 포함하는 특정 컬럼의 값 하나를 처리하고 반환
-- 다중행(집합) 함수 : 여러행의 특정 컬럼 값들을 대상으로 연산하고 반환

--숫자 함수 (abs, floor, round, trunc, mod)
--절대값으로 표현
-- +10 -> 10
-- -10 -> 10
select abs(10), abs(-10)
from dual
;

--소수점 이하 절사 되어서 출력 (floor)
-- 15.7 -> 15
select floor(15.7)
from dual;

-- 소수점 몇 번째 자리에서 반올림 하여 표현 (round)
-- 15.193 -> 15.19
-- 15.193 -> 20
select round(15.193,2), round(15.193,-1)
from dual;

-- 소수점 첫째 자리 이후 절사(trunc)
--15.79 -> 15.7
--15.79 -> 10
select trunc(15.79,1),
trunc(15.79,-1)
from dual;

-- 나머지 값 구하기
-- 11을 4로 나눈 나머지 ->3
select mod(11,4)
from dual;

--사원들 급여의 20%를 금액으로 표현
select ename, sal, sal*0.2 as "20% sal"
from emp;
select sal, mod(sal,2)
from emp
--where mod(sal,2) =1
;

--문자 함수 (concat, ||, substr, replace)
-- concat(문자, 문자) -> ''||''
select concat('abc', 'efg'), 'abc' || 'efg'
from dual
;

--문자열 추출 (substr)
--substr(문자열, 시작 위치, 길이)

--apple -> app 추출하기
select substr('apple',1,3)
from dual;

--apple -> ple (뒤에서 추출)
select substr('apple',-3)
from dual;

-- replace : 특정 문자열(패턴)을 다른 문자열(패턴)으로 변경
-- JACK and JUE -> BLACK and BLUE (J를 BL로 바꾸기)
select replace('JACK and JUE', 'J', 'BL')
from dual;

--오늘 날짜 출력
select sysdate
from dual
;

--모든 사원 이름의 스펠링을 A에서 L로 바꾼다. 그리고 봉급을 백 단위로 절사한다. 
select empno, ename, replace(ename, 'A', 'L'), sal, round(sal, -2)
from emp;

------------------------------------------------------------------------
-- 2021.06.11
------------------------------------------------------------------------

--형변환 함수 (단일행 함수)
-- 날짜 -> 문자,    숫자 -> 문자

-- to_char(날짜 데이터, '패턴'), to_char(숫자, '패턴')
-- 오늘 날짜와 현재시각 표시하기 - 년도/월/일/, 년도.월.일 시:분:초(24시 형식)
select sysdate, to_char(sysdate, 'yyyy.mm.dd. hh24:mi:ss')
from dual;

--사원들의 입사일을 년도.월.일. 의 형식으로 표시하는 칼럼 만들기
select ename, hiredate, to_char(hiredate, 'yyyy.mm.dd.')
from emp;

--orders 테이블에서 주문한 날짜를 년도.월.일 의 형식으로 표시하기
select orderid, orderdate, to_char(orderdate, 'yyyy.mm.dd.')
from orders;

-- 숫자 -> 문자
--123456 -> 0,000,123,456        123456 -> w123,456 (w는 원화표시 대체)
select to_char(123456, '0,000,000,000'), to_char(123456, 'L9,999,999,999')
from dual
;

--800 -> w800,000  (사원들의 급여에 1,000단위를 다 넣어주고 콤마로 천 단위씩 끊어주고 급여 앞에 원화표시하기)
select ename, sal, to_char(sal*1000, 'L999,999,999')
from emp;

-- 문자-> 숫자,    문자-> 날짜
-- to_number(문자열, 패턴)

--1,000,000 -> 1000000
--1,000,000 + 100000 -> 1100000 (바뀌어진 숫자 타입으로 더하기 연산까지 하기) 
select to_number('1,000,000', '9,999,999'),
       to_number('1,000,000', '9,999,999') + 100000
from dual;

-- 문자 - 날짜
-- to_date(문자열, 패턴)

-- 2012.05.17 -> 12/05/17  (패턴이 있는 문자형태의 날짜를 날짜형으로 바꿔주기)
-- 2012.05.17부터 오늘까지 살아 온 날짜 계산하기 -> 3314
select to_date('2012.05.17', 'yyyy.mm.dd'),
       trunc(sysdate-to_date('2012.05.17', 'yyyy.mm.dd')) 
from dual;

-- 만 나이 계산하기 (소수점 절사하기 위해 trunc 사용)
select trunc((sysdate-to_date('2012.05.17','yyyy.mm.dd'))/365)
from dual;

--decode 함수 : 분기를 위해 사용. switch-case와 유사
--decode(칼럼, 조건1값, 조건 1이 참일 때 사용할 값,
--            조건2값, 조건 2이 참일 대 사용할 값,
--            ....
--       )

-- emp 테이블에서 부서 번호에 맞는 부서 이름 출력
select *from dept;
--10 ACCOUNTING
--20 RESEARCH
--30 SALES
--40 OPERATIONS

select ename, deptno, 
       decode(deptno, 10, 'ACCOUNTING',
                      20, 'RESEARCH',
                      30, 'SALES',
                      40, 'OPERATIONS'
       ) as dname
from emp
order by dname
;

-- 직급에 따라 급여를 인상하기
--'ANALYST'인 사원은 5%
--'SALESMAN'인 사원은 10%
--'MANAGER'인 사원은 15%
--'CLERK'인 사원은 20%
select ename, job, sal, 
       decode(job, 'ANALYST', sal*1.05,
                   'SALESMAN', sal*1.1,
                   'MANAGER', sal*1.15,
                   'CLERK', sal*1.2
       ) as upsal
from emp
;

-- case 함수도 분기할 때 사용
-- case when 조건식 then 참일 때 값
select ename, deptno,
       case when deptno=10 then 'ACCOUNTING'
            when deptno=20 then 'RESEARCH'
            when deptno=30 then 'SALES'
            when deptno=40 then 'OPERATIONS'
       end as dname
from emp
order  by dname;
