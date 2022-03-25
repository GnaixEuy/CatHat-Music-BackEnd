package cn.limitless.cathatmusic.entity;

import cn.limitless.cathatmusic.enums.FileStatus;
import cn.limitless.cathatmusic.enums.FileType;
import cn.limitless.cathatmusic.enums.Storage;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/2/26
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@Entity
@Data
public class File extends TraceableBaseEntity {
	private String name;

	@Column(name = "file_key")
	private String key;

	private String ext;

	private Integer size;

	@Enumerated(EnumType.STRING)
	private FileType type;

	@Enumerated(EnumType.STRING)
	private Storage storage;

	@Enumerated(EnumType.STRING)
	private FileStatus status = FileStatus.UPLOADING;
}
