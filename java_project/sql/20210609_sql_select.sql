--특정 데이터를 검색하기 위해서는 
--select ~ from ~구문에 where절을 이용한다.
-- where 뒤에는 조건식이 정의된다. - where 컬럼명 비교연산자 값
-- where sal >= 3000
SELECT *
FROM emp
WHERE sal >= 3000;

-- 전체 속성이 아닌 사원 이름, 사원 번호, 급여만 출력
SELECT ename, empno, sal
FROM emp
WHERE sal >= 3000;