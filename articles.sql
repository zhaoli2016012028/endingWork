/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50716
Source Host           : 127.0.0.1:3306
Source Database       : blogs

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2019-05-04 13:05:48
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
