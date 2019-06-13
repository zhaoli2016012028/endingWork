/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50716
Source Host           : 127.0.0.1:3306
Source Database       : blogs

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2019-05-04 13:06:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for types
-- ----------------------------
DROP TABLE IF EXISTS `types`;
CREATE TABLE `types` (
  `UUID` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  PRIMARY KEY (`UUID`),
  KEY `type` (`type`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of types
-- ----------------------------
INSERT INTO `types` VALUES ('e72540a3549f44a69f5c02b9c68fa71d', '历史');
INSERT INTO `types` VALUES ('05e4df072781491babd1c9b9f728c978', '娱乐');
INSERT INTO `types` VALUES ('3f611116edaf4048b4e72d2df9a0b604', '科文');
INSERT INTO `types` VALUES ('4952a2d399cf48879245eb357f37fc09', '美妆');
INSERT INTO `types` VALUES ('af2a7c6b9f6e49a4bc49d47d8e31dd3f', '美食');
