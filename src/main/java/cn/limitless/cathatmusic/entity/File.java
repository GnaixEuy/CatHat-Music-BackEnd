package cn.limitless.cathatmusic.entity;

import cn.limitless.cathatmusic.enums.FileStatus;
import cn.limitless.cathatmusic.enums.FileType;
import cn.limitless.cathatmusic.enums.Storage;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName(value = "file", resultMap = "fileResultMap")
public class File extends AbstractEntity {

	private String name;

	@TableField(value = "file_key")
	private String key;

	private String ext;

	private Long size;

	private FileType type;

	private Storage storage;

	@TableField(value = "status")
	private FileStatus fileStatus = FileStatus.UPLOADING;
}
