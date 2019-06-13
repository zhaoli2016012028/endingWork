package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import utils.C3p0Con;
import entity.Comments;
import entity.Articles;
import entity.Types;

/**
* The Article Operation Class
* @author group5
* @version 1.1
*/
public class ArticlesOperation { 
	/**
	* 定义每页的博文列表展示5条.
	* 数据库连接.
	*/
	private static final int PAGESIZE = 5; //定义每页的博文列表展示5条
	Connection conn = C3p0Con.getConnection();//数据库连接
	QueryRunner runner = new QueryRunner();
	
	/**
	* add articles
	* @param n the Articles
    * @see SQLException
	*/
	public void addArticles(Articles n){//添加博文			
		try {
			String sql = "INSERT INTO articles (UUID,title,content,author,publishDate,type) VALUES (?,?,?,?,?,?)";
			Object[] params = {n.getUUID(),n.getTitle(),n.getContent(),n.getAuthor(),n.getPublishDate(),n.getType()};
			runner.update(conn, sql, params);//此方法有int返回值，可以写成 int r = runner.update(conn, sql, params);接受返回值，可用于测试
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3p0Con.closeConn(conn);
		}
	}
	
	/**
	* add comments
	* @param c the Comments
    * @see SQLException
	*/
	public void addComment(Comments c){	//某用户为某篇博文添加评论
		try {
			String sql = "INSERT INTO commentt (UUID,comments,blog,commentor) VALUES (?,?,?,?)";
			Object[] params = {c.getUUID(),c.getComments(),c.getBlog(),c.getCommentor()};
			runner.update(conn, sql, params);//此方法有int返回值，可以写成 int r = runner.update(conn, sql, params);接受返回值，可用于测试
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3p0Con.closeConn(conn);
		}
	}
	
