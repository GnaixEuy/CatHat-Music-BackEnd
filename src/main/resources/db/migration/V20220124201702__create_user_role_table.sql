/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

CREATE TABLE user_role
(
    user_id VARCHAR(32) NOT NULL COMMENT '用户ID',
    role_id VARCHAR(32) NOT NULL COMMENT '角色ID',
    CONSTRAINT c_user_id
        FOREIGN KEY (user_id) REFERENCES user (id),
    CONSTRAINT c_role_id
        FOREIGN KEY (role_id) REFERENCES role (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT '用户角色表';