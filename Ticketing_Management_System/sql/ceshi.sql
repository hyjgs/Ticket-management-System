 create sequence route_id start with 100007; 
 --select * from flight_cl;
rollback;
 --alter table flight_cl add constraint flight_cl_num_un unique(flight_num);
 select * from user_cl;
 --select * from flight_plan_cl;
 --select * from route_cl;
 --alter table flight_plan_cl add constraint flight_plan_cl_num_fk foreign key(flight_num) references flight_cl(flight_num);
 select * from flight_cl;
 --select * from airport_cl;
 --select * from plane_cl;
 --select constraint_name,constraint_type from user_constraints where table_name = 'FLIGHT_PLAN_CL';
 --select constraint_name,constraint_type from user_constraints where table_name = 'ROUTE_CL';
   select * from city_cl;
 select from_airport_id,to_airport_id from route_cl;
 select flight_num,* from flight_plan_cl where flight_num = 'TL1401';

 select city_name from city_cl e join airport_cl d on e.city_id = d.city_id
 where d.airport_id = (select to_airport_id from route_cl where route_id = 100006);
 
 
 select e.city_name from city_cl e join airport_cl d on e.city_id = d.city_id
  where d.airport_id = (select from_airport_id from route_cl where route_id = 100006);
 select e.city_name from city_cl e join airport_cl d on e.city_id = d.city_id where d.airport_id = (select from_airport_id from route_cl where route_id =100006);

 select plane_id from plane_cl where plane_model = 'boeing777';
 
 alter table mylog_cl modify(what varchar(100));
 
 insert into mylog_cl values(log_cl.nextval,user,sysdate,'sql1');
 select * from mylog_cl;
 delete mylog_cl;
 
 insert into mylog_cl values(log_cl.nextval, user, sysdate , '+sql1+');
 
 
 
 update flight_cl set Flight_departu_date =Wed Mar 05 00:00:00 CST 2014, 
 set Flight_arrival_date = Wed Mar 05 00:00:00 CST 2014, 
 set Route_id = 100001, 
 set Plane _id = 1001203161, 
 set Lowest_discount_price = 960, 
 set f_seats_remain = 32, 
 set b_seats_remain =25, 
 set e_seats_remain =225
 where flight_num = 'TL1202';
 
 update flight_cl 
 set flight_departu_date =to_date('2014-3-5','yyyy-mm-dd'),
 flight_arrival_date = to_date('2014-3-5','yyyy-mm-dd'),
  route_id = 100003, 
  plane_id = 1001203161,
  lowest_discount_price = 950,
  f_seats_remain = 32, 
  b_seats_remain =25,
  e_seats_remian =225
 where flight_num ='TL1202';
 
 update flight_cl set flight_departu_date =Wed Mar 05 00:00:00 CST 2014,
  flight_arrival_date = Wed Mar 05 00:00:00 CST 2014, 
  route_id = 100001,  
  plane_id = 1001203159,
  lowest_discount_price = 900, 
  f_seats_remain = 12, 
  b_seats_remain =5, 
  e_seats_remian =125 
  where flight_num ='TL1202';
  
  update flight_cl
   set flight_departu_date =to_date('Mon Jun 23 00:00:00 CST 2014','yyyy-MM-dd'), 
   flight_arrival_date = to_date('2014-00-23','yyyy-MM-dd'),
    route_id = 100005,  plane_id = 1001203162,
    lowest_discount_price = 960, 
    f_seats_remain = 56, 
    b_seats_remain =35, 
    e_seats_remian =125 where flight_num ='TL1204'
    
    select * from mylog_cl;
    
    select * from flight_plan_cl;
    alter table flight_plan_cl drop column plane_id;
    update flight_plan_cl set route_id = 100001 where flight_num='TL1202';   
 update flight_plan_cl set fp_start_date= to_date('2014-08-21','yyyy-mm-dd'), 
  fp_end_date=to_date('2014-08-21','yyyy-mm-dd'), 
  route_id=100001, 
  fp_departure_Date=to_date('12:20:12','hh24:mi:ss'),
  fp_arrival_Date=to_date('14:20:02','hh24:mi:ss'), 
  fp_scheduler=12, 
  fp_season_discount=0.45,
  fp_base_price = 1350 
  where flight_num='TL1202';
  
 select * from flight_cl;
  select * from route_cl;
  
  insert into flight_cl values(gg.nextval, to_date('2014-08-08','yyyy-mm-dd'), 
  to_date('2014-08-08','yyyy-mm-dd'), 100005, 1001203167,16, 50,125,632.0);
  
  
  insert into flight_cl values(gg.nextval, to_date('2014-09-09','yyyy-mm-dd'), 
  to_date('2014-09-09','yyyy-mm-dd'), 100006, 1001203166,10, 0,60,46.0) 

  insert into flight_cl values(gg.nextval,TL41564,to_date('2014-09-09','yyyy-mm-dd'), 
  to_date('2014-09-09','yyyy-mm-dd'), 100004, 1001203166,10, 0,60,2365.0)
  
  update plane_cl set c_cabin_seats = 10 ,y_cabin_seats = 40 where plane_num = 1000000007; 