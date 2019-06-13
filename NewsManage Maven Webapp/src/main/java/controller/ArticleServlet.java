package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ArticlesOperation;
import dao.Weather;
import entity.Comments;
import entity.Articles;
import entity.Types;
import utils.Abstract;
import utils.Page;
import utils.UUIDUtils;

/**
* Article Controller
* @author group5
* @version 1.1
*/
@WebServlet("/ArticleServlet")
public class ArticleServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ArticleServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String flag=request.getParameter("flag");
		
		if(flag!=null&&!flag.equals("")){
			switch(flag){
			  case "goIndex":
				  goIndex(request,response);
				  break;
			  case "all":
			  	 getManage(request,response);
			  	 break;
			  case "del":
				 delete(request,response);
				 break;
			  case "add":
				 add(request,response);
				 break;
			  case "edit":
				 edit(request,response);
				 break;
			  case "getOne":
				 getOne(request,response);
				 break;	
			  case "addcom":
				  addCom(request,response);
				  break;
			  case "quit":
				  quit(request,response);
				  break;
			  case "addGood":
			  	  addGood(request,response);
			  	  break;
			}		
		}
		else{
			String type=request.getParameter("type");
			String key=request.getParameter("key");
			if(type==null||type.equals("")){
				if(key==null||key.equals("")){
					getManage(request,response);
				}
				else{
					queryKey(request,response,key);
				}
			}
			else{
				if(key==null||key.equals("")){
					queryType(request,response,type);
				}
				else{
					queryTK(request,response,type,key);
				}
			}
		}
		
	}

	/** 
	 * 添加获赞数
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	private void addGood(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nUUID=request.getParameter("nUUID");
		new ArticlesOperation().addGood(nUUID);
    	ArticlesOperation nDao=new ArticlesOperation();
		Articles n=nDao.getArticles(nUUID);	
		request.setAttribute("nUUID", nUUID);
		request.setAttribute("title", n.getTitle());
		request.setAttribute("content", n.getContent());
		request.setAttribute("publishDate", n.getPublishDate());
		request.setAttribute("modifyDate", n.getModifyDate());
		request.setAttribute("author", n.getAuthor());
		request.setAttribute("type", n.getType());		
		List<Comments>cList=nDao.findAll(nUUID);
		request.setAttribute("cList", cList);
		request.setAttribute("viewNum", n.getViewNum());
		request.setAttribute("goodNum", n.getGoodNum());
		request.getRequestDispatcher("details.jsp").forward(request, response);		
	}

	/** 
	 * 退出登录
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	private void quit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.getSession().removeAttribute("user");//清空session信息  
		request.getSession().invalidate();//清除 session 中的所有信息  
		//退出登录的时候清空cookie信息,cookie需要通过HttpServletRequest，HttpServletResponse获取  
		Cookie[] cookie=request.getCookies();  
		for(Cookie c:cookie){  
		    if("autoLogin".equals(c.getName())){  
		        c.setMaxAge(0);  
		        response.addCookie(c);  
		    }  
		}
		
		goIndex(request, response);
	}

	/** 
	 * 添加评论
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	private void addCom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Comments c=new Comments();
		c.setUUID(UUIDUtils.getUUID());
		c.setComments(request.getParameter("comment"));
		String nUU=request.getParameter("nUUID");
		c.setBlog(nUU);
		c.setCommentor((String)request.getSession().getAttribute("uUUID"));
		new ArticlesOperation().addComment(c);	
		
		ArticlesOperation nDao=new ArticlesOperation();
		Articles n=nDao.getArticles(nUU);	
		request.setAttribute("nUUID", nUU);
		request.setAttribute("title", n.getTitle());
		request.setAttribute("content", n.getContent());
		request.setAttribute("publishDate", n.getPublishDate());
		request.setAttribute("modifyDate", n.getModifyDate());
		request.setAttribute("author", n.getAuthor());
		request.setAttribute("type", n.getType());
		request.setAttribute("viewNum", n.getViewNum());
		request.setAttribute("goodNum", n.getGoodNum());
		List<Comments>cList=nDao.findAll(nUU);
		request.setAttribute("cList", cList);
		request.getRequestDispatcher("details.jsp").forward(request, response);
	}

	/** 
	 * 获取首页要展示的信息
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	private static void goIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArticlesOperation nDao = new ArticlesOperation();
		List<Articles> nresult = new ArrayList<Articles>();
		List<Types> tresult=new ArrayList<Types>();
		String current=request.getParameter("currentPage");
		String total=request.getParameter("totalPage");
		//System.out.println("ii:"+total);
		int currentPage=new Page().countPage(current, total);
		int totalPage;
		totalPage=nDao.getTotalPage();
		nresult = nDao.query(currentPage);
		if (nresult!=null) //获取每篇博文的摘要
			for (int i = 0; i < nresult.size(); i++) 
				nresult.get(i).setSub(Abstract.getSubmary(nresult.get(i).getContent()));						
		tresult=nDao.queryType();
		List<Articles>gList=nDao.getGood();
		List<Articles>nList=nDao.getNew();
		//String wea=Weather.getTodayTemperatureInfo();
		//request.getSession().setAttribute("wea", wea);
		request.setAttribute("nresult", nresult);
		request.getSession().setAttribute("tresult", tresult);
		request.getSession().setAttribute("gList", gList);
		request.getSession().setAttribute("nList", nList);
		request.setAttribute("totalPage",totalPage);
		request.setAttribute("currentPage",currentPage);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}
	
	/** 
	 * 进入后台管理页
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	private void getManage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	//	request.getSession().invalidate();
		ArticlesOperation nDao = new ArticlesOperation();
		List<Articles> nresult = new ArrayList<Articles>();
		List<Types> tresult=new ArrayList<Types>();
		String current=request.getParameter("currentPage");
		String total=request.getParameter("totalPage");
		int currentPage=new Page().countPage(current, total);
		int totalPage;		
		
		String name= (String) request.getSession().getAttribute("user_name");
		String in= request.getParameter("index");
		if(name==null||in!=null){
			totalPage=nDao.getTotalPage();
			nresult=nDao.query(currentPage);
			if (nresult!=null) {
				for (int i = 0; i < nresult.size(); i++) {
					nresult.get(i).setSub(Abstract.getSubmary(nresult.get(i).getContent()));
				}
			}		
			tresult=nDao.queryType();
			request.setAttribute("nresult", nresult);
			request.getSession().setAttribute("tresult", tresult);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("totalPage",totalPage);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else{
			String mlist;
			String mlist1=request.getParameter("mlist");
			if (mlist1==null) {
				mlist=(String) request.getSession().getAttribute("mlist");
				
			}
			else {
				mlist=mlist1;
			}
			if(!request.getSession().getAttribute("grade").equals("1")||(mlist!=null&&mlist.equals("y"))){	
				totalPage=nDao.getTotalPage11((String) request.getSession().getAttribute("user_name"));
				nresult = nDao.query1(currentPage,(String) request.getSession().getAttribute("user_name"));
				if(nresult!=null){
					for (int i = 0; i < nresult.size(); i++) {
						nresult.get(i).setSub(Abstract.getSubmary(nresult.get(i).getContent()));
					}
				}
				request.getSession().setAttribute("mlist", mlist);
				request.setAttribute("nresult", nresult);
				request.setAttribute("totalPage",totalPage);
				request.setAttribute("currentPage",currentPage);
				request.getRequestDispatcher("manage/umanage.jsp").forward(request, response);		
			}
			else{
				totalPage=nDao.getTotalPage();
				nresult = nDao.query(currentPage);
				tresult=nDao.queryType();
				request.getSession().setAttribute("mlist", mlist);
				request.setAttribute("nresult", nresult);
				request.getSession().setAttribute("tresult", tresult);
				request.setAttribute("totalPage",totalPage);
				request.setAttribute("currentPage",currentPage);
				request.getRequestDispatcher("manage/amanage.jsp").forward(request, response);
			}
		}
	}
		
	/** 
	 * 删除博文
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String UUID=request.getParameter("UUID");
		ArticlesOperation nDao = new ArticlesOperation();
		nDao.delArticles(UUID);
		response.getWriter().print("<script language='javascript'>alert('操作成功')</script>");
		response.setHeader("refresh", "1;URL=/NewsManage/ArticleServlet?flag=all");
	}
    
	/** 
	 * 添加博文
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		String type=request.getParameter("type");
		String author=(String) request.getSession().getAttribute("user_name");
		Date day=new Date();    
		SimpleDateFormat date= new SimpleDateFormat("yyyy-MM-dd"); 
		String UUID = UUIDUtils.getUUID();
		Articles n=new Articles();
		n.setUUID(UUID);
		n.setAuthor(author);
		n.setContent(content);
		n.setPublishDate(date.format(day));
		n.setTitle(title);
		n.setType(type);
		ArticlesOperation nDao=new ArticlesOperation();
		nDao.addArticles(n);
		response.getWriter().print("<script language='javascript'>alert('操作成功')</script>");
		response.setHeader("refresh", "1;URL=/NewsManage/ArticleServlet?flag=all");
	}
    
	/** 
	 * 编辑博文
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	String title=request.getParameter("title");
		String content=request.getParameter("content");
		String type=request.getParameter("type");
		String UUID=request.getParameter("nUUID");
		Articles n=new Articles();
		n.setUUID(UUID);
		n.setContent(content);
		n.setTitle(title);
		n.setType(type);
		ArticlesOperation nDao=new ArticlesOperation();
		nDao.updateArticles(n);
		response.getWriter().print("<script language='javascript'>alert('操作成功')</script>");
		response.setHeader("refresh", "1;URL=/NewsManage/ArticleServlet?flag=all");
	}
    
	/** 
	 * 获取某篇博文全部信息
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	private void getOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	String UUID=request.getParameter("UUID");
    	ArticlesOperation nDao=new ArticlesOperation();
		String edit=request.getParameter("edit");
		if(edit==null){	
			/*不是进行编辑，则跳转到details页面*/
			nDao.addView(UUID);
			Articles n=nDao.getArticles(UUID);	
			request.setAttribute("nUUID", UUID);
			request.setAttribute("title", n.getTitle());
			request.setAttribute("content", n.getContent());
			request.setAttribute("publishDate", n.getPublishDate());
			request.setAttribute("modifyDate", n.getModifyDate());
			request.setAttribute("author", n.getAuthor());
			request.setAttribute("type", n.getType());		
			List<Comments>cList=nDao.findAll(UUID);
			request.setAttribute("cList", cList);
			request.setAttribute("viewNum", n.getViewNum());
			request.setAttribute("goodNum", n.getGoodNum());
			request.getRequestDispatcher("details.jsp").forward(request, response);
		}
		else {
			/*若进行编辑，则跳转到edit编辑页面*/
			Articles n=nDao.getArticles(UUID);	
			request.setAttribute("nUUID", UUID);
			request.setAttribute("title", n.getTitle());
			request.setAttribute("content", n.getContent());
			request.setAttribute("publishDate", n.getPublishDate());
			request.setAttribute("modifyDate", n.getModifyDate());
			request.setAttribute("author", n.getAuthor());
			request.setAttribute("type", n.getType());		
			request.getRequestDispatcher("manage/edit.jsp").forward(request, response);
		}		
	}
    
	/** 
	 * 通过关键字的查询控制
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @param key string
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	private void queryKey(HttpServletRequest request, HttpServletResponse response,String key) throws ServletException, IOException{
    	ArticlesOperation nDao = new ArticlesOperation();
		List<Articles> nresult = new ArrayList<Articles>();
		String current=request.getParameter("currentPage");
		String total=request.getParameter("totalPage");
		int currentPage=new Page().countPage(current, total);
		int totalPage;
		String name= (String) request.getSession().getAttribute("user_name");
		String in=request.getParameter("index");
		if(name==null||in!=null){
			totalPage=nDao.getTotalPage1(key);
			nresult=nDao.query(key, currentPage);
			if(nresult!=null){
				for (int i = 0; i < nresult.size(); i++) {
					nresult.get(i).setSub(Abstract.getSubmary(nresult.get(i).getContent()));
				}
			}
			request.setAttribute("key", key);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("totalPage",totalPage);
			request.setAttribute("nresult", nresult);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}		
		
		else{
			String mlist=(String) request.getSession().getAttribute("mlist");
			if(!request.getSession().getAttribute("grade").equals("1")||(mlist!=null&&mlist.equals("y"))) {	
				totalPage=nDao.getTotalPage1(key,(String) request.getSession().getAttribute("user_name"));
				nresult=nDao.query(key,(String) request.getSession().getAttribute("user_name"),currentPage);
				if (nresult!=null) {
					for (int i = 0; i < nresult.size(); i++) {
						nresult.get(i).setSub(Abstract.getSubmary(nresult.get(i).getContent()));
					}
				}	
				request.setAttribute("key", key);
				request.setAttribute("currentPage", currentPage);
				request.setAttribute("totalPage",totalPage);
				request.setAttribute("nresult", nresult);
				request.getRequestDispatcher("manage/umanage.jsp").forward(request, response);
			}
			else{
				totalPage=nDao.getTotalPage1(key);
				nresult=nDao.query(key, currentPage);
				request.setAttribute("key", key);
				request.setAttribute("currentPage", currentPage);
				request.setAttribute("totalPage",totalPage);
				request.setAttribute("nresult", nresult);
				request.getRequestDispatcher("manage/amanage.jsp").forward(request, response);
			}
		}	
    }
    
	/** 
	 * 通过类别的查询控制
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @param type string
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
    private void queryType(HttpServletRequest request, HttpServletResponse response,String type) throws ServletException, IOException{
//    	System.out.println("差类别");
    	ArticlesOperation nDao = new ArticlesOperation();
		List<Articles> nresult = new ArrayList<Articles>();
		String current=request.getParameter("currentPage");
		String total=request.getParameter("totalPage");
		int currentPage=new Page().countPage(current, total);
		int totalPage=nDao.getTotalPage(type);
		nresult=nDao.query1(type, currentPage);
		if (nresult!=null) {
			for (int i = 0; i < nresult.size(); i++) {
				nresult.get(i).setSub(Abstract.getSubmary(nresult.get(i).getContent()));
			}
		}		
		request.setAttribute("type", type);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("totalPage",totalPage);
		request.setAttribute("nresult", nresult);
		String name= (String) request.getSession().getAttribute("user_name");
		String in=request.getParameter("index");
		//System.out.println(in.equals("y"));
		if(name==null||in!=null)
			request.getRequestDispatcher("index.jsp").forward(request, response);
		else
		    request.getRequestDispatcher("manage/amanage.jsp").forward(request, response);
    }
    
	/** 
	 * 通过类别和关键字的查询控制
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @param type string
	 * @param key string
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
    private void queryTK(HttpServletRequest request, HttpServletResponse response,String type,String key) throws ServletException, IOException{
    	ArticlesOperation nDao = new ArticlesOperation();
		List<Articles> nresult = new ArrayList<Articles>();
		String current=request.getParameter("currentPage");
		String total=request.getParameter("totalPage");
		int currentPage=new Page().countPage(current, total);
		int totalPage=nDao.getTotalPage(key, type);
		nresult=nDao.query(type, currentPage, key);
		if(nresult!=null){
			for (int i = 0; i < nresult.size(); i++) {
				nresult.get(i).setSub(Abstract.getSubmary(nresult.get(i).getContent()));
			}
		}
		request.setAttribute("type", type);
		request.setAttribute("key", key);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("totalPage",totalPage);
		request.setAttribute("nresult", nresult);
		String name= (String) request.getSession().getAttribute("user_name");
		String in= request.getParameter("index");
		if(name==null||in!=null)		
			request.getRequestDispatcher("index.jsp").forward(request, response);
		else
		    request.getRequestDispatcher("manage/amanage.jsp").forward(request, response);
    }

}
