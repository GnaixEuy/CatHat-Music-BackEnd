/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package cn.limitless.cathatmusic.entity;

import cn.limitless.cathatmusic.enums.GeneralStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 * <p>
 * 项目： CatHat-Music
 *
 * @author GnaixEuy
 * @date 2022/5/6
 * @see <a href="https://github.com/GnaixEuy"> GnaixEuy的GitHub </a>
 */
@Data
@Entity
public class Album extends TraceableBaseEntity {
    private String name;

    private String description;

    private GeneralStatus status;

    private Boolean recommended = false;

    private Integer recommendFactor = 0;

    @OneToOne
    private File cover;

    @ManyToMany
    @JoinTable(name = "album_artist", joinColumns = @JoinColumn(name = "album_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "artist_id", referencedColumnName = "id"))
    private List<Artist> artists;

    @ManyToMany
    @JoinTable(name = "album_music", joinColumns = @JoinColumn(name = "album_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "music_id", referencedColumnName = "id"))
    private List<Music> musicList;
}
