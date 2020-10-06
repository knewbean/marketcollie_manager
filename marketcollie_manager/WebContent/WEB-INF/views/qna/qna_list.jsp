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
<link rel="stylesheet" type="text/css" href="/mgr/common/css/common.css">

<style type="text/css">
.qna-tab-div {margin: 0px auto; width:70%; padding: 1rem;}
.qna-subtitle {color:#77AF9C; margin: 0px auto; width:70%; text-align: center; font-weight: bold; font-size:1.5rem; padding-top:3rem;}
.thead-collie {color:#285943; background-color: #77AF9C; border-color: #77AF9C; text-align:center;}
.tbody-collie {text-align:center;}
</style>

<!-- Google CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<script type="text/javascript">
$(function(){
});//ready

function gotoDetail(qna_num){
	location.href="detail.do?qna_num="+qna_num;
}
</script>
</head>
<body style="font-family: 'NanumBarunGothic'">
	
<div id="wrap">

	<c:import url="/header.do" /> 

	<div id="container">
		<div class="qna-subtitle">
			<img src="../common/images/icons/icon_qna_32.png"> 문의사항 목록
		</div>
		<div class="qna-tab-div">
			<table class="table">
			  <thead class="thead-collie">
			    <tr>
			      <th scope="col">번호</th>
			      <th scope="col">제목</th>
			      <th scope="col">아이디</th>
			      <th scope="col">답변여부</th>
			    </tr>
			  </thead>
			  <tbody class="tbody-collie">
			  	<c:forEach begin="1" end="${qna_list.size()}" var="qna_cnt">
				    <tr style="cursor:pointer" onclick="gotoDetail(${qna_list[qna_cnt-1].qna_num});">
				      <th scope="row">${qna_cnt}</th>
				      <td>${qna_list[qna_cnt-1].qna_subject}</td>
				      <td>${qna_list[qna_cnt-1].id}</td>
				      <td>${qna_list[qna_cnt-1].qna_flag eq 'Y' ? 'O' : 'X'}</td>
				    </tr>
			  	</c:forEach>
			 </tbody>
			</table>
		</div>
	</div>
</div>

</body>
</html>