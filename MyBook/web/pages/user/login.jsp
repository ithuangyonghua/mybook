<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.Date,java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会员登录页面</title>
<%@include file="/pages/common/style.jsp"%>
<script type="text/javascript">

  $(function(){
      $("#sub_btn").click(function(){
           var username = $("#username").val();
           if(username ==""){
               layer.msg("用户名不能为空", {time:1000, icon:5, shift:6}, function(){});
               return false;
		   }
		  var password = $("#password").val();
          if(password ==""){
              layer.msg("密码不能为空", {time:1000, icon:5, shift:6}, function(){});
              return false;
          }
	  });
  });

</script>
</head>
<body>

			<div id="login_header" method="post">
				<img class="logo_img" alt="" src="static/img/logo.png" >
			</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎登录</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>会员</h1>
								<a href="pages/user/regist.jsp">立即注册</a>
							</div>
							<div class="msg_cont">
								<b></b>
								<span class="errorMsg">
                                   <%--<%=request.getAttribute("msg")==null?"请输入用户名和密码":request.getAttribute("msg") %>--%>
								   ${empty msg ?"请输入用户名和密码":msg}
								</span>
							</div>
							<div class="form">
								<form action="UserServlet" method="post">
									<input type="hidden" name="action" value="login"/>

									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" value="${username}" autocomplete="off" tabindex="1" id="username" name="username" />
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" id="password" name="password" />
									<br />
									<br />
									<input type="submit" value="登录" id="sub_btn" />
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<<%--div id="bottom">
			<span>
				""书城.Copyright &copy;2015
			</span>
		</div>--%>
		<%@include file="/pages/common/footer.jsp"%>
</body>
</html>