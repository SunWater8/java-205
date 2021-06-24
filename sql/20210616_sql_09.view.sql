--2021.06.16

-- 자주 사용되는
--30번 부서에 소속된 사원들의 사번과 이름과 부서번호를 출력하기 위한 
--select 문을 하나의 뷰로 정의해 봅시다.
create or replace view emp_view30
as
select empno, ename, deptno
from emp
where deptno=30
;
select * from emp_view30
where ename = 'JAMES'
;

--뷰 삭제
DROP VIEW EMP_VIEW30;

--인라인 뷰를 이용한 TOP3 구하기 (한 페이지에 게시물 제목을 3개만 표시하고 싶을 때 활용 됨)
--ROWNUM의 사용
SELECT ROWNUM, ENAME  -- ROWNUM 의 기본 정렬 순서는 입력 순서
FROM EMP
;
SELECT ROWNUM, ENAME   
FROM (SELECT * FROM EMP ORDER BY ENAME)-- 이름 순으로 ROWNUM 의 숫자가 바뀌어짐.
;
--입사일이 빠른 사람 TOP5 RNGKRL
SELECT ROWNUM, ENAME , HIREDATE 
FROM (SELECT * FROM EMP ORDER BY HIREDATE)
--FROM (SELECT * FROM EMP ORDER BY HIREDATE DESC) -- 가장 최근에 입사한 TOP5 구하는 문장
--WHERE ROWNUM BETWEEN 1 AND 5 --아래 문장과 같음.
WHERE ROWNUM <6
;

select * from sale;

--입사일이 빠른 순으로 정리한 뷰 만들기
SELECT * FROM EMP ORDER BY HIREDATE;

CREATE OR REPLACE VIEW VIEW_HIRE
AS SELECT * FROM EMP ORDER BY HIREDATE;

SELECT ROWNUM, ENAME, HIREDATE FROM view_hire;

--입사일 빠른 사람 구하기.
SELECT ROWNUM, ENAME, HIREDATE 
FROM view_hire
WHERE ROWNUM <6
;

--TOP5 중에서 다시 정렬하고자 하면 ORDER BY 사용하면 됨.(순위가 별로 중요하지 않을 때)
SELECT ROWNUM, ENAME, HIREDATE 
FROM view_hire
WHERE ROWNUM <6
ORDER BY ENAME
;

