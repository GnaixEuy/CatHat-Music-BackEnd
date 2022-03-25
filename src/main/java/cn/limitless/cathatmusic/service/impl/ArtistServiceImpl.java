package cn.limitless.cathatmusic.service.impl;

import cn.limitless.cathatmusic.dto.ArtistDto;
import cn.limitless.cathatmusic.dto.ArtistSearchFilter;
import cn.limitless.cathatmusic.entity.Artist;
import cn.limitless.cathatmusic.exception.ExceptionType;
import cn.limitless.cathatmusic.mapper.ArtistMapper;
import cn.limitless.cathatmusic.mapper.MapperInterface;
import cn.limitless.cathatmusic.repository.ArtistRepository;
import cn.limitless.cathatmusic.repository.specs.ArtistSpecification;
import cn.limitless.cathatmusic.repository.specs.SearchCriteria;
import cn.limitless.cathatmusic.repository.specs.SearchOperation;
import cn.limitless.cathatmusic.service.ArtistService;
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
public class ArtistServiceImpl extends TraceableGeneralServiceImpl<Artist, ArtistDto> implements ArtistService {

	private final ArtistMapper mapper;

	private final ArtistRepository repository;

	@Override
	public List<ArtistDto> list() {
		return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
	}

	@Override
	public Page<ArtistDto> search(ArtistSearchFilter artistSearchFilter) {
		ArtistSpecification specs = new ArtistSpecification();
		// Todo: 代码重复需要重构
		specs.add(new SearchCriteria("name", artistSearchFilter.getName(), SearchOperation.MATCH));
		Sort sort = Sort.by(Sort.Direction.DESC, "createdTime");
		Pageable pageable = PageRequest.of(artistSearchFilter.getPage() - 1, artistSearchFilter.getSize(), sort);
		return repository.findAll(specs, pageable).map(mapper::toDto);
	}

	@Override
	public JpaRepository<Artist, String> getRepository() {
		return repository;
	}

	@Override
	public MapperInterface<Artist, ArtistDto> getMapper() {
		return mapper;
	}

	@Override
	public ExceptionType getNotFoundExceptionType() {
		return ExceptionType.ARTIST_NOT_FOUND;
	}
}