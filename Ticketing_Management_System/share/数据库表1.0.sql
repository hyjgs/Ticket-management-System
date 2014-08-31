--建表,除了非空以外的约束,全部放在建表后再建--省份表--城市表--网点表--会员表--机场表--航线表-舱位等级表--飞机表
--航班计划表--航班表--会员航程表--订单表--订单项表

--省份表（Province）
Create table province_cl(
province_id number(2),
province_name varchar(32) constraint province_pn_nn not null,
province_simple_name varchar(20) constraint province_psimn_nn not null,
province_spell_name varchar(20)constraint province_psn_nn not null
) ;
alter table province_cl add 
constraint province_pid_pk primary key(province_id);
commit;

--城市表（City）
Create table city_cl(
city_id number(2),
city_name varchar(20) constraint city_cn_nn not null,
province_id number(2) constraint city_pi_nn not null,
city_spell_name varchar(20)  constraint city_csn_nn not null
);
alter table city_cl add 
constraint city_cid_pk primary key(city_id);

alter table city_cl add 
constraint city_pid_fk foreign key(province_id) 
references province_cl(province_id) on delete set null;

commit;

--网点表（Branch）
Create table branch_cl(
branch_id number(4),
branch_name varchar(256)not null,
province_id number not null,
city_id number not null,
branch_telephone1  varchar(20) constraint branch_bt_nn not null,
branch_telephone2 varchar(20), 
branch_fax varchar(20), 
branch_address varchar(30) ,
branch_zip varchar(20), 
branch_type char(1),
branch_state char(1)
);
alter table branch_cl add 
constraint branch_id_pk primary key(branch_id);

alter table branch_cl add 
constraint branch_pid_fk foreign key(province_id) 
references province_cl(province_id) on delete set null;

alter table branch_cl add 
constraint branch_city_fk foreign key(city_id) 
references city_cl(city_id) on delete set null;
commit;

--用户表
create table user_cl(
user_id number(5),
user_login_name varchar(32) not null,
user_password char(32) not null,
user_name varchar(40) not null,
user_telephone varchar(20),
user_certif_type varchar(20),
user_certif_num varchar(20),
user_email varchar(50),
role_id number,
branch_id number
);
alter table user_cl add 
constraint user_id_pk primary key (user_id);

alter table user_cl add 
constraint user_lg_uk unique(user_login_name);

alter table user_cl add 
constraint user_n_uk unique(user_name);

alter table user_cl add 
constraint role_id_fk foreign key(role_id) 
references role_cl(role_id) on delete set null;

commit;

--角色表
create table role_cl(
role_id number role_id_pk primary key,
role_name varchar(20) not null,
role_privilege number not null
)
commit;

--会员表
create table membership_cl(
memb_id number(4),
memb_card_num varchar(20) not null,
memb_password varchar(20) not null,
memb_name_ch varchar(20) not null,
memb_name_sp varchar(20) not null,
memb_gender char(1),
memb_birthday date,
memb_certif_type varchar(20) not null,
memb_certif_num varchar(30) not null,
memb_tel_num1 varchar(20) not null,
memb_tel_num2 varchar(20),
memb_address varchar(100),
memb_zip varchar(20),
memb_reg_date date not null,
memb_email varchar(50),
memb_rank varchar(10) not null,
memb_account_stage number,
memb_account_mileage number
);

alter table membership_cl 
add constraint memship_id_PK primary key(memb_id);

alter table membership_cl 
add constraint memship_card_num_UN unique(memb_card_num);

alter table membership_cl 
add constraint memship_gender_CK check(memb_gender in ('F','M','f','m'));
commit;

