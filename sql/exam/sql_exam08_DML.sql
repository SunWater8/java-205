--2021.06.16

--CRUD
--CREATE : INSERT
--READ   : SELECT
--UPDATE : UPDATE
--DELETE : DELETE

-- PHONE 테이블을 바탕으로 SELECT, UPDATE, DELETE, INSERT 하는 SQL

SELECT * FROM phoneinfo_basic;
SELECT * FROM phoneinfo_univ;
SELECT * FROM phoneinfo_com;

--phoneinfo_basic (INSERT : CREATE)
DESC phoneinfo_basic;
INSERT INTO phoneinfo_basic
VALUES (1, 'BILL', '010-2659-4916', 'BILL99@GMAIL.COM', 'BRISTOL', SYSDATE)
;
INSERT INTO phoneinfo_basic
VALUES (2, 'ELY', '010-8878-6523', 'ELYFLY@GMAIL.COM', 'LONDON', SYSDATE)
;
  
INSERT INTO phoneinfo_basic
VALUES (3, 'SUSAN', '010-7884-9652', 'SUSU@NAVER.COM', 'BRIGHTON', SYSDATE)
;  
INSERT INTO phoneinfo_basic
VALUES (4, 'JULIE', '010-4569-1234', 'SEPTEM@HANMAIL.COM', NULL, NULL)
;
INSERT INTO phoneinfo_basic (IDX, FR_NAME, FR_PHONENUMBER)
VALUES (5, 'JESI', '010-5645-2312')
;

--phoneinfo_basic (UPDATE : UPDATE)
UPDATE phoneinfo_basic 
SET FR_ADDRESS = 'WELLS'
WHERE IDX=4   --PRIMARY KEY를 기준으로 하는 것이 좋다. 이름을 기준으로 한다면 이름이 중복될 수 있기 때문에 문제가 생길 수 있다.
;
SELECT *FROM phoneinfo_basic ;

--phoneinfo_basic (DELETE : DELETE)
DELETE FROM phoneinfo_basic WHERE IDX=1;




--phoneinfo_univ (INSERT)
--1. phoneinfo_basic 정보 입력
INSERT INTO phoneinfo_basic
VALUES (3, 'SUSAN', '010-7884-9652', 'SUSU@NAVER.COM', 'BRIGHTON', SYSDATE)
;
--2. phoneinfo_univ 정보 입력
INSERT INTO phoneinfo_univ
VALUES (1, 'SPANISH', 3, 4)
;
INSERT INTO phoneinfo_univ
VALUES (2, 'CHEMISTRY', 2,2)
;
 
--phoneinfo_univ (select : read 데이터 검색)
select *
from phoneinfo_basic pb, phoneinfo_univ pu
where pb.idx= pu.fr_ref;

--phoneinfo_univ (UPDATE : UPDATE 데이터 수정)
--전공과 학년을 수정, IDX 또는 외래키
UPDATE phoneinfo_univ
SET fr_u_major='COMPUTER', fr_u_year=1
WHERE IDX=2
;
UPDATE phoneinfo_univ
SET FR_U_YEAR=3
WHERE FR_U_YEAR=2
;
SELECT * FROM phoneinfo_univ;
 
 
 
-- phoneinfo_com (INSERT)
INSERT INTO phoneinfo_com
VALUES (1, 'LG ELC', 1)
;
INSERT INTO phoneinfo_com
VALUES (2, 'NHS', 3)
;

-- phoneinfo_com (SELECT : READ)
SELECT *
FROM phoneinfo_basic PB, phoneinfo_com PC
WHERE PB.IDX = PC.FR_REF
;

--UPDATE phoneinfo_com (UPDATE)
UPDATE phoneinfo_com
SET FR_REF=1
WHERE IDX=1
;
SELECT * FROM phoneinfo_com;


--DELETE 자식부터 지워준다. 
DELETE ;

--전체 친구 정보
SELECT *
FROM phoneinfo_basic pb, phoneinfo_univ pu, phoneinfo_com pc
where pb.idx = pu.fr_ref(+) and  pb.idx = pc.fr_ref(+)
;