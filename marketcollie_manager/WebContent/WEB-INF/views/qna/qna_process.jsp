<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- Google CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

<script type="text/javascript">
$(function(){
	
	if(${modify_result}) { 
		alert("수정했습니다.");
		location.href="list.do";
	} else {
		alert("수정 실패했습니다.");
		history.back();
	}
});//ready
</script>
</head>
<body style="font-family: nanumbarungothic">

<div id="wrap">
	

</div>
</body>
</html>