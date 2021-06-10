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