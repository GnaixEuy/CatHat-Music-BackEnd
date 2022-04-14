/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

ALTER TABLE `artist`
    ADD COLUMN `recommended` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '是否推荐：推荐：1； 不推荐：0；默认：0' AFTER `status`;
ALTER TABLE `artist`
    ADD COLUMN `recommend_factor` INT NOT NULL DEFAULT 0 COMMENT '推荐因数：越高越在上面' AFTER `recommended`;