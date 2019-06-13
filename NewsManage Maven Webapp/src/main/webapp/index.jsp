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
    
    <title>博客首页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/base.css" rel="stylesheet">
    <link href="css/index.css" rel="stylesheet">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
 <!-- 
  <body>
    
     <c:choose>  
       <c:when test="${user_name==null}">  
          <a href="login.jsp">登录</a>或<a href="register.jsp">注册</a>
       </c:when>  
       <c:otherwise>  		               
           <a href="ArticleServlet?flag=all">${user_name}</a>   	         
       </c:otherwise> 		          
     </c:choose>	
       
  	 <table>   	   
   	   <tr> 
		   <td><a href ="ArticleServlet?flag=all&index=y">综合</a></td>   	   	  	    	 
	 	   <c:forEach items="${tresult}" var="tresult">  	
	 		 <td><a href ="ArticleServlet?type=${tresult.type}&index=y">${tresult.type}</a></td>	    		 
		   </c:forEach> 
   	   </tr>	        	       
     </table>
     
     <form action="ArticleServlet?index=y" method="post">     
	     <table>	     	
		    <tr>
		     	<td>关键字<input type = "text" name="key"/></td>
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
    	   </tr>
       </c:forEach>  	       
     </table>
     
      <div>  
                       第${currentPage}页/共${totalPage}页
         <a href="ArticleServlet?currentPage=1&type=${type}&key=${key}&totalPage=${totalPage}&index=y">首页</a>          
         <c:choose>  
             <c:when test="${currentPage==1}">  
                                          上一页  
             </c:when>  
	         <c:otherwise>  		               
	               <a href="ArticleServlet?currentPage=${currentPage-1}&type=${type}&key=${key}&totalPage=${totalPage}&index=y">上一页</a>   	         
	         </c:otherwise> 		          
         </c:choose> 
         
         <c:choose>  
             <c:when test="${currentPage==totalPage}">  
                                         下一页  
             </c:when>  
	         <c:otherwise>  
	             <a href="ArticleServlet?currentPage=${currentPage+1}&type=${type}&key=${key}&totalPage=${totalPage}&index=y">下一页</a>  
	         </c:otherwise>  	         
         </c:choose> 
         <a href="ArticleServlet?currentPage=${totalPage}&type=${type}&key=${key}&totalPage=${totalPage}&index=y">尾页</a>  
         <form action="ArticleServlet?index=y" method="post">
                                跳转到<input type="text" name="currentPage"/>页
            <input type="hidden" name="type" value="${type}"/>
            <input type="hidden" name="key" value="${key}"/>
            <input type="hidden" name="totalPage" value="${totalPage}"/>
             <input type="submit" value="go"/>               
         </form>
       </div>        
  </body>
  -->
<body>  
  <header>
  <div id="logo"><a href=""></a></div>
  <nav class="topnav" id="topnav">
     <a href="index.jsp">
      <span>首页</span>
      <span class="en">Protal</span>
    </a>
      
      
    <c:choose>  
      <c:when test="${user_name==null}">  
	    <a href="login.jsp" >
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

<div class="banner">
  <section class="box">
    <ul class="texts">
      <p>欢迎来到博客首页</p>
      <p>在这里记录心情</p>
      <p>在这里留住回忆</p>
    </ul>
    
    <div class="avatar">
      <c:choose>  
        <c:when test="${user_name==null}">  
           <a href="login.jsp" ><span>头像</span></a>
        </c:when>
	    <c:otherwise>
	       <a href="ArticleServlet?flag=all" >
	       	  <img src="image/${uimagePath}" style="margin-top:-100px;height:130px;width:130px;">
	       	 
	       </a>
	    </c:otherwise> 		          
      </c:choose>   
    </div>
  </section>
</div>

