/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50716
Source Host           : 127.0.0.1:3306
Source Database       : blogs

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2019-05-04 13:05:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for commentt
-- ----------------------------
DROP TABLE IF EXISTS `commentt`;
CREATE TABLE `commentt` (
  `UUID` varchar(255) NOT NULL,
  `comments` varchar(255) DEFAULT NULL,
  `blog` varchar(255) DEFAULT NULL,
  `commentor` varchar(255) DEFAULT NULL,
  `comdate` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`UUID`),
  KEY `blog` (`blog`),
  KEY `commentor` (`commentor`),
  CONSTRAINT `blog` FOREIGN KEY (`blog`) REFERENCES `articles` (`UUID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `commentor` FOREIGN KEY (`commentor`) REFERENCES `users` (`UUID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of commentt
-- ----------------------------
INSERT INTO `commentt` VALUES ('028f659c81e142ea82b96f6ce494d43e', '眼里柔情都是你 爱里落花水飘零 梦里牵手都是你 命里纠结无处醒 今生君恩还不尽 愿有来生化春泥 雁过', '4a986aef7a504335bf2f2532a8cc6642', 'f873b2eb2b454b7098edb60a6f7b270d', '2018-07-03 15:49:51');
INSERT INTO `commentt` VALUES ('0f8c8fbfd4a04e098d1d24b2eba38ad4', '残虐你你你你你你你顶顶顶顶顶顶顶', 'bb40bb265d334f938d51b5b3487a5f97', '49514a98caa04548817c24a9aec3c2d1', '2019-05-04 12:20:09');
INSERT INTO `commentt` VALUES ('271352e66e524a5daa73ba43be9923e7', '我还你祝福 你英雄好汉', 'af8491cb64ae46b0b68c9fad76ac2156', 'f873b2eb2b454b7098edb60a6f7b270d', '2018-07-03 16:08:03');
INSERT INTO `commentt` VALUES ('45b054edfab14a14ac3d77c450d84f4d', '个JFK', '4a986aef7a504335bf2f2532a8cc6642', 'f873b2eb2b454b7098edb60a6f7b270d', '2018-07-03 16:02:14');
INSERT INTO `commentt` VALUES ('684e09bc0c4343d88d0847bf34672fa7', '顶顶顶顶顶顶顶顶顶顶顶', '0586f31ac2924e55bffefd0ea5778784', '49514a98caa04548817c24a9aec3c2d1', '2018-07-03 16:48:44');
INSERT INTO `commentt` VALUES ('826860cbc5d841c1a3a43de7ca51e0dc', '沉默我i吗你哦【我', 'bb40bb265d334f938d51b5b3487a5f97', '49514a98caa04548817c24a9aec3c2d1', '2019-05-04 12:20:14');
INSERT INTO `commentt` VALUES ('cd670300e99c4ad6ac8633c78af0e52e', ' 我是你执迷的信徒　你是我的坟墓 入死出生　', 'af8491cb64ae46b0b68c9fad76ac2156', '49514a98caa04548817c24a9aec3c2d1', '2018-07-03 09:07:39');
INSERT INTO `commentt` VALUES ('d60140cef209415686177f1c9d6dbff5', '同航 这沙滚滚水皱皱笑着浪荡', 'a5ebe14d9feb49cc9f9cc73d8887e9a7', 'f873b2eb2b454b7098edb60a6f7b270d', '2018-07-03 16:07:05');
INSERT INTO `commentt` VALUES ('dc7bf3bdb30e494e86d88434a9c70e6e', '共谁同航 这沙滚滚水皱皱笑着浪荡', 'a5ebe14d9feb49cc9f9cc73d8887e9a7', 'f873b2eb2b454b7098edb60a6f7b270d', '2018-07-03 16:06:45');
INSERT INTO `commentt` VALUES ('e650893f13b64f4f8ba3b6ff11a5cb15', '思念你到黯然神伤，自有情思。 描绘了“曾经沧海难为水，除却巫山不是云”；亦或是衣带渐宽终不悔，为伊消得人憔悴”；也可是“此曲只应天上有，人间难得几回闻“这样的意境', '4a986aef7a504335bf2f2532a8cc6642', 'f873b2eb2b454b7098edb60a6f7b270d', '2018-07-03 16:01:18');
