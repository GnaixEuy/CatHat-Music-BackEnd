/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

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
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
public class ArtistServiceImpl extends TraceableGeneralServiceImpl<Artist, ArtistDto> implements ArtistService {

    private ArtistMapper mapper;

    private ArtistRepository repository;

    @Override
    public List<ArtistDto> list() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Page<ArtistDto> search(ArtistSearchFilter artistSearchFilter) {
        ArtistSpecification specs = new ArtistSpecification();
        specs.add(new SearchCriteria("name", artistSearchFilter.getName(), SearchOperation.MATCH));
        if (artistSearchFilter.getRecommended() != null) {
            specs.add(new SearchCriteria("recommended", artistSearchFilter.getRecommended(), SearchOperation.EQUAL));
        }
        return repository.findAll(specs, artistSearchFilter.toPageable()).map(mapper::toDto);
    }

    @Override
    public ArtistDto recommend(String id, Integer recommendFactor) {
        Artist artist = getEntity(id);
        artist.setRecommended(true);
        artist.setRecommendFactor(recommendFactor);
        return mapper.toDto(repository.save(artist));
    }

    @Override
    public ArtistDto cancelRecommendation(String id) {
        Artist artist = getEntity(id);
        artist.setRecommended(false);
        artist.setRecommendFactor(0);
        return mapper.toDto(repository.save(artist));
    }

    @Override
    public JpaRepository<Artist, String> getRepository() {
        return repository;
    }

    @Autowired
    public void setRepository(ArtistRepository repository) {
        this.repository = repository;
    }

    @Override
    public MapperInterface<Artist, ArtistDto> getMapper() {
        return mapper;
    }

    @Autowired
    public void setMapper(ArtistMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public ExceptionType getNotFoundExceptionType() {
        return ExceptionType.ARTIST_NOT_FOUND;
    }
}