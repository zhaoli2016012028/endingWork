package utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
* The Database Connection Class
* @author group5
* @version 1.1
*/
public class C3p0Con {
	  private static DataSource dataSource=null;    
      static{    
          dataSource=new ComboPooledDataSource("mysql1");    
      }    
          
      /**  
	  * 获取数据库连接  
	  * @return Connection
	  */    
      public static Connection getConnection(){    
          Connection conn=null;    
          try {    
               conn=dataSource.getConnection();    
          } catch (SQLException e) {    
              e.printStackTrace();    
          }    
          return conn;    
      }    
      
      /**  
	  * 获取数据源  
	  * @return dataSource
	  */    
      public static DataSource getDataSource() {  
          return dataSource;  
      }  
      
      /**  
      * 关闭连接，释放资源
      * @param conn the Connection
      */    
      public static void closeConn(Connection conn){    
          try {    
              if(conn!=null && conn.isClosed()){    
                  conn.close();    
              }    
          } catch (SQLException e) {    
              e.printStackTrace();    
          }    
      }    
}
