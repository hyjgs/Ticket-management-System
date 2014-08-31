--alter table role_cl add(temp_privilege number(1));
--alter table role_cl modify(role_privilege number(1));

--alter table flight_plan_cl add constraint Flight_Plan_cl_plane_id_fk 
-- foreign key(plane_id) references plane_cl(plane_id);

--alter table order_item_cl add constraint orderitemcl_order_belong_fk 
--  foreign key(order_id) references order_cl(order_id);
--alter table role_cl drop column temp_privilege;
<<<<<<< .mine
--alter table USER_cl add(temp_privilege number(1));


create or replace view p_and_c_cl
as
select province_name,city_name,b.province_id,city_id from province_cl  b join city_cl u on b.province_id = u.province_id;

select * from p_and_c_cl;=======
<<<<<<< .mine
--alter table USER_cl add(temp_privilege number(1));

--select constraint_name,constraint_type from user_constraints
--where table_name = 'USER_CL';
--根据 （营业员编号）查询（经理编号）
select user_id,user_name from user_cl where user_id = 10003;

select branch_name,branch_telephone1 from branch_cl
where branch_id = (select branch_id from user_cl where user_id = 10003);

select city_name from city_cl
where city_id = (select city_id from branch_cl
where branch_id = (select branch_id from user_cl where user_id = 10003));

select province_name from province_cl
where province_id =(select province_id from branch_cl
where branch_id = (select branch_id from user_cl where user_id = 10003));

select user_id from user_cl
where role_id = 2 
and branch_id = (select branch_id from user_cl
where user_id = 10003);

=======
--alter table USER_cl add(temp_privilege number(1));


 
 --select * from route_cl;
 --delete route_cl;
-- select * from airport_cl;

select * from plane_cl;

--alter table flight_cl drop constraint FLIGHT_NUM_UK ;

DELETE flight_cl where flight_id between 100008 and 100011;
>>>>>>> .r70
>>>>>>> .r71


create or replace view p_and_c_cl
as
select province_name,city_name,b.province_id,city_id from province_cl  b join city_cl u on b.province_id = u.province_id;

select * from p_and_c_cl;