/*
MySQL Data Transfer
Source Host: localhost
Source Database: oamanager
Target Host: localhost
Target Database: oamanager
Date: 2017/11/30 ������ ���� 3:38:22
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for tb_ackforleave
-- ----------------------------
DROP TABLE IF EXISTS `tb_ackforleave`;
CREATE TABLE `tb_ackforleave` (
  `afl_id` int(11) NOT NULL auto_increment,
  `user_id` int(11) default NULL,
  `afl_applicationDate` date default NULL,
  `afl_startdate` date default NULL,
  `afl_endDate` date default NULL,
  `afl_content` text,
  `alfType_id` int(11) default NULL,
  `afl_approvestatus` varchar(50) default NULL,
  `afl_approveContent` text,
  `afl_approveDate` date default NULL,
  PRIMARY KEY  (`afl_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_afltype
-- ----------------------------
DROP TABLE IF EXISTS `tb_afltype`;
CREATE TABLE `tb_afltype` (
  `alfType_id` int(11) NOT NULL auto_increment,
  `aflType_name` varchar(30) default NULL,
  `aflType_descripti` varchar(50) default NULL,
  PRIMARY KEY  (`alfType_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_announcement
-- ----------------------------
DROP TABLE IF EXISTS `tb_announcement`;
CREATE TABLE `tb_announcement` (
  `am_id` int(11) NOT NULL auto_increment,
  `am_theme` varchar(100) NOT NULL,
  `am_conten` text NOT NULL,
  `user_id` int(11) NOT NULL,
  `am_date` date NOT NULL,
  `am_state` int(11) default '0',
  PRIMARY KEY  (`am_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_announcementrange
-- ----------------------------
DROP TABLE IF EXISTS `tb_announcementrange`;
CREATE TABLE `tb_announcementrange` (
  `am_id` int(11) NOT NULL,
  `dept_id` int(11) NOT NULL,
  PRIMARY KEY  (`am_id`,`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_approve
-- ----------------------------
DROP TABLE IF EXISTS `tb_approve`;
CREATE TABLE `tb_approve` (
  `approve_id` int(11) NOT NULL auto_increment,
  `approve_idea` varchar(30) default NULL,
  `approve_date` date default NULL,
  `user_id` int(11) default NULL,
  `offi_id` int(11) default NULL,
  `agreeOrnot` int(11) default NULL,
  PRIMARY KEY  (`approve_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_asset
-- ----------------------------
DROP TABLE IF EXISTS `tb_asset`;
CREATE TABLE `tb_asset` (
  `asset_no` varchar(20) NOT NULL,
  `asset_name` varchar(50) default NULL,
  `dept_id` int(11) default NULL,
  `assettype_id` int(11) default NULL,
  `asset_money` double default NULL,
  `depreciation_year` double default NULL,
  `incomplete_rate` double default NULL,
  `moth_depreciation` double default NULL,
  `asset_nature` int(11) default NULL,
  `asset_date` date default NULL,
  `using_date` date default NULL,
  `user_id` int(11) default NULL,
  `fortifytype_id` int(11) default NULL,
  `asset_descripti` varchar(50) default NULL,
  `asset_img` varchar(50) default NULL,
  PRIMARY KEY  (`asset_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_assetmaintain
-- ----------------------------
DROP TABLE IF EXISTS `tb_assetmaintain`;
CREATE TABLE `tb_assetmaintain` (
  `maintain_id` int(11) NOT NULL auto_increment,
  `asset_no` varchar(20) NOT NULL,
  `maintaintype_id` int(11) NOT NULL,
  `maintain_date` date NOT NULL,
  `user_id` int(11) NOT NULL,
  `maintain_descripti` varchar(50) default NULL,
  PRIMARY KEY  (`maintain_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_assettype
-- ----------------------------
DROP TABLE IF EXISTS `tb_assettype`;
CREATE TABLE `tb_assettype` (
  `assettype_id` int(11) NOT NULL auto_increment,
  `assettype_name` varchar(50) NOT NULL,
  `assettype_date` date NOT NULL,
  `assettype_descripti` varchar(50) default NULL,
  PRIMARY KEY  (`assettype_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_department
-- ----------------------------
DROP TABLE IF EXISTS `tb_department`;
CREATE TABLE `tb_department` (
  `dept_id` int(11) NOT NULL auto_increment,
  `dept_number` varchar(30) default NULL,
  `dept_name` varchar(30) NOT NULL,
  `dept_DESCRIPTI` varchar(50) default NULL,
  PRIMARY KEY  (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_emplyee
-- ----------------------------
DROP TABLE IF EXISTS `tb_emplyee`;
CREATE TABLE `tb_emplyee` (
  `emp_id` int(10) NOT NULL auto_increment,
  `emp_number` varchar(5) NOT NULL,
  `emp_name` varchar(30) NOT NULL,
  `user_id` int(11) NOT NULL,
  `emp_sex` char(2) NOT NULL,
  `emp_brithday` date NOT NULL,
  `pos_id` int(11) NOT NULL,
  `dept_id` int(11) NOT NULL,
  `emp_salary` double NOT NULL,
  `emp_telephone` varchar(20) default NULL,
  `emp_address` varchar(50) default NULL,
  `emp_entrydate` date NOT NULL,
  `marutakstatus` int(11) NOT NULL,
  `emp_photourl` varchar(100) NOT NULL,
  `emp_age` int(11) default NULL,
  PRIMARY KEY  (`emp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_evection
-- ----------------------------
DROP TABLE IF EXISTS `tb_evection`;
CREATE TABLE `tb_evection` (
  `ev_id` int(11) NOT NULL auto_increment,
  `date_ev` date NOT NULL,
  `time_ev` int(11) NOT NULL,
  `cuse_ev` text NOT NULL,
  `cost_ev` int(11) NOT NULL,
  `emp_id` int(11) NOT NULL,
  PRIMARY KEY  (`ev_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_flow_instance
-- ----------------------------
DROP TABLE IF EXISTS `tb_flow_instance`;
CREATE TABLE `tb_flow_instance` (
  `flow_instance_id` int(11) NOT NULL auto_increment,
  `flow_instance_name` varchar(100) default NULL,
  `create_user_id` int(11) default NULL,
  `create_date` date default NULL,
  `finish_date` date default NULL,
  `status` int(11) default NULL,
  `official_id` int(11) default NULL,
  `flow_id` int(11) default NULL,
  PRIMARY KEY  (`flow_instance_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_flow_link
-- ----------------------------
DROP TABLE IF EXISTS `tb_flow_link`;
CREATE TABLE `tb_flow_link` (
  `flow_link_id` int(11) NOT NULL auto_increment,
  `from_step` int(11) default NULL,
  `to_step1` int(11) default NULL,
  `to_step2` int(11) default NULL,
  `to_step3` int(11) default NULL,
  `to_step4` int(11) default NULL,
  `flow_id` int(11) default NULL,
  PRIMARY KEY  (`flow_link_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_flow_template
-- ----------------------------
DROP TABLE IF EXISTS `tb_flow_template`;
CREATE TABLE `tb_flow_template` (
  `flow_id` int(11) NOT NULL auto_increment,
  `flow_name` varchar(50) default NULL,
  `flow_type_id` varchar(50) default NULL,
  `user_id` int(11) default NULL,
  `create_date` date default NULL,
  `modify_user_id` int(11) default NULL,
  `modify_date` date default NULL,
  `version` int(11) default NULL,
  PRIMARY KEY  (`flow_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_flow_type
-- ----------------------------
DROP TABLE IF EXISTS `tb_flow_type`;
CREATE TABLE `tb_flow_type` (
  `flow_type_id` int(11) NOT NULL auto_increment,
  `flow_type_name` varchar(50) default NULL,
  `flow_description` varchar(200) default NULL,
  PRIMARY KEY  (`flow_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_fortifytype
-- ----------------------------
DROP TABLE IF EXISTS `tb_fortifytype`;
CREATE TABLE `tb_fortifytype` (
  `fortifytype_id` int(11) NOT NULL auto_increment,
  `fortifytype_name` varchar(50) NOT NULL,
  `fortifytype_date` date NOT NULL,
  `fortifytype_descripti` varchar(50) default NULL,
  PRIMARY KEY  (`fortifytype_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_function
-- ----------------------------
DROP TABLE IF EXISTS `tb_function`;
CREATE TABLE `tb_function` (
  `fun_id` int(11) NOT NULL auto_increment,
  `fun_name` varchar(30) NOT NULL,
  `fun_url` varchar(30) NOT NULL,
  `fun_forbidden` int(11) NOT NULL,
  `fun_descripti` varchar(50) default NULL,
  PRIMARY KEY  (`fun_id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_inbox
-- ----------------------------
DROP TABLE IF EXISTS `tb_inbox`;
CREATE TABLE `tb_inbox` (
  `receive_id` int(11) NOT NULL auto_increment,
  `inbox_senderId` int(11) NOT NULL,
  `inbox_receiverId` int(11) NOT NULL,
  `inbox_title` varchar(50) NOT NULL,
  `inbox_date` date NOT NULL,
  `receive_state` int(11) NOT NULL,
  `inbox_content` text,
  `email_state` int(11) NOT NULL,
  PRIMARY KEY  (`receive_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_leave
-- ----------------------------
DROP TABLE IF EXISTS `tb_leave`;
CREATE TABLE `tb_leave` (
  `le_id` int(11) NOT NULL auto_increment,
  `date_le` date NOT NULL,
  `time_le` int(11) NOT NULL,
  `cuse_le` varchar(255) NOT NULL,
  `emp_id` int(11) NOT NULL,
  PRIMARY KEY  (`le_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='InnoDB free: 11264 kB';

-- ----------------------------
-- Table structure for tb_mail
-- ----------------------------
DROP TABLE IF EXISTS `tb_mail`;
CREATE TABLE `tb_mail` (
  `mailId` int(11) NOT NULL auto_increment,
  `sender` varchar(50) default NULL,
  `reveicer` varchar(100) default NULL,
  `sereveicer` varchar(100) default NULL,
  `anreveicer` varchar(100) default NULL,
  `subject` varchar(1000) default NULL,
  `content` varchar(2000) default NULL,
  `time` varchar(100) default NULL,
  `attachment` varchar(100) default NULL,
  `date` date default NULL,
  `mtype` int(11) default NULL,
  PRIMARY KEY  (`mailId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_maintaintype
-- ----------------------------
DROP TABLE IF EXISTS `tb_maintaintype`;
CREATE TABLE `tb_maintaintype` (
  `maintaintype_id` int(11) NOT NULL auto_increment,
  `maintaintype_name` varchar(50) NOT NULL,
  `maintaintype_date` date NOT NULL,
  `maintaintype_descripti` varchar(50) default NULL,
  PRIMARY KEY  (`maintaintype_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_official
-- ----------------------------
DROP TABLE IF EXISTS `tb_official`;
CREATE TABLE `tb_official` (
  `offi_id` int(11) NOT NULL auto_increment,
  `offi_name` varchar(30) default NULL,
  `flow_id` int(11) default NULL,
  `offi_date` date default NULL,
  `user_id` int(11) default NULL,
  `offi_state` int(11) default NULL,
  `accrssory_name` varchar(30) default NULL,
  `offi_descripti` varchar(50) default NULL,
  `accessory` mediumblob,
  PRIMARY KEY  (`offi_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_outbox
-- ----------------------------
DROP TABLE IF EXISTS `tb_outbox`;
CREATE TABLE `tb_outbox` (
  `send_id` int(11) NOT NULL auto_increment,
  `outbox_senderId` int(11) NOT NULL,
  `outbox_receiverId` int(11) NOT NULL,
  `outbox_title` varchar(50) NOT NULL,
  `outbox_copyeId` int(11) NOT NULL,
  `outbox_secretId` int(11) NOT NULL,
  `outbox_content` text,
  `outbox_state` int(11) NOT NULL,
  PRIMARY KEY  (`send_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_position
-- ----------------------------
DROP TABLE IF EXISTS `tb_position`;
CREATE TABLE `tb_position` (
  `pos_id` int(11) NOT NULL auto_increment,
  `pos_name` varchar(30) NOT NULL,
  `pos_descripti` varchar(50) NOT NULL,
  PRIMARY KEY  (`pos_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_project_ask
-- ----------------------------
DROP TABLE IF EXISTS `tb_project_ask`;
CREATE TABLE `tb_project_ask` (
  `project_id` int(11) NOT NULL auto_increment,
  `project_name` varchar(50) default NULL,
  `project_date` date default NULL,
  `project_content` varchar(5000) default NULL,
  `project_money` double default NULL,
  `user_id` int(11) default NULL,
  PRIMARY KEY  (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_reimburse
-- ----------------------------
DROP TABLE IF EXISTS `tb_reimburse`;
CREATE TABLE `tb_reimburse` (
  `re_id` int(11) NOT NULL auto_increment,
  `user_id` int(11) default NULL,
  `re_applicationDate` date default NULL,
  `re_content` text,
  `re_money` double default NULL,
  `reimType_id` int(11) default NULL,
  `re_approvestatus` varchar(50) default NULL,
  PRIMARY KEY  (`re_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_reimtype
-- ----------------------------
DROP TABLE IF EXISTS `tb_reimtype`;
CREATE TABLE `tb_reimtype` (
  `reimType_id` int(11) NOT NULL auto_increment,
  `reimType_name` varchar(30) NOT NULL,
  `reimType_descripti` varchar(50) default NULL,
  PRIMARY KEY  (`reimType_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_rfmiddle
-- ----------------------------
DROP TABLE IF EXISTS `tb_rfmiddle`;
CREATE TABLE `tb_rfmiddle` (
  `role_id` int(11) NOT NULL,
  `fun_id` int(11) NOT NULL,
  PRIMARY KEY  (`role_id`,`fun_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role` (
  `role_id` int(11) NOT NULL auto_increment,
  `role_name` varchar(30) NOT NULL,
  `role_descripti` varchar(50) default NULL,
  PRIMARY KEY  (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_rumiddle
-- ----------------------------
DROP TABLE IF EXISTS `tb_rumiddle`;
CREATE TABLE `tb_rumiddle` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY  (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_salary
-- ----------------------------
DROP TABLE IF EXISTS `tb_salary`;
CREATE TABLE `tb_salary` (
  `sal_id` int(11) NOT NULL auto_increment,
  `date_sal` varchar(255) NOT NULL,
  `basic_salary` int(11) NOT NULL,
  `cut_money` int(11) NOT NULL,
  `bonus` int(11) NOT NULL,
  `tax` int(11) NOT NULL,
  `final_sal` int(11) NOT NULL,
  `emp_id` int(11) NOT NULL,
  PRIMARY KEY  (`sal_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_schedule
-- ----------------------------
DROP TABLE IF EXISTS `tb_schedule`;
CREATE TABLE `tb_schedule` (
  `schedule_id` int(11) NOT NULL auto_increment,
  `schedule_date` date default NULL,
  `schedule_desprict` text,
  `user_id` int(11) default NULL,
  PRIMARY KEY  (`schedule_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_stationery
-- ----------------------------
DROP TABLE IF EXISTS `tb_stationery`;
CREATE TABLE `tb_stationery` (
  `STATIONERY_ID` int(11) NOT NULL auto_increment,
  `STATIONERY_NAME` varchar(50) default NULL,
  `STATIONERY_DATE` date default NULL,
  `STATIONERY_MONERY` double default NULL,
  `stationery_amount` int(50) NOT NULL,
  `STATITYPE_ID` int(11) NOT NULL,
  `STATIONERY_descripti` varchar(50) NOT NULL,
  PRIMARY KEY  (`STATIONERY_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_stationerylibarary
-- ----------------------------
DROP TABLE IF EXISTS `tb_stationerylibarary`;
CREATE TABLE `tb_stationerylibarary` (
  `statilibrary_id` int(11) NOT NULL auto_increment,
  `statilibrary_name` varchar(50) NOT NULL,
  `statilibrary_date` date NOT NULL,
  `statilibrary_descripti` varchar(50) NOT NULL,
  PRIMARY KEY  (`statilibrary_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_stationerystatus
-- ----------------------------
DROP TABLE IF EXISTS `tb_stationerystatus`;
CREATE TABLE `tb_stationerystatus` (
  `stationeryStatus_id` int(11) NOT NULL auto_increment,
  `stationery_id` int(50) default NULL,
  `register_type` varchar(50) default NULL,
  `proposer_name` int(50) default NULL,
  `amount` int(11) default NULL,
  `oparate_date` date default NULL,
  `oparate_name` int(11) default NULL,
  `desprict` varchar(50) default NULL,
  `addition_massage` varchar(255) default NULL,
  PRIMARY KEY  (`stationeryStatus_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_stationerytype
-- ----------------------------
DROP TABLE IF EXISTS `tb_stationerytype`;
CREATE TABLE `tb_stationerytype` (
  `statitype_id` int(11) NOT NULL auto_increment,
  `statitype_name` varchar(50) NOT NULL,
  `statitype_date` date NOT NULL,
  `statilibrary_id` int(11) NOT NULL,
  `statitype_descripti` varchar(50) default NULL,
  PRIMARY KEY  (`statitype_id`),
  KEY `FK_Reference_26` (`statilibrary_id`),
  CONSTRAINT `FK_Reference_26` FOREIGN KEY (`statilibrary_id`) REFERENCES `tb_stationerylibarary` (`statilibrary_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_step_instance
-- ----------------------------
DROP TABLE IF EXISTS `tb_step_instance`;
CREATE TABLE `tb_step_instance` (
  `step_instance_id` int(11) NOT NULL auto_increment,
  `step_id` int(11) default NULL,
  `start_date` date default NULL,
  `finish_date` date default NULL,
  `status` int(11) default NULL,
  `emp_id` int(11) default NULL,
  `official_id` int(11) default NULL,
  `Flow_instance_id` int(11) default NULL,
  `commit` int(11) default NULL,
  PRIMARY KEY  (`step_instance_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_step_template
-- ----------------------------
DROP TABLE IF EXISTS `tb_step_template`;
CREATE TABLE `tb_step_template` (
  `step_id` int(11) NOT NULL auto_increment,
  `step_name` varchar(100) default NULL,
  `form_url` varchar(200) default NULL,
  `description` varchar(200) default NULL,
  `step_appoint` varchar(200) default NULL,
  PRIMARY KEY  (`step_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `user_id` int(11) NOT NULL auto_increment,
  `user_name` varchar(30) NOT NULL,
  `user_password` varchar(30) NOT NULL,
  `emp_id` int(11) NOT NULL,
  `user_email` varchar(50) NOT NULL,
  `state` int(11) default NULL,
  `code` varchar(200) default NULL,
  PRIMARY KEY  (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `tb_afltype` VALUES ('1', '事假', ' ');
INSERT INTO `tb_afltype` VALUES ('2', '年假', ' ');
INSERT INTO `tb_afltype` VALUES ('3', '其它', ' ');
INSERT INTO `tb_afltype` VALUES ('4', '婚假', ' ');
INSERT INTO `tb_afltype` VALUES ('5', '病假', ' ');
INSERT INTO `tb_afltype` VALUES ('6', '探亲假', ' ');
INSERT INTO `tb_afltype` VALUES ('7', '产假', null);
INSERT INTO `tb_announcement` VALUES ('2', '你是我的小可爱', '多幸运在最美的年纪遇见你', '1', '2017-11-08', '1');
INSERT INTO `tb_announcement` VALUES ('3', '你是我的小可爱', '多幸运在最美的年纪遇见你', '1', '2017-11-08', '1');
INSERT INTO `tb_announcement` VALUES ('4', '看不见看不见', ' 你你你你哦i', '2', '2017-11-07', '1');
INSERT INTO `tb_announcementrange` VALUES ('1', '1');
INSERT INTO `tb_approve` VALUES ('26', '很漂亮', '2017-11-29', '7', '20', '0');
INSERT INTO `tb_asset` VALUES ('A20170901', '笔记本电脑', '1', '1', '6999', '1', '1', null, '0', '2017-11-10', '2017-11-13', '1', '1', '123', null);
INSERT INTO `tb_asset` VALUES ('A20170902', '笔记本电脑', '2', '1', '6999', '1', '1', null, '0', '2017-11-10', null, '5', '1', '123', null);
INSERT INTO `tb_asset` VALUES ('A20170903', '笔记本电脑', '1', '1', '6999', '1', '1', null, '1', '2017-11-10', null, '3', '3', '123', null);
INSERT INTO `tb_assetmaintain` VALUES ('1', 'A20170901', '1', '2017-11-09', '2', '12331');
INSERT INTO `tb_assettype` VALUES ('1', '电子产品', '2017-11-07', '电子科技产品');
INSERT INTO `tb_assettype` VALUES ('2', '办公设备', '2017-11-06', '办公使用设备');
INSERT INTO `tb_assettype` VALUES ('3', '办公用品', '2017-11-07', '上班用的物品');
INSERT INTO `tb_department` VALUES ('1', '1', '人事部', '人事');
INSERT INTO `tb_department` VALUES ('2', '2', '后勤部', '后勤');
INSERT INTO `tb_department` VALUES ('3', '3', '技术部', '技术');
INSERT INTO `tb_department` VALUES ('4', '4', '开发部', '开发');
INSERT INTO `tb_department` VALUES ('5', '5', '产品部', '产品');
INSERT INTO `tb_department` VALUES ('6', '6', '销售部', '销售');
INSERT INTO `tb_department` VALUES ('7', '7', '财务部', '财务');
INSERT INTO `tb_emplyee` VALUES ('1', '9527', 'jingli', '1', '男', '1999-04-04', '1', '1', '8000', '15211365310', '湖南', '2017-11-02', '0', '/images/man3.jpeg', '24');
INSERT INTO `tb_emplyee` VALUES ('2', '1111', 'putong', '2', '男', '1998-02-06', '6', '1', '7000', '13145685421', '湖南', '2017-11-10', '0', '/images/man1.jpg', '23');
INSERT INTO `tb_emplyee` VALUES ('3', '2222', 'caiwu', '3', '女', '1995-11-08', '3', '1', '8888', '18265445875', '湖南', '2017-11-11', '0', '0', '22');
INSERT INTO `tb_emplyee` VALUES ('4', '3333', 'fuzong', '4', '男', '1994-06-15', '2', '1', '100000', '13154785554', '湖南', '2017-11-11', '0', '0', '25');
INSERT INTO `tb_emplyee` VALUES ('5', '4444', 'zhuguan', '5', '男', '1992-05-16', '5', '1', '2000000', '17258463211', '湖南', '2017-11-11', '0', '0', '28');
INSERT INTO `tb_emplyee` VALUES ('6', '6666', 'dongshiz', '6', '男', '1988-12-06', '4', '1', '20000000', '12345214523', '湖南', '2017-11-12', '0', '0', '35');
INSERT INTO `tb_emplyee` VALUES ('7', '8526', 'jingli2', '7', '男', '1997-05-05', '1', '1', '9654', '18325412226', '湖南', '2017-11-14', '0', '0', '26');
INSERT INTO `tb_emplyee` VALUES ('8', '4567', 'dongshiz2', '8', '男', '1988-01-26', '4', '1', '33333333', '15236984521', '湖南', '2017-11-14', '0', '0', '29');
INSERT INTO `tb_evection` VALUES ('2', '2017-11-30', '40', '40', '40', '2');
INSERT INTO `tb_evection` VALUES ('3', '2017-11-08', '3', 'qwe', '300', '4');
INSERT INTO `tb_evection` VALUES ('4', '2017-11-21', '3', 'qwe', '600', '2');
INSERT INTO `tb_evection` VALUES ('5', '2017-10-11', '3', 'www', '500', '2');
INSERT INTO `tb_evection` VALUES ('6', '2017-10-10', '7', 'sss', '200', '2');
INSERT INTO `tb_evection` VALUES ('7', '2017-12-14', '5', '100', '200', '2');
INSERT INTO `tb_evection` VALUES ('8', '2017-11-23', '11', '12312', '22', '5');
INSERT INTO `tb_evection` VALUES ('9', '2017-11-10', '2', 'sdfs', '22', '2');
INSERT INTO `tb_flow_instance` VALUES ('20', '请假实例', '1', '2017-11-29', null, '0', '20', '9');
INSERT INTO `tb_flow_type` VALUES ('1', '工作流程', '工作流程');
INSERT INTO `tb_flow_type` VALUES ('2', '业务流程', '业务流程');
INSERT INTO `tb_fortifytype` VALUES ('1', '购入不需要安装的固定资产', '2017-11-07', '直接使用不用安装');
INSERT INTO `tb_fortifytype` VALUES ('2', '购入需要安装已完工的固定资产', '2017-11-07', '直接使用不用安装');
INSERT INTO `tb_fortifytype` VALUES ('3', '其他单位转入的固定资产（新设备）', '2017-11-07', '新设备');
INSERT INTO `tb_fortifytype` VALUES ('4', '其他单位转入的固定资产（旧设备）', '2017-11-07', '旧设备');
INSERT INTO `tb_fortifytype` VALUES ('5', '捐赠的固定资产', '2017-11-07', '捐赠的');
INSERT INTO `tb_fortifytype` VALUES ('6', '融资租赁的固定资产', '2017-11-07', '融资租赁');
INSERT INTO `tb_function` VALUES ('1', '编辑', 'redact', '0', '用于数据的增删改');
INSERT INTO `tb_function` VALUES ('2', '保存word文档', 'buildWord', '0', '插入并返回主键');
INSERT INTO `tb_function` VALUES ('3', '公文管理', 'officialCommitDeleteApprove', '0', '添加审批记录');
INSERT INTO `tb_function` VALUES ('4', '添加公文', 'officialAdd', '0', '添加公文');
INSERT INTO `tb_function` VALUES ('5', '添加流程步骤', 'addWorkFlow', '0', '批量插入流程步骤');
INSERT INTO `tb_function` VALUES ('6', '删除流程', 'deleteWorkFlow', '0', '删除');
INSERT INTO `tb_function` VALUES ('7', '我的日程', 'mySchedule', '0', '我的日程');
INSERT INTO `tb_function` VALUES ('8', '授权', 'impower', '0', '授权');
INSERT INTO `tb_leave` VALUES ('2', '2017-11-24', '4', 'asdas', '2');
INSERT INTO `tb_leave` VALUES ('3', '2017-10-12', '3', 'saa', '2');
INSERT INTO `tb_leave` VALUES ('4', '2017-10-20', '5', 'ui', '2');
INSERT INTO `tb_leave` VALUES ('5', '2017-10-01', '7', '99', '4');
INSERT INTO `tb_leave` VALUES ('6', '2017-10-18', '6', '99', '4');
INSERT INTO `tb_leave` VALUES ('7', '2017-10-10', '5', '234', '5');
INSERT INTO `tb_leave` VALUES ('8', '2017-10-26', '5', 'qw', '5');
INSERT INTO `tb_mail` VALUES ('1', '小明', 'duhu,px,zsm,cyj', '无', '无', '群发测试', '<p>测试中</p>\r\n', '2017年11月16日 星期四 21:19 ', 'userface1.jpg', null, '0');
INSERT INTO `tb_mail` VALUES ('2', '小明', 'dd,admin', '无', '无', '多幸运在最美的年纪遇见你', '<p>群发测试</p>\r\n', '2017年11月16日 星期四 21:34 ', 'userface1.jpg', null, '0');
INSERT INTO `tb_mail` VALUES ('3', '小明', 'dd', '无', '无', '你好', '<p>你好啊我的小</p>\r\n', '2017年11月16日 星期四 21:39 ', '', null, '0');
INSERT INTO `tb_mail` VALUES ('4', '小明', 'zsm', 'admin', '无', '群发测试', '<p>测试</p>\r\n', '2017年11月16日 星期四 22:25 ', 'userface1.jpg', null, '0');
INSERT INTO `tb_mail` VALUES ('5', '小明', 'px,cyj,zsm,th,admin', '无', '无', '群发测试', '<p>测试中</p>\r\n', '2017年11月17日 星期五 13:58 ', 'userface1.jpg', null, '0');
INSERT INTO `tb_mail` VALUES ('6', '小明', 'duhu,admin,th,px,cyj', '无', '无', '多幸运群发测试', '<p>测试中</p>\r\n', '2017年11月22日 星期三 17:03 ', '', null, '0');
INSERT INTO `tb_maintaintype` VALUES ('1', '应急性', '2017-11-08', '急需维护时');
INSERT INTO `tb_maintaintype` VALUES ('2', '预防性', '2017-11-08', '预防机器故障');
INSERT INTO `tb_maintaintype` VALUES ('3', '针对性', '2017-11-08', '针对机器故障问题');
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
INSERT INTO `tb_reimtype` VALUES ('1', '经典报销', null);
INSERT INTO `tb_rfmiddle` VALUES ('1', '1');
INSERT INTO `tb_rfmiddle` VALUES ('1', '2');
INSERT INTO `tb_rfmiddle` VALUES ('1', '3');
INSERT INTO `tb_rfmiddle` VALUES ('1', '4');
INSERT INTO `tb_rfmiddle` VALUES ('1', '5');
INSERT INTO `tb_rfmiddle` VALUES ('1', '6');
INSERT INTO `tb_rfmiddle` VALUES ('1', '7');
INSERT INTO `tb_rfmiddle` VALUES ('1', '8');
INSERT INTO `tb_role` VALUES ('1', 'admin', '超级管理员');
INSERT INTO `tb_role` VALUES ('2', 'nomal', '普通管理员');
INSERT INTO `tb_rumiddle` VALUES ('1', '1');
INSERT INTO `tb_rumiddle` VALUES ('2', '2');
INSERT INTO `tb_rumiddle` VALUES ('3', '1');
INSERT INTO `tb_rumiddle` VALUES ('4', '2');
INSERT INTO `tb_rumiddle` VALUES ('5', '2');
INSERT INTO `tb_rumiddle` VALUES ('6', '2');
INSERT INTO `tb_rumiddle` VALUES ('7', '1');
INSERT INTO `tb_salary` VALUES ('6', '2017-11', '1200', '160', '40', '120', '960', '2');
INSERT INTO `tb_salary` VALUES ('7', '2017-11', '1800', '0', '0', '180', '1620', '3');
INSERT INTO `tb_salary` VALUES ('8', '2017-11', '4000', '0', '0', '400', '3600', '8');
INSERT INTO `tb_salary` VALUES ('9', '2017-11', '1200', '0', '0', '120', '1080', '6');
INSERT INTO `tb_salary` VALUES ('10', '2017-11', '1200', '0', '0', '120', '1080', '4');
INSERT INTO `tb_schedule` VALUES ('5', '2017-10-23', '你好', '1');
INSERT INTO `tb_schedule` VALUES ('8', '2017-11-29', '游戏', '1');
INSERT INTO `tb_stationery` VALUES ('1', 'dd', '2017-11-15', '543', '910', '1', '111');
INSERT INTO `tb_stationery` VALUES ('8', 'ee', '2017-11-17', '1', '1', '1', 'dd');
INSERT INTO `tb_stationery` VALUES ('9', 'dd', '2017-11-15', '543', '15', '5', '111');
INSERT INTO `tb_stationery` VALUES ('10', 'dd', '2017-11-15', '543', '20', '4', '111');
INSERT INTO `tb_stationery` VALUES ('11', 'dd', '2017-11-15', '543', '20', '4', '111');
INSERT INTO `tb_stationery` VALUES ('12', 'dd', '2017-11-15', '543', '20', '4', '111');
INSERT INTO `tb_stationery` VALUES ('13', 'dd', '2017-11-29', '543', '20', '1', '111');
INSERT INTO `tb_stationerylibarary` VALUES ('1', '杨枝龙', '2017-11-16', '很帅');
INSERT INTO `tb_stationerylibarary` VALUES ('2', '你好', '2017-11-25', '全');
INSERT INTO `tb_stationerystatus` VALUES ('1', '1', '领用', '1', '10', '2017-11-15', '1', '1111', null);
INSERT INTO `tb_stationerystatus` VALUES ('2', null, '借用', '2', '10', '2017-11-17', '1', null, null);
INSERT INTO `tb_stationerystatus` VALUES ('3', null, '维护', '2', null, '2017-11-17', '1', null, null);
INSERT INTO `tb_stationerystatus` VALUES ('4', '8', '采购入库', '6', '10', '2017-11-17', '1', '123456', null);
INSERT INTO `tb_stationerystatus` VALUES ('5', '1', '领用', '7', '10', '2017-11-17', '1', '123456', null);
INSERT INTO `tb_stationerystatus` VALUES ('6', '1', '借用', '8', '10', '2017-11-18', '1', '123', '未归还');
INSERT INTO `tb_stationerystatus` VALUES ('7', '9', '采购入库', '6', '20', '2017-11-20', '1', '1232543543', null);
INSERT INTO `tb_stationerystatus` VALUES ('8', '9', '领用', '6', '5', '2017-11-20', '1', '12678', null);
INSERT INTO `tb_stationerystatus` VALUES ('9', '1', '领用', '1', '20', '2017-11-29', '1', '123343', null);
INSERT INTO `tb_stationerystatus` VALUES ('10', '9', '采购入库', '2', '10', '2017-11-30', '1', '1231', null);
INSERT INTO `tb_stationerytype` VALUES ('1', '你号', '2017-11-24', '2', '我');
INSERT INTO `tb_stationerytype` VALUES ('4', '你好', '2017-11-24', '2', '大家好');
INSERT INTO `tb_stationerytype` VALUES ('5', '滚', '2017-11-22', '1', '大');
INSERT INTO `tb_step_instance` VALUES ('8', '2', '2017-11-29', null, '2', '1', '20', '20', '1');
INSERT INTO `tb_step_instance` VALUES ('9', '4', '2017-11-29', null, '1', '5', '20', '20', null);
INSERT INTO `tb_step_template` VALUES ('1', '开始', null, null, null);
INSERT INTO `tb_step_template` VALUES ('2', '经理审批', null, null, '经理');
INSERT INTO `tb_step_template` VALUES ('3', '副经理审批', null, null, '副经理');
INSERT INTO `tb_step_template` VALUES ('4', '主管审批', null, null, '主管');
INSERT INTO `tb_step_template` VALUES ('5', '财务总经理审批', null, null, '财务总经理');
INSERT INTO `tb_step_template` VALUES ('6', '董事长审批', null, null, '董事长');
INSERT INTO `tb_step_template` VALUES ('7', '结束', null, null, null);
INSERT INTO `tb_step_template` VALUES ('8', '项目经理审批', null, null, '项目经理');
INSERT INTO `tb_user` VALUES ('1', 'jingli', '123', '1', '1726204625@qq.com', '1', null);
INSERT INTO `tb_user` VALUES ('2', 'putong', '123', '2', '2325293782@qq.com', '1', null);
INSERT INTO `tb_user` VALUES ('3', 'caiwu', '123', '3', '1726204625@qq.com', '1', null);
INSERT INTO `tb_user` VALUES ('4', 'fuzong', '123', '4', '1726204625@11.com', '1', null);
INSERT INTO `tb_user` VALUES ('5', 'zhuguan', '123', '5', '1587415888@qq.com', '1', null);
INSERT INTO `tb_user` VALUES ('6', 'dongshiz', '123', '6', '454545@163.com', '1', null);
INSERT INTO `tb_user` VALUES ('7', 'jingli2', '123', '7', '1726204625@qq.com', '1', null);
INSERT INTO `tb_user` VALUES ('8', 'dongshiz2', '123', '8', '1726204625@qq.com', '1', null);
