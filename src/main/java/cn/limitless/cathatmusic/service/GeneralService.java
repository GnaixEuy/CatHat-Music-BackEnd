package cn.limitless.cathatmusic.service;

import cn.limitless.cathatmusic.dto.BaseDto;
import cn.limitless.cathatmusic.entity.BaseEntity;
import cn.limitless.cathatmusic.exception.ExceptionType;
import cn.limitless.cathatmusic.mapper.MapperInterface;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/3/24
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
public interface GeneralService<Entity extends BaseEntity, Dto extends BaseDto> {
	JpaRepository<Entity, String> getRepository();

	MapperInterface<Entity, Dto> getMapper();

	ExceptionType getNotFoundExceptionType();

	Dto create(Dto dto);

	Dto get(String id);

	Dto update(String id, Dto dto);

	void delete(String id);
}