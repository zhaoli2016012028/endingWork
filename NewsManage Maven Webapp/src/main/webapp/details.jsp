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
    
	<title>博客详情页</title>
    
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
	<link href="css/news.css" rel="stylesheet">

  </head>
  
  <body>
  <!-- 
     <table>
    	   <tr>
    	   	 <td>题目</td>
    	   	 <td><input type="text" name="title" value="${title}"/></td>
    	   </tr>
    	   <tr>
    	   	 <td>类型</td>
    	   	 <td><input type="text" name="type" value="${type}"/></td>
    	   </tr>
    	   <tr>
    	   	 <td>作者</td>
    	   	 <td><input type="text" name="author" value="${author}"/></td>
    	   </tr>
    	   <tr>
    	   	 
    	   </tr>  
    	   <tr>
    	   	 <td>发布日期</td>
    	   	 <td><input type="text" name="publishDate" value="${publishDate}"/></td>
    	   </tr>  
    	   <tr>
    	   	 <td>最新修改日期</td>
    	   	 <td><input type="text" name="modifyDate" value="${modifyDate}"/></td>
    	   </tr>  	   
    	</table>
    	<p>${content}</p>
    	<c:forEach items="${cList}" var="cList">  
    		 <tr><input type="text" value="${cList.user_name}"/></tr> 	
    		 <img src="image/${cList.imagePath}" width="42" height="42">   	 
    		 <tr><input type="text" value="${cList.imagePath}"/></tr> 	 	    	   	   
    	   	 <tr><input type="text" value="${cList.comments}"/></tr>
    	   	 <tr><input type="text" value="${cList.comdate}"/></tr>
        </c:forEach>  
        
        <c:choose>  
          <c:when test="${user_name==null}">  
               <a href="login.jsp">登录</a>或<a href="register.jsp">注册</a>后评论  
          </c:when>  
          <c:otherwise>  		               
               <form action="ArticleServlet?flag=addcom" method="post">
                  <input type="text" name="comment" />
                  <input type="submit" value="提交评论"/>               
    	   	      <input type="hidden" name="nUUID" value="${UUID}"/>	   
               </form>   	         
          </c:otherwise> 		          
       </c:choose>
    -->
    
    <header>
  <div id="logo"><a href=""></a></div>
  <nav class="topnav" id="topnav">
    <a href="index.jsp">
      <span>首页</span>
      <span class="en">Protal</span>
    </a>
    <c:choose>  
      <c:when test="${user_name==null}">  
	    <a href="login.jsp">
	      <span>登录|注册</span>
	      <span class="en">About</span>
	    </a>
	  </c:when>
	  <c:otherwise>  		               
           <a href="ArticleServlet?flag=all">
             <span>${user_name}</span>
	         <span class="en">About</span> 
	       </a>  	         
       </c:otherwise> 		          
     </c:choose>   
  </nav>
</header>

<article>
  <h2 class="title_tj">
    <p>博客<span>详情</span></p>
  </h2>
  <div id="contentText">
    <h2>${title}</h2>
    <img src="images/view.png" style="height:20px;width:20px;"/>
    <div style="margin-top:-20px;"><p>浏览量:${viewNum}</p></div>
    <img src="images/love.png" style="height:20px;width:20px;"/>
    <div style="margin-top:-20px;"><p>获赞数:${goodNum}</p></div> 
 
	 <c:choose>  
       <c:when test="${user_name==null}">  
	   </c:when>
	   <c:otherwise>  		               
           <a href="ArticleServlet?flag=addGood&nUUID=${nUUID}"><img src="images/like.png" class="site"/></a>	
                    
       </c:otherwise> 		          
     </c:choose>   
	 
    <p id="details">发布时间:${publishDate}&nbsp&nbsp更新时间：${modifyDate} &nbsp&nbsp&nbsp 作者：${author} &nbsp&nbsp类型：${type}</p><br>
    <p>${content}</p>
  </div>
</article>
<div class="bottom">
<c:forEach items="${cList}" var="cList"> 
	 <div>
	     <p class="username">${cList.user_name}</p>
	     <img src="image/${cList.imagePath}" />
	     <p class="text">${cList.comments}</p>
	     <p class="time">评论时间：${cList.comdate}</p>
	 </div>
</c:forEach> 
<c:choose>  
   <c:when test="${user_name==null}">  
 	  <a href="login.jsp" style="color:#FF7F50;" >登录</a>或<a href="register.jsp" style="color:#FF7F50;">注册</a>后评论  
   </c:when>  
   <c:otherwise>
	  <form action="ArticleServlet?flag=addcom" method="post">
          <input type="text" name="comment" style="height:100px;width:910px;font-size:18px;" /></br>
          <input type="submit" value="提交评论" style="border:2px pink none;backgroundcolor:pink;color:#AEEEEE;height:30px;width:70px;font-size:18px;margin-left:840px;"/>                
	 	 <input type="hidden" name="nUUID" value="${nUUID}"/>	   	 		
	  </form> 
   </c:otherwise> 		          
</c:choose>
</div>  

<footer>
  <p>版权所有@2019<a href="/"></a></p>
</footer>

<script src="js/silder.js"></script>
  </body>
</html>
