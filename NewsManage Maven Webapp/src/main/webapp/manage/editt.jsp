<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<base href="<%=basePath%>">
  	
    <title>类型修改页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="css/base.css" rel="stylesheet">
	<link href="css/index.css" rel="stylesheet">
	<link href="css/admin.css" rel="stylesheet">

  </head>
  
 <body>
   <%
  	String type=request.getParameter("type");
  	String UUID=request.getParameter("UUID");
  	request.setAttribute("type", type);
  	request.setAttribute("UUID",UUID );
   %>
  <header>
	  <div id="logo"><a href=""></a></div>
	  <nav class="topnav" id="topnav">
	    <a href="index.jsp">
	      <span>首页</span>
	      <span class="en">Protal</span>
	    </a>
	    <a href="ArticleServlet?flag=all">    
	      <span>返回</span>
	      <span class="en">Admin</span>
	    </a>
	    <a href="ArticleServlet?flag=quit">
	      <span>退出</span>
	      <span class="en">About</span>
	    </a>
	  </nav>
  </header>


	<article>
	  <h2 class="title_tj">
	    <p>欢迎<span>${user_name}</span></p>
	  </h2>
	  <div class="center_first" >   
    <div>
      <table width="100%" height="100%" border="0">
        <tr> 
          <td align="center"><FORM action="TypeServlet?flag=editType" method="POST" name="myform" >
          <table border="0" cellpadding="2" cellspacing="1" bgcolor="lightblue" class="table1">
            <tr>
              <td colspan="2"><div align="center"  style="font-size:20px"><strong>类型更改</strong></div></td>
            </tr>
            <tr>
              <td><input name="type" type="text" value="${type}" ></td>
              <input type="hidden" value="${UUID}" name="tUUID">
            </tr>
            <tr>
              <td colspan=2 align="center"><input type="submit" name="b1" value="更改" class="button"></td>
            </tr>
          </table>
        </FORM></td>
      </tr>
    </table>
    </div>
  </div>
	</article>
	
	<footer>
	  <p>版权所有@2019<a href=""></a></p>
	</footer>
	
	<script src="js/silder.js"></script>
	<script src="js/jquery.js"></script>  
    
  </body>
</html>
