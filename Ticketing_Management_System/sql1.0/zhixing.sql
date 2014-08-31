alter table user_cl add constraint
 user_cl_branch_id_fk foreign key(branch_id) references branch_cl(branch_id);