--乘客表
create table passenger_cl(
psg_id number(5),
psg _name varchar(40) not null,
psg_certif_type varchar(20) not null,
psg_ certif_num varchar(40) not null,
psg_telephone varchar(20),
psg_email varchar(40),
psg_type char(1) check(psg_type in('A','a','C'.'c'.'I','i'),
ref_memb_id number,
);
alter table passenger_cl 
add constraint psg_id_pk primary key(psg_id);

alter table passenger_cl 
add constraint psg_certif_type_UN unique(psg_certif_type);

alter table passenger_cl 
add constraint psg_ certif_num_UN unique(psg_ certif_num);

alter table passenger_cl add 
constraint ref_memb_id_fk foreign key(ref_memb_id) 
references membership_cl(memb_id) on delete set null;

alter table passenger_cl add 
constraint ref_user_id_fk foreign key(ref_user_id) 
references users_cl(user_id) on delete set null;
commit;

--机场表
create table airport_cl(
airport_id number(4),
airport_name varchar(20),
province_id number(2),
city_id	number(2),
airport_full_name varchar(20),
airport_code varchar(3)	not null,
departure_routes_num number,
arrival_routes_num number,
airport_grand varchar(2),
departure_flight_num_pre_week number,
arrival_flight_num_pre_week number
);
alter table airport_cl add 
constraint airport_airport_id_pk primary key(airport_id);

alter table airport_cl add 
constraint airport_province_id_fk foreign key(province_id) 
references province_cl(province_id);

alter table airport_cl add 
constraint airport_city_id_fk foreign_key(city_id) 
references city_cl(city_id);

alter table airport_cl add 
constraint airport_airport_code_uk unique(airport_code);
commit;

--航线表（Route）
create table route_cl(
route_id number(10),
from_airport_id number(4) not null,
to_airport_id	number(4) not null,
route_distance number,
route_base_price number(9,2),
flight_num_pre_week number
);
alter table route_cl add 
constraint route_route_id_pk primary key(route_id);

alter table route_cl add 
constraint route_from_airport_id_fk foreign key(from_airport_id) 
references airport_cl(airport_id);

alter table route_cl add 
constraint route_to_airport_id_fk foreign key(to_airport_id) 
references airport_cl(airport_id);
commit;

--舱位等级表
create table CabinClass_cl( 
cabin_class_id number, 
cabin_class_name varchar2(20), 
cabin_class_char char(1) not null, 
refund_charge  number(9,2), 
limit_condition char(3), 
cabin_discount number(9,2), 
plane_cabin_type char(1), 
mileage_factor number(9,2) 
); 
alter table CabinClass_cl add 
constraint CabinClass_id_PK primary key(cabin_class_id); 
alter table CabinClass_cl add 
constraint CabinClass_char_UN unique(cabin_class_char); alter table CabinClass_cl add constraint CabinCP_ca_type_CK check(plane_cabin_type in('F','f','C','c','Y','y')); 
commit;

--飞机表
create table plane_cl(
plane_id number(10),
plane_num number not null,
plane_model varchar(40) not null,
plane_manufacturer varchar(40),
max_continue_voyage number,
f_cabin_seats number,
c_cabin_seats number,
y_cabin_seats number
);
alter table plane_cl add 
constraint plane_plane_id_pk primary key(plane_id);

alter table plane_cl add 
constraint plane_plane_num_uk unique(plane_num);

alter table plane_cl add 
constraint plane_plane_model_uk unique(plane_model);
commit;

--航班计划表(airplan)
create table airplan_cl(
fp_id number(10),
flight_num varchar(8),
fp_start_date date not null,
fp_end_date date not null,
route_id number,
fp_departure_date date,
fp_arrival_date date,
fp_scheduler number,
fp_base_price number(9,2)
);
alter table airplan_cl add
constraint airplan_fp_id_pk primary key(fp_id);

alter table airplan_cl add
constraint airplan_flight_num_uk unique;

alter table airplan_cl add
constraint airplan_route_id_fk foreign	key(route_id) 
references route_cl(route_id);
commit;

--航班表
Create table flight_cl(
flight_id number,
flight_num char(8) constraint flight_num_nn not null,
flight_departu_date date not null,
flight_arrival_date date not null,
route_id number not null,
plane_id number not null,
f_seats_remain number,
b_seats_remain number,
e_seats_remian  number,
lowest_discount_price number(9,2)
  );
alter table flight_cl add 
constraint flight_id_pk primary key(flight_id);

alter table flight_cl add 
constraint flight_num_uk unique(flight_num);

alter table flight_cl add 
constraint flight_pid_fk foreign key(plane_id) 
references plane_cl(plane_id);

alter table flight_cl add 
constraint flight_rid_fk foreign key(route_id) 
references route_cl(route_id);

commit;

--会员航程表(member_flight_recoder_cl )
create table member_flight_recoder_cl (
sta_id number(15),
meb_id number(10),
sta_from_airport varchar(40),
sta_to_airport varchar(40),
sta_from_date Date,
sta_flight_num varchar(8),
sta_cabin_class varchar(5),
sta_account_mileage number(9,2) 
);
alter table member_flight_recoder_cl add 
constraint mem_fli_red_sta_id_PK primary key(sta_id);

alter table member_flight_recoder_cl add 
constraint mem_fli_red_meb_id_fk foreign key(meb_id)
references membership_cl(memb_id) on delete set null;
commit;

--订单表
create table Order_cl(
Order_id number,
User_id number not null,
Ord_money number(9,2),
Order_items varchar2(30),
Order_Date Date,
Order_states varchar2(20)
);
alter table order_cl add 
constraint Order_id_PK primary key(Order_id);


commit;

--订单项表(Order_Item)
create table Order_Item_cl( 
Order_item_id number, 
fligh_id number not null, 
passenger_id number not null, Ord_cabin_class char(1),
Discount number(9,2), 
Ticket_price number(9,2), 
Append_Tax number(9,2), 
Order_id number 
); 
alter table Order_Item_cl add 
constraint Order_Item_id_PK primary key(Order_item_id); alter table Order_Item_cl add constraint Order_Item_cl_CK check(Ord_cabin_class in('F','f','C','c','Y','y')); 
alter table Order_Item_cl add 
constraint Order_Item_Order_id_FK foreign key(Order_id)
references order_cl(order_id); 
commit;

--营业记录表（business_record） 
create table business_record_cl( 
buss_red_id number, 
buss_red_date date not null, 
user_id number, 
branch_id number, 
buss_red_price number not null, 
buss_red_account_state varchar(10), buss_type varchar(10)
); 
alter table business_record_cl
add constraint buss_red_id_PK primary key (buss_red_id); 

alter table business_record_cl
add constraint buss_red_user_id_FK foreign key(user_id) 
references user_cl(user_id) on delete set null; 

alter table business_record_cl
add constraint buss_red_brance_id_FK foreign key(branch_id) 
references branch_cl(branch_id) on delete set null; 
commit;

--机票表
create table Tickets_cl( 
ticket_id number, 
psg_id  number not null, 
psg_name varchar2(40) not null, 
flight_num number not null, 
sta_from_airport varchar2(40) not null, 
end_from_airport varchar2(40) not null, 
sta_fly_date Date not null, 
seat_number  number not null, 
ticket_price number(9,2) not null,cabin_class_id number not null
); 
alter table Tickets_cl add 
constraint Ticket_id_PK primary key(ticket_id); alter table Tickets_cl addconstraint tickets_cl_psg_id_FK foreign key(psg_id)references passenger_cl(psg_id);alter table Tickets_cl addconstraint tic_cabin_class_id_FK foreign key(cabin_class_id)references CabinClass_cl(cabin_class_id);
commit;
