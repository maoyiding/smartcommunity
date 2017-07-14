/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : smart

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-07-13 16:19:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for appraise
-- ----------------------------
DROP TABLE IF EXISTS `appraise`;
CREATE TABLE `appraise` (
  `appraiseId` int(11) NOT NULL AUTO_INCREMENT,
  `appraise` varchar(255) DEFAULT NULL,
  `time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `url` varchar(255) DEFAULT NULL,
  `id` int(11) DEFAULT NULL COMMENT ' people Id',
  PRIMARY KEY (`appraiseId`),
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of appraise
-- ----------------------------

-- ----------------------------
-- Table structure for banner
-- ----------------------------
DROP TABLE IF EXISTS `banner`;
CREATE TABLE `banner` (
  `bannerId` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`bannerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of banner
-- ----------------------------

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `categoryId` int(11) NOT NULL AUTO_INCREMENT,
  `category` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`categoryId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '食品生鲜');
INSERT INTO `category` VALUES ('2', '医药保健');
INSERT INTO `category` VALUES ('3', '酒水饮料');
INSERT INTO `category` VALUES ('4', '家居清洁');
INSERT INTO `category` VALUES ('5', '母婴用品');
INSERT INTO `category` VALUES ('6', '手机数码');
INSERT INTO `category` VALUES ('7', '电脑办公');
INSERT INTO `category` VALUES ('8', '酒水饮料');
INSERT INTO `category` VALUES ('9', '成人用品');

-- ----------------------------
-- Table structure for city
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `cityId` int(11) NOT NULL AUTO_INCREMENT,
  `orderWrold` char(2) NOT NULL,
  `cityName` varchar(255) NOT NULL,
  PRIMARY KEY (`cityId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of city
-- ----------------------------
INSERT INTO `city` VALUES ('1', 'C', '成都');

-- ----------------------------
-- Table structure for community
-- ----------------------------
DROP TABLE IF EXISTS `community`;
CREATE TABLE `community` (
  `communityId` int(11) NOT NULL AUTO_INCREMENT,
  `community` varchar(255) NOT NULL,
  `cityId` int(11) DEFAULT NULL,
  PRIMARY KEY (`communityId`),
  KEY `cityId` (`cityId`),
  CONSTRAINT `community_ibfk_1` FOREIGN KEY (`cityId`) REFERENCES `city` (`cityId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of community
-- ----------------------------
INSERT INTO `community` VALUES ('1', '青羊区', '1');
INSERT INTO `community` VALUES ('2', '金牛区', '1');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `goodsId` int(11) NOT NULL AUTO_INCREMENT,
  `goods` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `price` float(10,2) DEFAULT NULL,
  `repertory` int(11) DEFAULT NULL,
  `goodsImg` varchar(255) DEFAULT NULL,
  `categoryId` int(11) DEFAULT NULL,
  PRIMARY KEY (`goodsId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', '清风卷纸 原木纯品', '3层270段卫生纸*27卷', '42.90', '999', null, '4');
INSERT INTO `goods` VALUES ('2', '清风卷纸 原木纯品金装', '3层120抽软抽*24包纸巾', '50.00', '999', null, '4');
INSERT INTO `goods` VALUES ('3', '美赞臣 荷兰婴幼儿奶粉', '0-6个月婴儿适用', '120.00', '999', null, '5');
INSERT INTO `goods` VALUES ('4', '杜蕾斯挚爱装避孕套', '润滑爱爱体验!', '32.90', '99', null, '9');

-- ----------------------------
-- Table structure for people
-- ----------------------------
DROP TABLE IF EXISTS `people`;
CREATE TABLE `people` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `phone` varchar(255) NOT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `autonym` varchar(255) NOT NULL COMMENT '实名',
  `cityCommunity` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `state` int(10) DEFAULT NULL COMMENT '0为toot，1为管理员，2为店长，3为客户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of people
-- ----------------------------
INSERT INTO `people` VALUES ('1', '13398199422', null, '黑崎一护', '重庆-洪崖洞小区', '洪崖洞古玩市场', '123456', '1');

-- ----------------------------
-- Table structure for propertymag
-- ----------------------------
DROP TABLE IF EXISTS `propertymag`;
CREATE TABLE `propertymag` (
  `id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of propertymag
-- ----------------------------
SET FOREIGN_KEY_CHECKS=1;
