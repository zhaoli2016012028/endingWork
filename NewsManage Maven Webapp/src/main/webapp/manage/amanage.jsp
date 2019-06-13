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
    
    <title>管理员操作页</title>
    
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
    <p>欢迎你 ${user_name}</p>
    <p>管理员等级${grade}</p>
    <a href="ArticleServlet?flag=goIndex">返回首页</a>
  	<a href="UserServlet?flag=findAll">管理用户</a>
  	<a href="TypeServlet?flag=findType">管理类型</a>
  	<a href="ArticleServlet?flag=all&mlist=y">我的文章</a>
  	
  	 <table>   	   
   	   <tr> 
		   <td><a href ="ArticleServlet">综合</a></td>   	   	  	    	 
	 	   <c:forEach items="${tresult}" var="tresult">  	
	 		 <td><a href ="ArticleServlet?type=${tresult.type}">${tresult.type}</a></td>	    		 
		   </c:forEach> 
   	   </tr>	        	       
     </table>
      
     <a href ="manage/add.jsp">增加新闻</a>
      
     <form action="ArticleServlet" method="post">     
	     <table>	     	
		    <tr>
		     	<td>关键字<input type = "text" name="key"/></td>
		     	<input type="hidden" name="type" value="${type}"/>		     	
		     	<td colspan=3><input type="submit" value="查询新闻" /></td>
		    </tr>		 	      
	     </table>
	 </form>
         
     <table>
    	   <c:forEach items="${nresult}" var="nresult">  
	    	   <tr>    	   	  	    	 
	    	   	 <td><a href="ArticleServlet?flag=getOne&UUID=${nresult.UUID}"  target="_blank">${nresult.title}</a></td>
	    	   	 <td>${nresult.author}</td>
	    	   	 <td>${nresult.type}</td>
	    	   	 <td>${nresult.publishDate}</td>
	    	   	 <td>${nresult.modifyDate}</td>
	    		 <td><a href ="ArticleServlet?flag=del&UUID=${nresult.UUID} ">删除</a></td>	    		 
	    	   </tr>
	       </c:forEach>  	       
     </table>
     
      <div>  
                       第${currentPage}页/共${totalPage}页
         <a href="ArticleServlet?currentPage=1&type=${type}&key=${key}&totalPage=${totalPage}">首页</a>          
         <c:choose>  
             <c:when test="${currentPage==1}">  
                                          上一页  
             </c:when>  
	         <c:otherwise>  		               
	               <a href="ArticleServlet?currentPage=${currentPage-1}&type=${type}&key=${key}&totalPage=${totalPage}">上一页</a>   	         
	         </c:otherwise> 		          
         </c:choose> 
         
         <c:choose>  
             <c:when test="${currentPage==totalPage}">  
                                         下一页  
             </c:when>  
	         <c:otherwise>  
	             <a href="ArticleServlet?currentPage=${currentPage+1}&type=${type}&key=${key}&totalPage=${totalPage}">下一页</a>  
	         </c:otherwise>  	         
         </c:choose> 
         <a href="ArticleServlet?currentPage=${totalPage}&type=${type}&key=${key}&totalPage=${totalPage}">尾页</a>  
         <form action="ArticleServlet" method="post">
                                跳转到<input type="text" name="currentPage"/>页
            <input type="hidden" name="type" value="${type}"/>
            <input type="hidden" name="key" value="${key}"/>
            <input type="hidden" name="totalPage" value="${totalPage}"/>
             <input type="submit" value="go"/>               
         </form>
       </div>
  -->
     
     <header>
  <div id="logo"><a href=""></a></div>
  <nav class="topnav" id="topnav">
    <a href="index.jsp">
      <span>首页</span>
      <span class="en">Protal</span>
    </a>
    <a href="ArticleServlet?flag=quit">
      <span>退出</span>
      <span class="en">About</span>
    </a>
  </nav>
</header>

