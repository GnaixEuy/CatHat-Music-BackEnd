package cn.limitless.cathatmusic.service.impl;

import cn.limitless.cathatmusic.dto.PlaylistDto;
import cn.limitless.cathatmusic.dto.PlaylistSearchFilter;
import cn.limitless.cathatmusic.entity.Playlist;
import cn.limitless.cathatmusic.exception.ExceptionType;
import cn.limitless.cathatmusic.mapper.MapperInterface;
import cn.limitless.cathatmusic.mapper.PlaylistMapper;
import cn.limitless.cathatmusic.repository.PlaylistRepository;
import cn.limitless.cathatmusic.repository.specs.PlaylistSpecification;
import cn.limitless.cathatmusic.repository.specs.SearchCriteria;
import cn.limitless.cathatmusic.repository.specs.SearchOperation;
import cn.limitless.cathatmusic.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/3/12
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */

@Service
public class PlaylistServiceImpl extends TraceableGeneralServiceImpl<Playlist, PlaylistDto> implements PlaylistService {

	private PlaylistRepository repository;

	private PlaylistMapper mapper;

	@Override
	public Page<PlaylistDto> search(PlaylistSearchFilter playlistSearchFilter) {
		PlaylistSpecification specs = new PlaylistSpecification();
		specs.add(new SearchCriteria("name", playlistSearchFilter.getName(), SearchOperation.MATCH));
		if (playlistSearchFilter.getRecommended() != null) {
			specs.add(new SearchCriteria("recommended", playlistSearchFilter.getRecommended(), SearchOperation.EQUAL));
		}
		return repository.findAll(specs, playlistSearchFilter.toPageable()).map(mapper::toDto);
	}

	@Override
	public PlaylistDto recommend(String id, Integer recommendFactor) {
		Playlist playlist = getEntity(id);
		playlist.setRecommended(true);
		playlist.setRecommendFactor(recommendFactor);
		return mapper.toDto(repository.save(playlist));
	}

	@Override
	public PlaylistDto cancelRecommendation(String id) {
		Playlist playlist = getEntity(id);
		playlist.setRecommended(false);
		playlist.setRecommendFactor(0);
		return mapper.toDto(repository.save(playlist));
	}

	@Override
	public PlaylistDto makeSpecial(String id) {
		Playlist playlist = getEntity(id);
		playlist.setSpecial(true);
		return mapper.toDto(repository.save(playlist));
	}

	@Override
	public PlaylistDto cancelSpecial(String id) {
		Playlist playlist = getEntity(id);
		playlist.setSpecial(false);
		return mapper.toDto(repository.save(playlist));
	}

	@Override
	public JpaRepository<Playlist, String> getRepository() {
		return repository;
	}

	@Autowired
	public void setRepository(PlaylistRepository repository) {
		this.repository = repository;
	}

	@Override
	public MapperInterface<Playlist, PlaylistDto> getMapper() {
		return mapper;
	}

	@Autowired
	public void setMapper(PlaylistMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public ExceptionType getNotFoundExceptionType() {
		return ExceptionType.PLAYLIST_NOT_FOUND;
	}
}