	/**
	* update Articles
	* @param n the Articles
    * @see SQLException
	*/
	public void updateArticles(Articles n){//更新博文
		try {
			String sql = "UPDATE articles SET title=?,content=?,type=? WHERE UUID=?";
			Object[] params = {n.getTitle(),n.getContent(),n.getType(),n.getUUID()};
			runner.update(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3p0Con.closeConn(conn);
		}
	}
	
	/**
	* get articles
	* @return Articles
	* @param UUID the String
    * @see SQLException
	*/
	public Articles getArticles(String UUID){//根据UUID从数据库获取某篇博文全部内容
		try {
			Articles n = new Articles();
			String sql = "SELECT * FROM articles WHERE UUID =?";
			Object[] param = {UUID};
			n = runner.query(conn, sql, new BeanHandler<Articles>(Articles.class),param);
			return n;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3p0Con.closeConn(conn);
		}
		return null;
	}
	
	/**
	* find all comments in a article.
	* @return List Comments
	* @param blog the String
    * @see SQLException
	*/
	public List<Comments> findAll(String blog) { //获取某篇博文的所有评论信息
		 /*该sql语句查询2个表，用户表（users）评论表（commentt）*/
	    String sql="SELECT commentt.comments,commentt.comdate,users.imagePath,users.user_name FROM commentt,users WHERE commentt.commentor=users.UUID AND commentt.blog=?";
		try {
			List<Comments> cresult = runner.query(conn, sql, new BeanListHandler<Comments>(Comments.class),blog);
			return cresult;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3p0Con.closeConn(conn);
		}
		return null;
	}
	
	/**
	* delete one article.
	* @param UUID the String
    * @see SQLException
	*/
	public void delArticles(String UUID){//根据UUID删除某篇博文
		String sql="DELETE FROM articles WHERE UUID=?";
		try {
			runner.update(conn, sql, UUID);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3p0Con.closeConn(conn);
		}
	}
	
	/**
	* 通过日期倒序查询当前页的博文信息.
	* @return List Articles
	* @param currentPage the integer
    * @see SQLException
	*/
	public List<Articles> query(int currentPage){	//用UUID做主键不用倒序，查出的就是倒序的顺序
		String sql="SELECT articles.viewNum,articles.goodNum,articles.author,articles.content,articles.modifyDate,articles.publishDate,articles.title,articles.type,articles.UUID,users.imagePath FROM articles,users WHERE users.user_name=articles.author ORDER BY publishDate DESC LIMIT ?,?";
		try {
			List<Articles> nresult = runner.query(conn, sql, new BeanListHandler<Articles>(Articles.class),(currentPage-1)*PAGESIZE,PAGESIZE);
			return nresult;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3p0Con.closeConn(conn);
		}
		return null;
	 }
	 
	 /**
	 * 通过日期倒序查询某用户当前页的博文信息.
	 * @return List Articles
	 * @param currentPage the integer
	 * @param author the String
     * @see SQLException
	 */
	 public List<Articles> query1(int currentPage,String author){	
			String sql = "SELECT articles.viewNum,articles.goodNum,articles.author,articles.content,articles.modifyDate,articles.publishDate,articles.title,articles.type,articles.UUID,users.imagePath FROM articles,users"+
						" WHERE users.user_name=articles.author AND author=? ORDER BY publishDate DESC LIMIT ?,?";
			try {
				List<Articles> nresult = runner.query(conn, sql, new BeanListHandler<Articles>(Articles.class),author,(currentPage-1)*PAGESIZE,PAGESIZE);
				return nresult;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				C3p0Con.closeConn(conn);
			}
			return null;
	}
	 
	 /**
	 * 方法重载，通过关键字进行模糊查询，具有分页功能，展示当前页的内容.
	 * @return List Articles
	 * @param key the string
	 * @param currentPage the integer
     * @see SQLException
	 */
	 public List<Articles> query(String key,int currentPage){ 
		StringBuilder sb=new StringBuilder();
		sb.append("SELECT articles.viewNum,articles.goodNum,articles.author,articles.content,articles.modifyDate,articles.publishDate,articles.title,articles.type,articles.UUID,users.imagePath FROM articles,users"+ 
                  " WHERE users.user_name=articles.author AND (articles.title LIKE '%"+key+"%' OR articles.content LIKE '%"+key+"%' OR articles.author LIKE '%"+key+"%' OR articles.publishDate LIKE BINARY '%"+key+"%' OR articles.modifyDate LIKE BINARY '%"+key+"%' OR articles.type LIKE '%"+key+"%') ORDER BY publishDate DESC LIMIT " +(currentPage-1)*PAGESIZE+","+PAGESIZE);
		String sql=sb.toString();
		try {
			List<Articles> nresult = runner.query(conn, sql, new BeanListHandler<Articles>(Articles.class));
			return nresult;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3p0Con.closeConn(conn);
		}
		return null;
	 }
	 
	 /**
	 * 方法重载，普通用户进入后台主页，通过关键字对自己的博文进行查询，模糊查询 .
	 * @return List Articles
	 * @param key the String
	 * @param author the String
	 * @param currentPage the integer
     * @see SQLException
	 */
	 public List<Articles> query(String key,String author,int currentPage){     
		StringBuilder sb=new StringBuilder();
		sb.append("SELECT articles.viewNum,articles.goodNum,articles.author,articles.content,articles.modifyDate,articles.publishDate,articles.title,articles.type,articles.UUID,users.imagePath FROM articles,users"+ 
                  " WHERE users.user_name=articles.author AND author=? AND (title LIKE '%"+key+"%' OR content LIKE '%"+key+"%' OR publishDate LIKE BINARY '%"+key+"%' OR modifyDate LIKE BINARY '%"+key+"%' OR type LIKE '%"+key+"%') ORDER BY publishDate DESC LIMIT "+(currentPage-1)*PAGESIZE+","+PAGESIZE);
		String sql=sb.toString();
		try {
			List<Articles> nresult = runner.query(conn, sql,new BeanListHandler<Articles>(Articles.class),author);
			return nresult;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3p0Con.closeConn(conn);
		}
		return null;
	 }
	
	 /**
	 * 通过类型查询博文 .
	 * @return List Articles
	 * @param type the String
	 * @param currentPage the integer
     * @see SQLException
	 */
	 public List<Articles> query1(String type,int currentPage){   //此方法和上一方法的参数类型和个数相同，故不能构成重载
		String sql = "SELECT articles.viewNum,articles.goodNum,articles.author,articles.content,articles.modifyDate,articles.publishDate,articles.title,articles.type,articles.UUID,users.imagePath FROM articles,users WHERE users.user_name=articles.author AND articles.type=? ORDER BY publishDate DESC LIMIT ?,?";
		try {
			List<Articles> nresult = runner.query(conn, sql, new BeanListHandler<Articles>(Articles.class),type,(currentPage-1)*PAGESIZE,PAGESIZE);
			return nresult;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3p0Con.closeConn(conn);
		}
		return null;
	}
	
	 /**
	 * 在某一类型下，通过关键字查询博文.
	 * @return List Articles
	 * @param type the String
	 * @param currentPage the integer
	 * @param key the String
     * @see SQLException
	 */
	 public List<Articles> query(String type,int currentPage,String key){   
		StringBuilder sb=new StringBuilder();
		sb.append("SELECT articles.viewNum,articles.goodNum,articles.author,articles.content,articles.modifyDate,articles.publishDate,articles.title,articles.type,articles.UUID,users.imagePath FROM articles,users "+
                  "WHERE users.user_name=articles.author AND articles.type=? AND (articles.title LIKE '%"+key+"%' OR articles.content LIKE '%"+key+"%' OR articles.author LIKE '%"+key+"%' OR articles.publishDate LIKE BINARY '%"+key+"%' OR articles.modifyDate LIKE BINARY '%"+key+"%') ORDER BY publishDate DESC LIMIT "+(currentPage-1)*PAGESIZE+","+PAGESIZE);
		String sql=sb.toString();
		try {
			List<Articles> nresult = runner.query(conn, sql, new BeanListHandler<Articles>(Articles.class),type);
			return nresult;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3p0Con.closeConn(conn);
		}
		return null;
	}
	
	 /**
	 * 查询博文总数，进而计算出博文总页数.
	 * @return totalPage
     * @see SQLException
	 */
	 public int getTotalPage(){//
		int totalPage = 0;
		int totalrecords = 0;
		String sql = "SELECT COUNT(*)  FROM articles";		
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ResultSet rs=ptmt.executeQuery();
			if(rs.next()){
				totalrecords = rs.getInt(1);
			}
			totalPage = (totalrecords % PAGESIZE == 0 ? totalrecords / PAGESIZE : totalrecords/PAGESIZE + 1);	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3p0Con.closeConn(conn);
		}
		return totalPage;	
	}
	
