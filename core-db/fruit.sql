CREATE TABLE `fruit`(
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) DEFAULT NULL,
  `price` INT DEFAULT 0,
  `producing_area` VARCHAR(100),
  `object_version_number` BIGINT(20) DEFAULT '1',
  `request_id` BIGINT(20) DEFAULT '-1',
  `program_id` BIGINT(20) DEFAULT '-1',
  `created_by` BIGINT(20) DEFAULT '-1',
  `creation_date` DATETIME DEFAULT CURRENT_TIMESTAMP ,
  `last_updated_by` BIGINT(20)  DEFAULT '-1',
  `last_update_date` DATETIME DEFAULT CURRENT_TIMESTAMP ,
  `last_update_login` BIGINT(20)  DEFAULT '-1',
  PRIMARY KEY (`id`)
  ) ENGINE=INNODB DEFAULT CHARSET=UTF8;