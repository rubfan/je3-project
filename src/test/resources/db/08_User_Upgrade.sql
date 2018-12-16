ALTER TABLE `Upgrade` ADD COLUMN `default_number` INT NOT NULL DEFAULT(0);

UPDATE `Upgrade` SET `default_number` =
    CASE `id`
        WHEN 1 THEN 2
        WHEN 2 THEN 3
        WHEN 3 THEN 4
        WHEN 4 THEN 5
        WHEN 5 THEN 6
        WHEN 6 THEN 8
        WHEN 8 THEN 2
        WHEN 22 THEN 2
    END
WHERE `id` < 7 OR `id` = 8 OR `id` = 22;






