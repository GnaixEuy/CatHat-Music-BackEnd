/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

CREATE TABLE playlist
(
    `id`           VARCHAR(32)                 NOT NULL
        PRIMARY KEY COMMENT '歌单ID',
    `name`         VARCHAR(64)                 NOT NULL COMMENT '歌单名字',
    `description`  TEXT                        NULL COMMENT '歌单简介',
    `cover_id`     VARCHAR(32)                 NULL COMMENT '歌单封面ID',
    `status`       VARCHAR(32) DEFAULT 'DRAFT' NOT NULL COMMENT '歌单上架状态，DRAFT-草稿，PUBLISHED-已上架，CLOSED-已下架',
    `created_time` datetime(6)                 NOT NULL COMMENT '创建时间',
    `updated_time` datetime(6)                 NOT NULL COMMENT '更新时间',
    CONSTRAINT c_cover_id
        FOREIGN KEY (cover_id) REFERENCES `file` (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT '歌单表';