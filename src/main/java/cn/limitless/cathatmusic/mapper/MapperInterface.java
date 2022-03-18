package cn.limitless.cathatmusic.mapper;

import cn.limitless.cathatmusic.dto.BaseDto;
import cn.limitless.cathatmusic.entity.BaseEntity;
import org.mapstruct.MappingTarget;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/3/17
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
public interface MapperInterface<Entity extends BaseEntity, Dto extends BaseDto> {
	Dto toDto(Entity entity);

	Entity toEntity(Dto dto);

	Entity updateEntity(@MappingTarget Entity entity, Dto dto);
}
