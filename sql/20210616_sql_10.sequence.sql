--2021.06.16

--SEQUENCE : 번호 재생기
CREATE SEQUENCE pi_idx_pk;

-- 누를 때 마다 새롭게 생성하기
select pi_idx_pk.nextval
from dual;

--지금 가지고 있는 값을 확인 할 때.
select pi_idx_pk.currval
from dual;

--객체를 저장할 때


----------------------------------------------
--- 2021.06.17
----------------------------------------------

--sequence : 숫자를 생성하는 객체
-- 설정을 통해서 일련번호를 (연속되는 숫자를) 생성해준다. -> 기본키가 대리키인 경우 입력되는 값으로 사용한다.

--dept 테이블 구조 복사 -> deptno 에 들어갈 데이터 sequence 생성 -> insert 테스트
drop table dept03;
--(1) dept 테이블 구조 복사
create table dept03
as select * from dept where 1=0;

select * from dept03;

--(2) 
create sequence dept_deptno_seq
increment by 10
start with 10;

--(3) dept03에 저장
-- insert into dept03 values (10, 'dev', 'seoul'); --10이 들어간 자리에 sequence 넣어주기
insert into dept03 values (dept_deptno_seq.nextval, 'dev', 'seoul');




--대학친구, 회사 친구 테이블 -> 기본키(대리키) -> sequence 생성 -> insert 개선

-- sequence : 번호 재생기
CREATE SEQUENCE pi_idx_pk;
CREATE SEQUENCE PI_U_IDX_PK START WITH 6 INCREMENT BY 1;
CREATE SEQUENCE PI_C_IDX_PK START WITH 6 INCREMENT BY 1;


--PHONEINFRO_UNIV에 INSERT 할 때 잔동으로 기본키를 연속적인 번호를 지정할 수 있다.
INSERT INTO phoneinfo_univ
VALUES (PI_U_IDX_PK, 'SPANISH', 3, pi_idx_pk.NEXTVAL)
;

