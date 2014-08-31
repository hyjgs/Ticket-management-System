
-- insert into CabinClass_cl(cabin_class_id,cabin_class_name,cabin_class_char,
-- refund_charge,limit_condition,cabin_discount,plane_cabin_type,mileage_factor,
--turn_charge,redate_charge) values(1001,'头等舱','F',0.05,'TGZ',1.8,'F',1.5,20,10);
 
 insert into CabinClass_cl(cabin_class_id,cabin_class_name,cabin_class_char,
 refund_charge,limit_condition,cabin_discount,plane_cabin_type,mileage_factor,
 turn_charge,redate_charge) values(1002,'头等舱(折扣)','A',0.05,'TG',1.5,'F',1.5,null,10);
 
  insert into CabinClass_cl(cabin_class_id,cabin_class_name,cabin_class_char,
 refund_charge,limit_condition,cabin_discount,plane_cabin_type,mileage_factor,
 turn_charge,redate_charge) values(1003,'头等舱(会员)','O',null,'G',null,'F',null,null,1000);
 
  insert into CabinClass_cl(cabin_class_id,cabin_class_name,cabin_class_char,
 refund_charge,limit_condition,cabin_discount,plane_cabin_type,mileage_factor,
 turn_charge,redate_charge) values(1004,'公务舱','C',0.05,'TGZ',1.5,'C',1.3,20,10);
  insert into CabinClass_cl(cabin_class_id,cabin_class_name,cabin_class_char,
 refund_charge,limit_condition,cabin_discount,plane_cabin_type,mileage_factor,
 turn_charge,redate_charge) values(1005,'公务舱(折扣)','D',0.05,'TG',1.2,'C',1.3,null,10);
  insert into CabinClass_cl(cabin_class_id,cabin_class_name,cabin_class_char,
 refund_charge,limit_condition,cabin_discount,plane_cabin_type,mileage_factor,
 turn_charge,redate_charge) values(1006,'公务舱(会员)','I',null,'G',null,'C',null,null,1000);
  insert into CabinClass_cl(cabin_class_id,cabin_class_name,cabin_class_char,
 refund_charge,limit_condition,cabin_discount,plane_cabin_type,mileage_factor,
 turn_charge,redate_charge) values(1007,'经济舱','Y',0.05,'TGZ',1.0,'Y',1.0,20,10);
 insert into CabinClass_cl(cabin_class_id,cabin_class_name,cabin_class_char,
 refund_charge,limit_condition,cabin_discount,plane_cabin_type,mileage_factor,
 turn_charge,redate_charge) values(1008,'经济舱(折扣)','M',0.05,'TG',0.9,'Y',0.9,null,10);
 insert into CabinClass_cl(cabin_class_id,cabin_class_name,cabin_class_char,
 refund_charge,limit_condition,cabin_discount,plane_cabin_type,mileage_factor,
 turn_charge,redate_charge) values(1009,'经济舱(会员)','W',null,'G',null,'Y',null,null,500);
 insert into CabinClass_cl(cabin_class_id,cabin_class_name,cabin_class_char,
 refund_charge,limit_condition,cabin_discount,plane_cabin_type,mileage_factor,
 turn_charge,redate_charge) values(1010,'经济舱(折扣)','H',0.05,'TG',0.85,'Y',0.85,null,10);
 insert into CabinClass_cl(cabin_class_id,cabin_class_name,cabin_class_char,
 refund_charge,limit_condition,cabin_discount,plane_cabin_type,mileage_factor,
 turn_charge,redate_charge) values(1011,'经济舱(折扣)','K',0.05,'TG',0.8,'Y',0.8,null,10);
 insert into CabinClass_cl(cabin_class_id,cabin_class_name,cabin_class_char,
 refund_charge,limit_condition,cabin_discount,plane_cabin_type,mileage_factor,
 turn_charge,redate_charge) values(1012,'经济舱(折扣)','L',0.05,'TG',0.75,'Y',0.75,null,10);
 select * from CabinClass_cl;
 ALTER TABLE CabinClass_cl MODIFY(redate_charge number(4));