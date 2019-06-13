<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
  <title>注册页</title>
<link href="css/base.css" rel="stylesheet">
<link href="css/index.css" rel="stylesheet">
<link href="css/about_.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-1.11.2.js"></script>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script type="text/javascript">
	  $(document).ready(function(){
		$("#user_name").blur(
				function() {
					$.ajax({
			             type: "POST",
			             url: "UserServlet?flag=register1",
			             data: {user_name:$("#user_name").val()},
			             dataType: "json",
			             success: function(data){
             			console.info(data)
             			 $('#checkResult').empty();   //清空resText里面的所有内容
                         var html = ''; 
             			 //alert(data.userName)
             			if(data.result=="true"){
             				console.info("用户已经被注册")
             				document.getElementById("bt1").disabled=ture;
             			}else{
             				console.info("用户没有被注册")
             			}
                        html=data.reason
                         $('#checkResult').html(html);
                      }
			         });
				}
			);
	})
</script>

  </head>
  
  <!--  <body>
    <form action="UserServlet?flag=register" method="post">
    	<table>
    		<tr>
    			<td><input name="user_name" type="text" /></td>
    			<td><input name="passwd" type="password"/></td>
    			<td><input name="submit" type="submit" value="注册"></td>
    		</tr>
    	</table>
    	<a href="login.jsp">返回登录</a>
    </form>
  </body>
</html>-->

<header>
  <div id="logo"><a href=""></a></div>
  <nav class="topnav" id="topnav">
    <a href="index.jsp">
      <span>首页</span>
      <span class="en">Protal</span>
    </a>
    <!-- <a href="newlist_.html">
      <span>博文浏览</span>
      <span class="en">Life</span>
    </a>
    <a href="moodlist_.html">
      <span>博文列表</span>
      <span class="en">Doing</span>
    </a> -->
    <a href="register.jsp">
      <span>注册</span>
      <span class="en">About</span>
    </a>
  </nav>
</header>

<article>
  <h2 class="title_tj">
    <p><span>注册</span></p>
  </h2>
  <div class="login">
    <form action="UserServlet?flag=register" method="post">
      <input type="text" name="user_name" placeholder="用户名" required="required" id="user_name">
      <div id="checkResult"></div>
      <input type="password" name="passwd" placeholder="密  码" required="required">
      <input type="text" name="email" placeholder="邮 箱   选填" />
      <button type="submit" id="bt1">注册</button>
      <p><a href="login.jsp">返回登录</a></p>
    </form>
  </div>
</article>

<footer>
  <p>版权所有@2019<a href="/"></a></p>
</footer>

<script src="js/silder.js"></script>
</body>
</html>

