package cn.limitless.cathatmusic.service.impl;

import cn.limitless.cathatmusic.dao.ArtistDao;
import cn.limitless.cathatmusic.dto.ArtistCreateRequest;
import cn.limitless.cathatmusic.dto.ArtistDto;
import cn.limitless.cathatmusic.dto.ArtistUpdateRequest;
import cn.limitless.cathatmusic.entity.Artist;
import cn.limitless.cathatmusic.entity.TraceableBaseEntity;
import cn.limitless.cathatmusic.enums.ArtistStatus;
import cn.limitless.cathatmusic.exception.BizException;
import cn.limitless.cathatmusic.exception.ExceptionType;
import cn.limitless.cathatmusic.mapper.ArtistMapper;
import cn.limitless.cathatmusic.service.ArtistService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/3/14
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@Service
@Slf4j
@RequiredArgsConstructor(onConstructor_ = {@Lazy, @Autowired})
public class ArtistServiceImpl extends BaseService implements ArtistService {

	private final ArtistMapper mapper;

	private final ArtistDao artistDao;

	@Override
	public ArtistDto create(ArtistCreateRequest artistCreateRequest) {
		Artist artist = mapper.createEntity(artistCreateRequest);
		artist.setStatus(ArtistStatus.DRAFT);
		artist.setCreatedBy(getCurrentUserEntity());
		artist.setUpdatedBy(getCurrentUserEntity());
		final int insertResult = this.artistDao.insert(artist);
		if (insertResult == 1) {
			final Artist resultArtist = this.artistDao.selectOne(Wrappers.<Artist>lambdaQuery()
					.eq(Artist::getName, artist.getName())
					.eq(Artist::getPhoto, artist.getPhoto())
					.eq(Artist::getRemark, artist.getRemark())
					.eq(TraceableBaseEntity::getCreatedBy, getCurrentUserEntity())
					.eq(TraceableBaseEntity::getUpdatedBy, getCurrentUserEntity())
			);
			return mapper.toDto(resultArtist);
		} else {
			throw new BizException(ExceptionType.INNER_ERROR);
		}
	}

	@Override
	public ArtistDto update(String id, ArtistUpdateRequest artistUpdateRequest) {
		final Artist artist = this.artistDao.selectById(id);
		if (artist == null) {
			throw new BizException(ExceptionType.ARTIST_NOT_FOUND);
		}
		Artist updateArtist = mapper.updateEntity(artist, artistUpdateRequest);
		final int updateResult = this.artistDao.updateById(updateArtist);
		if (updateResult == 1) {
			final Artist resultArtist = this.artistDao.selectOne(Wrappers.<Artist>lambdaQuery()
					.eq(Artist::getName, artist.getName())
					.eq(Artist::getPhoto, artist.getPhoto())
					.eq(Artist::getRemark, artist.getRemark())
					.eq(TraceableBaseEntity::getCreatedBy, getCurrentUserEntity())
					.eq(TraceableBaseEntity::getUpdatedBy, getCurrentUserEntity())
			);
			return this.mapper.toDto(resultArtist);
		} else {
			throw new BizException(ExceptionType.INNER_ERROR);
		}
	}

	@Override
	public List<ArtistDto> list() {
		return this.artistDao.selectList(null).stream().map(mapper::toDto).collect(Collectors.toList());
	}
}