package cn.limitless.cathatmusic.service.impl;

import cn.limitless.cathatmusic.dao.MusicDao;
import cn.limitless.cathatmusic.dto.MusicCreateRequest;
import cn.limitless.cathatmusic.dto.MusicDto;
import cn.limitless.cathatmusic.dto.MusicUpdateRequest;
import cn.limitless.cathatmusic.entity.Music;
import cn.limitless.cathatmusic.enums.MusicStatus;
import cn.limitless.cathatmusic.exception.BizException;
import cn.limitless.cathatmusic.exception.ExceptionType;
import cn.limitless.cathatmusic.mapper.MusicMapper;
import cn.limitless.cathatmusic.service.MusicService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
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
public class MusicServiceImpl implements MusicService {

	private final MusicDao musicDao;
	private final MusicMapper musicMapper;

	@Override
	public MusicDto create(MusicCreateRequest musicCreateRequest) {
		log.info("开始保存音乐业务");
		Music music = this.musicMapper.createEntity(musicCreateRequest);
		music.setStatus(MusicStatus.DRAFT);
		log.info("填充状态完成");
		if (this.musicDao.insert(music) == 1) {
			log.info("保存完成");
			final Music resultMusic = this.musicDao.selectOne(Wrappers.<Music>lambdaQuery().eq(Music::getName, music.getName()).eq(Music::getDescription, music.getDescription()));
			log.info("转换完成");
			return this.musicMapper.toDto(resultMusic);
		} else {
			throw new BizException(ExceptionType.MUSIC_INSERT_ERROR);
		}
	}

	@Override
	public MusicDto update(String id, MusicUpdateRequest musicUpdateRequest) {
		final Music oldMusic = this.getMusic(id);
		final Music music = this.musicMapper.updateEntity(oldMusic, musicUpdateRequest);
		final int result = this.musicDao.updateById(music);
		if (result == 1) {
			final Music resultMusic = this.musicDao.selectById(id);
			return this.musicMapper.toDto(resultMusic);
		}
		throw new BizException(ExceptionType.MUSIC_UPDATE_ERROR);
	}

	@Override
	public void publish(String id) {
		this.changeStatus(id, MusicStatus.PUBLISH);
	}

	@Override
	public void close(String id) {
		this.changeStatus(id, MusicStatus.CLOSED);
	}

	private void changeStatus(String id, MusicStatus musicStatus) {
		final Music music = this.getMusic(id);
		music.setStatus(musicStatus);
		final int result = this.musicDao.updateById(music);
		if (result != 1) {
			throw new BizException(ExceptionType.MUSIC_UPDATE_ERROR);
		}
	}


	private Music getMusic(String id) {
		final Music music = this.musicDao.selectById(id);
		if (music == null) {
			throw new BizException(ExceptionType.MUSIC_NOT_FOUND);
		}
		return music;
	}
}
