--20210614

--sub query

--스칼라 부속질의 : SELECT 절 부분
-- 단일 행, 단일 열 값이 사용된다.

--ORDERS 테이블의 CUSTID 에 맞춰서 CUSTOMER 의 고객 이름을 옆 칼럼에 대입하기. 고객번호와 고객 이름 출력하기
SELECT O.CUSTID, (SELECT C.NAME FROM CUSTOMER C WHERE O.CUSTID = C.CUSTID) AS NAME
FROM ORDERS O
;

-- 사원이 속한 부서의 이름을 출력하기 ( 사원 이름, 부서이름)
SELECT E.ENAME, (SELECT D.DNAME FROM DEPT D WHERE E.DEPTNO=D.DEPTNO)AS DNAME
FROM EMP E
;
--마당서점의 고객별 판매액을 출력(결과는 고객이름과 고객별 판매액을 출력)

--마당서점 관련 테이블들.
SELECT * FROM BOOK;
SELECT * FROM CUSTOMER;
SELECT * FROM ORDERS;

SELECT C.CUSTID, C.NAME, SUM(O.SALEPRICE) AS " 판매액"
FROM ORDERS O, CUSTOMER C
WHERE O.CUSTID=C.CUSTID
GROUP BY C.CUSTID, C.NAME
;
--스칼라 부속 질의 사용
SELECT (SELECT NAME 
        FROM CUSTOMER C 
        WHERE C.CUSTID = O.CUSTID
        ) "NAME", 
        SUM(SALEPRICE) "TOTAL"
FROM ORDERS O
GROUP BY CUSTID
;

--인라인 뷰
--고객번호가 2 이하인 고객의 판매액을 출력 (결과는 고객이름과 고객별 판매액 출력)
SELECT NAME, SUM(SALEPRICE)
FROM (SELECT * 
WHERE 
--중첩질의
-- 평균 급여보다 더 많은 급여를 받는 사원을 검색

--IN, NOT IN
--대한민국에 거주하는 고객에게 판매한 도서의 총 판매액을 구하시오.

--ALL, SOME, ANY
-- 3번 고객이 주문한 도서의 최고 금액보다 더 비싼 도서를 구입한 주문의 주문번호와 금액을 보이시오. 

--부서번호가 30번인 사원들의 급여 중 가장 작은 값(950)보다 많은 급여를 받는 사원의 이름, 급여를 출력
--30번 소속 사원들 중에서 급여를 가장 많이 받는 사원보다 더 많은 급여를 받는 사람의 이름, 급여를 출력

--EXISTS, NOT EXISTS 
--EXISTS 연산자로 대한민국에 거주하는 고객에게 판매한 도서의 총 판매액을 구하시오. 