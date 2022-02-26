package cn.limitless.cathatmusic.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/1/24
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@Slf4j
@Component
public class MybatisDateHandler implements MetaObjectHandler {

	@Override
	public void insertFill(MetaObject metaObject) {
		log.info("开始装填");
		this.strictInsertFill(metaObject, "createdTime", Date.class, new Date());
		this.strictInsertFill(metaObject, "updatedTime", Date.class, new Date());
		log.info("结束装填");
	}

	@Override
	public void updateFill(MetaObject metaObject) {
		log.info("开始更新");
		this.strictUpdateFill(metaObject, "updatedTime", Date.class, new Date());
		this.setFieldValByName("updatedTime", new Date(), metaObject);
		log.info("结束更新");
	}
}