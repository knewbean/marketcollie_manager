<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마켓콜리</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/collie_user/common/css/common.css">
 
<style type="text/css">
#container{ width: 70%; margin: 0px auto; min-height: 700px; margin-top:50px; }
</style>
<!-- Google CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<script type="text/javascript">
$(function(){
	
	
});//ready
</script>
</head>
<body style="font-family: nanumbarungothic">

<div id="wrap">
	
	<jsp:include page="/WEB-INF/views/common/header.jsp" />
	
	<div id="container">
		<div style="text-align: center; font-size: 40px; color:#285943; border-color: #77AF9C;">
			아이템 등록이 완료되었습니다.
		</div>
		<div style="text-align: center; ">
		<input type="button" value="메인으로" />
		</div>
	</div>
	
	
</div>

</body>
</html>	