  create sequence gg start with 100000;
  select gg.nextval from dual;
  insert into flight_cl(flight_id,flight_num,Flight_departu_date,Flight_arrival_date
  ,Route_id,F_seats_remain,B_seats_remain,E_seats_remian,Lowest_discount_price,
  Plane_id) values(gg.nextval,'TL1202',to_date('2014-3-5','yyyy-mm-dd'),
  to_date('2014-3-5','yyyy-mm-dd'),100001,12,5,125,960,1001203159);
 --drop sequence gg;
SELECT * FROM flight_cl;
  insert into flight_cl(flight_id,flight_num,Flight_departu_date,Flight_arrival_date
  ,Route_id,F_seats_remain,B_seats_remain,E_seats_remian,Lowest_discount_price,
  Plane_id) values(gg.nextval,'TL1203',to_date('2014-4-6','yyyy-mm-dd'),
  to_date('2014-4-6','yyyy-mm-dd'),100001,12,5,125,960,1001203159);
   
   insert into flight_cl(flight_id,flight_num,Flight_departu_date,Flight_arrival_date
  ,Route_id,F_seats_remain,B_seats_remain,E_seats_remian,Lowest_discount_price,
  Plane_id) values(gg.nextval,'TL1204',to_date('2014-6-23','yyyy-mm-dd'),
  to_date('2014-6-23','yyyy-mm-dd'),100001,12,5,125,960,1001203159);
  
    insert into flight_cl(flight_id,flight_num,Flight_departu_date,Flight_arrival_date
  ,Route_id,F_seats_remain,B_seats_remain,E_seats_remian,Lowest_discount_price,
  Plane_id) values(gg.nextval,'TL1401',to_date('2014-9-6','yyyy-mm-dd'),
  to_date('2014-9-6','yyyy-mm-dd'),100006,89,45,325,380,1001203163);
  
  
  insert into flight_cl(flight_id,flight_num,Flight_departu_date,Flight_arrival_date
  ,Route_id,F_seats_remain,B_seats_remain,E_seats_remian,Lowest_discount_price,
  Plane_id) values(gg.nextval,'TL1402',to_date('2014-9-29','yyyy-mm-dd'),
  to_date('2014-9-29','yyyy-mm-dd'),100003,23,15,225,941,1001203164);
  
  insert into flight_cl(flight_id,flight_num,Flight_departu_date,Flight_arrival_date
  ,Route_id,F_seats_remain,B_seats_remain,E_seats_remian,Lowest_discount_price,
  Plane_id) values(gg.nextval,'TL1202',to_date('2014-4-25','yyyy-mm-dd'),
  to_date('2014-4-25','yyyy-mm-dd'),100001,12,5,125,960,1001203159);
  
  insert into flight_cl(flight_id,flight_num,Flight_departu_date,Flight_arrival_date
  ,Route_id,F_seats_remain,B_seats_remain,E_seats_remian,Lowest_discount_price,
  Plane_id) values(gg.nextval,'TL1204',to_date('2014-4-6','yyyy-mm-dd'),
  to_date('2014-4-6','yyyy-mm-dd'),100002,32,25,225,1300,1001203161);
  
  insert into flight_cl(flight_id,flight_num,Flight_departu_date,Flight_arrival_date
  ,Route_id,F_seats_remain,B_seats_remain,E_seats_remian,Lowest_discount_price,
  Plane_id) values(gg.nextval,'TL1204',to_date('2014-4-6','yyyy-mm-dd'),
  to_date('2014-4-6','yyyy-mm-dd'),100002,32,25,225,1300,1001203161);
  

 