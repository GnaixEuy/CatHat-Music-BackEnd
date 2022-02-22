package cn.limitless.cathatmusic.service;

import cn.limitless.cathatmusic.dto.MusicCreateRequest;
import cn.limitless.cathatmusic.dto.MusicDto;
import cn.limitless.cathatmusic.dto.MusicUpdateRequest;
import cn.limitless.cathatmusic.entity.Music;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/2/21
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
public interface MusicService extends IService<Music> {

	MusicDto create(MusicCreateRequest musicCreateRequest);

	MusicDto update(String id, MusicUpdateRequest musicUpdateRequest);
}
