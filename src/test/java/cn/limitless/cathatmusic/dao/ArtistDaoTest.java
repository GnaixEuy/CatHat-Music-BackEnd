package cn.limitless.cathatmusic.dao;

import cn.limitless.cathatmusic.entity.Artist;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Lazy;

import java.util.List;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/3/18
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = {@Lazy, @Autowired})
class ArtistDaoTest {

	private final ArtistDao artistDao;

	@Test
	public void selectList() {
		final List<Artist> artists = this.artistDao.selectList(null);
		artists.forEach(System.out::println);
	}

}