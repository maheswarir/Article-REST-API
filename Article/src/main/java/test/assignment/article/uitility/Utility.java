package test.assignment.article.uitility;

import java.util.Map;

/**
 * 
 * @author Masheswari Rajendran
 * @Date 12/10/2015 create utility methods
 * 
 */
public class Utility {

	/**
	 * check given string contains null value
	 * 
	 * @param data
	 * @return
	 */
	public static boolean isNotNull(String data) {

		if (data == null | data == "") {
			return false;
		} else {
			return true;
		}

	}

	/**
	 * check given Object contains null value
	 * @param data
	 * @return
	 */
	public static boolean isNotNull(Map<String, Object> data) {

		if (data.get("Article") == null | data.get("Article") == "") {
			return false;
		} else {
			return true;
		}

	}
}
