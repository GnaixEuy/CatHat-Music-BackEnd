package cn.limitless.cathatmusic.vo;

import lombok.Data;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/2/26
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@Data
public class FileUploadVo {

	private String secretId;

	private String secretKey;

	private String sessionToken;

	private String key;

	private String fileId;

	private Long startTime;

	private Long expiredTime;
	
}
