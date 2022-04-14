/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

CREATE TABLE role
(
    id           VARCHAR(32)  NOT NULL
        PRIMARY KEY COMMENT '角色ID',
    name         VARCHAR(128) NULL COMMENT '角色名称',
    title        VARCHAR(128) NULL COMMENT '角色标识',
    created_time datetime(6)  NOT NULL COMMENT '创建时间',
    updated_time datetime(6)  NOT NULL COMMENT '更新时间'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT '角色表';