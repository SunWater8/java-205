-- 2021.06.10
-- function:단일행 함수, 집합함수 (다중행 함수)
-- 단일행 함수: 하나의 행이 포함하는 특정 컬럼의 값 하나를 처리하고 반환한다.
-- 다중행 함수 : 여러행의 특정 컬럼값들을 대상으로 연산하고 반환한다.


-- 숫자 함수
select 'oracle'
from dual
;

--dual은 연습하기 위한 테이블
--select * from dual; 

select abs(10), abs(-10)
from dual
;

select FLOOR(15.7) --소수점 이하 절사 되어서 출력
from dual
;

select round(15.193, 1), --소수점 첫 번째 자리까지 반올림 해서 표현
round(15.193, -1)        --1째 자리에서 반올림.
from dual
;

select TRUNC(15.79,1), --소수점 첫 째 자리 이후 절사
trunc(15.79)           -- 소수점 모두 절사
from dual;

select mod(11,4) --11을 4로 나눈 나머지
from dual;

--사원들의 급여 20%를 금액으로 표현
select sal, MOD(sal, 2)      
from emp;

select sal, mod(sal, 2)
from emp
where mod(sal,2)=1
;

-- 문자 함수
-- concat(문자, 문자) -> ''||''
select concat('abc', 'efg'), 'abc' || 'efg'
from dual
;

-- 문자열 추출 : substr
--substr(문자열, 시작 위치, 길이)
select substr('apple',1,3)
from dual
;

--뒤에서 추출
select substr('apple', -3)    
from dual
;

-- replace : 특정 문자열(패턴)을 다른 문자열(패턴)으로 변경
select REPLACE('JACK and JUE','J','BL')
from dual
;

--오늘 날짜 출력
select sysdate
from dual
;


------------------------------------------------------
--2021.06.11
------------------------------------------------------

-- 형변환 함수 (단일행 함수)
-- 날짜 -> 문자, 숫자 -> 문자
-- to_char(날짜 데이터, '패턴'), to_char(숫자, '패턴')        --패턴:내가 어떻게 출력할지에 대한 내용.
select sysdate, to_char(sysdate, 'yyyy.mm.dd. hh24:mi:ss')
from dual;


select ename, hiredate, to_char(hiredate, 'yyyy.mm.dd. ')
from emp
;

select orderid, orderdate, to_char(orderdate, 'yyyy.mm.dd.') 
from orders ;

-- 숫자 -> 문자
select to_char(123456, '0,000,000,000'), to_char(123456,'L9,999,999,999')
from dual
;

select ename, sal, to_char(sal*1000, 'L999,999,999')
from emp;

-- 문자 -> 숫자, 문자 -> 날짜
-- to_number(문자열, 패턴)
select to_number('1,000,000','9,999,999'),
        to_number('1,000,000', '9,999,999')+100000
from dual;

--문자-날짜
-- to_date(문자열, 패턴)
select to_date('2012.05.17', 'yyyy.mm.dd')
from dual;

select sysdate-to_date('2012.05.17', 'yyyy.mm.dd') --살아온 날짜
from dual;

select trunc(sysdate-to_date('2012.05.17', 'yyyy.mm.dd')) -- 살아온 날짜, 소수점 절사
from dual;

select trunc((sysdate-to_date('2012.05.17', 'yyyy.mm.dd'))/365)  --만 나이 계산
from dual;

-- decode 함수 : 분기를 위해 사용 switch-case 유사
-- decode(칼럼, = 조건1 값, 조건1의 참일 때 사용할 값
--          , 조건2 값, 조건2의 참일 때 사용할 값
--          , ....
-- )

-- emp 테이블에서 부서번호에 맞는 부서 이름 출력
select * from dept;

-- 10 ACCOUNTING
-- 20 RESEARCH
-- 30 SALES
-- 40 OPERATIONS

select ename, deptno,
        decode(deptno, 10, 'ACCOUNTING',
                       20, 'RESEARCH',
                       30, 'SALES',
                       40, 'OPERATIONS'
        ) as dname
from emp
order by dname
;


-- 8. 직급에 따라 급여를 인상하도록 하자.
-- 직급이 'ANALYST'인 사원은 5%,
--       'SALESMAN'인 사원은 10%,
--       'MANAGER'인 사원은 15%,
--       'CLERK'인 사원은 20%,

select empno, ename, job, sal, 
       decode(job, 'ANALYST', sal+(sal*0.05),    -- sal*1.05 라고 하는 것과 같음.
                   'SALESMAN', sal+(sal*0.1), 
                   'MANAGER', sal+(sal*0.15), 
                   'CLERK', sal+(sal*0.2)
              )as upsal
from emp;

-- case 함수도 분기할 때 사용. 크다 작다의 비교 연산자도 사용 가능.
-- case when 조건식 then 참일 때 값
select ename, deptno,
        case when deptno=10 then 'ACCOUNTING'
             when deptno=20 then 'RESEARCH'
             when deptno=30 then 'SALES'
             when deptno=40 then 'OPERATIONS'
        end as dname
from emp
order by dname;

