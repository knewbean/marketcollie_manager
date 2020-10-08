<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="관리자 메인 페이지"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<style type="text/css">

.subtitle {color:#77AF9C; margin: 0px auto; width:70%; text-align: center; font-weight: bold; font-size:1.5rem; padding-top:3rem;}
.tab-div {margin: 0px auto; width: 400px; margin-top: 20px; border-top: 1px solid #77AF9C; border-bottom: 1px solid #77AF9C;}
.table{ width: 400px; margin: 0px auto; border: 0px solid #fff }
.thead-collie {color:#285943; background-color: #77AF9C; border-color: #77AF9C; text-align:center;}
.tbody-collie {text-align:left; border: 0px solid #fff;}
.btn-div {margin: 0px auto; width:400px; padding: 10px 0px 10px 0px; text-align: center;}
.collieBtnMain{ border: 1px solid #77AF9C; padding: 10px 10px 10px 10px; margin-top: 5px; margin-bottom: 5px; color: #285943; font-size: 15px; background-color: #77AF9C }
</style>

<link rel="stylesheet" type="text/css" href="/mgr/common/css/common.css">
<!-- Google CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<script type="text/javascript">
$(function(){
});//ready

</script>
</head>
<body>
	
<div id="wrap">

	<c:import url="/header.do" /> 

	<div id="container">
		
		<div class="subtitle">
			회원 관리
		</div>
		
		<div class="tab-div" id="memTableDiv">
			<table class="table">
			  <tbody class="tbody-collie">
			    <tr style="border: 0px solid #fff">
			      <th style="width: 100px; ">번호</th>
			      <td style="width:300px; "><c:out value="${ mem_detail.member_num }"/></td>
			    </tr>
			    <tr>
			      <th>아이디</th>
			      <td><c:out value="${ mem_detail.id }"/></td>
			    </tr>
			    <tr>
			      <th>이름</th>
			      <td><c:out value="${ mem_detail.name }"/></td>
			    </tr>
			    <tr>
			      <th>이메일</th>
			      <td><c:out value="${ mem_detail.email }"/></td>
			    </tr>
			    <tr>
			      <th>휴대폰</th>
			      <td><c:out value="${ mem_detail.phone }"/></td>
			    </tr>
			    <tr>
			      <th>우편번호</th>
			      <td><c:out value="${ mem_detail.zipcode }"/></td>
			    </tr>
			    <tr>
			      <th>주소</th>
			      <td><c:out value="${ mem_detail.addr }"/></td>
			    </tr>
			    <tr>
			      <th>상세주소</th>
			      <td><c:out value="${ mem_detail.addr_detail }"/></td>
			    </tr>
			    <tr>
			      <th>가입일</th>
			      <td><c:out value="${ mem_detail.input_date }"/></td>
			    </tr>
			 </tbody>
			</table>
		</div>
		
		<div class="btn-div">
		<input type="button" value="확인" id="cateAddBtn" class="collieBtnMain" onclick="javascript:history.back()">
		</div>
		
	</div>
</div>

</body>
</html>