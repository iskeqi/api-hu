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

 Date: 17/11/2020 15:50:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for pj_api_environment
-- ----------------------------
DROP TABLE IF EXISTS `pj_api_environment`;
CREATE TABLE `pj_api_environment`
(
    `id`        bigint UNSIGNED                                               NOT NULL AUTO_INCREMENT COMMENT '环境ID',
    `name`      varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '环境名称',
    `url`       varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '前置URL',
    `note`      varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
    `projectId` bigint UNSIGNED                                               NULL DEFAULT NULL COMMENT '项目ID',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 9
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT = 'API 环境表'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pj_api_environment
-- ----------------------------
INSERT INTO `pj_api_environment`
VALUES (2, '测试环境', 'http://192.168.49.35/api-hu', '此环境用于开发自测和前端联调', 2);
INSERT INTO `pj_api_environment`
VALUES (7, '<<开发测试环境>>', 'http://192.168.49.35/api-hu', '此环境用于开发自测和前端联调', 2);
INSERT INTO `pj_api_environment`
VALUES (8, '<<开发测试环境>>', 'http://192.168.49.35/api-hu', '此环境用于开发自测和前端联调', 2);

-- ----------------------------
-- Table structure for pj_api_environment_param
-- ----------------------------
DROP TABLE IF EXISTS `pj_api_environment_param`;
CREATE TABLE `pj_api_environment_param`
(
    `id`                 bigint UNSIGNED                                               NOT NULL AUTO_INCREMENT COMMENT '参数ID',
    `param_name`         varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '参数名称',
    `param_value`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '参数值',
    `param_note`         varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '参数备注',
    `param_type`         char(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci      NULL DEFAULT NULL COMMENT '参数类型（HEADER/QUERY）',
    `api_environment_id` bigint UNSIGNED                                               NULL DEFAULT NULL COMMENT '所属环境ID',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 8
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT = 'API环境参数表'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pj_api_environment_param
-- ----------------------------
INSERT INTO `pj_api_environment_param`
VALUES (2, 'accessToken', 'GUiOiJTVVBFUl9BRE1JTiIsInByb2p', '访问accessToken', 'HEADER', 2);
INSERT INTO `pj_api_environment_param`
VALUES (6, '<<accessToken>>', 'GUiOiJTVVBFUl9BRE1JTiIsInByb2p', '访问accessToken', 'HEADER', 7);
INSERT INTO `pj_api_environment_param`
VALUES (7, '<<accessToken>>', 'GUiOiJTVVBFUl9BRE1JTiIsInByb2p', '访问accessToken', 'HEADER', 8);

-- ----------------------------
-- Table structure for pj_api_group
-- ----------------------------
DROP TABLE IF EXISTS `pj_api_group`;
CREATE TABLE `pj_api_group`
(
    `id`         bigint UNSIGNED                                               NOT NULL AUTO_INCREMENT COMMENT 'API分组ID',
    `parent_id`  bigint UNSIGNED                                               NULL DEFAULT NULL COMMENT '父级分组ID',
    `ancestors`  varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '祖级列表',
    `name`       varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NULL DEFAULT NULL COMMENT '分组名称',
    `order_num`  int UNSIGNED                                                  NULL DEFAULT NULL COMMENT '显示顺序',
    `project_id` bigint                                                        NULL DEFAULT NULL COMMENT '项目ID',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 47
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT = 'API分组表'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pj_api_group
-- ----------------------------
INSERT INTO `pj_api_group`
VALUES (41, 0, '0', '系统管理模块', 1, 2);
INSERT INTO `pj_api_group`
VALUES (42, 0, '0', '项目管理模块', 2, 2);
INSERT INTO `pj_api_group`
VALUES (43, 41, '0,41', '用户管理', 1, 2);
INSERT INTO `pj_api_group`
VALUES (44, 41, '0,41', '字典管理', 2, 2);
INSERT INTO `pj_api_group`
VALUES (45, 42, '0,42', 'API管理', 1, 2);
INSERT INTO `pj_api_group`
VALUES (46, 42, '0,42', '数据源管理', 2, 2);

-- ----------------------------
-- Table structure for pj_api_request
-- ----------------------------
DROP TABLE IF EXISTS `pj_api_request`;
CREATE TABLE `pj_api_request`
(
    `id`                      bigint UNSIGNED                                                NOT NULL AUTO_INCREMENT COMMENT 'API请求ID',
    `name`                    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NULL DEFAULT NULL COMMENT '接口名称',
    `url`                     varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NULL DEFAULT NULL COMMENT '接口地址',
    `requestMethod`           varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NULL DEFAULT NULL COMMENT '请求方式',
    `request_content_type`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NULL DEFAULT NULL COMMENT '请求数据类型',
    `response_content_type`   varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NULL DEFAULT NULL COMMENT '响应数据类型',
    `request_demo`            varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '请求示例',
    `response_demo`           varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '响应示例',
    `note`                    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NULL DEFAULT NULL COMMENT '接口描述',
    `request_json_root_type`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NULL DEFAULT NULL COMMENT '请求JSON根类型',
    `response_json_root_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NULL DEFAULT NULL COMMENT '响应JSON根类型',
    `projectId`               bigint UNSIGNED                                                NULL DEFAULT NULL COMMENT '项目ID',
    `api_group_id`            bigint UNSIGNED                                                NULL DEFAULT NULL COMMENT 'API所属分组ID',
    `order_num`               int UNSIGNED                                                   NULL DEFAULT NULL COMMENT '显示顺序',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 11
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT = 'API 请求表'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pj_api_request
-- ----------------------------
INSERT INTO `pj_api_request`
VALUES (10, '新增用户1', '/user/create', 'POST', 'application/json', 'application/json', '{}', '{}', '增加用户1', 'object',
        'object', 2, 43, 2);
INSERT INTO `pj_api_request`
VALUES (13, '新增e124用户', '/user/create', 'POST', 'application/json', 'application/json', '{}', '{}', '增加4213用户',
        'object', 'object', 2, 45, 1);

-- ----------------------------
-- Table structure for pj_api_request_param
-- ----------------------------
DROP TABLE IF EXISTS `pj_api_request_param`;
CREATE TABLE `pj_api_request_param`
(
    `id`             bigint UNSIGNED                                               NOT NULL AUTO_INCREMENT COMMENT 'API请求或响应参数ID',
    `name`           varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '参数名称',
    `note`           varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '参数说明',
    `required`       char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci      NULL DEFAULT NULL COMMENT '是否必须（必须 Y，非必须N）',
    `type`           char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci     NULL DEFAULT NULL COMMENT '参数类型(string,int等)',
    `example`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '示例',
    `param_type`     char(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci      NULL DEFAULT NULL COMMENT '请求/响应（REQUEST/RESPONSE）',
    `api_request_id` bigint UNSIGNED                                               NULL DEFAULT NULL COMMENT '请求API ID',
    `parent_id`      bigint UNSIGNED                                               NULL DEFAULT NULL COMMENT '父级参数ID(顶级参数的 parentId 置为0)',
    `order_num`      bigint                                                        NULL DEFAULT NULL COMMENT '参数排序字段',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 25
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT = 'API 请求的请求参数和相应参数'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pj_api_request_param
-- ----------------------------
INSERT INTO `pj_api_request_param`
VALUES (21, 'username', '用户名', 'Y', 'string', 'xiaoming', 'REQUEST', 10, 0, 1);
INSERT INTO `pj_api_request_param`
VALUES (22, 'username', '用户名', 'Y', 'string', 'xiaoming', 'REQUEST', 10, 21, 1);
INSERT INTO `pj_api_request_param`
VALUES (23, 'username', '用户名', 'Y', 'string', 'xiaoming', 'RESPONSE', 10, 0, 1);
INSERT INTO `pj_api_request_param`
VALUES (24, 'username', '用户名', 'Y', 'string', 'xiaoming', 'RESPONSE', 10, 23, 1);
INSERT INTO `pj_api_request_param`
VALUES (34, 'username', '用户名', 'Y', 'string', 'xiaoming', 'REQUEST', 13, 0, 1);
INSERT INTO `pj_api_request_param`
VALUES (35, 'username', '用户名', 'Y', 'string', 'xiaoming', 'REQUEST', 13, 34, 1);
INSERT INTO `pj_api_request_param`
VALUES (36, 'username', '用户名', 'Y', 'string', 'xiaoming', 'RESPONSE', 13, 0, 1);
INSERT INTO `pj_api_request_param`
VALUES (37, 'username', '用户名', 'Y', 'string', 'xiaoming', 'RESPONSE', 13, 36, 1);

-- ----------------------------
-- Table structure for pj_datasource
-- ----------------------------
DROP TABLE IF EXISTS `pj_datasource`;
CREATE TABLE `pj_datasource`
(
    `id`                bigint UNSIGNED                                               NOT NULL AUTO_INCREMENT COMMENT '数据源ID',
    `name`              varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '数据源名称',
    `url`               varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '数据源连接url',
    `driver_class_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '数据源驱动名',
    `username`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '数据源用户名',
    `password`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '数据源密码',
    `projectId`         bigint UNSIGNED                                               NULL DEFAULT NULL COMMENT '项目ID',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 8
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT = '数据源表'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pj_datasource
-- ----------------------------
INSERT INTO `pj_datasource`
VALUES (2, 'api-hu',
        'jdbc:mysql://10.10.20.200:3306/api-hu?useUnicode=true&characterEncoding=utf8&useSSL=true&serverTimezone=GMT%2B8&allowMultiQueries=true',
        'com.mysql.cj.jdbc.Driver', 'user_dev', 'Lt@888888', 2);
INSERT INTO `pj_datasource`
VALUES (3, 'api-hu3',
        'jdbc:mysql://10.10.20.200:3306/api-hu?useUnicode=true&characterEncoding=utf8&useSSL=true&serverTimezone=GMT%2B8&allowMultiQueries=true',
        'com.mysql.cj.jdbc.Driver', 'user_dev', 'Lt@888888', 2);
INSERT INTO `pj_datasource`
VALUES (4, 'api-hu4',
        'jdbc:mysql://10.10.20.200:3306/api-hu?useUnicode=true&characterEncoding=utf8&useSSL=true&serverTimezone=GMT%2B8&allowMultiQueries=true',
        'com.mysql.cj.jdbc.Driver', 'user_dev', 'Lt@888888', 2);
INSERT INTO `pj_datasource`
VALUES (5, 'api-hu5',
        'jdbc:mysql://10.10.20.200:3306/api-hu?useUnicode=true&characterEncoding=utf8&useSSL=true&serverTimezone=GMT%2B8&allowMultiQueries=true',
        'com.mysql.cj.jdbc.Driver', 'user_dev', 'Lt@888888', 2);
INSERT INTO `pj_datasource`
VALUES (6, 'api-hu6',
        'jdbc:mysql://10.10.20.200:3306/api-hu?useUnicode=true&characterEncoding=utf8&useSSL=true&serverTimezone=GMT%2B8&allowMultiQueries=true',
        'com.mysql.cj.jdbc.Driver', 'user_dev', 'Lt@888888', 2);

-- ----------------------------
-- Table structure for pj_datasource_table
-- ----------------------------
DROP TABLE IF EXISTS `pj_datasource_table`;
CREATE TABLE `pj_datasource_table`
(
    `id`            bigint UNSIGNED                                               NOT NULL AUTO_INCREMENT COMMENT '表结构ID',
    `datasource_id` bigint UNSIGNED                                               NULL DEFAULT NULL COMMENT '数据源ID',
    `table_name`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '表名称',
    `table_comment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '表备注',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1056
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT = '数据源表结构表'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pj_datasource_table
-- ----------------------------
INSERT INTO `pj_datasource_table`
VALUES (1049, 2, 'pj_datasource', '数据源表');
INSERT INTO `pj_datasource_table`
VALUES (1050, 2, 'pj_datasource_table', '数据源表结构表');
INSERT INTO `pj_datasource_table`
VALUES (1051, 2, 'pj_datasource_table_column', '表结构字段列表');
INSERT INTO `pj_datasource_table`
VALUES (1052, 2, 'sys_account', '用户表');
INSERT INTO `pj_datasource_table`
VALUES (1053, 2, 'sys_account_project', '用户-项目关联表');
INSERT INTO `pj_datasource_table`
VALUES (1054, 2, 'sys_dict_item', '系统管理-字典表');
INSERT INTO `pj_datasource_table`
VALUES (1055, 2, 'sys_project', '项目表');

-- ----------------------------
-- Table structure for pj_datasource_table_column
-- ----------------------------
DROP TABLE IF EXISTS `pj_datasource_table_column`;
CREATE TABLE `pj_datasource_table_column`
(
    `id`                  bigint UNSIGNED                                               NOT NULL AUTO_INCREMENT COMMENT '表字段ID',
    `datasource_table_id` bigint UNSIGNED                                               NULL DEFAULT NULL COMMENT '所属表ID',
    `column_name`         varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '列名',
    `column_type`         varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '列类型',
    `column_comment`      varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '列描述',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 11317
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT = '表结构字段列表'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pj_datasource_table_column
-- ----------------------------
INSERT INTO `pj_datasource_table_column`
VALUES (11277, 1049, 'id', 'bigint unsigned', '数据源ID');
INSERT INTO `pj_datasource_table_column`
VALUES (11278, 1049, 'name', 'varchar', '数据源名称');
INSERT INTO `pj_datasource_table_column`
VALUES (11279, 1049, 'url', 'varchar', '数据源连接url');
INSERT INTO `pj_datasource_table_column`
VALUES (11280, 1049, 'driver_class_name', 'varchar', '数据源驱动名');
INSERT INTO `pj_datasource_table_column`
VALUES (11281, 1049, 'username', 'varchar', '数据源用户名');
INSERT INTO `pj_datasource_table_column`
VALUES (11282, 1049, 'password', 'varchar', '数据源密码');
INSERT INTO `pj_datasource_table_column`
VALUES (11283, 1049, 'projectId', 'bigint unsigned', '项目ID');
INSERT INTO `pj_datasource_table_column`
VALUES (11284, 1050, 'id', 'bigint unsigned', '表结构ID');
INSERT INTO `pj_datasource_table_column`
VALUES (11285, 1050, 'datasource_id', 'bigint unsigned', '数据源ID');
INSERT INTO `pj_datasource_table_column`
VALUES (11286, 1050, 'table_name', 'varchar', '表名称');
INSERT INTO `pj_datasource_table_column`
VALUES (11287, 1050, 'table_comment', 'varchar', '表备注');
INSERT INTO `pj_datasource_table_column`
VALUES (11288, 1051, 'id', 'bigint unsigned', '表字段ID');
INSERT INTO `pj_datasource_table_column`
VALUES (11289, 1051, 'datasource_table_id', 'bigint unsigned', '所属表ID');
INSERT INTO `pj_datasource_table_column`
VALUES (11290, 1051, 'column_name', 'varchar', '列名');
INSERT INTO `pj_datasource_table_column`
VALUES (11291, 1051, 'column_type', 'varchar', '列类型');
INSERT INTO `pj_datasource_table_column`
VALUES (11292, 1051, 'column_comment', 'varchar', '列描述');
INSERT INTO `pj_datasource_table_column`
VALUES (11293, 1052, 'id', 'bigint unsigned', '用户ID');
INSERT INTO `pj_datasource_table_column`
VALUES (11294, 1052, 'account', 'varchar', '用户名');
INSERT INTO `pj_datasource_table_column`
VALUES (11295, 1052, 'nick_name', 'varchar', '姓名');
INSERT INTO `pj_datasource_table_column`
VALUES (11296, 1052, 'post', 'varchar', '岗位');
INSERT INTO `pj_datasource_table_column`
VALUES (11297, 1052, 'password', 'varchar', '密码');
INSERT INTO `pj_datasource_table_column`
VALUES (11298, 1052, 'create_time', 'datetime', '创建时间');
INSERT INTO `pj_datasource_table_column`
VALUES (11299, 1052, 'update_time', 'datetime', '修改时间');
INSERT INTO `pj_datasource_table_column`
VALUES (11300, 1053, 'account_id', 'bigint unsigned', '用户ID');
INSERT INTO `pj_datasource_table_column`
VALUES (11301, 1053, 'project_id', 'bigint unsigned', '项目ID');
INSERT INTO `pj_datasource_table_column`
VALUES (11302, 1054, 'id', 'bigint unsigned', '字典记录主键');
INSERT INTO `pj_datasource_table_column`
VALUES (11303, 1054, 'type_code', 'varchar', '字典类型编码');
INSERT INTO `pj_datasource_table_column`
VALUES (11304, 1054, 'type_name', 'varchar', '字典类型名称');
INSERT INTO `pj_datasource_table_column`
VALUES (11305, 1054, 'item_code', 'varchar', '字典项编码');
INSERT INTO `pj_datasource_table_column`
VALUES (11306, 1054, 'item_value', 'varchar', '字典项值');
INSERT INTO `pj_datasource_table_column`
VALUES (11307, 1054, 'item_sort', 'int unsigned', '字典项排序');
INSERT INTO `pj_datasource_table_column`
VALUES (11308, 1054, 'item_remark', 'varchar', '字典项备注字段');
INSERT INTO `pj_datasource_table_column`
VALUES (11309, 1054, 'item_css', 'varchar', '字典项样式属性(备用字段)');
INSERT INTO `pj_datasource_table_column`
VALUES (11310, 1054, 'delete_flag', 'char', '逻辑删除字段（Y 未删除，N 已删除）');
INSERT INTO `pj_datasource_table_column`
VALUES (11311, 1055, 'id', 'bigint unsigned', '项目ID');
INSERT INTO `pj_datasource_table_column`
VALUES (11312, 1055, 'project_name', 'varchar', '项目名称');
INSERT INTO `pj_datasource_table_column`
VALUES (11313, 1055, 'project_note', 'varchar', '项目描述信息');
INSERT INTO `pj_datasource_table_column`
VALUES (11314, 1055, 'delete_flag', 'char', '逻辑删除(Y：未删除，N：已删除)');
INSERT INTO `pj_datasource_table_column`
VALUES (11315, 1055, 'create_time', 'datetime', '创建时间');
INSERT INTO `pj_datasource_table_column`
VALUES (11316, 1055, 'update_time', 'datetime', '修改时间');

-- ----------------------------
-- Table structure for sys_account
-- ----------------------------
DROP TABLE IF EXISTS `sys_account`;
CREATE TABLE `sys_account`
(
    `id`          bigint UNSIGNED                                               NOT NULL AUTO_INCREMENT COMMENT '用户ID',
    `account`     varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NULL DEFAULT NULL COMMENT '用户名',
    `nick_name`   varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NULL DEFAULT NULL COMMENT '姓名',
    `post`        varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NULL DEFAULT NULL COMMENT '岗位',
    `password`    varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
    `create_time` datetime(0)                                                   NULL DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime(0)                                                   NULL DEFAULT NULL COMMENT '修改时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 11
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT = '用户表'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_account
-- ----------------------------
INSERT INTO `sys_account`
VALUES (1, 'admin', '超级管理员', '超级管理员', '7c705886f552f568826c12bb53b326c5594be799a9e64296ff59002275734449',
        '2020-11-10 11:42:23', '2020-11-10 11:42:26');
INSERT INTO `sys_account`
VALUES (4, 'xiaoming4', '小明4', '前端开发', 'c891a0200a63e2a97e9dc854018013b7b05ab1ae9b5c6c2426e902608cb9d27a',
        '2020-11-09 14:19:32', '2020-11-10 13:21:55');
INSERT INTO `sys_account`
VALUES (5, 'xiaoming5', '小明5', '安卓开发', '980feabde551de5e855d8d5a66a4313a22accda0f088c477aba20bd86b09ed4a',
        '2020-11-09 14:22:43', '2020-11-10 13:21:57');
INSERT INTO `sys_account`
VALUES (6, 'xiaoming6', '小明6', '后端开发', 'bbd701c83c76e687beafb3c9275add7b0ee81cd0800e83ae07d584713bf9d940',
        '2020-11-09 14:24:49', '2020-11-10 13:21:59');
INSERT INTO `sys_account`
VALUES (7, 'xiaoming7', '小明7', '后端开发', '363707a94d628f6deb4e8f9811d99947da6712891db541132e40ed3ea1190681',
        '2020-11-09 14:33:48', '2020-11-10 13:22:02');
INSERT INTO `sys_account`
VALUES (8, 'xiaoming8', '小明8', '后端开发', 'f08761cc30f6ea03e96c8e4aca4faee7d7b56d1d3215c14bbbd839cee47db779',
        '2020-11-09 14:34:29', '2020-11-10 13:22:04');
INSERT INTO `sys_account`
VALUES (10, 'xiaoming9', 'xiaoming9', 'IOS开发', '544714054708d657d9bbee98bc45540078a22f08affe31b68f4266d8ce269231',
        '2020-11-10 11:29:24', '2020-11-10 13:22:07');

-- ----------------------------
-- Table structure for sys_account_project
-- ----------------------------
DROP TABLE IF EXISTS `sys_account_project`;
CREATE TABLE `sys_account_project`
(
    `account_id` bigint UNSIGNED NOT NULL COMMENT '用户ID',
    `project_id` bigint UNSIGNED NOT NULL COMMENT '项目ID',
    PRIMARY KEY (`account_id`, `project_id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT = '用户-项目关联表'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_account_project
-- ----------------------------
INSERT INTO `sys_account_project`
VALUES (4, 2);
INSERT INTO `sys_account_project`
VALUES (5, 2);
INSERT INTO `sys_account_project`
VALUES (6, 2);
INSERT INTO `sys_account_project`
VALUES (7, 2);

-- ----------------------------
-- Table structure for sys_dict_item
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_item`;
CREATE TABLE `sys_dict_item`
(
    `id`          bigint UNSIGNED                                               NOT NULL AUTO_INCREMENT COMMENT '字典记录主键',
    `type_code`   varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字典类型编码',
    `type_name`   varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字典类型名称',
    `item_code`   varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字典项编码',
    `item_value`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字典项值',
    `item_sort`   int UNSIGNED                                                  NULL DEFAULT NULL COMMENT '字典项排序',
    `item_remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字典项备注字段',
    `item_css`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字典项样式属性(备用字段)',
    `delete_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci      NULL DEFAULT NULL COMMENT '逻辑删除字段（Y 未删除，N 已删除）',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 10
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT = '系统管理-字典表'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict_item
-- ----------------------------
INSERT INTO `sys_dict_item`
VALUES (1, 'gender', '性别', 'man', '男', 1, '男性', '备用字段', 'Y');
INSERT INTO `sys_dict_item`
VALUES (3, 'gender', '性别', 'women', '女', 2, '女性', '备用字段', 'Y');
INSERT INTO `sys_dict_item`
VALUES (4, 'post', '岗位', 'web', 'WEB前端开发工程师', 1, 'WEB前端开发工程师', 'WEB前端开发工程师', 'Y');
INSERT INTO `sys_dict_item`
VALUES (5, 'post', '岗位', 'java', 'JAVA开发工程师', 2, 'JAVA开发工程师', 'JAVA开发工程师', 'Y');
INSERT INTO `sys_dict_item`
VALUES (6, 'post', '岗位', 'test', '测试工程师', 3, '测试工程师', '测试工程师', 'Y');
INSERT INTO `sys_dict_item`
VALUES (7, 'post', '岗位', 'android', 'android开发工程师', 4, 'android开发工程师', 'android开发工程师', 'Y');
INSERT INTO `sys_dict_item`
VALUES (8, 'post', '岗位', 'ios', 'IOS开发工程师', 5, 'IOS开发工程师', 'IOS开发工程师', 'Y');
INSERT INTO `sys_dict_item`
VALUES (9, 'post', '岗位', 'product', '产品经理', 6, '产品经理', '产品经理', 'Y');

-- ----------------------------
-- Table structure for sys_project
-- ----------------------------
DROP TABLE IF EXISTS `sys_project`;
CREATE TABLE `sys_project`
(
    `id`           bigint UNSIGNED                                               NOT NULL AUTO_INCREMENT COMMENT '项目ID',
    `project_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NULL DEFAULT NULL COMMENT '项目名称',
    `project_note` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '项目描述信息',
    `delete_flag`  char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci      NULL DEFAULT NULL COMMENT '逻辑删除(Y：未删除，N：已删除)',
    `create_time`  datetime(0)                                                   NULL DEFAULT NULL COMMENT '创建时间',
    `update_time`  datetime(0)                                                   NULL DEFAULT NULL COMMENT '修改时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 5
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT = '项目表'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_project
-- ----------------------------
INSERT INTO `sys_project`
VALUES (1, '山东枣庄网格监管项目', '山东枣庄网格监管项目', 'Y', '2020-11-10 13:25:57', '2020-11-10 13:32:33');
INSERT INTO `sys_project`
VALUES (2, '网格监管', '山东枣庄网格监管项目', 'Y', '2020-11-10 14:08:55', '2020-11-10 14:08:55');
INSERT INTO `sys_project`
VALUES (3, '网格监管1', '山东枣庄网格监管项目', 'Y', '2020-11-10 14:08:59', '2020-11-10 14:08:59');
INSERT INTO `sys_project`
VALUES (4, '网格监管2', '山东枣庄网格监管项目', 'Y', '2020-11-10 14:09:04', '2020-11-10 14:09:04');

SET FOREIGN_KEY_CHECKS = 1;
