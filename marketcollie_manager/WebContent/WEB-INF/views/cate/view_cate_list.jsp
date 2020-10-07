<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="관리자 메인 페이지"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

.qna-tab-div {margin: 0px auto; width:40%; padding: 1rem;}
.qna-subtitle {color:#77AF9C; margin: 0px auto; width:70%; text-align: center; font-weight: bold; font-size:1.5rem; padding-top:3rem;}
.thead-collie {color:#285943; background-color: #77AF9C; border-color: #77AF9C; text-align:center;}
.tbody-collie {text-align:center;}

</style>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
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
		url:"move_cate_list.do",
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
	      		tab+='<th>번호</th>';
	      		tab+='<th>이름</th>';
	      		tab+='</tr>';
	      		tab+='</thead>';
	      		tab+='<tbody class="tbody-collie">';
	      		$.each(jsonObj.cate_list,function(i, json){
		      		tab+='<tr>';
		      		tab+='<th>';
		      		tab+=json.cate_num;
		      		tab+='</th>';
		      		tab+='<td>';
		      		tab+=json.cate_name;
		      		tab+='</td>';
		      		tab+='</tr>';
	      		});//each
	      		
	      		tab+='</tbody>';
	      		tab+='</table>';
	      		
	      		$("#cateTableDiv").html(tab);
	      		$("#pagination").html(jsonObj.paging);
	      	}//end if
		}//success
	});//ajax
	
}//movePage

</script>
</head>
<body>
	
<div id="wrap">

	<c:import url="/header.do" /> 

	<div id="container">
		
		<div class="qna-subtitle">
			카테고리 관리
		</div>
		
		<div class="qna-tab-div" id="cateTableDiv">
			<table class="table">
			  <thead class="thead-collie">
			    <tr>
			      <th>번호</th>
			      <th>이름</th>
			    </tr>
			  </thead>
			  <tbody class="tbody-collie">
			  	<c:forEach var="cate" items="${ cate_list }">
				    <tr>
				      <th><c:out value="${ cate.cate_num }"/></th>
				      <td><c:out value="${ cate.cate_name }"/></td>
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