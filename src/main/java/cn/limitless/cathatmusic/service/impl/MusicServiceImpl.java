package cn.limitless.cathatmusic.service.impl;

import cn.limitless.cathatmusic.dao.MusicDao;
import cn.limitless.cathatmusic.dto.MusicCreateRequest;
import cn.limitless.cathatmusic.dto.MusicDto;
import cn.limitless.cathatmusic.entity.Music;
import cn.limitless.cathatmusic.enums.MusicStatus;
import cn.limitless.cathatmusic.exception.BizException;
import cn.limitless.cathatmusic.exception.ExceptionType;
import cn.limitless.cathatmusic.mapper.MusicMapper;
import cn.limitless.cathatmusic.service.MusicService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
public class MusicServiceImpl extends ServiceImpl<MusicDao, Music> implements MusicService {

	private final MusicDao musicDao;
	private final MusicMapper musicMapper;

	@Autowired
	public MusicServiceImpl(MusicDao musicDao, MusicMapper musicMapper) {
		this.musicDao = musicDao;
		this.musicMapper = musicMapper;
	}

	@Override
	public MusicDto create(MusicCreateRequest musicCreateRequest) {
		log.info("开始保存音乐业务");
		Music music = this.musicMapper.createEntity(musicCreateRequest);
		music.setStatus(MusicStatus.DRAFT);
		log.info("填充状态完成");
		if (this.save(music)) {
			log.info("保存完成");
			final Music resultMusic = getOne(Wrappers.<Music>lambdaQuery().eq(Music::getName, music.getName()).eq(Music::getDescription, music.getDescription()));
			log.info("转换完成");
			return this.musicMapper.toDto(resultMusic);
		} else {
			throw new BizException(ExceptionType.MUSIC_INSERT_ERROR);
		}
	}
}
