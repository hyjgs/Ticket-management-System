
 create sequence plan start with 201412600 increment by 1;
 select plan.nextval from dual;
  insert into flight_plan_cl(fp_id,flight_num,Fp_start_date,Fp_end_date
  ,Route_id,Fp_departure_Date,Fp_arrival_Date,fp_scheduler,fp_base_price,
  fp_season_discount,Plane_id) values(gg.nextval,'TL1203',to_date('2014-4-1','yyyy-mm-dd'),
  to_date('2014-7-1','yyyy-mm-dd'),100001,to_date('14:25','hh24:mi'),to_date('18:10','hh24:mi'),
  20,900,0.9,1001203159);
  --select plane_id from plane_cl;

 select * from flight_plan_cl;
 
 insert into flight_plan_cl(fp_id,flight_num,Fp_start_date,Fp_end_date
  ,Route_id,Fp_departure_Date,Fp_arrival_Date,fp_scheduler,fp_base_price,
  fp_season_discount,Plane_id) values(gg.nextval,'TL1204',to_date('2014-6-5','yyyy-mm-dd'),
  to_date('2014-8-17','yyyy-mm-dd'),100002,to_date('9:00','hh24:mi'),to_date('13:10','hh24:mi'),
 15,1350,0.85,1001203161);
   insert into flight_plan_cl(fp_id,flight_num,Fp_start_date,Fp_end_date
  ,Route_id,Fp_departure_Date,Fp_arrival_Date,fp_scheduler,fp_base_price,
  fp_season_discount,Plane_id) values(gg.nextval,'TL1401',to_date('2014-9-1','yyyy-mm-dd'),
  to_date('2014-12-10','yyyy-mm-dd'),100006,to_date('18:00','hh24:mi'),to_date('19:22','hh24:mi'),
  20,300,0.9,1001203163);
  
  --select * from route_cl;
insert into flight_plan_cl(fp_id,flight_num,Fp_start_date,Fp_end_date
  ,Route_id,Fp_departure_Date,Fp_arrival_Date,fp_scheduler,fp_base_price,
  fp_season_discount,Plane_id) values(gg.nextval,'TL1402',to_date('2014-9-1','yyyy-mm-dd'),
  to_date('2014-11-10','yyyy-mm-dd'),100003,to_date('14:06','hh24:mi'),to_date('18:22','hh24:mi'),
  3,1130,0.7,1001203164);
  
  update flight_plan_cl set fp_id = 201412584 where flight_num = 'TL1402';
  update flight_plan_cl set Plane_id =  1001203159 where flight_num = 'TL1204';