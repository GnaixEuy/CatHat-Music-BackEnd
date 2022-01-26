package cn.limitless.cathatmusic.utils;

import com.baomidou.mybatisplus.core.incrementer.DefaultIdentifierGenerator;
import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import com.github.ksuid.KsuidGenerator;
import org.springframework.stereotype.Component;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/1/24
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@Component
public class KsuidIdentifierGenerator implements IdentifierGenerator {

	@Override
	public Number nextId(Object entity) {
		return new DefaultIdentifierGenerator().nextId(entity);
	}

	@Override
	@SuppressWarnings(value = {"nls"})
	public String nextUUID(Object entity) {
		return KsuidGenerator.generate();
	}
}
