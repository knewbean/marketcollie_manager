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
.tab-div {margin: 0px auto; width:60%; padding: 1rem;}
.table{ width: 720px; margin: 0px auto; }
.thead-collie {color:#285943; background-color: #77AF9C; border-color: #77AF9C; text-align:center;}
.tbody-collie {text-align:center;}
.btn-div {margin: 0px auto; width:400px; padding: 10px 0px 10px 0px; text-align: right;}
.collieBtnMain{ border: 1px solid #77AF9C; padding: 10px 10px 10px 10px; margin-top: 5px; margin-bottom: 5px; color: #285943; font-size: 15px; background-color: #77AF9C }

.active {cursor:pointer;}
.page-item.active .page-link {background-color:#fff; border-color:#77AF9C;  color:#77AF9C; border-radius: 0}
.page-item.disabled .page-link {background-color:#fff; border-color:#77AF9C; color:#77AF9C; border-radius: 0}
</style>

<link rel="stylesheet" type="text/css" href="/mgr/common/css/common.css">
<!-- Google CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<script type="text/javascript">
$(function(){
});//ready

function movePage(current_page){
	
	$.ajax({
		url:"move_list.do",
		type:"POST",
		data:"current_page="+current_page,
		dataType:"JSON",
		error:function(xhr){
			alert("에러");
			console.log(xhr.status+" / "+xhr.statusText);
		},
		success:function(jsonObj){
	      	if(jsonObj.flag=="success"){
	      		
	      		var tab='<table class="table">';
	      		tab+='<thead class="thead-collie">';
	      		tab+='<tr>';
	      		tab+='<th style="width: 70px; ">번호</th>';
	      		tab+='<th style="width: 200px; ">아이디</th>';
	      		tab+='<th style="width: 150px; ">이름</th>';
	      		tab+='<th style="width: 150px; ">휴대폰</th>';
	      		tab+='<th style="width: 150px; ">가입일자</th>';
	      		tab+='</tr>';
	      		tab+='</thead>';
	      		tab+='<tbody class="tbody-collie">';
	      		$.each(jsonObj.mem_list,function(i, json){
		      		tab+='<tr style="cursor: pointer;" onclick="showMemDetail('+json.member_num+')">';
		      		tab+='<th>';
		      		tab+=json.member_num;
		      		tab+='</th>';
		      		tab+='<td>';
		      		tab+=json.id;
		      		tab+='</td>';
		      		tab+='<td>';
		      		tab+=json.name;
		      		tab+='</td>';
		      		tab+='<td>';
		      		tab+=json.phone;
		      		tab+='</td>';
		      		tab+='<td>';
		      		tab+=json.input_date;
		      		tab+='</td>';
		      		tab+='</tr>';
	      		});//each
	      		
	      		tab+='</tbody>';
	      		tab+='</table>';
	      		
	      		$("#memTableDiv").html(tab);
	      		$("#pagination").html(jsonObj.paging);
	      	}//end if
		}//success
	});//ajax
	
}//movePage

function showMemDetail(member_num){
	
	location.href="detail.do?member_num="+member_num;
	
}//showMemDetail

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
			  <thead class="thead-collie">
			    <tr>
			      <th style="width: 70px; ">번호</th>
			      <th style="width: 200px; ">아이디</th>
			      <th style="width: 150px; ">이름</th>
			      <th style="width: 150px; ">휴대폰</th>
			      <th style="width: 150px; ">가입일자</th>
			    </tr>
			  </thead>
			  <tbody class="tbody-collie">
			  	<c:forEach var="mem" items="${ member_list }">
				    <tr style="cursor: pointer;" onclick="showMemDetail(${ mem.member_num })">
				      <th><c:out value="${ mem.member_num }"/></th>
				      <td><c:out value="${ mem.id }"/></td>
				      <td><c:out value="${ mem.name }"/></td>
				      <td><c:out value="${ mem.phone }"/></td>
				      <td><c:out value="${ mem.input_date }"/></td>
				    </tr>
			  	</c:forEach>
			 </tbody>
			</table>
		</div>
		
		<div id="pagination">
		<c:out value="${ paging }" escapeXml="false"/>
		</div>
		
	</div>
</div>

</body>
</html>