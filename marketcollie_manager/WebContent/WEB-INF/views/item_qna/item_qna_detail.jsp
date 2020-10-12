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
#container{ min-height: 800px }
.item_qna-subtitle {color:#5E7170; margin: 0px auto; width:70%; text-align: center; font-weight: bold; font-size:1.5rem; padding-top:3rem; margin-top: 30px }
.item_qna-tab-div {margin: 0px auto; width:70%; padding: 1rem; margin-top: 30px }
.table{ width: 800px; margin: 0px auto }
.thead-collie {color:#285943; background-color: #77AF9C; border-color: #77AF9C; text-align:center; font-weight: bold; width: 200px; vertical-align: middle !important }
.tbody-collie { border-color: none; }
.item_qna_value{ width: 600px; resize: none; vertical-align: middle !important }
#btnDiv{ width: 230px; margin: 0px auto }
.btn-primary{ background-color: #5E7170; border-color: #5E7170; margin:0px auto; margin-top: 50px; width: 100px; padding: 8px  }
.btn-primary:hover, .btn-primary:active, .btn-primary:focus{ background-color: #5E7170 !important; }
#updateBtn{ margin-left: 20px }
</style>

<!-- Google CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<script type="text/javascript">
$(function(){
	$("#updateBtn").click(function(){
		if( $("#item_qna_reply").val().trim() == "" || $("#item_qna_reply").val() == null ){
			alert("답변을 입력해주세요.");
			return;
		}//end if
		
		var param = $("form[name=updateForm]").serialize();
		if( confirm("답변을 등록하시겠습니까?") ){
			$.ajax({
				url : "../item_qna/update_reply.do",
				type : "POST",
				data : param,
				error : function(xhr){
					alert("error : " + xhr.status + " / " + xhr.statusText);
				},
				success : function(data){
					alert("답변이 등록되었습니다.");
					location.href = "../item_qna/list.do?item_num="+${ param.item_num }+"&current_page="+${ param.current_page };
				}//data
			});//ajax			
		}//end if
	});//click
});//ready

function moveToBack(item_num, current_page){
	location.href = "../item_qna/list.do?item_num="+item_num+"&current_page="+current_page;
}//moveToBack

</script>
</head>
<body style="font-family: 'NanumBarunGothic'">
	
<div id="wrap">

	<c:import url="/header.do" /> 

	<div id="container">
		<div class="item_qna-subtitle">
			상품문의 목록
		</div>
			<form id="updateForm" name="updateForm">
			<div class="item_qna-tab-div">
				<table class="table">
				  <tbody class="tbody-collie">
				    <tr>
				      <td class="thead-collie">아이디</td>
				      <td class="item_qna_value">${ item_qna_detail.id }</td>
				    </tr>
				    <tr>
				      <td class="thead-collie">이메일</td>
				      <td class="item_qna_value">${ item_qna_detail.email }</td>
				    </tr>
				    <tr>
				      <td class="thead-collie">연락처</td>
				      <td class="item_qna_value">${ item_qna_detail.phone }</td>
				    </tr>
				    <tr>
				      <td class="thead-collie">제목</td>
				      <td class="item_qna_value">${ item_qna_detail.item_qna_subject }</td>
				    </tr>
				    <tr>
				      <td class="thead-collie">내용</td>
				      <td class="item_qna_value">
				      	<textarea class="item_qna_value" rows="5" cols="50" readonly="readonly">${ item_qna_detail.item_qna_content }</textarea>
				      </td>
				    </tr>
				    <tr>
				      <td class="thead-collie">답변</td>
				      <td class="item_qna_value">
				      	<textarea id="item_qna_reply" name="item_qna_reply" value="${ item_qna_detail.item_qna_reply }" class="item_qna_value" rows="5" cols="50">${ item_qna_detail.item_qna_reply }</textarea>
				      </td>
				    </tr>
				  </tbody>
				 </table>
				<input type="hidden" name="item_qna_num" value="${ param.item_qna_num }"/>
			</div>
			</form>	
			<div id="btnDiv">
				<button type="button" class="btn btn-primary" onclick="moveToBack(${ param.item_num }, ${ param.current_page });">뒤로</button>
				<button type="button" class="btn btn-primary" id="updateBtn">
					<c:if test="${ empty item_qna_detail.item_qna_reply }">등록</c:if>
					<c:if test="${ not empty item_qna_detail.item_qna_reply }">수정</c:if>
				</button>
			</div>			
	</div>
</div>

</body>
</html>