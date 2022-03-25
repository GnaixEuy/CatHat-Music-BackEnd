package cn.limitless.cathatmusic.repository.specs;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/3/24
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
public enum SearchOperation {
	GREATER_THAN,
	LESS_THAN,
	GREATER_THAN_EQUAL,
	LESS_THAN_EQUAL,
	NOT_EQUAL,
	EQUAL,
	MATCH,
	MATCH_START,
	MATCH_END,
	IN,
	NOT_IN
}
