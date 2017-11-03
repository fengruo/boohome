/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50716
Source Host           : 127.0.0.1:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2017-11-03 22:04:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_adjust
-- ----------------------------
DROP TABLE IF EXISTS `t_adjust`;
CREATE TABLE `t_adjust` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adjust_time` datetime DEFAULT NULL COMMENT '申请时间',
  `adjust_remark` varchar(50) DEFAULT NULL COMMENT '申请原因',
  `adjust_user_id` int(11) DEFAULT NULL COMMENT '申请人编号',
  `adjust_class_date` date DEFAULT NULL COMMENT '申请调课时间',
  `adjust_class_no` varchar(50) DEFAULT NULL COMMENT '申请调课节次：12、34、56、78',
  `adjust_class_place` varchar(50) DEFAULT NULL COMMENT '申请调课地点',
  `adjust_class_type` varchar(50) DEFAULT NULL COMMENT '申请调课类型：补课、听课',
  `chekc_user_id` int(11) DEFAULT NULL COMMENT '审核人编号',
  `check_time` datetime DEFAULT NULL COMMENT '审核时间',
  `check_state` varchar(50) DEFAULT NULL COMMENT '审核状态，默认待审核',
  `check_remark` varchar(50) DEFAULT NULL COMMENT '审核意见',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='调课申请';

-- ----------------------------
-- Table structure for t_mailto
-- ----------------------------
DROP TABLE IF EXISTS `t_mailto`;
CREATE TABLE `t_mailto` (
  `zid` int(11) NOT NULL AUTO_INCREMENT,
  `zemail` varchar(50) DEFAULT NULL COMMENT '邮箱地址',
  `zdate` datetime DEFAULT NULL COMMENT '预定发布时间',
  `zsenddate` datetime DEFAULT NULL COMMENT '信息发布时间',
  `zemailtext` text COMMENT '邮件内容',
  `zstate` int(2) DEFAULT '0' COMMENT '发布状态 0待发 1已发',
  `zemailtitle` varchar(255) DEFAULT NULL COMMENT '邮件抬头',
  PRIMARY KEY (`zid`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_repair
-- ----------------------------
DROP TABLE IF EXISTS `t_repair`;
CREATE TABLE `t_repair` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `build` varchar(50) DEFAULT NULL COMMENT '楼号',
  `room` varchar(50) DEFAULT NULL COMMENT '房间号',
  `equipment_name` varchar(50) DEFAULT NULL COMMENT '设备名称',
  `place` varchar(50) DEFAULT NULL COMMENT '具体位置',
  `trouble` varchar(50) DEFAULT NULL COMMENT '故障描述',
  `state` varchar(50) DEFAULT NULL COMMENT '状态:报修、修复、外修',
  `phone` varchar(50) DEFAULT NULL COMMENT '联系方式',
  `report_user_id` int(11) DEFAULT NULL COMMENT '报修人编号',
  `report_remak` varchar(50) DEFAULT NULL COMMENT '报修备注',
  `report_time` datetime DEFAULT NULL COMMENT '报修时间',
  `repair_user_id` int(11) DEFAULT NULL COMMENT '维修人员编号',
  `repair_time` datetime DEFAULT NULL COMMENT '维修时间',
  `repair_remark` varchar(50) DEFAULT NULL COMMENT '维修备注',
  `apply_user_id` int(11) DEFAULT NULL COMMENT '申请人编号',
  `apply_time` datetime DEFAULT NULL,
  `apply_remark` varchar(50) DEFAULT NULL,
  `check_user_id` int(11) DEFAULT NULL COMMENT '审批人员编号',
  `check_time` datetime DEFAULT NULL COMMENT '审核时间',
  `check_remark` varchar(50) DEFAULT NULL COMMENT '审核意见',
  `check_state` varchar(50) DEFAULT NULL COMMENT '审核状态：待审核、批准、不批准',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(8) unsigned NOT NULL AUTO_INCREMENT,
  `account` varchar(12) DEFAULT NULL COMMENT '用户名',
  `password` varchar(16) DEFAULT NULL COMMENT '密码',
  `pic` varchar(50) DEFAULT NULL COMMENT '照片',
  `name_true` varchar(20) DEFAULT NULL COMMENT '真实姓名',
  `sex` varchar(1) DEFAULT NULL COMMENT '性别：男、女',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `ID_card` varchar(18) DEFAULT NULL COMMENT '身份证号',
  `tel` varchar(20) DEFAULT NULL COMMENT '移动电话',
  `college` varchar(20) DEFAULT NULL COMMENT '学院',
  `grade` varchar(4) DEFAULT NULL COMMENT '年级：4位数字',
  `specialy` varchar(20) DEFAULT NULL COMMENT '专业',
  `classes` varchar(20) DEFAULT NULL COMMENT '班级',
  `role` varchar(20) DEFAULT NULL COMMENT '角色：学生、教师。。。（管理员、院领导）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=518 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_wechatuser
-- ----------------------------
DROP TABLE IF EXISTS `t_wechatuser`;
CREATE TABLE `t_wechatuser` (
  `zid` int(8) NOT NULL AUTO_INCREMENT,
  `openid` varchar(50) NOT NULL COMMENT '唯一识别',
  `nickname` varchar(255) DEFAULT NULL COMMENT '昵称',
  `sex` int(2) DEFAULT NULL COMMENT '性别',
  `country` varchar(255) DEFAULT NULL COMMENT '国家',
  `province` varchar(255) DEFAULT NULL COMMENT '省份',
  `city` varchar(255) DEFAULT NULL COMMENT '城市',
  `imgurl` varchar(255) DEFAULT NULL COMMENT '头像',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`zid`),
  KEY `u_id` (`zid`),
  KEY `u_openid` (`openid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