<article>
  <h2 class="title_tj">
    <p>博客<span>推荐</span></p>
  </h2>
  
  <table  class="table1">   	   
	<tr> 
      <td ><a href ="ArticleServlet?flag=all&index=y" style="color:#FF7F50">综合</a></td>   	   	  	    	 
     <c:forEach items="${tresult}" var="tresult">  	
	  <td><a href ="ArticleServlet?type=${tresult.type}&index=y" style="color:#FF7F50">${tresult.type}</a></td>	    		 
     </c:forEach> 
    </tr>	        	       
  </table>
  
  <form action="ArticleServlet?index=y" method="post">     
     <table class="sousuo">	     	
	    <tr>
	     	<td style="color:#EE799F">关键字<input id="input" type = "text" name="key"/></td>
	     	<input type="hidden" name="type" value="${type}"/>
	     	<td colspan=3><input id="submit" type="submit" value="查询新闻" style="border:2px pink none;backgroundcolor:pink;color:#AEEEEE;"/></td>
	    </tr>		 	      
     </table>
 </form>
  
  <div class="bloglist left">
     <c:forEach items="${nresult}" var="nresult"> 
	    <h3>${nresult.title}</h3>
	    <figure><img src="image/${nresult.imagePath}" width="175px" height="150px"></figure>
	    <ul>
	      <p>${nresult.sub}...</p>
	      <p>浏览量:${nresult.viewNum}</p>
      	  <p>获赞数:${nresult.goodNum}</p> 
	      <a title="" href="ArticleServlet?flag=getOne&UUID=${nresult.UUID}" target="_blank" class="readmore">阅读全文>></a>
	    </ul>
	    <p class="dateview">
	      <span>发布于：${nresult.publishDate}</span>
	      <span>更新于：${nresult.modifyDate}</span>
	      <span>作者：${nresult.author}</span>
	      <span>博客类别：${nresult.type}</span>
	    </p>
 	</c:forEach>
 </div>

  <aside class="right">
    <div class="weather">
      <iframe width="250" scrolling="no" height="60" frameborder="0" allowtransparency="true" src="http://i.tianqi.com/index.php?c=code&id=12&icon=1&num=1"></iframe>
    </div>
    <div class="news">
    <h3>
      <p>最新<span>博客</span></p>
    </h3>
    <ul class="rank">
      <c:forEach items="${nList}" var="nList"> 
        <li><a href="ArticleServlet?flag=getOne&UUID=${nList.UUID}" title="" target="_blank">${nList.title}</a></li>
      </c:forEach>
    </ul>

    <h3 class="ph">
      <p>最新<span>排行</span></p>
    </h3>
    <ul class="paih">
      <c:forEach items="${gList}" var="gList">      
        <li><a href="ArticleServlet?flag=getOne&UUID=${gList.UUID}" title="" target="_blank">${gList.title}</a></li>
      </c:forEach>
    </ul>

    <h3 class="links">
      <p>博客<span>链接</span></p>
    </h3>
    <ul class="website">
      <li><a href="">大可爱的博客</a></li>
      <li><a href="">小可爱的博客</a></li>
      <li><a href="">小仙女的博客</a></li>
      <li><a href="">萝卜花的博客</a></li>
      <li><a href="">小小的博客</a></li>
    </ul> 
    </div>  

    <!-- Baidu Button BEGIN -->
    <div id="bdshare" class="bdshare_t bds_tools_32 get-codes-bdshare"><a class="bds_tsina"></a><a class="bds_qzone"></a><a class="bds_tqq"></a><a class="bds_renren"></a><span class="bds_more"></span><a class="shareCount"></a></div>
    <script type="text/javascript" id="bdshare_js" data="type=tools&amp;uid=6574585" ></script> 
    <script type="text/javascript" id="bdshell_js"></script> 
    <script type="text/javascript">
      document.getElementById("bdshell_js").src = "http://bdimg.share.baidu.com/static/js/shell_v2.js?cdnversion=" + Math.ceil(new Date()/3600000)
    </script> 
   
</article>

<div class="lastdiv" style="color:#FF7F50">  
                第${currentPage}页/共${totalPage}页
  <a href="ArticleServlet?currentPage=1&type=${type}&key=${key}&totalPage=${totalPage}&index=y" style="color:#FF7F50;margin-left:20px;margin-right:20px;">首页</a>          
  <c:choose>  
      <c:when test="${currentPage==1}">  
                                   上一页  
      </c:when>  
   <c:otherwise>  		               
         <a href="ArticleServlet?currentPage=${currentPage-1}&type=${type}&key=${key}&totalPage=${totalPage}&index=y" style="color:#FF7F50;margin-right:20px;">上一页</a>   	         
   </c:otherwise> 		          
  </c:choose> 
  
  <c:choose>  
      <c:when test="${currentPage==totalPage}" >  
                                  下一页  
      </c:when>  
   <c:otherwise>  
       <a href="ArticleServlet?currentPage=${currentPage+1}&type=${type}&key=${key}&totalPage=${totalPage}&index=y" style="color:#FF7F50;margin-left:20px;">下一页</a>  
   </c:otherwise>  	         
  </c:choose> 
  <a href="ArticleServlet?currentPage=${totalPage}&type=${type}&key=${key}&totalPage=${totalPage}&index=y" style="color:#FF7F50;margin-left:20px;">尾页</a>  
  <form action="ArticleServlet?index=y" method="post" style="color:#FF7F50;margin-left:30px;">
                         跳转到<input id="tiaozhuan" type="text" name="currentPage"/>页
     <input type="hidden" name="type" value="${type}"/>
     <input type="hidden" name="key" value="${key}"/>
     <input type="hidden" name="totalPage" value="${totalPage}"/>
      <input id="go" type="submit" value="go" style="border:2px pink none;backgroundcolor:pink;color:#AEEEEE;"/>               
  </form>
</div> 

<footer>
  <p>版权所有@2019<a href="/"></a></p>
</footer>

<script src="js/silder.js"></script>
</body>
  
</html>
