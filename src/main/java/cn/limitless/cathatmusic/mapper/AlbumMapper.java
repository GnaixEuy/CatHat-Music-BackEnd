/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package cn.limitless.cathatmusic.mapper;

import cn.limitless.cathatmusic.dto.AlbumCreateRequest;
import cn.limitless.cathatmusic.dto.AlbumDto;
import cn.limitless.cathatmusic.dto.AlbumUpdateRequest;
import cn.limitless.cathatmusic.entity.Album;
import cn.limitless.cathatmusic.vo.AlbumVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 * <p>
 * 项目： CatHat-Music
 *
 * @author GnaixEuy
 * @date 2022/5/6
 * @see <a href="https://github.com/GnaixEuy"> GnaixEuy的GitHub </a>
 */
@Mapper(componentModel = "spring",
        uses = {FileMapper.class, ArtistMapper.class, MusicMapper.class},
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface AlbumMapper extends MapperInterface<Album, AlbumDto> {

    @Mapping(source = "coverId", target = "cover.id")
    @Mapping(source = "artistIds", target = "artists")
    AlbumDto toDto(AlbumCreateRequest albumCreateRequest);

    @Mapping(source = "coverId", target = "cover.id")
    @Mapping(source = "artistIds", target = "artists")
    AlbumDto toDto(AlbumUpdateRequest albumUpdateRequest);


    AlbumVo toVo(AlbumDto albumDto);
}

