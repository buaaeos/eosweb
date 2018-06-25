/*
Navicat MySQL Data Transfer

Source Server         : Mysql
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : eos

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-06-25 10:01:52
*/
USE `test`;
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account_name` varchar(20) NOT NULL,
  `head_block_num` int(11) DEFAULT NULL,
  `head_block_time` varchar(20) DEFAULT NULL,
  `privileged` varchar(6) DEFAULT NULL,
  `last_code_update` varchar(20) DEFAULT NULL,
  `created` varchar(20) DEFAULT NULL,
  `ram_quota` float DEFAULT NULL,
  `net_weight` float DEFAULT NULL,
  `cpu_weight` float DEFAULT NULL,
  `net_used` float DEFAULT NULL,
  `net_available` float DEFAULT NULL,
  `net_max` float DEFAULT NULL,
  `cpu_used` float DEFAULT NULL,
  `cpu_available` float DEFAULT NULL,
  `cpu_max` float DEFAULT NULL,
  `ram_usage` float DEFAULT NULL,
  `self_del_from` varchar(20) DEFAULT NULL,
  `self_del_to` varchar(20) DEFAULT NULL,
  `self_del_net` float DEFAULT NULL,
  `self_del_cpu` float DEFAULT NULL,
  `refund_request` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------

-- ----------------------------
-- Table structure for action
-- ----------------------------
DROP TABLE IF EXISTS `action`;
CREATE TABLE `action` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `actor` varchar(20) DEFAULT NULL,
  `permission` varchar(20) DEFAULT NULL,
  `from` varchar(20) DEFAULT NULL,
  `to` varchar(20) DEFAULT NULL,
  `quantity` varchar(255) DEFAULT NULL,
  `memo` text,
  `trx_id` int(11) NOT NULL,
  `hex_data` varchar(500) DEFAULT NULL,
  `account_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `act_trx` (`trx_id`),
  KEY `act_acc` (`account_id`),
  CONSTRAINT `act_acc` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`),
  CONSTRAINT `act_trx` FOREIGN KEY (`trx_id`) REFERENCES `transaction` (`trx_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of action
-- ----------------------------

-- ----------------------------
-- Table structure for block
-- ----------------------------
DROP TABLE IF EXISTS `block`;
CREATE TABLE `block` (
  `blk_id` int(11) NOT NULL AUTO_INCREMENT,
  `id` varchar(255) NOT NULL,
  `timestamp` varchar(20) NOT NULL,
  `previous` varchar(255) DEFAULT NULL,
  `transaction_mroot` varchar(255) DEFAULT NULL,
  `action_mroot` varchar(255) DEFAULT NULL,
  `schedule_version` int(11) DEFAULT NULL,
  `new_producers` varchar(255) DEFAULT NULL,
  `producer_signature` varchar(500) DEFAULT NULL,
  `block_num` int(11) DEFAULT NULL,
  `ref_block_prefix` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`blk_id`),
  KEY `block_num` (`block_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of block
-- ----------------------------

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `perm_name` varchar(20) DEFAULT NULL,
  `parent` varchar(20) DEFAULT NULL,
  `threshold` int(11) DEFAULT NULL,
  `key` varchar(255) DEFAULT NULL,
  `weight` float DEFAULT NULL,
  `accounts` varchar(255) DEFAULT NULL,
  `waits` varchar(255) DEFAULT NULL,
  `account_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `per_acc` (`account_id`),
  CONSTRAINT `per_acc` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------

-- ----------------------------
-- Table structure for transaction
-- ----------------------------
DROP TABLE IF EXISTS `transaction`;
CREATE TABLE `transaction` (
  `trx_id` int(11) NOT NULL AUTO_INCREMENT,
  `id` varchar(255) NOT NULL,
  `compression` varchar(255) DEFAULT NULL,
  `packed_trx` varchar(1000) DEFAULT NULL,
  `expiration` varchar(255) DEFAULT NULL,
  `ref_block_num` int(11) DEFAULT NULL,
  `ref_block_prefix` bigint(20) DEFAULT NULL,
  `max_net_usage_words` int(11) DEFAULT NULL,
  `max_cpu_usage_ms` int(11) DEFAULT NULL,
  `delay_sec` int(11) DEFAULT NULL,
  PRIMARY KEY (`trx_id`),
  KEY `trx_blk` (`ref_block_num`),
  CONSTRAINT `trx_blk` FOREIGN KEY (`ref_block_num`) REFERENCES `block` (`block_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of transaction
-- ----------------------------

-- ----------------------------
-- Table structure for vote_info
-- ----------------------------
DROP TABLE IF EXISTS `vote_info`;
CREATE TABLE `vote_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `owner` varchar(20) DEFAULT NULL,
  `proxy` varchar(255) DEFAULT NULL,
  `producers` varchar(255) DEFAULT NULL,
  `staked` float DEFAULT NULL,
  `last_vote_weight` float DEFAULT NULL,
  `proxied_vote_weight` float DEFAULT NULL,
  `is_proxy` smallint(6) DEFAULT NULL,
  `deferred_trx_id` int(11) DEFAULT NULL,
  `last_unstake_time` varchar(20) DEFAULT NULL,
  `unstaking` varchar(255) DEFAULT NULL,
  `owner_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `vot_acc` (`owner_id`),
  CONSTRAINT `vot_acc` FOREIGN KEY (`owner_id`) REFERENCES `account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vote_info
-- ----------------------------
