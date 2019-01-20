/*
Navicat MySQL Data Transfer

Source Server         : quadcopter
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : ywpt

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2019-01-20 22:16:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sign
-- ----------------------------
DROP TABLE IF EXISTS `sign`;
CREATE TABLE `sign` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `signdate` datetime DEFAULT NULL,
  `signip` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sign
-- ----------------------------
INSERT INTO `sign` VALUES ('3', '1', '2019-01-10 14:10:11', '192.168.31.250');
INSERT INTO `sign` VALUES ('4', '1', '2019-01-03 09:06:43', '192.168.31.250');
INSERT INTO `sign` VALUES ('15', '1', '2018-12-12 16:10:54', '10.123.128.11');
INSERT INTO `sign` VALUES ('16', '1', '2019-02-08 09:14:19', '10.123.128.21');
INSERT INTO `sign` VALUES ('17', '1', '2018-11-05 19:59:43', '10.123.128.21');
INSERT INTO `sign` VALUES ('18', '1', '2019-02-28 20:24:55', '10.123.128.11');
INSERT INTO `sign` VALUES ('37', '1', '2019-01-20 21:52:53', '192.168.31.250');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'zsga', '123456');
INSERT INTO `user` VALUES ('2', 'kxc', '123456');
