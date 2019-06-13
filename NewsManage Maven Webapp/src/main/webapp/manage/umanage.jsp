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
    
    <title>博客浏览页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="css/base.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet">
	<link href="css/index.css" rel="stylesheet">

  </head>
  
  <body>  
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
       <div class="yonghu">
	     
	      <img src="image/${uimagePath}" style="position:float;height:42px;width:42px;border:1px solid black;">
	       
	      <a href="manage/imageUpload.jsp" class="site">换头像</a>
	      <span style="">欢迎您  ${user_name}</span>
	      
	   </div>    
         	      	           	
	  </nav>  
	
 </header>
    <c:if test="${grade eq '1'}">
       <a href="ArticleServlet?flag=all&mlist=r">
	       <span  style="margin-left:85%;font-size:15px;color:#FF7F50;">返回管理</span>
       </a> 
	</c:if> 
    
<div class="banner">
  <section class="box">
    <ul class="texts">
      <p>欢迎来到博客首页</p>
      <p>在这里记录心情</p>
      <p>在这里留住回忆</p>
    </ul>
  </section>
</div>

<article>
  <h2 class="title_tj">
    <p>我的<span>博文</span></p>
    
  </h2>
  <div style="margin-top:10px;">
     <a href="ArticleServlet?flag=all"  style="font-size:18px;color:#FF7F50;">全部博文</a>&emsp;&emsp;
     <a href="manage/add.jsp"   style="font-size:18px;color:#FF7F50;">增加博文</a>
  </div>
  <form action="ArticleServlet" method="post">     
     <table class="sousuo">	     	
	    <tr>
	     	<td style="color:#EE799F">关键字<input id="input" type = "text" name="key"/></td>
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
      	  <p><a href="ArticleServlet?flag=getOne&UUID=${nresult.UUID}&edit=y">编辑</a></p>
      	  <p><a href="ArticleServlet?flag=del&UUID=${nresult.UUID}">删除</a></p>
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
  <a href="ArticleServlet?currentPage=1&key=${key}&totalPage=${totalPage}&index=y" style="color:#FF7F50;margin-left:20px;margin-right:20px;">首页</a>          
  <c:choose>  
      <c:when test="${currentPage==1}">  
                                   上一页  
      </c:when>  
   <c:otherwise>  		               
         <a href="ArticleServlet?currentPage=${currentPage-1}&key=${key}&totalPage=${totalPage}&index=y" style="color:#FF7F50;margin-right:20px;">上一页</a>   	         
   </c:otherwise> 		          
  </c:choose> 
  
  <c:choose>  
      <c:when test="${currentPage==totalPage}" >  
                                  下一页  
      </c:when>  
   <c:otherwise>  
       <a href="ArticleServlet?currentPage=${currentPage+1}&key=${key}&totalPage=${totalPage}" style="color:#FF7F50;margin-left:20px;">下一页</a>  
   </c:otherwise>  	         
  </c:choose> 
  <a href="ArticleServlet?currentPage=${totalPage}&key=${key}&totalPage=${totalPage}" style="color:#FF7F50;margin-left:20px;">尾页</a>  
  <form action="ArticleServlet" method="post" style="color:#FF7F50;margin-left:30px;">
                         跳转到<input id="tiaozhuan" type="text" name="currentPage"/>页
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
