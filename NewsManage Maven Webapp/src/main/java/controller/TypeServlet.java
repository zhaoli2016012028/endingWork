package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ArticlesOperation;
import entity.Types;
import utils.UUIDUtils;

/**
* Type Controller
* 进行与类型相关的控制操作
* @author group5
* @version 1.1
*/
@WebServlet("/TypeServlet")
public class TypeServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public TypeServlet() {
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
		doPost(request, response);
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
		switch(flag){
		  case "findType":
			  findType(request,response);
			  break;
		  case "addType":
			  addType(request,response);
			  break;
		  case "delType":
			  delType(request,response);
			  break;
		  case "editType":
			  editType(request,response);
			  break;
		}
	}

	/** 
	 * 修改编辑类型
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	private void editType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		new ArticlesOperation().editType(request.getParameter("tUUID"), request.getParameter("type"));	
		request.getRequestDispatcher("TypeServlet?flag=findType").forward(request,response);
	}

	/** 
	 * 删除类型
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	private void delType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		new ArticlesOperation().delType(request.getParameter("UUID"));
		request.getRequestDispatcher("TypeServlet?flag=findType").forward(request,response);
	}

	/** 
	 * 添加类型
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	private void addType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Types t=new Types();
		t.setUUID(UUIDUtils.getUUID());
		t.setType(request.getParameter("type"));
		new ArticlesOperation().addType(t);
		request.getRequestDispatcher("TypeServlet?flag=findType").forward(request,response);
	}

	/** 
	 * 获取全部类型列表
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	private void findType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Types> tresult=new ArticlesOperation().queryType();
		System.out.println("uuuu");
		request.setAttribute("tresult", tresult);
		request.getRequestDispatcher("manage/tlist.jsp").forward(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}
}
