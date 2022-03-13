package cn.limitless.cathatmusic.dto;

import cn.limitless.cathatmusic.enums.FileStatus;
import cn.limitless.cathatmusic.enums.FileType;
import cn.limitless.cathatmusic.enums.Storage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/2/26
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileDto {

	private String id;

	private String name;

	private String key;

	private String uri;

	private String ext;

	private Long size;

	private FileType type;

	private Storage storage;

	private FileStatus fileStatus;

	private java.util.Date createdTime;

	private Date updatedTime;

}
