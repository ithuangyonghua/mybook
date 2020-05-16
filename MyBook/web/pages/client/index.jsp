<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.Date,java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>书城首页</title>
    <%@include file="/pages/common/style.jsp"%>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.png" >
    <span class="wel_word">网上书城</span>
    <div>
        <c:if test="${not empty sessionScope.user}">
            <span>欢迎<span class="um_span">${user.username}</span>光临""书城</span>
            <a href="pages/order/order.jsp">我的订单</a>
            <a href="UserServlet?action=logout">注销</a>&nbsp;&nbsp;
        </c:if>
        <c:if test="${empty sessionScope.user}">
            <a href="pages/user/login.jsp">登录</a> |
            <a href="pages/user/regist.jsp">注册</a> &nbsp;&nbsp;
        </c:if>
        <%--CartServlet?action=list--%>
        <a href="pages/cart/cart.jsp">购物车</a>
        <a href="pages/manager/manager.jsp">后台管理</a>
    </div>
</div>
<div id="main">
    <div id="book">
        <div class="book_cond">
            <form action="client/ClientBookServlet" method="get">
                <input type="hidden" name="action" value="getBookByPrice"/>
                价格：<input id="min" type="text" name="min" value="${param.min}"> 元 -
                <input id="max" type="text" name="max" value="${param.max}"> 元
                <input type="submit" value="查询" />
            </form>
        </div>
        <div style="text-align: center">
            <c:if test="${not empty cartItem.items}">
                <span>您的购物车中有${sessionScope.cartItem.totalCount}件商品</span>
                <div>
                    您刚刚将<span style="color: red">${sessionScope.lastName}</span>加入到了购物车中
                </div>
            </c:if>

        </div>

     <c:forEach items="${page.items}" var="i">
        <div class="b_list">
            <div class="img_div">
                <img class="book_img" alt="" src="static/img/default.jpg" />
            </div>
            <div class="book_info">
                <div class="book_name">
                    <span class="sp1">书名:</span>
                    <span class="sp2">${i.name}</span>
                </div>
                <div class="book_author">
                    <span class="sp1">作者:</span>
                    <span class="sp2">${i.author}</span>
                </div>
                <div class="book_price">
                    <span class="sp1">价格:</span>
                    <span class="sp2">￥${i.price}</span>
                </div>
                <div class="book_sales">
                    <span class="sp1">销量:</span>
                    <span class="sp2">${i.sales}</span>
                </div>
                <div class="book_amount">
                    <span class="sp1">库存:</span>
                    <span class="sp2">${i.stock}</span>
                </div>
                <div class="book_add">
                    <button bookid="${i.id}"  class="addItemBtn">加入购物车</button>
                </div>
            </div>
        </div>
     </c:forEach>
    </div>


    <%@include file="/pages/common/nav.jsp"%>
</div>

<%@include file="/pages/common/footer.jsp"%>
</body>
</html>
<script type="text/javascript">
    //加入购物车监听事件
    $(".addItemBtn").click(function(){
            window.location.href="${base}CartServlet?action=addItem&id=" + $(this).attr("bookid");
    });
</script>