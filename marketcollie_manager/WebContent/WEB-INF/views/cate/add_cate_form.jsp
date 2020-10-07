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
.tab-div {margin: 0px auto; width:40%; padding: 1rem;}
.table{ width: 400px; margin: 0px auto; }
.thead-collie {color:#285943; background-color: #77AF9C; border-color: #77AF9C; text-align:center;}
.tbody-collie {text-align:center;}
.btn-div {margin: 0px auto; width:400px; padding: 10px 0px 10px 0px; text-align: right;}
.collieBtnMain{ border: 1px solid #77AF9C; padding: 10px 10px 10px 10px; margin-top: 5px; margin-bottom: 5px; color: #285943; font-size: 15px; background-color: #77AF9C }
.collieText{ width: 300px; padding: 5px; font-size: 15px; }
</style>

<link rel="stylesheet" type="text/css" href="/mgr/common/css/common.css">
<!-- Google CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<script type="text/javascript">
$(function(){
	
	$("#cateAddBtn").click(function(){
		
		if($("#cate_name").val().trim()==""){
			alert("카테고리 이름을 입력해주세요");
			$("#cate_name").focus();
			return;
		}//end if
		if($("#cate_name").val().replace(/[ㄱ-힣A-Za-z]/g, "") != ""){
			alert("카테고리 이름은 한글 또는 영문(대,소문자)만 입력 가능합니다.");
			$("#cate_name").val("");
			$("#cate_name").focus();
			return;
		}//end if
		
		$("#cateAddFrm").submit();
		
	});//click
	
});//ready

</script>
</head>
<body>
	
<div id="wrap">

	<c:import url="/header.do" /> 

	<div id="container">
		
		<div class="subtitle">
			카테고리 추가
		</div>
		
		<div class="tab-div" id="cateTableDiv">
			<table class="table">
			  <tbody class="tbody-collie">
			    <tr>
			      <th style="width: 200px; padding-top: 18px">이름</th>
			      <td style="width: 200px; ">
			      <form action="add_cate_process.do" method="post" id="cateAddFrm">
			      <input type="text" id="cate_name" name="cate_name" class="collieText"/>
			      <input type="text" hidden="hidden"/>
			      </form>
			      </td>
			    </tr>
			 </tbody>
			</table>
		</div>
		
		<div class="btn-div">
		<input type="button" value="추가" id="cateAddBtn" class="collieBtnMain">
		</div>
		
		<div id="pagination">
		<c:out value="${ paging }" escapeXml="false"/>
		</div>
		
	</div>
</div>

</body>
</html>