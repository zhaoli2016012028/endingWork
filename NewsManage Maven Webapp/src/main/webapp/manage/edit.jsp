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
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>修改博客</title>
	<script type="text/javascript" src="ueditor/ueditor.config.js"></script>
	<script type="text/javascript" src="ueditor/ueditor.all.js"></script>
	<script type="text/javascript" src="js/jquery.js"></script>
  </head>
  
  <body>
	<div>
	<form action="ArticleServlet?flag=edit" method="post">
	<div style="text-align: center;">
		 文章题目：<input type="text" name="title" value="${title}"/>
		 <input type="hidden" name="nUUID" value="${nUUID}"/> 
		 文章类型：<select name="type"><option  selected>${type}</option>
                       <c:forEach items="${tresult}" var="tresult">
                       		<option>${tresult.type}</option>
                       	</c:forEach>
               </select>
       
			   <input type="hidden" name="UUID" value="${UUID}"/> 
	    
	 </div>
	 <textarea id="container" name="content" style="width: 800px; height: 400px; margin:0 auto; margin-top:40px;">
	 	${content}
	</textarea>
	<input type="submit" value="提交"/>
	</form>
	<script type="text/javascript">
	  var ue=UE.getEditor("container");
	</script>
	</div>
  </body>
</html>
   