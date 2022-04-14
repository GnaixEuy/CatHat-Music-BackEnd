/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package cn.limitless.cathatmusic.entity;

import cn.limitless.cathatmusic.enums.FileStatus;
import cn.limitless.cathatmusic.enums.FileType;
import cn.limitless.cathatmusic.enums.Storage;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/2/26
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@Entity
@Data
public class File extends TraceableBaseEntity {
    private String name;

    @Column(name = "file_key")
    private String key;

    private String ext;

    private Integer size;

    @Enumerated(EnumType.STRING)
    private FileType type;

    @Enumerated(EnumType.STRING)
    private Storage storage;

    @Enumerated(EnumType.STRING)
    private FileStatus status = FileStatus.UPLOADING;
}
