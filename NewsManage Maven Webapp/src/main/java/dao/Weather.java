package dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 描述：爬取网页上的今天的天气
 * @author group5   
 * @version 1.1
 */
public class Weather {
	
	/** 
	 * 发起http get请求获取网页源代码 
	 * @param requestUrl String 请求地址
	 * @return String 该地址返回的html字符串
	 */  
    private static String httpRequest(String requestUrl) {  
        
        StringBuffer buffer = null;  
        BufferedReader bufferedReader = null;
        InputStreamReader inputStreamReader = null;
        InputStream inputStream = null;
        HttpURLConnection httpUrlConn = null;
  
        try {  
            // 建立get请求
            URL url = new URL(requestUrl);  
            httpUrlConn = (HttpURLConnection) url.openConnection();  
            httpUrlConn.setDoInput(true);  
            httpUrlConn.setRequestMethod("GET");  
  
            // 获取输入流  
            inputStream = httpUrlConn.getInputStream();  
            inputStreamReader = new InputStreamReader(inputStream, "utf-8");  
            bufferedReader = new BufferedReader(inputStreamReader);  
  
            // 从输入流读取结果
            buffer = new StringBuffer();  
            String str = null;  
            while ((str = bufferedReader.readLine()) != null) {  
                buffer.append(str);  
            }  
  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  finally {
            // 释放资源
            if(bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(inputStreamReader != null){
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(httpUrlConn != null){
                httpUrlConn.disconnect();  
            }
        }
        return buffer.toString();  
    }  
  
    /** 
     * 过滤掉html字符串中无用的信息
     * @param html String html字符串
     * @return String 有用的数据
     */   
    private static String htmlFiter1(String html) {   	
         
        String b="(.*)(<li class=\"sky skyid lv3 on\">)(.*?)(</li>)(.*)";
        // 取出有用的范围
        Pattern p = Pattern.compile(b);  
        Matcher m = p.matcher(html);
        String s1;
        if(m.find()) {
        	s1=m.group(3);   
        	return s1;
        }                     	
    	else 
    		return null;
    }
    
    /** 
     * 对以上两个方法进行封装。
     * @return String 得到爬取到的结果
     */  
    public static String getTodayTemperatureInfo() {  
        // 调用第一个方法，获取html字符串
        String html = httpRequest("http://www.weather.com.cn/weather/101060101.shtml"); 
        // 调用第二个方法，过滤掉无用的信息
        String result = htmlFiter1(html); 
        //System.out.println("00:"+result);
        return result;  
    } 
    
    public static void main(String args[]) {
    	getTodayTemperatureInfo();
	}
}
