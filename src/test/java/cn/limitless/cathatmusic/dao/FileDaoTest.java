package cn.limitless.cathatmusic.dao;

import cn.limitless.cathatmusic.entity.File;
import cn.limitless.cathatmusic.enums.FileStatus;
import cn.limitless.cathatmusic.enums.Storage;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/3/4
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = {@Lazy, @Autowired})
@Transactional
class FileDaoTest {

	private final FileDao fileDao;

	@Test
	void insert() {
		final File file = new File();
		file.setKey("sjaklfjdsklaf");
		file.setFileStatus(FileStatus.CANCEL);
		file.setExt("其他");
		file.setName("测试");
		file.setStorage(Storage.COS);
		file.setSize(333);
		final int result = this.fileDao.insert(file);
		Assertions.assertEquals(result, 1);
	}
}