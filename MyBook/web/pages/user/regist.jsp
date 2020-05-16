<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.Date,java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会员注册页面</title>
<%@include file="/pages/common/style.jsp"%>
<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}
</style>
	<script type="text/javascript">
		 $(function(){
             // 验证用户名：必须由字母，数字下划线组成，并且长度为 5 到 12 位
             // 验证密码：必须由字母，数字下划线组成，并且长度为 5 到 12 位
             // 验证确认密码：和密码相同
             // 邮箱验证：xxxxx@xxx.com
             // 验证码：现在只需要验证用户已输入。因为还没讲到服务器。验证码生成。
             $("#yzmimg").click(function () {
                this.src="${path}kaptcha.jpg?d" + new Date();
             });
			 $("#sub_btn").click(function(){
                 //1.验证用户名
				 debugger;
                 var username = $("#username").val();
                 var usernamePat = /^\w{5,12}$/;
                 if(!usernamePat.test(username)){
                     $(".errorMsg").text("用户名格式有误,请重新输入");
                     return false;//注意是return false
                 }
                 //2.验证密码
                 var password = $("#password").val();
                 var passwordPat = /^\w{5,12}$/;
				 if(!passwordPat.test(password)){
                     $(".errorMsg").text("密码格式有误,请重新输入");
                     return false;//注意是return false
				 }
				 //3.验证确认密码
				 var repassword = $("#repwd").val();
                 if(repassword!=password){
                     $(".errorMsg").text("两次输入密码不一致,请重新输入");
                     return false;//注意是return false
				 }
                 //验证邮箱
				 var email = $("#email").val();
                 var emailPatt=/^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
                 if(!emailPatt.test(email)){
                     $(".errorMsg").text("邮箱格式不正确,请重新输入");
                     return false;//注意是return false
				 }

			 });
		 });


	</script>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.png" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册会员</h1>
								<span class="errorMsg">
								    ${empty msg?"":msg}
								</span>
							</div>
							<div class="form">
								<form action="UserServlet" method="post">
									<input type="hidden" name="action" value="regist"/>
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" value="${username}" tabindex="1" name="username" id="username" />
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" id="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1" name="repwd" id="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" value="${email}" tabindex="1" name="email" id="email" />
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" style="width: 150px;"  name="yzm" id="code"/>
									<img alt=""  id="yzmimg" src="kaptcha.jpg" style="float: right; margin-right: 40px ;width:100px;height:30px" >
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
									
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<%--<div id="bottom">
			<span>
				""书城.Copyright &copy;2015
			</span>
		</div>--%>
		<%@include file="/pages/common/footer.jsp"%>
</body>
</html>
<script>

</script>