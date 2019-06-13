package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dao.MailOperation;
import dao.UsersOperation;
import entity.Users;
//import service.UsersService;
import utils.Encrypt;
import utils.UUIDUtils;

/**
* User Controller
* @author group5
* @version 1.1
*/
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UserServlet() {
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
		
		String flag = request.getParameter("flag");
		switch(flag){ 
		 case"addMail":
			addMail(request,response);
			break;
		 case "login":	
			 login(request,response);
			 break;
		 case "register1":
			 register1(request,response);
			 break;
		 case "register":
			 register(request, response);
			 break;
		 case "findAll":
			 findAll(request,response);
			 break;
		 case "del":
			 delete(request,response);
			 break;
		 case "image":
			 image(request,response);
			 break;
		}
	}
	
	/** 
	 * 邮箱绑定
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	private void addMail(HttpServletRequest request, HttpServletResponse response) throws IOException {
		/*用户在session时间内点击发送到邮箱的信息，接收传来的参数并进行校验*/
		String email=request.getParameter("email");
		String code=request.getParameter("code");
		String c = (String) request.getSession().getAttribute("ccode");
		if(code.equals(c)){
			/*若校验成功，则在数据库中为该用户添加邮箱*/
			new UsersOperation().updateUsers(email, request.getParameter("uUUID"));
			response.getWriter().print("<script language='javascript'>alert('邮箱激活成功')</script>");
			response.setHeader("refresh", "1;URL=/NewsManage/login.jsp");	
		}
		else{
			/*若未校验成功，则告知用户，返回登录页*/
			response.getWriter().print("<script language='javascript'>alert('邮箱未激活成功')</script>");
			response.setHeader("refresh", "1;URL=/NewsManage/login.jsp");	
		}
	}

	/** 
	 * 用户注册
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	private void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String user_name=request.getParameter("user_name");//获取前台传来的用户名参数
		String passwd = request.getParameter("passwd"); //获取前台传来的密码参数
		UsersOperation uDao = new UsersOperation();	
		Users u0 = new Users(); //调用实体类创建一个新的对象
		u0.setUser_name(user_name);
		u0.setPassword(Encrypt.MD5(passwd));
		u0.setGrade("2");
		String uUUID=UUIDUtils.getUUID();
		u0.setUUID(uUUID);
		String code=UUIDUtils.getUUID();
		request.getSession().setAttribute("ccode", code);
		uDao.addUsers(u0);//调用UsersOperation中的方法，像数据库添加该用户信息
		String email=request.getParameter("email");
		if(email!=null&&!email.equals("")){
			/*Email为用户选填项，若其注册了邮箱，调用MailOperation中的方法设置用户邮箱后，返回登录页*/
			MailOperation mailOperation=new MailOperation(email, code,uUUID);
			mailOperation.run();
			response.getWriter().print("<script language='javascript'>alert('前往邮箱激活进行绑定')</script>");
			response.setHeader("refresh", "1;URL=/NewsManage/login.jsp");	
		}
		else {
			/*Email为用户选填项，若其未注册邮箱则直接返回登录页*/
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
	}
	
	/** 
	 * 文件上传，实现上传头像的功能
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	private void image(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {	
		String savePath1 = this.getServletContext().getRealPath("/image");
		System.out.println("ll:"+savePath1);
		File file1 = new File(savePath1);
		// 判断上传文件的保存目录是否存在
		if (!file1.exists() && !file1.isDirectory()) {
			System.out.println(savePath1 + "目录不存在，需要创建");
			// 创建目录
			file1.mkdir();
		}

		try {
			// 使用Apache文件上传组件处理文件上传步骤：
			// 1、创建一个DiskFileItemFactory工厂
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 2、创建一个文件上传解析器
			ServletFileUpload upload = new ServletFileUpload(factory);
			// 解决上传文件名的中文乱码
			upload.setHeaderEncoding("UTF-8");
			// 3、判断提交上来的数据是否是上传表单的数据
			if (!ServletFileUpload.isMultipartContent(request)) {
				// 按照传统方式获取数据
				return;
			}
			// 4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
			List<FileItem> list = upload.parseRequest(request);
			for (FileItem item : list) {
				String filename = item.getName();
	
				if (filename == null || filename.trim().equals("")) {
					continue;
				}
				// 注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如：
				// c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
				// 处理获取到的上传文件的文件名的路径部分，只保留文件名部分
				if (filename.endsWith(".jpg")||filename.endsWith(".png")) {
	
					filename = UUIDUtils.getUUID()+".jpg";
					// 获取item中的上传文件的输入流
					InputStream in = item.getInputStream();
					// 创建一个文件输出流
					FileOutputStream out = new FileOutputStream(savePath1 + "\\" + filename);
					// 创建一个缓冲区
					byte buffer[] = new byte[1024];
					// 判断输入流中的数据是否已经读完的标识
					int len = 0;
					// 循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
					while ((len = in.read(buffer)) > 0) {
						// 使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath +
						// "\\" + filename)当中
						out.write(buffer, 0, len);
					}
					// 关闭输入流
					in.close();
					// 关闭输出流
					out.close();
					// 删除处理文件上传时生成的临时文件
					item.delete();
				}
				new UsersOperation().addImage(filename,(String) request.getSession().getAttribute("uUUID"));
				request.getSession().setAttribute("uimagePath", filename);
				request.getRequestDispatcher("ArticleServlet?flag=all").forward(request,response);
			}
		} catch (Exception e) {
			System.out.println("上传头像失败");
			e.printStackTrace();
		}		
	}

	/**
	 * Initialization of the servlet. <br>
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}
	
	/** 
	 * 进行登录验证
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		/*进行登录验证*/
		String user_name=request.getParameter("user_name");
		String passwd = request.getParameter("passwd");
		Users u = new Users();
	    UsersOperation uDao = new UsersOperation();		
	    u = uDao.getUsers(user_name);
		if(u==null){
			 response.getWriter().print("<script language='javascript'>alert('用户名不存在')</script>");
			 response.setHeader("refresh", "1;URL=/NewsManage/login.jsp");
		}
		else if(Encrypt.MD5(passwd).equals(u.getPassword())){
			request.getSession().setAttribute("grade", u.getGrade());
			request.getSession().setAttribute("user_name", user_name);
			request.getSession().setAttribute("uimagePath", u.getImagePath());
			request.getSession().setAttribute("uUUID", u.getUUID());
			request.getRequestDispatcher("ArticleServlet?flag=goIndex").forward(request, response);     
			 
		}
		else{
			 response.getWriter().print("<script language='javascript'>alert('密码错误')</script>");
			 response.setHeader("refresh", "1;URL=/NewsManage/login.jsp");
		}
	}
	
	/** 
	 * 用户进行注册时进行用户名是否重复的验证，将验证结果传到前台，前台使用ajax进行接收判断，省去页面跳转
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws IOException if an error occurred
	 */
    public void register1(HttpServletRequest request, HttpServletResponse response) throws IOException{
    	/*用户进行注册时进行用户名是否重复的验证，将验证结果传到前台，前台使用ajax进行接收判断，省去页面跳转*/
    	String user_name=request.getParameter("user_name");
		Users u = new Users();
		UsersOperation uDao = new UsersOperation();	
		u=uDao.getUsers(user_name);
		boolean result;
		String s;
		if(u!=null){
			result=false;
			s="账户已经被注册";
		}
		else{
			result=true;
			s="账户可以被注册";
		}
		String s1="{\"result\":\""+result+"\",\"reason\":\""+s+"\"}";
		response.getWriter().write(String.valueOf(s1));
	}
    
	/** 
	 * 通过UUID删除某用户
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws IOException if an error occurred
	 */
    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		/*通过UUID删除某用户*/
    	new UsersOperation().delUsers(request.getParameter("UUID"));
		response.getWriter().print("<script language='javascript'>alert('删除成功')</script>");
		response.setHeader("refresh", "1;URL=/NewsManage/UserServlet?flag=findAll");
	}

	/** 
	 * 获得全部用户信息
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*获得全部用户信息*/
    	List<Users>uresult=new UsersOperation().findAll();
		request.setAttribute("uresult", uresult);
		request.getRequestDispatcher("manage/users.jsp").forward(request,response);
	}
}
