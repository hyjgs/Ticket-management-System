会员表（membership）
create table membership(
memb_id number(4),
memb_card_num varchar(20) not null,
memb_password varchar(20) not null,
memb_lastname_ch varchar(20) not null,
memb_firstname_ch varchar(20) not null,
memb_lastname_sp varchar(20) not null,
memb_firstname_sp varchar(20) not null,
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
memb_account_mileage number,
memb_available_stage number,
memb_available_mileage number(9,2)
);

alter table membership 
add constraint memship_id_PK primary key(memb_id);
alter table membership
add constraint memship_card_num_UN unique(memb_card_num);
alter table membership
add constraint memship_gender_CK check(memb_gender in ('F','M','f','m'));

select constraint_name,constraint_type from user_constraints where table_name = 'MEMBER_FLIGHT_RECODER';


会员航程表(member_flight_recoder)
create table member_flight_recoder(
sta_id number(15),
meb_id number(10),
sta_from_airport varchar(40),
sta_to_airport varchar(40),
sta_from_date Date,
sta_flight_num varchar(8),
sta_cabin_class varchar(5),
sta_account_mileage number(9,2) not null
);
alter table member_flight_recoder
add constraint mem_fli_red_sta_id_PK primary key(sta_id);
alter table member_flight_recoder
add constraint mem_fli_red_meb_id_fk foreign key(meb_id)
references membership(memb_id) on delete set null;

营业记录表（business_record）
create table business_record(
buss_red_id number,
buss_red_date date not null,
user_id number,
branch_id number,
buss_red_price number not null,
buss_red_account_state varchar(10)
);
alter table business_record
add constraint buss_red_id_PK primary key (buss_red_id);
alter table business_record
add constraint buss_red_user_id_FK foreign key(user_id)
references users(user_id) on delete set null;
alter table business_record
add constraint buss_red_brance_id_FK foreign key(branch_id) references branch(branch_id) on delete set null;
