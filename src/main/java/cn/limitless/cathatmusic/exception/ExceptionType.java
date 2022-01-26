package cn.limitless.cathatmusic.exception;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/1/26
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
public enum ExceptionType {

	/**
	 * 枚举业务异常信息
	 */
	INNER_ERROR(500, "系统内部错误"),
	UNAUTHORIZED(401, "未登录"),
	BAD_REQUEST(400, "请求错误"),
	FORBIDDEN(403, "无权操作"),
	NOT_FOUND(404, "未找到"),
	USER_NAME_DUPLICATE(40001001, "用户名重复"),
	USER_NOT_FOUND(40401002, "用户不存在"),
	USER_PASSWORD_NOT_MATCH(40001003, "用户名或密码错误"),
	USER_NOT_ENABLED(50001001, "用户未启用"),
	USER_LOCKED(50001002, "用户被锁定"),
	USER_INSERT_ERROR(40001077, "创建用户信息失败");

	private final Integer code;
	private final String message;


	ExceptionType(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}