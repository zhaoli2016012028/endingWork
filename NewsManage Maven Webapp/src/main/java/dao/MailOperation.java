package dao;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;

/**
* The Mail Operation Class
* @author group5
* @version 1.1
*/
public class MailOperation implements Runnable {
	/**
	* 收件人邮箱
	* 激活码
	* UUID
	*/ 
    private String email;// 收件人邮箱
    private String code;// 激活码
    private String UUID;
    
	/**
	* 这是一个构造方法，在创建对象时直接进行传参
	* @param email the String
	* @param code the String
	* @param UUID the String
	*/ 
    public MailOperation(String email, String code,String UUID) {
        this.email = email;
        this.code = code;
        this.UUID=UUID;
    }
 
	/**
	* 该方法进行发送邮件.
    * @see Exception
	*/
    public void run() {
        // 1.创建连接对象javax.mail.Session
        // 2.创建邮件对象 javax.mail.Message
        // 3.发送一封激活邮件
        String from = "3475488468@qq.com";// 发件人电子邮箱
        String host = "smtp.qq.com"; // 指定发送邮件的主机smtp.qq.com(QQ)|smtp.163.com(网易)
        Properties properties = System.getProperties();// 获取系统属性
 
        properties.setProperty("mail.smtp.host", host);// 设置邮件服务器
        properties.setProperty("mail.smtp.auth", "true");// 打开认证
 
        try {
            //QQ邮箱需要下面这段代码，163邮箱不需要
            MailSSLSocketFactory sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
            properties.put("mail.smtp.ssl.enable", "true");
            properties.put("mail.smtp.ssl.socketFactory", sf);
 
            // 1.获取默认session对象
            Session session = Session.getInstance(properties, new Authenticator() {
                public PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("3475488468", "jceczeutrljxcgja"); // 发件人邮箱账号、授权码
                }
            });
 
            // 2.创建邮件对象
            Message message = new MimeMessage(session);
            // 2.1设置发件人
            message.setFrom(new InternetAddress(from));
            // 2.2设置接收人
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            // 2.3设置邮件主题
            message.setSubject("账号绑定");
            // 2.4设置邮件内容,用户点击该内容，便将code等参数传递到UserServlet
            String content = "<html><head></head><body><h1>这是一封激活邮件,激活请点击以下</h1><h3><a href='http://localhost:8080/NewsManage/UserServlet?flag=addMail&code="+code+"&uUUID="+UUID+"&email="+email+"'>绑定邮箱"+"</a></h3></body></html>";
            message.setContent(content, "text/html;charset=UTF-8");
            // 3.发送邮件
            Transport.send(message);
            System.out.println("邮件成功发送!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}