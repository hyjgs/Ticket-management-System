insert into order_item_cl
values(0812,201412580,1003,'F',1.8,900,150,1001);

insert into order_item_cl
values(0813,201412582,1001,'M',0.9,1350,150,1002);
select * from order_item_cl;

201412581  900
201412582 1350
201412583 900

alter table order_item_cl
drop constraint ORDER_ITEM_CL_CK ;