<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
<%--<base href="http://localhost:8080/BookStore02/">
<link type="text/css" rel="stylesheet" href="static/css/style.css" >--%>
<%@include file="/pages/common/style.jsp"%>
</head>
<body>
	<%--${sessionScope.cartItem}--%>
	<%--<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.png" >
			<span class="wel_word">购物车</span>
			<div>
				<span>欢迎<span class="um_span">韩总</span>光临""书城</span>
				<a href="pages/order/order.jsp">我的订单</a>
				<a href="index.jsp">注销</a>&nbsp;&nbsp;
				<a href="index.jsp">返回</a>
			</div>
	</div>--%>

	<%@include file="/pages/common/top.jsp"%>
	<div id="main">
	
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>
			<c:if test="${empty sessionScope.cartItem.items}">
				<tr>
					<td colspan="5"><a href="index.jsp">亲,购物车为空！快点去首页添加商品把</a></td>
				</tr>
			</c:if>
			<c:if test="${not empty sessionScope.cartItem.items}">
				<c:forEach items="${sessionScope.cartItem.items}" var="item">
					<tr>
						<td>${item.value.name}</td>
						<td><input type="text" style="width:80px;" bookid="${item.value.id}" class="numberBtn" value="${item.value.count}"/></td>
						<td>${item.value.price}</td>
						<td>${item.value.totalPrice}</td>
						<td><a class="itemDeleteBtn" href="CartServlet?action=deleteItem&id=${item.value.id}">删除</a></td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
		<c:if test="${not empty cartItem.items}">
		<div class="cart_info">
			<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cartItem.totalCount}</span>件商品</span>
			<span class="cart_span">总金额<span class="b_price">${sessionScope.cartItem.totalPrice}</span>元</span>
			<span class="cart_span"><a id="clearBtn" href="CartServlet?action=clear">清空购物车</a></span>
			<span class="cart_span"><a href="OrderServlet?action=createOrder">去结账</a></span>
		</div>
		</c:if>
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
	 $(function(){
	     $(".itemDeleteBtn").click(function(){
	         return window.confirm("你确定删除【"+$(this).parent().parent().find("td:first").text()+"】吗?");
		 });
	     $("#clearBtn").click(function(){
             return window.confirm("你确定清空购物车吗?");
		 });

	     $(".numberBtn").change(function(){
	        if(window.confirm("你确认将【"+$(this).parent().parent().find("td:first").text()+"】商品数量修改为"+$(this).attr("value")+"吗?")){
                window.location.href="${path}CartServlet?action=updateCount&id="+$(this).attr("bookid")+"&count=" + $(this).attr("value");
			}else{
	            this.value=this.defaultValue;
			}
		 });

	 });



</script>