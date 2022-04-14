/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package cn.limitless.cathatmusic.mapper;

import cn.limitless.cathatmusic.dto.ArtistCreateRequest;
import cn.limitless.cathatmusic.dto.ArtistDto;
import cn.limitless.cathatmusic.dto.ArtistUpdateRequest;
import cn.limitless.cathatmusic.entity.Artist;
import cn.limitless.cathatmusic.vo.ArtistVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * <img src="https://c-ssl.duitang.com/uploads/blog/202008/30/20200830183701_3ZzSR.thumb.1000_0.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/3/13
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@Mapper(componentModel = "spring", uses = {FileMapper.class, MusicMapper.class}, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ArtistMapper extends MapperInterface<Artist, ArtistDto> {
    @Mapping(source = "photoId", target = "photo.id")
    ArtistDto toDto(ArtistCreateRequest artistCreateRequest);

    ArtistDto toDto(ArtistUpdateRequest artistUpdateRequest);

    ArtistVo toVo(ArtistDto artistDto);
}
