SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

USE `statement`;

-- -----------------------------------------------------
-- Table `statement`.`Customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `statement`.`Customer` ;

CREATE  TABLE IF NOT EXISTS `statement`.`Customer` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `firstName` VARCHAR(45) NOT NULL ,
  `lastName` VARCHAR(45) NOT NULL ,
  `ssn` VARCHAR(9) NOT NULL ,
  `address1` VARCHAR(45) NOT NULL ,
  `city` VARCHAR(45) NOT NULL ,
  `state` VARCHAR(2) NOT NULL ,
  `zip` VARCHAR(9) NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `statement`.`Account`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `statement`.`Account` ;

CREATE  TABLE IF NOT EXISTS `statement`.`Account` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `accountNumber` VARCHAR(9) NOT NULL ,
  `cashBalance` DECIMAL(15,2) NOT NULL ,
  `tier` INT NULL ,
  `Customer_id` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_Account_Customer1` (`Customer_id` ASC) ,
  CONSTRAINT `fk_Account_Customer1`
    FOREIGN KEY (`Customer_id` )
    REFERENCES `statement`.`Customer` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `statement`.`Ticker`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `statement`.`Ticker` ;

CREATE  TABLE IF NOT EXISTS `statement`.`Ticker` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `ticker` VARCHAR(45) NOT NULL ,
  `currentPrice` DECIMAL(8,2) NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `statement`.`Transaction`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `statement`.`Transaction` ;

CREATE  TABLE IF NOT EXISTS `statement`.`Transaction` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `transactionType` INT NOT NULL ,
  `executedTime` DATETIME NOT NULL ,
  `dollarAmount` DECIMAL(15,2) NOT NULL ,
  `qty` INT NULL ,
  `tickerId` INT NOT NULL ,
  `Account_id` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_Transaction_Ticker` (`tickerId` ASC) ,
  INDEX `fk_Transaction_Account1` (`Account_id` ASC) ,
  CONSTRAINT `fk_Transaction_Ticker`
    FOREIGN KEY (`tickerId` )
    REFERENCES `statement`.`Ticker` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Transaction_Account1`
    FOREIGN KEY (`Account_id` )
    REFERENCES `statement`.`Account` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
