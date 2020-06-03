/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2020-05-31 14:19:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for adminuser
-- ----------------------------
DROP TABLE IF EXISTS `adminuser`;
CREATE TABLE `adminuser` (
  `uid` int(11) NOT NULL COMMENT '管理员id',
  `username` varchar(20) NOT NULL COMMENT '管理员用户名',
  `password` varchar(20) NOT NULL COMMENT '管理员登录密码',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of adminuser
-- ----------------------------
INSERT INTO `adminuser` VALUES ('170001', 'admin', '123321');

-- ----------------------------
-- Table structure for answerstate
-- ----------------------------
DROP TABLE IF EXISTS `answerstate`;
CREATE TABLE `answerstate` (
  `anid` int(11) NOT NULL AUTO_INCREMENT COMMENT '答题情况表id',
  `qid` int(11) DEFAULT NULL COMMENT '试题id',
  `state` int(2) DEFAULT NULL COMMENT '答题情况1(对)2（错）3（没有做）',
  `tnid` int(11) DEFAULT NULL COMMENT '考试记录id',
  PRIMARY KEY (`anid`),
  KEY `FKd7jutiww9p5b57lou5pd8mwf8` (`qid`),
  KEY `FKs0if9cb8bpy9fl75bvckn4yhx` (`tnid`),
  CONSTRAINT `FKd7jutiww9p5b57lou5pd8mwf8` FOREIGN KEY (`qid`) REFERENCES `question` (`qid`),
  CONSTRAINT `FKs0if9cb8bpy9fl75bvckn4yhx` FOREIGN KEY (`tnid`) REFERENCES `testnote` (`tnid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of answerstate
-- ----------------------------

-- ----------------------------
-- Table structure for bj
-- ----------------------------
DROP TABLE IF EXISTS `bj`;
CREATE TABLE `bj` (
  `bjid` int(11) NOT NULL AUTO_INCREMENT COMMENT '班级id',
  `bjname` varchar(50) NOT NULL COMMENT '班级名称',
  `tid` int(11) DEFAULT NULL COMMENT '教师id',
  `teacherUser_tid` int(11) DEFAULT NULL,
  PRIMARY KEY (`bjid`),
  KEY `FK6yinq5ty7u2qeadvxciby0lyb` (`tid`),
  KEY `FKelefm8oak1yslai5mx5l9j991` (`teacherUser_tid`),
  CONSTRAINT `FK6yinq5ty7u2qeadvxciby0lyb` FOREIGN KEY (`tid`) REFERENCES `teacheruser` (`tid`),
  CONSTRAINT `FKelefm8oak1yslai5mx5l9j991` FOREIGN KEY (`teacherUser_tid`) REFERENCES `teacheruser` (`tid`),
  CONSTRAINT `bj_ibfk_1` FOREIGN KEY (`tid`) REFERENCES `teacheruser` (`tid`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bj
-- ----------------------------
INSERT INTO `bj` VALUES ('1', '17软1', '6', null);
INSERT INTO `bj` VALUES ('2', '17软2', '1752501', null);
INSERT INTO `bj` VALUES ('5', '17软5', '1752503', null);
INSERT INTO `bj` VALUES ('6', '17软6', '1752503', null);

-- ----------------------------
-- Table structure for bj_student
-- ----------------------------
DROP TABLE IF EXISTS `bj_student`;
CREATE TABLE `bj_student` (
  `BJ_bjid` int(11) NOT NULL,
  `students_sid` int(11) NOT NULL,
  PRIMARY KEY (`BJ_bjid`,`students_sid`),
  UNIQUE KEY `UK_o6qummux946hv3alre2t9wkma` (`students_sid`),
  CONSTRAINT `FKilbbauog3lc5w4i89yb3lj53` FOREIGN KEY (`students_sid`) REFERENCES `student` (`sid`),
  CONSTRAINT `FKlly7j2xmivh3kmxsupw764y01` FOREIGN KEY (`BJ_bjid`) REFERENCES `bj` (`bjid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bj_student
-- ----------------------------

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES ('124');
INSERT INTO `hibernate_sequence` VALUES ('124');
INSERT INTO `hibernate_sequence` VALUES ('124');
INSERT INTO `hibernate_sequence` VALUES ('124');
INSERT INTO `hibernate_sequence` VALUES ('124');
INSERT INTO `hibernate_sequence` VALUES ('124');

-- ----------------------------
-- Table structure for hibernate_sequences
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequences`;
CREATE TABLE `hibernate_sequences` (
  `sequence_name` varchar(255) NOT NULL,
  `next_val` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`sequence_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hibernate_sequences
-- ----------------------------
INSERT INTO `hibernate_sequences` VALUES ('default', '2');

-- ----------------------------
-- Table structure for qprelationp
-- ----------------------------
DROP TABLE IF EXISTS `qprelationp`;
CREATE TABLE `qprelationp` (
  `rid` int(11) NOT NULL,
  `num` int(11) DEFAULT NULL,
  `qid` int(11) DEFAULT NULL,
  `qpid` int(11) DEFAULT NULL,
  PRIMARY KEY (`rid`),
  KEY `FKfl1k0uv24957g674kpfbu2el8` (`qid`),
  KEY `FKh3brdc46trr2n8mj3xtiw74wt` (`qpid`),
  CONSTRAINT `FKfl1k0uv24957g674kpfbu2el8` FOREIGN KEY (`qid`) REFERENCES `question` (`qid`),
  CONSTRAINT `FKh3brdc46trr2n8mj3xtiw74wt` FOREIGN KEY (`qpid`) REFERENCES `questionpaper` (`qpid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qprelationp
-- ----------------------------
INSERT INTO `qprelationp` VALUES ('11', null, null, null);
INSERT INTO `qprelationp` VALUES ('14', null, null, null);
INSERT INTO `qprelationp` VALUES ('16', null, null, null);
INSERT INTO `qprelationp` VALUES ('17', null, null, null);
INSERT INTO `qprelationp` VALUES ('18', null, null, null);

-- ----------------------------
-- Table structure for qprelationq
-- ----------------------------
DROP TABLE IF EXISTS `qprelationq`;
CREATE TABLE `qprelationq` (
  `rid` int(11) NOT NULL AUTO_INCREMENT COMMENT '试卷与试题对应关系id',
  `num` int(11) DEFAULT NULL COMMENT '试题序号',
  `qpid` int(11) DEFAULT NULL COMMENT '试卷id',
  `qid` int(11) DEFAULT NULL COMMENT '试题id',
  PRIMARY KEY (`rid`),
  KEY `FKd51r19r2uqe1gn6v4jap2o7ci` (`qpid`),
  KEY `FKoypfe6ge2wu7fih09xuyeyrr9` (`qid`),
  CONSTRAINT `FKd51r19r2uqe1gn6v4jap2o7ci` FOREIGN KEY (`qpid`) REFERENCES `questionpaper` (`qpid`),
  CONSTRAINT `FKoypfe6ge2wu7fih09xuyeyrr9` FOREIGN KEY (`qid`) REFERENCES `question` (`qid`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qprelationq
-- ----------------------------
INSERT INTO `qprelationq` VALUES ('1', '7', '53', '31');
INSERT INTO `qprelationq` VALUES ('2', '8', '53', '32');
INSERT INTO `qprelationq` VALUES ('3', '9', '53', '28');
INSERT INTO `qprelationq` VALUES ('4', '10', '53', '29');
INSERT INTO `qprelationq` VALUES ('5', '1', '54', '17');
INSERT INTO `qprelationq` VALUES ('6', '2', '54', '19');
INSERT INTO `qprelationq` VALUES ('7', '3', '54', '23');
INSERT INTO `qprelationq` VALUES ('8', '4', '54', '30');
INSERT INTO `qprelationq` VALUES ('9', '5', '54', '33');
INSERT INTO `qprelationq` VALUES ('10', '6', '54', '28');
INSERT INTO `qprelationq` VALUES ('18', '1', '53', '17');
INSERT INTO `qprelationq` VALUES ('19', '2', '53', '18');
INSERT INTO `qprelationq` VALUES ('20', '3', '53', '21');
INSERT INTO `qprelationq` VALUES ('21', '4', '53', '24');
INSERT INTO `qprelationq` VALUES ('22', '5', '53', '23');
INSERT INTO `qprelationq` VALUES ('23', '6', '53', '30');
INSERT INTO `qprelationq` VALUES ('25', null, '24', '17');
INSERT INTO `qprelationq` VALUES ('35', null, '34', '17');
INSERT INTO `qprelationq` VALUES ('36', null, '34', '18');
INSERT INTO `qprelationq` VALUES ('38', null, '37', '17');
INSERT INTO `qprelationq` VALUES ('39', null, '37', '18');
INSERT INTO `qprelationq` VALUES ('41', null, '40', '17');
INSERT INTO `qprelationq` VALUES ('42', null, '40', '18');
INSERT INTO `qprelationq` VALUES ('56', null, '55', '17');
INSERT INTO `qprelationq` VALUES ('57', null, '55', '18');
INSERT INTO `qprelationq` VALUES ('58', null, '55', '19');
INSERT INTO `qprelationq` VALUES ('59', null, '55', '20');
INSERT INTO `qprelationq` VALUES ('60', null, '55', '21');
INSERT INTO `qprelationq` VALUES ('61', null, '55', '22');
INSERT INTO `qprelationq` VALUES ('62', null, '55', '23');
INSERT INTO `qprelationq` VALUES ('63', null, '55', '24');
INSERT INTO `qprelationq` VALUES ('64', null, '55', '31');
INSERT INTO `qprelationq` VALUES ('65', null, '55', '32');
INSERT INTO `qprelationq` VALUES ('66', null, '55', '29');
INSERT INTO `qprelationq` VALUES ('69', null, '15', '17');
INSERT INTO `qprelationq` VALUES ('72', null, '15', '17');

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `qid` int(11) NOT NULL AUTO_INCREMENT COMMENT '试题id',
  `qcontent` varchar(800) NOT NULL COMMENT '试题内容',
  `aoption` varchar(255) DEFAULT NULL COMMENT '选项a',
  `boption` varchar(255) DEFAULT NULL COMMENT '选项b',
  `coption` varchar(255) DEFAULT NULL COMMENT '选项c',
  `doption` varchar(255) DEFAULT NULL COMMENT '选项d',
  `qanswer` varchar(255) DEFAULT NULL COMMENT '试题答案',
  `qanalysis` varchar(800) DEFAULT NULL COMMENT '试题解析',
  `oword` varchar(50) DEFAULT NULL COMMENT '关键字1',
  `qscope` varchar(20) DEFAULT NULL COMMENT '试题范围',
  `qdifficulty` varchar(8) DEFAULT NULL COMMENT '试题难度',
  `qdate` datetime DEFAULT NULL COMMENT '添加日期',
  `qtid` int(11) DEFAULT NULL COMMENT '试题类型id',
  `tid` int(11) DEFAULT NULL COMMENT '教师编号id',
  `questionType_qtid` int(11) DEFAULT NULL,
  `teacherUser_tid` int(11) DEFAULT NULL,
  PRIMARY KEY (`qid`),
  KEY `FKbaasjyxv0bvhkje9wfs7aikau` (`qtid`),
  KEY `FK8k438jxhyrfu1p2w8hajfeitg` (`tid`),
  KEY `FKdk03p45p11vihlk44td4mvw8b` (`questionType_qtid`),
  KEY `FK59amduvc4xqh5or4o0nvvee70` (`teacherUser_tid`),
  CONSTRAINT `FK59amduvc4xqh5or4o0nvvee70` FOREIGN KEY (`teacherUser_tid`) REFERENCES `teacheruser` (`tid`),
  CONSTRAINT `FK8k438jxhyrfu1p2w8hajfeitg` FOREIGN KEY (`tid`) REFERENCES `teacheruser` (`tid`),
  CONSTRAINT `FKbaasjyxv0bvhkje9wfs7aikau` FOREIGN KEY (`qtid`) REFERENCES `questiontype` (`qtid`),
  CONSTRAINT `FKdk03p45p11vihlk44td4mvw8b` FOREIGN KEY (`questionType_qtid`) REFERENCES `questiontype` (`qtid`),
  CONSTRAINT `question_ibfk_1` FOREIGN KEY (`qtid`) REFERENCES `questiontype` (`qtid`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `question_ibfk_2` FOREIGN KEY (`tid`) REFERENCES `teacheruser` (`tid`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES ('17', '()是构成C语言程序的基本单位。', '函数', '过程', '子程序', '子例程', '函数', '   							函数是构成C语言程序的基本单位   						', '单位', '第一单元', '简单', '2020-05-24 11:59:24', '1', '1752503', null, null);
INSERT INTO `question` VALUES ('18', 'C语言程序从（）开始执行。', '程序中第一条可执行语句', '程序中第一个函数', '程序中的main函数', '包含文件中的第一个函数', '程序中的main函数', '   							C语言程序从程序中的第一个main函数开始执行\r\n   						', '执行顺序', '第一单元', '简单', '2017-05-25 11:15:42', '1', '1752501', null, null);
INSERT INTO `question` VALUES ('19', '以下说法中正确的是（）', 'C语言程序总是从第一个定义的函数开始执行', '在C语言程序中，要调用的函数必须在main()函数中定义', 'C语言程序总是从main()函数开始执行', 'C语言程序中的main()函数必须放在程序的开始部分', 'C语言程序总是从main()函数开始执行', '   							C语言总是从main()函数开始执行。\r\n   						', '执行顺序', '第一单元', '简单', '2017-05-25 11:19:53', '1', '1752501', null, null);
INSERT INTO `question` VALUES ('20', '下列关于C语言的说法错误的是（）', 'C程序的工作过程是编辑、编译、连接、运行', 'C语言不区分大小写', 'C程序的三种基本结构是顺序、选择、循环', 'C程序从main函数开始执行', 'C语言不区分大小写', '   							C语言区分大小写\r\n   						', '大小写', '第一单元', '简单', '2017-05-25 11:23:00', '1', '1752501', null, null);
INSERT INTO `question` VALUES ('21', '下列正确的标识符是（）', '-a1', 'a[i]', 'a2_i', 'int t', 'a2_i', '   							（1）只能由字母、数字、下划线构成。（2）数字不能作为标识符的开头。（3）关键字不能作为标识符。\r\n   						', '标识符', '第一单元', '简单', '2017-05-25 11:26:02', '1', '1752501', null, null);
INSERT INTO `question` VALUES ('22', '下列C语言用户标识符中合法的是（）', '3ax', 'x', 'case', '-e2', 'x', '   							选项A中的标识符以数字开头不满足；选项C为关键字；选项D中的“-”开头\r\n   						', '标识符', '第一单元', '简单', '2017-05-25 11:28:38', '1', '1752501', null, null);
INSERT INTO `question` VALUES ('23', 'C语言中的简单数据类型包括（）', '整型、实型、逻辑型', '整型、实型、逻辑型、字符型', '整型、字符型、逻辑型', '整型、实型、字符型', '整型、实型、字符型', '   							C语言中的简单数据类型包括：整型、实型、字符型。\r\n   						', '数据类型', '第一单元', '简单', '2017-05-25 11:31:29', '1', '1752501', null, null);
INSERT INTO `question` VALUES ('24', '在C语言程序中，表达式5%2的结果是（）', '2.5', '2', '1', '3', '1', '   							%为求余运算符，该运算符只能对整型数据进行运算。且符号与被模数相同。5%2=1；\r\n   						', '余数', '第一单元', '简单', '2017-05-25 11:34:05', '1', '1752501', null, null);
INSERT INTO `question` VALUES ('25', '若有说明：int a[][3]={{1,2,3},{4,5},{6,7}}; 则数组a的第一维的大小为: ( )', '2', '3', '4', '无确定值', '3', '   							二维数组的一维大小，即指二维数组的行数，在本题中，按行对二维数组赋值，因此内层有几个大括号，数组就有几行\r\n   						', '数组', '第一单元', '中等', '2017-05-25 11:36:49', '1', '1752501', null, null);
INSERT INTO `question` VALUES ('26', 'C语言中函数返回值的类型是由（）决定的', '函数定义时指定的类型', 'return语句中的表达式类型', '调用该函数时的实参的数据类型', '形参的数据类型', '函数定义时指定的类型', '   							C语言中函数返回值的类型是由函数定义时指定的类型决定的\r\n   						', '返回类型', '第一单元', '中等', '2017-05-25 12:49:12', '1', '1752501', null, null);
INSERT INTO `question` VALUES ('27', '在C语言中，表示静态存储类别的关键字是', 'auto', 'register', 'static', 'extern', 'static', '   							static\r\n   						', '静态存储', '第一单元', '中等', '2017-05-25 12:50:40', '1', '1752501', null, null);
INSERT INTO `question` VALUES ('28', '#include <stdio.h>\r\nmain()\r\n{ int a=1,b=3,c=5;\r\nif (c==a+b)\r\n printf(\"yes\\n\");\r\nelse\r\n printf(\"no\\n\");\r\n}', '', '', '', '', 'no', '   							==表示判断符号两边的值是否相等；=表示将符号右边的值赋给左边的变量\r\n   						', '判断', '第一单元', '简单', '2017-05-25 12:54:53', '3', '1752501', null, null);
INSERT INTO `question` VALUES ('29', '#include <stdio.h>\r\nmain()\r\n{ int a=12, b= -34, c=56, min=0;\r\nmin=a;\r\n  if(min>b)  \r\nmin=b;\r\n  if(min>c)  \r\nmin=c;\r\nprintf(\"min=%d\", min);\r\n}', '', '', '', '', 'min=34', '   							选择结构\r\n   						', '选择结构', '第一单元', '中等', '2017-05-25 12:56:07', '3', '1752501', null, null);
INSERT INTO `question` VALUES ('30', '在函数调用时，实际参数和形式参数可以同名', '', '', '', '', '对', '   							在函数调用时，实际参数和形式参数可以同名\r\n   						', '形式参数和实际参数', '第一单元', '简单', '2017-05-25 13:06:28', '2', '1752501', null, null);
INSERT INTO `question` VALUES ('31', '函数间的数据传递不可以使用全局变量', '', '', '', '', '错', '   							函数间的数据传递可以使用全局变量\r\n   						', '数据传递', '第一单元', '简单', '2017-05-25 13:07:35', '2', '1752501', null, null);
INSERT INTO `question` VALUES ('32', '主调函数和被调函数总是在同一个文件里', '', '', '', '', '错', '   							主调函数和被调函数可以在同一个文件里\r\n   						', '函数位置', '第一单元', '简单', '2017-05-25 13:08:25', '2', '1752501', null, null);
INSERT INTO `question` VALUES ('33', 'struct是声明结构体类型时用的关键字', '', '', '', '', '对', '   							struct是声明结构体类型时用的关键字\r\n   						', '关键字', '第一单元', '中等', '2017-05-25 13:09:27', '2', '1752501', null, null);
INSERT INTO `question` VALUES ('77', '中国首富是谁', '马云', '马化腾', '王兴', '王健林', '马化腾', '无', '首富', '第一单元', '简单', '2020-05-29 16:20:17', '1', null, null, null);

-- ----------------------------
-- Table structure for questionpaper
-- ----------------------------
DROP TABLE IF EXISTS `questionpaper`;
CREATE TABLE `questionpaper` (
  `qpid` int(11) NOT NULL AUTO_INCREMENT COMMENT '试卷id',
  `qpdate` datetime NOT NULL COMMENT '出卷时间',
  `time` int(11) NOT NULL COMMENT '考试时长',
  `tid` int(11) DEFAULT NULL COMMENT '教师编号',
  `qpname` varchar(50) NOT NULL,
  PRIMARY KEY (`qpid`),
  KEY `FKtk78cxay18odowy9u2cgwyg1g` (`tid`),
  CONSTRAINT `FKtk78cxay18odowy9u2cgwyg1g` FOREIGN KEY (`tid`) REFERENCES `teacheruser` (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of questionpaper
-- ----------------------------
INSERT INTO `questionpaper` VALUES ('11', '2020-05-26 17:02:46', '20', '1752503', 'test');
INSERT INTO `questionpaper` VALUES ('13', '2020-05-26 17:08:14', '20', '1752503', 'test');
INSERT INTO `questionpaper` VALUES ('15', '2020-05-26 17:12:14', '20', '1752503', 'test');
INSERT INTO `questionpaper` VALUES ('20', '2020-05-26 22:06:09', '22', '1752503', '111');
INSERT INTO `questionpaper` VALUES ('22', '2020-05-26 22:13:33', '11', '1752503', 'xxx ');
INSERT INTO `questionpaper` VALUES ('24', '2020-05-26 22:16:25', '20', '6', '');
INSERT INTO `questionpaper` VALUES ('27', '2020-05-27 18:44:49', '111', '1752503', '111222');
INSERT INTO `questionpaper` VALUES ('30', '2020-05-27 19:28:46', '121', '1752503', 'qqq');
INSERT INTO `questionpaper` VALUES ('31', '2020-05-27 19:31:27', '1111', '1752503', '22222');
INSERT INTO `questionpaper` VALUES ('32', '2020-05-27 19:35:39', '121', '1752503', 'gggg');
INSERT INTO `questionpaper` VALUES ('33', '2020-05-27 19:39:30', '444', '1752503', 'ffff');
INSERT INTO `questionpaper` VALUES ('34', '2020-05-27 19:46:24', '121', '1752503', 'vvv');
INSERT INTO `questionpaper` VALUES ('37', '2020-05-27 20:54:14', '22', '1752503', 'zzzz');
INSERT INTO `questionpaper` VALUES ('40', '2020-05-27 21:07:19', '22', '1752503', 'zzzzzzzzz');
INSERT INTO `questionpaper` VALUES ('43', '2020-05-27 21:54:09', '1213', '1752503', '112223');
INSERT INTO `questionpaper` VALUES ('53', '2017-05-25 13:10:43', '2', '1752501', '');
INSERT INTO `questionpaper` VALUES ('54', '2017-05-25 13:14:20', '1', '1752501', '');
INSERT INTO `questionpaper` VALUES ('55', '2020-05-27 23:46:01', '122', '1752503', 'java考卷1');
INSERT INTO `questionpaper` VALUES ('56', '2017-05-27 01:51:39', '120', null, '');

-- ----------------------------
-- Table structure for questionpaper_qprelationp
-- ----------------------------
DROP TABLE IF EXISTS `questionpaper_qprelationp`;
CREATE TABLE `questionpaper_qprelationp` (
  `TestPaper_qpid` int(11) NOT NULL,
  `relationpqs_rid` int(11) NOT NULL,
  UNIQUE KEY `UK_h27bcq3hox556xear2xpxkqok` (`relationpqs_rid`),
  KEY `FK66kbovis0wmp41ln28clnryr6` (`TestPaper_qpid`),
  CONSTRAINT `FK66kbovis0wmp41ln28clnryr6` FOREIGN KEY (`TestPaper_qpid`) REFERENCES `questionpaper` (`qpid`),
  CONSTRAINT `FKofn1gspq68s9ggin1odtj7jjp` FOREIGN KEY (`relationpqs_rid`) REFERENCES `qprelationp` (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of questionpaper_qprelationp
-- ----------------------------

-- ----------------------------
-- Table structure for questionpaper_qprelationq
-- ----------------------------
DROP TABLE IF EXISTS `questionpaper_qprelationq`;
CREATE TABLE `questionpaper_qprelationq` (
  `TestPaper_qpid` int(11) NOT NULL,
  `relationpqs_rid` int(11) NOT NULL,
  UNIQUE KEY `UK_7lqxt9vijt6u6ks0jumn20jqk` (`relationpqs_rid`),
  KEY `FKcsr0qnt45nyb8r1ilv69mdqhd` (`TestPaper_qpid`),
  CONSTRAINT `FKcsr0qnt45nyb8r1ilv69mdqhd` FOREIGN KEY (`TestPaper_qpid`) REFERENCES `questionpaper` (`qpid`),
  CONSTRAINT `FKe0w4anlko8d0qpwodpm549v0h` FOREIGN KEY (`relationpqs_rid`) REFERENCES `qprelationq` (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of questionpaper_qprelationq
-- ----------------------------

-- ----------------------------
-- Table structure for questionpaper_question
-- ----------------------------
DROP TABLE IF EXISTS `questionpaper_question`;
CREATE TABLE `questionpaper_question` (
  `TestPaper_qpid` int(11) NOT NULL,
  `questions_qid` int(11) NOT NULL,
  UNIQUE KEY `UK_ced3h1varud5ptcp3qvl8v6gq` (`questions_qid`),
  KEY `FKjgeiq0gmok71grx3xtult8t` (`TestPaper_qpid`),
  CONSTRAINT `FK28l14w8vbjp13ii5mblrvky87` FOREIGN KEY (`questions_qid`) REFERENCES `question` (`qid`),
  CONSTRAINT `FKjgeiq0gmok71grx3xtult8t` FOREIGN KEY (`TestPaper_qpid`) REFERENCES `questionpaper` (`qpid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of questionpaper_question
-- ----------------------------

-- ----------------------------
-- Table structure for questionpaper_testcontrol
-- ----------------------------
DROP TABLE IF EXISTS `questionpaper_testcontrol`;
CREATE TABLE `questionpaper_testcontrol` (
  `TestPaper_qpid` int(11) NOT NULL,
  `controls_tcid` int(11) NOT NULL,
  UNIQUE KEY `UK_dm5nbey2r1fciw2quwiuj0pft` (`controls_tcid`),
  KEY `FKc03rx8knivl7j2234geddassx` (`TestPaper_qpid`),
  CONSTRAINT `FKb8e6uvv3p3tf0f0ty83nojfgp` FOREIGN KEY (`controls_tcid`) REFERENCES `testcontrol` (`tcid`),
  CONSTRAINT `FKc03rx8knivl7j2234geddassx` FOREIGN KEY (`TestPaper_qpid`) REFERENCES `questionpaper` (`qpid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of questionpaper_testcontrol
-- ----------------------------

-- ----------------------------
-- Table structure for questiontype
-- ----------------------------
DROP TABLE IF EXISTS `questiontype`;
CREATE TABLE `questiontype` (
  `qtid` int(11) NOT NULL AUTO_INCREMENT COMMENT '试题类型id',
  `qtname` varchar(50) NOT NULL COMMENT '试题类型名称',
  `score` int(11) NOT NULL COMMENT '该题型分数',
  PRIMARY KEY (`qtid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of questiontype
-- ----------------------------
INSERT INTO `questiontype` VALUES ('1', '选择题', '2');
INSERT INTO `questiontype` VALUES ('2', '判断题', '1');
INSERT INTO `questiontype` VALUES ('3', '读程序题', '2');
INSERT INTO `questiontype` VALUES ('4', '选择题', '2');
INSERT INTO `questiontype` VALUES ('5', '判断题', '1');
INSERT INTO `questiontype` VALUES ('6', '读程序题', '2');

-- ----------------------------
-- Table structure for questiontype_question
-- ----------------------------
DROP TABLE IF EXISTS `questiontype_question`;
CREATE TABLE `questiontype_question` (
  `QuestionType_qtid` int(11) NOT NULL,
  `questions_qid` int(11) NOT NULL,
  PRIMARY KEY (`QuestionType_qtid`,`questions_qid`),
  UNIQUE KEY `UK_a87dj10uak936avfn246afgsk` (`questions_qid`),
  CONSTRAINT `FKqulchc4fgn6nqmx0str6b49l1` FOREIGN KEY (`QuestionType_qtid`) REFERENCES `questiontype` (`qtid`),
  CONSTRAINT `FKwghjwkwtkc26jpqb093tqb4e` FOREIGN KEY (`questions_qid`) REFERENCES `question` (`qid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of questiontype_question
-- ----------------------------

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `sid` int(11) NOT NULL COMMENT '学号',
  `password` varchar(20) NOT NULL COMMENT '密码',
  `name` varchar(20) DEFAULT NULL COMMENT '学生姓名',
  `phone` varchar(20) DEFAULT NULL COMMENT '电话',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `bjid` int(11) DEFAULT NULL COMMENT '班级id',
  `bj_bjid` int(11) DEFAULT NULL,
  PRIMARY KEY (`sid`),
  KEY `FKg38hb6ioau31cosrf7uoesly1` (`bjid`),
  KEY `FKcgybadmpq4vntq6dv6be6nlyl` (`bj_bjid`),
  CONSTRAINT `FKcgybadmpq4vntq6dv6be6nlyl` FOREIGN KEY (`bj_bjid`) REFERENCES `bj` (`bjid`),
  CONSTRAINT `FKg38hb6ioau31cosrf7uoesly1` FOREIGN KEY (`bjid`) REFERENCES `bj` (`bjid`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`bjid`) REFERENCES `bj` (`bjid`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('19999', '123456', ' Spring Boot云收藏', '17839164655', '111129@qq.com', '2', null);
INSERT INTO `student` VALUES ('1752601', '1752601', '赵伟', '18317526001', 'zh@163.com', '1', null);
INSERT INTO `student` VALUES ('1752602', '1752602', '乔羽', '18317526002', 'qy@163.com', '1', null);
INSERT INTO `student` VALUES ('1752603', '1752603', '孙涛', '18317526003', 'st@163.com', '1', null);
INSERT INTO `student` VALUES ('1752604', '1752604', '孙婷', '18317526004', 'stt@163.com', '1', null);
INSERT INTO `student` VALUES ('1752605', '1752605', '李阳', '18317526005', 'ly@163.com', '1', null);

-- ----------------------------
-- Table structure for student_testnote
-- ----------------------------
DROP TABLE IF EXISTS `student_testnote`;
CREATE TABLE `student_testnote` (
  `Student_sid` int(11) NOT NULL,
  `testNotes_tnid` int(11) NOT NULL,
  UNIQUE KEY `UK_j60fvmhurl0vgv8qt84hfurhc` (`testNotes_tnid`),
  KEY `FK4ny5ryqaymnuid8caw86bsgtm` (`Student_sid`),
  CONSTRAINT `FK4ny5ryqaymnuid8caw86bsgtm` FOREIGN KEY (`Student_sid`) REFERENCES `student` (`sid`),
  CONSTRAINT `FKedlowmx8dl9wasjbvbc20lmh0` FOREIGN KEY (`testNotes_tnid`) REFERENCES `testnote` (`tnid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student_testnote
-- ----------------------------

-- ----------------------------
-- Table structure for teacheruser
-- ----------------------------
DROP TABLE IF EXISTS `teacheruser`;
CREATE TABLE `teacheruser` (
  `tid` int(11) NOT NULL COMMENT '教师编号id',
  `password` varchar(20) NOT NULL COMMENT '教师登录密码',
  `tname` varchar(20) DEFAULT NULL COMMENT '教师姓名',
  `phone` varchar(20) DEFAULT NULL COMMENT '电话',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacheruser
-- ----------------------------
INSERT INTO `teacheruser` VALUES ('6', '123456', '吴龙', '18839164655', '2385946158@qq.com');
INSERT INTO `teacheruser` VALUES ('1752501', '1752501', '李华', '18317525001', 'lh@163.com');
INSERT INTO `teacheruser` VALUES ('1752502', '123445', '111', null, '1111');
INSERT INTO `teacheruser` VALUES ('1752503', '1752503', '张磊', '18317525003', 'zl@163.com');

-- ----------------------------
-- Table structure for teacheruser_bj
-- ----------------------------
DROP TABLE IF EXISTS `teacheruser_bj`;
CREATE TABLE `teacheruser_bj` (
  `TeacherUser_tid` int(11) NOT NULL,
  `bjs_bjid` int(11) NOT NULL,
  PRIMARY KEY (`TeacherUser_tid`,`bjs_bjid`),
  UNIQUE KEY `UK_2hq4pi3gjchxb9uandim71v5r` (`bjs_bjid`),
  CONSTRAINT `FK4feap7k7o25wws9xqvw10leh8` FOREIGN KEY (`TeacherUser_tid`) REFERENCES `teacheruser` (`tid`),
  CONSTRAINT `FKr2ok6s4w9k79vrcvgdfra46ek` FOREIGN KEY (`bjs_bjid`) REFERENCES `bj` (`bjid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacheruser_bj
-- ----------------------------

-- ----------------------------
-- Table structure for testcontrol
-- ----------------------------
DROP TABLE IF EXISTS `testcontrol`;
CREATE TABLE `testcontrol` (
  `tcid` int(11) NOT NULL AUTO_INCREMENT COMMENT '考场控制id',
  `qpid` int(11) DEFAULT NULL COMMENT '试卷编号',
  `tdate` timestamp NULL DEFAULT NULL COMMENT '考试日期',
  PRIMARY KEY (`tcid`),
  KEY `FKl0o4w7svuyuv70ryda3jybth8` (`qpid`),
  CONSTRAINT `FKl0o4w7svuyuv70ryda3jybth8` FOREIGN KEY (`qpid`) REFERENCES `questionpaper` (`qpid`),
  CONSTRAINT `testcontrol_ibfk_1` FOREIGN KEY (`qpid`) REFERENCES `questionpaper` (`qpid`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of testcontrol
-- ----------------------------
INSERT INTO `testcontrol` VALUES ('67', '55', '2020-05-20 00:00:00');
INSERT INTO `testcontrol` VALUES ('71', '55', '2020-05-29 10:00:00');
INSERT INTO `testcontrol` VALUES ('74', '55', '2020-05-20 00:00:00');
INSERT INTO `testcontrol` VALUES ('76', '55', '2020-06-30 14:00:00');

-- ----------------------------
-- Table structure for testcontrol_testnote
-- ----------------------------
DROP TABLE IF EXISTS `testcontrol_testnote`;
CREATE TABLE `testcontrol_testnote` (
  `TestControl_tcid` int(11) NOT NULL,
  `testNotes_tnid` int(11) NOT NULL,
  UNIQUE KEY `UK_jg0vlwdofkkctpyadpkh6fcsa` (`testNotes_tnid`),
  KEY `FKn03ja39ddfom7xxqsbk8f3mpb` (`TestControl_tcid`),
  CONSTRAINT `FKmpbfvn4yuje3ixsml1wcd8ogo` FOREIGN KEY (`testNotes_tnid`) REFERENCES `testnote` (`tnid`),
  CONSTRAINT `FKn03ja39ddfom7xxqsbk8f3mpb` FOREIGN KEY (`TestControl_tcid`) REFERENCES `testcontrol` (`tcid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of testcontrol_testnote
-- ----------------------------

-- ----------------------------
-- Table structure for testnote
-- ----------------------------
DROP TABLE IF EXISTS `testnote`;
CREATE TABLE `testnote` (
  `tnid` int(11) NOT NULL AUTO_INCREMENT COMMENT '考试记录id',
  `sid` int(11) DEFAULT NULL COMMENT '学号',
  `qpid` int(11) DEFAULT NULL COMMENT '试卷编号',
  `score` int(11) DEFAULT NULL COMMENT '分数',
  `tscore` int(11) DEFAULT NULL,
  `tcid` int(11) DEFAULT NULL,
  PRIMARY KEY (`tnid`),
  KEY `FK60hojljg7tpfi9oneceys96ok` (`sid`),
  KEY `FK2jvkm5uf544yj5u3wf2q8ga72` (`qpid`),
  KEY `FK7ka7rnodsusmlmyxn9xlx29f4` (`tcid`),
  CONSTRAINT `FK2jvkm5uf544yj5u3wf2q8ga72` FOREIGN KEY (`qpid`) REFERENCES `questionpaper` (`qpid`),
  CONSTRAINT `FK60hojljg7tpfi9oneceys96ok` FOREIGN KEY (`sid`) REFERENCES `student` (`sid`),
  CONSTRAINT `FK7ka7rnodsusmlmyxn9xlx29f4` FOREIGN KEY (`tcid`) REFERENCES `testcontrol` (`tcid`),
  CONSTRAINT `testnote_ibfk_1` FOREIGN KEY (`sid`) REFERENCES `student` (`sid`),
  CONSTRAINT `testnote_ibfk_2` FOREIGN KEY (`qpid`) REFERENCES `questionpaper` (`qpid`)
) ENGINE=InnoDB AUTO_INCREMENT=124 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of testnote
-- ----------------------------
INSERT INTO `testnote` VALUES ('78', '1752601', null, '9', '11', '76');
INSERT INTO `testnote` VALUES ('111', '1752601', null, '10', '0', '74');
INSERT INTO `testnote` VALUES ('112', '1752602', null, '10', '0', '76');
INSERT INTO `testnote` VALUES ('113', '1752603', null, '10', '0', '76');
INSERT INTO `testnote` VALUES ('118', '1752601', null, '4', '6', '71');
INSERT INTO `testnote` VALUES ('123', '1752601', null, '8', '10', '67');
