CREATE TABLE IF NOT EXISTS `register1` (
  `account` VARCHAR(20) NOT NULL,
  `pwd` VARCHAR(45) NOT NULL,
  `name` VARCHAR(20) NULL,
  `age` INT NULL,
  `city` VARCHAR(20) NULL,
  `reg_time` DATETIME NULL,
  `role` VARCHAR(20) NULL,
  `active` TINYINT NULL,
  PRIMARY KEY (`account`));