<article>
  <h2 class="title_tj">
    <p>欢迎你<span>${user_name}</span></p>
  </h2>
  <div class="center_first" >
    <div style="font-size: 18px; text-align: ;font-weight: 700px;">
      <p>
      	 <span><a href="UserServlet?flag=findAll">管理用户&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp </a></span>
      	 <span><a href="TypeServlet?flag=findType">管理类型&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp </a></span>
      	 <span><a href="ArticleServlet?flag=all&mlist=y">我的博客</a></span>
      </p>
      
      <p>
         <span><a href ="ArticleServlet">综合&nbsp&nbsp&nbsp</a></span>
         <c:forEach items="${tresult}" var="tresult">  
           <span><a href ="ArticleServlet?type=${tresult.type}">${tresult.type}&nbsp&nbsp&nbsp</a>
         </c:forEach>
      </p>
    </div>
    
    <div style="margin-top: 30px;">
      <form name="input" action="ArticleServlet" method="post" style="margin-left: 30%">
        <span style="font-size: 16px;">关键字:</span> 
        <input type="text" style="height: 30px;width: 300px;" name="key" />
        <input type="hidden" name="type" value="${type}"/>	
        <input type="submit" value="查询" style="height: 35px;width: 50px;background-color: lightblue;font-style: 18px;" />
      </form>
    </div>
    
    <div  style="margin-top:40px;font-size: 18px" >
      <table width="80%" height="40px" border="0" align="center" cellpadding="3" cellspacing="1" bgcolor="white">
        <tr bgcolor="lightblue">
          <td><div align="center"><strong>标题</strong></div></td>
          <td><div align="center"><strong>作者</strong></div></td>
          <td><div align="center"><strong>类型</strong></div></td>
          <td><div align="center"><strong>发布时间</strong></div></td>
          <td><div align="center"><strong>更新时间</strong></div></td>
          <td><div align="center"><strong>删除</strong></div></td>
        </tr>
          <c:forEach items="${nresult}" var="nresult">  
	        <tr bgcolor="lightpink">
	          <td><div align="center"><a href="ArticleServlet?flag=getOne&UUID=${nresult.UUID}"  target="_blank">${nresult.title}</a></div></td>
	          <td><div align="center">${nresult.author}</div></td>
	          <td><div align="center">${nresult.type}</div></td>
	          <td><div align="center">${nresult.publishDate}</div></td>
	          <td><div align="center">${nresult.modifyDate}</div></td>
	          <td><div align="center"><a href ="ArticleServlet?flag=del&UUID=${nresult.UUID}">删除</a></div></td>
	        </tr>
	      </c:forEach>
      </table>
 
      <div class="page">
       	 第${currentPage}页/共${totalPage}页
         <a href="ArticleServlet?currentPage=1&type=${type}&key=${key}&totalPage=${totalPage}">首页</a>          
         <c:choose>  
             <c:when test="${currentPage==1}">  
                                          上一页  
             </c:when>  
	         <c:otherwise>  		               
	               <a href="ArticleServlet?currentPage=${currentPage-1}&type=${type}&key=${key}&totalPage=${totalPage}">上一页</a>   	         
	         </c:otherwise> 		          
         </c:choose> 
         
         <c:choose>  
             <c:when test="${currentPage==totalPage}">  
                                         下一页  
             </c:when>  
	         <c:otherwise>  
	             <a href="ArticleServlet?currentPage=${currentPage+1}&type=${type}&key=${key}&totalPage=${totalPage}">下一页</a>  
	         </c:otherwise>  	         
         </c:choose> 
         <a href="ArticleServlet?currentPage=${totalPage}&type=${type}&key=${key}&totalPage=${totalPage}">尾页</a>  
         <form action="ArticleServlet" method="post">
                                跳转到<input type="text" name="currentPage"/>页
            <input type="hidden" name="type" value="${type}"/>
            <input type="hidden" name="key" value="${key}"/>
            <input type="hidden" name="totalPage" value="${totalPage}"/>
             <input type="submit" value="go"/>               
         </form>
      </div>
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
