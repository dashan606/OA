/*
Navicat MySQL Data Transfer

Source Server         : localhsot
Source Server Version : 50720
Source Host           : 127.0.0.1:3306
Source Database       : oamanager

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-05-10 21:50:41
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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_announcement
-- ----------------------------
INSERT INTO `tb_announcement` VALUES ('2', '你是我的小可爱', '多幸运在最美的年纪遇见你', '1', '2017-11-08', '1');
INSERT INTO `tb_announcement` VALUES ('3', '你是我的小可爱', '多幸运在最美的年纪遇见你', '1', '2017-11-08', '1');
INSERT INTO `tb_announcement` VALUES ('4', '看不见看不见', ' 你你你你哦i', '2', '2017-11-07', '1');
INSERT INTO `tb_announcement` VALUES ('5', '五一，我们一起去旅游吧', '感谢大家长久以来的辛苦付出，五一我们去旅游', '6', '2018-04-25', '1');
INSERT INTO `tb_announcement` VALUES ('6', '普通发公告1', '普通发公告1普通发公告1普通发公告1普通发公告1普通发公告1', '1', '2018-05-09', '1');
INSERT INTO `tb_announcement` VALUES ('7', '普通发公告2', '普通发公告2普通发公告2普通发公告2普通发公告2普通发公告2普通发公告2普通发公告2', '2', '2018-05-10', '1');
INSERT INTO `tb_announcement` VALUES ('8', '普通发公告3', '普通发公告3普通发公告3普通发公告3普通发公告3普通发公告3普通发公告3普通发公告3', '2', '2018-05-11', '0');
INSERT INTO `tb_announcement` VALUES ('9', '普通发公告3', '普通发公告3普通发公告3普通发公告3普通发公告3普通发公告3普通发公告3普通发公告3', '2', '2018-05-11', '0');

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_approve
-- ----------------------------

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_assetmaintain
-- ----------------------------
INSERT INTO `tb_assetmaintain` VALUES ('1', 'A20170901', '1', '2017-11-09', '2', '12331');

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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_department
-- ----------------------------
INSERT INTO `tb_department` VALUES ('1', '1', '人事部', '人事');
INSERT INTO `tb_department` VALUES ('2', '2', '后勤部', '后勤');
INSERT INTO `tb_department` VALUES ('3', '3', '技术部', '技术');
INSERT INTO `tb_department` VALUES ('4', '4', '开发部', '开发');
INSERT INTO `tb_department` VALUES ('5', '5', '产品部', '产品');
INSERT INTO `tb_department` VALUES ('6', '6', '销售部', '销售');
INSERT INTO `tb_department` VALUES ('7', '7', '财务部', '财务');

-- ----------------------------
-- Table structure for tb_emplyee
-- ----------------------------
DROP TABLE IF EXISTS `tb_emplyee`;
CREATE TABLE `tb_emplyee` (
  `emp_id` int(10) NOT NULL AUTO_INCREMENT,
  `emp_number` varchar(5) NOT NULL,
  `emp_name` varchar(30) NOT NULL,
  `user_id` int(11) NOT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_emplyee
-- ----------------------------
INSERT INTO `tb_emplyee` VALUES ('1', '001', '经理', '1', '男', '1999-04-04', '1', '4', '8000', '15211365310', '郑州二七区紫荆山南路001号', '2018-02-14', '0', '/images/man8.jpg', '24');
INSERT INTO `tb_emplyee` VALUES ('2', '002', '普通员工1', '2', '男', '1998-02-06', '6', '3', '7000', '13145685421', '郑州二七区紫荆山南路002号', '2018-02-14', '0', '/images/头像1.jpg', '23');
INSERT INTO `tb_emplyee` VALUES ('3', '003', '财务', '3', '女', '1995-11-08', '3', '7', '8888', '18265445875', '郑州二七区紫荆山南路003号', '2018-02-14', '0', '0', '22');
INSERT INTO `tb_emplyee` VALUES ('4', '004', '副总', '4', '男', '1994-06-15', '2', '5', '100000', '13154785554', '郑州二七区紫荆山南路004号', '2018-02-14', '0', '0', '25');
INSERT INTO `tb_emplyee` VALUES ('5', '005', '主管', '5', '男', '1992-05-16', '5', '6', '200000', '17258463211', '郑州二七区紫荆山南路005号', '2018-02-14', '0', '0', '28');
INSERT INTO `tb_emplyee` VALUES ('6', '006', '董事长', '6', '男', '1988-12-06', '4', '5', '2000000', '12345214523', '郑州二七区紫荆山南路006号', '2018-02-14', '0', '0', '35');
INSERT INTO `tb_emplyee` VALUES ('7', '007', '经理2', '7', '男', '1997-05-05', '1', '2', '9654', '18325412226', '郑州二七区紫荆山南路007号', '2018-02-14', '0', '0', '26');
INSERT INTO `tb_emplyee` VALUES ('8', '008', '董事2', '8', '男', '1988-01-26', '4', '1', '400000', '15236984521', '郑州二七区紫荆山南路008号', '2018-02-14', '0', '0', '29');
INSERT INTO `tb_emplyee` VALUES ('9', '111', '李大大', '10', '男', '2017-12-01', '1', '4', '8000', '18692975420', '郑州二七区紫荆山南路009号', '2018-02-14', '0', '/images/face.jpg', '20');

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_evection
-- ----------------------------
INSERT INTO `tb_evection` VALUES ('1', '2017-11-30', '2', '学习', '300', '1');
INSERT INTO `tb_evection` VALUES ('2', '2017-11-08', '3', '调研', '200', '2');
INSERT INTO `tb_evection` VALUES ('3', '2017-11-21', '3', '学习', '600', '4');
INSERT INTO `tb_evection` VALUES ('4', '2017-10-11', '3', '调研', '500', '3');
INSERT INTO `tb_evection` VALUES ('5', '2017-10-10', '7', '学习', '200', '2');

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_flow_instance
-- ----------------------------

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_flow_link
-- ----------------------------

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_flow_template
-- ----------------------------

-- ----------------------------
-- Table structure for tb_flow_type
-- ----------------------------
DROP TABLE IF EXISTS `tb_flow_type`;
CREATE TABLE `tb_flow_type` (
  `flow_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `flow_type_name` varchar(50) DEFAULT NULL,
  `flow_description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`flow_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_flow_type
-- ----------------------------
INSERT INTO `tb_flow_type` VALUES ('1', '工作流程', '工作流程');
INSERT INTO `tb_flow_type` VALUES ('2', '业务流程', '业务流程');

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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='InnoDB free: 11264 kB';

-- ----------------------------
-- Records of tb_leave
-- ----------------------------
INSERT INTO `tb_leave` VALUES ('1', '2017-09-01', '5', '私事', '5');
INSERT INTO `tb_leave` VALUES ('2', '2017-10-01', '7', '私事', '4');
INSERT INTO `tb_leave` VALUES ('3', '2017-10-10', '5', '私事', '5');
INSERT INTO `tb_leave` VALUES ('4', '2017-10-13', '5', '私事', '2');
INSERT INTO `tb_leave` VALUES ('5', '2017-10-18', '6', '私事', '4');
INSERT INTO `tb_leave` VALUES ('6', '2017-11-24', '4', '私事', '2');
INSERT INTO `tb_leave` VALUES ('7', '2017-12-10', '3', '家里有事', '2');

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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_mail
-- ----------------------------
INSERT INTO `tb_mail` VALUES ('1', '小明', 'duhu,px,zsm,cyj', '无', '无', '群发测试', '<p>测试中</p>\r\n', '2017年11月16日 星期四 21:19 ', 'userface1.jpg', null, '0');
INSERT INTO `tb_mail` VALUES ('4', '小明', 'zsm', 'admin', '无', '群发测试', '<p>测试</p>\r\n', '2017年11月16日 星期四 22:25 ', 'userface1.jpg', null, '0');
INSERT INTO `tb_mail` VALUES ('5', '小明', 'px,cyj,zsm,th,admin', '无', '无', '群发测试', '<p>测试中</p>\r\n', '2017年11月17日 星期五 13:58 ', 'userface1.jpg', null, '0');
INSERT INTO `tb_mail` VALUES ('6', '小明', 'duhu,admin,th,px,cyj', '无', '无', '多幸运群发测试', '<p>测试中</p>\r\n', '2017年11月22日 星期三 17:03 ', '', null, '0');
INSERT INTO `tb_mail` VALUES ('7', 'jingli', 'dongshiz2', '无', '无', '你好', '<p>你好</p>\r\n', '2017年12月01日 星期五 15:44 ', '', null, '0');

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_official
-- ----------------------------

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
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_position
-- ----------------------------
INSERT INTO `tb_position` VALUES ('1', '经理', '经理');
INSERT INTO `tb_position` VALUES ('2', '副经理', '副经理');
INSERT INTO `tb_position` VALUES ('3', '财务总经理', '财务总经理');
INSERT INTO `tb_position` VALUES ('4', '董事长', '董事长');
INSERT INTO `tb_position` VALUES ('5', '主管', '主管');
INSERT INTO `tb_position` VALUES ('6', '普通员工', '普通员工');
INSERT INTO `tb_position` VALUES ('7', '业务员', '业务员');
INSERT INTO `tb_position` VALUES ('8', '推广', '推广');
INSERT INTO `tb_position` VALUES ('9', '市场策划', '市场策划');
INSERT INTO `tb_position` VALUES ('10', '会计', '会计');
INSERT INTO `tb_position` VALUES ('11', '结算', '结算');
INSERT INTO `tb_position` VALUES ('12', '出纳', '出纳');
INSERT INTO `tb_position` VALUES ('13', '记账', '记账');
INSERT INTO `tb_position` VALUES ('14', '技术总监', '技术总监');
INSERT INTO `tb_position` VALUES ('15', '项目经理', '项目经理');
INSERT INTO `tb_position` VALUES ('16', '小组长', '小组长');
INSERT INTO `tb_position` VALUES ('17', '产品经理', '产品经理');
INSERT INTO `tb_position` VALUES ('20', '软件测试工程师', '测试');
INSERT INTO `tb_position` VALUES ('21', '软件开发工程师', '软件开发工程师');
INSERT INTO `tb_position` VALUES ('22', '平面设计师', '平面设计师');
INSERT INTO `tb_position` VALUES ('23', '董事长秘书', '董事长秘书');
INSERT INTO `tb_position` VALUES ('24', '总经理助理', '总经理助理');
INSERT INTO `tb_position` VALUES ('25', '保洁', '保洁');
INSERT INTO `tb_position` VALUES ('26', '司机', '司机');
INSERT INTO `tb_position` VALUES ('27', '保安', '保安');

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_project_ask
-- ----------------------------

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
INSERT INTO `tb_rfmiddle` VALUES ('2', '7');

-- ----------------------------
-- Table structure for tb_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(30) NOT NULL,
  `role_descripti` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_role
-- ----------------------------
INSERT INTO `tb_role` VALUES ('1', 'admin', '超级管理员');
INSERT INTO `tb_role` VALUES ('2', 'nomal', '普通管理员');

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
INSERT INTO `tb_rumiddle` VALUES ('1', '1');
INSERT INTO `tb_rumiddle` VALUES ('2', '1');
INSERT INTO `tb_rumiddle` VALUES ('3', '1');
INSERT INTO `tb_rumiddle` VALUES ('4', '1');
INSERT INTO `tb_rumiddle` VALUES ('5', '1');
INSERT INTO `tb_rumiddle` VALUES ('6', '1');
INSERT INTO `tb_rumiddle` VALUES ('7', '1');
INSERT INTO `tb_rumiddle` VALUES ('9', '2');

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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_salary
-- ----------------------------
INSERT INTO `tb_salary` VALUES ('1', '2017-11', '1200', '160', '40', '120', '960', '2');
INSERT INTO `tb_salary` VALUES ('2', '2017-11', '1800', '0', '0', '180', '1620', '3');
INSERT INTO `tb_salary` VALUES ('3', '2017-11', '4000', '0', '0', '400', '3600', '8');
INSERT INTO `tb_salary` VALUES ('4', '2017-11', '1200', '0', '0', '120', '1080', '6');
INSERT INTO `tb_salary` VALUES ('15', '2017-11', '1200', '0', '0', '120', '1080', '4');
INSERT INTO `tb_salary` VALUES ('16', '2018-5', '8000', '0', '0', '800', '7200', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_schedule
-- ----------------------------
INSERT INTO `tb_schedule` VALUES ('1', '2017-10-23', '开会', '1');
INSERT INTO `tb_schedule` VALUES ('2', '2017-12-01', '项目演示', '1');
INSERT INTO `tb_schedule` VALUES ('10', '2017-12-01', 'dddd', '2');
INSERT INTO `tb_schedule` VALUES ('11', '2018-04-27', '五一我们旅游去', '6');
INSERT INTO `tb_schedule` VALUES ('12', '2018-05-10', '出差到北京', '2');

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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_step_instance
-- ----------------------------

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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_step_template
-- ----------------------------
INSERT INTO `tb_step_template` VALUES ('1', '开始', null, null, null);
INSERT INTO `tb_step_template` VALUES ('2', '经理审批', null, null, '经理');
INSERT INTO `tb_step_template` VALUES ('3', '副经理审批', null, null, '副经理');
INSERT INTO `tb_step_template` VALUES ('4', '主管审批', null, null, '主管');
INSERT INTO `tb_step_template` VALUES ('5', '财务总经理审批', null, null, '财务总经理');
INSERT INTO `tb_step_template` VALUES ('6', '董事长审批', null, null, '董事长');
INSERT INTO `tb_step_template` VALUES ('7', '结束', null, null, null);
INSERT INTO `tb_step_template` VALUES ('8', '项目经理审批', null, null, '项目经理');

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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'jingli', '123', '1', '1726204625@qq.com', '1', null);
INSERT INTO `tb_user` VALUES ('2', 'putong', '123', '2', '2325293782@qq.com', '1', null);
INSERT INTO `tb_user` VALUES ('3', 'caiwu', '123', '3', '1726204625@qq.com', '1', null);
INSERT INTO `tb_user` VALUES ('4', 'fuzong', '123', '4', '1726204625@11.com', '1', null);
INSERT INTO `tb_user` VALUES ('5', 'zhuguan', '123', '5', '1587415888@qq.com', '1', null);
INSERT INTO `tb_user` VALUES ('6', 'dongshiz', '123', '6', '454545@163.com', '1', null);
INSERT INTO `tb_user` VALUES ('7', 'jingli2', '123', '7', '1726204625@qq.com', '1', null);
INSERT INTO `tb_user` VALUES ('8', 'dongshiz2', '123', '8', '123123123@qq.com', '1', null);
INSERT INTO `tb_user` VALUES ('9', 'admin', '123456', '9', '510661864@qq.com', '0', '955630ee0abd4e4cb3b991cb2b93a37e0c3f0dce32664105837e1961223c3649');
SET FOREIGN_KEY_CHECKS=1;
