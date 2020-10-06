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
.tbody-collie { border-color: none;}
.last {border-bottom: 1px solid #dee2e6;}
.qna-detail-buttons {margin: 0px auto; text-align:center;}
.qna-detail-btn{ background-color: #77AF9C;  border: none;  text-decoration: none; color:#285943;
				 padding-left:1.5rem; padding-right:1.5rem; padding-top:1rem; padding-bottom:1rem;
				 margin-left:2rem; margin-top:1rem; margin-right:2rem; margin-bottom:2rem;}
.qna-detail-ta {width: -webkit-fill-available; resize: none; height: 10rem;}
</style>

<!-- Google CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<script type="text/javascript">
$(function(){
});//ready

function modifyQna(){
	$("#qnafrm").submit();
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
		<form id="qnafrm" action="modify_reply.do" method="POST">
			<div class="qna-tab-div">
				<table class="table">
				  <tbody class="tbody-collie">
				    <tr>
				      <td class="thead-collie">아이디</td>
				      <td>${qna_info.id}</td>
				    </tr>
				    <tr>
				      <td class="thead-collie">이메일</td>
				      <td>${qna_info.email}</td>
				    </tr>
				    <tr>
				      <td class="thead-collie">연락처</td>
				      <td>${qna_info.phone}</td>
				    </tr>
				    <tr>
				      <td class="thead-collie">제목</td>
				      <td>${qna_info.qna_subject}</td>
				    </tr>
				    <tr>
				      <td class="thead-collie">내용</td>
				      <td><textarea disabled="disabled" class="qna-detail-ta">${qna_info.qna_content}</textarea></td>
				    </tr>
				    <tr style="border-bottom: 1px solid #dee2e6;">
				      <td class="thead-collie last">답변</td>
				      <td><textarea class="qna-detail-ta" name="qna_reply">${qna_info.qna_reply}</textarea></td>
				    </tr>
				  </tbody>
				 </table>
			</div>
			<div class="qna-detail-buttons">
				<input type="button" value="뒤로" onclick="javascript:history.back();"class="qna-detail-btn"/>
				<input type="button" value="수정" onclick="modifyQna()"class="qna-detail-btn"/>
			</div>
			<input type="hidden" name="qna_num" value="${param.qna_num}"/>
		</form>
	</div>
</div>

</body>
</html>