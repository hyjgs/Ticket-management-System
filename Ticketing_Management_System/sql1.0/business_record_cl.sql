insert into business_record_cl
values(1,to_date('2013-08-23','yyyy-mm-dd'),10003,1003,900,'确定一级结算','购票');

insert into business_record_cl
values(2,to_date('2013-08-25','yyyy-mm-dd'),10010,1002,1350,'申请二级结算','购票');

insert into business_record_cl
values(3,to_date('2013-08-25','yyyy-mm-dd'),10003,1003,600,'申请一级结算','购票');

insert into business_record_cl
values(4,to_date('2013-08-27','yyyy-mm-dd'),10003,1003,-500,'申请一级结算','退票');

select user_id,branch_id from user_cl
where role_id = 1;

alter table business_record_cl
modify buss_red_account_state varchar(30);

select * from business_record_cl;


create sequence buss_red_num
start with 9
increment by 1


insert into business_record_cl values(buss_red_num.nextval





