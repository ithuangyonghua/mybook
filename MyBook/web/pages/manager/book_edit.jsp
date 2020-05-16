<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.Date,java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑图书</title>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}
	
	input {
		text-align: center;
	}
</style>
</head>
<body>
		<%@include file="/pages/common/manage.jsp"%>
		<div id="main">
			<form action="manager/bookServlet" method="post">
				<table>
					<tr>
						<td>名称</td>
						<td>价格</td>
						<td>作者</td>
						<td>销量</td>
						<td>库存</td>
						<td colspan="2">操作</td>
					</tr>		
					<tr>
						<input type="hidden" name="pageNo" value="${param.pageNo}"/>
						<input type="hidden" name="action" value="${empty param.id?"add":"update"}"/>
						<input name="id"  type="hidden" value="${bookEntity.id}"/>
						<td><input name="name"  type="text" value="${bookEntity.name}"/></td>
						<td><input name="price" type="text" value="${bookEntity.price}"/></td>
						<td><input name="author" type="text" value="${bookEntity.author}"/></td>
						<td><input name="sales" type="text" value="${bookEntity.sales}"/></td>
						<td><input name="stock" type="text" value="${bookEntity.stock}"/></td>
						<td><input type="submit" value="提交"/></td>
					</tr>	
				</table>
			</form>
			
	
		</div>

		<%@include file="/pages/common/footer.jsp"%>
</body>
</html>