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

 Date: 09/11/2020 18:21:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_account
-- ----------------------------
DROP TABLE IF EXISTS `sys_account`;
CREATE TABLE `sys_account`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `account` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `nick_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `post` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '岗位',
  `password` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_account
-- ----------------------------
INSERT INTO `sys_account` VALUES (4, 'xiaoming4', '小明4', '前端开发', 'c891a0200a63e2a97e9dc854018013b7b05ab1ae9b5c6c2426e902608cb9d27a', '2020-11-09 14:19:32', '2020-11-09 14:53:51');
INSERT INTO `sys_account` VALUES (5, 'xiaoming5', '小明5', '安卓开发', '980feabde551de5e855d8d5a66a4313a22accda0f088c477aba20bd86b09ed4a', '2020-11-09 14:22:43', '2020-11-09 16:43:22');
INSERT INTO `sys_account` VALUES (6, 'xiaoming6', '小明6', '后端开发', 'bbd701c83c76e687beafb3c9275add7b0ee81cd0800e83ae07d584713bf9d940', '2020-11-09 14:24:49', '2020-11-09 14:24:49');
INSERT INTO `sys_account` VALUES (7, 'xiaoming7', '小明7', '后端开发', '363707a94d628f6deb4e8f9811d99947da6712891db541132e40ed3ea1190681', '2020-11-09 14:33:48', '2020-11-09 14:33:48');
INSERT INTO `sys_account` VALUES (8, 'xiaoming8', '小明8', '后端开发', 'f08761cc30f6ea03e96c8e4aca4faee7d7b56d1d3215c14bbbd839cee47db779', '2020-11-09 14:34:29', '2020-11-09 14:34:29');

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

-- ----------------------------
-- Table structure for sys_project
-- ----------------------------
DROP TABLE IF EXISTS `sys_project`;
CREATE TABLE `sys_project`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `project_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '项目名称',
  `project_note` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '项目描述信息',
  `delete_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '逻辑删除(Y：未删除，N：已删除)',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '项目表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_project
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
