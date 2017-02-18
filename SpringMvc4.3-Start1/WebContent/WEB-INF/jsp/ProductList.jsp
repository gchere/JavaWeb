
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="">
		<table border="1">
			<tr>
				<td>编号</td>
				<td>产品名称</td>
				<td>厂商</td>
				<td>生产地址</td>
				<td>简介</td>
				<td>价格</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${proList}" var="product" varStatus="vs">
				<tr>
					<td>${vs.count}</td>
					<td>${product.name}</td>
					<td>${product.vender}</td>
					<td>${product.address}</td>
					<td>${product.description}</td>
					<td>${product.price}</td>
					<td><a href="product_del.action?id=${product.id}">删除</a></td>
					<td><a href="product_uping.action?id=${product.id}">修改</a></td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>