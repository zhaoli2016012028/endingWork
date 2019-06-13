package utils;

import java.util.UUID;

/**
* The UUID Generation Class
* @author group5
* @version 1.1
*/
public class UUIDUtils {
	/**
	 * 获得一个UUID
	 * @return String UUID
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	/**
	 * 获得指定数目的UUID
	 * @param number integer 需要获得的UUID数量
	 * @return String[] UUID数组
	 */
	public static String[] getUUID(int number) {
		if (number < 1) {
			return null;
		}
		String[] ss = new String[number];
		for (int i = 0; i < number; i++) {
			ss[i] = getUUID();
		}
		return ss;
	}
	
}
