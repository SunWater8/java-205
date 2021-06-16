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
