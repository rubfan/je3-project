
<<<<<<< HEAD
CREATE TABLE `Notification` (
 	`id` INT NOT NULL AUTO_INCREMENT,
  	`name` varchar(64) NOT NULL,
 	`description` varchar(128) NOT NULL,
 	PRIMARY KEY (`id`)
 );

 CREATE TABLE Trigger_Notification (
 	`id` INT NOT NULL AUTO_INCREMENT,
 	`notification_id` INT NOT NULL,
 	`building_id` INT,
 	`resource_id` INT,
 	`upgrade_id` INT,
 	`building_number` FLOAT,
 	`resource_number` FLOAT,
 	`upgrade_number` FLOAT,
 	PRIMARY KEY (`id`)
=======
CREATE TABLE Notification (
 	id INT NOT NULL AUTO_INCREMENT,
  	name varchar(64) NOT NULL,
 	description varchar(128) NOT NULL,
 	PRIMARY KEY (id)
 );

 CREATE TABLE Trigger_Notification (
 	id INT NOT NULL AUTO_INCREMENT,
 	notification_id INT NOT NULL,
 	building_id INT,
 	resource_id INT,
 	upgrade_id INT,
 	building_number FLOAT,
 	resource_number FLOAT,
 	upgrade_number FLOAT,
 	PRIMARY KEY (id)
>>>>>>> 0669dec5e6c84c87b313dfc09f20b4b233761ae5
 );