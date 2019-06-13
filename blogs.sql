/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50716
Source Host           : 127.0.0.1:3306
Source Database       : blogs

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2019-05-04 13:05:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for articles
-- ----------------------------
DROP TABLE IF EXISTS `articles`;
CREATE TABLE `articles` (
  `UUID` varchar(255) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `content` text,
  `author` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `publishDate` date DEFAULT NULL,
  `modifyDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `viewNum` int(11) NOT NULL DEFAULT '0',
  `goodNum` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`UUID`),
  KEY `type` (`type`),
  KEY `auuid` (`author`),
  CONSTRAINT `auuid` FOREIGN KEY (`author`) REFERENCES `users` (`user_name`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `type` FOREIGN KEY (`type`) REFERENCES `types` (`type`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of articles
-- ----------------------------
INSERT INTO `articles` VALUES ('01f053748ea141fc8557420f823cd7bb', '帆帆帆帆', '<p><img src=\"http://img.baidu.com/hi/jx2/j_0026.gif\"/>顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶慢慢慢慢慢慢慢慢慢慢慢慢慢慢慢</p>', 'caoying', '科文', '2018-07-03', '2019-05-04 11:11:50', '5', '0');
INSERT INTO `articles` VALUES ('0586f31ac2924e55bffefd0ea5778784', '我最最爱学习', '<p>	 	</p><p><img src=\"http://img.baidu.com/hi/jx2/j_0050.gif\"/>顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶</p><p>\r\n	</p>', 'admin', '美食', '2018-07-03', '2019-05-04 11:31:21', '10', '2');
INSERT INTO `articles` VALUES ('4a986aef7a504335bf2f2532a8cc6642', '痴情冢', '眼里柔情都是你\r\n爱里落花水飘零\r\n梦里牵手都是你\r\n命里纠结无处醒\r\n今生君恩还不尽\r\n愿有来生化春泥\r\n雁过无痕风有情\r\n生死两忘江湖里', '卓卓', '娱乐', '2018-06-21', '2019-05-04 11:11:55', '18', '4');
INSERT INTO `articles` VALUES ('9b1fcad03dce4705bc1dadfa75184d4c', '观看《星际穿越》的一些思考与想法及学习本门课程的一些感悟', '<p><img title=\"1530599924823094151.png\" alt=\"bike.png\" src=\"ueditor/jsp/upload/image/20180703/1530599924823094151.png\"/>呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃<img src=\"http://img.baidu.com/hi/jx2/j_0026.gif\"/></p>', 'admin', '娱乐', '2018-07-03', '2019-05-04 11:26:35', '11', '0');
INSERT INTO `articles` VALUES ('a5ebe14d9feb49cc9f9cc73d8887e9a7', '难念的经', '天阔阔雪漫漫共谁同航\r\n这沙滚滚水皱皱笑着浪荡\r\n贪欢一刻偏教那女儿情长埋葬\r\n吞风吻雨葬落日未曾彷徨\r\n欺山赶海践雪径也未绝望\r\n拈花把酒偏折煞世人情狂\r\n凭这两眼与百臂或千手不能防\r\n天阔阔雪漫漫共谁同航\r\n这沙滚滚水皱皱笑着浪荡\r\n贪欢一晌偏教那女儿情长埋葬\r\n笑你我枉花光心计\r\n爱竞逐镜花那美丽\r\n怕幸运会转眼远逝\r\n为贪嗔喜恶怒着迷', '小欣欣', '娱乐', '2018-06-20', '2019-05-04 11:27:04', '6', '3');
INSERT INTO `articles` VALUES ('af8491cb64ae46b0b68c9fad76ac2156', '宽恕', '如是我闻　仰慕比暗恋还苦\r\n我走你的路　男儿泪　女儿哭\r\n我是你执迷的信徒　你是我的坟墓\r\n入死出生　由你做主\r\n你给我保护　我还你祝福\r\n你英雄好汉　需要抱负\r\n可你欠我幸福　拿什么来弥补\r\n难道爱比恨更难宽恕\r\n如是我闻 爱本是恨的来处\r\n胡汉不归路　一个输　一个苦\r\n宁愿你恨得糊涂　中了爱的迷毒\r\n一念满足　一念残酷\r\n你给我保护　我还你祝福\r\n你英雄好汉　需要抱负\r\n可你欠我幸福　拿什么来弥补\r\n难道爱比恨更难宽恕\r\n爱比恨更难宽恕', 'admin', '历史', '2018-06-19', '2018-07-03 16:07:48', '2', '1');
INSERT INTO `articles` VALUES ('bb40bb265d334f938d51b5b3487a5f97', '', '<p><img title=\"1556943504112055544.png\" alt=\"bike.png\" src=\"/ueditor/jsp/upload/image/20190504/1556943504112055544.png\"/><img src=\"http://img.baidu.com/hi/jx2/j_0017.gif\"/></p><pre class=\"brush:java;toolbar:false;\">public&nbsp;Users&nbsp;getUsers(String&nbsp;user_name)&nbsp;{&nbsp;//根据用户名获取该用户信息\r\n&nbsp;&nbsp;Users&nbsp;u&nbsp;=&nbsp;null;&nbsp;&nbsp;&nbsp;\r\n&nbsp;&nbsp;try&nbsp;{&nbsp;&nbsp;\r\n&nbsp;&nbsp;&nbsp;String&nbsp;sql&nbsp;=&nbsp;&quot;SELECT&nbsp;*&nbsp;FROM&nbsp;users&nbsp;WHERE&nbsp;user_name&nbsp;=?&quot;;\r\n&nbsp;&nbsp;&nbsp;Object[]&nbsp;param&nbsp;=&nbsp;{user_name};\r\n&nbsp;&nbsp;&nbsp;u&nbsp;=&nbsp;runner.query(conn,&nbsp;sql,&nbsp;new&nbsp;BeanHandler&lt;Users&gt;(Users.class),param);//对数据库进行操作\r\n&nbsp;&nbsp;}&nbsp;catch&nbsp;(SQLException&nbsp;e)&nbsp;{\r\n&nbsp;&nbsp;&nbsp;e.printStackTrace();\r\n&nbsp;&nbsp;}finally&nbsp;{\r\n&nbsp;&nbsp;&nbsp;C3p0Con.closeConn(conn);//释放数据库连接\r\n&nbsp;&nbsp;}\r\n&nbsp;&nbsp;return&nbsp;u;\r\n&nbsp;}</pre><p><br/></p>', 'admin', '娱乐', '2019-05-04', '2019-05-04 12:19:55', '1', '0');
INSERT INTO `articles` VALUES ('e28851836506487ea96040e28fef784a', '忘记时间', '沉默着走了有 多遥远\r\n抬起头 蓦然间 才发现\r\n一直倒退 倒退到原点\r\n倔强坚持 对抗时间\r\n说好了的永远 断了线\r\n期许了 不变的 却都已改变\r\n紧闭 双眼 才能看得见', '卓卓', '历史', '2018-06-25', '2019-04-19 23:34:45', '11', '0');

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
