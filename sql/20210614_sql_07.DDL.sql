--2021.06.15
--DDL : 데이터 정의

--테이블 생성 : create table
--테이블 수정 : alter table
--테이블 삭제 : drop table


--  테이블 생성해보기

-- create table (
--    컬럼 이름 타입(사이즈) 제약조건 정의,
--    .....
--)

-- create table (
--    컬럼 이름 타입(사이즈) ,    --컬럼 타입 정의
--    .....,
--    제약조건 정의,             -- 제약조건 정의  
--    ......,
--)


--사원 테이블과 유사한 구조의 
--사원번호, 사원이름, 급여 3개의 칼럼으로 구성된 
--EMP01 테이블을 생성해 봅시다. 

create table emp01 (
    empno number(4),     -- 사원번호
    ename varchar2(20),  -- 사원이름
    sal number(6,2)      -- 급여
);

--서브 쿼리를 이용해서 기존 테이블의 구조를 복사하고 해당 튜플도 복사
-- 내용은 다 복사되어 가져오지만 제약조건은 가져오지 않는다. ALTER TABLE로 제약조건을 줄 수 있다. 이런 식의 복사는 별도로 백업하고 싶을 떄 사용되는 복사 방법이다.
--서브 쿼리로 EMP 테이블을 복사하여 EMP02 테이블 생성해보기 - 전체복사
CREATE TABLE EMP02
AS
SELECT * FROM EMP;

--원하는 컬럼으로 구성된 복제 테이블 생성하기 -일부복사
CREATE TABLE EMP03
AS
SELECT EMPNO, ENAME FROM EMP;


CREATE TABLE EMP04
AS
SELECT * FROM EMP WHERE DEPTNO=30
;
-- 데이터 없어 구조만 복사해오기
-- COPY ONLY THE STRUCTURE OF THE TABLE.
CREATE TABLE EMP05
AS
SELECT *FROM EMP WHERE 1=2;




-- ALTER TABLE
-- 변경 : 칼럼 삭제, 칼럼 추가, 칼럼 수정

-- 테이블 변경 : ALTER TABLE
-- ALTER TABLE (테이블 이름) ADD
-- ALTER TABLE (테이블 이름} MODIFY
-- ALTER TABLE (테이블 이름} DROP


-- ADD TABLE
--EMP01 테이블에 JOB 컬럼을 추가해보자

ALTER TABLE EMP01
ADD(JOB VARCHAR2(9))
;

-- ALTER
--EMP01 테이블의 JOB 컬럼의 사이즈를 수정해보기 9 -> 30

ALTER TABLE  EMP01
MODIFY(JOB VARCHAR2(130) NOT NULL)
;

--DROP TABLE
-- EMP01 테이블의 JOB 컬럼을 삭제
ALTER TABLE EMP01
DROP COLUMN JOB
;
--테이블 삭제
DROP TABLE EMP05;


--TRUNCATE : 모든 행을 삭제. (롤백이 안된다. 복구할 수 없기 때문에 사용 시 주의해야 한다. )
--새로운 테이블, 데이터 생성
CREATE TABLE EMP02
AS
SELECT * FROM EMP
;

--TRUNCATE : 모든 행을 삭제 
TRUNCATE TABLE EMP02;

SELECT * FROM EMP02;

--테이블 이름 바꿔주기
RENAME EMP02 TO TEST;
DESC EMP02; --테이블이 삭제 되었기 때문에 객체가 존재하지 않느다고 나옴.


-- 제약조건 NOT NULL
DROP TABLE EMP02;

--테이블 복사 및 생성
CREATE TABLE EMP02
AS
SELECT EMPNO, ENAME, SAL, JOB FROM EMP WHERE 1=0 -- WHERE 1=0 은 '참'이 아닌 것을 의미한다.
;

DESC EMP;  -- 잘 만들었는지 확인해보기

--행 삽입하기
INSERT INTO EMP02(EMPNO, ENAME, SAL, JOB) 
    VALUES(100, 'SQL', 1000, 'MANAGER');

CREATE TABLE EMP02(
    EMPNO NUMBER(4) NOT NULL,
    ENAME VARCHAR2(20) NOT NULL,
    SAL NUMBER(6,2),
    JOB VARCHAR(20)
);

DESC EMP02;
SELECT * FROM EMP02;


