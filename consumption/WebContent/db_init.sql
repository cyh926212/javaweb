/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306_mysql
Source Server Version : 50620
Source Host           : localhost:3306
Source Database       : consumption

Target Server Type    : MYSQL
Target Server Version : 50620
File Encoding         : 65001

Date: 2022-06-02 01:31:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_consumption
-- ----------------------------
DROP TABLE IF EXISTS `t_consumption`;
CREATE TABLE `t_consumption` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `money` double(255,0) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_consumption
-- ----------------------------
INSERT INTO `t_consumption` VALUES ('9', '交通出行', '打车', '20', '2022-05-30 00:00:00', '1');
INSERT INTO `t_consumption` VALUES ('10', '餐饮美食', '海底捞', '200', '2022-05-30 00:00:00', '1');
INSERT INTO `t_consumption` VALUES ('15', '家居服装', '外套', '98', '2022-05-31 00:00:00', '2');
INSERT INTO `t_consumption` VALUES ('16', '餐饮美食', '海底捞', '200', '2022-06-01 00:00:00', '3');
INSERT INTO `t_consumption` VALUES ('17', '美容美发', '染发', '180', '2022-06-01 00:00:00', '3');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', 'admin');
INSERT INTO `t_user` VALUES ('2', '1027054500', '1027054500');
INSERT INTO `t_user` VALUES ('3', '范宇康', '123456');
