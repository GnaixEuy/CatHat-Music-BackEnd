package cn.limitless.cathatmusic.vo;

import cn.limitless.cathatmusic.enums.FileStatus;
import cn.limitless.cathatmusic.enums.FileType;
import cn.limitless.cathatmusic.enums.Storage;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/3/4
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class FileVo extends BaseVo {

	private String name;

	private String key;

	private String uri;

	private Storage storage;

	private String ext;

	private Long size;

	private FileType type;

	private FileStatus status;

}
