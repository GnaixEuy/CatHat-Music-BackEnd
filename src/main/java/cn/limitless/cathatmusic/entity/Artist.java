package cn.limitless.cathatmusic.entity;

import cn.limitless.cathatmusic.enums.ArtistStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * <img src="https://c-ssl.duitang.com/uploads/blog/202008/30/20200830183701_3ZzSR.thumb.1000_0.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/3/13
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@Data
@Entity
public class Artist extends TraceableBaseEntity {

    private String name;

    private String remark;

    @OneToOne
    private File photo;

    @ManyToMany
    @JoinTable(name = "artist_music", joinColumns = @JoinColumn(name = "artist_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "music_id", referencedColumnName = "id"))
    private List<Music> musicList;

    private ArtistStatus status = ArtistStatus.DRAFT;

    private Boolean recommended = false;

    private Integer recommendFactor = 0;

}
