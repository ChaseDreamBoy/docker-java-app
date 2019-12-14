CREATE DATABASE IF NOT EXISTS my_db default charset utf8mb4 COLLATE utf8mb4_general_ci;

CREATE TABLE IF NOT EXISTS `my_db`.`test`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NULL DEFAULT NULL COMMENT '名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB ROW_FORMAT = Dynamic;

INSERT INTO `my_db`.`test` VALUES (1, 'docker value test01');
INSERT INTO `my_db`.`test` VALUES (2, 'docker value test02');
INSERT INTO `my_db`.`test` VALUES (3, 'docker value test03');

