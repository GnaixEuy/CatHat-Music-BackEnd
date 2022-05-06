/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package cn.limitless.cathatmusic.service.impl;

import cn.limitless.cathatmusic.dto.AlbumDto;
import cn.limitless.cathatmusic.dto.AlbumSearchFilter;
import cn.limitless.cathatmusic.entity.Album;
import cn.limitless.cathatmusic.exception.ExceptionType;
import cn.limitless.cathatmusic.mapper.AlbumMapper;
import cn.limitless.cathatmusic.mapper.MapperInterface;
import cn.limitless.cathatmusic.repository.AlbumRepository;
import cn.limitless.cathatmusic.repository.specs.AlbumSpecification;
import cn.limitless.cathatmusic.repository.specs.SearchCriteria;
import cn.limitless.cathatmusic.repository.specs.SearchOperation;
import cn.limitless.cathatmusic.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 * <p>
 * 项目： CatHat-Music
 *
 * @author GnaixEuy
 * @date 2022/5/6
 * @see <a href="https://github.com/GnaixEuy"> GnaixEuy的GitHub </a>
 */
@Service
public class AlbumServiceImpl extends TraceableGeneralServiceImpl<Album, AlbumDto> implements AlbumService {

    private AlbumRepository repository;

    private AlbumMapper mapper;

    @Override
    public Page<AlbumDto> search(AlbumSearchFilter albumSearchFilter) {
        AlbumSpecification specs = new AlbumSpecification();
        specs.add(new SearchCriteria("name", albumSearchFilter.getName(), SearchOperation.MATCH));
        if (albumSearchFilter.getRecommended() != null) {
            specs.add(new SearchCriteria("recommended", albumSearchFilter.getRecommended(), SearchOperation.EQUAL));
        }
        return repository.findAll(specs, albumSearchFilter.toPageable()).map(mapper::toDto);
    }

    @Override
    public AlbumDto recommend(String id, Integer recommendFactor) {
        Album album = getEntity(id);
        album.setRecommended(true);
        album.setRecommendFactor(recommendFactor);
        return mapper.toDto(repository.save(album));
    }

    @Override
    public AlbumDto cancelRecommendation(String id) {
        return null;
    }

    @Override
    public JpaRepository<Album, String> getRepository() {
        return repository;
    }

    @Autowired
    public void setRepository(AlbumRepository repository) {
        this.repository = repository;
    }

    @Override
    public MapperInterface<Album, AlbumDto> getMapper() {
        return mapper;
    }

    @Autowired
    public void setMapper(AlbumMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public ExceptionType getNotFoundExceptionType() {
        return ExceptionType.ALBUM_NOT_FOUND;
    }
}
