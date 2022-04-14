/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

CREATE TABLE music
(
    id           VARCHAR(32)                 NOT NULL
        PRIMARY KEY COMMENT '歌曲ID',
    name         VARCHAR(64)                 NOT NULL COMMENT '歌曲名',
    description  TEXT                        NULL COMMENT '歌曲简介',
    status       VARCHAR(32) DEFAULT 'DRAFT' NOT NULL COMMENT '歌曲上架状态，DRAFT-草稿，PUBLISHED-已上架，CLOSED-已下架',
    created_time datetime(6)                 NOT NULL COMMENT '创建时间',
    updated_time datetime(6)                 NOT NULL COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT '歌曲表';