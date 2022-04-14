/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

CREATE TABLE artist_music
(
    `artist_id` VARCHAR(32) NOT NULL COMMENT '歌手ID',
    `music_id`  VARCHAR(32) NOT NULL COMMENT '歌曲ID',
    CONSTRAINT artist_music_artist_id
        FOREIGN KEY (artist_id) REFERENCES `artist` (id),
    CONSTRAINT artist_music_music_id
        FOREIGN KEY (music_id) REFERENCES `music` (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT '歌手歌曲关联表';