--EMP02 테이블 삭제하고 UNIQUE 넣어서 다시 생성
--UNIQUE 제약으로 인해서 중복된 데이터가 들어가지 못한다.
CREATE TABLE EMP02(
    EMPNO NUMBER(4) NOT NULL UNIQUE,
    ENAME VARCHAR2(20) NOT NULL,
    SAL NUMBER(6,2),
    JOB VARCHAR(20)
);

-- EMP02 테이블 다시 삭제하여서 다음과 같이 다시 생성 - PRIMARY KEY 지정
CREATE TABLE EMP02(
    EMPNO NUMBER(4)  PRIMARY KEY,
    ENAME VARCHAR2(20) NOT NULL,
    SAL NUMBER(6,2),
    JOB VARCHAR(20)
);
--PRIMARY 키가 지정되도록 하였기 때문에 중복된 내용의 기본키는 입력되지 못한다.
SELECT * FROM EMP02;

-- EMP02 테이블 삭제하고 다음과 같이 다시 생성 - CHECK 에 SAL>500 이하의 내용 넣기
CREATE TABLE EMP02(
    EMPNO NUMBER(4) PRIMARY KEY,
    ENAME VARCHAR2(20) NOT NULL,
    SAL NUMBER(6,2)CHECK (SAL>500 AND SLA<5000),
    JOB VARCHAR(20) 
);

--DEFAULT 초기화
CREATE TABLE EMP02(
    EMPNO NUMBER(4) PRIMARY KEY,
    ENAME VARCHAR2(20) NOT NULL,
    SAL NUMBER(6,2) CHECK (SAL>500 AND SLA<5000),
    JOB VARCHAR(20) DEFAULT '미지정'
);

--새 컬럼 추가해서 테이블 만들기
DROP TABLE EMP02;
CREATE TABLE EMP02(
    EMPNO NUMBER(4) PRIMARY KEY,
    ENAME VARCHAR2(20) NOT NULL,
    SAL NUMBER(6,2) CHECK (SAL>500 AND SAL<5000),
    JOB VARCHAR(20) DEFAULT '미지정',
    DEPTNO NUMBER(2) REFERENCES DEPT(DEPTNO) -- DEPT 테이블의 PK를 참조하기
);

-- DEPTNO 중에서 '50'인 행이 없기 때문에 오류가 나옴.
INSERT INTO EMP02(EMPNO, ENAME, SAL, JOB, DEPTNO) 
    VALUES(2000, 'SQL', 3000, 'MANAGER',50);


--컬럼 레벨로 제약 조건명 명시하기
DROP TABLE EMP02;

CREATE TABLE EMP02(
    EMPNO NUMBER(4) CONSTRAINT EMP02_EMPNO_PK PRIMARY KEY,
    ENAME VARCHAR2(20)CONSTRAINT EMP02_ENAME_NN NOT NULL,
    SAL NUMBER(6,2) CONSTRAINT EMP02_SAL_CK CHECK (SAL>500 AND SAL<5000),
    JOB VARCHAR(20) DEFAULT '미지정',
    DEPTNO NUMBER(2) CONSTRAINT EMP02_DEPTNO_FK REFERENCES DEPT(DEPTNO)
);

INSERT INTO EMP02(EMPNO, ENAME, SAL, JOB, DEPTNO) 
    VALUES(2000, 'SQL', 4000, 'MANAGER',40);


--위의 테이블 생성에서는 컬럼 레벨에서 제약 사항 정의

--다음의 테이블 생성에서는 테이블 레벨에서 제약 사항 정의
CREATE TABLE EMP03(
    EMPNO NUMBER(4),
    ENAME VARCHAR2(20)CONSTRAINT EMP03_ENAME_NN NOT NULL,  -- NULL 제약은 컬럼 레벨에서만 정의
    SAL NUMBER(6,2) CONSTRAINT EMP03_SAL_CK CHECK (SAL>500 AND SAL<5000),
    JOB VARCHAR(20),
    DEPTNO NUMBER(2),
    --------------------------------------------------------------
    -- 제약 정의
    CONSTRAINT EMP03_EMPNO_PK PRIMARY KEY (EMPNO), --PK제약
    CONSTRAINT EMP03_DEPTNO FOREIGN KEY (DEPTNO) REFERENCES DEPT(DEPTNO)
);
