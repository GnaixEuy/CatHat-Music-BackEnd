/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package cn.limitless.cathatmusic.service;

import cn.limitless.cathatmusic.dto.AlbumDto;
import cn.limitless.cathatmusic.dto.AlbumSearchFilter;
import cn.limitless.cathatmusic.entity.Album;
import org.springframework.data.domain.Page;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 * <p>
 * 项目： CatHat-Music
 *
 * @author GnaixEuy
 * @date 2022/5/6
 * @see <a href="https://github.com/GnaixEuy"> GnaixEuy的GitHub </a>
 */
public interface AlbumService extends GeneralService<Album, AlbumDto> {
    Page<AlbumDto> search(AlbumSearchFilter albumSearchFilter);

    AlbumDto recommend(String id, Integer recommendFactor);

    AlbumDto cancelRecommendation(String id);
}
