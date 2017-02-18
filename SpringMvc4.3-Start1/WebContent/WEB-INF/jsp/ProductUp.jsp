<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="product_Updated.action" method="get">
		<fieldset>
			<legend>Update a product</legend>
			<label for="name">Product name</label>
				<input type="hidden" id="id" name="id" value="${product.id}" tabindex="1" />
				
				<input type="text" id="name" name="name" value="${product.name}" tabindex="2" />
				
				<label for="name">Product vender</label>
				<input type="text" id="vender" name="vender" value="${product.vender}" tabindex="3" />
				
				<label for="name">Address</label>
				<input type="text" id="address" name="address" value="${product.address}" tabindex="4" />
				
				<label for="name">Description</label>
				<input type="text" id="description" name="description" value="${product.description}" tabindex="5" />
				
				<label for="name">Price</label>
				<input type="text" id="price" name="price" value="${product.price}" tabindex="6" />
			<div id="buttons">
				<label for="dummy"></label> <input id="reset" type="reset"
					tabindex="7" /> <input id="submit" type="submit" tabindex="8"
					value="Update Product" />
		</fieldset>
	</form>
</body>
</html>