/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost:3306
 Source Schema         : bus

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 14/12/2018 13:59:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `state` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'Jame', 'e10adc3949ba59abbe56e057f20f883e', 'ROLE_ADMIN', 0);
INSERT INTO `admin` VALUES (2, 'James', '$2a$10$RXIP.5UWU./FtcaMDI57uOTBZv.A/jOoCh8sNvWRKRHwLyj2V6.qW', 'ROLE_ADMIN', 0);
INSERT INTO `admin` VALUES (3, 'admin', '$2a$10$5QCYucXlnFRL22oxI2xjHOJSUkRQjm8y0EEUEspjsAkFWdqzB1UY6', 'ROLE_ADMIN', 0);

-- ----------------------------
-- Table structure for bus
-- ----------------------------
DROP TABLE IF EXISTS `bus`;
CREATE TABLE `bus`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `card` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `driverId` int(11) NULL DEFAULT NULL,
  `wayId` int(11) NULL DEFAULT NULL,
  `price` double NULL DEFAULT NULL,
  `topen` timestamp(0) NULL DEFAULT NULL,
  `tclose` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `driverId`(`driverId`) USING BTREE,
  INDEX `wayId`(`wayId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bus
-- ----------------------------
INSERT INTO `bus` VALUES (1, 'DFSADSA', 1, 2, 1, NULL, NULL);

-- ----------------------------
-- Table structure for driver
-- ----------------------------
DROP TABLE IF EXISTS `driver`;
CREATE TABLE `driver`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `driver_card` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `head` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mobile` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` int(11) NULL DEFAULT 0,
  `last_bus` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of driver
-- ----------------------------
INSERT INTO `driver` VALUES (1, 'James', '19999999999', 19, NULL, '男', '15674995169', 0, NULL);

-- ----------------------------
-- Table structure for history
-- ----------------------------
DROP TABLE IF EXISTS `history`;
CREATE TABLE `history`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `busId` int(11) NULL DEFAULT NULL,
  `wayId` int(11) NULL DEFAULT NULL,
  `driverId` int(11) NULL DEFAULT NULL,
  `state` int(11) NULL DEFAULT 0,
  `tgo` timestamp(0) NULL DEFAULT NULL,
  `tend` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `busId`(`busId`) USING BTREE,
  INDEX `wayId`(`wayId`) USING BTREE,
  INDEX `driverId`(`driverId`) USING BTREE,
  CONSTRAINT `history_ibfk_1` FOREIGN KEY (`busId`) REFERENCES `bus` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `history_ibfk_2` FOREIGN KEY (`wayId`) REFERENCES `way` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `history_ibfk_3` FOREIGN KEY (`driverId`) REFERENCES `driver` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for station
-- ----------------------------
DROP TABLE IF EXISTS `station`;
CREATE TABLE `station`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of station
-- ----------------------------
INSERT INTO `station` VALUES (1, '暮云站');
INSERT INTO `station` VALUES (3, '湖南科技职业学院暮云校区');
INSERT INTO `station` VALUES (4, '暮云派出所');
INSERT INTO `station` VALUES (5, '中信广场');
INSERT INTO `station` VALUES (6, '大托城外城');
INSERT INTO `station` VALUES (7, '环宇城');
INSERT INTO `station` VALUES (8, '南托岭');
INSERT INTO `station` VALUES (9, '大托铺');
INSERT INTO `station` VALUES (10, '冰箱厂');

-- ----------------------------
-- Table structure for way
-- ----------------------------
DROP TABLE IF EXISTS `way`;
CREATE TABLE `way`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `topen` timestamp(0) NULL DEFAULT NULL,
  `tclose` timestamp(0) NULL DEFAULT NULL,
  `topenString` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tcloseString` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of way
-- ----------------------------
INSERT INTO `way` VALUES (2, '长株潭101', NULL, NULL, '8:00', '18:00');

-- ----------------------------
-- Table structure for way_station
-- ----------------------------
DROP TABLE IF EXISTS `way_station`;
CREATE TABLE `way_station`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stationId` int(11) NOT NULL,
  `wayId` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `stationId`(`stationId`) USING BTREE,
  INDEX `wayId`(`wayId`) USING BTREE,
  CONSTRAINT `way_station_ibfk_1` FOREIGN KEY (`stationId`) REFERENCES `station` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `way_station_ibfk_2` FOREIGN KEY (`wayId`) REFERENCES `way` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 49 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of way_station
-- ----------------------------
INSERT INTO `way_station` VALUES (41, 1, 2);
INSERT INTO `way_station` VALUES (42, 3, 2);
INSERT INTO `way_station` VALUES (43, 10, 2);
INSERT INTO `way_station` VALUES (44, 4, 2);
INSERT INTO `way_station` VALUES (45, 8, 2);
INSERT INTO `way_station` VALUES (46, 6, 2);
INSERT INTO `way_station` VALUES (47, 7, 2);
INSERT INTO `way_station` VALUES (48, 5, 2);

SET FOREIGN_KEY_CHECKS = 1;
