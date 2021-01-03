<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑图书</title>

	<%-- 静态包含 base标签、css样式，jQuery文件 --%>
	<%@ include file="/pages/common/head.jsp"%>

<style type="text/css">
	*{
		text-decoration: none;
	}
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}
	
	input {
		text-align: center;
		background-color: transparent;
		color: black;
		outline-style: none;
		outline-color: invert ;
		outline-width: 0px ;
		text-shadow: none ;
		-webkit-appearance: none ;
		-webkit-user-select: text ;
		outline-color: transparent ;
		box-shadow: none;
	}

	input.submit_bt{
		color: #e3e3e3;
		border:1px solid #666666;
		background-color: #39987c;

	}

</style>
</head>
<body>
		<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.jpg" style="border-radius:10px">
			<span class="wel_word">&nbsp;编辑图书</span>

			<%-- 静态包含manager管理模块的菜单--%>
			<%@include file="/pages/common/manager_menu.jsp"%>

		</div>
		<div id="main">
			<form action="manager/bookServlet" method="get">
				<input type="hidden" name="pageNo" value="${param.pageNo}"/>
				<input type="hidden" name="action" value="${ empty param.id ? "add" : "update"}"/>
				<input type="hidden" name="id" value="${ requestScope.book.id }"/>
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
						<td><input name="name" type="text" value="${requestScope.book.name}"/></td>
						<td><input name="price" type="text" value="${requestScope.book.price}"/></td>
						<td><input name="author" type="text" value="${requestScope.book.author}"/></td>
						<td><input name="sales" type="text" value="${requestScope.book.sales}"/></td>
						<td><input name="stock" type="text" value="${requestScope.book.stock}"/></td>
						<td><input class="submit_bt" type="submit" value="提交"/></td>
					</tr>	
				</table>
			</form>
		</div>

		<%-- 静态包含页脚 --%>
		<%@include file="/pages/common/footer.jsp"%>

</body>
</html>