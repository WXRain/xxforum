/*
MySQL Data Transfer
Source Host: localhost
Source Database: forum
Target Host: localhost
Target Database: forum
Date: 2016/7/25 21:50:51
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for reply
-- ----------------------------
CREATE TABLE `reply` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `topicId` int(10) NOT NULL,
  `toReplyId` int(10) NOT NULL,
  `toUserId` int(10) NOT NULL,
  `date` bigint(100) NOT NULL,
  `text` char(200) NOT NULL,
  `userId` int(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for section
-- ----------------------------
CREATE TABLE `section` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `introduce` varchar(200) NOT NULL,
  `topicCount` int(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for topic
-- ----------------------------
CREATE TABLE `topic` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `userId` int(10) NOT NULL,
  `sectionId` int(10) NOT NULL,
  `clickCount` int(10) NOT NULL,
  `replyCount` int(10) NOT NULL,
  `topicName` varchar(100) NOT NULL,
  `topicText` varchar(200) NOT NULL,
  `releaseDate` bigint(100) NOT NULL,
  `lastReplyDate` bigint(100) NOT NULL,
  `isTop` int(1) NOT NULL,
  `isFine` int(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `sex` int(1) NOT NULL,
  `level` int(2) NOT NULL,
  `exp` int(3) NOT NULL,
  `isManager` int(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `reply` VALUES ('1', '1', '0', '0', '1463472558848', '111', '0');
INSERT INTO `reply` VALUES ('2', '0', '0', '0', '0', 'this is test', '0');
INSERT INTO `reply` VALUES ('4', '0', '0', '0', '0', 'this is test', '0');
INSERT INTO `reply` VALUES ('5', '0', '0', '0', '0', 'this is test', '0');
INSERT INTO `reply` VALUES ('6', '0', '0', '0', '0', 'this is testUI', '3');
INSERT INTO `reply` VALUES ('7', '1', '0', '0', '1465736206775', '123', '1');
INSERT INTO `reply` VALUES ('8', '1', '7', '1', '1465736305778', '345', '1');
INSERT INTO `reply` VALUES ('9', '6', '0', '0', '1465805400218', '123456', '1');
INSERT INTO `reply` VALUES ('10', '6', '9', '1', '1465805410902', '123456789', '1');
INSERT INTO `reply` VALUES ('11', '6', '10', '1', '1465805426605', '123', '1');
INSERT INTO `reply` VALUES ('12', '6', '0', '0', '1465980197015', '这是回复', '1');
INSERT INTO `reply` VALUES ('13', '10', '0', '0', '1466038770847', '456', '9');
INSERT INTO `reply` VALUES ('14', '10', '13', '9', '1466038799265', '123456', '9');
INSERT INTO `section` VALUES ('1', 'FirstSection', 'this is firstSection', '1');
INSERT INTO `section` VALUES ('2', 'SecondSection', 'this is secondSection', '2');
INSERT INTO `section` VALUES ('3', 'ThirdSection', 'this is thirdSection', '1');
INSERT INTO `section` VALUES ('4', 'tmpSection', 'test?', '3');
INSERT INTO `section` VALUES ('5', 'liujun', '123', '4');
INSERT INTO `topic` VALUES ('1', '1', '1', '0', '3', 'this is first topic', 'one one one ', '1463456966960', '1465736305896', '1', '1');
INSERT INTO `topic` VALUES ('2', '3', '2', '0', '0', 'this is second topic', 'two two two', '1463456966960', '1463456966960', '1', '0');
INSERT INTO `topic` VALUES ('3', '4', '3', '2', '2', 'this is third topic', 'three three three', '1463456966960', '1463456966990', '0', '1');
INSERT INTO `topic` VALUES ('4', '1', '2', '0', '0', 'test2', 'this is test 2', '1465736525922', '1465736525922', '0', '0');
INSERT INTO `topic` VALUES ('6', '1', '5', '0', '4', 'liujun2', 'dfjkdjgjlkdsjlkdjf', '1465805324468', '1465980197064', '0', '0');
INSERT INTO `topic` VALUES ('7', '1', '5', '0', '0', '王', '王宇', '1465805487713', '1465805487713', '0', '0');
INSERT INTO `topic` VALUES ('8', '1', '5', '0', '0', 'di er ge', 'this is second one\r\n', '1465979696352', '1465979696352', '0', '0');
INSERT INTO `topic` VALUES ('9', '1', '5', '0', '0', 'di san ge', 'this is third one', '1465979711902', '1465979711902', '0', '0');
INSERT INTO `user` VALUES ('1', 'abc', '123', 'i am 1', '1', '10', '100', '1');
INSERT INTO `user` VALUES ('2', 'aaa', '456', 'i am 2', '1', '5', '50', '0');
INSERT INTO `user` VALUES ('3', 'bbb', '789', 'i am 3', '2', '0', '0', '1');
INSERT INTO `user` VALUES ('4', 'ccc', '001', 'i am 4', '2', '5', '0', '0');
INSERT INTO `user` VALUES ('5', '王宇', '123456', 'i am wangxinyu', '1', '110', '1000', '1');
INSERT INTO `user` VALUES ('8', 'aaaa', '123456', 'this is text', '1', '0', '0', '0');
INSERT INTO `user` VALUES ('9', 'w123456', '123456', '王', '1', '0', '0', '0');
