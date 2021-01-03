<%--
  Created by IntelliJ IDEA.
  User: 廖婷姝
  Date: 2020/12/31
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- 分页条 --%>
<div id="page_nav">
    <c:if test="${requestScope.page.pageNo > 1}">
        <a href="${requestScope.page.url}&pageNo=1">首页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo-1}">上一页</a>
    </c:if>

    <%--<a href="#">3</a>--%>
    【${ requestScope.page.pageNo}】
    <%--<a href="#">5</a>--%>
    <c:if test="${requestScope.page.pageNo < requestScope.page.pageTotal}">
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo+1}">下一页</a>
    </c:if>

    <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageTotal}">末页</a>
    共${ requestScope.page.pageTotal}页，${ requestScope.page.pageTotalCount}条记录
    <%--到第<input value="4" name="pn" id="pn_input"/>页
    <input type="button" value="确定">--%>
</div>
