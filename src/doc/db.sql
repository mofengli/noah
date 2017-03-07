-- --------------------------------------------------------
-- 主机:                           139.199.77.251
-- 服务器版本:                        5.7.17-log - MySQL Community Server (GPL)
-- 服务器操作系统:                      linux-glibc2.5
-- HeidiSQL 版本:                  9.3.0.5001
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 noah 的数据库结构
DROP DATABASE IF EXISTS `noah`;
CREATE DATABASE IF NOT EXISTS `noah` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `noah`;


-- 导出  表 noah.customer 结构
DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '客户名称',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户表';

-- 数据导出被取消选择。


-- 导出  表 noah.delivery 结构
DROP TABLE IF EXISTS `delivery`;
CREATE TABLE IF NOT EXISTS `delivery` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `indent_id` bigint(20) NOT NULL COMMENT '订单Id',
  `sender` varchar(50) DEFAULT NULL COMMENT '送货人',
  `receiver` varchar(50) DEFAULT NULL COMMENT '收货人',
  `amount` bigint(20) NOT NULL DEFAULT '0' COMMENT '送货数量',
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='送货详情';

-- 数据导出被取消选择。


-- 导出  表 noah.indent 结构
DROP TABLE IF EXISTS `indent`;
CREATE TABLE IF NOT EXISTS `indent` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `customer_id` bigint(20) NOT NULL COMMENT '客户Id',
  `product_id` bigint(20) NOT NULL COMMENT '产品Id',
  `currency` int(1) NOT NULL DEFAULT '1' COMMENT '币种（1：人民币，2：美元）',
  `sum` bigint(20) NOT NULL DEFAULT '0' COMMENT '订单总金额',
  `amount` bigint(20) NOT NULL DEFAULT '0' COMMENT '订单总数量',
  `status` int(1) NOT NULL DEFAULT '1' COMMENT '订单状态((1:未开始，2：运行中，3：正常结束，4：逾期结束)',
  `start_date` datetime NOT NULL COMMENT '订单开始时间',
  `end_date` datetime NOT NULL COMMENT '订单结束时间',
  `ext` varchar(100) NOT NULL COMMENT '扩展信息',
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '订单创建时间',
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '订单更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';

-- 数据导出被取消选择。


-- 导出  表 noah.product 结构
DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) NOT NULL COMMENT '产品编号',
  `name` varchar(20) NOT NULL COMMENT '产品名称',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品表';

-- 数据导出被取消选择。


-- 导出  表 noah.supplier 结构
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE IF NOT EXISTS `supplier` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '供应商名称',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='供应商表';

-- 数据导出被取消选择。
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
