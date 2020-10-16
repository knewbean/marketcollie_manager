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
.active {cursor:pointer;}
.page-item.active .page-link {background-color:#fff; border-color:#77AF9C;  color:#77AF9C; border-radius: 0}
.page-item.disabled .page-link {background-color:#fff; border-color:#77AF9C; color:#77AF9C; border-radius: 0}
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

function movePage(current_page){
	$.ajax({
		url:"move_list.do",
		type:"POST",
		data:"current_page="+current_page,//where절이 있는경우 &을 사용하여 쿼리스트링 추가
		dataType:"JSON",
		error:function(xhr){
			alert("에러");
			console.log(xhr.status+" / "+xhr.statusText);
		},
		success:function(jsonObj){
	      	if(jsonObj.flag=="success"){
	      		//테이블을 그린다
	      		var tab='<table class="table">';
	      		tab+='<thead class="thead-collie">';
	      		tab+='<tr>';
	      		tab+='<th scope="col" style="width:10%">번호</th>';
			    tab+='<th scope="col" style="width:60%">제목</th>';
			    tab+='<th scope="col" style="width:20%">아이디</th>';
			    tab+='<th scope="col" style="width:10%">답변여부</th>';
	      		tab+='</tr>';
	      		tab+='</thead>';
	      		tab+='<tbody class="tbody-collie">';
	      		$.each(jsonObj.qna_list,function(i, json){
		      		tab+='<tr style="cursor:pointer" onclick="gotoDetail('+(json.qna_num)+');">';
		      		tab+='<th scope="row">';
		      		tab+=(i+1);
		      		tab+='</th>';
		      		tab+='<td>'
		      		tab+=json.qna_subject;
		      		tab+='</td>';
		      		tab+='<td>';
		      		tab+=json.id;
		      		tab+='</td>';
		      		tab+='<td>';
		      		if(json.qna_flag != 'Y') {
			      		tab+='X';
		      		} else {
		      			tab+='O'
		      		}
		      		tab+='</td>';
		      		tab+='</tr>';
	      		});//each
	      		
	      		tab+='</tbody>';
	      		tab+='</table>';
	      		//새로 그린 테이블을 div에 넣는다
	      		$("#qnaTabDiv").html(tab);
			//페이지네이션을 그리는 코드는 따로 작성할 필요 없이 바로 div에 넣으면 된다.
	      		$("#pagination").html(jsonObj.paging);
	      	}//end if
		}//success
	});//ajax
	
}//movePage

</script>
</head>
<body style="font-family: 'NanumBarunGothic'">
	
<div id="wrap">

	<c:import url="/header.do" /> 

	<div id="container">
		<div class="qna-subtitle">
			<img src="../common/images/icons/icon_qna_32.png"> 문의사항 목록
		</div>
		<div class="qna-tab-div" id="qnaTabDiv">
			<table class="table">
			  <thead class="thead-collie">
			    <tr>
			      <th scope="col" style="width:10%">번호</th>
			      <th scope="col" style="width:60%">제목</th>
			      <th scope="col" style="width:20%">아이디</th>
			      <th scope="col" style="width:10%">답변여부</th>
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
		
		<div id="pagination">
			<c:out value="${paging}" escapeXml="false" />
		</div>
		
	</div>
</div>

</body>
</html>