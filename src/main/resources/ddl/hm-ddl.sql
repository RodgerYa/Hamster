create table  if not exists user (
  id int(11) not null auto_increment comment 'ID',
  loginname varchar(20) not null comment '登录名',
  name varchar(20) not null comment '用户名',
  password varchar(20) not null comment  '密码',
  created datetime not null default current_timestamp comment '创建时间',
  modified datetime not null default current_timestamp on update current_timestamp comment '修改时间',
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

create table if not exists assetsaccount (
  id int(11) not null auto_increment comment 'ID',
  userid int(11) not null comment '用户id',
  name varchar(38) not null comment '账户名称',
  type int(11) not null comment '账户类型',
  balance int(20) not null default 0 comment '账户余额(分)',
  totalCost int(20) not null default 0 comment '账户累计流出金额(分)',
  totalIncome int(20) not null default 0 comment '账户累计流入金额(分)',
  created datetime not null default current_timestamp comment '创建时间',
  creator varchar(38) not null comment '创建人',
  modifier varchar(38) not null comment '修改人',
  modified datetime not null default current_timestamp on update current_timestamp comment '修改时间',
  description text COMMENT '账户描述',
  primary key(id),
  unique key uk_useraccount(userid, name)
)engine=innodb default charset=utf8mb4 comment '资产账户表'

create table if not exists liabilityaccount (
  id int(11) not null auto_increment comment 'ID',
  userid int(11) not null comment '用户id',
  name varchar(38) not null comment '账户名称',
  type int(11) not null comment '账户类型',
  lineofcredit int(20) not null default 0 comment '信用额度(分)',
  totalCost int(20) not null default 0 comment '账户累计流出金额(分)',
  statementdate int(11) not null default 1 comment '出账日期',
  repaymentdate int(11) not null default 1 comment '还款日期',
  created datetime not null default current_timestamp comment '创建时间',
  creator varchar(38) not null comment '创建人',
  modifier varchar(38) not null comment '修改人',
  modified datetime not null default current_timestamp on update current_timestamp comment '修改时间',
  description text COMMENT '账户描述',
  primary key(id),
  unique key uk_useraccount(userid, name)
)engine=innodb default charset=utf8mb4 comment '负债账户表'

create table if not exists billitem (
  id int(11) not null auto_increment comment 'ID',
  userid int(11) not null comment '用户id',
  accountid int(11) not null comment '账户id',
  fromassetsaccount boolean not null comment '是否来源于资产账户',
  isincome boolean not null default false comment '是否是收入',
  costtype int(11) not null comment '消费类型',
  amount int(20) not null comment '记账金额（分）',
  created datetime not null default current_timestamp comment '创建时间',
  creator varchar(38) not null comment '创建人',
  modifier varchar(38) not null comment '修改人',
  modified datetime not null default current_timestamp on update current_timestamp comment '修改时间',
  primary key(id)
)engine=innodb default charset=utf8mb4 comment '记账款项表'

