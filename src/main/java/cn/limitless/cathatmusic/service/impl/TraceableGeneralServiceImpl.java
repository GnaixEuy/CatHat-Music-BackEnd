package cn.limitless.cathatmusic.service.impl;

import cn.limitless.cathatmusic.dto.BaseDto;
import cn.limitless.cathatmusic.entity.TraceableBaseEntity;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/3/24
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
abstract class TraceableGeneralServiceImpl<Entity extends TraceableBaseEntity, Dto extends BaseDto> extends GeneralServiceImpl<Entity, Dto> {
	@Override
	public Dto create(Dto dto) {
		Entity entity = getMapper().toEntity(dto);
		entity.setCreatedBy(getCurrentUserEntity());
		entity.setUpdatedBy(getCurrentUserEntity());
		return getMapper().toDto(getRepository().save(entity));
	}

	@Override
	public Dto update(String id, Dto dto) {
		Entity existedEntity = getEntity(id);
		Entity entity = getMapper().updateEntity(existedEntity, dto);
		entity.setUpdatedBy(getCurrentUserEntity());
		Entity updatedEntity = getRepository().save(entity);
		return getMapper().toDto(updatedEntity);
	}
}
