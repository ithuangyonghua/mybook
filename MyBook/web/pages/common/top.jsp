<%--
  Created by IntelliJ IDEA.
  User: Hyh
  Date: 2020/5/10
  Time: 12:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.png" >
    <div>
        <span>欢迎<span class="um_span">${user.username}</span>光临""书城</span>
        <a href="pages/order/order.jsp">我的订单</a>
        <a href="UserServlet?action=logout">注销</a>&nbsp;&nbsp;
        <a href="${path}/index.jsp">返回</a>
    </div>
</div>
