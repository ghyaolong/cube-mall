/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : cube_mall

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 27/08/2019 11:52:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_ali_pay_log
-- ----------------------------
DROP TABLE IF EXISTS `t_ali_pay_log`;
CREATE TABLE `t_ali_pay_log`  (
  `id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `order_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `out_trade_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `total_amount` decimal(10, 0) NULL DEFAULT NULL,
  `trade_type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `customer_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  `create_time` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_attribute
-- ----------------------------
DROP TABLE IF EXISTS `t_attribute`;
CREATE TABLE `t_attribute`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '属性名称',
  `category_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '属性' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_attribute_options
-- ----------------------------
DROP TABLE IF EXISTS `t_attribute_options`;
CREATE TABLE `t_attribute_options`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `option` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '选项值',
  `attribute_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '属性id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '属性选项' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_brand
-- ----------------------------
DROP TABLE IF EXISTS `t_brand`;
CREATE TABLE `t_brand`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '品牌名称',
  `code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '品牌编码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '品牌' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_category
-- ----------------------------
DROP TABLE IF EXISTS `t_category`;
CREATE TABLE `t_category`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类名称',
  `code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类编码',
  `parent_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父类Id',
  `is_visable` int(11) NOT NULL DEFAULT 0 COMMENT '门户是否可见  0：可见    1：隐藏',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '链接URL',
  `sequence` float(255, 0) NULL DEFAULT NULL COMMENT '排序，数字越小，越靠前',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '分类' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_category
-- ----------------------------
INSERT INTO `t_category` VALUES ('1', '家用电器', '100', '0', 0, NULL, 10);
INSERT INTO `t_category` VALUES ('2', '电视', '101', '1', 0, NULL, 10);
INSERT INTO `t_category` VALUES ('3', '空调', '101', '1', 0, NULL, 10);
INSERT INTO `t_category` VALUES ('4', '洗衣机', '102', '1', 0, NULL, 10);
INSERT INTO `t_category` VALUES ('5', '手机', '200', '0', 0, NULL, 10);
INSERT INTO `t_category` VALUES ('6', '游戏机', '201', '5', 0, NULL, 10);
INSERT INTO `t_category` VALUES ('7', '老人机', '202', '5', 0, NULL, 10);

-- ----------------------------
-- Table structure for t_department
-- ----------------------------
DROP TABLE IF EXISTS `t_department`;
CREATE TABLE `t_department`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `del_flag` int(11) NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `parent_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sort_order` decimal(10, 2) NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_parent` bit(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_department
-- ----------------------------
INSERT INTO `t_department` VALUES ('40322777781112832', '', '2018-08-10 20:40:40', 0, '', '2018-08-11 00:03:06', '0', 1.00, 0, '总部', b'1');
INSERT INTO `t_department` VALUES ('40322811096469504', '', '2018-08-10 20:40:48', 0, '', '2019-03-14 18:50:44', '40322777781112832', 1.00, 0, '技术部', b'1');
INSERT INTO `t_department` VALUES ('40322852833988608', '', '2018-08-10 20:40:58', 0, '', '2018-08-11 01:29:42', '40322811096469504', 1.00, 0, '研发中心', NULL);
INSERT INTO `t_department` VALUES ('40327204755738624', '', '2018-08-10 20:58:15', 0, '', '2018-08-10 22:02:15', '40322811096469504', 2.00, 0, '大数据', NULL);
INSERT INTO `t_department` VALUES ('40327253309001728', '', '2018-08-10 20:58:27', 0, '', '2018-08-11 17:26:38', '40322811096469504', 3.00, -1, '人工智障', NULL);
INSERT INTO `t_department` VALUES ('40343262766043136', '', '2018-08-10 22:02:04', 0, '', '2018-08-11 00:02:53', '0', 2.00, 0, '成都分部', b'1');
INSERT INTO `t_department` VALUES ('40344005342400512', '', '2018-08-10 22:05:01', 0, '', '2018-08-11 17:48:44', '40343262766043136', 2.00, 0, 'Vue', NULL);
INSERT INTO `t_department` VALUES ('40389030113710080', '', '2018-08-11 01:03:56', 0, '', '2018-08-11 17:50:04', '40343262766043136', 1.00, 0, 'JAVA', b'0');
INSERT INTO `t_department` VALUES ('40652270295060480', '', '2018-08-11 18:29:57', 0, '', '2018-08-12 18:45:01', '0', 3.00, 0, '人事部', b'1');
INSERT INTO `t_department` VALUES ('40652338142121984', NULL, '2018-08-11 18:30:13', 0, NULL, '2018-08-11 18:30:13', '40652270295060480', 1.00, 0, '游客', b'0');
INSERT INTO `t_department` VALUES ('40681289119961088', '', '2018-08-11 20:25:16', 0, '', '2018-08-11 22:47:48', '40652270295060480', 2.00, 0, 'VIP', b'0');

-- ----------------------------
-- Table structure for t_log
-- ----------------------------
DROP TABLE IF EXISTS `t_log`;
CREATE TABLE `t_log`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `del_flag` int(11) NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `cost_time` int(11) NULL DEFAULT NULL,
  `ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ip_info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `request_param` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `request_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `request_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `log_type` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `order_no` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单编号',
  `member_id` int(11) NULL DEFAULT NULL COMMENT '客户编号',
  `status` int(11) NULL DEFAULT NULL COMMENT '订单状态 0未付款,1已付款,2已发货,3已签收,-1退货申请,-2退货中,-3已退货,-4取消交易',
  `after_status` int(11) NULL DEFAULT NULL COMMENT '用户售后状态 0 未发起售后 1 申请售后 -1 售后已取消 2 处理中 200 处理完毕',
  `product_count` int(11) NULL DEFAULT 0 COMMENT '商品数量',
  `product_amount_total` decimal(10, 2) NULL DEFAULT NULL COMMENT '商品总价',
  `order_amount_total` decimal(10, 2) NULL DEFAULT NULL COMMENT '实际付款金额',
  `address_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货地址编码',
  `pay_channel` tinyint(4) NULL DEFAULT NULL COMMENT '支付渠道 0余额 1微信 2支付宝',
  `out_trade_no` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单支付单号',
  `pay_time` timestamp(0) NULL DEFAULT NULL COMMENT '支付时间',
  `delivery_time` timestamp(0) NULL DEFAULT NULL COMMENT '发货时间',
  `end_time` timestamp(0) NULL DEFAULT NULL COMMENT '交易完成时间',
  `is_comment` int(11) NULL DEFAULT NULL COMMENT '买家是否评价',
  `delivery_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '快递名称：  顺丰   ，圆通......',
  `delivery_code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '快递单号',
  `sku_id` int(11) NULL DEFAULT NULL COMMENT 'skuId',
  `attribute_options` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '属性选项 json格式存储，有多个选项，就存储多个选项',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_pay_log
-- ----------------------------
DROP TABLE IF EXISTS `t_pay_log`;
CREATE TABLE `t_pay_log`  (
  `id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `order_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `out_trade_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pay_type` tinyint(4) NULL DEFAULT NULL,
  `step` int(11) NULL DEFAULT NULL,
  `content` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `member_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `del_flag` int(11) NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parent_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` int(11) NULL DEFAULT NULL,
  `sort_order` decimal(10, 2) NULL DEFAULT NULL,
  `component` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `level` int(11) NULL DEFAULT NULL,
  `button_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `show_always` bit(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_permission
-- ----------------------------
INSERT INTO `t_permission` VALUES ('102235632889237504', 'admin', '2019-01-28 17:00:15', 0, 'admin', '2019-01-28 17:00:15', NULL, 'vue-generator', '125909152017944576', 0, 3.10, 'Main', '/vue-generator', 'Vue代码生成', 'md-send', 1, NULL, 0, NULL, b'1');
INSERT INTO `t_permission` VALUES ('102237605176807424', 'admin', '2019-01-28 17:08:06', 0, 'admin', '2019-02-01 20:41:31', '', 'table-generator', '102235632889237504', 0, 0.00, 'xboot-vue-generator/tableGenerator', 'table', '增删改表格生成[付费]', 'md-grid', 2, '', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('102240052523831296', 'admin', '2019-01-28 17:17:49', 0, 'admin', '2019-02-01 20:41:38', '', 'tree-generator', '102235632889237504', 0, 1.00, 'xboot-vue-generator/treeGenerator', 'tree', '树形结构生成[付费]', 'md-git-branch', 2, '', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('103658022701633536', 'admin', '2019-02-01 15:12:20', 0, 'admin', '2019-02-01 18:38:29', '', 'test', '102235632889237504', 0, 3.00, 'xboot-vue-generator/test', 'test', '代码生成测试页', 'ios-bug', 2, '', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('113601631450304512', 'admin', '2019-03-01 01:44:41', 0, 'admin', '2019-03-01 01:44:41', NULL, '', '81716172680073216', 1, 2.00, '', '/xboot/actTask/backAll/**', '审批驳回至发起人', '', 3, 'disable', 0, NULL, b'1');
INSERT INTO `t_permission` VALUES ('113602149589454848', 'admin', '2019-03-01 01:46:44', 0, 'admin', '2019-06-26 20:38:55', '', 'components', '125909152017944576', 0, 5.00, 'Main', '/components', 'XBoot业务组件', 'md-cube', 1, '', 0, '', b'0');
INSERT INTO `t_permission` VALUES ('113602342657462272', 'admin', '2019-03-01 01:47:30', 0, 'admin', '2019-03-01 02:03:26', '', 'components', '113602149589454848', 0, 0.00, 'xboot-components/xboot-components', 'components', 'XBoot业务组件', 'md-cube', 2, '', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('113603512293658624', 'admin', '2019-03-01 01:52:09', 0, 'admin', '2019-06-26 20:38:47', '', 'library', '125909152017944576', 0, 6.00, 'Main', '/library', '第三方依赖工具/组件', 'ios-link', 1, '', 0, '', b'0');
INSERT INTO `t_permission` VALUES ('113603617897844736', 'admin', '2019-03-01 01:52:34', 0, 'admin', '2019-03-01 02:03:15', '', 'library', '113603512293658624', 0, 0.00, 'xboot-library/xboot-library', 'library', '第三方依赖工具/组件', 'ios-link', 2, '', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('117806106536841216', 'admin', '2019-03-12 16:11:46', 0, 'admin', '2019-03-12 16:11:46', NULL, 'process-finish-manage', '76606430504816640', 0, 0.80, 'activiti/process-finish-manage/processFinishManage', 'process-finish-manage', '结束的流程[付费]', 'md-power', 2, '', 0, NULL, b'1');
INSERT INTO `t_permission` VALUES ('121426317022334976', 'admin', '2019-03-22 15:57:11', 0, 'admin', '2019-03-22 15:57:11', NULL, 'redis', '39915540965232640', 0, 2.21, 'sys/redis/redis', 'redis', 'Redis缓存管理', 'md-barcode', 2, '', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('125909152017944576', 'admin', '2019-04-04 00:50:22', 0, 'admin', '2019-07-31 20:24:57', '', 'xboot', '', -1, 0.00, '', '', 'XBoot管理系统', 'md-home', 0, '', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('127995258721013760', 'admin', '2019-04-09 18:59:49', 0, 'admin', '2019-04-09 19:03:32', '', 'doc', '', -1, 1.00, '', '', 'XBoot开发文档', 'md-document', 0, '', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('127996320085446656', 'admin', '2019-04-09 19:04:02', 0, 'admin', '2019-07-08 12:06:33', '', 'app', '', -1, 2.00, '', '', '小程序与Flutter App', 'md-phone-portrait', 0, '', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('127996726786134016', 'admin', '2019-04-09 19:05:39', 0, 'admin', '2019-04-09 19:05:39', NULL, 'xpay', NULL, -1, 3.00, NULL, NULL, 'XPay支付系统', 'md-cash', 0, NULL, 0, NULL, b'1');
INSERT INTO `t_permission` VALUES ('127997001756315648', 'admin', '2019-04-09 19:06:44', 0, 'admin', '2019-04-09 19:06:44', NULL, 'xmall', NULL, -1, 4.00, NULL, NULL, 'XMall商城', 'md-cart', 0, NULL, 0, NULL, b'1');
INSERT INTO `t_permission` VALUES ('128364633437245440', 'admin', '2019-04-10 19:27:35', 0, 'admin', '2019-04-10 19:27:44', '', 'xboot-show', '', -1, 2.10, '', '', 'XBoot宣传官网', 'md-paper-plane', 0, '', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('128366789653434368', 'admin', '2019-04-10 19:36:09', 0, 'admin', '2019-07-08 12:20:51', '', 'flutter', '127996320085446656', 0, 1.00, 'Main', '/flutter', 'XBoot Flutter App', 'md-phone-portrait', 1, '', 0, '', b'0');
INSERT INTO `t_permission` VALUES ('128368112335589376', 'admin', '2019-04-10 19:41:24', 0, 'admin', '2019-04-10 19:41:24', NULL, 'flutter', '128366789653434368', 0, 0.00, 'flutter/flutter', 'flutter', 'XBoot Flutter App', 'md-phone-portrait', 2, '', 0, NULL, b'1');
INSERT INTO `t_permission` VALUES ('129033675403694080', 'admin', '2019-04-12 15:46:07', 0, 'admin', '2019-04-12 15:49:08', '', 'single-window', '41373430515240960', 0, 3.20, 'xboot-vue-template/single-window/singleWindow', 'single-window', '动态组件单页操作', 'md-easel', 2, '', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('149452775095275520', 'admin', '2019-06-08 00:04:19', 0, 'admin', '2019-06-08 00:04:19', NULL, 'admin', '39915540965232640', 0, 2.29, 'sys/monitor/monitor', '/admin', 'Admin监控', 'md-speedometer', 2, '', 0, 'http://127.0.0.1:8888/xboot/admin', b'1');
INSERT INTO `t_permission` VALUES ('156365156580855808', 'admin', '2019-06-27 01:51:39', 0, 'admin', '2019-06-27 01:51:39', NULL, '', '5129710648430593', 1, 1.18, '', '/xboot/user/resetPass', '重置密码', '', 3, 'other', 0, NULL, b'1');
INSERT INTO `t_permission` VALUES ('15701400130424832', '', '2018-06-03 22:04:06', 0, '', '2018-09-19 22:16:44', '', '', '5129710648430593', 1, 1.11, '', '/xboot/user/admin/add*', '添加用户', '', 3, 'add', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('15701915807518720', '', '2018-06-03 22:06:09', 0, '', '2018-06-06 14:46:51', '', '', '5129710648430593', 1, 1.13, '', '/xboot/user/admin/disable/**', '禁用用户', '', 3, 'disable', 0, NULL, b'1');
INSERT INTO `t_permission` VALUES ('15708892205944832', '', '2018-06-03 22:33:52', 0, '', '2018-06-28 16:44:48', '', '', '5129710648430593', 1, 1.14, '', '/xboot/user/admin/enable/**', '启用用户', '', 3, 'enable', 0, NULL, b'1');
INSERT INTO `t_permission` VALUES ('160509731956330496', 'admin', '2019-07-08 12:20:43', 0, 'admin', '2019-07-08 12:22:13', '', 'weapp', '127996320085446656', 0, 0.00, 'Main', '/weapp', '微信小程序', 'ios-appstore', 1, '', 0, '', b'0');
INSERT INTO `t_permission` VALUES ('160509918166650881', 'admin', '2019-07-08 12:21:28', 0, 'admin', '2019-07-08 12:21:28', NULL, 'weapp', '160509731956330496', 0, 0.00, 'weapp/weapp', 'weapp', '微信小程序', 'ios-apps', 2, '', 0, NULL, b'1');
INSERT INTO `t_permission` VALUES ('16392452747300864', '', '2018-06-05 19:50:06', 0, 'admin', '2019-06-26 20:38:41', '', 'access', '125909152017944576', 0, 7.00, 'Main', '/access', '权限按钮测试页', 'md-lock', 1, '', 0, '', b'0');
INSERT INTO `t_permission` VALUES ('16392767785668608', '', '2018-06-05 19:51:21', 0, 'admin', '2018-10-23 12:34:38', '', 'access_index', '16392452747300864', 0, 5.10, 'access/access', 'index', '权限按钮测试页', 'md-lock', 2, '', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('16438800255291392', '', '2018-06-05 22:54:18', 0, 'admin', '2018-10-23 12:34:51', '', '', '16392767785668608', 1, 5.11, '', 'test-add', '添加按钮测试', '', 3, 'add', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('16438962738434048', '', '2018-06-05 22:54:55', 0, 'admin', '2018-10-23 12:35:05', '', '', '16392767785668608', 1, 5.12, '', 'test-edit', '编辑按钮测试', '', 3, 'edit', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('16439068543946752', '', '2018-06-05 22:55:20', 0, 'admin', '2018-10-23 12:34:54', '', '', '16392767785668608', 1, 5.13, '', 'test-delete', '删除按钮测试', '', 3, 'delete', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('16678126574637056', '', '2018-06-06 14:45:16', 0, '', '2018-09-19 22:16:48', '', '', '5129710648430593', 1, 1.12, '', '/xboot/user/admin/edit*', '编辑用户', '', 3, 'edit', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('16678447719911424', '', '2018-06-06 14:46:32', 0, '', '2018-08-10 21:41:16', '', '', '5129710648430593', 1, 1.15, '', '/xboot/user/delByIds/**', '删除用户', '', 3, 'delete', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('16687383932047360', '', '2018-06-06 15:22:03', 0, '', '2018-09-19 22:07:34', '', '', '5129710648430594', 1, 1.21, '', '/xboot/role/save*', '添加角色', '', 3, 'add', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('16689632049631232', '', '2018-06-06 15:30:59', 0, '', '2018-09-19 22:07:37', '', '', '5129710648430594', 1, 1.22, '', '/xboot/role/edit*', '编辑角色', '', 3, 'edit', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('16689745006432256', '', '2018-06-06 15:31:26', 0, '', '2018-08-10 21:41:23', '', '', '5129710648430594', 1, 1.23, '', '/xboot/role/delAllByIds/**', '删除角色', '', 3, 'delete', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('16689883993083904', NULL, '2018-06-06 15:31:59', 0, NULL, '2018-06-06 15:31:59', NULL, NULL, '5129710648430594', 1, 1.24, NULL, '/xboot/role/editRolePerm**', '分配权限', NULL, 3, 'editPerm', 0, NULL, b'1');
INSERT INTO `t_permission` VALUES ('16690313745666048', '', '2018-06-06 15:33:41', 0, '', '2018-09-19 22:07:46', '', '', '5129710648430594', 1, 1.25, '', '/xboot/role/setDefault*', '设为默认角色', '', 3, 'setDefault', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('16694861252005888', '', '2018-06-06 15:51:46', 0, '', '2018-09-19 22:07:52', '', '', '5129710648430595', 1, 1.31, '', '/xboot/permission/add*', '添加菜单', '', 3, 'add', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('16695107491205120', '', '2018-06-06 15:52:44', 0, '', '2018-09-19 22:07:57', '', '', '5129710648430595', 1, 1.32, '', '/xboot/permission/edit*', '编辑菜单', '', 3, 'edit', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('16695243126607872', '', '2018-06-06 15:53:17', 0, '', '2018-08-10 21:41:33', '', '', '5129710648430595', 1, 1.33, '', '/xboot/permission/delByIds/**', '删除菜单', '', 3, 'delete', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('175808753877127169', 'admin', '2019-08-19 17:33:34', 0, 'admin', '2019-08-19 17:34:41', '', 'sso', '125909152017944576', 0, 8.00, 'Main', '/sso', '单点登录测试站', 'md-log-in', 1, '', 0, '', b'0');
INSERT INTO `t_permission` VALUES ('175808922710446081', 'admin', '2019-08-19 17:34:15', 0, 'admin', '2019-08-19 17:34:15', NULL, 'sso', '175808753877127169', 0, 0.00, 'sso/sso', 'sso', '单点登录测试站', 'md-log-in', 2, '', 0, NULL, b'1');
INSERT INTO `t_permission` VALUES ('25014528525733888', '', '2018-06-29 14:51:09', 0, '', '2018-10-08 11:13:27', '', '', '5129710648430593', 1, 1.16, '', '无', '上传图片', '', 3, 'upload', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('39915540965232640', NULL, '2018-08-09 17:42:28', 0, NULL, '2018-08-09 17:42:28', NULL, 'monitor', '125909152017944576', 0, 2.00, 'Main', '/monitor', '系统监控', 'ios-analytics', 1, NULL, 0, NULL, b'1');
INSERT INTO `t_permission` VALUES ('39916171171991552', '', '2018-08-09 17:44:57', 0, 'admin', '2019-01-20 00:37:29', '', 'druid', '39915540965232640', 0, 2.40, 'sys/monitor/monitor', 'druid', 'SQL监控', 'md-analytics', 2, '', 0, 'http://127.0.0.1:8888/druid/login.html', b'1');
INSERT INTO `t_permission` VALUES ('39918482854252544', '', '2018-08-09 17:54:08', 0, 'admin', '2019-01-20 00:37:41', '', 'swagger', '39915540965232640', 0, 2.50, 'sys/monitor/monitor', 'swagger', '接口文档', 'md-document', 2, '', 0, 'http://127.0.0.1:8888/swagger-ui.html', b'1');
INSERT INTO `t_permission` VALUES ('40238597734928384', NULL, '2018-08-10 15:06:10', 0, NULL, '2018-08-10 15:06:10', NULL, 'department-manage', '5129710648430592', 0, 1.20, 'sys/department-manage/departmentManage', 'department-manage', '部门管理', 'md-git-branch', 2, '', 0, NULL, b'1');
INSERT INTO `t_permission` VALUES ('41363147411427328', '', '2018-08-13 17:34:43', 0, '', '2018-08-20 20:05:21', '', 'log-manage', '39915540965232640', 0, 2.20, 'sys/log-manage/logManage', 'log-manage', '操作日志管理', 'md-list-box', 2, '', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('41363537456533504', '', '2018-08-13 17:36:16', 0, '', '2018-08-13 17:56:11', '', '', '41363147411427328', 1, 2.11, '', '/xboot/log/delByIds/**', '删除日志', '', 3, 'delete', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('41364927394353152', '', '2018-08-13 17:41:48', 0, '', '2018-09-19 22:08:57', '', '', '41363147411427328', 1, 2.12, '', '/xboot/log/delAll*', '清空日志', '', 3, 'undefined', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('41370251991977984', NULL, '2018-08-13 18:02:57', 0, NULL, '2018-08-13 18:02:57', NULL, 'quartz-job', '39915540965232640', 0, 2.10, 'sys/quartz-manage/quartzManage', 'quartz-job', '定时任务', 'md-time', 2, '', 0, NULL, b'1');
INSERT INTO `t_permission` VALUES ('41371711400054784', '', '2018-08-13 18:08:45', 0, '', '2019-07-07 21:24:26', '', 'actuator', '39915540965232640', 0, 2.30, 'sys/actuator/actuator', 'actuator', 'Actuator监控', 'logo-angular', 2, '', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('41373430515240960', '', '2018-08-13 18:15:35', 0, 'admin', '2018-11-17 11:41:44', '', 'vue-template', '125909152017944576', 0, 3.00, 'Main', '/vue-template', '后台Vue模版', 'ios-albums', 1, '', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('41375330996326400', '', '2018-08-13 18:23:08', 0, 'admin', '2018-10-20 22:47:07', '', 'simple-table', '41373430515240960', 0, 3.10, 'xboot-vue-template/simple-table/simpleTable', 'simple-table', '简单表格', 'ios-grid-outline', 2, '', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('41376192166629376', '', '2018-08-13 18:26:33', 0, 'admin', '2018-10-20 22:47:26', '', 'search-table', '41373430515240960', 0, 3.40, 'xboot-vue-template/search-table/searchTable', 'search-table', '搜索表格[付费]', 'md-grid', 2, '', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('41377034236071936', '', '2018-08-13 18:29:54', 0, 'admin', '2018-10-20 22:47:33', '', 'complex-table', '41373430515240960', 0, 3.50, 'xboot-vue-template/complex-table/complexTable', 'complex-table', '复杂表格[付费]', 'ios-grid', 2, '', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('41378916912336896', '', '2018-08-13 18:37:23', 0, 'admin', '2019-04-12 15:38:08', '', 'tree', '41373430515240960', 0, 3.22, 'xboot-vue-template/tree/tree', 'tree', '树形结构', 'ios-git-network', 2, '', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('41469219249852416', NULL, '2018-08-14 00:36:13', 0, NULL, '2018-08-14 00:36:13', NULL, '', '41371711400054784', 1, 2.31, '', '无', '查看数据', '', 3, 'view', 0, NULL, b'1');
INSERT INTO `t_permission` VALUES ('42082442672082944', '', '2018-08-15 17:12:57', 0, 'admin', '2019-04-12 15:48:50', '', 'new-window', '41373430515240960', 0, 3.21, 'xboot-vue-template/new-window/newWindow', 'new-window', '新窗口操作', 'ios-browsers', 2, '', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('42087054753927168', '', '2018-08-15 17:31:16', 0, 'admin', '2019-06-03 13:07:48', '', 'html-edit', '41373430515240960', 0, 3.92, 'xboot-vue-template/html-edit/htmlEdit', 'html-edit', '富文本编辑[付费]', 'ios-create', 2, '', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('43117268627886080', '', '2018-08-18 13:44:58', 0, '', '2018-08-18 20:55:04', '', 'message-manage', '5129710648430592', 0, 1.30, 'sys/message-manage/messageManage', 'message-manage', '消息管理[付费]', 'md-mail', 2, '', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('44986029924421632', '', '2018-08-23 17:30:46', 0, '', '2018-09-23 23:26:53', '', 'social-manage', '5129710648430592', 0, 1.50, 'sys/social-manage/socialManage', 'social-manage', '社交账号绑定[付费]', 'md-share', 2, '', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('45069342940860416', '', '2018-08-23 23:01:49', 0, '', '2018-08-24 10:01:09', '', '', '44986029924421632', 1, 1.42, '', '无', '查看社交账号数据', '', 3, 'view', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('45235228800716800', '', '2018-08-24 10:01:00', 0, '', '2018-09-19 22:07:23', '', '', '44986029924421632', 1, 1.41, '', '/xboot/relate/delByIds*', '删除解绑', '', 3, 'delete', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('45235621697949696', '', '2018-08-24 10:02:33', 0, '', '2018-09-19 22:06:57', '', '', '40238597734928384', 1, 1.21, '', '/xboot/department/add*', '添加部门', '', 3, 'add', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('45235787867885568', '', '2018-08-24 10:03:13', 0, '', '2018-09-19 22:07:02', '', '', '40238597734928384', 1, 1.22, '', '/xboot/department/edit*', '编辑部门', '', 3, 'edit', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('45235939278065664', NULL, '2018-08-24 10:03:49', 0, NULL, '2018-08-24 10:03:49', NULL, '', '40238597734928384', 1, 1.23, '', '/xboot/department/delByIds/*', '删除部门', '', 3, 'delete', 0, NULL, b'1');
INSERT INTO `t_permission` VALUES ('45236734832676864', '', '2018-08-24 10:06:59', 0, '', '2018-09-19 22:07:07', '', '', '43117268627886080', 1, 1.31, '', '/xboot/message/add*', '添加消息', '', 3, 'add', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('45237010692050944', '', '2018-08-24 10:08:04', 0, '', '2018-09-19 22:07:12', '', '', '43117268627886080', 1, 1.32, '', '/xboot/message/edit*', '编辑消息', '', 3, 'edit', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('45237170029465600', NULL, '2018-08-24 10:08:42', 0, NULL, '2018-08-24 10:08:42', NULL, '', '43117268627886080', 1, 1.33, '', '/xboot/message/delByIds/*', '删除消息', '', 3, 'delete', 0, NULL, b'1');
INSERT INTO `t_permission` VALUES ('45264987354042368', '', '2018-08-24 11:59:14', 0, '', '2018-09-19 22:08:11', '', '', '41370251991977984', 1, 2.11, '', '/xboot/quartzJob/add*', '添加定时任务', '', 3, 'add', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('45265487029866496', '', '2018-08-24 12:01:14', 0, '', '2018-09-19 22:08:17', '', '', '41370251991977984', 1, 2.12, '', '/xboot/quartzJob/edit*', '编辑定时任务', '', 3, 'edit', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('45265762415284224', '', '2018-08-24 12:02:19', 0, '', '2018-09-19 22:08:24', '', '', '41370251991977984', 1, 2.13, '', '/xboot/quartzJob/pause*', '暂停定时任务', '', 3, 'disable', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('45265886315024384', '', '2018-08-24 12:02:49', 0, '', '2018-09-19 22:09:13', '', '', '41370251991977984', 1, 2.14, '', '/xboot/quartzJob/resume*', '恢复定时任务', '', 3, 'enable', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('45266070000373760', NULL, '2018-08-24 12:03:33', 0, NULL, '2018-08-24 12:03:33', NULL, '', '41370251991977984', 1, 2.15, '', '/xboot/quartzJob/delByIds/*', '删除定时任务', '', 3, 'delete', 0, NULL, b'1');
INSERT INTO `t_permission` VALUES ('5129710648430592', '', '2018-06-04 19:02:29', 0, '', '2018-09-29 23:11:56', '', 'sys', '125909152017944576', 0, 1.00, 'Main', '/sys', '系统管理', 'ios-settings', 1, '', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('5129710648430593', '', '2018-06-04 19:02:32', 0, '', '2018-08-13 15:15:33', '', 'user-manage', '5129710648430592', 0, 1.10, 'sys/user-manage/userManage', 'user-manage', '用户管理', 'md-person', 2, '', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('5129710648430594', '', '2018-06-04 19:02:35', 0, '', '2018-10-13 13:51:36', '', 'role-manage', '5129710648430592', 0, 1.60, 'sys/role-manage/roleManage', 'role-manage', '角色权限管理', 'md-contacts', 2, '', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('5129710648430595', '', '2018-06-04 19:02:37', 0, '', '2018-09-23 23:32:02', '', 'menu-manage', '5129710648430592', 0, 1.70, 'sys/menu-manage/menuManage', 'menu-manage', '菜单权限管理', 'md-menu', 2, '', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('56309618086776832', '', '2018-09-23 23:26:40', 0, 'admin', '2018-11-15 15:17:43', '', 'oss-manage', '5129710648430592', 0, 1.40, 'sys/oss-manage/ossManage', 'oss-manage', '文件对象存储[付费]', 'ios-folder', 2, '', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('56898976661639168', '', '2018-09-25 14:28:34', 0, '', '2018-09-25 15:12:46', '', '', '5129710648430593', 1, 1.17, '', '/xboot/user/importData*', '导入用户', '', 3, 'input', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('56911328312299520', '', '2018-09-25 15:17:39', 0, 'admin', '2018-10-20 22:47:36', '', 'excel', '41373430515240960', 0, 3.60, 'xboot-vue-template/excel/excel', 'excel', 'Excel导入导出[付费]', 'md-exit', 2, '', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('57009544286441472', NULL, '2018-09-25 21:47:55', 0, NULL, '2018-09-25 21:47:55', NULL, '', '43117268627886080', 1, 1.40, '', '/xboot/messageSend/save*', '添加已发送消息', '', 3, 'add', 0, NULL, b'1');
INSERT INTO `t_permission` VALUES ('57009744761589760', NULL, '2018-09-25 21:48:43', 0, NULL, '2018-09-25 21:48:43', NULL, '', '43117268627886080', 1, 1.50, '', '/xboot/messageSend/update*', '编辑已发送消息', '', 3, 'edit', 0, NULL, b'1');
INSERT INTO `t_permission` VALUES ('57009981228060672', NULL, '2018-09-25 21:49:39', 0, NULL, '2018-09-25 21:49:39', NULL, '', '43117268627886080', 1, 1.60, '', '/xboot/messageSend/delByIds/*', '删除已发送消息', '', 3, 'delete', 0, NULL, b'1');
INSERT INTO `t_permission` VALUES ('57212882168844288', '', '2018-09-26 11:15:55', 0, '', '2018-10-08 11:10:05', '', '', '56309618086776832', 1, 1.41, '', '无', '上传文件', '', 3, 'upload', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('58480609315524608', '', '2018-09-29 23:13:24', 0, 'admin', '2018-11-14 13:24:26', '', 'setting', '5129710648430592', 0, 1.90, 'sys/setting-manage/settingManage', 'setting', '系统配置[付费]', 'ios-settings-outline', 2, '', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('61394706252173312', NULL, '2018-10-08 00:12:59', 0, NULL, '2018-10-08 00:12:59', NULL, '', '58480609315524608', 1, 1.81, '', '/xboot/setting/seeSecret/**', '查看私密配置', '', 3, 'view', 0, NULL, b'1');
INSERT INTO `t_permission` VALUES ('61417744146370560', '', '2018-10-08 01:44:32', 0, '', '2018-10-08 01:50:03', '', '', '58480609315524608', 1, 1.82, '', '/xboot/setting/*/set*', '编辑配置', '', 3, 'edit', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('61560041605435392', NULL, '2018-10-08 11:09:58', 0, NULL, '2018-10-08 11:09:58', NULL, '', '56309618086776832', 1, 1.42, '', '/xboot/file/rename*', '重命名文件', '', 3, 'edit', 0, NULL, b'1');
INSERT INTO `t_permission` VALUES ('61560275261722624', NULL, '2018-10-08 11:10:54', 0, NULL, '2018-10-08 11:10:54', NULL, '', '56309618086776832', 1, 1.43, '', '/xboot/file/copy*', '复制文件', '', 3, 'edit', 0, NULL, b'1');
INSERT INTO `t_permission` VALUES ('61560480518377472', NULL, '2018-10-08 11:11:43', 0, NULL, '2018-10-08 11:11:43', NULL, '', '56309618086776832', 1, 1.44, '', '/xboot/file/delete/*', '删除文件', '', 3, 'delete', 0, NULL, b'1');
INSERT INTO `t_permission` VALUES ('63482475359244288', '', '2018-10-13 18:29:02', 0, 'admin', '2018-10-20 22:47:45', '', 'custom-tree', '41373430515240960', 0, 3.80, 'xboot-vue-template/custom-tree/customTree', 'custom-tree', '自定义树[付费]', 'md-git-network', 2, '', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('63741744973352960', '', '2018-10-14 11:39:17', 0, 'admin', '2019-02-04 17:03:07', '', 'render', '41373430515240960', 0, 3.30, 'xboot-vue-template/render/render', 'render', 'Render函数示例[付费]', 'md-aperture', 2, '', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('64290663792906240', '', '2018-10-16 00:00:29', 0, 'admin', '2018-10-20 22:47:49', '', 'tree&table', '41373430515240960', 0, 3.90, 'xboot-vue-template/tree&table/tree&table', 'tree&table', '树+表格[付费]', 'md-list', 2, '', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('66790433014943744', 'admin', '2018-10-22 21:33:42', 0, 'admin', '2018-10-22 21:37:12', '', 'card-list', '41373430515240960', 0, 3.91, 'xboot-vue-template/card-list/cardList', 'card-list', '卡片列表[付费]', 'md-card', 2, '', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('67027338952445952', 'admin', '2018-10-23 13:15:03', 0, 'admin', '2018-10-23 14:57:38', '', 'product-template', '125909152017944576', 0, 4.00, 'Main', '/product-template', '前台产品级组件', 'md-ribbon', 1, '', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('67027909637836800', 'admin', '2018-10-23 13:17:19', 0, 'admin', '2018-10-23 14:57:46', '', 'banner', '67027338952445952', 0, 4.10, 'product-template/banner/Banner', 'banner', '轮播组件[付费]', 'md-book', 2, '', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('67042515441684480', 'admin', '2018-10-23 14:15:22', 0, 'admin', '2018-10-23 14:57:51', '', 'product', '67027338952445952', 0, 4.20, 'product-template/product/Product', 'product', '产品组件[付费]', 'md-pricetags', 2, '', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('67082402312228864', 'admin', '2018-10-23 16:53:53', 0, 'admin', '2018-10-23 16:53:53', NULL, 'category', '67027338952445952', 0, 4.30, 'product-template/category/Category', 'category', '分类栏组件[付费]', 'md-apps', 2, '', 0, NULL, b'1');
INSERT INTO `t_permission` VALUES ('75002207560273920', 'admin', '2018-11-14 13:24:21', 0, 'admin', '2018-11-20 20:06:22', '', 'dict', '5129710648430592', 0, 1.80, 'sys/dict-manage/dictManage', 'dict', '数据字典管理', 'md-bookmarks', 2, '', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('76215889006956544', 'admin', '2018-11-17 21:47:05', 0, 'admin', '2018-11-17 21:47:53', '', '', '75002207560273920', 1, 1.81, '', '/xboot/dict/add*', '添加字典', '', 3, 'add', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('76216071333351424', 'admin', '2018-11-17 21:47:48', 0, 'admin', '2018-11-17 21:47:48', NULL, '', '75002207560273920', 1, 1.82, '', '/xboot/dict/edit*', '编辑字典', '', 3, 'edit', 0, NULL, b'1');
INSERT INTO `t_permission` VALUES ('76216264070008832', 'admin', '2018-11-17 21:48:34', 0, 'admin', '2018-11-17 21:48:34', NULL, '', '75002207560273920', 1, 1.83, '', '/xboot/dict/delByIds/**', '删除字典', '', 3, 'delete', 0, NULL, b'1');
INSERT INTO `t_permission` VALUES ('76216459709124608', 'admin', '2018-11-17 21:49:21', 0, 'admin', '2018-11-17 21:49:21', NULL, '', '75002207560273920', 1, 1.84, '', '/xboot/dictData/add*', '添加字典数据', '', 3, 'add', 0, NULL, b'1');
INSERT INTO `t_permission` VALUES ('76216594207870976', 'admin', '2018-11-17 21:49:53', 0, 'admin', '2018-11-17 21:49:53', NULL, '', '75002207560273920', 1, 1.85, '', '/xboot/dictData/edit*', '编辑字典数据', '', 3, 'edit', 0, NULL, b'1');
INSERT INTO `t_permission` VALUES ('76216702639017984', 'admin', '2018-11-17 21:50:18', 0, 'admin', '2018-11-17 21:50:18', NULL, '', '75002207560273920', 1, 1.86, '', '/xboot/dictData/delByIds/**', '删除字典数据', '', 3, 'delete', 0, NULL, b'1');
INSERT INTO `t_permission` VALUES ('76606430504816640', 'admin', '2018-11-18 23:38:57', 0, 'admin', '2018-11-18 23:39:12', '', 'activiti', '125909152017944576', 0, 1.10, 'Main', '/activiti', '工作流程', 'md-git-compare', 1, '', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('76607201262702592', 'admin', '2018-11-18 23:42:01', 0, 'admin', '2018-11-20 19:41:58', '', 'model-manage', '76606430504816640', 0, 1.00, 'activiti/model-manage/modelManage', 'model-manage', '模型管理[付费]', 'md-cube', 2, '', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('76914082455752704', 'admin', '2018-11-19 20:01:28', 0, 'admin', '2018-11-20 19:41:50', '', 'process-manage', '76606430504816640', 0, 0.90, 'activiti/process-manage/processManage', 'process-manage', '流程管理[付费]', 'md-calendar', 2, '', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('80539147005071360', 'admin', '2018-11-29 20:06:10', 0, 'admin', '2018-12-04 14:14:41', '', 'category-manage', '76606430504816640', 0, 2.00, 'activiti/category-manage/categoryManage', 'category-manage', '流程分类管理[付费]', 'md-bookmark', 2, '', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('81319435670917120', 'admin', '2018-12-01 23:46:45', 0, 'admin', '2018-12-02 15:37:03', '', 'process-ins-manage', '76606430504816640', 0, 0.70, 'activiti/process-ins-manage/processInsManage', 'process-ins-manage', '运行中的流程[付费]', 'md-fastforward', 2, '', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('81558529864896512', 'admin', '2018-12-02 15:36:50', 0, 'admin', '2018-12-08 14:50:38', '', 'apply-manage', '76606430504816640', 0, 0.00, 'activiti/apply-manage/applyManage', 'apply-manage', '我的申请[付费]', 'md-clipboard', 2, '', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('81716172680073216', 'admin', '2018-12-03 02:03:15', 0, 'admin', '2018-12-03 02:03:15', NULL, 'todo-manage', '76606430504816640', 0, 0.10, 'activiti/todo-manage/todoManage', 'todo-manage', '我的待办[付费]', 'ios-pricetag', 2, '', 0, NULL, b'1');
INSERT INTO `t_permission` VALUES ('82269650301227008', 'admin', '2018-12-04 14:42:34', 0, 'admin', '2018-12-04 14:42:34', NULL, 'done-manage', '76606430504816640', 0, 0.20, 'activiti/done-manage/doneManage', 'done-manage', '我的已办[付费]', 'ios-pricetag-outline', 2, '', 0, NULL, b'1');
INSERT INTO `t_permission` VALUES ('84082369492946944', 'admin', '2018-12-09 14:45:40', 0, 'admin', '2018-12-09 14:46:59', '', '', '81558529864896512', 1, 0.00, '', '/xboot/leave/add*', '添加请假申请', '', 3, 'add', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('84082920431554560', 'admin', '2018-12-09 14:47:51', 0, 'admin', '2018-12-09 14:47:51', NULL, '', '81558529864896512', 1, 1.00, '', '/xboot/actBusiness/delByIds/**', '删除草稿申请', '', 3, 'delete', 0, NULL, b'1');
INSERT INTO `t_permission` VALUES ('84083562503999488', 'admin', '2018-12-09 14:50:25', 0, 'admin', '2018-12-09 14:50:25', NULL, '', '81716172680073216', 1, 0.00, '', '/xboot/actTask/pass**', '审批通过', '', 3, 'enable', 0, NULL, b'1');
INSERT INTO `t_permission` VALUES ('84083641302388736', 'admin', '2018-12-09 14:50:43', 0, 'admin', '2018-12-09 14:50:43', NULL, '', '81716172680073216', 1, 1.00, '', '/xboot/actTask/back**', '审批驳回', '', 3, 'disable', 0, NULL, b'1');
INSERT INTO `t_permission` VALUES ('84084404707659776', 'admin', '2018-12-09 14:53:45', 0, 'admin', '2018-12-09 14:53:45', NULL, '', '81716172680073216', 1, 3.00, '', '/xboot/actTask/delegate**', '委托代办', '', 3, 'other', 0, NULL, b'1');
INSERT INTO `t_permission` VALUES ('84084724590448640', 'admin', '2018-12-09 14:55:02', 0, 'admin', '2018-12-09 14:55:02', NULL, '', '82269650301227008', 1, 0.00, '', '/xboot/actTask/deleteHistoric/**', '删除已办任务', '', 3, 'delete', 0, NULL, b'1');
INSERT INTO `t_permission` VALUES ('84084965817454592', 'admin', '2018-12-09 14:55:59', 0, 'admin', '2018-12-09 14:55:59', NULL, '', '81319435670917120', 1, 0.00, '', '/xboot/actProcess/delInsByIds/**', '删除运行流程', '', 3, 'delete', 0, NULL, b'1');
INSERT INTO `t_permission` VALUES ('84085542324539392', 'admin', '2018-12-09 14:58:17', 0, 'admin', '2018-12-09 14:58:17', NULL, '', '76914082455752704', 1, 0.00, '', '/xboot/actProcess/updateInfo/**', '编辑流程信息', '', 3, 'edit', 0, NULL, b'1');
INSERT INTO `t_permission` VALUES ('84085810797744128', 'admin', '2018-12-09 14:59:21', 0, 'admin', '2018-12-09 14:59:21', NULL, '', '76914082455752704', 1, 1.00, '', '/xboot/actProcess/editNodeUser**', '流程节点设置', '', 3, 'edit', 0, NULL, b'1');
INSERT INTO `t_permission` VALUES ('84085980943880192', 'admin', '2018-12-09 15:00:01', 0, 'admin', '2018-12-09 15:00:01', NULL, '', '76914082455752704', 1, 2.00, '', '/xboot/actProcess/convertToModel/**', '流程转模型', '', 3, 'other', 0, NULL, b'1');
INSERT INTO `t_permission` VALUES ('84086163001839616', 'admin', '2018-12-09 15:00:45', 0, 'admin', '2018-12-09 15:01:37', '', '', '76914082455752704', 1, 3.00, '', '/xboot/actProcess/delByIds/**', '删除流程定义', '', 3, 'delete', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('84086362248056832', 'admin', '2018-12-09 15:01:32', 0, 'admin', '2018-12-09 15:01:32', NULL, '', '76914082455752704', 1, 4.00, '', '/xboot/actModel/deployByFile**', '文件部署流程', '', 3, 'other', 0, NULL, b'1');
INSERT INTO `t_permission` VALUES ('84086882907983872', 'admin', '2018-12-09 15:03:36', 0, 'admin', '2018-12-09 15:03:36', NULL, '', '76607201262702592', 1, 0.00, '', '/xboot/actModel/add**', '添加模型', '', 3, 'add', 0, NULL, b'1');
INSERT INTO `t_permission` VALUES ('84087009940869120', 'admin', '2018-12-09 15:04:06', 0, 'admin', '2018-12-09 15:04:06', NULL, '', '76607201262702592', 1, 1.00, '', '/xboot/actModel/delByIds/**', '删除模型', '', 3, 'delete', 0, NULL, b'1');
INSERT INTO `t_permission` VALUES ('84087154040377344', 'admin', '2018-12-09 15:04:41', 0, 'admin', '2018-12-09 15:04:41', NULL, '', '76607201262702592', 1, 2.00, '', '/xboot/actModel/deploy/**', '部署模型', '', 3, 'other', 0, NULL, b'1');
INSERT INTO `t_permission` VALUES ('84087344352727040', 'admin', '2018-12-09 15:05:26', 0, 'admin', '2018-12-09 15:05:33', '', '', '80539147005071360', 1, 0.00, '', '/xboot/actCategory/add**', '添加流程分类', '', 3, 'add', 0, '', b'1');
INSERT INTO `t_permission` VALUES ('84087480852156416', 'admin', '2018-12-09 15:05:59', 0, 'admin', '2018-12-09 15:05:59', NULL, '', '80539147005071360', 1, 1.00, '', '/xboot/actCategory/edit**', '编辑流程分类', '', 3, 'edit', 0, NULL, b'1');
INSERT INTO `t_permission` VALUES ('84087593041399808', 'admin', '2018-12-09 15:06:25', 0, 'admin', '2018-12-09 15:06:25', NULL, '', '80539147005071360', 1, 2.00, '', '/xboot/actCategory/delByIds/**', '删除流程分类', '', 3, 'delete', 0, NULL, b'1');

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `del_flag` int(11) NULL DEFAULT NULL,
  `default_role` bit(1) NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `data_type` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('16457350655250432', '', '2018-06-06 00:08:00', 'admin', '2018-11-02 20:42:24', 'ROLE_TEST', 0, NULL, '测试权限按钮显示', 1);
INSERT INTO `t_role` VALUES ('496138616573952', '', '2018-04-22 23:03:49', 'admin', '2018-11-15 23:02:59', 'ROLE_ADMIN', 0, NULL, '超级管理员 拥有所有权限', 0);
INSERT INTO `t_role` VALUES ('496138616573953', '', '2018-05-02 21:40:03', 'admin', '2018-11-01 22:59:48', 'ROLE_USER', 0, b'1', '普通注册用户 路过看看', 0);

-- ----------------------------
-- Table structure for t_role_department
-- ----------------------------
DROP TABLE IF EXISTS `t_role_department`;
CREATE TABLE `t_role_department`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `del_flag` int(11) NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `department_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role_department
-- ----------------------------
INSERT INTO `t_role_department` VALUES ('70763874256687105', 'admin', '2018-11-02 20:42:43', 0, 'admin', '2018-11-02 20:42:43', '40322777781112832', '16457350655250432');
INSERT INTO `t_role_department` VALUES ('70763874265075712', 'admin', '2018-11-02 20:42:43', 0, 'admin', '2018-11-02 20:42:43', '40322811096469504', '16457350655250432');
INSERT INTO `t_role_department` VALUES ('70763874277658624', 'admin', '2018-11-02 20:42:43', 0, 'admin', '2018-11-02 20:42:43', '40322852833988608', '16457350655250432');

-- ----------------------------
-- Table structure for t_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_role_permission`;
CREATE TABLE `t_role_permission`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `del_flag` int(11) NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `permission_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role_permission
-- ----------------------------
INSERT INTO `t_role_permission` VALUES ('175808979732008960', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '125909152017944576', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979736203264', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '5129710648430592', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979740397568', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '5129710648430593', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979744591872', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '15701400130424832', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979748786176', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '16678126574637056', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979752980480', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '15701915807518720', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979757174784', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '15708892205944832', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979761369088', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '16678447719911424', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979765563392', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '25014528525733888', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979765563394', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '56898976661639168', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979769757697', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '156365156580855808', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979773952001', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '40238597734928384', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979782340608', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '45235621697949696', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979786534912', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '45235787867885568', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979790729217', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '45235939278065664', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979794923521', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '43117268627886080', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979799117824', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '45236734832676864', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979803312128', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '45237010692050944', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979807506432', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '45237170029465600', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979811700736', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '57009544286441472', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979811700738', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '57009744761589760', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979815895041', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '57009981228060672', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979820089345', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '56309618086776832', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979824283649', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '57212882168844288', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979828477952', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '61560041605435392', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979832672256', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '61560275261722624', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979836866560', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '61560480518377472', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979841060864', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '44986029924421632', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979845255168', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '45235228800716800', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979849449473', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '45069342940860416', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979853643777', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '5129710648430594', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979862032384', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '16687383932047360', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979866226688', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '16689632049631232', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979870420992', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '16689745006432256', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979874615296', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '16689883993083904', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979878809600', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '16690313745666048', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979883003904', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '5129710648430595', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979887198208', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '16694861252005888', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979887198210', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '16695107491205120', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979891392513', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '16695243126607872', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979895586817', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '75002207560273920', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979899781120', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '76215889006956544', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979903975424', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '76216071333351424', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979908169728', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '76216264070008832', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979912364032', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '76216459709124608', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979912364034', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '76216594207870976', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979920752640', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '76216702639017984', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979924946944', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '58480609315524608', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979929141248', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '61394706252173312', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979933335552', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '61417744146370560', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979937529857', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '76606430504816640', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979941724161', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '81558529864896512', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979945918465', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '84082369492946944', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979950112769', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '84082920431554560', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979954307073', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '81716172680073216', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979958501376', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '84083562503999488', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979962695680', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '84083641302388736', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979966889984', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '113601631450304512', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979971084288', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '84084404707659776', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979975278592', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '82269650301227008', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979975278594', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '84084724590448640', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979979472897', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '81319435670917120', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979983667201', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '84084965817454592', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979987861505', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '117806106536841216', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808979996250112', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '76914082455752704', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980000444416', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '84085542324539392', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980004638720', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '84085810797744128', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980008833024', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '84085980943880192', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980013027329', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '84086163001839616', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980017221633', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '84086362248056832', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980021415937', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '76607201262702592', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980025610240', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '84086882907983872', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980029804544', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '84087009940869120', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980033998848', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '84087154040377344', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980038193152', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '80539147005071360', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980042387456', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '84087344352727040', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980042387458', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '84087480852156416', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980046581761', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '84087593041399808', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980050776065', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '39915540965232640', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980054970369', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '41370251991977984', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980063358976', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '45264987354042368', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980067553280', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '45265487029866496', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980071747584', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '45265762415284224', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980075941888', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '45265886315024384', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980080136193', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '45266070000373760', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980084330497', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '41363147411427328', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980088524801', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '41363537456533504', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980092719105', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '41364927394353152', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980096913409', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '121426317022334976', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980101107713', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '149452775095275520', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980105302016', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '41371711400054784', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980109496320', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '41469219249852416', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980113690624', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '39916171171991552', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980117884928', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '39918482854252544', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980117884930', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '41373430515240960', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980122079233', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '41375330996326400', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980126273537', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '129033675403694080', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980134662144', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '42082442672082944', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980138856448', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '41378916912336896', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980138856450', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '63741744973352960', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980143050753', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '41376192166629376', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980147245057', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '41377034236071936', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980155633664', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '56911328312299520', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980159827968', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '63482475359244288', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980164022272', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '64290663792906240', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980168216576', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '66790433014943744', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980168216578', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '42087054753927168', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980172410881', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '102235632889237504', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980176605185', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '102237605176807424', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980180799489', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '102240052523831296', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980184993793', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '103658022701633536', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980189188096', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '67027338952445952', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980193382400', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '67027909637836800', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980197576704', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '67042515441684480', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980201771009', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '67082402312228864', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980205965313', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '113602149589454848', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980214353920', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '113602342657462272', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980218548224', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '113603512293658624', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980222742528', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '113603617897844736', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980226936832', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '16392452747300864', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980231131136', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '16392767785668608', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980235325440', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '16438800255291392', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980239519744', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '16438962738434048', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980239519746', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '16439068543946752', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980243714049', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '175808753877127169', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980247908353', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '175808922710446081', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980252102657', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '127995258721013760', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980256296960', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '127996320085446656', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980260491264', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '160509731956330496', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980260491266', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '160509918166650881', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980264685569', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '128366789653434368', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980273074176', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '128368112335589376', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980273074178', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '128364633437245440', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980277268481', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '127996726786134016', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175808980281462785', 'admin', '2019-08-19 17:34:28', 0, 'admin', '2019-08-19 17:34:28', '127997001756315648', '496138616573952');
INSERT INTO `t_role_permission` VALUES ('175877407536844800', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '125909152017944576', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407541039104', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '5129710648430592', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407549427712', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '5129710648430593', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407553622016', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '40238597734928384', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407557816321', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '43117268627886080', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407566204928', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '57009744761589760', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407570399232', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '56309618086776832', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407574593537', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '44986029924421632', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407582982144', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '5129710648430594', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407591370752', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '5129710648430595', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407595565056', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '75002207560273920', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407603953664', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '58480609315524608', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407608147968', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '76606430504816640', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407612342273', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '81558529864896512', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407620730880', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '81716172680073216', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407624925185', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '82269650301227008', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407633313792', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '81319435670917120', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407637508096', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '117806106536841216', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407645896704', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '76914082455752704', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407654285312', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '76607201262702592', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407658479616', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '80539147005071360', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407666868224', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '39915540965232640', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407671062529', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '41370251991977984', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407675256833', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '41363147411427328', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407683645440', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '41371711400054784', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407687839744', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '39916171171991552', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407692034049', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '39918482854252544', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407700422656', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '41373430515240960', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407704616961', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '41375330996326400', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407713005568', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '42082442672082944', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407721394176', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '41378916912336896', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407725588480', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '63741744973352960', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407729782785', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '41376192166629376', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407738171392', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '41377034236071936', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407742365696', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '56911328312299520', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407746560001', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '63482475359244288', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407750754305', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '64290663792906240', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407759142912', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '66790433014943744', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407763337217', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '42087054753927168', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407771725824', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '102235632889237504', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407775920128', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '102237605176807424', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407784308736', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '102240052523831296', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407788503040', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '103658022701633536', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407792697345', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '67027338952445952', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407801085952', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '67027909637836800', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407805280257', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '67042515441684480', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407813668864', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '67082402312228864', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407817863168', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '113602149589454848', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407826251776', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '113602342657462272', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407830446080', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '113603512293658624', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407834640385', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '113603617897844736', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407843028992', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '16392452747300864', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407847223296', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '16392767785668608', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407855611904', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '16438800255291392', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407859806208', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '16438962738434048', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407864000512', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '16439068543946752', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407872389120', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '175808753877127169', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407876583424', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '175808922710446081', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407884972032', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '127995258721013760', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407889166336', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '127996320085446656', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407893360641', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '160509731956330496', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407901749248', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '160509918166650881', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407905943552', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '128366789653434368', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407910137856', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '128368112335589376', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407914332160', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '128364633437245440', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407922720768', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '127996726786134016', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877407926915072', NULL, '2019-08-19 22:06:23', 0, NULL, '2019-08-19 22:06:23', '127997001756315648', '496138616573953');
INSERT INTO `t_role_permission` VALUES ('175877432572645376', NULL, '2019-08-19 22:06:29', 0, NULL, '2019-08-19 22:06:29', '125909152017944576', '16457350655250432');
INSERT INTO `t_role_permission` VALUES ('175877432576839680', NULL, '2019-08-19 22:06:29', 0, NULL, '2019-08-19 22:06:29', '5129710648430592', '16457350655250432');
INSERT INTO `t_role_permission` VALUES ('175877432581033985', NULL, '2019-08-19 22:06:29', 0, NULL, '2019-08-19 22:06:29', '5129710648430593', '16457350655250432');
INSERT INTO `t_role_permission` VALUES ('175877432585228289', NULL, '2019-08-19 22:06:29', 0, NULL, '2019-08-19 22:06:29', '40238597734928384', '16457350655250432');
INSERT INTO `t_role_permission` VALUES ('175877432589422593', NULL, '2019-08-19 22:06:29', 0, NULL, '2019-08-19 22:06:29', '57009744761589760', '16457350655250432');
INSERT INTO `t_role_permission` VALUES ('175877432593616897', NULL, '2019-08-19 22:06:29', 0, NULL, '2019-08-19 22:06:29', '16392452747300864', '16457350655250432');
INSERT INTO `t_role_permission` VALUES ('175877432602005504', NULL, '2019-08-19 22:06:29', 0, NULL, '2019-08-19 22:06:29', '16392767785668608', '16457350655250432');
INSERT INTO `t_role_permission` VALUES ('175877432606199808', NULL, '2019-08-19 22:06:29', 0, NULL, '2019-08-19 22:06:29', '16439068543946752', '16457350655250432');
INSERT INTO `t_role_permission` VALUES ('175877432610394113', NULL, '2019-08-19 22:06:29', 0, NULL, '2019-08-19 22:06:29', '175808753877127169', '16457350655250432');
INSERT INTO `t_role_permission` VALUES ('175877432614588417', NULL, '2019-08-19 22:06:29', 0, NULL, '2019-08-19 22:06:29', '175808922710446081', '16457350655250432');

-- ----------------------------
-- Table structure for t_sku
-- ----------------------------
DROP TABLE IF EXISTS `t_sku`;
CREATE TABLE `t_sku`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'sku名称',
  `code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'sku编码',
  `price` double(10, 2) NULL DEFAULT NULL COMMENT '价格',
  `spu_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'spuId',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'SKU' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_sku_options
-- ----------------------------
DROP TABLE IF EXISTS `t_sku_options`;
CREATE TABLE `t_sku_options`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sku_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'sku_id',
  `options_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '属性选项id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'sku-属性选项关联' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_sku_specifications_options
-- ----------------------------
DROP TABLE IF EXISTS `t_sku_specifications_options`;
CREATE TABLE `t_sku_specifications_options`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sku_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'sku_id',
  `specification_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '规格选项ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_specifications
-- ----------------------------
DROP TABLE IF EXISTS `t_specifications`;
CREATE TABLE `t_specifications`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `parameter_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参数名称',
  `specific_group_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '规格组',
  `category_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类Id',
  `show_position` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '显示位置',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '规格' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_specifications_group
-- ----------------------------
DROP TABLE IF EXISTS `t_specifications_group`;
CREATE TABLE `t_specifications_group`  (
  `id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '规格组名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '规格组' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_specifications_options
-- ----------------------------
DROP TABLE IF EXISTS `t_specifications_options`;
CREATE TABLE `t_specifications_options`  (
  `id` int(32) NOT NULL,
  `options` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '选项值',
  `specifiction_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '规格id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_spu
-- ----------------------------
DROP TABLE IF EXISTS `t_spu`;
CREATE TABLE `t_spu`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品名称',
  `spu_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'SPU编码',
  ` intro` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '简介',
  `details` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '详解',
  `category_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类id',
  `brand_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '品牌id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'SPU' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `avatar` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mobile` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nick_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  `type` int(11) NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `del_flag` int(11) NULL DEFAULT NULL,
  `department_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `street` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pass_strength` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('16739222421508096', '', '2018-06-06 18:48:02', '', '2018-10-08 00:04:32', '', 'https://s1.ax1x.com/2018/05/19/CcdVQP.png', '', '1012139570@qq.com', '18782059033', '', '$2a$10$PS04ecXfknNd3V8d.ymLTObQciapMU4xU8.GADBZZsuTZr7ymnagy', '男', 0, 0, 'test2', 0, '40652338142121984', '', '弱');
INSERT INTO `t_user` VALUES ('4363087427670016', '', '2018-05-03 15:09:42', '', '2018-10-08 00:04:46', '[\"510000\",\"510100\",\"510114\"]', 'https://s1.ax1x.com/2018/05/19/CcdVQP.png', '', '1012139570@qq.com', '18782059033', '', '$2a$10$PS04ecXfknNd3V8d.ymLTObQciapMU4xU8.GADBZZsuTZr7ymnagy', '男', 0, 0, 'test', 0, '40652338142121984', '', '弱');
INSERT INTO `t_user` VALUES ('682265633886208', '', '2018-05-01 16:13:51', 'admin', '2019-01-19 14:11:43', '[\"510000\",\"510100\",\"510104\"]', 'https://s1.ax1x.com/2018/05/19/CcdVQP.png', 'test', '2549575805@qq.com', '18782059038', 'Exrick', '$2a$10$PS04ecXfknNd3V8d.ymLTObQciapMU4xU8.GADBZZsuTZr7ymnagy', '男', 0, 1, 'admin', 0, '40322777781112832', '天府1街', '弱');
INSERT INTO `t_user` VALUES ('682265633886209', '', '2018-04-30 23:28:42', 'admin', '2019-04-28 22:31:02', '', 'https://s1.ax1x.com/2018/05/19/CcdVQP.png', '', '1012@qq.com', '18782059033', '', '$2a$10$PS04ecXfknNd3V8d.ymLTObQciapMU4xU8.GADBZZsuTZr7ymnagy', '女', -1, 0, 'Exrick', 0, '40322777781112832', '', '弱');

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `del_flag` int(11) NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `role_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES ('134933785559961600', NULL, '2019-04-28 22:31:02', 0, NULL, '2019-04-28 22:31:02', '496138616573953', '682265633886209');
INSERT INTO `t_user_role` VALUES ('134933785576738816', NULL, '2019-04-28 22:31:02', 0, NULL, '2019-04-28 22:31:02', '496138616573952', '682265633886209');
INSERT INTO `t_user_role` VALUES ('61392579396112384', NULL, '2018-10-08 00:04:32', 0, NULL, '2018-10-08 00:04:32', '16457350655250432', '16739222421508096');
INSERT INTO `t_user_role` VALUES ('61392637076180992', NULL, '2018-10-08 00:04:46', 0, NULL, '2018-10-08 00:04:46', '496138616573953', '4363087427670016');
INSERT INTO `t_user_role` VALUES ('98931727094779904', NULL, '2019-01-19 14:11:43', 0, NULL, '2019-01-19 14:11:43', '496138616573952', '682265633886208');

-- ----------------------------
-- Table structure for t_wx_pay_log
-- ----------------------------
DROP TABLE IF EXISTS `t_wx_pay_log`;
CREATE TABLE `t_wx_pay_log`  (
  `id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `order_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `out_trade_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `total_fee` decimal(10, 0) NULL DEFAULT NULL,
  `trade_type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `customer_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  `create_time` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
