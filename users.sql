/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50716
Source Host           : 127.0.0.1:3306
Source Database       : blogs

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2019-05-04 13:06:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `UUID` varchar(255) NOT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `grade` varchar(255) DEFAULT NULL,
  `imagePath` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`UUID`),
  KEY `user_name` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('165133cf6e2a438fb3ed126112fa59f1', '卓卓', '7246135A0B2D504A1A8714B0C85DF1E1', '2', '阿朱1.jpg', null);
INSERT INTO `users` VALUES ('49514a98caa04548817c24a9aec3c2d1', 'admin', '21232F297A57A5A743894A0E4A801FC3', '1', '9469699ea27242898aaf4c8e167b1a43.jpg', null);
INSERT INTO `users` VALUES ('63982a860c474a41a8e626a21f9abccb', '小欣欣', 'B314FADA1B57ABA647171AE89DA81B09', '2', '乔峰.jpg', null);
INSERT INTO `users` VALUES ('67d65e7e019f49a683e10f91cdeabeeb', '123', '202CB962AC59075B964B07152D234B70', '2', '萧峰.jpg', null);
INSERT INTO `users` VALUES ('81a46684aa2a430d839b39d77413a1c0', 'zl1', 'EEAE3F04DC94F1CA3EEA2225E7C899C2', '2', '阿朱之死.jpg', 'zhaoliguaner@163.com');
INSERT INTO `users` VALUES ('8a958677723f4023bc143941f53987fd', '2014012003', '9A18A9E571611A284048C9B7DFF6DD95', '2', null, null);
INSERT INTO `users` VALUES ('8ed32236170840bfba26a0da704e1da0', '33', '182BE0C5CDCD5072BB1864CDEE4D3D6E', '2', null, null);
INSERT INTO `users` VALUES ('ca3c45cbab3942578c3f313daaaf0b83', 'dx3', '4BE347A9571CBEDBACFA8D5750CD9BA9', '2', null, 'zhaoliguaner@sina.com');
INSERT INTO `users` VALUES ('f383a6982fbc47eb870ea80bf6da6b21', 'dx4', '4BE347A9571CBEDBACFA8D5750CD9BA9', '2', null, null);
INSERT INTO `users` VALUES ('f873b2eb2b454b7098edb60a6f7b270d', 'caoying', '3A3B04769D2C5215A1964C80B78E5E65', '2', '杨逍.jpg', '1813840809@qq.com');
