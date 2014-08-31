alter table branch_cl add 
constraint branch_id_pk primary key(branch_id);

alter table branch_cl add 
constraint branch_pid_fk foreign key(province_id) 
references province_cl( province_id) on delete set null;

alter table branch_cl add 
constraint branch_city_fk foreign key(city_id) 
references province_cl(city_id) on delete set null;
commit;