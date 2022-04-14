/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package cn.limitless.cathatmusic.vo;

import cn.limitless.cathatmusic.enums.ArtistStatus;
import lombok.*;

import java.util.List;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/3/13
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArtistVo extends BaseVo {
    private String name;

    private String remark;

    private FileVo photo;

    private List<MusicVo> musicDtoList;

    private ArtistStatus status;

    private Boolean recommended;

    private Integer recommendFactor;
}
