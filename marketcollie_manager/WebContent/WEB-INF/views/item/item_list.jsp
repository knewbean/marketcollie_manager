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
#contentwrap{display: flex; flex-direction:column; justify-content: center; width: 100%}

.qna-tab-div {margin: 0px auto; width:70%; padding: 1rem;}
.qna-subtitle {color:#77AF9C; margin: 0px auto; width:70%; text-align: center; font-weight: bold; font-size:1.5rem; padding-top:3rem;}
.thead-collie {color:#285943; background-color: #77AF9C; border-color: #77AF9C; text-align:center;}
.tbody-collie {text-align:center;}
.search{display: flex; justify-content: space-between; width:70%; margin: 0px auto;}
.cate{padding-left: 20px;
   	  padding-top: 20px;}
.type{height: 40px;
    margin-right: 5px;}
.btnWrap{}

#searchBox{	display:flex; 
			margin-left: inherit;
			padding-left: 20px;
    		padding-top: 20px}
#searchForm{width: 240px;     
			height: 40px;
    		margin-right: 5px; }
#searchFrm{display: flex;}
#searchBtn{height: 40px;
			margin-right: 20px;}	
</style>

<!-- Google CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<script type="text/javascript">
$(function(){
});//ready

function gotoDetail(item_num){
	location.href="detail.do?item_num="+item_num;
}
</script>
</head>
<body style="font-family: 'NanumBarunGothic'">
	
<div id="wrap">

	<c:import url="/header.do" /> 

	<div id="container">
		<div class="qna-subtitle">
			<img src="../common/images/icons/icon_qna_32.png"> 상품관리 
		</div>
		
		<div id="contentwrap">
		<div class="search">
			<div class="cate">
				<select class="form-control-sm">
					<option>채소</option>
					<option>정육</option>
					<option>과일</option>
					<option>빵</option>
					<option>유제품</option>
				</select>
			</div>
			
			<div id="searchBox">
				<select class="form-control-sm type">
					<option>상품 이름</option>
				</select>
				
				<form id="searchFrm">
				<input type="text" id="searchForm" class="form-control">
				<input type="button" id="searchBtn" value="검색">
				</form>
			</div>			
		</div>
		
		<div class="qna-tab-div">
			<table class="table">
			  <thead class="thead-collie">
			    <tr>
			      <th scope="col">카테고리</th>
			      <th scope="col">상품번호</th>
			      <th scope="col">상품명</th>
			      <th scope="col">가격</th>
			      <th scope="col">중량/용량</th>
			      <th scope="col">판매단위</th>
			      <th scope="col">재고</th>
			      <th scope="col">등록날짜</th>
			    </tr>
			  </thead>
			  <tbody class="tbody-collie">
			  	<c:forEach var="item" items="${ item_list}">
				    <tr style="cursor:pointer" onclick="togoDetail(${ item.item_num })">
				      <td><c:out value="${item.cate_name}"/></td>
				      <td><c:out value="${item.item_num}"/></td>
				      <td><c:out value="${item.item_name}"/></td>
				      <td><c:out value="${item.item_price}"/></td>
				      <td><c:out value="${item.item_weight}"/></td>
				      <td><c:out value="${item.item_unit}"/></td>
				      <td><c:out value="${item.item_stock}"/></td>
				      <td><c:out value="${item.input_date}"/></td>
				     
				    </tr>
			  	</c:forEach>
			 </tbody>
			</table>
			
			<div>
			
			</div>
		</div>
			
		</div>
	</div>
</div>

</body>
</html>