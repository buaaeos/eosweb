USE `test`;
ALTER TABLE `action` DROP FOREIGN KEY `trx_id`;
ALTER TABLE `block` DROP FOREIGN KEY `block-trx`;
ALTER TABLE `permission` DROP FOREIGN KEY `account`;
ALTER TABLE `account` DROP FOREIGN KEY `account_action`;
ALTER TABLE `vote_info` DROP FOREIGN KEY `voter_account`;

DROP TABLE `block`;
DROP TABLE `transaction`;
DROP TABLE `action`;
DROP TABLE `account`;
DROP TABLE `permission`;
DROP TABLE `vote_info`;

CREATE TABLE `block` (
  `id` int NOT NULL,
  `blk_id` varchar(255) NOT NULL,
  `timestamp` varchar(20) NOT NULL,
  `previous` varchar(255) NULL,
  `transaction_mroot` varchar(255) NULL,
  `action_mroot` varchar(255) NULL,
  `schedule_version` int NULL,
  `new_producers` varchar(255) NULL,
  `producer_signature` text NULL,
  `block_num` int NULL,
  `ref_block_prefix` decimal NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE `transaction` (
  `id` int NOT NULL,
  `trx_id` varchar(255) NOT NULL,
  `compression` varchar(255) NULL,
  `packed_trx` text NULL,
  `expiration` varchar(255) NULL,
  `ref_block_num` int NULL,
  `ref_block_prefix` varchar(255) NULL,
  `max_net_usage_words` int NULL,
  `max_cpu_usage_ms` int NULL,
  `delay_sec` int NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE `action` (
  `id` varchar(255) NOT NULL,
  `account` varchar(20) NULL,
  `name` varchar(20) NULL,
  `actor` varchar(20) NULL,
  `permission` varchar(20) NULL,
  `from` varchar(20) NULL,
  `to` varchar(20) NULL,
  `quantity` varchar(255) NULL,
  `memo` varchar(255) NULL,
  `trx_id` varchar(255) NOT NULL,
  `hex_data` text NULL,
  `account_id` int NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE `account` (
  `id` int NOT NULL,
  `account_name` varchar(20) NOT NULL,
  `head_block_num` int NULL,
  `head_block_time` varchar(20) NULL,
  `privileged` varchar(6) NULL,
  `last_code_update` varchar(20) NULL,
  `created` varchar(20) NULL,
  `ram_quota` float NULL,
  `net_weight` float NULL,
  `cpu_weight` float NULL,
  `net_used` float NULL,
  `net_available` float NULL,
  `net_max` float NULL,
  `cpu_used` float NULL,
  `cpu_available` float NULL,
  `cpu_max` float NULL,
  `ram_usage` float NULL,
  `self_del_from` varchar(20) NULL,
  `self_del_to` varchar(20) NULL,
  `self_del_net` float NULL,
  `self_del_cpu` float NULL,
  `refund_request` varchar(255) NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE `permission` (
  `id` int NOT NULL,
  `perm_name` varchar(20) NULL,
  `parent` varchar(20) NULL,
  `threshold` int NULL,
  `key` varchar(255) NULL,
  `weight` float NULL,
  `accounts` varchar(255) NULL,
  `waits` varchar(255) NULL,
  `account_id` int NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE `vote_info` (
  `id` int NOT NULL,
  `owner` varchar(20) NULL,
  `proxy` varchar(255) NULL,
  `producers` varchar(255) NULL,
  `staked` float NULL,
  `last_vote_weight` float NULL,
  `proxied_vote_weight` float NULL,
  `is_proxy` smallint NULL,
  `deferred_trx_id` int NULL,
  `last_unstake_time` varchar(20) NULL,
  `unstaking` varchar(255) NULL,
  `owner_id` int NULL,
  PRIMARY KEY (`id`)
);

ALTER TABLE `action` ADD CONSTRAINT `trx_id` FOREIGN KEY (`trx_id`) REFERENCES `transaction` (`id`);
ALTER TABLE `block` ADD CONSTRAINT `block-trx` FOREIGN KEY (`block_num`) REFERENCES `transaction` (`ref_block_num`);
ALTER TABLE `permission` ADD CONSTRAINT `account` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`);
ALTER TABLE `account` ADD CONSTRAINT `account_action` FOREIGN KEY (`id`) REFERENCES `action` (`account_id`);
ALTER TABLE `vote_info` ADD CONSTRAINT `voter_account` FOREIGN KEY (`owner_id`) REFERENCES `account` (`id`);

