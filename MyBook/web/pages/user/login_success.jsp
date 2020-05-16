<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.Date,java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会员注册页面</title>
<%@include file="/pages/common/style.jsp"%>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}
</style>
</head>
<body>
        <%@include file="/pages/common/top.jsp"%>
		<div id="main">
		
			<h1>欢迎回来 <a href="index.jsp">转到主页</a></h1>
	
		</div>
		
		<%--<div id="bottom">
			<span>
				""书城.Copyright &copy;2015
			</span>
		</div>--%>
		<%@include file="/pages/common/footer.jsp"%>
</body>
</html>