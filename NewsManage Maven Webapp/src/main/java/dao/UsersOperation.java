package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import entity.Users;
import utils.C3p0Con;

/**
* The Users Operation Class
* @author group5
* @version 1.1
*/
public class UsersOperation {	
	/**
	* 数据库连接.
	*/
	Connection conn = C3p0Con.getConnection();//数据库连接
	QueryRunner runner = new QueryRunner();
	
	/**
	* add Users
	* @param u the Users
    * @see SQLException
	*/
	public void addUsers(Users u) {	//增加用户
		try {
			String sql = "INSERT INTO users (UUID,user_name,password,grade) VALUES (?,?,?,?)";
			Object[] params = {u.getUUID(),u.getUser_name(),u.getPassword(),u.getGrade()};
			/*对数据库进行操作*/
			runner.update(conn, sql, params);//此方法有int返回值，可以写成 int r = runner.update(conn, sql, params);接受返回值，可用于测试
//			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			C3p0Con.closeConn(conn); //释放数据库连接
		}
	}
	
	/**
	* add image for one user.
	* @param filename the String
	* @param UUID the String
    * @see SQLException
	*/
	public void addImage(String filename,String UUID) {	//通过用户UUID为用户添加头像
		try {
			String sql = "UPDATE users SET imagePath=? WHERE UUID=?";
			Object[] params = {filename,UUID};
			/*对数据库进行操作*/
			runner.update(conn, sql, params);//此方法有int返回值，可以写成 int r = runner.update(conn, sql, params);接受返回值，可用于测试
//			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			C3p0Con.closeConn(conn);//释放数据库连接
		}
	}
	
	/**
	* update a user's information to add email.
	* @param email the String
	* @param UUID the String
    * @see SQLException
	*/
	public void updateUsers(String email,String UUID) { //通过用户UUID设置用户邮箱
		try {
			String sql = "UPDATE users SET email=? WHERE UUID=?";
			Object[] params = {email,UUID};
			runner.update(conn, sql, params);	//对数据库进行操作
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			C3p0Con.closeConn(conn); //释放数据库连接
		}
	}
	/**
	* get a user's information.
	* @param user_name the String
	* @return users the String
    * @see SQLException
	*/
	public Users getUsers(String user_name) { //根据用户名获取该用户信息
		Users u = null;			
		try {		
			String sql = "SELECT * FROM users WHERE user_name =?";
			Object[] param = {user_name};
			u = runner.query(conn, sql, new BeanHandler<Users>(Users.class),param);//对数据库进行操作
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			C3p0Con.closeConn(conn);//释放数据库连接
		}
		return u;
	}
	
	/**
	* delete a user's information.
	* @param UUID the String
    * @see SQLException
	*/
	public void delUsers(String UUID) {//删除用户信息
		try {
			String sql="DELETE FROM users WHERE UUID=?";		
			runner.update(conn, sql, UUID);	//对数据库进行操作
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			C3p0Con.closeConn(conn); //释放数据库连接
		}
	}
	
	/**
	* find all users' information.
	* @return List Users
    * @see SQLException
	*/
	public List<Users> findAll(){ //获取全部用户信息，用链表类进行保存
		try {
			String sql = "SELECT *FROM users";
			/*对数据库进行操作*/
			List<Users> uresult = runner.query(conn, sql, new BeanListHandler<Users>(Users.class));
			return uresult;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			C3p0Con.closeConn(conn);//释放数据库连接
		}
		return null;
	}
	
}