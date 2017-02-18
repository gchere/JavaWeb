<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form action="product_save.action" method="post">
			<fieldset>
				<legend>Add a product</legend>
				<label for="name">Product name</label>
				<input type="text" id="name" name="name" value="" tabindex="1" />
				
				<label for="name">Product vender</label>
				<input type="text" id="vender" name="vender" value="" tabindex="2" />
				
				<label for="name">Address</label>
				<input type="text" id="address" name="address" value="" tabindex="3" />
				
				<label for="name">Description</label>
				<input type="text" id="description" name="description" value="" tabindex="4" />
				
				<label for="name">Price</label>
				<input type="text" id="price" name="price" value="" tabindex="5" />
				
				<div id="buttons">
				<label for="dummy"></label>
				<input id="reset" type="reset" tabindex="6" />
				<input id="submit" type="submit" tabindex="7" value="Add Product" />
				</div>
			</fieldset>
		</form>
	
	</div>
</body>
</html>