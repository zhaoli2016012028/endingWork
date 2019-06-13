package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
* The extract string Class
* @author group5
* @version 1.1
*/
public class Abstract {    //去标签的方法
	
	/**
	* 该静态方法用于去标签
	* @param htmlStr
	* @return string
	*/
	private static String removeTag(String htmlStr){
		String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; // script
        String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; // style
        String regEx_html = "<[^>]+>"; // HTML tag
        String regEx_space = "\\s+|\t|\r|\n";// other characters
 
        Pattern p_script = Pattern.compile(regEx_script,Pattern.CASE_INSENSITIVE);
		Matcher m_script = p_script.matcher(htmlStr);
        htmlStr = m_script.replaceAll("");
        Pattern p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
        Matcher m_style = p_style.matcher(htmlStr);
        htmlStr = m_style.replaceAll("");
        Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
        Matcher m_html = p_html.matcher(htmlStr);
        htmlStr = m_html.replaceAll("");
        Pattern p_space = Pattern.compile(regEx_space, Pattern.CASE_INSENSITIVE);
        Matcher m_space = p_space.matcher(htmlStr);
        htmlStr = m_space.replaceAll(" ");
        return htmlStr;
	}
	
	/**
	* 该静态方法提取一段文本的摘要，本方法限制取最多取100个字符
	* @param s the String
	* @return string
	*/
	public static String getSubmary(String s){//提取一段文本的摘要，本方法限制取最多取100个字符
		String s0=Abstract.removeTag(s);
		String s1;
		if (s0.length()<100) {
			s1=s0;
		}
		else{
			s1=s0.substring(0, 100);
		}
		return s1;
	}
}
