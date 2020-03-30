/*
Navicat MySQL Data Transfer

Source Server         : MySQL_8
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : escapistchess

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2020-03-30 21:23:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for boss
-- ----------------------------
DROP TABLE IF EXISTS `boss`;
CREATE TABLE `boss` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `hp` int(11) NOT NULL,
  `atk` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of boss
-- ----------------------------
INSERT INTO `boss` VALUES ('1', '恶霸', '500', '50');
INSERT INTO `boss` VALUES ('2', '恐龙小子', '300', '100');
INSERT INTO `boss` VALUES ('3', '王哈桑', '600', '60');
INSERT INTO `boss` VALUES ('4', '伊利丹', '600', '60');

-- ----------------------------
-- Table structure for fight
-- ----------------------------
DROP TABLE IF EXISTS `fight`;
CREATE TABLE `fight` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `player` int(11) NOT NULL,
  `result` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fight
-- ----------------------------

-- ----------------------------
-- Table structure for item
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `hp` int(11) NOT NULL,
  `atk` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of item
-- ----------------------------
INSERT INTO `item` VALUES ('1', 'AK47', '0', '100');
INSERT INTO `item` VALUES ('2', '棒棒糖', '50', '10');
INSERT INTO `item` VALUES ('3', '汉堡', '100', '0');
INSERT INTO `item` VALUES ('4', '急救包', '150', '0');
INSERT INTO `item` VALUES ('5', '咖喱棒', '0', '150');
INSERT INTO `item` VALUES ('6', '马卡龙', '60', '0');
INSERT INTO `item` VALUES ('7', '面包片', '30', '0');
INSERT INTO `item` VALUES ('8', '牛奶', '40', '0');
INSERT INTO `item` VALUES ('9', '啤酒', '40', '20');
INSERT INTO `item` VALUES ('10', '西瓜', '30', '10');
INSERT INTO `item` VALUES ('11', '香蕉', '30', '10');
INSERT INTO `item` VALUES ('12', '雪糕', '20', '0');
INSERT INTO `item` VALUES ('13', '钻石剑', '0', '150');

-- ----------------------------
-- Table structure for map
-- ----------------------------
DROP TABLE IF EXISTS `map`;
CREATE TABLE `map` (
  `id` int(11) NOT NULL,
  `no1` int(11) NOT NULL,
  `no2` int(11) NOT NULL,
  `no3` int(11) NOT NULL,
  `no4` int(11) NOT NULL,
  `no5` int(11) NOT NULL,
  `no6` int(11) NOT NULL,
  `no7` int(11) NOT NULL,
  `no8` int(11) NOT NULL,
  `no9` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of map
-- ----------------------------
INSERT INTO `map` VALUES ('1', '1', '1', '3', '1', '5', '1', '5', '1', '3');
INSERT INTO `map` VALUES ('2', '1', '5', '1', '3', '1', '1', '1', '1', '5');
INSERT INTO `map` VALUES ('3', '5', '1', '5', '3', '1', '1', '1', '5', '1');
INSERT INTO `map` VALUES ('4', '3', '1', '1', '1', '5', '1', '1', '3', '1');
INSERT INTO `map` VALUES ('5', '1', '1', '1', '1', '3', '5', '5', '1', '3');
INSERT INTO `map` VALUES ('6', '1', '5', '5', '3', '1', '5', '3', '1', '1');
INSERT INTO `map` VALUES ('7', '5', '1', '1', '1', '5', '3', '1', '1', '5');
INSERT INTO `map` VALUES ('8', '1', '1', '5', '1', '3', '1', '3', '1', '1');
INSERT INTO `map` VALUES ('9', '1', '3', '1', '1', '1', '1', '5', '3', '5');
INSERT INTO `map` VALUES ('10', '5', '5', '1', '3', '3', '5', '1', '5', '3');
INSERT INTO `map` VALUES ('11', '3', '1', '5', '1', '5', '3', '1', '3', '3');
INSERT INTO `map` VALUES ('12', '3', '3', '5', '1', '1', '5', '5', '5', '1');
INSERT INTO `map` VALUES ('13', '5', '5', '1', '1', '1', '3', '5', '5', '1');
INSERT INTO `map` VALUES ('14', '3', '5', '1', '1', '3', '1', '1', '1', '1');
INSERT INTO `map` VALUES ('15', '1', '1', '1', '5', '3', '1', '5', '1', '1');
INSERT INTO `map` VALUES ('16', '1', '5', '5', '1', '3', '1', '3', '1', '5');

-- ----------------------------
-- Table structure for monster
-- ----------------------------
DROP TABLE IF EXISTS `monster`;
CREATE TABLE `monster` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `hp` int(11) NOT NULL,
  `atk` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of monster
-- ----------------------------
INSERT INTO `monster` VALUES ('1', '狗', '100', '10');
INSERT INTO `monster` VALUES ('2', '怪狗', '80', '15');
INSERT INTO `monster` VALUES ('3', '胖丁', '100', '15');
INSERT INTO `monster` VALUES ('4', '皮卡丘', '50', '50');
INSERT INTO `monster` VALUES ('5', '麒麟', '80', '20');
INSERT INTO `monster` VALUES ('6', '青蛙', '20', '10');
INSERT INTO `monster` VALUES ('7', '球', '60', '20');
INSERT INTO `monster` VALUES ('8', '兔子', '90', '10');
INSERT INTO `monster` VALUES ('9', '小狗', '70', '9');
INSERT INTO `monster` VALUES ('10', '小怪', '120', '20');
INSERT INTO `monster` VALUES ('11', '小黄鸭', '99', '14');
INSERT INTO `monster` VALUES ('12', '小蜗', '50', '50');
INSERT INTO `monster` VALUES ('13', '笑哭', '200', '200');
INSERT INTO `monster` VALUES ('14', '酷儿', '100', '15');

-- ----------------------------
-- Table structure for player
-- ----------------------------
DROP TABLE IF EXISTS `player`;
CREATE TABLE `player` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `hp` int(11) NOT NULL,
  `atk` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of player
-- ----------------------------
INSERT INTO `player` VALUES ('1', 'saber', '100', '20');
INSERT INTO `player` VALUES ('2', '超人', '200', '25');
INSERT INTO `player` VALUES ('3', '李华', '100', '15');
INSERT INTO `player` VALUES ('4', '路飞', '200', '20');
INSERT INTO `player` VALUES ('5', '女神', '100', '10');
