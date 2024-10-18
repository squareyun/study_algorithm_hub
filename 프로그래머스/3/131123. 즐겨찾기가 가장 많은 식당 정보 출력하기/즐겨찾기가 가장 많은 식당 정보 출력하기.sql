select food_type, rest_id, rest_name, favorites
from rest_info r
where favorites = (
    select max(favorites)
    from rest_info
    where food_type = r.food_type
)
order by 1 desc;