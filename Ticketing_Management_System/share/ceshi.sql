select e.route_id,e.route_distance from route_cl e join airport_cl a 
on  e.from_airport_id =a.airport_id 
where e.from_airport_id  in (select k.airport_id from airport_cl k join city_cl f 
		on k.city_id = f.city_id where city_name = '北京') 
and e.to_airport_id in  (select i.airport_id from airport_cl i join city_cl o 
		on i.city_id = o.city_id where city_name = '上海');
		
		select e.city_name from city_cl e join airport_cl d on e.city_id = d.city_id 
		where d.airport_id = (select to_airport_id from route_cl where route_id = 100001);
		
 select * from flight_cl where route_id in
 (select e.route_id from route_cl e join airport_cl a 
on  e.from_airport_id =a.airport_id 
where e.from_airport_id  in (select k.airport_id from airport_cl k join city_cl f 
		on k.city_id = f.city_id where city_name = '北京') 
and e.to_airport_id in  (select i.airport_id from airport_cl i join city_cl o 
		on i.city_id = o.city_id where city_name = '杭州'));
		
	select * from flight_cl where route_id in (select route_id from route_cl where 
	from_airport_id =(select airport_id from airport_cl
	where airport_full_name = '首都机场') and to_airport_id = (select airport_id from airport_cl
	where airport_full_name = '虹桥机场'));
	
	select * from route_cl;
	select route_base_price from route_cl where route_id =100007;