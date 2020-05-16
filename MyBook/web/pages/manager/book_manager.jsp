<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>图书管理</title>
</head>
<body>
<%@include file="/pages/common/manage.jsp" %>
<div id="main">
    <table>
        <tr>
            <td>名称</td>
            <td>价格</td>
            <td>作者</td>
            <td>销量</td>
            <td>库存</td>
            <td colspan="2">操作</td>
        </tr>
        <c:forEach items="${page.items}" var="book">
            <tr>
                <td>${book.name}</td>
                <td>${book.price}</td>
                <td>${book.author}</td>
                <td>${book.sales}</td>
                <td>${book.stock}</td>
                <td><a href="manager/bookServlet?id=${book.id}&action=getBook&pageNo=${requestScope.page.pageTotal}">修改</a></td>
                <td><a class="deleteBtn" href="manager/bookServlet?id=${book.id}&action=delete&pageNo=${requestScope.page.pageTotal}">删除</a></td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="7"><a href="pages/manager/book_edit.jsp?pageNo=${requestScope.page.pageTotal}">添加图书</a></td>
        </tr>
    </table>
   <%-- <div id="page_nav">
        <c:if test="${ requestScope.page.pageNo > 1}">
            <a href="manager/bookServlet?pageNo=1&action=page">首页</a>
            <a href="manager/bookServlet?pageNo=${ requestScope.page.pageNo - 1}&action=page">上一页</a>
        </c:if>

        <c:choose>
             &lt;%&ndash;情况 1：如果总页码小于等于 5 的情况，页码的范围是：1-总页码&ndash;%&gt;
            <c:when test="${ requestScope.page.pageTotal <= 5 }">
                <c:set var="begin" value="1"/>
                <c:set var="end" value="${requestScope.page.pageTotal}"/>
            </c:when>
            &lt;%&ndash;情况 2：总页码大于 5 的情况&ndash;%&gt;
            <c:when test="${requestScope.page.pageTotal > 5}">
               <c:choose>
                &lt;%&ndash;小情况 1：当前页码为前面 3 个：1，2，3 的情况，页码范围是：1-5.&ndash;%&gt;
                <c:when test="${requestScope.page.pageNo <= 3}">
                     <c:set var="begin" value="1"/>
                    <c:set var="end" value="5"/>
                 </c:when>
                &lt;%&ndash;小情况 2：当前页码为最后 3 个，8，9，10，页码范围是：总页码减 4 - 总页码&ndash;%&gt;
                   <c:when test="${requestScope.page.pageNo > requestScope.page.pageTotal-3}">
                       <c:set var="begin" value="${requestScope.page.pageTotal-4}"/>
                       <c:set var="end" value="${requestScope.page.pageTotal}"/>
                   </c:when> &lt;%&ndash;小情况 3：4，5，6，7，页码范围是：当前页码减 2 - 当前页码加 2&ndash;%&gt;
                    <c:otherwise>
                      <c:set var="begin" value="${requestScope.page.pageNo-2}"/>
                        <c:set var="end"  value="${requestScope.page.pageNo+2}"/>
                    </c:otherwise>
               </c:choose>
            </c:when>
        </c:choose>
        <c:forEach begin="${begin}" end="${end}" var="i">
            <c:if test="${i == requestScope.page.pageNo}"> 【${i}】 </c:if>
            <c:if test="${i != requestScope.page.pageNo}">
                <a href="manager/bookServlet?action=page&pageNo=${i}">${i}</a> </c:if>
        </c:forEach> &lt;%&ndash;页码输出的结束&ndash;%&gt;


        <c:if test="${ requestScope.page.pageNo < requestScope.page.pageTotal}">
            <a href="manager/bookServlet?pageNo=${ requestScope.page.pageNo + 1}&action=page">下一页</a>
            <a href="manager/bookServlet?pageNo=${ requestScope.page.pageTotal}&action=page">末页</a>
        </c:if>

        共${ requestScope.page.pageTotal }页，${ requestScope.page.pageTotalCount }条记录
        到第<input value="${ requestScope.page.pageNo }" name="pn" id="pn_input"/>页
        <input type="button" id="serachPageBtn" value="确定"></div>--%>

     <%@include file="/pages/common/nav.jsp"%>

</div>

<%@include file="/pages/common/footer.jsp" %>
</body>
</html>
<script>
    $(".deleteBtn").click(function () {
        return confirm("你确认删除【" + $(this).parent().parent().find("td:first").text() + "】");
    });

</script>