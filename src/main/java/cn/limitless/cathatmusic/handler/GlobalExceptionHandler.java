package cn.limitless.cathatmusic.handler;

import cn.limitless.cathatmusic.exception.BizException;
import cn.limitless.cathatmusic.exception.ErrorResponse;
import cn.limitless.cathatmusic.exception.ExceptionType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.List;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/1/26
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = BizException.class)
	public ErrorResponse bizExceptionHandler(BizException exception) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setCode(exception.getCode());
		errorResponse.setMessage(exception.getMessage());
		errorResponse.setTrace(exception.getStackTrace());
		return errorResponse;
	}


	@ExceptionHandler(value = Exception.class)
	public ErrorResponse exceptionHandler(Exception exception) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setCode(ExceptionType.INNER_ERROR.getCode());
		errorResponse.setMessage(ExceptionType.INNER_ERROR.getMessage());
		return errorResponse;
	}


	@ExceptionHandler(value = AccessDeniedException.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public ErrorResponse accessDeniedHandler(Exception exception) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setCode(ExceptionType.FORBIDDEN.getCode());
		errorResponse.setMessage(ExceptionType.FORBIDDEN.getMessage());
		return errorResponse;
	}

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public List<ErrorResponse> bizExceptionHandler(MethodArgumentNotValidException e) {

		List<ErrorResponse> errorResponses = new ArrayList<>();
		e.getBindingResult().getAllErrors().forEach((error) -> {
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setCode(ExceptionType.BAD_REQUEST.getCode());
			errorResponse.setMessage(error.getDefaultMessage());
			errorResponses.add(errorResponse);
		});
		return errorResponses;
	}
}