CREATE TABLE `User` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` varchar(16) NOT NULL UNIQUE,
	`password` varchar(16) NOT NULL,
	`token` varchar(128) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Room` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` varchar(64) NOT NULL,
	`description` varchar(128) NOT NULL,
	`user_1_id` INT,
	`user_2_id` INT,
	`start_game_time` DATETIME,
	PRIMARY KEY (`id`)
);

CREATE TABLE `User_Building` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`user_id` INT NOT NULL,
	`building_id` INT NOT NULL,
	`number` FLOAT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `User_Resource` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`user_id` INT NOT NULL,
	`resource_id` INT NOT NULL,
	`number` FLOAT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `User_Upgrade` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`user_id` INT NOT NULL,
	`upgrade_id` INT NOT NULL,
	`number` FLOAT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `User_Achievement` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`user_id` INT NOT NULL,
	`achievement_id` INT NOT NULL,
	`number` FLOAT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Message` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`text` varchar(128) NOT NULL,
	`from_user_id` INT NOT NULL,
	`to_user_id` INT NOT NULL,
	`time` DATETIME NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Notification` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` varchar(64) NOT NULL,
	`description` varchar(128) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Building` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` varchar(64) NOT NULL,
	`description` varchar(128) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Resource` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` varchar(64) NOT NULL,
	`description` varchar(128) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Upgrade` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` varchar(64) NOT NULL,
	`description` varchar(128) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Achievement` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` varchar(64) NOT NULL,
	`description` varchar(128) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Card` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` varchar(64) NOT NULL,
	`description` varchar(128) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Card_Group` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` varchar(64) NOT NULL,
	`description` varchar(128) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Card_Building` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `building_set_id` INT ,
  `building_id` INT NOT NULL,
  `number` FLOAT,
 	PRIMARY KEY (`id`)
);

CREATE TABLE `Card_Resource` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `resource_set_id` INT,
  `resource_id` INT NOT NULL,
  `number` FLOAT,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Card_Upgrade` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `upgrade_set_id` INT,
  `upgrade_id` INT NOT NULL,
  `number` FLOAT,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Card_Product` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`card_id` INT NOT NULL,
	`card_group_id` INT NOT NULL,
	`p1_set_building_id` INT,
	`p2_set_building_id` INT,
	`p1_set_resource_id` INT,
	`p2_set_resource_id` INT,
	`p1_set_upgrade_id` INT,
	`p2_set_upgrade_id` INT,
	`necessary_building_id` INT,
	`necessary_upgrade_id` INT,
	`necessary_building_number` FLOAT,
	`necessary_upgrade_number` FLOAT,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Trigger_Notification` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`notification_id` INT NOT NULL,
	`building_id` INT,
	`resource_id` INT,
	`upgrade_id` INT,
	`building_number` FLOAT,
	`resource_number` FLOAT,
	`upgrade_number` FLOAT,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Upgrade_Product` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`upgrade_id` INT NOT NULL,
	`building_id` INT,
	`resource_id` INT,
	`percent` FLOAT,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Building_Product` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`building_id` INT NOT NULL,
	`resource_id` INT NOT NULL,
	`number_per_sec` FLOAT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Trigger_Achievement` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`achievement_id` INT NOT NULL,
	`building_id` INT,
	`resource_id` INT,
	`upgrade_id` INT,
	`building_number` INT,
	`resource_number` INT,
	`upgrade_number` INT,
	PRIMARY KEY (`id`)
);

CREATE TABLE `User_Notification` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`user_id` INT NOT NULL,
	`notification_id` INT NOT NULL,
	PRIMARY KEY (`id`)
);

ALTER TABLE `User` ADD CONSTRAINT `User_fk0` FOREIGN KEY (`user_id`) REFERENCES `User`(`id`);
ALTER TABLE `User` ADD CONSTRAINT `User_fk1` FOREIGN KEY (`room_id`) REFERENCES `Room`(`id`);

ALTER TABLE `Room` ADD CONSTRAINT `Room_fk0` FOREIGN KEY (`user_1_id`) REFERENCES `User`(`id`);
ALTER TABLE `Room` ADD CONSTRAINT `Room_fk1` FOREIGN KEY (`user_2_id`) REFERENCES `User`(`id`);

ALTER TABLE `User_Building` ADD CONSTRAINT `User_Building_fk0` FOREIGN KEY (`user_id`) REFERENCES `User`(`id`);
ALTER TABLE `User_Building` ADD CONSTRAINT `User_Building_fk1` FOREIGN KEY (`building_id`) REFERENCES `Building`(`id`);

ALTER TABLE `User_Resource` ADD CONSTRAINT `User_Resource_fk0` FOREIGN KEY (`user_id`) REFERENCES `User`(`id`);
ALTER TABLE `User_Resource` ADD CONSTRAINT `User_Resource_fk1` FOREIGN KEY (`resource_id`) REFERENCES `Resource`(`id`);

ALTER TABLE `User_Upgrade` ADD CONSTRAINT `User_Upgrade_fk0` FOREIGN KEY (`user_id`) REFERENCES `User`(`id`);
ALTER TABLE `User_Upgrade` ADD CONSTRAINT `User_Upgrade_fk1` FOREIGN KEY (`upgrade_id`) REFERENCES `Upgrade`(`id`);

ALTER TABLE `User_Achievement` ADD CONSTRAINT `User_Achievement_fk0` FOREIGN KEY (`user_id`) REFERENCES `User`(`id`);
ALTER TABLE `User_Achievement` ADD CONSTRAINT `User_Achievement_fk1` FOREIGN KEY (`achievement_id`) REFERENCES `Achievement`(`id`);

ALTER TABLE `Message` ADD CONSTRAINT `Message_fk0` FOREIGN KEY (`from_user_id`) REFERENCES `User`(`id`);
ALTER TABLE `Message` ADD CONSTRAINT `Message_fk1` FOREIGN KEY (`to_user_id`) REFERENCES `User`(`id`);

ALTER TABLE `Card_Building` ADD CONSTRAINT `Card_Building_fk1` FOREIGN KEY (`building_id`) REFERENCES `Building`(`id`);

ALTER TABLE `Card_Resource` ADD CONSTRAINT `Card_Resource_fk1` FOREIGN KEY (`resource_id`) REFERENCES `Resource`(`id`);

ALTER TABLE `Card_Upgrade` ADD CONSTRAINT `Card_Upgrade_fk1` FOREIGN KEY (`upgrade_id`) REFERENCES `Upgrade`(`id`);

ALTER TABLE `Card_Product` ADD CONSTRAINT `Card_Product_fk0` FOREIGN KEY (`card_id`) REFERENCES `Card`(`id`);
ALTER TABLE `Card_Product` ADD CONSTRAINT `Card_Product_fk1` FOREIGN KEY (`card_group_id`) REFERENCES `Card_Group`(`id`);
ALTER TABLE `Card_Product` ADD CONSTRAINT `Card_Product_fk2` FOREIGN KEY (`p1_set_building_id`) REFERENCES `Card_Building`(`building_st_id`);
ALTER TABLE `Card_Product` ADD CONSTRAINT `Card_Product_fk3` FOREIGN KEY (`p2_set_building_id`) REFERENCES `Card_Building`(`building_st_id`);
ALTER TABLE `Card_Product` ADD CONSTRAINT `Card_Product_fk4` FOREIGN KEY (`p1_set_resource_id`) REFERENCES `Card_Resource`(`resource_st_id`);
ALTER TABLE `Card_Product` ADD CONSTRAINT `Card_Product_fk5` FOREIGN KEY (`p2_set_resource_id`) REFERENCES `Card_Resource`(`resource_st_id`);
ALTER TABLE `Card_Product` ADD CONSTRAINT `Card_Product_fk6` FOREIGN KEY (`p1_set_upgrade_id`) REFERENCES `Card_Upgrade`(`upgrade_st_id`);
ALTER TABLE `Card_Product` ADD CONSTRAINT `Card_Product_fk7` FOREIGN KEY (`p2_set_upgrade_id`) REFERENCES `Card_Upgrade`(`upgrade_st_id`);
ALTER TABLE `Card_Product` ADD CONSTRAINT `Card_Product_fk8` FOREIGN KEY (`necessary_building_id`) REFERENCES `Building`(`building_st_id`);
ALTER TABLE `Card_Product` ADD CONSTRAINT `Card_Product_fk9` FOREIGN KEY (`necessary_upgrade_id`) REFERENCES `Upgrade`(`upgrade_st_id`);

ALTER TABLE `Trigger_Notification` ADD CONSTRAINT `Trigger_Notification_fk0` FOREIGN KEY (`notification_id`) REFERENCES `Notification`(`id`);
ALTER TABLE `Trigger_Notification` ADD CONSTRAINT `Trigger_Notification_fk1` FOREIGN KEY (`building_id`) REFERENCES `Building`(`id`);
ALTER TABLE `Trigger_Notification` ADD CONSTRAINT `Trigger_Notification_fk2` FOREIGN KEY (`resource_id`) REFERENCES `Resource`(`id`);
ALTER TABLE `Trigger_Notification` ADD CONSTRAINT `Trigger_Notification_fk3` FOREIGN KEY (`upgrade_id`) REFERENCES `Upgrade`(`id`);

ALTER TABLE `Upgrade_Product` ADD CONSTRAINT `Upgrade_Product_fk0` FOREIGN KEY (`upgrade_id`) REFERENCES `Upgrade`(`id`);
ALTER TABLE `Upgrade_Product` ADD CONSTRAINT `Upgrade_Product_fk1` FOREIGN KEY (`building_id`) REFERENCES `Building`(`id`);
ALTER TABLE `Upgrade_Product` ADD CONSTRAINT `Upgrade_Product_fk2` FOREIGN KEY (`resource_id`) REFERENCES `Resource`(`id`);

ALTER TABLE `Building_Product` ADD CONSTRAINT `Building_Product_fk0` FOREIGN KEY (`building_id`) REFERENCES `Building`(`id`);
ALTER TABLE `Building_Product` ADD CONSTRAINT `Building_Product_fk1` FOREIGN KEY (`resource_id`) REFERENCES `Resource`(`id`);

ALTER TABLE `Trigger_Achievement` ADD CONSTRAINT `Trigger_Achievement_fk0` FOREIGN KEY (`achievement_id`) REFERENCES `Achievement`(`id`);
ALTER TABLE `Trigger_Achievement` ADD CONSTRAINT `Trigger_Achievement_fk1` FOREIGN KEY (`building_id`) REFERENCES `Building`(`id`);
ALTER TABLE `Trigger_Achievement` ADD CONSTRAINT `Trigger_Achievement_fk2` FOREIGN KEY (`resource_id`) REFERENCES `Resource`(`id`);
ALTER TABLE `Trigger_Achievement` ADD CONSTRAINT `Trigger_Achievement_fk3` FOREIGN KEY (`upgrade_id`) REFERENCES `Upgrade`(`id`);

ALTER TABLE `User_Notification` ADD CONSTRAINT `User_Notification_fk0` FOREIGN KEY (`user_id`) REFERENCES `User`(`id`);
ALTER TABLE `User_Notification` ADD CONSTRAINT `User_Notification_fk1` FOREIGN KEY (`notification_id`) REFERENCES `Notification`(`id`);