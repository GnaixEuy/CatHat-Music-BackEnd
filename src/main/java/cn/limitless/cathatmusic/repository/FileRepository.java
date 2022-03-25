package cn.limitless.cathatmusic.repository;

import cn.limitless.cathatmusic.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/3/24
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
public interface FileRepository extends JpaRepository<File, String> {
}
