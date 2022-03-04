package cn.limitless.cathatmusic.service.impl;

import cn.limitless.cathatmusic.dto.FileUploadDto;
import cn.limitless.cathatmusic.exception.BizException;
import cn.limitless.cathatmusic.exception.ExceptionType;
import cn.limitless.cathatmusic.service.StorageService;
import com.tencent.cloud.CosStsClient;
import com.tencent.cloud.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.TreeMap;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/3/3
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@Service(value = "COS")
public class CosStorageServiceImpl implements StorageService {

	@Value(value = "${cos.bucket}")
	private String bucket;
	@Value(value = "${cos.secret-id}")
	private String secretId;
	@Value(value = "${cos.secret-key}")
	private String secretKey;
	@Value(value = "${cos.region}")
	private String region;

	@Override
	public FileUploadDto initFileUpload() {
		try {
			Long startTime = System.currentTimeMillis();
			Long expiredTime = new Date(startTime + 1800 * 1000).getTime();
			Response response = CosStsClient.getCredential(getCosStsConfig());
			FileUploadDto fileUploadDto = new FileUploadDto();
			fileUploadDto.setBucket(bucket);
			fileUploadDto.setRegion(region);
			fileUploadDto.setSecretId(response.credentials.tmpSecretId);
			fileUploadDto.setSecretKey(response.credentials.tmpSecretKey);
			fileUploadDto.setSessionToken(response.credentials.sessionToken);
//			fileUploadDto.setStartTime(startTime);
//			fileUploadDto.setExpiredTime(expiredTime);
			return fileUploadDto;
		} catch (Exception e) {
			e.printStackTrace();
			throw new BizException(ExceptionType.INNER_ERROR);
		}
	}

	private TreeMap<String, Object> getCosStsConfig() {
		final TreeMap<String, Object> config = new TreeMap<String, Object>();
		config.put("secretId", this.secretId);
		config.put("secretKey", this.secretKey);
		// 临时密钥有效时长，单位是秒
		config.put("durationSeconds", 1800);
		config.put("allowPrefixes", new String[]{
				"*"
		});
		config.put("bucket", bucket);
		config.put("region", region);
		String[] allowActions = new String[]{
				// 简单上传
				"name/cos:PutObject",
				"name/cos:PostObject",
				// 分片上传
				"name/cos:InitiateMultipartUpload",
				"name/cos:ListMultipartUploads",
				"name/cos:ListParts",
				"name/cos:UploadPart",
				"name/cos:CompleteMultipartUpload"
		};
		config.put("allowActions", allowActions);
		return config;
	}
}
