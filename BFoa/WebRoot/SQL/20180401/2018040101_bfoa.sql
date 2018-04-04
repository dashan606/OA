/*
Navicat MySQL Data Transfer

Source Server         : localhsot
Source Server Version : 50720
Source Host           : 127.0.0.1:3306
Source Database       : bfoa

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-04-05 02:24:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_dep
-- ----------------------------
DROP TABLE IF EXISTS `tb_dep`;
CREATE TABLE `tb_dep` (
  `dep_id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT NULL,
  `dep_sn` varchar(255) DEFAULT NULL,
  `dep_name` varchar(255) DEFAULT NULL,
  `dep_desc` varchar(255) DEFAULT NULL,
  `flag` int(11) DEFAULT NULL,
  PRIMARY KEY (`dep_id`),
  KEY `FKCB83DABE7519F32E` (`pid`),
  CONSTRAINT `FKCB83DABE7519F32E` FOREIGN KEY (`pid`) REFERENCES `tb_dep` (`dep_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_dep
-- ----------------------------
INSERT INTO `tb_dep` VALUES ('1', null, 'dep001', '总裁办', '总裁办公室', '1');
INSERT INTO `tb_dep` VALUES ('2', '1', 'dep002', '经理办', '经理办公室', '1');
INSERT INTO `tb_dep` VALUES ('3', '2', 'dep003', '客服部', '客服部', '1');
INSERT INTO `tb_dep` VALUES ('4', '3', 'dep004', '咨询服务', '客服部-咨询服务', '1');
INSERT INTO `tb_dep` VALUES ('5', '3', 'dep005', '投诉纠纷', '客服部-投诉纠纷', '1');
INSERT INTO `tb_dep` VALUES ('6', '3', 'dep006', '售后服务', '客服部-售后服务', '1');
INSERT INTO `tb_dep` VALUES ('7', '2', 'dep007', '技术部', '技术部', '1');
INSERT INTO `tb_dep` VALUES ('8', '7', 'dep008', '美工设计', '技术部-美工设计', '1');
INSERT INTO `tb_dep` VALUES ('9', '7', 'dep009', '系统开发', '技术部-系统开发', '1');
INSERT INTO `tb_dep` VALUES ('10', '7', 'dep010', '测试体验', '技术部-测试体验', '1');
INSERT INTO `tb_dep` VALUES ('11', '2', 'dep011', '市场部', '市场部', '1');
INSERT INTO `tb_dep` VALUES ('12', '11', 'dep012', '活动推广', '市场部-活动推广', '1');
INSERT INTO `tb_dep` VALUES ('13', '11', 'dep013', '营销策划', '市场部-营销策划', '1');
INSERT INTO `tb_dep` VALUES ('14', '11', 'dep014', '商务洽谈', '市场部-商务洽谈', '1');
INSERT INTO `tb_dep` VALUES ('15', '2', 'dep015', '财务部', '财务部', '1');
INSERT INTO `tb_dep` VALUES ('16', '2', 'dep016', '人事部', '人事部', '1');
INSERT INTO `tb_dep` VALUES ('17', '16', 'dep017', '员工招聘', '人事部-员工招聘', '1');

-- ----------------------------
-- Table structure for tb_emp
-- ----------------------------
DROP TABLE IF EXISTS `tb_emp`;
CREATE TABLE `tb_emp` (
  `emp_id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_sn` varchar(255) DEFAULT NULL,
  `emp_name` varchar(255) DEFAULT NULL,
  `emp_sex` varchar(255) DEFAULT NULL,
  `emp_address` varchar(255) DEFAULT NULL,
  `emp_phone` varchar(255) DEFAULT NULL,
  `emp_job` varchar(255) DEFAULT NULL,
  `emp_img` varchar(255) DEFAULT NULL,
  `flag` int(11) DEFAULT NULL,
  `dep_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`emp_id`),
  KEY `FKCB83DF77258080EE` (`dep_id`),
  CONSTRAINT `FKCB83DF77258080EE` FOREIGN KEY (`dep_id`) REFERENCES `tb_dep` (`dep_id`)
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_emp
-- ----------------------------
INSERT INTO `tb_emp` VALUES ('1', 'emp001', '赵继锋', '男', '郑州二七区紫荆山南路001号', '18899880001', '董事长', '', '1', '1');
INSERT INTO `tb_emp` VALUES ('2', 'emp002', '赵秋凤', '女', '郑州二七区紫荆山南路002号', '18899880002', '总经理', '', '1', '2');
INSERT INTO `tb_emp` VALUES ('3', 'emp003', '赵煜康', '男', '郑州二七区紫荆山南路003号', '18899880003', '客服部经理', '', '1', '3');
INSERT INTO `tb_emp` VALUES ('4', 'emp004', '赵士皓', '男', '郑州二七区紫荆山南路004号', '18899880004', '技术部经理', '', '1', '7');
INSERT INTO `tb_emp` VALUES ('5', 'emp005', '赵添冶', '男', '郑州二七区紫荆山南路005号', '18899880005', '市场部经理', '', '1', '11');
INSERT INTO `tb_emp` VALUES ('6', 'emp006', '赵玉容', '女', '郑州二七区紫荆山南路006号', '18899880006', '财务部经理', '', '1', '15');
INSERT INTO `tb_emp` VALUES ('7', 'emp007', '赵乐', '女', '郑州二七区紫荆山南路007号', '18899880007', '人事部经理', '', '1', '16');
INSERT INTO `tb_emp` VALUES ('8', 'emp008', '赵甜冶', '女', '郑州二七区紫荆山南路008号', '18899880008', '客服部主管', '', '1', '3');
INSERT INTO `tb_emp` VALUES ('9', 'emp009', '赵永和', '女', '郑州二七区紫荆山南路009号', '18899880009', '技术部主管', '', '1', '7');
INSERT INTO `tb_emp` VALUES ('10', 'emp010', '赵刚', '男', '郑州二七区紫荆山南路010号', '18899880010', '市场部主管', '', '1', '11');
INSERT INTO `tb_emp` VALUES ('11', 'emp011', '赵艳臣', '女', '郑州二七区紫荆山南路011号', '18899880011', '财务部主管', '', '1', '15');
INSERT INTO `tb_emp` VALUES ('12', 'emp012', '赵贵阳', '男', '郑州二七区紫荆山南路012号', '18899880012', '人事部主管', '', '1', '16');
INSERT INTO `tb_emp` VALUES ('13', 'emp013', '赵舔业', '男', '郑州二七区紫荆山南路013号', '18899880013', '客服部主管', '', '1', '3');
INSERT INTO `tb_emp` VALUES ('14', 'emp014', '赵薇', '男', '郑州二七区紫荆山南路014号', '18899880014', '技术部主管', '', '1', '7');
INSERT INTO `tb_emp` VALUES ('15', 'emp015', '赵湛博', '女', '郑州二七区紫荆山南路015号', '18899880015', '市场部主管', '', '1', '11');
INSERT INTO `tb_emp` VALUES ('16', 'emp016', '赵岩', '女', '郑州二七区紫荆山南路016号', '18899880016', '财务部主管', '', '1', '15');
INSERT INTO `tb_emp` VALUES ('17', 'emp017', '赵泰彰', '女', '郑州二七区紫荆山南路017号', '18899880017', '人事部主管', '', '1', '16');
INSERT INTO `tb_emp` VALUES ('18', 'emp018', '赵欷西', '女', '郑州二七区紫荆山南路018号', '18899880018', '客服部主管', '', '1', '3');
INSERT INTO `tb_emp` VALUES ('19', 'emp019', '赵华', '男', '郑州二七区紫荆山南路019号', '18899880019', '技术部主管', '', '1', '7');
INSERT INTO `tb_emp` VALUES ('20', 'emp020', '赵倩云', '女', '郑州二七区紫荆山南路020号', '18899880020', '市场部主管', '', '1', '11');
INSERT INTO `tb_emp` VALUES ('21', 'emp021', '赵春燕', '女', '郑州二七区紫荆山南路021号', '18899880021', '财务部主管', '', '1', '15');
INSERT INTO `tb_emp` VALUES ('22', 'emp022', '赵石浩', '女', '郑州二七区紫荆山南路022号', '18899880022', '人事部主管', '', '1', '16');
INSERT INTO `tb_emp` VALUES ('23', 'emp023', '赵静', '女', '郑州二七区紫荆山南路023号', '18899880023', '普通员工', '', '1', '4');
INSERT INTO `tb_emp` VALUES ('24', 'emp024', '赵瑞凯', '男', '郑州二七区紫荆山南路024号', '18899880024', '普通员工', '', '1', '5');
INSERT INTO `tb_emp` VALUES ('25', 'emp025', '赵嘉琦', '女', '郑州二七区紫荆山南路025号', '18899880025', '普通员工', '', '1', '6');
INSERT INTO `tb_emp` VALUES ('26', 'emp026', '赵俊霞', '男', '郑州二七区紫荆山南路026号', '18899880026', '普通员工', '', '1', '8');
INSERT INTO `tb_emp` VALUES ('27', 'emp027', '赵鹏', '男', '郑州二七区紫荆山南路027号', '18899880027', '普通员工', '', '1', '9');
INSERT INTO `tb_emp` VALUES ('28', 'emp028', '赵一鹤', '男', '郑州二七区紫荆山南路028号', '18899880028', '普通员工', '', '1', '10');
INSERT INTO `tb_emp` VALUES ('29', 'emp029', '赵梓含', '女', '郑州二七区紫荆山南路029号', '18899880029', '普通员工', '', '1', '12');
INSERT INTO `tb_emp` VALUES ('30', 'emp030', '赵若岚', '女', '郑州二七区紫荆山南路030号', '18899880030', '普通员工', '', '1', '13');
INSERT INTO `tb_emp` VALUES ('31', 'emp031', '赵若兰', '男', '郑州二七区紫荆山南路031号', '18899880031', '普通员工', '', '1', '14');
INSERT INTO `tb_emp` VALUES ('32', 'emp032', '赵泉', '女', '郑州二七区紫荆山南路032号', '18899880032', '普通员工', '', '1', '15');
INSERT INTO `tb_emp` VALUES ('33', 'emp033', '赵俊芳', '女', '郑州二七区紫荆山南路033号', '18899880033', '普通员工', '', '1', '16');
INSERT INTO `tb_emp` VALUES ('34', 'emp034', '赵文婷', '女', '郑州二七区紫荆山南路034号', '18899880034', '普通员工', '', '1', '4');
INSERT INTO `tb_emp` VALUES ('35', 'emp035', '赵家同', '男', '郑州二七区紫荆山南路035号', '18899880035', '普通员工', '', '1', '5');
INSERT INTO `tb_emp` VALUES ('36', 'emp036', '赵子怡', '男', '郑州二七区紫荆山南路036号', '18899880036', '普通员工', '', '1', '6');
INSERT INTO `tb_emp` VALUES ('37', 'emp037', '赵英博', '女', '郑州二七区紫荆山南路037号', '18899880037', '普通员工', '', '1', '8');
INSERT INTO `tb_emp` VALUES ('38', 'emp038', '赵珈影', '女', '郑州二七区紫荆山南路038号', '18899880038', '普通员工', '', '1', '9');
INSERT INTO `tb_emp` VALUES ('39', 'emp039', '赵凯', '女', '郑州二七区紫荆山南路039号', '18899880039', '普通员工', '', '1', '10');
INSERT INTO `tb_emp` VALUES ('40', 'emp040', '赵丽', '女', '郑州二七区紫荆山南路040号', '18899880040', '普通员工', '', '1', '12');
INSERT INTO `tb_emp` VALUES ('41', 'emp041', '赵竣景', '男', '郑州二七区紫荆山南路041号', '18899880041', '普通员工', '', '1', '13');
INSERT INTO `tb_emp` VALUES ('42', 'emp042', '赵晏', '女', '郑州二七区紫荆山南路042号', '18899880042', '普通员工', '', '1', '14');
INSERT INTO `tb_emp` VALUES ('43', 'emp043', '赵大炜', '男', '郑州二七区紫荆山南路043号', '18899880043', '普通员工', '', '1', '15');
INSERT INTO `tb_emp` VALUES ('44', 'emp044', '赵琳', '男', '郑州二七区紫荆山南路044号', '18899880044', '普通员工', '', '1', '16');
INSERT INTO `tb_emp` VALUES ('45', 'emp045', '赵以萍', '男', '郑州二七区紫荆山南路045号', '18899880045', '普通员工', '', '1', '4');
INSERT INTO `tb_emp` VALUES ('46', 'emp046', '赵子仪', '女', '郑州二七区紫荆山南路046号', '18899880046', '普通员工', '', '1', '5');
INSERT INTO `tb_emp` VALUES ('47', 'emp047', '钱畅', '女', '郑州二七区紫荆山南路047号', '18899880047', '普通员工', '', '1', '6');
INSERT INTO `tb_emp` VALUES ('48', 'emp048', '钱向春', '女', '郑州二七区紫荆山南路048号', '18899880048', '普通员工', '', '1', '8');
INSERT INTO `tb_emp` VALUES ('49', 'emp049', '钱玥娴', '女', '郑州二七区紫荆山南路049号', '18899880049', '普通员工', '', '1', '9');
INSERT INTO `tb_emp` VALUES ('50', 'emp050', '钱刚', '男', '郑州二七区紫荆山南路050号', '18899880050', '普通员工', '', '1', '10');
INSERT INTO `tb_emp` VALUES ('51', 'emp051', '钱宇杰', '女', '郑州二七区紫荆山南路051号', '18899880051', '普通员工', '', '1', '12');
INSERT INTO `tb_emp` VALUES ('52', 'emp052', '钱海东', '女', '郑州二七区紫荆山南路052号', '18899880052', '普通员工', '', '1', '13');
INSERT INTO `tb_emp` VALUES ('53', 'emp053', '钱家驹', '女', '郑州二七区紫荆山南路053号', '18899880053', '普通员工', '', '1', '14');
INSERT INTO `tb_emp` VALUES ('54', 'emp054', '钱丽琴', '女', '郑州二七区紫荆山南路054号', '18899880054', '普通员工', '', '1', '4');
INSERT INTO `tb_emp` VALUES ('55', 'emp055', '钱博通', '男', '郑州二七区紫荆山南路055号', '18899880055', '普通员工', '', '1', '5');
INSERT INTO `tb_emp` VALUES ('56', 'emp056', '钱文贤', '女', '郑州二七区紫荆山南路056号', '18899880056', '普通员工', '', '1', '6');
INSERT INTO `tb_emp` VALUES ('57', 'emp057', '钱小琴', '男', '郑州二七区紫荆山南路057号', '18899880057', '普通员工', '', '1', '8');
INSERT INTO `tb_emp` VALUES ('58', 'emp058', '钱广通', '男', '郑州二七区紫荆山南路058号', '18899880058', '普通员工', '', '1', '9');
INSERT INTO `tb_emp` VALUES ('59', 'emp059', '钱丽琇', '男', '郑州二七区紫荆山南路059号', '18899880059', '普通员工', '', '1', '10');
INSERT INTO `tb_emp` VALUES ('60', 'emp060', '钱诚', '女', '郑州二七区紫荆山南路060号', '18899880060', '普通员工', '', '1', '12');
INSERT INTO `tb_emp` VALUES ('61', 'emp061', '钱学豪', '女', '郑州二七区紫荆山南路061号', '18899880061', '普通员工', '', '1', '13');
INSERT INTO `tb_emp` VALUES ('62', 'emp062', '钱展成', '男', '郑州二七区紫荆山南路062号', '18899880062', '普通员工', '', '1', '14');
INSERT INTO `tb_emp` VALUES ('63', 'emp063', '钱展灰', '女', '郑州二七区紫荆山南路063号', '18899880063', '普通员工', '', '1', '4');
INSERT INTO `tb_emp` VALUES ('64', 'emp064', '钱灰展', '女', '郑州二七区紫荆山南路064号', '18899880064', '普通员工', '', '1', '5');
INSERT INTO `tb_emp` VALUES ('65', 'emp065', '钱展森', '男', '郑州二七区紫荆山南路065号', '18899880065', '普通员工', '', '1', '6');
INSERT INTO `tb_emp` VALUES ('66', 'emp066', '钱森展', '女', '郑州二七区紫荆山南路066号', '18899880066', '普通员工', '', '1', '8');
INSERT INTO `tb_emp` VALUES ('67', 'emp067', '钱展城', '女', '郑州二七区紫荆山南路067号', '18899880067', '普通员工', '', '1', '9');
INSERT INTO `tb_emp` VALUES ('68', 'emp068', '钱旭成', '女', '郑州二七区紫荆山南路068号', '18899880068', '普通员工', '', '1', '10');
INSERT INTO `tb_emp` VALUES ('69', 'emp069', '钱成旭', '女', '郑州二七区紫荆山南路069号', '18899880069', '普通员工', '', '1', '12');
INSERT INTO `tb_emp` VALUES ('70', 'emp070', '钱旭', '男', '郑州二七区紫荆山南路070号', '18899880070', '普通员工', '', '1', '13');
INSERT INTO `tb_emp` VALUES ('71', 'emp071', '钱辉煌', '女', '郑州二七区紫荆山南路071号', '18899880071', '普通员工', '', '1', '14');
INSERT INTO `tb_emp` VALUES ('72', 'emp072', '钱展水', '男', '郑州二七区紫荆山南路072号', '18899880072', '普通员工', '', '1', '4');
INSERT INTO `tb_emp` VALUES ('73', 'emp073', '钱展翔', '男', '郑州二七区紫荆山南路073号', '18899880073', '普通员工', '', '1', '5');
INSERT INTO `tb_emp` VALUES ('74', 'emp074', '钱展翅', '男', '郑州二七区紫荆山南路074号', '18899880074', '普通员工', '', '1', '6');
INSERT INTO `tb_emp` VALUES ('75', 'emp075', '钱展吉', '女', '郑州二七区紫荆山南路075号', '18899880075', '普通员工', '', '1', '8');
INSERT INTO `tb_emp` VALUES ('76', 'emp076', '钱程', '女', '郑州二七区紫荆山南路076号', '18899880076', '普通员工', '', '1', '9');
INSERT INTO `tb_emp` VALUES ('77', 'emp077', '钱广燕', '女', '郑州二七区紫荆山南路077号', '18899880077', '普通员工', '', '1', '10');
INSERT INTO `tb_emp` VALUES ('78', 'emp078', '钱珈萱', '女', '郑州二七区紫荆山南路078号', '18899880078', '普通员工', '', '1', '12');
INSERT INTO `tb_emp` VALUES ('79', 'emp079', '钱碎英', '男', '郑州二七区紫荆山南路079号', '18899880079', '普通员工', '', '1', '13');
INSERT INTO `tb_emp` VALUES ('80', 'emp080', '钱龙风', '女', '郑州二七区紫荆山南路080号', '18899880080', '普通员工', '', '1', '14');
INSERT INTO `tb_emp` VALUES ('81', 'emp081', '钱成祥', '女', '郑州二七区紫荆山南路081号', '18899880081', '普通员工', '', '1', '4');
INSERT INTO `tb_emp` VALUES ('82', 'emp082', '钱成龙', '女', '郑州二七区紫荆山南路082号', '18899880082', '普通员工', '', '1', '5');
INSERT INTO `tb_emp` VALUES ('83', 'emp083', '钱晨洋', '女', '郑州二七区紫荆山南路083号', '18899880083', '普通员工', '', '1', '6');
INSERT INTO `tb_emp` VALUES ('84', 'emp084', '钱一平', '男', '郑州二七区紫荆山南路084号', '18899880084', '普通员工', '', '1', '8');
INSERT INTO `tb_emp` VALUES ('85', 'emp085', '钱新建', '女', '郑州二七区紫荆山南路085号', '18899880085', '普通员工', '', '1', '9');
INSERT INTO `tb_emp` VALUES ('86', 'emp086', '钱玮', '男', '郑州二七区紫荆山南路086号', '18899880086', '普通员工', '', '1', '10');
INSERT INTO `tb_emp` VALUES ('87', 'emp087', '钱凤英', '男', '郑州二七区紫荆山南路087号', '18899880087', '普通员工', '', '1', '12');
INSERT INTO `tb_emp` VALUES ('88', 'emp088', '钱晓聪', '男', '郑州二七区紫荆山南路088号', '18899880088', '普通员工', '', '1', '13');
INSERT INTO `tb_emp` VALUES ('89', 'emp089', '钱孝聪', '女', '郑州二七区紫荆山南路089号', '18899880089', '普通员工', '', '1', '14');
INSERT INTO `tb_emp` VALUES ('90', 'emp090', '钱骊嫒', '女', '郑州二七区紫荆山南路090号', '18899880090', '普通员工', '', '1', '4');

-- ----------------------------
-- Table structure for tb_group
-- ----------------------------
DROP TABLE IF EXISTS `tb_group`;
CREATE TABLE `tb_group` (
  `g_id` int(11) NOT NULL AUTO_INCREMENT,
  `g_name` varchar(255) DEFAULT NULL,
  `flag` int(11) DEFAULT NULL,
  `g_sn` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`g_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_group
-- ----------------------------
INSERT INTO `tb_group` VALUES ('1', '超级管理员', '1', '001');

-- ----------------------------
-- Table structure for tb_impower
-- ----------------------------
DROP TABLE IF EXISTS `tb_impower`;
CREATE TABLE `tb_impower` (
  `im_id` int(11) NOT NULL AUTO_INCREMENT,
  `mainBody_id` int(11) DEFAULT NULL,
  `mainBody_type` varchar(255) DEFAULT NULL,
  `module_id` int(11) DEFAULT NULL,
  `saveOption` int(11) DEFAULT NULL,
  `queryOption` int(11) DEFAULT NULL,
  `deleteOption` int(11) DEFAULT NULL,
  `updateOption` int(11) DEFAULT NULL,
  `extOption` int(11) DEFAULT NULL,
  PRIMARY KEY (`im_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_impower
-- ----------------------------
INSERT INTO `tb_impower` VALUES ('1', '1', 'group', '1', '1', '1', '1', '1', '1');
INSERT INTO `tb_impower` VALUES ('2', '1', 'group', '2', '1', '1', '1', '1', '1');
INSERT INTO `tb_impower` VALUES ('3', '1', 'group', '3', '1', '1', '1', '1', '1');
INSERT INTO `tb_impower` VALUES ('4', '1', 'group', '4', '1', '1', '1', '1', '1');
INSERT INTO `tb_impower` VALUES ('5', '1', 'group', '5', '1', '1', '1', '1', '1');
INSERT INTO `tb_impower` VALUES ('6', '1', 'group', '6', '1', '1', '1', '1', '1');
INSERT INTO `tb_impower` VALUES ('7', '1', 'user', '1', '1', '1', '1', '1', '1');

-- ----------------------------
-- Table structure for tb_mod
-- ----------------------------
DROP TABLE IF EXISTS `tb_mod`;
CREATE TABLE `tb_mod` (
  `m_id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT NULL,
  `m_sn` varchar(255) DEFAULT NULL,
  `m_name` varchar(255) DEFAULT NULL,
  `m_address` varchar(255) DEFAULT NULL,
  `m_path_c` varchar(255) DEFAULT NULL,
  `m_path_n` varchar(255) DEFAULT NULL,
  `flag` int(11) DEFAULT NULL,
  PRIMARY KEY (`m_id`),
  KEY `FKCB83FDB1F8A74A7` (`pid`),
  CONSTRAINT `FKCB83FDB1F8A74A7` FOREIGN KEY (`pid`) REFERENCES `tb_mod` (`m_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_mod
-- ----------------------------
INSERT INTO `tb_mod` VALUES ('1', null, 'mod001', '组织管理', 'bfmod/mod_findSubMod.action', 'web/imgs/bar/zzgl_choose.jpg', 'web/imgs/bar/zzgl_normal.jpg', '1');
INSERT INTO `tb_mod` VALUES ('2', '1', 'mod002', '部门管理', 'bfdep/dep_showTree.action', 'web/imgs/bar/zzgl.jpg', 'web/imgs/bar/zzgl.jpg', '1');
INSERT INTO `tb_mod` VALUES ('3', '1', 'mod003', '员工管理', 'bfemp/emp.action', 'web/imgs/bar/yggl.jpg', 'web/imgs/bar/yggl.jpg', '1');
INSERT INTO `tb_mod` VALUES ('4', null, 'mod004', '权限管理', 'bfmod/mod_findSubMod.action', 'web/imgs/bar/qxgl_choose.jpg', 'web/imgs/bar/qxgl_normal.jpg', '1');
INSERT INTO `tb_mod` VALUES ('5', '4', 'mod005', '模块管理', 'bfmod/mod.action', 'web/imgs/bar/mkgl.jpg', 'web/imgs/bar/mkgl.jpg', '1');
INSERT INTO `tb_mod` VALUES ('6', '4', 'mod006', '账号管理', 'bfgrp/grp.action', 'web/imgs/bar/zhgl.jpg', 'web/imgs/bar/zhgl.jpg', '1');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `u_id` int(11) NOT NULL AUTO_INCREMENT,
  `u_name` varchar(255) DEFAULT NULL,
  `u_pwd` varchar(255) DEFAULT NULL,
  `flag` int(11) DEFAULT NULL,
  `g_id` int(11) DEFAULT NULL,
  `emp` int(11) DEFAULT NULL,
  PRIMARY KEY (`u_id`),
  UNIQUE KEY `emp` (`emp`),
  KEY `FKA4FF6AFCA2407071` (`g_id`),
  KEY `FKA4FF6AFC54E3096E` (`emp`),
  CONSTRAINT `FKA4FF6AFC54E3096E` FOREIGN KEY (`emp`) REFERENCES `tb_emp` (`emp_id`),
  CONSTRAINT `FKA4FF6AFCA2407071` FOREIGN KEY (`g_id`) REFERENCES `tb_group` (`g_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'root', '123', '1', '1', '1');
SET FOREIGN_KEY_CHECKS=1;
