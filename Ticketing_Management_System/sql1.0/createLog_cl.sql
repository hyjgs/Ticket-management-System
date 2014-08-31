
create sequence log_cl start with 1000 increment by 1;
create table mylog_cl(
	log_id number(8) primary key,
	who varchar(20),
	whentime date default sysdate,
	what varchar(60)
	);
	
	insert into mylog_cl values(log_cl.nextval,user,sysdate,'updatesda');
	
	select * from mylog_cl;
	delete mylog_cl;
	select * from plane_cl;
	select f_cabin_seats,c_cabin_seats,y_cabin_seats from plane_cl where plane_id = 1001203159;