-- 社区团购系统数据库初始化脚本
CREATE DATABASE IF NOT EXISTS springboot975sz DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE springboot975sz;

CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint NOT NULL COMMENT '主键',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `role` varchar(50) DEFAULT '管理员' COMMENT '角色',
  `addtime` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='管理员';

INSERT INTO `users` VALUES (1, 'admin', '21232f297a57a5a743894a0e4a801fc3', '管理员', NOW());

CREATE TABLE IF NOT EXISTS `token` (
  `id` bigint NOT NULL COMMENT '主键',
  `userid` bigint DEFAULT NULL COMMENT '用户id',
  `username` varchar(100) DEFAULT NULL COMMENT '用户名',
  `tablename` varchar(100) DEFAULT NULL COMMENT '表名',
  `role` varchar(50) DEFAULT NULL COMMENT '角色',
  `token` varchar(200) DEFAULT NULL COMMENT 'token',
  `expiratedtime` datetime DEFAULT NULL COMMENT '过期时间',
  `addtime` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='token表';

CREATE TABLE IF NOT EXISTS `yonghu` (
  `id` bigint NOT NULL COMMENT '主键',
  `zhanghao` varchar(100) NOT NULL COMMENT '账号',
  `mima` varchar(100) NOT NULL COMMENT '密码',
  `xingming` varchar(100) DEFAULT NULL COMMENT '姓名',
  `xingbie` varchar(50) DEFAULT NULL COMMENT '性别',
  `shouji` varchar(20) DEFAULT NULL COMMENT '手机',
  `youxiang` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `touxiang` varchar(500) DEFAULT NULL COMMENT '头像',
  `money` double DEFAULT 0 COMMENT '余额',
  `addtime` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户';

CREATE TABLE IF NOT EXISTS `shangjia` (
  `id` bigint NOT NULL COMMENT '主键',
  `shangjiabianhao` varchar(100) NOT NULL COMMENT '商家编号',
  `shangjiamingcheng` varchar(200) DEFAULT NULL COMMENT '商家名称',
  `mima` varchar(100) NOT NULL COMMENT '密码',
  `lianxiren` varchar(100) DEFAULT NULL COMMENT '联系人',
  `lianxidianhua` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `dizhi` varchar(500) DEFAULT NULL COMMENT '地址',
  `yingyezhizhao` varchar(500) DEFAULT NULL COMMENT '营业执照',
  `shenhezt` varchar(50) DEFAULT '未审核' COMMENT '审核状态',
  `money` double DEFAULT 0 COMMENT '余额',
  `addtime` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商家';

CREATE TABLE IF NOT EXISTS `shangpinfenlei` (
  `id` bigint NOT NULL COMMENT '主键',
  `shangpinfenlei` varchar(100) DEFAULT NULL COMMENT '商品分类',
  `addtime` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品分类';

CREATE TABLE IF NOT EXISTS `shangpinxinxi` (
  `id` bigint NOT NULL COMMENT '主键',
  `shangpinmingcheng` varchar(200) DEFAULT NULL COMMENT '商品名称',
  `shangpinfenlei` varchar(100) DEFAULT NULL COMMENT '商品分类',
  `pinpai` varchar(100) DEFAULT NULL COMMENT '品牌',
  `shangjiariqi` date DEFAULT NULL COMMENT '上架日期',
  `shangpinjieshao` text COMMENT '商品介绍',
  `shangpintupian` varchar(500) DEFAULT NULL COMMENT '商品图片',
  `shangpubianhao` varchar(100) DEFAULT NULL COMMENT '商铺编号',
  `shangpumingcheng` varchar(200) DEFAULT NULL COMMENT '商铺名称',
  `onelimittimes` int DEFAULT NULL COMMENT '单人限购次数',
  `alllimittimes` int DEFAULT NULL COMMENT '总限购次数',
  `thumbsupnum` int DEFAULT 0 COMMENT '点赞数',
  `crazilynum` int DEFAULT 0 COMMENT '收藏数',
  `clicktime` datetime DEFAULT NULL COMMENT '最近点击时间',
  `clicknum` int DEFAULT 0 COMMENT '点击次数',
  `price` double DEFAULT NULL COMMENT '原价',
  `groupprice` double DEFAULT NULL COMMENT '团购价',
  `grouppeople` int DEFAULT NULL COMMENT '团购人数',
  `curpeople` int DEFAULT 0 COMMENT '当前团购人数',
  `addtime` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品信息';

CREATE TABLE IF NOT EXISTS `cart` (
  `id` bigint NOT NULL COMMENT '主键',
  `tablename` varchar(100) DEFAULT NULL COMMENT '商品表名',
  `userid` bigint DEFAULT NULL COMMENT '用户id',
  `goodid` bigint DEFAULT NULL COMMENT '商品id',
  `goodname` varchar(200) DEFAULT NULL COMMENT '商品名称',
  `picture` varchar(500) DEFAULT NULL COMMENT '图片',
  `buynumber` int DEFAULT 1 COMMENT '购买数量',
  `price` double DEFAULT NULL COMMENT '原价',
  `discountprice` double DEFAULT NULL COMMENT '折扣价',
  `addtime` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='购物车';

CREATE TABLE IF NOT EXISTS `orders` (
  `id` bigint NOT NULL COMMENT '主键',
  `orderid` varchar(100) DEFAULT NULL COMMENT '订单编号',
  `tablename` varchar(100) DEFAULT NULL COMMENT '商品表名',
  `userid` bigint DEFAULT NULL COMMENT '用户id',
  `goodid` bigint DEFAULT NULL COMMENT '商品id',
  `goodname` varchar(200) DEFAULT NULL COMMENT '商品名称',
  `picture` varchar(500) DEFAULT NULL COMMENT '图片',
  `buynumber` int DEFAULT 1 COMMENT '购买数量',
  `price` double DEFAULT NULL COMMENT '原价',
  `discountprice` double DEFAULT NULL COMMENT '折扣价',
  `total` double DEFAULT NULL COMMENT '总价',
  `discounttotal` double DEFAULT NULL COMMENT '折扣总价',
  `type` int DEFAULT 1 COMMENT '支付类型',
  `status` varchar(50) DEFAULT '未支付' COMMENT '订单状态',
  `address` varchar(500) DEFAULT NULL COMMENT '收货地址',
  `tel` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `consignee` varchar(100) DEFAULT NULL COMMENT '收货人',
  `logistics` varchar(200) DEFAULT NULL COMMENT '物流信息',
  `remark` text COMMENT '备注',
  `addtime` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单';

CREATE TABLE IF NOT EXISTS `address` (
  `id` bigint NOT NULL COMMENT '主键',
  `userid` bigint DEFAULT NULL COMMENT '用户id',
  `address` varchar(500) DEFAULT NULL COMMENT '收货地址',
  `name` varchar(100) DEFAULT NULL COMMENT '收货人',
  `phone` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `isdefault` varchar(10) DEFAULT '否' COMMENT '是否默认',
  `addtime` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='收货地址';

CREATE TABLE IF NOT EXISTS `discussshangpinxinxi` (
  `id` bigint NOT NULL COMMENT '主键',
  `refid` bigint DEFAULT NULL COMMENT '关联商品id',
  `userid` bigint DEFAULT NULL COMMENT '用户id',
  `nickname` varchar(100) DEFAULT NULL COMMENT '昵称',
  `content` text COMMENT '评论内容',
  `reply` text COMMENT '回复',
  `addtime` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品评论';

CREATE TABLE IF NOT EXISTS `storeup` (
  `id` bigint NOT NULL COMMENT '主键',
  `userid` bigint DEFAULT NULL COMMENT '用户id',
  `refid` bigint DEFAULT NULL COMMENT '关联id',
  `tablename` varchar(100) DEFAULT NULL COMMENT '表名',
  `name` varchar(200) DEFAULT NULL COMMENT '名称',
  `picture` varchar(500) DEFAULT NULL COMMENT '图片',
  `type` varchar(50) DEFAULT NULL COMMENT '类型',
  `inteltype` varchar(50) DEFAULT NULL COMMENT '推荐类型',
  `remark` text COMMENT '备注',
  `addtime` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='收藏';

CREATE TABLE IF NOT EXISTS `shequxinxi` (
  `id` bigint NOT NULL COMMENT '主键',
  `title` varchar(200) DEFAULT NULL COMMENT '标题',
  `picture` varchar(500) DEFAULT NULL COMMENT '图片',
  `content` text COMMENT '内容',
  `addtime` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='社区信息';

CREATE TABLE IF NOT EXISTS `messages` (
  `id` bigint NOT NULL COMMENT '主键',
  `userid` bigint DEFAULT NULL COMMENT '用户id',
  `username` varchar(100) DEFAULT NULL COMMENT '用户名',
  `content` text COMMENT '留言内容',
  `cpicture` varchar(500) DEFAULT NULL COMMENT '留言图片',
  `reply` text COMMENT '回复',
  `rpicture` varchar(500) DEFAULT NULL COMMENT '回复图片',
  `addtime` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='留言';

CREATE TABLE IF NOT EXISTS `news` (
  `id` bigint NOT NULL COMMENT '主键',
  `title` varchar(200) DEFAULT NULL COMMENT '标题',
  `introduction` text COMMENT '简介',
  `picture` varchar(500) DEFAULT NULL COMMENT '图片',
  `content` text COMMENT '内容',
  `addtime` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='新闻公告';

CREATE TABLE IF NOT EXISTS `config` (
  `id` bigint NOT NULL COMMENT '主键',
  `name` varchar(100) DEFAULT NULL COMMENT '配置名称',
  `value` text COMMENT '配置值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统配置';

INSERT INTO `config` VALUES (1, 'bannerImg', '');
INSERT INTO `config` VALUES (2, 'noticeTitle', '欢迎使用社区团购系统');
INSERT INTO `config` VALUES (3, 'noticeContent', '本系统为社区团购平台，提供优质的团购商品和服务。');
