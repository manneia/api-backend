-- 创建库
create database if not exists api_luo;

-- 切换库
use api_luo;

-- 用户表
create table if not exists user
(
    id           bigint auto_increment comment 'id' primary key,
    userName     varchar(256)                           null comment '用户昵称',
    userAccount  varchar(256)                           not null comment '账号',
    userAvatar   varchar(1024)                          null comment '用户头像',
    gender       tinyint                                null comment '性别',
    userRole     varchar(256) default 'user'            not null comment '用户角色：user / admin',
    userPassword varchar(512)                           not null comment '密码',
    createTime   datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete     tinyint      default 0                 not null comment '是否删除',
    constraint uni_userAccount
        unique (userAccount)
) comment '用户';

-- 帖子表
create table if not exists post
(
    id            bigint auto_increment comment 'id' primary key,
    age           int comment '年龄',
    gender        tinyint  default 0                 not null comment '性别（0-男, 1-女）',
    education     varchar(512)                       null comment '学历',
    place         varchar(512)                       null comment '地点',
    job           varchar(512)                       null comment '职业',
    contact       varchar(512)                       null comment '联系方式',
    loveExp       varchar(512)                       null comment '感情经历',
    content       text                               null comment '内容（个人介绍）',
    photo         varchar(1024)                      null comment '照片地址',
    reviewStatus  int      default 0                 not null comment '状态（0-待审核, 1-通过, 2-拒绝）',
    reviewMessage varchar(512)                       null comment '审核信息',
    viewNum       int                                not null default 0 comment '浏览数',
    thumbNum      int                                not null default 0 comment '点赞数',
    userId        bigint                             not null comment '创建用户 id',
    createTime    datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime    datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete      tinyint  default 0                 not null comment '是否删除'
) comment '帖子';

-- 接口信息表
create table if not exists api_luo.`interface_info`
(
    id             bigint                             not null auto_increment comment '主键' primary key,
    name           varchar(256)                       not null comment '接口名称',
    description    varchar(256)                       null comment '描述',
    url            varchar(512)                       not null comment '接口地址',
    requestHeader  text                               null comment '请求头',
    responseHeader text                               null comment '响应头',
    status         int      default 0                 not null comment '接口状态 (0 - 关闭 1 - 开启)',
    method         varchar(256)                       not null comment '请求类型',
    userId         bigint                             not null comment '创建人Id',
    createTime     datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime     datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete       tinyint  default 0                 not null comment '是否删除(0-未删, 1-已删)'
) comment '接口信息表';

insert into api_luo.`interface_info` (`name`, `description`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`) values ('吕浩', '龙荣轩', 'www.arlie-goodwin.biz', '黎鹏', '廖雨泽', 0, '韩雨泽', 3);
insert into api_luo.`interface_info` (`name`, `description`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`) values ('贺梓晨', '许立轩', 'www.dewayne-wintheiser.biz', '张志泽', '苏子默', 0, '方昊强', 9);
insert into api_luo.`interface_info` (`name`, `description`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`) values ('冯思淼', '唐昊然', 'www.desiree-feil.name', '董烨华', '王熠彤', 0, '邓烨磊', 748780379);
insert into api_luo.`interface_info` (`name`, `description`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`) values ('马峻熙', '姜绍辉', 'www.kira-waters.org', '任智辉', '何熠彤', 0, '戴明辉', 39360561);
insert into api_luo.`interface_info` (`name`, `description`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`) values ('潘文博', '白智宸', 'www.agustin-skiles.io', '段语堂', '严雨泽', 0, '史瑾瑜', 1494428);
insert into api_luo.`interface_info` (`name`, `description`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`) values ('叶擎苍', '谢明杰', 'www.diane-dicki.info', '石昊天', '韦乐驹', 0, '方弘文', 50);
insert into api_luo.`interface_info` (`name`, `description`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`) values ('许乐驹', '孔雨泽', 'www.lore-macejkovic.co', '袁哲瀚', '韩昊强', 0, '覃文', 4016061);
insert into api_luo.`interface_info` (`name`, `description`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`) values ('夏烨磊', '赵笑愚', 'www.christopher-homenick.io', '沈正豪', '龙乐驹', 0, '廖修杰', 21);
insert into api_luo.`interface_info` (`name`, `description`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`) values ('刘展鹏', '戴懿轩', 'www.clement-russel.net', '郑越彬', '吕文', 0, '孟正豪', 4);
insert into api_luo.`interface_info` (`name`, `description`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`) values ('严伟宸', '袁烨磊', 'www.elmo-gutmann.info', '韩熠彤', '胡钰轩', 0, '谢琪', 9169780);
insert into api_luo.`interface_info` (`name`, `description`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`) values ('廖涛', '吕楷瑞', 'www.santa-barton.com', '卢明杰', '傅旭尧', 0, '周黎昕', 1720311997);
insert into api_luo.`interface_info` (`name`, `description`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`) values ('邱立轩', '黎明杰', 'www.craig-hackett.co', '余天磊', '邹弘文', 0, '马健柏', 55444);
insert into api_luo.`interface_info` (`name`, `description`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`) values ('黎伟诚', '苏浩宇', 'www.karoline-olson.org', '严哲瀚', '赵鸿煊', 0, '刘驰', 48);
insert into api_luo.`interface_info` (`name`, `description`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`) values ('白鹏', '黄风华', 'www.wilbur-harvey.name', '钱博超', '刘靖琪', 0, '沈旭尧', 6);
insert into api_luo.`interface_info` (`name`, `description`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`) values ('蔡天翊', '金鸿煊', 'www.damon-kuhlman.net', '苏智宸', '周文', 0, '黄伟宸', 14307);
insert into api_luo.`interface_info` (`name`, `description`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`) values ('卢鑫鹏', '万懿轩', 'www.faye-von.org', '雷志泽', '莫哲瀚', 0, '田浩', 469306316);
insert into api_luo.`interface_info` (`name`, `description`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`) values ('覃振家', '郑浩然', 'www.dale-ferry.co', '尹皓轩', '罗展鹏', 0, '邵嘉熙', 849);
insert into api_luo.`interface_info` (`name`, `description`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`) values ('唐黎昕', '毛晓博', 'www.porter-dooley.info', '毛炫明', '唐立果', 0, '尹懿轩', 375);
insert into api_luo.`interface_info` (`name`, `description`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`) values ('黄烨霖', '覃思远', 'www.graig-weimann.io', '马浩轩', '史昊强', 0, '杨绍齐', 6793738);
insert into api_luo.`interface_info` (`name`, `description`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`) values ('孔展鹏', '韦熠彤', 'www.sonya-roberts.org', '姜博涛', '杜志强', 0, '龙立诚', 122767835);
