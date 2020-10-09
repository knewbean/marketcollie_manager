<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/mgr/common/css/common.css">

<style type="text/css">
#container{ min-height: 900px }
.review-subtitle {color:#5E7170; margin: 0px auto; width:70%; text-align: center; font-weight: bold; font-size:1.5rem; padding-top:3rem; margin-top: 30px}
.review-tab-div {margin: 0px auto; width:70%; padding: 1rem; margin-top: 10px}
.table{ width: 1000px; margin: 0px auto }
.thead-collie {color:#285943; background-color: #77AF9C; border-color: #77AF9C; text-align:center;}
.tbody-collie {text-align:center;}
#btnDiv{ width: 100px; margin: 0px auto }
.btn-primary{ background-color: #5E7170; border-color: #5E7170; margin:0px auto; margin-top: 30px; width: 100px; padding: 8px  }
.btn-primary:hover, .btn-primary:active, .btn-primary:focus{ background-color: #5E7170 !important; }
.pagination{ width:280px; margin: 0px auto; margin-top: 60px}
.active {cursor:pointer;}
.page-item.active .page-link {background-color:#17462B; border-color:#17462B;}
</style>

<!-- Google CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<script type="text/javascript">
$(function(){
	
});//ready

function gotoDetail(current_page, review_num){
	if ( current_page == '' ){
		var current_page = 1;
	}//end if
	location.href="detail.do?item_num="+${ param.item_num }+"&current_page="+current_page+"&review_num="+review_num;
}//gotoDetail

function movePage(current_page, item_num){
	$.ajax({
		url : "move_review_list.do",
		type : "POST", 
		data : "item_num="+ ${ param.item_num } +"&current_page="+current_page,
		dataType : "JSON",
		error : function(xhr){
			alert("error : " + xhr.status + " / " + xhr.statusText);
		},
		success : function(jsonObj){
			if( jsonObj.flag == "success" ){
				var output = '<table class="table"><thead class="thead-collie">';
				output += '<tr><th scope="col" style="width: 100px">번호</th>';
				output += '<th scope="col" style="width: 500px">제목</th>';
				output += '<th scope="col" style="width: 200px">아이디</th>';
				output += '<th scope="col" style="width: 300px">작성일</th></tr></thead>';
				output += '<tbody class="tbody-collie">';
				
				$.each(jsonObj.review_list, function(i, json){
					output += '<tr style="cursor:pointer" onclick="gotoDetail(' + current_page + ', ' + json.review_num + ');">';
					output += '<th scope="row">'+ json.review_num +'</th>';
					output += '<td>'+ json.review_subject + '</td>';
					output += '<td>'+ json.id + '</td>';
					output += '<td>' + json.input_date.substring(0,10) + '</td></tr>';
				});//each
	
				output += '</tbody></table>';
				$("#review-tab-div").html(output);
				
				$("#pagination").html(jsonObj.paging);
			}//end if
		}//success
	});//ajax
}//movePage

function moveToBack(){
	location.href = "../item/item_list.do";
}//moveToBack

</script>
</head>
<body style="font-family: 'NanumBarunGothic'">
	
<div id="wrap">

	<c:import url="/header.do" /> 

	<div id="container">
		<div class="review-subtitle">
			상품후기 목록
		</div>
		<div class="review-tab-div" id="review-tab-div">
			<table class="table">
			  <thead class="thead-collie">
			    <tr>
			      <th scope="col" style="width: 100px">번호</th>
			      <th scope="col" style="width: 500px">제목</th>
			      <th scope="col" style="width: 200px">아이디</th>
			      <th scope="col" style="width: 300px">작성일</th>
			    </tr>
			  </thead>
			  <tbody class="tbody-collie">
			  	<c:forEach var="mrld" items="${ review_list }">
				    <tr style="cursor:pointer" onclick="gotoDetail('${ param.current_page }', ${ mrld.review_num });">
				      <th scope="row">${ mrld.review_num }</th>
				      <td>${ mrld.review_subject }</td>
				      <td>${ mrld.id }</td>
				      <td>${ fn:substring(mrld.input_date, 0, 10) }</td>
				    </tr>
			  	</c:forEach>
			 </tbody>
			</table>
		</div>
		<div id="btnDiv">
			<button type="button" class="btn btn-primary" id="btn" onclick="moveToBack();">뒤로</button>
		</div>
		<div id="pagination">
			<c:out value="${ paging }" escapeXml="false"/>
		</div>
	</div>
</div>

</body>
</html>