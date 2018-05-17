/*
Navicat MySQL Data Transfer

Source Server         : localhsot
Source Server Version : 50720
Source Host           : 127.0.0.1:3306
Source Database       : oamanager

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-05-18 04:00:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_ackforleave
-- ----------------------------
DROP TABLE IF EXISTS `tb_ackforleave`;
CREATE TABLE `tb_ackforleave` (
  `afl_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `afl_applicationDate` date DEFAULT NULL,
  `afl_startdate` date DEFAULT NULL,
  `afl_endDate` date DEFAULT NULL,
  `afl_content` text,
  `alfType_id` int(11) DEFAULT NULL,
  `afl_approvestatus` varchar(50) DEFAULT NULL,
  `afl_approveContent` text,
  `afl_approveDate` date DEFAULT NULL,
  PRIMARY KEY (`afl_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_ackforleave
-- ----------------------------

-- ----------------------------
-- Table structure for tb_afltype
-- ----------------------------
DROP TABLE IF EXISTS `tb_afltype`;
CREATE TABLE `tb_afltype` (
  `alfType_id` int(11) NOT NULL AUTO_INCREMENT,
  `aflType_name` varchar(30) DEFAULT NULL,
  `aflType_descripti` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`alfType_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_afltype
-- ----------------------------
INSERT INTO `tb_afltype` VALUES ('1', '事假', ' ');
INSERT INTO `tb_afltype` VALUES ('2', '年假', ' ');
INSERT INTO `tb_afltype` VALUES ('3', '其它', ' ');
INSERT INTO `tb_afltype` VALUES ('4', '婚假', ' ');
INSERT INTO `tb_afltype` VALUES ('5', '病假', ' ');
INSERT INTO `tb_afltype` VALUES ('6', '探亲假', ' ');
INSERT INTO `tb_afltype` VALUES ('7', '产假', null);

-- ----------------------------
-- Table structure for tb_announcement
-- ----------------------------
DROP TABLE IF EXISTS `tb_announcement`;
CREATE TABLE `tb_announcement` (
  `am_id` int(11) NOT NULL AUTO_INCREMENT,
  `am_theme` varchar(100) NOT NULL,
  `am_conten` text NOT NULL,
  `user_id` int(11) NOT NULL,
  `am_date` date NOT NULL,
  `am_state` int(11) DEFAULT '0',
  PRIMARY KEY (`am_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_announcement
-- ----------------------------
INSERT INTO `tb_announcement` VALUES ('11', '五一放假三天', '亲，五一我们放假三天', '1', '2018-04-25', '1');
INSERT INTO `tb_announcement` VALUES ('13', '本周末要加班哦', '请注意，本周末要加班哦！', '39', '2018-05-17', '1');
INSERT INTO `tb_announcement` VALUES ('15', '明天中午聚餐', '亲，明天中午我们一起聚餐', '1', '2018-05-15', '1');
INSERT INTO `tb_announcement` VALUES ('17', '今天中午福满楼聚餐', 'All，今天中午福满楼聚餐！', '39', '2018-05-18', '1');

-- ----------------------------
-- Table structure for tb_announcementrange
-- ----------------------------
DROP TABLE IF EXISTS `tb_announcementrange`;
CREATE TABLE `tb_announcementrange` (
  `am_id` int(11) NOT NULL,
  `dept_id` int(11) NOT NULL,
  PRIMARY KEY (`am_id`,`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_announcementrange
-- ----------------------------
INSERT INTO `tb_announcementrange` VALUES ('1', '1');

-- ----------------------------
-- Table structure for tb_approve
-- ----------------------------
DROP TABLE IF EXISTS `tb_approve`;
CREATE TABLE `tb_approve` (
  `approve_id` int(11) NOT NULL AUTO_INCREMENT,
  `approve_idea` varchar(30) DEFAULT NULL,
  `approve_date` date DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `offi_id` int(11) DEFAULT NULL,
  `agreeOrnot` int(11) DEFAULT NULL,
  PRIMARY KEY (`approve_id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_approve
-- ----------------------------
INSERT INTO `tb_approve` VALUES ('1', '吃肉去吧', '2018-05-13', '14', '2', '0');
INSERT INTO `tb_approve` VALUES ('2', '收到', '2018-05-13', '39', '2', '0');
INSERT INTO `tb_approve` VALUES ('3', '1111', '2018-05-13', '39', '1', '0');
INSERT INTO `tb_approve` VALUES ('4', '回去吧', '2018-05-13', '14', '3', '0');
INSERT INTO `tb_approve` VALUES ('5', '去吃吧', '2018-05-13', '14', '4', '0');
INSERT INTO `tb_approve` VALUES ('6', '去吃吧', '2018-05-13', '14', '4', '0');
INSERT INTO `tb_approve` VALUES ('7', '去吧', '2018-05-13', '14', '5', '0');
INSERT INTO `tb_approve` VALUES ('8', '的说说', '2018-05-13', '14', '8', '0');
INSERT INTO `tb_approve` VALUES ('9', '谁谁谁', '2018-05-13', '14', '6', '0');
INSERT INTO `tb_approve` VALUES ('10', '大师傅', '2018-05-13', '14', '7', '0');
INSERT INTO `tb_approve` VALUES ('11', '好', '2018-05-14', '14', '13', '0');
INSERT INTO `tb_approve` VALUES ('12', 'ok', '2018-05-14', '8', '13', '0');
INSERT INTO `tb_approve` VALUES ('13', '核算通过', '2018-05-14', '11', '13', '0');
INSERT INTO `tb_approve` VALUES ('14', '玩得开心', '2018-05-14', '5', '13', '0');
INSERT INTO `tb_approve` VALUES ('15', '注意安全', '2018-05-14', '1', '13', '0');
INSERT INTO `tb_approve` VALUES ('16', '保证完成任务', '2018-05-14', '39', '13', '0');
INSERT INTO `tb_approve` VALUES ('17', '1111', '2018-05-14', '14', '14', '0');
INSERT INTO `tb_approve` VALUES ('18', '222222', '2018-05-14', '14', '15', '0');
INSERT INTO `tb_approve` VALUES ('19', '3333', '2018-05-14', '14', '16', '0');
INSERT INTO `tb_approve` VALUES ('20', '啊啊啊啊啊', '2018-05-14', '8', '14', '0');
INSERT INTO `tb_approve` VALUES ('21', '顶顶顶顶', '2018-05-14', '8', '15', '0');
INSERT INTO `tb_approve` VALUES ('22', '顶顶顶顶', '2018-05-14', '8', '16', '0');
INSERT INTO `tb_approve` VALUES ('23', '干干干', '2018-05-14', '11', '14', '0');
INSERT INTO `tb_approve` VALUES ('24', '1111', '2018-05-14', '11', '15', '0');
INSERT INTO `tb_approve` VALUES ('25', '11111', '2018-05-14', '11', '16', '0');
INSERT INTO `tb_approve` VALUES ('26', '谁谁谁', '2018-05-14', '5', '14', '0');
INSERT INTO `tb_approve` VALUES ('27', '谁谁谁', '2018-05-14', '5', '15', '0');
INSERT INTO `tb_approve` VALUES ('28', '三生三世十里桃花', '2018-05-14', '5', '16', '0');
INSERT INTO `tb_approve` VALUES ('29', '666', '2018-05-14', '1', '14', '0');
INSERT INTO `tb_approve` VALUES ('30', '三生三世十里桃花', '2018-05-14', '14', '17', '0');
INSERT INTO `tb_approve` VALUES ('31', '1111111', '2018-05-14', '8', '17', '0');
INSERT INTO `tb_approve` VALUES ('32', '5555', '2018-05-14', '11', '17', '0');
INSERT INTO `tb_approve` VALUES ('33', '顶顶顶顶', '2018-05-14', '5', '17', '0');
INSERT INTO `tb_approve` VALUES ('34', '666666', '2018-05-14', '1', '17', '0');
INSERT INTO `tb_approve` VALUES ('35', '是是是', '2018-05-14', '39', '17', '0');
INSERT INTO `tb_approve` VALUES ('36', '顶顶顶顶', '2018-05-14', '14', '18', '0');
INSERT INTO `tb_approve` VALUES ('37', '公告管理', '2018-05-14', '8', '18', '0');
INSERT INTO `tb_approve` VALUES ('38', '6666', '2018-05-14', '11', '18', '0');
INSERT INTO `tb_approve` VALUES ('39', '6666', '2018-05-14', '5', '18', '0');
INSERT INTO `tb_approve` VALUES ('40', '333', '2018-05-14', '1', '18', '0');
INSERT INTO `tb_approve` VALUES ('41', '88888', '2018-05-14', '39', '18', '0');
INSERT INTO `tb_approve` VALUES ('42', '啊啊啊', '2018-05-14', '14', '19', '0');
INSERT INTO `tb_approve` VALUES ('43', '等到', '2018-05-14', '8', '19', '0');
INSERT INTO `tb_approve` VALUES ('44', '是是是', '2018-05-14', '5', '19', '0');
INSERT INTO `tb_approve` VALUES ('45', '啊啊啊', '2018-05-14', '39', '19', '0');

-- ----------------------------
-- Table structure for tb_asset
-- ----------------------------
DROP TABLE IF EXISTS `tb_asset`;
CREATE TABLE `tb_asset` (
  `asset_no` varchar(20) NOT NULL,
  `asset_name` varchar(50) DEFAULT NULL,
  `dept_id` int(11) DEFAULT NULL,
  `assettype_id` int(11) DEFAULT NULL,
  `asset_money` double DEFAULT NULL,
  `depreciation_year` double DEFAULT NULL,
  `incomplete_rate` double DEFAULT NULL,
  `moth_depreciation` double DEFAULT NULL,
  `asset_nature` int(11) DEFAULT NULL,
  `asset_date` date DEFAULT NULL,
  `using_date` date DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `fortifytype_id` int(11) DEFAULT NULL,
  `asset_descripti` varchar(50) DEFAULT NULL,
  `asset_img` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`asset_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_asset
-- ----------------------------
INSERT INTO `tb_asset` VALUES ('A20170901', '笔记本电脑', '1', '1', '6999', '1', '1', null, '0', '2017-11-10', '2017-11-13', '1', '1', '123', null);
INSERT INTO `tb_asset` VALUES ('A20170902', '笔记本电脑', '2', '1', '6999', '1', '1', null, '0', '2017-11-10', null, '5', '1', '123', null);
INSERT INTO `tb_asset` VALUES ('A20170903', '笔记本电脑', '1', '1', '6999', '1', '1', null, '1', '2017-11-10', null, '3', '3', '123', null);

-- ----------------------------
-- Table structure for tb_assetmaintain
-- ----------------------------
DROP TABLE IF EXISTS `tb_assetmaintain`;
CREATE TABLE `tb_assetmaintain` (
  `maintain_id` int(11) NOT NULL AUTO_INCREMENT,
  `asset_no` varchar(20) NOT NULL,
  `maintaintype_id` int(11) NOT NULL,
  `maintain_date` date NOT NULL,
  `user_id` int(11) NOT NULL,
  `maintain_descripti` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`maintain_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_assetmaintain
-- ----------------------------
INSERT INTO `tb_assetmaintain` VALUES ('1', 'A20170901', '1', '2017-11-09', '2', '12331');
INSERT INTO `tb_assetmaintain` VALUES ('2', 'A20170901', '2', '2018-05-15', '39', '升级病毒库');

-- ----------------------------
-- Table structure for tb_assettype
-- ----------------------------
DROP TABLE IF EXISTS `tb_assettype`;
CREATE TABLE `tb_assettype` (
  `assettype_id` int(11) NOT NULL AUTO_INCREMENT,
  `assettype_name` varchar(50) NOT NULL,
  `assettype_date` date NOT NULL,
  `assettype_descripti` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`assettype_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_assettype
-- ----------------------------
INSERT INTO `tb_assettype` VALUES ('1', '电子产品', '2017-11-07', '电子科技产品');
INSERT INTO `tb_assettype` VALUES ('2', '办公设备', '2017-11-06', '办公使用设备');
INSERT INTO `tb_assettype` VALUES ('3', '办公用品', '2017-11-07', '上班用的物品');

-- ----------------------------
-- Table structure for tb_department
-- ----------------------------
DROP TABLE IF EXISTS `tb_department`;
CREATE TABLE `tb_department` (
  `dept_id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_number` varchar(30) DEFAULT NULL,
  `dept_name` varchar(30) NOT NULL,
  `dept_DESCRIPTI` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_department
-- ----------------------------
INSERT INTO `tb_department` VALUES ('0', 'dep000', '超级管理员(系统专用)', '超级管理员，该部门为系统专用');
INSERT INTO `tb_department` VALUES ('1', 'dep001', '董事会', '董事会董事');
INSERT INTO `tb_department` VALUES ('2', 'dep002', '总经办', '总经理办公室');
INSERT INTO `tb_department` VALUES ('3', 'dep003', '客服部', '客服部：负责企业客服');
INSERT INTO `tb_department` VALUES ('4', 'dep004', '技术部', '技术部：负责企业技术');
INSERT INTO `tb_department` VALUES ('5', 'dep005', '市场部', '市场部：负责市场');
INSERT INTO `tb_department` VALUES ('6', 'dep006', '财务部', '财务部：负责企业财务');
INSERT INTO `tb_department` VALUES ('7', 'dep007', '人事部', '人事部：负责企业人事');
INSERT INTO `tb_department` VALUES ('8', 'dep008', '安保部', '安保部：负责企业安保');
INSERT INTO `tb_department` VALUES ('9', 'dep009', '秘书处', '秘书处：企业秘书');

-- ----------------------------
-- Table structure for tb_emplyee
-- ----------------------------
DROP TABLE IF EXISTS `tb_emplyee`;
CREATE TABLE `tb_emplyee` (
  `emp_id` int(10) NOT NULL AUTO_INCREMENT,
  `emp_number` varchar(12) NOT NULL,
  `emp_name` varchar(30) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `emp_sex` char(2) NOT NULL,
  `emp_brithday` date NOT NULL,
  `pos_id` int(11) NOT NULL,
  `dept_id` int(11) NOT NULL,
  `emp_salary` double NOT NULL,
  `emp_telephone` varchar(20) DEFAULT NULL,
  `emp_address` varchar(50) DEFAULT NULL,
  `emp_entrydate` date NOT NULL,
  `marutakstatus` int(11) NOT NULL,
  `emp_photourl` varchar(100) NOT NULL,
  `emp_age` int(11) DEFAULT NULL,
  PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=109 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_emplyee
-- ----------------------------
INSERT INTO `tb_emplyee` VALUES ('0', 'emp000', '超级管理员', '0', '男', '2000-01-01', '0', '0', '5555', '18888888888', '郑州二七区紫荆山南路', '2017-04-01', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('1', 'emp001', '陈正章', '1', '男', '2000-01-02', '1', '1', '8000', '18899880001', '郑州二七区紫荆山南路001号', '2017-04-02', '0', '/images/1 (2).jpg', '18');
INSERT INTO `tb_emplyee` VALUES ('2', 'emp002', '曲伟', '2', '男', '2000-01-03', '2', '1', '7000', '18899880002', '郑州二七区紫荆山南路002号', '2017-04-03', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('3', 'emp003', '杨昊', '3', '男', '2000-01-04', '2', '1', '8888', '18899880003', '郑州二七区紫荆山南路003号', '2017-04-04', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('4', 'emp004', '庄海蕴', '4', '女', '2000-01-05', '2', '1', '100000', '18899880004', '郑州二七区紫荆山南路004号', '2017-04-05', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('5', 'emp005', '冯与声', '5', '女', '2000-01-06', '3', '2', '200000', '18899880005', '郑州二七区紫荆山南路005号', '2017-04-06', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('6', 'emp006', '谭亚兰', '6', '女', '2000-01-07', '4', '2', '2000000', '18899880006', '郑州二七区紫荆山南路006号', '2017-04-07', '0', '/images/1 (2).jpg', '18');
INSERT INTO `tb_emplyee` VALUES ('7', 'emp007', '马瑞晗', '7', '女', '2000-01-08', '4', '2', '9654', '18899880007', '郑州二七区紫荆山南路007号', '2017-04-08', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('8', 'emp008', '苏莹', '8', '女', '2000-01-09', '5', '3', '400000', '18899880008', '郑州二七区紫荆山南路008号', '2017-04-09', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('9', 'emp009', '赵燕', '9', '女', '2000-01-10', '5', '4', '8000', '18899880009', '郑州二七区紫荆山南路009号', '2017-04-10', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('10', 'emp010', '敖苠鑫', '10', '男', '2000-01-11', '5', '5', '5000', '18899880010', '郑州二七区紫荆山南路010号', '2017-04-11', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('11', 'emp011', '喻皇', '11', '女', '2000-01-12', '5', '6', '8000', '18899880011', '郑州二七区紫荆山南路011号', '2017-04-12', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('12', 'emp012', '刘宽', '12', '男', '2000-01-13', '5', '7', '7000', '18899880012', '郑州二七区紫荆山南路012号', '2017-04-13', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('13', 'emp013', '唐林轩', '13', '男', '2000-01-14', '5', '8', '8888', '18899880013', '郑州二七区紫荆山南路013号', '2017-04-14', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('14', 'emp014', '李中昱', '14', '男', '2000-01-15', '6', '3', '100000', '18899880014', '郑州二七区紫荆山南路014号', '2017-04-15', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('15', 'emp015', '周培', '15', '男', '2000-01-16', '6', '4', '200000', '18899880015', '郑州二七区紫荆山南路015号', '2017-04-16', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('16', 'emp016', '钱太宝', '16', '男', '2000-01-17', '6', '5', '2000000', '18899880016', '郑州二七区紫荆山南路016号', '2017-04-17', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('17', 'emp017', '赵前', '17', '男', '2000-01-18', '6', '6', '9654', '18899880017', '郑州二七区紫荆山南路017号', '2017-04-18', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('18', 'emp018', '郭景洋', '18', '男', '2000-01-19', '6', '7', '400000', '18899880018', '郑州二七区紫荆山南路018号', '2017-04-19', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('19', 'emp019', '黄贺方', '19', '女', '2000-01-20', '6', '8', '8000', '18899880019', '郑州二七区紫荆山南路019号', '2017-04-20', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('20', 'emp020', '朱敏', '20', '女', '2000-01-21', '6', '9', '5000', '18899880020', '郑州二七区紫荆山南路020号', '2017-04-21', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('21', 'emp021', '王文美', '21', '女', '2000-01-22', '6', '3', '8000', '18899880021', '郑州二七区紫荆山南路021号', '2017-04-22', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('22', 'emp022', '郭晖', '22', '女', '2000-01-23', '6', '4', '7000', '18899880022', '郑州二七区紫荆山南路022号', '2017-04-23', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('23', 'emp023', '樊珊珊', '23', '女', '2000-01-24', '6', '5', '8888', '18899880023', '郑州二七区紫荆山南路023号', '2017-04-24', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('24', 'emp024', '张玮', '24', '男', '2000-01-25', '6', '6', '100000', '18899880024', '郑州二七区紫荆山南路024号', '2017-04-25', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('25', 'emp025', '徐超', '25', '女', '2000-01-26', '6', '7', '200000', '18899880025', '郑州二七区紫荆山南路025号', '2017-04-26', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('26', 'emp026', '师庆玲', '26', '女', '2000-01-27', '6', '8', '2000000', '18899880026', '郑州二七区紫荆山南路026号', '2017-04-27', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('27', 'emp027', '蔡诗宇', '27', '女', '2000-01-28', '6', '3', '9654', '18899880027', '郑州二七区紫荆山南路027号', '2017-04-28', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('28', 'emp028', '张庭溪', '28', '男', '2000-01-29', '6', '4', '400000', '18899880028', '郑州二七区紫荆山南路028号', '2017-04-29', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('29', 'emp029', '刘小凡', '29', '男', '2000-01-30', '6', '5', '8000', '18899880029', '郑州二七区紫荆山南路029号', '2017-04-30', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('30', 'emp030', '宋昱辰', '30', '男', '2000-01-31', '6', '6', '5000', '18899880030', '郑州二七区紫荆山南路030号', '2017-05-01', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('31', 'emp031', '曾畅', '31', '男', '2000-02-01', '6', '7', '8000', '18899880031', '郑州二七区紫荆山南路031号', '2017-05-02', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('32', 'emp032', '王庚', '32', '男', '2000-02-02', '6', '8', '7000', '18899880032', '郑州二七区紫荆山南路032号', '2017-05-03', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('33', 'emp033', '纪晟', '33', '男', '2000-02-03', '6', '3', '8888', '18899880033', '郑州二七区紫荆山南路033号', '2017-05-04', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('34', 'emp034', '管亚伟', '34', '男', '2000-02-04', '6', '4', '100000', '18899880034', '郑州二七区紫荆山南路034号', '2017-05-05', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('35', 'emp035', '叶阳阳', '35', '男', '2000-02-05', '6', '5', '200000', '18899880035', '郑州二七区紫荆山南路035号', '2017-05-06', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('36', 'emp036', '李成泰', '36', '男', '2000-02-06', '6', '6', '9654', '18899880036', '郑州二七区紫荆山南路036号', '2017-05-07', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('37', 'emp037', '王婷婷', '37', '女', '2000-02-07', '6', '7', '400000', '18899880037', '郑州二七区紫荆山南路037号', '2017-05-08', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('38', 'emp038', '吕畅鸿', '38', '女', '2000-02-08', '6', '8', '8000', '18899880038', '郑州二七区紫荆山南路038号', '2017-05-09', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('39', 'emp039', '邓冰洁', '39', '女', '2000-02-09', '7', '3', '5000', '18899880039', '郑州二七区紫荆山南路039号', '2017-05-10', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('40', 'emp040', '彭黄培', '40', '男', '2000-02-10', '8', '3', '8000', '18899880040', '郑州二七区紫荆山南路040号', '2017-05-11', '0', '/images/default-head.png', '18');
INSERT INTO `tb_emplyee` VALUES ('41', 'emp041', '许馨尹', '41', '女', '2000-02-11', '9', '3', '7000', '18899880041', '郑州二七区紫荆山南路041号', '2017-05-12', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('42', 'emp042', '朱学佩', '42', '女', '2000-02-12', '7', '3', '8888', '18899880042', '郑州二七区紫荆山南路042号', '2017-05-13', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('43', 'emp043', '薄览', '43', '女', '2000-02-13', '8', '3', '100000', '18899880043', '郑州二七区紫荆山南路043号', '2017-05-14', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('44', 'emp044', '孙文君', '44', '女', '2000-02-14', '9', '3', '200000', '18899880044', '郑州二七区紫荆山南路044号', '2017-05-15', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('45', 'emp045', '施文君', '45', '女', '2000-02-15', '7', '3', '2000000', '18899880045', '郑州二七区紫荆山南路045号', '2017-05-16', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('46', 'emp046', '胡凌翔', '46', '男', '2000-02-16', '8', '3', '9654', '18899880046', '郑州二七区紫荆山南路046号', '2017-05-17', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('47', 'emp047', '胡洋', '47', '男', '2000-02-17', '9', '3', '400000', '18899880047', '郑州二七区紫荆山南路047号', '2017-05-18', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('48', 'emp048', '梅泽文', '48', '男', '2000-02-18', '7', '3', '8000', '18899880048', '郑州二七区紫荆山南路048号', '2017-05-19', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('49', 'emp049', '王庆庆', '49', '女', '2000-02-19', '8', '3', '5000', '18899880049', '郑州二七区紫荆山南路049号', '2017-05-20', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('50', 'emp050', '赵丹', '50', '男', '2000-02-20', '9', '3', '8000', '18899880050', '郑州二七区紫荆山南路050号', '2017-05-21', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('51', 'emp051', '丁绪辉', '51', '男', '2000-02-21', '7', '3', '9654', '18899880051', '郑州二七区紫荆山南路051号', '2017-05-22', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('52', 'emp052', '苍丹', '52', '女', '2000-02-22', '8', '3', '400000', '18899880052', '郑州二七区紫荆山南路052号', '2017-05-23', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('53', 'emp053', '于航', '53', '女', '2000-02-23', '9', '3', '8000', '18899880053', '郑州二七区紫荆山南路053号', '2017-05-24', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('54', 'emp054', '陈炯尧', '54', '男', '2000-02-24', '10', '4', '5000', '18899880054', '郑州二七区紫荆山南路054号', '2017-05-25', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('55', 'emp055', '单蒙', '55', '男', '2000-02-25', '11', '4', '8000', '18899880055', '郑州二七区紫荆山南路055号', '2017-05-26', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('56', 'emp056', '张玉婷', '56', '女', '2000-02-26', '12', '4', '7000', '18899880056', '郑州二七区紫荆山南路056号', '2017-05-27', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('57', 'emp057', '王非', '57', '女', '2000-02-27', '10', '4', '8888', '18899880057', '郑州二七区紫荆山南路057号', '2017-05-28', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('58', 'emp058', '王越贞', '58', '女', '2000-02-28', '11', '4', '100000', '18899880058', '郑州二七区紫荆山南路058号', '2017-05-29', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('59', 'emp059', '张权', '59', '男', '2000-02-29', '12', '4', '200000', '18899880059', '郑州二七区紫荆山南路059号', '2017-05-30', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('60', 'emp060', '陈祯', '60', '女', '2000-03-01', '10', '4', '9654', '18899880060', '郑州二七区紫荆山南路060号', '2017-05-31', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('61', 'emp061', '宋海青', '61', '女', '2000-03-02', '11', '4', '400000', '18899880061', '郑州二七区紫荆山南路061号', '2017-06-01', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('62', 'emp062', '肖荣强', '62', '男', '2000-03-03', '12', '4', '8000', '18899880062', '郑州二七区紫荆山南路062号', '2017-06-02', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('63', 'emp063', '徐超', '63', '男', '2000-03-04', '10', '4', '5000', '18899880063', '郑州二七区紫荆山南路063号', '2017-06-03', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('64', 'emp064', '许鹏飞', '64', '男', '2000-03-05', '11', '4', '8888', '18899880064', '郑州二七区紫荆山南路064号', '2017-06-04', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('65', 'emp065', '鲍希琰', '65', '女', '2000-03-06', '12', '4', '100000', '18899880065', '郑州二七区紫荆山南路065号', '2017-06-05', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('66', 'emp066', '李双龙', '66', '男', '2000-03-07', '13', '5', '200000', '18899880066', '郑州二七区紫荆山南路066号', '2017-06-06', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('67', 'emp067', '顾一春', '67', '男', '2000-03-08', '14', '5', '2000000', '18899880067', '郑州二七区紫荆山南路067号', '2017-06-07', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('68', 'emp068', '栾开元', '68', '男', '2000-03-09', '15', '5', '9654', '18899880068', '郑州二七区紫荆山南路068号', '2017-06-08', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('69', 'emp069', '徐刚', '69', '男', '2000-03-10', '13', '5', '400000', '18899880069', '郑州二七区紫荆山南路069号', '2017-06-09', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('70', 'emp070', '赵飞', '70', '男', '2000-03-11', '14', '5', '8000', '18899880070', '郑州二七区紫荆山南路070号', '2017-06-10', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('71', 'emp071', '张玥', '71', '女', '2000-03-12', '15', '5', '5000', '18899880071', '郑州二七区紫荆山南路071号', '2017-06-11', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('72', 'emp072', '严景艺', '72', '女', '2000-03-13', '13', '5', '8000', '18899880072', '郑州二七区紫荆山南路072号', '2017-06-12', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('73', 'emp073', '吴茜', '73', '女', '2000-03-14', '14', '5', '7000', '18899880073', '郑州二七区紫荆山南路073号', '2017-06-13', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('74', 'emp074', '杨晔霏', '74', '女', '2000-03-15', '15', '5', '8888', '18899880074', '郑州二七区紫荆山南路074号', '2017-06-14', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('75', 'emp075', '朱永彤', '75', '女', '2000-03-16', '13', '5', '100000', '18899880075', '郑州二七区紫荆山南路075号', '2017-06-15', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('76', 'emp076', '徐梦真', '76', '女', '2000-03-17', '14', '5', '200000', '18899880076', '郑州二七区紫荆山南路076号', '2017-06-16', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('77', 'emp077', '狄悬悬', '77', '男', '2000-03-18', '15', '5', '9654', '18899880077', '郑州二七区紫荆山南路077号', '2017-06-17', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('78', 'emp078', '王书文', '78', '男', '2000-03-19', '16', '6', '400000', '18899880078', '郑州二七区紫荆山南路078号', '2017-06-18', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('79', 'emp079', '韩会平', '79', '女', '2000-03-20', '17', '6', '8000', '18899880079', '郑州二七区紫荆山南路079号', '2017-06-19', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('80', 'emp080', '马宁', '80', '女', '2000-03-21', '18', '6', '5000', '18899880080', '郑州二七区紫荆山南路080号', '2017-06-20', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('81', 'emp081', '柳润涛', '81', '男', '2000-03-22', '19', '6', '8000', '18899880081', '郑州二七区紫荆山南路081号', '2017-06-21', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('82', 'emp082', '刘洋', '82', '男', '2000-03-23', '16', '6', '7000', '18899880082', '郑州二七区紫荆山南路082号', '2017-06-22', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('83', 'emp083', '朱福辉', '83', '男', '2000-03-24', '17', '6', '8888', '18899880083', '郑州二七区紫荆山南路083号', '2017-06-23', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('84', 'emp084', '周小莉', '84', '女', '2000-03-25', '18', '6', '100000', '18899880084', '郑州二七区紫荆山南路084号', '2017-06-24', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('85', 'emp085', '章忻玥', '85', '女', '2000-03-26', '19', '6', '200000', '18899880085', '郑州二七区紫荆山南路085号', '2017-06-25', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('86', 'emp086', '顾昱晖', '86', '男', '2000-03-27', '20', '7', '2000000', '18899880086', '郑州二七区紫荆山南路086号', '2017-06-26', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('87', 'emp087', '李胜', '87', '男', '2000-03-28', '21', '7', '9654', '18899880087', '郑州二七区紫荆山南路087号', '2017-06-27', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('88', 'emp088', '郑菁', '88', '女', '2000-03-29', '22', '7', '400000', '18899880088', '郑州二七区紫荆山南路088号', '2017-06-28', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('89', 'emp089', '潘宗慧', '89', '女', '2000-03-30', '20', '7', '8000', '18899880089', '郑州二七区紫荆山南路089号', '2017-06-29', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('90', 'emp090', '朱燕萍', '90', '女', '2000-03-31', '21', '7', '8888', '18899880090', '郑州二七区紫荆山南路090号', '2017-06-30', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('91', 'emp091', '邹献', '91', '男', '2000-04-01', '22', '7', '8889', '18899880091', '郑州二七区紫荆山南路091号', '2017-07-01', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('92', 'emp092', '李玮玮', '92', '女', '2000-04-02', '20', '7', '8890', '18899880092', '郑州二七区紫荆山南路092号', '2017-07-02', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('93', 'emp093', '彭献龙', '93', '男', '2000-04-03', '21', '7', '8891', '18899880093', '郑州二七区紫荆山南路093号', '2017-07-03', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('94', 'emp094', '李明', '94', '男', '2000-04-04', '22', '7', '8892', '18899880094', '郑州二七区紫荆山南路094号', '2017-07-04', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('95', 'emp095', '曹国生', '95', '男', '2000-04-05', '20', '7', '8893', '18899880095', '郑州二七区紫荆山南路095号', '2017-07-05', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('96', 'emp096', '李兰兰', '96', '女', '2000-04-06', '21', '7', '8894', '18899880096', '郑州二七区紫荆山南路096号', '2017-07-06', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('97', 'emp097', '高云燕', '97', '女', '2000-04-07', '22', '7', '8895', '18899880097', '郑州二七区紫荆山南路097号', '2017-07-07', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('98', 'emp098', '沈永生', '98', '男', '2000-04-08', '23', '8', '8896', '18899880098', '郑州二七区紫荆山南路098号', '2017-07-08', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('99', 'emp099', '白帆', '99', '男', '2000-04-09', '23', '8', '8897', '18899880099', '郑州二七区紫荆山南路099号', '2017-07-09', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('100', 'emp100', '刘鑫', '100', '男', '2000-04-10', '23', '8', '8898', '18899880100', '郑州二七区紫荆山南路100号', '2017-07-10', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('101', 'emp101', '王康', '101', '男', '2000-04-11', '23', '8', '8899', '18899880101', '郑州二七区紫荆山南路101号', '2017-07-11', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('102', 'emp102', '李兆伟', '102', '男', '2000-04-12', '23', '8', '8900', '18899880102', '郑州二七区紫荆山南路102号', '2017-07-12', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('103', 'emp103', '傅英明', '103', '男', '2000-04-13', '23', '8', '8901', '18899880103', '郑州二七区紫荆山南路103号', '2017-07-13', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('104', 'emp104', '孙震', '104', '男', '2000-04-14', '23', '8', '8902', '18899880104', '郑州二七区紫荆山南路104号', '2017-07-14', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('105', 'emp105', '蔡鹏飞', '105', '男', '2000-04-15', '23', '8', '8903', '18899880105', '郑州二七区紫荆山南路105号', '2017-07-15', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('106', 'emp106', '泠惠', '106', '男', '2000-04-16', '24', '9', '8904', '18899880106', '郑州二七区紫荆山南路106号', '2017-07-16', '0', '/images/default-head.png', '18');
INSERT INTO `tb_emplyee` VALUES ('107', 'emp107', '曾叶凤', '107', '女', '2000-04-17', '24', '9', '8905', '18899880107', '郑州二七区紫荆山南路107号', '2017-07-17', '0', '0', '18');
INSERT INTO `tb_emplyee` VALUES ('108', 'emp108', '庄伟伟', '108', '女', '2000-04-18', '24', '9', '8906', '18899880108', '郑州二七区紫荆山南路108号', '2017-07-18', '0', '0', '18');

-- ----------------------------
-- Table structure for tb_evection
-- ----------------------------
DROP TABLE IF EXISTS `tb_evection`;
CREATE TABLE `tb_evection` (
  `ev_id` int(11) NOT NULL AUTO_INCREMENT,
  `date_ev` date NOT NULL,
  `time_ev` int(11) NOT NULL,
  `cuse_ev` text NOT NULL,
  `cost_ev` int(11) NOT NULL,
  `emp_id` int(11) NOT NULL,
  PRIMARY KEY (`ev_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_evection
-- ----------------------------
INSERT INTO `tb_evection` VALUES ('1', '2017-11-30', '2', '学习', '300', '1');
INSERT INTO `tb_evection` VALUES ('2', '2017-11-08', '3', '调研', '200', '25');
INSERT INTO `tb_evection` VALUES ('3', '2017-11-21', '3', '学习', '600', '38');
INSERT INTO `tb_evection` VALUES ('4', '2017-10-11', '3', '调研', '500', '46');
INSERT INTO `tb_evection` VALUES ('5', '2017-10-10', '7', '学习', '200', '66');
INSERT INTO `tb_evection` VALUES ('6', '2018-05-03', '10', '业务指导', '100', '39');
INSERT INTO `tb_evection` VALUES ('7', '2018-05-10', '2', '总部开会', '200', '39');

-- ----------------------------
-- Table structure for tb_flow_instance
-- ----------------------------
DROP TABLE IF EXISTS `tb_flow_instance`;
CREATE TABLE `tb_flow_instance` (
  `flow_instance_id` int(11) NOT NULL AUTO_INCREMENT,
  `flow_instance_name` varchar(100) DEFAULT NULL,
  `create_user_id` int(11) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `finish_date` date DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `official_id` int(11) DEFAULT NULL,
  `flow_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`flow_instance_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_flow_instance
-- ----------------------------
INSERT INTO `tb_flow_instance` VALUES ('13', '节假日活动庆典实例', '39', '2018-05-14', null, '0', '13', '22');
INSERT INTO `tb_flow_instance` VALUES ('14', '公司节日活动实例', '39', '2018-05-14', null, '0', '14', '23');
INSERT INTO `tb_flow_instance` VALUES ('15', '公司庆典实例', '39', '2018-05-14', null, '0', '15', '24');
INSERT INTO `tb_flow_instance` VALUES ('16', '团队聚会实例', '39', '2018-05-14', null, '0', '16', '25');
INSERT INTO `tb_flow_instance` VALUES ('17', '项目申报实例', '39', '2018-05-14', null, '0', '17', '26');
INSERT INTO `tb_flow_instance` VALUES ('18', '报销单实例', '39', '2018-05-14', null, '0', '18', '27');
INSERT INTO `tb_flow_instance` VALUES ('19', '请假单实例', '39', '2018-05-14', null, '0', '19', '28');

-- ----------------------------
-- Table structure for tb_flow_link
-- ----------------------------
DROP TABLE IF EXISTS `tb_flow_link`;
CREATE TABLE `tb_flow_link` (
  `flow_link_id` int(11) NOT NULL AUTO_INCREMENT,
  `from_step` int(11) DEFAULT NULL,
  `to_step1` int(11) DEFAULT NULL,
  `to_step2` int(11) DEFAULT NULL,
  `to_step3` int(11) DEFAULT NULL,
  `to_step4` int(11) DEFAULT NULL,
  `flow_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`flow_link_id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_flow_link
-- ----------------------------
INSERT INTO `tb_flow_link` VALUES ('53', '1', '2', '3', '4', '5', '22');
INSERT INTO `tb_flow_link` VALUES ('54', '5', '6', '7', '-1', '-1', '22');
INSERT INTO `tb_flow_link` VALUES ('55', '1', '2', '3', '4', '5', '23');
INSERT INTO `tb_flow_link` VALUES ('56', '5', '6', '-1', '-1', '-1', '23');
INSERT INTO `tb_flow_link` VALUES ('57', '7', '-1', '-1', '-1', '-1', '23');
INSERT INTO `tb_flow_link` VALUES ('58', '1', '2', '3', '4', '5', '24');
INSERT INTO `tb_flow_link` VALUES ('59', '7', '6', '7', '-1', '-1', '24');
INSERT INTO `tb_flow_link` VALUES ('60', '7', '-1', '-1', '-1', '-1', '24');
INSERT INTO `tb_flow_link` VALUES ('61', '1', '2', '3', '4', '5', '25');
INSERT INTO `tb_flow_link` VALUES ('62', '7', '6', '-1', '-1', '-1', '25');
INSERT INTO `tb_flow_link` VALUES ('63', '7', '-1', '-1', '-1', '-1', '25');
INSERT INTO `tb_flow_link` VALUES ('64', '1', '2', '3', '4', '5', '26');
INSERT INTO `tb_flow_link` VALUES ('65', '5', '6', '-1', '-1', '7', '26');
INSERT INTO `tb_flow_link` VALUES ('66', '1', '2', '3', '4', '5', '27');
INSERT INTO `tb_flow_link` VALUES ('67', '5', '6', '7', '7', '7', '27');
INSERT INTO `tb_flow_link` VALUES ('68', '1', '2', '3', '5', '7', '28');

-- ----------------------------
-- Table structure for tb_flow_template
-- ----------------------------
DROP TABLE IF EXISTS `tb_flow_template`;
CREATE TABLE `tb_flow_template` (
  `flow_id` int(11) NOT NULL AUTO_INCREMENT,
  `flow_name` varchar(50) DEFAULT NULL,
  `flow_type_id` varchar(50) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `modify_user_id` int(11) DEFAULT NULL,
  `modify_date` date DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`flow_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_flow_template
-- ----------------------------
INSERT INTO `tb_flow_template` VALUES ('22', '节假日活动庆典', '5', '1', '2018-05-14', null, null, '1');
INSERT INTO `tb_flow_template` VALUES ('23', '公司节日活动', '5', '1', '2018-05-14', null, null, '1');
INSERT INTO `tb_flow_template` VALUES ('24', '公司庆典', '5', '1', '2018-05-14', null, null, '1');
INSERT INTO `tb_flow_template` VALUES ('25', '团队聚会', '5', '1', '2018-05-14', null, null, '1');
INSERT INTO `tb_flow_template` VALUES ('26', '项目申报', '4', '1', '2018-05-14', null, null, '1');
INSERT INTO `tb_flow_template` VALUES ('27', '报销单', '2', '1', '2018-05-14', null, null, '1');
INSERT INTO `tb_flow_template` VALUES ('28', '请假单', '1', '1', '2018-05-14', null, null, '1');

-- ----------------------------
-- Table structure for tb_flow_type
-- ----------------------------
DROP TABLE IF EXISTS `tb_flow_type`;
CREATE TABLE `tb_flow_type` (
  `flow_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `flow_type_name` varchar(50) DEFAULT NULL,
  `flow_description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`flow_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_flow_type
-- ----------------------------
INSERT INTO `tb_flow_type` VALUES ('1', '休假流程', '休假流程，请假调休');
INSERT INTO `tb_flow_type` VALUES ('2', '报销流程', '报销流程，各种报销');
INSERT INTO `tb_flow_type` VALUES ('3', '离职流程', '离职流程，离职辞职');
INSERT INTO `tb_flow_type` VALUES ('4', '项目审批', '公司项目审批流程');
INSERT INTO `tb_flow_type` VALUES ('5', '活动审批', '公司活动审批');

-- ----------------------------
-- Table structure for tb_fortifytype
-- ----------------------------
DROP TABLE IF EXISTS `tb_fortifytype`;
CREATE TABLE `tb_fortifytype` (
  `fortifytype_id` int(11) NOT NULL AUTO_INCREMENT,
  `fortifytype_name` varchar(50) NOT NULL,
  `fortifytype_date` date NOT NULL,
  `fortifytype_descripti` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`fortifytype_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_fortifytype
-- ----------------------------
INSERT INTO `tb_fortifytype` VALUES ('1', '购入不需要安装的固定资产', '2017-11-07', '直接使用不用安装');
INSERT INTO `tb_fortifytype` VALUES ('2', '购入需要安装已完工的固定资产', '2017-11-07', '直接使用不用安装');
INSERT INTO `tb_fortifytype` VALUES ('3', '其他单位转入的固定资产（新设备）', '2017-11-07', '新设备');
INSERT INTO `tb_fortifytype` VALUES ('4', '其他单位转入的固定资产（旧设备）', '2017-11-07', '旧设备');
INSERT INTO `tb_fortifytype` VALUES ('5', '捐赠的固定资产', '2017-11-07', '捐赠的');
INSERT INTO `tb_fortifytype` VALUES ('6', '融资租赁的固定资产', '2017-11-07', '融资租赁');

-- ----------------------------
-- Table structure for tb_function
-- ----------------------------
DROP TABLE IF EXISTS `tb_function`;
CREATE TABLE `tb_function` (
  `fun_id` int(11) NOT NULL AUTO_INCREMENT,
  `fun_name` varchar(30) NOT NULL,
  `fun_url` varchar(30) NOT NULL,
  `fun_forbidden` int(11) NOT NULL,
  `fun_descripti` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`fun_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_function
-- ----------------------------
INSERT INTO `tb_function` VALUES ('1', '编辑', 'redact', '0', '用于数据的增删改');
INSERT INTO `tb_function` VALUES ('2', '保存word文档', 'buildWord', '0', '插入并返回主键');
INSERT INTO `tb_function` VALUES ('3', '公文管理', 'officialCommitDeleteApprove', '0', '添加审批记录');
INSERT INTO `tb_function` VALUES ('4', '添加公文', 'officialAdd', '0', '添加公文');
INSERT INTO `tb_function` VALUES ('5', '添加流程步骤', 'addWorkFlow', '0', '批量插入流程步骤');
INSERT INTO `tb_function` VALUES ('6', '删除流程', 'deleteWorkFlow', '0', '删除');
INSERT INTO `tb_function` VALUES ('7', '我的日程', 'mySchedule', '0', '我的日程');
INSERT INTO `tb_function` VALUES ('8', '授权', 'impower', '0', '授权');

-- ----------------------------
-- Table structure for tb_inbox
-- ----------------------------
DROP TABLE IF EXISTS `tb_inbox`;
CREATE TABLE `tb_inbox` (
  `receive_id` int(11) NOT NULL AUTO_INCREMENT,
  `inbox_senderId` int(11) NOT NULL,
  `inbox_receiverId` int(11) NOT NULL,
  `inbox_title` varchar(50) NOT NULL,
  `inbox_date` date NOT NULL,
  `receive_state` int(11) NOT NULL,
  `inbox_content` text,
  `email_state` int(11) NOT NULL,
  PRIMARY KEY (`receive_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_inbox
-- ----------------------------

-- ----------------------------
-- Table structure for tb_leave
-- ----------------------------
DROP TABLE IF EXISTS `tb_leave`;
CREATE TABLE `tb_leave` (
  `le_id` int(11) NOT NULL AUTO_INCREMENT,
  `date_le` date NOT NULL,
  `time_le` int(11) NOT NULL,
  `cuse_le` varchar(255) NOT NULL,
  `emp_id` int(11) NOT NULL,
  PRIMARY KEY (`le_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='InnoDB free: 11264 kB';

-- ----------------------------
-- Records of tb_leave
-- ----------------------------
INSERT INTO `tb_leave` VALUES ('1', '2017-09-01', '5', '私事', '58');
INSERT INTO `tb_leave` VALUES ('2', '2017-10-01', '7', '私事', '23');
INSERT INTO `tb_leave` VALUES ('3', '2017-10-10', '5', '私事', '46');
INSERT INTO `tb_leave` VALUES ('4', '2017-10-13', '5', '私事', '15');
INSERT INTO `tb_leave` VALUES ('5', '2017-10-18', '6', '私事', '9');
INSERT INTO `tb_leave` VALUES ('6', '2017-11-24', '4', '私事', '33');
INSERT INTO `tb_leave` VALUES ('7', '2017-12-10', '3', '家里有事', '2');
INSERT INTO `tb_leave` VALUES ('8', '2018-05-14', '1', '过过肉瘾', '39');

-- ----------------------------
-- Table structure for tb_mail
-- ----------------------------
DROP TABLE IF EXISTS `tb_mail`;
CREATE TABLE `tb_mail` (
  `mailId` int(11) NOT NULL AUTO_INCREMENT,
  `sender` varchar(50) DEFAULT NULL,
  `reveicer` varchar(100) DEFAULT NULL,
  `sereveicer` varchar(100) DEFAULT NULL,
  `anreveicer` varchar(100) DEFAULT NULL,
  `subject` varchar(1000) DEFAULT NULL,
  `content` varchar(2000) DEFAULT NULL,
  `time` varchar(100) DEFAULT NULL,
  `attachment` varchar(100) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `mtype` int(11) DEFAULT NULL,
  PRIMARY KEY (`mailId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_mail
-- ----------------------------
INSERT INTO `tb_mail` VALUES ('1', '小明', 'duhu,px,zsm,cyj', '无', '无', '群发测试', '<p>测试中</p>\r\n', '2017年11月16日 星期四 21:19 ', 'userface1.jpg', null, '0');
INSERT INTO `tb_mail` VALUES ('7', 'jingli', 'dongshiz2', '无', '无', '你好', '<p>你好</p>\r\n', '2017年12月01日 星期五 15:44 ', '', null, '0');
INSERT INTO `tb_mail` VALUES ('8', '超级管理员', 'dsz,zjl,kfbjl,kfbzg1,kfbyg1', 'root', '无', '邮件测试20180501', '<p>POP3/IMAP/SMTP/Exchange/CardDAV/CalDAV服务</p>\r\n\r\n<p>开启服务：</p>\r\n\r\n<p>POP3/SMTP服务&nbsp;(<a href=\"http://service.mail.qq.com/cgi-bin/help?subtype=1&amp;&amp;id=28&amp;&amp;no=371\" target=\"_blank\">如何使用 Foxmail 等软件收发邮件？</a>)</p>\r\n\r\n<p>已开启&nbsp;|&nbsp;&nbsp;关闭</p>\r\n\r\n<p>IMAP/SMTP服务&nbsp;(<a href=\"http://service.mail.qq.com/cgi-bin/help?subtype=1&amp;&amp;id=28&amp;&amp;no=331\" target=\"_blank\">什么是 IMAP，它又是如何设置？</a>)</p>\r\n\r\n<p>已开启&nbsp;|&nbsp;&nbsp;关闭</p>\r\n\r\n<p>Exchange服务&nbsp;(<a href=\"http://service.mail.qq.com/cgi-bin/help?id=20019\" target=\"_blank\">什么是Exchange，它又是如何设置？</a>)</p>\r\n\r\n<p>已关闭&nbsp;|&nbsp; 开启</p>\r\n\r\n<p>CardDAV/CalDAV服务&nbsp;(<a href=\"http://service.mail.qq.com/cgi-bin/help?subtype=1&amp;&amp;id=25&amp;&amp;no=1001024\" target=\"_blank\">什么是CardDAV/CalDAV，它又是如何设置？</a>)</p>\r\n\r\n<p>已关闭&nbsp;|&nbsp; 开启</p>\r\n\r\n<p>(POP3/IMAP/SMTP/CardDAV/CalDAV服务均支持SSL连接。<a href=\"http://service.mail.qq.com/cgi-bin/help?subtype=1&amp;&amp;id=28&amp;&amp;no=369\" target=\"_blank\">如何设置？</a>)</p>\r\n\r\n<p>温馨提示：登录第三方客户端时，密码框请输入&ldquo;授权码&rdquo;进行验证。生成授权码</p>\r\n', '2018年05月14日 星期一 12:52 ', '', null, '0');

-- ----------------------------
-- Table structure for tb_maintaintype
-- ----------------------------
DROP TABLE IF EXISTS `tb_maintaintype`;
CREATE TABLE `tb_maintaintype` (
  `maintaintype_id` int(11) NOT NULL AUTO_INCREMENT,
  `maintaintype_name` varchar(50) NOT NULL,
  `maintaintype_date` date NOT NULL,
  `maintaintype_descripti` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`maintaintype_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_maintaintype
-- ----------------------------
INSERT INTO `tb_maintaintype` VALUES ('1', '应急性', '2017-11-08', '急需维护时');
INSERT INTO `tb_maintaintype` VALUES ('2', '预防性', '2017-11-08', '预防机器故障');
INSERT INTO `tb_maintaintype` VALUES ('3', '针对性', '2017-11-08', '针对机器故障问题');

-- ----------------------------
-- Table structure for tb_official
-- ----------------------------
DROP TABLE IF EXISTS `tb_official`;
CREATE TABLE `tb_official` (
  `offi_id` int(11) NOT NULL AUTO_INCREMENT,
  `offi_name` varchar(30) DEFAULT NULL,
  `flow_id` int(11) DEFAULT NULL,
  `offi_date` date DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `offi_state` int(11) DEFAULT NULL,
  `accrssory_name` varchar(30) DEFAULT NULL,
  `offi_descripti` varchar(50) DEFAULT NULL,
  `accessory` mediumblob,
  PRIMARY KEY (`offi_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_official
-- ----------------------------
INSERT INTO `tb_official` VALUES ('13', '五一海南旅游', '22', '2018-05-14', '39', '1', '五一旅游策划书', '五一海南旅游策划书', 0xEFBFBDEFBFBD11E0A1B11AEFBFBD000000000000000000000000000000003E000300EFBFBDEFBFBD0900060000000000000000000000010000000100000000000000001000000200000001000000EFBFBDEFBFBDEFBFBDEFBFBD0000000000000000EFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBD0E000000EFBFBDEFBFBDEFBFBDEFBFBD0400000005000000060000000700000008000000090000000A0000000B0000000C0000000D0000000F000000EFBFBDEFBFBDEFBFBDEFBFBD10000000EFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBD52006F006F007400200045006E00740072007900000000000000000000000000000000000000000000000000000000000000000000000000000000000000000016000500EFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBD0200000000000000000000000000000000000000000000000000000000000000EFBFBD67EFBFBD5FEFBFBDEFBFBDEFBFBD01030000004019000000000000440061007400610000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000A000201EFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBD000000000000000000000000000000000000000000000000000000000000000000000000EFBFBDEFBFBDEFBFBDEFBFBD000000000000000030005400610062006C006500000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000E0002010100000004000000EFBFBDEFBFBDEFBFBDEFBFBD000000000000000000000000000000000000000000000000000000000000000000000000000000002E0700000000000057006F007200640044006F00630075006D0065006E007400000000000000000000000000000000000000000000000000000000000000000000000000000000001A000200EFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBD0000000000000000000000000000000000000000000000000000000000000000000000001D000000330E0000000000000100000002000000030000000400000005000000060000000700000008000000090000000A0000000B0000000C0000000D0000000E0000000F000000100000001100000012000000130000001400000015000000160000001700000018000000190000001A0000001B0000001C000000EFBFBDEFBFBDEFBFBDEFBFBD1E0000001F000000200000002100000022000000230000002400000025000000260000002700000028000000290000002A0000002B0000002C0000002D0000002E0000002F000000300000003100000032000000330000003400000035000000360000003700000038000000390000003A0000003B0000003C0000003D0000003E0000003F000000400000004100000042000000430000004400000045000000460000004700000048000000490000004A0000004B0000004C0000004D0000004E0000004F000000500000005100000052000000530000005400000055000000EFBFBDEFBFBDEFBFBDEFBFBD5700000058000000590000005A0000005B000000640000005D0000005E0000005F00000060000000610000006200000063000000EFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBD1400110012000100EFBFBD000F000400000001000000000046000060EFBFBDEFBFBD02004600000000000000000000000200636BEFBFBD6500000B000000612403032403312400001C00434A1500504A01004B4802006D480904734809046E4804087448040800000000000000000000000000000000000024004160EFBFBDEFBFBDEFBFBD002400000000000000000000000600D89EEFBFBDEFBFBDEFBFBD6B3DEFBFBD575B534F000000000000000000000000380020600100EFBFBD00380000000000000000000000020075EFBFBD1AEFBFBD000016000F006124000324004724000DEFBFBD0800023910722001020400434A1200EFBFBD001F6001000201EFBFBD0000000000000000000000020075EFBFBD09770000630010001264EFBFBD0001006124030324034724004026092464000000014EEFBFBD08000000EFBFBD000001002564000000044FEFBFBD08000000EFBFBD0000040026640000000150EFBFBD08000000EFBFBD0000010027640000000451EFBFBD08000000EFBFBD000004000DEFBFBD080002391072200102000C00434A12004F4A0000514A0000000800000208000005000000000800000208000006000000021000000000000000010000000000000800000000090000004716EFBFBD01000002020603050405020304EFBFBD7A0020000000EFBFBD0800000000000000EFBFBD01000000000000540069006D006500730020004E0065007700200052006F006D0061006E0000002D04EFBFBD01EFBFBD0002010600030101010101030000000000EFBFBD2806000000000000000100040000000000EFBFBD5B534F00003104EFBFBD01EFBFBD00020B0503020204020204EFBFBD0200EFBFBD523C0F2816000000000000001F00040000000000EFBFBD5F6FEFBFBDC596D19E00003514EFBFBD0102000505010201070602050700000000000000000000000000000000000000EFBFBD00000000530079006D0062006F006C0000003324EFBFBD010100020B0604020202020204EFBFBD2A00EFBFBD437800EFBFBD0900000000000000EFBFBD0100400000EFBFBDEFBFBD41007200690061006C0000002D04EFBFBD01EFBFBD0002010609060101010101EFBFBD0200EFBFBDEFBFBD7CEFBFBD3816000000000000000100040000000000D19E534F00003F34EFBFBD01010002070309020205020404EFBFBD2A00EFBFBD437800EFBFBD0900000000000000EFBFBD0100400000EFBFBDEFBFBD43006F007500720069006500720020004E006500770000003B04EFBFBD0102000500000000000000000000000000000000000000000000000000000000EFBFBD00000000570069006E006700640069006E006700730000003504EFBFBD010000020B0604030504040204EFBFBD2E00EFBFBD5B6000EFBFBD2900000000000000EFBFBD010120000028205400610068006F006D0061000000EFBFBDEFBFBD12000000000000000000000000000000000000000000000000000000000000000000000000000000200004000108EFBFBD180000EFBFBD01EFBFBD516801000000005E320667EFBFBDEFBFBD1447000000000100000000000000000000000000000000000000040003100000000000000000000000000100010000000100000000000000210300000000000003005A002600210029002C002E003A003B003F005D007D00EFBFBD00EFBFBD00EFBFBD02EFBFBD021520162019201D2026203622013002300330053009300B300D300F3011301530173001EFBFBD02EFBFBD07EFBFBD09EFBFBD0CEFBFBD0EEFBFBD1AEFBFBD1BEFBFBD1FEFBFBD3DEFBFBD40EFBFBD5CEFBFBD5DEFBFBD5EEFBFBDEFBFBDEFBFBD0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000028005B007B00EFBFBD0018201C2008300A300C300E3010301430163008EFBFBD0EEFBFBD3BEFBFBD5BEFBFBDEFBFBDEFBFBDEFBFBDEFBFBD000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000807EFBFBD05EFBFBD00EFBFBD0002EFBFBD00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000029EFBFBDEFBFBD0F0100013F0000EFBFBD030000EFBFBDEFBFBDEFBFBD7FEFBFBDEFBFBDEFBFBD7FEFBFBDEFBFBDEFBFBD7FEFBFBDEFBFBDEFBFBD7FEFBFBDEFBFBDEFBFBD7FEFBFBDEFBFBDEFBFBD7FEFBFBDEFBFBDEFBFBD7F272A17000000000032000000000000000000000000000000000001EFBFBD0100000000000000000000000000010001000000000000000000000000000000000000000000010000000000000E00000000EFBFBDEFBFBDEFBFBDEFBFBD0F0000EFBFBD46000000000006EFBFBD1800000002080000020000000200000001000000010000000200000053000BEFBFBD1E000000EFBFBD0104000000EFBFBD01EFBFBDEFBFBDEFBFBD00EFBFBD01EFBFBDEFBFBDEFBFBD00EFBFBD0173EFBFBDEFBFBD00EFBFBD01033E0000000F0002EFBFBDEFBFBD000000100008EFBFBD0800000002000000010400000F0003EFBFBD300000000F0004EFBFBD28000000010009EFBFBD100000000000000000000000000000000000000002000AEFBFBD0800000000040000050000000F0004EFBFBD3000000012000AEFBFBD0800000001040000000E000043000BEFBFBD180000007F000000EFBFBD017F0120002000EFBFBD01000008003F0301000100EFBFBD40000000000000000000000000000000000000EFBFBDEFBFBD00EFBFBDEFBFBD090400001450EFBFBD000000000000120000000000080000020800000E004B534B53EFBFBD00080000000000000000000000000000000000000004081600330E000000000000000000000100000000000000000000000000000000000000000000000000000000000000EFBFBDEFBFBD0F000000000000000000EFBFBDEFBFBD0F000000000000000000EFBFBDEFBFBD0F0000000000000000000000000000000000EFBFBD00000000006801000000000000680100000000000000000000000000000000000000000000000000000000000000000000410600001400000000000000000000000000000000000000000000000000000000000000000000000000000000000000680100000C000000740100000C0000000000000000000000EFBFBD010000EFBFBD010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000002C07000002000000000000000000000000000000000000000000000000000000000000000000000000000000000000001D06000024000000EFBFBD03000068020000EFBFBD0300002A000000EFBFBD01000015000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000055060000EFBFBD0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000002000C0100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000D000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000008000002080000EFBFBD0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000086D480904734809040000010008000002080000EFBFBD000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000010000000131001FEFBFBDEFBFBD2E20EFBFBDEFBFBD4121EFBFBD080723EFBFBDEFBFBD0522EFBFBD080724EFBFBDEFBFBD0525EFBFBD000017EFBFBD530318EFBFBDEFBFBD033250020031EFBFBD3801EFBFBDEFBFBD02000000000800000208000006000000EFBFBDEFBFBD0000060102000000000000000000000000000000000001000000EFBFBDEFBFBDEFBFBDEFBFBDEFBFBD4F6810EFBFBDEFBFBD08002B27EFBFBDEFBFBD30000000600100001000000001000000EFBFBD000000000000EFBFBDEFBFBD00000002000000EFBFBD00000003000000EFBFBD000000040000004801000005000000EFBFBD00000006000000EFBFBD00000007000000EFBFBD00000008000000EFBFBD0000000500530075006D006D0061007200790049006E0066006F0072006D006100740069006F006E000000000000000000000000000000000000000000000000000000280002010300000005000000EFBFBDEFBFBDEFBFBDEFBFBD00000000000000000000000000000000000000000000000000000000000000000000000056000000EFBFBD01000000000000050044006F00630075006D0065006E007400530075006D006D0061007200790049006E0066006F0072006D006100740069006F006E000000000000000000000038000200EFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBD0000000000000000000000000000000000000000000000000000000000000000000000005C000000EFBFBD010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000EFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBD0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000EFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBD00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000009000000EFBFBD0000000E000000EFBFBD0000000F000000EFBFBD0000001000000004010000120000000C01000013000000340100000C0000003C010000000000000000000002000000EFBFBD04000013000000040800001F00000001000000000000001F00000001000000000000001F00000001000000000000001F00000001000000000000001F00000001000000000000001F00000001000000000000001F00000001000000000000000300000000000000030000000000000003000000000000001F0000000F00000057005000530020004F00660066006900630065002000134E1A4E487200000000030000000000000040000000EFBFBD37EFBFBD5FEFBFBDEFBFBDEFBFBD011F00000008000000EFBFBDEFBFBD000006010200000000000000000000000000000000000200000002EFBFBDEFBFBDD59C2E1B10EFBFBDEFBFBD08002B2CEFBFBDEFBFBD4400000005EFBFBDEFBFBDD59C2E1B10EFBFBDEFBFBD08002B2CEFBFBDEFBFBD5C010000180100001000000001000000EFBFBD000000000000EFBFBDEFBFBD0000000F000000EFBFBD00000002000000EFBFBD0000000E000000EFBFBD00000006000000EFBFBD00000005000000EFBFBD00000011000000EFBFBD00000003000000EFBFBD00000004000000EFBFBD00000007000000EFBFBD00000008000000EFBFBD00000009000000EFBFBD0000000A000000000100000B00000008010000100000001001000002000000EFBFBD04000013000000040800001F00000001000000000000001F00000001000000000000001F00000001000000000000000300000000000000030000000000000003000000000000001F0000000100000000000000030000000000000003000000000000000300000000000000030000000000000003000000000000000B000000000000000B00000000000000EFBFBD000000040000000000000028000000010000005C000000000000EFBFBD64000000020000006C0000000100000002000000130000004B0053004F00500072006F0064007500630074004200750069006C0064005600650072000000000002000000EFBFBD04000013000000040800001F0000001000000032003000350032002D0039002E0031002E0030002E0033003900310034000000050000000F0004EFBFBD3000000012000AEFBFBD4D006F0075006E007400440061000000180000007F000000EFBFBD017F0120002000EFBFBD01000008003F0301000100EFBFBD40000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000);
INSERT INTO `tb_official` VALUES ('14', '元旦晚会', '23', '2018-05-14', '39', '1', '', '', null);
INSERT INTO `tb_official` VALUES ('15', '公司周年庆', '24', '2018-05-14', '39', '1', '', '', null);
INSERT INTO `tb_official` VALUES ('16', '部门聚餐', '25', '2018-05-14', '39', '1', '', '', null);
INSERT INTO `tb_official` VALUES ('17', '1111', '26', '2018-05-14', '39', '1', '', '', null);
INSERT INTO `tb_official` VALUES ('18', '222', '27', '2018-05-14', '39', '1', '', '', null);
INSERT INTO `tb_official` VALUES ('19', '请假一天，吃肉去', '28', '2018-05-14', '39', '1', '', '', null);

-- ----------------------------
-- Table structure for tb_outbox
-- ----------------------------
DROP TABLE IF EXISTS `tb_outbox`;
CREATE TABLE `tb_outbox` (
  `send_id` int(11) NOT NULL AUTO_INCREMENT,
  `outbox_senderId` int(11) NOT NULL,
  `outbox_receiverId` int(11) NOT NULL,
  `outbox_title` varchar(50) NOT NULL,
  `outbox_copyeId` int(11) NOT NULL,
  `outbox_secretId` int(11) NOT NULL,
  `outbox_content` text,
  `outbox_state` int(11) NOT NULL,
  PRIMARY KEY (`send_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_outbox
-- ----------------------------

-- ----------------------------
-- Table structure for tb_position
-- ----------------------------
DROP TABLE IF EXISTS `tb_position`;
CREATE TABLE `tb_position` (
  `pos_id` int(11) NOT NULL AUTO_INCREMENT,
  `pos_name` varchar(30) NOT NULL,
  `pos_descripti` varchar(50) NOT NULL,
  PRIMARY KEY (`pos_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_position
-- ----------------------------
INSERT INTO `tb_position` VALUES ('0', '超级管理员', '超级管理员');
INSERT INTO `tb_position` VALUES ('1', '董事长', '董事长');
INSERT INTO `tb_position` VALUES ('2', '董事', '董事会董事');
INSERT INTO `tb_position` VALUES ('3', '总经理', '总经理');
INSERT INTO `tb_position` VALUES ('4', '副总经理', '副总经理');
INSERT INTO `tb_position` VALUES ('5', '部门经理', '部门经理');
INSERT INTO `tb_position` VALUES ('6', '主管', '主管');
INSERT INTO `tb_position` VALUES ('7', '咨询服务', '客服部-咨询服务');
INSERT INTO `tb_position` VALUES ('8', '投诉纠纷', '客服部-投诉纠纷');
INSERT INTO `tb_position` VALUES ('9', '售后服务', '客服部-售后服务');
INSERT INTO `tb_position` VALUES ('10', '美工设计', '技术部-美工设计');
INSERT INTO `tb_position` VALUES ('11', '系统开发', '技术部-系统开发');
INSERT INTO `tb_position` VALUES ('12', '测试体验', '技术部-测试体验');
INSERT INTO `tb_position` VALUES ('13', '活动推广', '市场部-活动推广');
INSERT INTO `tb_position` VALUES ('14', '营销策划', '市场部-营销策划');
INSERT INTO `tb_position` VALUES ('15', '商务洽谈', '市场部-商务洽谈');
INSERT INTO `tb_position` VALUES ('16', '会计', '财务部-会计');
INSERT INTO `tb_position` VALUES ('17', '结算', '财务部-结算');
INSERT INTO `tb_position` VALUES ('18', '出纳', '财务部-出纳');
INSERT INTO `tb_position` VALUES ('19', '记账', '财务部-记账');
INSERT INTO `tb_position` VALUES ('20', 'HR', '人事部-HR');
INSERT INTO `tb_position` VALUES ('21', '培训', '人事部-培训');
INSERT INTO `tb_position` VALUES ('22', '管理', '人事部-管理');
INSERT INTO `tb_position` VALUES ('23', '保安', '安保部-保安');
INSERT INTO `tb_position` VALUES ('24', '秘书', '秘书部-秘书');

-- ----------------------------
-- Table structure for tb_project_ask
-- ----------------------------
DROP TABLE IF EXISTS `tb_project_ask`;
CREATE TABLE `tb_project_ask` (
  `project_id` int(11) NOT NULL AUTO_INCREMENT,
  `project_name` varchar(50) DEFAULT NULL,
  `project_date` date DEFAULT NULL,
  `project_content` varchar(5000) DEFAULT NULL,
  `project_money` double DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`project_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_project_ask
-- ----------------------------
INSERT INTO `tb_project_ask` VALUES ('1', '', '2018-05-11', '', null, '0');

-- ----------------------------
-- Table structure for tb_reimburse
-- ----------------------------
DROP TABLE IF EXISTS `tb_reimburse`;
CREATE TABLE `tb_reimburse` (
  `re_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `re_applicationDate` date DEFAULT NULL,
  `re_content` text,
  `re_money` double DEFAULT NULL,
  `reimType_id` int(11) DEFAULT NULL,
  `re_approvestatus` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`re_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_reimburse
-- ----------------------------

-- ----------------------------
-- Table structure for tb_reimtype
-- ----------------------------
DROP TABLE IF EXISTS `tb_reimtype`;
CREATE TABLE `tb_reimtype` (
  `reimType_id` int(11) NOT NULL AUTO_INCREMENT,
  `reimType_name` varchar(30) NOT NULL,
  `reimType_descripti` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`reimType_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_reimtype
-- ----------------------------
INSERT INTO `tb_reimtype` VALUES ('1', '车辆使用费', null);
INSERT INTO `tb_reimtype` VALUES ('2', '通讯费', null);
INSERT INTO `tb_reimtype` VALUES ('3', '公务费用', null);
INSERT INTO `tb_reimtype` VALUES ('4', '差旅费', null);
INSERT INTO `tb_reimtype` VALUES ('5', '办公费', null);

-- ----------------------------
-- Table structure for tb_rfmiddle
-- ----------------------------
DROP TABLE IF EXISTS `tb_rfmiddle`;
CREATE TABLE `tb_rfmiddle` (
  `role_id` int(11) NOT NULL,
  `fun_id` int(11) NOT NULL,
  PRIMARY KEY (`role_id`,`fun_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_rfmiddle
-- ----------------------------
INSERT INTO `tb_rfmiddle` VALUES ('1', '1');
INSERT INTO `tb_rfmiddle` VALUES ('1', '2');
INSERT INTO `tb_rfmiddle` VALUES ('1', '3');
INSERT INTO `tb_rfmiddle` VALUES ('1', '4');
INSERT INTO `tb_rfmiddle` VALUES ('1', '5');
INSERT INTO `tb_rfmiddle` VALUES ('1', '6');
INSERT INTO `tb_rfmiddle` VALUES ('1', '7');
INSERT INTO `tb_rfmiddle` VALUES ('1', '8');
INSERT INTO `tb_rfmiddle` VALUES ('2', '1');
INSERT INTO `tb_rfmiddle` VALUES ('2', '2');
INSERT INTO `tb_rfmiddle` VALUES ('2', '3');
INSERT INTO `tb_rfmiddle` VALUES ('2', '4');
INSERT INTO `tb_rfmiddle` VALUES ('2', '5');
INSERT INTO `tb_rfmiddle` VALUES ('2', '6');
INSERT INTO `tb_rfmiddle` VALUES ('2', '7');
INSERT INTO `tb_rfmiddle` VALUES ('4', '1');
INSERT INTO `tb_rfmiddle` VALUES ('4', '2');
INSERT INTO `tb_rfmiddle` VALUES ('4', '3');
INSERT INTO `tb_rfmiddle` VALUES ('4', '4');
INSERT INTO `tb_rfmiddle` VALUES ('4', '7');
INSERT INTO `tb_rfmiddle` VALUES ('5', '1');
INSERT INTO `tb_rfmiddle` VALUES ('5', '2');
INSERT INTO `tb_rfmiddle` VALUES ('5', '3');
INSERT INTO `tb_rfmiddle` VALUES ('5', '4');
INSERT INTO `tb_rfmiddle` VALUES ('5', '5');
INSERT INTO `tb_rfmiddle` VALUES ('5', '6');
INSERT INTO `tb_rfmiddle` VALUES ('5', '7');
INSERT INTO `tb_rfmiddle` VALUES ('5', '8');
INSERT INTO `tb_rfmiddle` VALUES ('6', '1');
INSERT INTO `tb_rfmiddle` VALUES ('6', '2');
INSERT INTO `tb_rfmiddle` VALUES ('6', '3');
INSERT INTO `tb_rfmiddle` VALUES ('6', '4');
INSERT INTO `tb_rfmiddle` VALUES ('6', '5');
INSERT INTO `tb_rfmiddle` VALUES ('6', '6');
INSERT INTO `tb_rfmiddle` VALUES ('6', '7');
INSERT INTO `tb_rfmiddle` VALUES ('6', '8');
INSERT INTO `tb_rfmiddle` VALUES ('7', '1');
INSERT INTO `tb_rfmiddle` VALUES ('7', '2');
INSERT INTO `tb_rfmiddle` VALUES ('7', '3');
INSERT INTO `tb_rfmiddle` VALUES ('7', '4');
INSERT INTO `tb_rfmiddle` VALUES ('7', '5');
INSERT INTO `tb_rfmiddle` VALUES ('7', '6');
INSERT INTO `tb_rfmiddle` VALUES ('7', '7');
INSERT INTO `tb_rfmiddle` VALUES ('8', '1');
INSERT INTO `tb_rfmiddle` VALUES ('8', '2');
INSERT INTO `tb_rfmiddle` VALUES ('8', '3');
INSERT INTO `tb_rfmiddle` VALUES ('8', '4');
INSERT INTO `tb_rfmiddle` VALUES ('8', '5');
INSERT INTO `tb_rfmiddle` VALUES ('8', '6');
INSERT INTO `tb_rfmiddle` VALUES ('8', '7');
INSERT INTO `tb_rfmiddle` VALUES ('8', '8');
INSERT INTO `tb_rfmiddle` VALUES ('9', '1');
INSERT INTO `tb_rfmiddle` VALUES ('9', '2');
INSERT INTO `tb_rfmiddle` VALUES ('9', '3');
INSERT INTO `tb_rfmiddle` VALUES ('9', '4');
INSERT INTO `tb_rfmiddle` VALUES ('9', '5');
INSERT INTO `tb_rfmiddle` VALUES ('9', '6');
INSERT INTO `tb_rfmiddle` VALUES ('9', '7');
INSERT INTO `tb_rfmiddle` VALUES ('9', '8');
INSERT INTO `tb_rfmiddle` VALUES ('10', '1');
INSERT INTO `tb_rfmiddle` VALUES ('10', '2');
INSERT INTO `tb_rfmiddle` VALUES ('10', '3');
INSERT INTO `tb_rfmiddle` VALUES ('10', '4');
INSERT INTO `tb_rfmiddle` VALUES ('10', '5');
INSERT INTO `tb_rfmiddle` VALUES ('10', '6');
INSERT INTO `tb_rfmiddle` VALUES ('10', '7');
INSERT INTO `tb_rfmiddle` VALUES ('10', '8');
INSERT INTO `tb_rfmiddle` VALUES ('11', '1');
INSERT INTO `tb_rfmiddle` VALUES ('11', '2');
INSERT INTO `tb_rfmiddle` VALUES ('11', '3');
INSERT INTO `tb_rfmiddle` VALUES ('11', '4');
INSERT INTO `tb_rfmiddle` VALUES ('11', '5');
INSERT INTO `tb_rfmiddle` VALUES ('11', '6');
INSERT INTO `tb_rfmiddle` VALUES ('11', '7');
INSERT INTO `tb_rfmiddle` VALUES ('11', '8');
INSERT INTO `tb_rfmiddle` VALUES ('12', '1');
INSERT INTO `tb_rfmiddle` VALUES ('12', '2');
INSERT INTO `tb_rfmiddle` VALUES ('12', '3');
INSERT INTO `tb_rfmiddle` VALUES ('12', '4');
INSERT INTO `tb_rfmiddle` VALUES ('12', '5');
INSERT INTO `tb_rfmiddle` VALUES ('12', '6');
INSERT INTO `tb_rfmiddle` VALUES ('12', '7');
INSERT INTO `tb_rfmiddle` VALUES ('12', '8');
INSERT INTO `tb_rfmiddle` VALUES ('13', '1');
INSERT INTO `tb_rfmiddle` VALUES ('13', '2');
INSERT INTO `tb_rfmiddle` VALUES ('13', '3');
INSERT INTO `tb_rfmiddle` VALUES ('13', '4');
INSERT INTO `tb_rfmiddle` VALUES ('13', '5');
INSERT INTO `tb_rfmiddle` VALUES ('13', '6');
INSERT INTO `tb_rfmiddle` VALUES ('13', '7');
INSERT INTO `tb_rfmiddle` VALUES ('13', '8');

-- ----------------------------
-- Table structure for tb_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(30) NOT NULL,
  `role_descripti` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_role
-- ----------------------------
INSERT INTO `tb_role` VALUES ('1', '超级管理员', '超级管理员，用户系统所有权限');
INSERT INTO `tb_role` VALUES ('2', '管理员', '普通管理员，拥有系统所属权限');
INSERT INTO `tb_role` VALUES ('4', '普通用户', '普通员工所属角色');
INSERT INTO `tb_role` VALUES ('5', '董事会', '董事会董事');
INSERT INTO `tb_role` VALUES ('6', '总经办', '总经理办公室');
INSERT INTO `tb_role` VALUES ('7', '客服部', '客服部：负责企业客服');
INSERT INTO `tb_role` VALUES ('8', '技术部', '技术部：负责企业技术');
INSERT INTO `tb_role` VALUES ('9', '市场部', '市场部：负责市场');
INSERT INTO `tb_role` VALUES ('10', '财务部', '财务部：负责企业财务');
INSERT INTO `tb_role` VALUES ('11', '人事部', '人事部：负责企业人事');
INSERT INTO `tb_role` VALUES ('12', '安保部', '安保部：负责企业安保');
INSERT INTO `tb_role` VALUES ('13', '秘书处', '秘书处：企业秘书');

-- ----------------------------
-- Table structure for tb_rumiddle
-- ----------------------------
DROP TABLE IF EXISTS `tb_rumiddle`;
CREATE TABLE `tb_rumiddle` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_rumiddle
-- ----------------------------
INSERT INTO `tb_rumiddle` VALUES ('0', '1');
INSERT INTO `tb_rumiddle` VALUES ('1', '5');
INSERT INTO `tb_rumiddle` VALUES ('5', '6');
INSERT INTO `tb_rumiddle` VALUES ('8', '7');
INSERT INTO `tb_rumiddle` VALUES ('9', '8');
INSERT INTO `tb_rumiddle` VALUES ('10', '9');
INSERT INTO `tb_rumiddle` VALUES ('11', '10');
INSERT INTO `tb_rumiddle` VALUES ('12', '11');
INSERT INTO `tb_rumiddle` VALUES ('13', '12');
INSERT INTO `tb_rumiddle` VALUES ('14', '7');
INSERT INTO `tb_rumiddle` VALUES ('18', '7');
INSERT INTO `tb_rumiddle` VALUES ('39', '4');

-- ----------------------------
-- Table structure for tb_salary
-- ----------------------------
DROP TABLE IF EXISTS `tb_salary`;
CREATE TABLE `tb_salary` (
  `sal_id` int(11) NOT NULL AUTO_INCREMENT,
  `date_sal` varchar(255) NOT NULL,
  `basic_salary` int(11) NOT NULL,
  `cut_money` int(11) NOT NULL,
  `bonus` int(11) NOT NULL,
  `tax` int(11) NOT NULL,
  `final_sal` int(11) NOT NULL,
  `emp_id` int(11) NOT NULL,
  PRIMARY KEY (`sal_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_salary
-- ----------------------------
INSERT INTO `tb_salary` VALUES ('1', '2018-5', '8000', '0', '0', '800', '7200', '1');
INSERT INTO `tb_salary` VALUES ('2', '2018-5', '7000', '0', '0', '700', '6300', '2');
INSERT INTO `tb_salary` VALUES ('3', '2018-5', '5000', '166', '0', '500', '4334', '39');

-- ----------------------------
-- Table structure for tb_schedule
-- ----------------------------
DROP TABLE IF EXISTS `tb_schedule`;
CREATE TABLE `tb_schedule` (
  `schedule_id` int(11) NOT NULL AUTO_INCREMENT,
  `schedule_date` date DEFAULT NULL,
  `schedule_desprict` text,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`schedule_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_schedule
-- ----------------------------
INSERT INTO `tb_schedule` VALUES ('1', '2017-10-23', '开会', '1');
INSERT INTO `tb_schedule` VALUES ('2', '2017-12-01', '项目演示', '1');
INSERT INTO `tb_schedule` VALUES ('10', '2017-12-01', 'dddd', '2');
INSERT INTO `tb_schedule` VALUES ('11', '2018-04-27', '五一我们旅游去', '6');
INSERT INTO `tb_schedule` VALUES ('12', '2018-05-10', '出差到北京', '2');
INSERT INTO `tb_schedule` VALUES ('13', '2018-05-14', '今天晚上下班后去逛超市', '0');

-- ----------------------------
-- Table structure for tb_stationery
-- ----------------------------
DROP TABLE IF EXISTS `tb_stationery`;
CREATE TABLE `tb_stationery` (
  `STATIONERY_ID` int(11) NOT NULL AUTO_INCREMENT,
  `STATIONERY_NAME` varchar(50) DEFAULT NULL,
  `STATIONERY_DATE` date DEFAULT NULL,
  `STATIONERY_MONERY` double DEFAULT NULL,
  `stationery_amount` int(50) NOT NULL,
  `STATITYPE_ID` int(11) NOT NULL,
  `STATIONERY_descripti` varchar(50) NOT NULL,
  PRIMARY KEY (`STATIONERY_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_stationery
-- ----------------------------
INSERT INTO `tb_stationery` VALUES ('1', '华硕A84', '2017-11-15', '4500', '8', '1', '华硕系列');
INSERT INTO `tb_stationery` VALUES ('2', '联想B460', '2017-11-17', '5000', '1', '1', '联想系列');
INSERT INTO `tb_stationery` VALUES ('3', '联想A46', '2017-11-15', '4600', '10', '1', '联想系列');
INSERT INTO `tb_stationery` VALUES ('4', '数码录音笔', '2017-11-15', '500', '3', '2', '数码系列');
INSERT INTO `tb_stationery` VALUES ('5', '签字笔', '2017-11-15', '3', '50', '3', '笔');
INSERT INTO `tb_stationery` VALUES ('6', '打印纸', '2017-11-15', '2', '200', '3', '纸张');
INSERT INTO `tb_stationery` VALUES ('7', '投影机', '2017-11-29', '400', '2', '4', '投影机');
INSERT INTO `tb_stationery` VALUES ('8', '华硕A84', '2017-12-01', '4500', '1', '1', '华硕系列');
INSERT INTO `tb_stationery` VALUES ('9', 'Surface pro5', '2018-05-14', '8800', '10', '1', '微软的Surface pro5，128G');
INSERT INTO `tb_stationery` VALUES ('10', '联想台式机666', '2018-05-15', '6866', '5', '1', '办公室666配置');

-- ----------------------------
-- Table structure for tb_stationerylibarary
-- ----------------------------
DROP TABLE IF EXISTS `tb_stationerylibarary`;
CREATE TABLE `tb_stationerylibarary` (
  `statilibrary_id` int(11) NOT NULL AUTO_INCREMENT,
  `statilibrary_name` varchar(50) NOT NULL,
  `statilibrary_date` date NOT NULL,
  `statilibrary_descripti` varchar(50) NOT NULL,
  PRIMARY KEY (`statilibrary_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_stationerylibarary
-- ----------------------------
INSERT INTO `tb_stationerylibarary` VALUES ('1', '电子数码', '2017-11-16', '电子设备');
INSERT INTO `tb_stationerylibarary` VALUES ('2', '办公消耗品', '2017-11-25', '办公用品');
INSERT INTO `tb_stationerylibarary` VALUES ('3', '办公设备', '2017-11-30', '设备');

-- ----------------------------
-- Table structure for tb_stationerystatus
-- ----------------------------
DROP TABLE IF EXISTS `tb_stationerystatus`;
CREATE TABLE `tb_stationerystatus` (
  `stationeryStatus_id` int(11) NOT NULL AUTO_INCREMENT,
  `stationery_id` int(50) DEFAULT NULL,
  `register_type` varchar(50) DEFAULT NULL,
  `proposer_name` int(50) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `oparate_date` date DEFAULT NULL,
  `oparate_name` int(11) DEFAULT NULL,
  `desprict` varchar(50) DEFAULT NULL,
  `addition_massage` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`stationeryStatus_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_stationerystatus
-- ----------------------------
INSERT INTO `tb_stationerystatus` VALUES ('1', '8', '领用', '3', '1', '2017-12-01', '1', '', null);
INSERT INTO `tb_stationerystatus` VALUES ('2', '7', '借用', '5', '1', '2017-12-01', '1', '看看', '未归还');

-- ----------------------------
-- Table structure for tb_stationerytype
-- ----------------------------
DROP TABLE IF EXISTS `tb_stationerytype`;
CREATE TABLE `tb_stationerytype` (
  `statitype_id` int(11) NOT NULL AUTO_INCREMENT,
  `statitype_name` varchar(50) NOT NULL,
  `statitype_date` date NOT NULL,
  `statilibrary_id` int(11) NOT NULL,
  `statitype_descripti` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`statitype_id`),
  KEY `FK_Reference_26` (`statilibrary_id`),
  CONSTRAINT `FK_Reference_26` FOREIGN KEY (`statilibrary_id`) REFERENCES `tb_stationerylibarary` (`statilibrary_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_stationerytype
-- ----------------------------
INSERT INTO `tb_stationerytype` VALUES ('1', '电脑及耗材', '2017-11-24', '1', '电脑材料');
INSERT INTO `tb_stationerytype` VALUES ('2', '电子数码', '2017-11-24', '1', '数码');
INSERT INTO `tb_stationerytype` VALUES ('3', '办公消耗品', '2017-11-22', '2', '办公');
INSERT INTO `tb_stationerytype` VALUES ('4', '办公设备', '2017-11-23', '3', '设备');

-- ----------------------------
-- Table structure for tb_step_instance
-- ----------------------------
DROP TABLE IF EXISTS `tb_step_instance`;
CREATE TABLE `tb_step_instance` (
  `step_instance_id` int(11) NOT NULL AUTO_INCREMENT,
  `step_id` int(11) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `finish_date` date DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `emp_id` int(11) DEFAULT NULL,
  `official_id` int(11) DEFAULT NULL,
  `Flow_instance_id` int(11) DEFAULT NULL,
  `commit` int(11) DEFAULT NULL,
  PRIMARY KEY (`step_instance_id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_step_instance
-- ----------------------------
INSERT INTO `tb_step_instance` VALUES ('11', '2', '2018-05-14', null, '2', '14', '13', '13', null);
INSERT INTO `tb_step_instance` VALUES ('12', '3', '2018-05-14', null, '2', '8', '13', '13', null);
INSERT INTO `tb_step_instance` VALUES ('13', '4', '2018-05-14', null, '2', '11', '13', '13', null);
INSERT INTO `tb_step_instance` VALUES ('14', '5', '2018-05-14', null, '2', '5', '13', '13', '1');
INSERT INTO `tb_step_instance` VALUES ('15', '6', '2018-05-14', null, '2', '1', '13', '13', null);
INSERT INTO `tb_step_instance` VALUES ('16', '7', '2018-05-14', null, '2', '39', '13', '13', null);
INSERT INTO `tb_step_instance` VALUES ('17', '2', '2018-05-14', null, '2', '14', '14', '14', null);
INSERT INTO `tb_step_instance` VALUES ('18', '3', '2018-05-14', null, '2', '8', '14', '14', null);
INSERT INTO `tb_step_instance` VALUES ('19', '4', '2018-05-14', null, '2', '11', '14', '14', null);
INSERT INTO `tb_step_instance` VALUES ('20', '5', '2018-05-14', null, '2', '5', '14', '14', '1');
INSERT INTO `tb_step_instance` VALUES ('21', '2', '2018-05-14', null, '2', '14', '15', '15', null);
INSERT INTO `tb_step_instance` VALUES ('22', '3', '2018-05-14', null, '2', '8', '15', '15', null);
INSERT INTO `tb_step_instance` VALUES ('23', '4', '2018-05-14', null, '2', '11', '15', '15', null);
INSERT INTO `tb_step_instance` VALUES ('24', '5', '2018-05-14', null, '2', '5', '15', '15', null);
INSERT INTO `tb_step_instance` VALUES ('25', '2', '2018-05-14', null, '2', '14', '16', '16', null);
INSERT INTO `tb_step_instance` VALUES ('26', '3', '2018-05-14', null, '2', '8', '16', '16', null);
INSERT INTO `tb_step_instance` VALUES ('27', '4', '2018-05-14', null, '2', '11', '16', '16', null);
INSERT INTO `tb_step_instance` VALUES ('28', '5', '2018-05-14', null, '2', '5', '16', '16', null);
INSERT INTO `tb_step_instance` VALUES ('29', '6', '2018-05-14', null, '2', '1', '14', '14', null);
INSERT INTO `tb_step_instance` VALUES ('30', '2', '2018-05-14', null, '2', '14', '17', '17', null);
INSERT INTO `tb_step_instance` VALUES ('31', '3', '2018-05-14', null, '2', '8', '17', '17', null);
INSERT INTO `tb_step_instance` VALUES ('32', '4', '2018-05-14', null, '2', '11', '17', '17', null);
INSERT INTO `tb_step_instance` VALUES ('33', '5', '2018-05-14', null, '2', '5', '17', '17', '1');
INSERT INTO `tb_step_instance` VALUES ('34', '6', '2018-05-14', null, '2', '1', '17', '17', null);
INSERT INTO `tb_step_instance` VALUES ('35', '7', '2018-05-14', null, '2', '39', '17', '17', null);
INSERT INTO `tb_step_instance` VALUES ('36', '2', '2018-05-14', null, '2', '14', '18', '18', null);
INSERT INTO `tb_step_instance` VALUES ('37', '3', '2018-05-14', null, '2', '8', '18', '18', null);
INSERT INTO `tb_step_instance` VALUES ('38', '4', '2018-05-14', null, '2', '11', '18', '18', null);
INSERT INTO `tb_step_instance` VALUES ('39', '5', '2018-05-14', null, '2', '5', '18', '18', '1');
INSERT INTO `tb_step_instance` VALUES ('40', '6', '2018-05-14', null, '2', '1', '18', '18', null);
INSERT INTO `tb_step_instance` VALUES ('41', '7', '2018-05-14', null, '2', '39', '18', '18', null);
INSERT INTO `tb_step_instance` VALUES ('42', '7', '2018-05-14', null, '2', '39', '18', '18', null);
INSERT INTO `tb_step_instance` VALUES ('43', '7', '2018-05-14', null, '2', '39', '18', '18', null);
INSERT INTO `tb_step_instance` VALUES ('44', '2', '2018-05-14', null, '2', '14', '19', '19', null);
INSERT INTO `tb_step_instance` VALUES ('45', '3', '2018-05-14', null, '2', '8', '19', '19', null);
INSERT INTO `tb_step_instance` VALUES ('46', '5', '2018-05-14', null, '2', '5', '19', '19', null);
INSERT INTO `tb_step_instance` VALUES ('47', '7', '2018-05-14', null, '2', '39', '19', '19', null);

-- ----------------------------
-- Table structure for tb_step_template
-- ----------------------------
DROP TABLE IF EXISTS `tb_step_template`;
CREATE TABLE `tb_step_template` (
  `step_id` int(11) NOT NULL AUTO_INCREMENT,
  `step_name` varchar(100) DEFAULT NULL,
  `form_url` varchar(200) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `step_appoint` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`step_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_step_template
-- ----------------------------
INSERT INTO `tb_step_template` VALUES ('1', '开始', '', '', '');
INSERT INTO `tb_step_template` VALUES ('2', '申请人所属主管审批', '', '', '主管');
INSERT INTO `tb_step_template` VALUES ('3', '申请人所属部门经理审批', '', '', '部门经理');
INSERT INTO `tb_step_template` VALUES ('4', '财务部审批', '', '', '部门经理');
INSERT INTO `tb_step_template` VALUES ('5', '总经理审批', '', '', '总经理');
INSERT INTO `tb_step_template` VALUES ('6', '董事长审批', '', '', '董事长');
INSERT INTO `tb_step_template` VALUES ('7', '完成', '', '', '');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(30) NOT NULL,
  `user_password` varchar(30) NOT NULL,
  `emp_id` int(11) NOT NULL,
  `user_email` varchar(50) NOT NULL,
  `state` int(11) DEFAULT NULL,
  `code` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=109 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('0', 'root', '123', '0', '1111111@qq.com', '1', '');
INSERT INTO `tb_user` VALUES ('1', 'dsz', '123', '1', '123456@126.com', '1', '');
INSERT INTO `tb_user` VALUES ('2', 'ds1', '123', '2', '123456@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('3', 'ds2', '123', '3', '234567@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('4', 'ds3', '123', '4', '345678@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('5', 'zjl', '123', '5', '456789@qq.com', '1', '');
INSERT INTO `tb_user` VALUES ('6', 'fzjl1', '123', '6', '567900@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('7', 'fzjl2', '123', '7', '679011@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('8', 'kfbjl', '123', '8', '790122@qq.com', '1', '');
INSERT INTO `tb_user` VALUES ('9', 'jsbjl', '123', '9', '901233@qq.com', '1', '');
INSERT INTO `tb_user` VALUES ('10', 'scbjl', '123', '10', '1012344@qq.com', '1', '');
INSERT INTO `tb_user` VALUES ('11', 'cwbjl', '123', '11', '1234567@qq.com', '1', '');
INSERT INTO `tb_user` VALUES ('12', 'rsbjl', '123', '12', '12345@qq.com', '1', '');
INSERT INTO `tb_user` VALUES ('13', 'abbjl', '123', '13', '123456@qq.com', '1', '');
INSERT INTO `tb_user` VALUES ('14', 'kfbzg1', '123', '14', '234567@qq.com', '1', '');
INSERT INTO `tb_user` VALUES ('15', 'jsbzg1', '123', '15', '345678@qq.com', '1', '');
INSERT INTO `tb_user` VALUES ('16', 'scbzg1', '123', '16', '456789@qq.com', '1', '');
INSERT INTO `tb_user` VALUES ('17', 'cwbzg1', '123', '17', '567900@qq.com', '1', '');
INSERT INTO `tb_user` VALUES ('18', 'rsbzg1', '123', '18', '679011@qq.com', '1', '');
INSERT INTO `tb_user` VALUES ('19', 'abbzg1', '123', '19', '790122@qq.com', '1', '');
INSERT INTO `tb_user` VALUES ('20', 'msczg1', '123', '20', '901233@qq.com', '1', '');
INSERT INTO `tb_user` VALUES ('21', 'kfbzg2', '123', '21', '1012344@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('22', 'jsbzg2', '123', '22', '1234567@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('23', 'scbzg2', '123', '23', '12345@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('24', 'cwbzg2', '123', '24', '123456@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('25', 'rsbzg2', '123', '25', '234567@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('26', 'abbzg2', '123', '26', '345678@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('27', 'kfbzg3', '123', '27', '456789@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('28', 'jsbzg3', '123', '28', '567900@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('29', 'scbzg3', '123', '29', '679011@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('30', 'cwbzg3', '123', '30', '790122@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('31', 'rsbzg3', '123', '31', '901233@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('32', 'abbzg3', '123', '32', '1012344@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('33', 'kfbzg4', '123', '33', '1234567@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('34', 'jsbzg4', '123', '34', '12345@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('35', 'scbzg4', '123', '35', '123456@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('36', 'cwbzg4', '123', '36', '234567@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('37', 'rsbzg4', '123', '37', '345678@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('38', 'abbzg4', '123', '38', '456789@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('39', 'kfbyg1', '123', '39', '567900@qq.com', '1', '');
INSERT INTO `tb_user` VALUES ('40', 'kfbyg2', '123', '40', '679011@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('41', 'kfbyg3', '123', '41', '790122@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('42', 'kfbyg4', '123', '42', '901233@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('43', 'kfbyg5', '123', '43', '1012344@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('44', 'kfbyg6', '123', '44', '1234567@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('45', 'kfbyg7', '123', '45', '12345@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('46', 'kfbyg8', '123', '46', '123456@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('47', 'kfbyg9', '123', '47', '234567@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('48', 'kfbyg10', '123', '48', '345678@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('49', 'kfbyg11', '123', '49', '456789@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('50', 'kfbyg12', '123', '50', '567900@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('51', 'kfbyg13', '123', '51', '679011@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('52', 'kfbyg14', '123', '52', '790122@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('53', 'kfbyg15', '123', '53', '901233@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('54', 'jsbyg1', '123', '54', '1012344@qq.com', '1', '');
INSERT INTO `tb_user` VALUES ('55', 'jsbyg2', '123', '55', '1234567@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('56', 'jsbyg3', '123', '56', '12345@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('57', 'jsbyg4', '123', '57', '123456@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('58', 'jsbyg5', '123', '58', '234567@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('59', 'jsbyg6', '123', '59', '345678@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('60', 'jsbyg7', '123', '60', '456789@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('61', 'jsbyg8', '123', '61', '567900@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('62', 'jsbyg9', '123', '62', '679011@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('63', 'jsbyg10', '123', '63', '790122@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('64', 'jsbyg11', '123', '64', '901233@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('65', 'jsbyg12', '123', '65', '1012344@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('66', 'scbyg1', '123', '66', '1234567@qq.com', '1', '');
INSERT INTO `tb_user` VALUES ('67', 'scbyg2', '123', '67', '12345@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('68', 'scbyg3', '123', '68', '123456@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('69', 'scbyg4', '123', '69', '234567@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('70', 'scbyg5', '123', '70', '345678@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('71', 'scbyg6', '123', '71', '456789@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('72', 'scbyg7', '123', '72', '567900@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('73', 'scbyg8', '123', '73', '679011@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('74', 'scbyg9', '123', '74', '790122@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('75', 'scbyg10', '123', '75', '901233@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('76', 'scbyg11', '123', '76', '1012344@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('77', 'scbyg12', '123', '77', '1234567@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('78', 'cwbyg1', '123', '78', '12345@qq.com', '1', '');
INSERT INTO `tb_user` VALUES ('79', 'cwbyg2', '123', '79', '123456@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('80', 'cwbyg3', '123', '80', '234567@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('81', 'cwbyg4', '123', '81', '345678@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('82', 'cwbyg5', '123', '82', '456789@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('83', 'cwbyg6', '123', '83', '567900@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('84', 'cwbyg7', '123', '84', '679011@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('85', 'cwbyg8', '123', '85', '790122@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('86', 'rsbyg1', '123', '86', '901233@qq.com', '1', '');
INSERT INTO `tb_user` VALUES ('87', 'rsbyg2', '123', '87', '1012344@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('88', 'rsbyg3', '123', '88', '1234567@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('89', 'rsbyg4', '123', '89', '12345@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('90', 'rsbyg5', '123', '90', '123456@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('91', 'rsbyg6', '123', '91', '234567@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('92', 'rsbyg7', '123', '92', '345678@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('93', 'rsbyg8', '123', '93', '456789@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('94', 'rsbyg9', '123', '94', '567900@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('95', 'rsbyg10', '123', '95', '679011@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('96', 'rsbyg11', '123', '96', '790122@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('97', 'rsbyg12', '123', '97', '901233@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('98', 'abbyg1', '123', '98', '1012344@qq.com', '1', '');
INSERT INTO `tb_user` VALUES ('99', 'abbyg2', '123', '99', '1234567@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('100', 'abbyg3', '123', '100', '12345@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('101', 'abbyg4', '123', '101', '123456@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('102', 'abbyg5', '123', '102', '234567@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('103', 'abbyg6', '123', '103', '345678@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('104', 'abbyg7', '123', '104', '456789@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('105', 'abbyg8', '123', '105', '567900@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('106', 'mscyg1', '123', '106', '679011@qq.com', '1', '');
INSERT INTO `tb_user` VALUES ('107', 'mscyg2', '123', '107', '790122@qq.com', '0', '');
INSERT INTO `tb_user` VALUES ('108', 'mscyg3', '123', '108', '901233@qq.com', '0', '');
SET FOREIGN_KEY_CHECKS=1;
