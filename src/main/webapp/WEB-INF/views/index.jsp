<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MadLib Google Reviews</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/spacelab/bootstrap.min.css"
	rel="stylesheet" crossorigin="anonymous">
<link href="/styles.css" rel="stylesheet" />
</head>
<body>
	<div class="container">

		<h1>MadLib Google Reviews</h1>
		<form action="/newReview?city=${city}?name=${name}?content=${content}">
		<h3>City</h3><input name="city"/>
		<h3>Venue</h3><input name="name"/>
		<h3>Your Words (Separate by commas)</h3><textarea name="content" rows="5 " cols="60"></textarea>
			<button type="submit" class="btn btn-primary">Go!</button>
		</form>
	
	</div> 

</body>
</html>