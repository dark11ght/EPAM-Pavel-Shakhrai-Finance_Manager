CREATE TABLE `finance_manager`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `account_id` INT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC));

CREATE TABLE `finance_manager`.`accounts` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `account_name` VARCHAR(45) NOT NULL,
  `balance` DECIMAL NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC));

ALTER TABLE `finance_manager`.`accounts`
ADD INDEX `user_id_idx` (`user_id` ASC);
ALTER TABLE `finance_manager`.`accounts`
ADD CONSTRAINT `user_id`
  FOREIGN KEY (`user_id`)
  REFERENCES `finance_manager`.`users` (`id`)
  ON DELETE CASCADE
  ON UPDATE NO ACTION;

INSERT INTO `finance_manager`.`users` (`id`, `login`, `password`, `account_id`)
 VALUES (1, 'pavel', 'pass', NULL);

INSERT INTO `finance_manager`.`users` (`login`, `password`)
VALUES ('vasya', 'pass123');

INSERT INTO `finance_manager`.`users` (`login`, `password`)
VALUES ('ivan', 'pass123');

INSERT INTO `finance_manager`.`accounts` (`account_name`, `balance`, `user_id`)
VALUES ('pavel_account', 265.75, 1);

INSERT INTO `finance_manager`.`accounts` (`account_name`, `balance`, `user_id`)
VALUES ('pavel_account2', 456.70, 1);

INSERT INTO `finance_manager`.`accounts` (`account_name`, `balance`, `user_id`)
VALUES ('ivan_account', 0.0, 3);