import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import dao.ArticlesOperation;
import dao.UsersOperation;
import dao.Weather;
import entity.Articles;
import entity.Comments;
import entity.Types;
import entity.Users;
import utils.Abstract;
import utils.C3p0Con;
import utils.Encrypt;
import utils.Page;
import utils.UUIDUtils;

/**
* Test Class
* @author group5
* @version 1.1
*/
public class CommandT {

	/**
	* 测试数据库的连接
	*/
	@Test 
	public void testt() {
		Connection conn = C3p0Con.getConnection();
		C3p0Con.closeConn(conn);
	}
	/**
	* 关于用户的操作
	*/
	@Test 
	public void test() {
		Users users=new Users();
		users.setGrade("2"); //测试用户类方法
		users.setPassword(Encrypt.MD5("zhaol")); //测试密码加密功能
		users.setUser_name("ncud");
		users.setUUID(UUIDUtils.getUUID()); //测试UUID生成功能
		UsersOperation uOperation=new UsersOperation();
		uOperation.addUsers(users); //增加用户
		Users u=uOperation.getUsers("ncud"); //根据用户名获取某用户
		uOperation.delUsers(u.getUUID()); //删除用户
	}
	/**
	* 关于博文的操作
	*/
	@Test 
	public void testIn0(){
		ArticlesOperation aOperation=new ArticlesOperation();
		Articles a=new Articles(); //测试博文类方法
		a.setTitle("hhxx");
		a.setAuthor("admin");
		a.setContent("ertyuiopphgdszxcvbnm,asdfghjkl");
		a.setType("娱乐");
		a.setUUID(UUIDUtils.getUUID());
		Date day=new Date();    
		SimpleDateFormat date= new SimpleDateFormat("yyyy-MM-dd"); 
		a.setPublishDate(date.format(day));
		aOperation.addArticles(a); //增加博文
		aOperation.query("我", "admin", 1);//查询博文，关键字为"我",作者为"admin",查找第1页的内容
	}
	/**
	* 关于类型的操作
	*/
	@Test 
	public void testIn1(){
		ArticlesOperation aOperation=new ArticlesOperation();
		Types t=new Types();
		t.setType("武侠");
		t.setUUID(UUIDUtils.getUUID());
		aOperation.addType(t);//测试增加类型的方法
		aOperation.queryType();//测试查询类型的方法
	}
	/**
	* 关于评论的操作
	*/
	@Test 
	public void testIn2(){
		ArticlesOperation aOperation=new ArticlesOperation();
		Comments c=new Comments(); //测试评论类方法
		c.setBlog("01f053748ea141fc8557420f823cd7bb");
		c.setComments("haohao");
		c.setUUID(UUIDUtils.getUUID());
		c.setCommentor("49514a98caa04548817c24a9aec3c2d1");
		aOperation.addComment(c); //增加评论
	}
	/**
	* 测试摘要提取方法
	*/
	@Test 
	public void testIn3(){
		String htmlStr="<p>选择比努力更重要关于方向的命运的只有几个”。没错其实就是这样。 ..."
				+ "博彩业i我西欧文化霍尔我西欧武侯祠吃的内外国土部女婿维护市场部的黑色版本好的后卫差不多吧</p>";
		String str=Abstract.getSubmary(htmlStr);
		assert(str.length()<100);
	}
	/**
	* 测试计算当前页方法
	*/
	@Test 
	public void testIn4(){
		int p=new Page().countPage("9", "8");
		assert(p==8);
	}
	/**
	* 测试计算当前页方法
	*/
	@Test 
	public void testIn5(){
		Weather.getTodayTemperatureInfo();
	}

}
