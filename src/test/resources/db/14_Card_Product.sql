INSERT INTO `Card_Product`
    (id, card_id, card_group_id, p1_set_building_id, p2_set_building_id, p1_set_resource_id, p2_set_resource_id,
    p1_set_upgrade_id, p2_set_upgrade_id, necessary_building_id, necessary_upgrade_id, necessary_building_number,
    necessary_upgrade_number)
VALUES
/*Buildings*/
    (1,1,1,1,null,1,null,null,null,null,null,null,null),
    (2,2,1,2,null,2,null,null,null,null,null,null,null),
    (3,3,1,3,null,3,null,null,null,null,null,null,null),
    (4,4,1,4,null,4,null,null,null,3,null,1,null),
    (5,5,1,5,null,5,null,null,null,3,null,1,null),
    (6,6,1,6,null,6,null,null,null,3,null,1,null),
    (7,7,1,7,null,7,null,null,null,6,null,1,null),
    (8,8,1,8,null,8,null,null,null,7,null,1,null),
    (9,9,1,9,null,9,null,null,null,8,null,1,null),
    (10,10,1,10,null,10,null,null,null,8,null,1,null),
    (11,11,1,11,null,11,null,null,null,6,null,1,null),
    (12,12,1,12,null,12,null,null,null,11,null,1,null),
    (13,13,1,13,null,13,null,null,null,11,null,1,null),
    (14,14,1,14,null,14,null,null,null,6,null,1,null),
    (15,15,1,15,null,15,null,null,null,14,null,1,null),
    (16,16,1,16,null,16,null,null,null,14,null,1,null),
    (17,17,1,17,null,17,null,null,null,6,null,1,null),
    (18,18,1,18,null,18,null,null,null,17,null,1,null),
    (19,19,1,19,null,19,null,null,null,17,null,1,null),
    (20,20,1,20,null,20,null,null,null,5,null,1,null),
    (21,21,1,21,null,21,null,null,null,20,null,1,null),
    (22,22,1,22,null,22,null,null,null,20,null,1,null),
/*Upgrade*/
    (23,23,2,1,null,23,null,1,null,1,null,null,null),
    (24,24,2,1,null,24,null,2,null,1,1,null,null),
    (25,25,2,1,null,25,null,3,null,3,null,null,null);
