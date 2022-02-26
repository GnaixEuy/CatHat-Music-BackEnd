package cn.limitless.cathatmusic.entity;

import cn.limitless.cathatmusic.enums.FileStatus;
import cn.limitless.cathatmusic.enums.FileType;
import cn.limitless.cathatmusic.enums.Storage;
import lombok.*;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/2/26
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class File extends AbstractEntity {

	private String name;

	private String key;

	private String ext;

	private Integer size;

	private FileType type;

	private Storage storage;

	private FileStatus fileStatus;
}
