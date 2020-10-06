<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/mgr/common/css/common.css">

<style type="text/css">
.review-subtitle {color:#5E7170; margin: 0px auto; width:70%; text-align: center; font-weight: bold; font-size:1.5rem; padding-top:3rem; margin-top: 30px}
.review-tab-div {margin: 0px auto; width:70%; padding: 1rem; margin-top: 30px}
.table{ width: 800px; margin: 0px auto }
.thead-collie {color:#285943; background-color: #77AF9C; border-color: #77AF9C; text-align:center; font-weight: bold}
.tbody-collie { border-color: none;}
#btnDiv{ width: 230px; margin: 0px auto }
.btn-primary{ background-color: #5E7170; border-color: #5E7170; margin:0px auto; margin-top: 50px; width: 100px; padding: 8px  }
.btn-primary:hover, .btn-primary:active, .btn-primary:focus{ background-color: #5E7170 !important; }
#delBtn{ margin-left: 20px }
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
<body style="font-family: 'NanumBarunGothic'">
	
<div id="wrap">

	<c:import url="/header.do" /> 

	<div id="container">
		<div class="review-subtitle">
			상품후기 목록
		</div>
			<div class="review-tab-div">
				<table class="table">
				  <tbody class="tbody-collie">
				    <tr>
				      <td class="thead-collie">번호</td>
				      <td>1</td>
				    </tr>
				    <tr>
				      <td class="thead-collie">아이디</td>
				      <td>gildong</td>
				    </tr>
				    <tr>
				      <td class="thead-collie">제목</td>
				      <td>브로콜리</td>
				    </tr>
				    <tr>
				      <td class="thead-collie">내용</td>
				      <td>브로콜리 맛있네요 ㅎ</td>
				    </tr>
				  </tbody>
				 </table>
			</div>
			<div id="btnDiv">
				<button type="button" class="btn btn-primary" onclick="javascript:history.back();">뒤로</button>
				<button type="button" class="btn btn-primary" id="delBtn">삭제</button>
			</div>			
			<input type="hidden" name="review_num" value=""/>
	</div>
</div>

</body>
</html>