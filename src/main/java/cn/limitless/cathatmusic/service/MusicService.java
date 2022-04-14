/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package cn.limitless.cathatmusic.service;

import cn.limitless.cathatmusic.dto.MusicDto;
import cn.limitless.cathatmusic.dto.MusicSearchFilter;
import cn.limitless.cathatmusic.entity.Music;
import org.springframework.data.domain.Page;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/2/21
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
public interface MusicService extends GeneralService<Music, MusicDto> {

    Page<MusicDto> search(MusicSearchFilter musicSearchRequest);

    void publish(String id);

    void close(String id);
}
