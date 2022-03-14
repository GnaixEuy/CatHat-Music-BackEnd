package cn.limitless.cathatmusic.dao;

import cn.limitless.cathatmusic.entity.Playlist;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/3/14
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = {@Lazy, @Autowired})
@Transactional
class PlaylistDaoTest {

	private final PlaylistDao playlistDao;

	@Test
	public void selectAll() {
		final List<Playlist> playlists = this.playlistDao.selectList(null);
		Assertions.assertNotNull(playlists);
		playlists.forEach(System.out::println);
	}

}