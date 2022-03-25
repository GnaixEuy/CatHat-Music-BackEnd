package cn.limitless.cathatmusic.service;

import cn.limitless.cathatmusic.dto.ArtistDto;
import cn.limitless.cathatmusic.dto.ArtistSearchFilter;
import cn.limitless.cathatmusic.entity.Artist;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/3/14
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
public interface ArtistService extends GeneralService<Artist, ArtistDto> {
	List<ArtistDto> list();

	Page<ArtistDto> search(ArtistSearchFilter artistSearchFilter);
}