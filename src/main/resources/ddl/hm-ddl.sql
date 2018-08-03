create table  if not exists user (
  id int(11) not null auto_increment comment 'ID',
  loginname varchar(20) comment '登录名',
  name varchar(20) comment '用户名',
  password varchar(20) not null comment  '密码',
  created datetime not null  comment '创建时间',
  modified datetime not null  comment '修改时间',
  creator varchar(64) not null  comment '创建人',
  modifier varchar(64) not null comment '修改人',
  primary key(id),
  unique key uk_1(loginname)
)engine=innodb default charset=utf8 comment '用户';

create table  if not exists permission (
  id int(11) not null auto_increment comment 'ID' ,
  name varchar(64) not null comment '名称',
  primary key(id)
)engine=innodb default charset=utf8 comment '权限';

create table if not exists userpermission (
  id int(11) not null auto_increment comment 'ID',
  userId int(11) not null comment 'userID',
  permissionId int(11) not null comment 'PermissionID',
  primary key(id)
)engine=innodb default charset=utf8mb4 comment '用户权限表'

