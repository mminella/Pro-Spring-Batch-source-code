SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

USE `spring_batch_test`;

-- -----------------------------------------------------
-- Table `spring_batch_test`.`Account_Summary`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `spring_batch_test`.`Account_Summary` ;

CREATE  TABLE IF NOT EXISTS `spring_batch_test`.`Account_Summary` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `account_number` VARCHAR(10) NOT NULL ,
  `current_balance` DECIMAL(10,2) NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `spring_batch_test`.`Transaction`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `spring_batch_test`.`Transaction` ;

CREATE  TABLE IF NOT EXISTS `spring_batch_test`.`Transaction` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `timestamp` TIMESTAMP NOT NULL ,
  `amount` DECIMAL(8,2) NOT NULL ,
  `account_summary_id` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_Transaction_Account_Summary` (`account_summary_id` ASC) ,
  CONSTRAINT `fk_Transaction_Account_Summary`
    FOREIGN KEY (`account_summary_id` )
    REFERENCES `spring_batch_test`.`Account_Summary` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
