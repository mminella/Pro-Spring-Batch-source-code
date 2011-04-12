-- -----------------------------------------------------
-- Table Customer
-- -----------------------------------------------------
DROP TABLE IF EXISTS Customer ;

CREATE  TABLE Customer (
  id INT NOT NULL AUTO_INCREMENT ,
  firstName VARCHAR(45) NOT NULL ,
  lastName VARCHAR(45) NOT NULL ,
  ssn VARCHAR(9) NOT NULL ,
  address1 VARCHAR(45) NOT NULL ,
  city VARCHAR(45) NOT NULL ,
  state VARCHAR(2) NOT NULL ,
  zip VARCHAR(9) NOT NULL ,
  PRIMARY KEY (id) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table Account
-- -----------------------------------------------------
DROP TABLE IF EXISTS Account ;

CREATE  TABLE Account (
  id INT NOT NULL AUTO_INCREMENT ,
  accountNumber VARCHAR(9) NOT NULL ,
  cashBalance DECIMAL(15,2) NOT NULL ,
  tier INT NULL ,
  Customer_id INT NOT NULL ,
  PRIMARY KEY (id) ,
  INDEX fk_Account_Customer1 (Customer_id ASC) ,
  CONSTRAINT fk_Account_Customer1
    FOREIGN KEY (Customer_id )
    REFERENCES Customer (id )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table Ticker
-- -----------------------------------------------------
DROP TABLE IF EXISTS Ticker ;

CREATE  TABLE Ticker (
  id INT NOT NULL AUTO_INCREMENT ,
  ticker VARCHAR(45) NOT NULL ,
  currentPrice DECIMAL(8,2) NOT NULL ,
  PRIMARY KEY (id) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table Transaction
-- -----------------------------------------------------
DROP TABLE IF EXISTS Transaction ;

CREATE  TABLE Transaction (
  id INT NOT NULL AUTO_INCREMENT ,
  transactionType INT NOT NULL ,
  executedTime DATETIME NOT NULL ,
  dollarAmount DECIMAL(15,2) NOT NULL ,
  qty INT NULL ,
  tickerId INT NOT NULL ,
  Account_id INT NOT NULL ,
  PRIMARY KEY (id) ,
  INDEX fk_Transaction_Ticker (tickerId ASC) ,
  INDEX fk_Transaction_Account1 (Account_id ASC) ,
  CONSTRAINT fk_Transaction_Ticker
    FOREIGN KEY (tickerId )
    REFERENCES Ticker (id )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_Transaction_Account1
    FOREIGN KEY (Account_id )
    REFERENCES Account (id )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
