/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

ALTER TABLE `file`
    ADD COLUMN `created_by_user_id` VARCHAR(32) NOT NULL DEFAULT '1' COMMENT '创建者用户ID' AFTER `status` ,
        ADD CONSTRAINT `c_created_by_user_id`
        FOREIGN KEY (`created_by_user_id`) REFERENCES `user`(`id`);

ALTER TABLE `file`
    ADD COLUMN `updated_by_user_id` VARCHAR(32) NOT NULL DEFAULT '1' COMMENT '更新者用户ID' AFTER `created_by_user_id` ,
        ADD CONSTRAINT `c_updated_by_user_id`
        FOREIGN KEY (`updated_by_user_id`) REFERENCES `user`(`id`);