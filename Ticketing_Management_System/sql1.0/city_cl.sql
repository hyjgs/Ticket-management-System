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