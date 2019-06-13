<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
 <html>
  <head>
    <base href="<%=basePath%>">
    
<title>登录|注册页</title>
<link href="css/base.css" rel="stylesheet">
<link href="css/index.css" rel="stylesheet">
<link href="css/about_.css" rel="stylesheet">
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <!--  <body>
    <form action="UserServlet?flag=login" method="post">
    	<table>
    		<tr>
    			<td><input name="user_name" type="text" /></td>
    			<td><input name="passwd" type="password"/></td>
    			<td><input name="submit" type="submit" value="登录"></td>
    		</tr>
    	</table>
    </form>
    <a href="register.jsp">注册</a>
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
    <a href="login.jsp">
      <span>登录|注册</span>
      <span class="en">About</span>
    </a>
  </nav>
</header>

<article>
  <h2 class="title_tj">
    <p><span>登录|注册</span></p>
  </h2>
  <div class="login">
    <form action="UserServlet?flag=login" method="post">
      <input type="text" id="username" name="user_name" placeholder="用户名" required="required">
      <input type="password" id="psw" name="passwd" placeholder="密  码" required="required">
      <button type="submit" id="submit" onclick="login()" style="margin-left:390px;height:50px;">登录</a></button>
      <p><a href="register.jsp">注册</a></p>
    </form>
  </div>
</article>

<footer>
  <p>版权所有@2019<a href="/"></a></p>
</footer>

<script src="js/silder.js"></script>
<script src="js/jquery.js"></script>
<script type="text/javascript">
  // function login(){
  //   var username=$("#username").val();
  //   var psw=$("#psw").val();
  //   if((username).equal("admin")&&(psw).equal("admin")){
  //     windows.location.href="admin.html"
  //   }else{
  //     alert("登录失败，用户名或密码错误")
  //   }
  // }
      </script>
</script>
</body>
</html>
