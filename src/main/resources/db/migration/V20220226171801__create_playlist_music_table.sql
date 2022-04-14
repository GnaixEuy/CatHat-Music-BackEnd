/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

CREATE TABLE playlist_music
(
    `playlist_id` VARCHAR(32) NOT NULL COMMENT '歌单ID',
    `music_id`    VARCHAR(32) NOT NULL COMMENT '歌曲ID',
    CONSTRAINT c_playlist_id
        FOREIGN KEY (playlist_id) REFERENCES `playlist` (id),
    CONSTRAINT c_music_id
        FOREIGN KEY (music_id) REFERENCES `music` (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT '歌单歌曲表';