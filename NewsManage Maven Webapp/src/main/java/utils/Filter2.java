package utils;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class HFilter
 * 为所有跳转到index.jsp的页面添加过滤器
 * @author group5
 * @version 1.1
 */
@WebFilter({"/Filter1","/index.jsp"})
public class Filter2 implements Filter {

    /**
     * Default constructor. 
     */
    public Filter2() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * 如果在页面跳转过程中，无type和key参数，则执行ArticleServlet中goIndex对应的方法，跳转到index页面
	 * @param request the ServletRequest
	 * @param response the ServletResponse
	 * @param chain the FilterChain
	 * @throws IOException if an error occurred
	 * @throws ServletException if an error occurred
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
	    HttpServletResponse res = (HttpServletResponse) response;
	    res.setContentType("text/html");
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
	    String type=req.getParameter("type");
	    String key=req.getParameter("key");
	    if(type==null&&key==null) 
	    	req.getRequestDispatcher("/ArticleServlet?flag=goIndex").forward(req, res);
	   // System.out.println("过滤器2执行");
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
