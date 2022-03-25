package cn.limitless.cathatmusic.service.impl;

import cn.limitless.cathatmusic.dto.MusicDto;
import cn.limitless.cathatmusic.dto.MusicSearchFilter;
import cn.limitless.cathatmusic.entity.Music;
import cn.limitless.cathatmusic.enums.MusicStatus;
import cn.limitless.cathatmusic.exception.ExceptionType;
import cn.limitless.cathatmusic.mapper.MapperInterface;
import cn.limitless.cathatmusic.mapper.MusicMapper;
import cn.limitless.cathatmusic.repository.MusicRepository;
import cn.limitless.cathatmusic.repository.specs.MusicSpecification;
import cn.limitless.cathatmusic.repository.specs.SearchCriteria;
import cn.limitless.cathatmusic.repository.specs.SearchOperation;
import cn.limitless.cathatmusic.service.MusicService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/2/21
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@Slf4j
@Service
@RequiredArgsConstructor(onConstructor_ = {@Lazy, @Autowired})
public class MusicServiceImpl extends GeneralServiceImpl<Music, MusicDto> implements MusicService {

	private final MusicRepository repository;

	private final MusicMapper mapper;


	@Override
	public Page<MusicDto> search(MusicSearchFilter musicSearchRequest) {
		if (musicSearchRequest == null) {
			musicSearchRequest = new MusicSearchFilter();
		}
		MusicSpecification specs = new MusicSpecification();
		specs.add(new SearchCriteria("name", musicSearchRequest.getName(), SearchOperation.MATCH));
		Sort sort = Sort.by(Sort.Direction.DESC, "createdTime");
		Pageable pageable = PageRequest.of(musicSearchRequest.getPage() - 1, musicSearchRequest.getSize(), sort);
		return repository.findAll(specs, pageable).map(mapper::toDto);
	}

	@Override
	public void publish(String id) {
		Music music = getEntity(id);
		music.setStatus(MusicStatus.PUBLISHED);
		repository.save(music);
	}


	@Override
	public void close(String id) {
		Music music = getEntity(id);
		music.setStatus(MusicStatus.CLOSED);
		repository.save(music);
	}

	@Override
	public JpaRepository<Music, String> getRepository() {
		return repository;
	}

	@Override
	public MapperInterface<Music, MusicDto> getMapper() {
		return mapper;
	}

	@Override
	public ExceptionType getNotFoundExceptionType() {
		return ExceptionType.MUSIC_NOT_FOUND;
	}
}

