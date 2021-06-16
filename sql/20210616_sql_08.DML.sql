--2021.06.16
--DML
--
--데이터 입력 : 행단위 입력
--INSERT INTO 테이블명 (컬럼명,...) VALUES(데이터, 데이터,...)
--입력하고자 하는 컬럼과 입력 데이터의 개수는 일치
--컬럼의 도메인과 입력데이터의 타입이 일치
--기본키와 같이 NOT NULL 인 경우 컬럼을 생략하면 안됨.


--테스트 테이블 생성
CREATE TABLE DEPT01
AS
SELECT * FROM DEPT WHERE 1=0;

DESC DEPT01; --컬럼 명 확인

-- 1번 부서 개발팀 서울 위치
INSERT INTO DEPT01(DEPTNO, DNAME, LOC)
            VALUES (1, 'DEVELOPE', 'SEOUL')
;

SELECT * FROM DEPT01;  -- 행 입력 확인

--컬럼의 개수가 VALUES 개수가 다를 때 오류 ( "too many values")
INSERT INTO DEPT01(DEPTNO, DNAME)
            VALUES (1, 'DEVELOPE', 'SEOUL')
;

--values 개수가 잘못 되었을 때 오류 ("not enough values")
INSERT INTO DEPT01(DEPTNO, DNAME, LOC)
            VALUES (1, 'DEVELOPE')
;

--타입이 잘못 맞추었을 때 오류 - 숫자인데 ''작은따움표 사용하더라도 자동 형변환 되기 때문에 오류가 나지 않는다.
INSERT INTO DEPT01(DEPTNO, DNAME, LOC)
            VALUES ('30', 'DEVELOPE', 'SEOUL')
;
--타입이 잘못 맞추었을 때 오류2 ("invalid number")
INSERT INTO DEPT01(DEPTNO, DNAME, LOC)
            VALUES ('이십', 'DEVELOPE', 'SEOUL')
;

-- not null 제약 조건이 있는 경우에 오류 ("cannot insert null into ("HR"."DEPT"."DEPTNO")")
insert into dept(dname, loc)
            values('develope', 'seoul')
;

--데이터 저장할 
--
-- VALUES 절의 데이터의 순서 : 테이블이 생성될 때 정의된 컬럼의 순서 -> DESC 테이블
DESC DEPT01;

INSERT INTO DEPT01 VALUES(20, 'MARKETING', 'PUSAN');

--데이터의 순서가 바뀌면 오류 발생 ("invalid number")
INSERT INTO DEPT01 VALUES( 'MARKETING',20, 'PUSAN');



desc emp;

--데이터를 잘 못 입력 했을 때 롤백으로 되돌아가기 하면 된다. (트랜젝션 특징)
insert into emp (empno, deptno) values(7777,60);
select * from emp;
rollback;

desc orders;
-- custid에는 6번이 없기 때문에 오류 발생 ? ("parent key not found")
insert into orders (orderid, custid, bookid)values(11, 6,11);


--서브쿼리를 이용해서 데이터 입력
drop table dept02;
create table dept02
as select * from dept where 1=0;

desc dept02;
select * from dept02;

--데이터 입력 
insert into dept02
select *from dept;

--자기 자신의 데이터를 또 입력
insert into dept02
select *from dept02;



--update : 데이터를 변경 - 행단위로 선택하고 변경하고자 하는 컬럼을 기술
--   update 테이블 명 
--   set 컬럼이름 = 새로운 데이터, 컬럼이름=새로운 데이터, ...
--   where 행을 선택하는 조건


--새로 만든 dept03 테이블에 dept 테이블을 내용도 모두 복사 시킨 후, 모든 부서를 서울로 위치 시키기
create table dept03
as select * from dept;

select * from dept03;

update dept03
set loc = 'SEOUL';
-- where (조건이 모든 부서이기 때문에 where 절은 굳이 필요하지 않음) 

--10번 부서의 위치를 pusan으로 이동하고, 부서이름도 DEV 로 변경
update dept03
set loc='PUSAN', dname = 'DEV'
where deptno=10
;

--EMP01 새롭게 생성하고 UPDATE
DROP TABLE EMP01;

CREATE TABLE EMP01
AS SELECT * FROM EMP;

SELECT * FROM EMP01;

-- UPDATE 01 : 모든 사원의 부서 번호를 30번으로 수정합시다.
UPDATE EMP01
SET DEPTNO=30;

-- UPDATE 02 : 모든 사원의 급여를 10% 인상시킵니다.
UPDATE EMP01
SET SAL=SAL*1.1;

-- UPDATE 03 : 모든 사원의 입사일을 오늘로 수정.
UPDATE EMP01
SET HIREDATE = SYSDATE;        
-- 특정 날짜로 하고 싶으면 SET HIREDATE = '21/06/15' 이렇게 하면 됨.

ROLLBACK;
--부서번호가 10번인 사원의 부서번호를 30번으로 수정
UPDATE EMP01
SET DEPTNO=30
WHERE DEPTNO=10
;

--급여가 3000 이상인 사원만 급여를 10% 인상
UPDATE EMP01
SET SAL = SAL*0.1
WHERE SAL >= 3000
;

--83년에 입사한 사원의 입사일을 오늘로 수정
UPDATE EMP01
SET HIREDATE = SYSDATE
WHERE SUBSTR(HIREDATE,1,2)='83'
;
ROLLBACK;





--(한개의 행만 수정) 

--SCOTT 사원의 부서번호는 30번으로, 직급은 MANAGER로 한꺼번에 수정 
UPDATE EMP01
SET DEPTNO=30, JOB = 'MANAGER'
WHERE ENAME = 'SCOTT'
;
SELECT *FROM EMP01;

-- SCOTT사원의 입사일자를 오늘로 하고 급여를 50, 커미션을 4000으로 수정
UPDATE EMP01
SET HIREDATE=SYSDATE, SAL=50, COMM=4000
WHERE ENAME='SCOTT'
;

--서브쿼리로 UPDATE 하기
--20번 부서의 지역명을 40번 부서의 지역명으로 수정
DROP TABLE DEPT03;
CREATE TABLE DEPT03 AS SELECT *FROM DEPT;
SELECT*FROM DEPT;
SELECT*FROM DEPT03;

UPDATE DEPT03
SET LOC=(SELECT LOC FROM DEPT03 WHERE DEPTNO=40)
WHERE DEPTNO=20
;

--(다중행 수정) - 서브쿼리 사용
-- 부서번호가 20번인 부서의 부서명과 지역명을 부서번호가 10번 부서와 동일하게 수정
SELECT * FROM DEPT03 WHERE DEPTNO=10 OR DEPTNO=20;

UPDATE DEPT03
SET (DNAME, LOC) = (SELECT DNAME, LOC FROM DEPT03 WHERE DEPTNO=10)
WHERE DEPTNO=20
;


-- DELETE 
-- 데이터의 삭제 : 행 단위
-- DELETE FROM 테이블 이름 WHERE 조건

-- DEPT03 테이블의 모든 데이터를 삭제하기
DELETE FROM DEPT03;
SELECT *FROM DEPT03;

--이름이 SCOTT인 사원을 삭제 (퇴사 처리)
DELETE FROM EMP01 WHERE ENAME = 'SCOTT';

--사원 테이블에서 부서명이 SALES 인 사원을 모두 삭제
SELECT *FROM EMP01;

DELETE FROM EMP01 
WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME = 'SALES')
;
