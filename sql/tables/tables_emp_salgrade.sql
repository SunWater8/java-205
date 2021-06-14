--2021.06.14
--salgrade table



CREATE TABLE SALGRADE
(GRADE NUMBER,
LOSAL NUMBER,
HISAL NUMBER);

--트랜젝션이 시작
INSERT INTO SALGRADE VALUES (1, 700, 1200);
INSERT INTO SALGRADE VALUES (2, 1201, 1400);
INSERT INTO SALGRADE VALUES (3, 1401, 2000);
INSERT INTO SALGRADE VALUES (4, 2001, 3000);
INSERT INTO SALGRADE VALUES (5, 3001, 9999);

-- 아직도 논리적인 저장만 진행
commit; -- 물리적인 저장
-- 커밋이 아닌 rollback 이라면 트랜젝션이 시작되기 전의 위치로 돌아간다.