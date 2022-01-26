package cn.limitless.cathatmusic.exception;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/1/26
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
public class BizException extends RuntimeException {

	private final Integer code;

	public BizException(ExceptionType exceptionType) {
		super(exceptionType.getMessage());
		this.code = exceptionType.getCode();
	}

	public Integer getCode() {
		return code;
	}
}