	 /**
	 * 查询某类型的博文总数及所占总页数.
	 * @return totalPage
	 * @param type the String
     * @see SQLException
	 */
	public int getTotalPage(String type){//查询某类型的博文总数及所占总页数
		int totalPage = 0;
		int totalrecords = 0;
		String sql = "SELECT COUNT(*)  FROM articles WHERE type = ?";	
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1, type);
			ResultSet rs=ptmt.executeQuery();
			if(rs.next()){
				totalrecords = rs.getInt(1);
			}
			totalPage = (totalrecords % PAGESIZE == 0 ? totalrecords / PAGESIZE : totalrecords/PAGESIZE + 1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3p0Con.closeConn(conn);
		}
		return totalPage;			
	}
	
	 /**
	 * 查询满足关键字的博文总数及所占总页数.
	 * @return totalPage
	 * @param key the String
     * @see SQLException
	 */
	public int getTotalPage1(String key){ //查询满足关键字的博文总数及所占总页数
		int totalPage = 0;
		int totalrecords = 0;
		StringBuilder sb=new StringBuilder();
		sb.append("SELECT COUNT(*)  FROM articles WHERE title LIKE '%"+key+"%' OR content LIKE '%"+key+"%' OR author LIKE '%"+key+"%' OR publishDate LIKE BINARY '%"+key+"%' OR modifyDate LIKE BINARY '%"+key+"%' OR type LIKE '%"+key+"%' ");
		String sql=sb.toString();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ResultSet rs=ptmt.executeQuery();
			if(rs.next()){
				totalrecords = rs.getInt(1);
			}
			totalPage = (totalrecords % PAGESIZE == 0 ? totalrecords / PAGESIZE : totalrecords/PAGESIZE + 1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3p0Con.closeConn(conn);
		}
		return totalPage;			
	}
	
	 /**
	 * 查询某用户的博文总数及所占总页数.
	 * @return totalPage
	 * @param author the String
     * @see SQLException
	 */
	public int getTotalPage11(String author){ //查询某用户的博文总数及所占总页数
		int totalPage = 0;
		int totalrecords = 0;
		String sql = "SELECT COUNT(*)  FROM articles WHERE author=?";		
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1, author);
			ResultSet rs=ptmt.executeQuery();
			if(rs.next()){
				totalrecords = rs.getInt(1);
			}
			totalPage = (totalrecords % PAGESIZE == 0 ? totalrecords / PAGESIZE : totalrecords/PAGESIZE + 1);	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3p0Con.closeConn(conn);
		}
		return totalPage;	
	}
	
	 /**
	 * 查询某用户的博文总数及所占总页数.
	 * @return totalPage
	 * @param key the String
	 * @param type the String
     * @see SQLException
	 */
	public int getTotalPage(String key,String type){ //在某一类型下，满足关键字的博文总数及所占总页数
		int totalPage = 0;
		int totalrecords = 0;
		StringBuilder sb=new StringBuilder();
		sb.append("SELECT COUNT(*)  FROM articles WHERE (title LIKE '%"+key+"%' OR content LIKE '%"+key+"%' OR author LIKE '%"+key+"%' OR publishDate LIKE BINARY '%"+key+"%' OR modifyDate LIKE BINARY '%"+key+"%') AND type=?");
		String sql=sb.toString();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1, type);
			ResultSet rs=ptmt.executeQuery();
			if(rs.next()){
				totalrecords = rs.getInt(1);
			}
			totalPage = (totalrecords % PAGESIZE == 0 ? totalrecords / PAGESIZE : totalrecords/PAGESIZE + 1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3p0Con.closeConn(conn);
		}
		return totalPage;			
	}
	
	 /**
	 * 在某一用户下，满足关键字的博文总数及所占总页数.
	 * @return totalPage
	 * @param key the String
	 * @param author the String
     * @see SQLException
	 */
	public int getTotalPage1(String key,String author){ //在某一用户下，满足关键字的博文总数及所占总页数
		int totalPage = 0;
		int totalrecords = 0;
		StringBuilder sb=new StringBuilder();
		sb.append("SELECT COUNT(*)  FROM articles WHERE (title LIKE '%"+key+"%' OR content LIKE '%"+key+"%' OR type LIKE '%"+key+"%' OR publishDate LIKE BINARY '%"+key+"%'OR modifyDate LIKE BINARY '%"+key+"%') AND author=?");
		String sql=sb.toString();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1, author);
			ResultSet rs=ptmt.executeQuery();
			if(rs.next()){
				totalrecords = rs.getInt(1);
			}
			totalPage = (totalrecords % PAGESIZE == 0 ? totalrecords / PAGESIZE : totalrecords/PAGESIZE + 1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3p0Con.closeConn(conn);
		}
		return totalPage;			
	}
	
	 /**
	 * 查询获得博文全部类型.
	 * @return List Types
     * @see SQLException
	 */
	public List<Types> queryType(){ //查询获得博文全部类型
		String sql="SELECT * FROM types";
		try {
			List<Types> tresult=runner.query(conn, sql,new BeanListHandler<Types>(Types.class));		
//			List tresult = (List) runner.query(conn, sql, new ColumnListHandler());
			return tresult;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3p0Con.closeConn(conn);
		}
		return null;		
	}
	
	 /**
	 * 删除某博文类型.
	 * @param UUID the String
     * @see SQLException
	 */
	public void delType(String UUID){ //删除某博文类型
		String sql="DELETE FROM types WHERE UUID=?";
		try {
			runner.update(conn, sql, UUID);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3p0Con.closeConn(conn);
		}
	}
	
	 /**
	 * 增加博文类型.
	 * @param t the Types
     * @see SQLException
	 */
	public void addType(Types t){ //增加博文类型
		try {
			String sql = "INSERT INTO types (UUID,type) VALUES (?,?)";
			Object[] params = {t.getUUID(),t.getType()};
			runner.update(conn, sql, params);//此方法有int返回值，可以写成 int r = runner.update(conn, sql, params);接受返回值，可用于测试
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3p0Con.closeConn(conn);
		}
	}
	
	 /**
	 * 修改博文类型.
	 * @param UUID the String
	 * @param type the String
     * @see SQLException
	 */
	public void editType(String UUID,String type){ //修改博文类型
		try {
			String sql = "UPDATE types SET type=? WHERE UUID=?";
			Object[] params = {type,UUID};
			runner.update(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3p0Con.closeConn(conn);
		}
	}

	 /**
	 * 对某篇博文记录其浏览量.
	 * @param UUID the String
     * @see SQLException
	 */
	public void addView(String UUID) { //对某篇博文记录其浏览量
		try {
			String sql = "UPDATE articles SET viewNum=viewNum+1 WHERE UUID=?";
			Object[] params = {UUID};
			runner.update(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3p0Con.closeConn(conn);
		}
	}
	
	 /**
	 * 对某篇博文记录其点赞数.
	 * @param UUID the String
     * @see SQLException
	 */
	public void addGood(String UUID) { //对某篇博文记录其点赞数
		try {
			String sql = "UPDATE articles SET goodNum=goodNum+1 WHERE UUID=?";
			Object[] params = {UUID};
			runner.update(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3p0Con.closeConn(conn);
		}
	}
	
	/**
	* 根据获赞数获取top5的博文 .
	* @return List Articles
    * @see SQLException
	*/
	public List<Articles> getGood(){//根据获赞数获取top5的博文 
		try {
			String sql = "SELECT title,UUID FROM articles ORDER BY viewNum DESC LIMIT 5";
			List<Articles> nresult=runner.query(conn, sql,new BeanListHandler<Articles>(Articles.class));	
			return nresult;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3p0Con.closeConn(conn);
		}
		return null;
	}
	
	/**
	* 根据发布日期获取最新发布的5篇的博文  .
	* @return List Articles
    * @see SQLException
	*/
	public List<Articles> getNew(){ //根据发布日期获取最新发布的5篇的博文 
		try {
			String sql = "SELECT title,UUID FROM articles ORDER BY publishDate DESC LIMIT 5";
			List<Articles> nresult=runner.query(conn, sql,new BeanListHandler<Articles>(Articles.class));	
			return nresult;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3p0Con.closeConn(conn);
		}
		return null;
	}
}
