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
	if('${mgr_id}' != '' && '${not empty mgr_id}') { 
		alert('${mgr_id}님 어서오세요.');
		location.href="category/list.do";
	} else {
		alert("아이디와 비밀번호를 확인해주세요.");
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