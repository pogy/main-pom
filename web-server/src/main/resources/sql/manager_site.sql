/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Version : 50163
 Source Host           : localhost
 Source Database       : manager_site

 Target Server Version : 50163
 File Encoding         : utf-8

 Date: 05/13/2016 20:29:24 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `manager_permission`
-- ----------------------------
DROP TABLE IF EXISTS `manager_permission`;
CREATE TABLE `manager_permission` (
  `permission_id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `namespace` varchar(30) DEFAULT NULL,
  `permission_tag` varchar(60) DEFAULT NULL COMMENT '权限标签',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint(11) DEFAULT NULL COMMENT '创建者Id',
  `status` tinyint(1) unsigned DEFAULT '1' COMMENT '状态，1为可用0为不可用',
  `permission_comment` varchar(100) DEFAULT NULL COMMENT '权限备注',
  `parent_pid` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
--  Records of `manager_permission`
-- ----------------------------
BEGIN;
INSERT INTO `manager_permission` VALUES ('1', 'sup', 'sup:btn', '2016-05-12 15:12:55', '1', '0', '用户角色权限管理', null), ('3', 'sup', 'sup:btn2', '2016-05-13 10:05:20', '1', '0', '这个用来写', '1'), ('4', 'sup', 'sup:title', '2016-05-13 14:27:15', '1', '0', '管理员的标题用的', null), ('5', 'sup', 'sup:bbb', '2016-05-13 17:03:21', '1', '0', '小按钮', '3'), ('6', 'sup', 'sup:bws', '2016-05-13 17:08:06', '1', '0', '大按钮', '3'), ('7', 'sup', 'sup:wiw', '2016-05-13 17:08:36', '1', '0', '中按钮', '3'), ('8', 'sup', 'sub:ttt', '2016-05-13 17:17:48', '1', '0', '测试啊', '4'), ('9', 'user', 'user:manager', '2016-05-13 18:18:14', '1', '1', '用户管理', null), ('10', 'user', 'user:list', '2016-05-13 18:18:43', '1', '1', '用户列表', '9'), ('11', 'user', 'user:add', '2016-05-13 18:19:17', '1', '1', '添加用户', '9'), ('12', 'user', 'user:modify', '2016-05-13 18:20:00', '1', '1', '修改用户角色', '9'), ('13', 'role', 'role:manager', '2016-05-13 18:20:26', '1', '1', '角色管理', null), ('14', 'role', 'role:list', '2016-05-13 18:20:52', '1', '1', '角色列表', '13'), ('15', 'role', 'role:add', '2016-05-13 18:21:28', '1', '1', '添加角色', '13'), ('16', 'role', 'role:modify', '2016-05-13 18:22:06', '1', '1', '修改角色权限', '13'), ('17', 'permission', 'permission:manager', '2016-05-13 18:22:30', '1', '1', '权限管理', null), ('18', 'permission', 'permission:list', '2016-05-13 18:23:01', '1', '1', '权限列表', '17'), ('19', 'permission', 'permission:top', '2016-05-13 18:24:19', '1', '1', '操作顶级权限', '17'), ('20', 'permission', 'permission:sub', '2016-05-13 18:24:47', '1', '1', '操作子级权限', '17');
COMMIT;

-- ----------------------------
--  Table structure for `manager_role`
-- ----------------------------
DROP TABLE IF EXISTS `manager_role`;
CREATE TABLE `manager_role` (
  `role_id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_name` varchar(45) DEFAULT NULL COMMENT '角色名称',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `role_comment` varchar(255) DEFAULT NULL COMMENT '角色备注',
  `create_user_id` bigint(11) DEFAULT NULL COMMENT '登陆者用户ID',
  `status` tinyint(1) unsigned DEFAULT '1' COMMENT '可用性，1为可用，0为不可用',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
--  Records of `manager_role`
-- ----------------------------
BEGIN;
INSERT INTO `manager_role` VALUES ('1', '超级管理员', '2016-05-12 15:12:14', '最高权限', '1', '1'), ('2', '小角色', '2016-05-13 11:01:18', '不足为说', '1', '1');
COMMIT;

-- ----------------------------
--  Table structure for `manager_role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `manager_role_permission`;
CREATE TABLE `manager_role_permission` (
  `role_permission_id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` bigint(11) DEFAULT NULL COMMENT '角色Id',
  `permission_id` bigint(11) DEFAULT NULL COMMENT '权限Id',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COMMENT='角色、权限对应表';

-- ----------------------------
--  Records of `manager_role_permission`
-- ----------------------------
BEGIN;
INSERT INTO `manager_role_permission` VALUES ('2', '1', '1', '2016-05-13 13:10:26'), ('3', '2', '1', '2016-05-13 14:03:02'), ('4', '2', '3', '2016-05-13 14:03:03'), ('7', '1', '3', '2016-05-13 18:05:44'), ('8', '1', '4', '2016-05-13 18:05:54'), ('9', '2', '5', '2016-05-13 18:12:46'), ('12', '1', '5', '2016-05-13 18:13:24'), ('13', '1', '6', '2016-05-13 18:13:25'), ('14', '1', '7', '2016-05-13 18:13:25'), ('15', '1', '8', '2016-05-13 18:13:26'), ('16', '1', '9', '2016-05-13 18:34:58'), ('17', '1', '10', '2016-05-13 18:34:58'), ('18', '1', '11', '2016-05-13 18:34:59'), ('19', '1', '12', '2016-05-13 18:35:00'), ('20', '1', '13', '2016-05-13 18:35:00'), ('21', '1', '16', '2016-05-13 18:35:01'), ('22', '1', '15', '2016-05-13 18:35:01'), ('23', '1', '14', '2016-05-13 18:35:02'), ('24', '1', '17', '2016-05-13 18:35:03'), ('25', '1', '18', '2016-05-13 18:35:04'), ('26', '1', '19', '2016-05-13 18:35:04'), ('27', '1', '20', '2016-05-13 18:35:05'), ('28', '2', '10', '2016-05-13 18:52:38'), ('29', '2', '9', '2016-05-13 18:52:41');
COMMIT;

-- ----------------------------
--  Table structure for `manager_user`
-- ----------------------------
DROP TABLE IF EXISTS `manager_user`;
CREATE TABLE `manager_user` (
  `user_id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `nick` varchar(100) DEFAULT NULL COMMENT '用户昵称',
  `login_name` varchar(60) DEFAULT NULL COMMENT '用户登陆名',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `status` tinyint(1) unsigned DEFAULT '1' COMMENT '用户状态，1为可用，0为不可用',
  `head_url` varchar(255) DEFAULT NULL COMMENT '用户头像',
  `last_login_ip` varchar(20) DEFAULT NULL COMMENT '最后登陆IP',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
--  Records of `manager_user`
-- ----------------------------
BEGIN;
INSERT INTO `manager_user` VALUES ('1', '开发维护', 'kfwh', 'CpievEp3tWpuK7exnZldGFzkQJDBPimEt+zG1EbUth6pmRt2pMLwSxtNJEhBRJRU', '2016-05-10 18:17:27', '1', null, null), ('2', '大数据维护', 'datauser', 'CpievEp3tWpuK7exnZldGFzkQJDBPimEt+zG1EbUth6pmRt2pMLwSxtNJEhBRJRU', '2016-05-13 14:07:26', '1', null, null);
COMMIT;

-- ----------------------------
--  Table structure for `manager_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `manager_user_role`;
CREATE TABLE `manager_user_role` (
  `user_role_id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(11) DEFAULT NULL COMMENT '用户Id',
  `role_id` bigint(11) DEFAULT NULL COMMENT '解决Id',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户角色表';

-- ----------------------------
--  Records of `manager_user_role`
-- ----------------------------
BEGIN;
INSERT INTO `manager_user_role` VALUES ('1', '1', '1', '2016-05-12 15:13:40');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
