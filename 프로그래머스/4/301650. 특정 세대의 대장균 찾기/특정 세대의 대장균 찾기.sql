select c.id
from ecoli_data p
join ecoli_data s on p.id = s.parent_id
join ecoli_data c on s.id = c.parent_id
where p.parent_id is null
order by c.id;