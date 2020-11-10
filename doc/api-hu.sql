/*
 Navicat Premium Data Transfer

 Source Server         : 10.10.20.200
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : 10.10.20.200:3306
 Source Schema         : api-hu

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 10/11/2020 16:28:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_account
-- ----------------------------
DROP TABLE IF EXISTS `sys_account`;
CREATE TABLE `sys_account`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `account` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `nick_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `post` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '岗位',
  `password` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_account
-- ----------------------------
INSERT INTO `sys_account` VALUES (1, 'admin', '超级管理员', '超级管理员', '7c705886f552f568826c12bb53b326c5594be799a9e64296ff59002275734449', '2020-11-10 11:42:23', '2020-11-10 11:42:26');
INSERT INTO `sys_account` VALUES (4, 'xiaoming4', '小明4', '前端开发', 'c891a0200a63e2a97e9dc854018013b7b05ab1ae9b5c6c2426e902608cb9d27a', '2020-11-09 14:19:32', '2020-11-10 13:21:55');
INSERT INTO `sys_account` VALUES (5, 'xiaoming5', '小明5', '安卓开发', '980feabde551de5e855d8d5a66a4313a22accda0f088c477aba20bd86b09ed4a', '2020-11-09 14:22:43', '2020-11-10 13:21:57');
INSERT INTO `sys_account` VALUES (6, 'xiaoming6', '小明6', '后端开发', 'bbd701c83c76e687beafb3c9275add7b0ee81cd0800e83ae07d584713bf9d940', '2020-11-09 14:24:49', '2020-11-10 13:21:59');
INSERT INTO `sys_account` VALUES (7, 'xiaoming7', '小明7', '后端开发', '363707a94d628f6deb4e8f9811d99947da6712891db541132e40ed3ea1190681', '2020-11-09 14:33:48', '2020-11-10 13:22:02');
INSERT INTO `sys_account` VALUES (8, 'xiaoming8', '小明8', '后端开发', 'f08761cc30f6ea03e96c8e4aca4faee7d7b56d1d3215c14bbbd839cee47db779', '2020-11-09 14:34:29', '2020-11-10 13:22:04');
INSERT INTO `sys_account` VALUES (10, 'xiaoming9', 'xiaoming9', 'IOS开发', '544714054708d657d9bbee98bc45540078a22f08affe31b68f4266d8ce269231', '2020-11-10 11:29:24', '2020-11-10 13:22:07');

-- ----------------------------
-- Table structure for sys_account_project
-- ----------------------------
DROP TABLE IF EXISTS `sys_account_project`;
CREATE TABLE `sys_account_project`  (
  `account_id` bigint UNSIGNED NOT NULL COMMENT '用户ID',
  `project_id` bigint UNSIGNED NOT NULL COMMENT '项目ID',
  PRIMARY KEY (`account_id`, `project_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户-项目关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_account_project
-- ----------------------------
INSERT INTO `sys_account_project` VALUES (4, 2);
INSERT INTO `sys_account_project` VALUES (5, 2);
INSERT INTO `sys_account_project` VALUES (6, 2);
INSERT INTO `sys_account_project` VALUES (7, 2);

-- ----------------------------
-- Table structure for sys_dict_item
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_item`;
CREATE TABLE `sys_dict_item`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '字典记录主键',
  `type_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字典类型编码',
  `type_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字典类型名称',
  `item_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字典项编码',
  `item_value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字典项值',
  `item_sort` int UNSIGNED NULL DEFAULT NULL COMMENT '字典项排序',
  `item_remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字典项备注字段',
  `item_css` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字典项样式属性(备用字段)',
  `delete_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '逻辑删除字段（Y 未删除，N 已删除）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统管理-字典表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict_item
-- ----------------------------
INSERT INTO `sys_dict_item` VALUES (1, 'gender', '性别', 'man', '男', 1, '男性', '备用字段', 'Y');
INSERT INTO `sys_dict_item` VALUES (3, 'gender', '性别', 'women', '女', 2, '女性', '备用字段', 'Y');
INSERT INTO `sys_dict_item` VALUES (4, 'post', '岗位', 'web', 'WEB前端开发工程师', 1, 'WEB前端开发工程师', 'WEB前端开发工程师', 'Y');
INSERT INTO `sys_dict_item` VALUES (5, 'post', '岗位', 'java', 'JAVA开发工程师', 2, 'JAVA开发工程师', 'JAVA开发工程师', 'Y');
INSERT INTO `sys_dict_item` VALUES (6, 'post', '岗位', 'test', '测试工程师', 3, '测试工程师', '测试工程师', 'Y');
INSERT INTO `sys_dict_item` VALUES (7, 'post', '岗位', 'android', 'android开发工程师', 4, 'android开发工程师', 'android开发工程师', 'Y');
INSERT INTO `sys_dict_item` VALUES (8, 'post', '岗位', 'ios', 'IOS开发工程师', 5, 'IOS开发工程师', 'IOS开发工程师', 'Y');
INSERT INTO `sys_dict_item` VALUES (9, 'post', '岗位', 'product', '产品经理', 6, '产品经理', '产品经理', 'Y');

-- ----------------------------
-- Table structure for sys_project
-- ----------------------------
DROP TABLE IF EXISTS `sys_project`;
CREATE TABLE `sys_project`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '项目ID',
  `project_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '项目名称',
  `project_note` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '项目描述信息',
  `delete_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '逻辑删除(Y：未删除，N：已删除)',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '项目表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_project
-- ----------------------------
INSERT INTO `sys_project` VALUES (1, '山东枣庄网格监管项目', '山东枣庄网格监管项目', 'Y', '2020-11-10 13:25:57', '2020-11-10 13:32:33');
INSERT INTO `sys_project` VALUES (2, '网格监管', '山东枣庄网格监管项目', 'Y', '2020-11-10 14:08:55', '2020-11-10 14:08:55');
INSERT INTO `sys_project` VALUES (3, '网格监管1', '山东枣庄网格监管项目', 'Y', '2020-11-10 14:08:59', '2020-11-10 14:08:59');
INSERT INTO `sys_project` VALUES (4, '网格监管2', '山东枣庄网格监管项目', 'Y', '2020-11-10 14:09:04', '2020-11-10 14:09:04');

SET FOREIGN_KEY_CHECKS = 1;
