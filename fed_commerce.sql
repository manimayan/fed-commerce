/*
 Navicat Premium Data Transfer

 Source Server         : Mysql_DB
 Source Server Type    : MySQL
 Source Server Version : 50562 (5.5.62)
 Source Host           : localhost:3306
 Source Schema         : fed_commerce

 Target Server Type    : MySQL
 Target Server Version : 50562 (5.5.62)
 File Encoding         : 65001

 Date: 22/12/2022 15:30:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart`  (
  `user_id` varchar(45) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `product_id` int(11) NULL DEFAULT NULL,
  `quantity` int(11) NULL DEFAULT NULL,
  `updated_on` datetime NULL DEFAULT NULL,
  `cart_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`cart_id`) USING BTREE,
  INDEX `user_id_idx`(`user_id`) USING BTREE,
  INDEX `product_id_idx`(`product_id`) USING BTREE,
  CONSTRAINT `product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES ('william03', 4, 8, '2022-12-17 21:24:06', 8);

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NULL DEFAULT NULL,
  `user_id` varchar(45) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `updated_on` datetime NULL DEFAULT NULL,
  `quantity` int(11) NULL DEFAULT NULL,
  `order_batch` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`) USING BTREE,
  INDEX `prod_id_idx`(`product_id`) USING BTREE,
  INDEX `u_id_idx`(`user_id`) USING BTREE,
  CONSTRAINT `prod_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `u_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 64 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (50, 9, 'madhu13', '2022-12-18 19:25:24', 4, 1);
INSERT INTO `orders` VALUES (51, 10, 'madhu13', '2022-12-18 19:25:25', 2, 1);
INSERT INTO `orders` VALUES (52, 9, 'madhu13', '2022-12-18 19:25:29', 4, 2);
INSERT INTO `orders` VALUES (53, 10, 'madhu13', '2022-12-18 19:25:29', 2, 2);
INSERT INTO `orders` VALUES (54, 9, 'madhu13', '2022-12-18 19:25:33', 4, 3);
INSERT INTO `orders` VALUES (55, 10, 'madhu13', '2022-12-18 19:25:33', 2, 3);
INSERT INTO `orders` VALUES (56, 9, 'madhu13', '2022-12-18 19:25:38', 4, 4);
INSERT INTO `orders` VALUES (57, 10, 'madhu13', '2022-12-18 19:25:38', 2, 4);
INSERT INTO `orders` VALUES (58, 9, 'madhu13', '2022-12-18 20:11:50', 4, 5);
INSERT INTO `orders` VALUES (59, 10, 'madhu13', '2022-12-18 20:11:50', 2, 5);
INSERT INTO `orders` VALUES (60, 9, 'madhu13', '2022-12-18 20:11:53', 4, 6);
INSERT INTO `orders` VALUES (61, 10, 'madhu13', '2022-12-18 20:11:53', 2, 6);
INSERT INTO `orders` VALUES (62, 1, 'madhu13', '2022-12-20 23:44:42', 4, 7);
INSERT INTO `orders` VALUES (63, 3, 'madhu13', '2022-12-20 23:44:42', 9, 7);

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `description` varchar(45) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `category` varchar(45) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `price` varchar(45) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `quantity` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`product_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (1, 'HP Notebook Laptop', NULL, 'electronics', '899.00', 9);
INSERT INTO `product` VALUES (2, 'Intel RAM', NULL, 'electronics', '199.00', 8);
INSERT INTO `product` VALUES (3, 'Apple USB Charger', NULL, 'electronics', '49.00', 14);
INSERT INTO `product` VALUES (4, 'Sony Bluetooth Speaker', NULL, 'electronics', '149.00', 6);
INSERT INTO `product` VALUES (5, 'Camel Staples XS-100', NULL, 'stationery', '12.00', 202);
INSERT INTO `product` VALUES (9, 'Camlin Ruled Book XS-100', NULL, 'stationery', '9.00', 54);
INSERT INTO `product` VALUES (10, 'Old School Day - PaperBack', '', 'books', '13.00', 198);
INSERT INTO `product` VALUES (11, 'Nataraj Led Pencils', NULL, 'school', '123.00', 202);
INSERT INTO `product` VALUES (12, 'Lessons in Chemistry', NULL, 'books', '19.00', 202);
INSERT INTO `product` VALUES (13, 'The Richest Man in Babylon', NULL, 'books', '12.00', 50);
INSERT INTO `product` VALUES (14, 'Little Blue Truck Board Book', NULL, 'books', '10.00', 20);
INSERT INTO `product` VALUES (15, 'A Gentleman in Moscow', NULL, 'books', '5.99', 56);
INSERT INTO `product` VALUES (16, 'The Cat in the Hat', NULL, 'books', '6.99', 12);
INSERT INTO `product` VALUES (17, 'Room on the Broom', NULL, 'books', '9.99', 520);
INSERT INTO `product` VALUES (18, 'So Much Owed', NULL, 'books', '89.99', 565);
INSERT INTO `product` VALUES (19, 'ASUS VivoBook 15 (2021)', NULL, 'electronics', '399.00', 34);
INSERT INTO `product` VALUES (20, 'Lenovo IdeaPad Slim 3', NULL, 'electronics', '599.00', 45);
INSERT INTO `product` VALUES (21, 'boAt Wave Call Smart Watch', NULL, 'electronics', '199.00', 56);
INSERT INTO `product` VALUES (22, 'Lenovo Tab M10 FHD Plus', NULL, 'electronics', '119.00', 23);
INSERT INTO `product` VALUES (23, 'JK Copier Paper - A4, 75 GSM', NULL, 'stationery', '12.00', 45);
INSERT INTO `product` VALUES (24, 'Pidilite Fevicol 200 Gram Craft Glue', NULL, 'stationery', '9.00', 45);
INSERT INTO `product` VALUES (25, 'Cello Pinpoint Ball Pen', NULL, 'stationery', '3.99', 45);
INSERT INTO `product` VALUES (26, 'Parker Vector Standard CT Ball Pen', NULL, 'stationery', '1.99', 23);
INSERT INTO `product` VALUES (27, 'Wolpin Sticky Notes 400 Sheets', NULL, 'stationery', '3.99', 45);
INSERT INTO `product` VALUES (28, 'Pilot V7 Liquid Ink Roller Ball Pen', NULL, 'stationery', '2.99', 56);
INSERT INTO `product` VALUES (29, 'COI Daily to Do Notepads', NULL, 'stationery', '5.99', 34);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` varchar(45) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `name` varchar(45) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `password` varchar(45) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `city` varchar(45) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `postal_code` varchar(45) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `street` varchar(45) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('madhu13', 'Madhumitha Baskar', '12345678', 'Minneapolis', '55409', 'Stevens Ave');
INSERT INTO `user` VALUES ('manimayan11', 'Manimaran Palani', '12345678', 'Montreal', 'H3H2E7', 'Saint Marc');
INSERT INTO `user` VALUES ('tejas09', 'Tejaswini Devi', '12345678', 'Ottawa', 'JU7O09', 'Garry Street');
INSERT INTO `user` VALUES ('william03', 'William Moses', '12345678', 'Montreal', 'HYT675', 'Shermen Oakes');

SET FOREIGN_KEY_CHECKS = 1;
