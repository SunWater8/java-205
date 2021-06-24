-- 팔리는 수량 인기 순위
select distinct sname, count(sname) as count
from sale
group by sname
order by count desc 
;

-- rownum 활용하여 top 3 출력
select rownum, sname, count
from (select distinct sname, count(sname) as count
from sale
group by sname
order by count desc )
where rownum < 4;

--문제?? 동일한 개수일 때 

select * from sale;