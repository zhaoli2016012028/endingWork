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
    
    <title>用户管理页</title>
    
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
  <!-- 
    <table>
       <c:forEach items="${uresult}" var="uresult">  
    	   <tr>    	   	  	    	 
    	   	 <td>${uresult.user_name}</td>
    	   	 <td>${uresult.grade}</td>
    		 <td><a href ="UserServlet?flag=del&UUID=${uresult.UUID} ">删除</a></td>	    		 
    	   </tr>
       </c:forEach>  	
    </table>
   -->
     
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

    <div  style="margin-top:40px;font-size: 18px" >
      <table width="80%" height="40px" border="0" align="center" cellpadding="3" cellspacing="1" bgcolor="white">
        <tr bgcolor="lightblue">
          <td><div align="center"><strong>姓名</strong></div></td>
          <td><div align="center"><strong>等级</strong></div></td>
          <td><div align="center"><strong>删除</strong></div></td>
        </tr>
        <c:forEach items="${uresult}" var="uresult">  
	        <tr bgcolor="lightpink">
	          <td><div align="center">${uresult.user_name}</div></td>
	          <td><div align="center">${uresult.grade}</div></td>
	          <td><div align="center"><a href ="UserServlet?flag=del&UUID=${uresult.UUID}">删除</a></div></td>
	        </tr>
	    </c:forEach>
      </table>
    </div>
  </div>
</article>

<footer>
  <p>版权所有@2019<a href="/"></a></p>
</footer>

<script src="js/silder.js"></script>
<script src="js/jquery.js"></script>  
  </body>
</html>
