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
.review-subtitle {color:#5E7170; margin: 0px auto; width:70%; text-align: center; font-weight: bold; font-size:1.5rem; padding-top:3rem; margin-top: 30px}
.review-tab-div {margin: 0px auto; width:70%; padding: 1rem; margin-top: 10px}
.thead-collie {color:#285943; background-color: #77AF9C; border-color: #77AF9C; text-align:center;}
.tbody-collie {text-align:center;}
#btnDiv{ width: 100px; margin: 0px auto }
.btn-primary{ background-color: #5E7170; border-color: #5E7170; margin:0px auto; margin-top: 30px; width: 100px; padding: 8px  }
.btn-primary:hover, .btn-primary:active, .btn-primary:focus{ background-color: #5E7170 !important; }
.pagination{ width:280px; margin: 0px auto; margin-top: 60px}
.page-link{ color: #333 !important }
</style>

<!-- Google CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<script type="text/javascript">
$(function(){

});//ready

function gotoDetail(review_num){
	location.href="detail.do?review_num="+review_num;
}
</script>
</head>
<body style="font-family: 'NanumBarunGothic'">
	
<div id="wrap">

	<c:import url="/header.do" /> 

	<div id="container">
		<div class="review-subtitle">
			상품문의 목록
		</div>
		<div class="review-tab-div">
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
				    <tr style="cursor:pointer" onclick="gotoDetail();">
				      <th scope="row">1</th>
				      <td>브로콜리 한개밖에안왔는데요?</td>
				      <td>gildong</td>
				      <td>N</td>
				    </tr>
				    <tr style="cursor:pointer" onclick="gotoDetail();">
				      <th scope="row">2</th>
				      <td>환불요청합니다.</td>
				      <td>test1</td>
				      <td>Y</td>
				    </tr>
				    <tr style="cursor:pointer" onclick="gotoDetail();">
				      <th scope="row">1</th>
				      <td>브로콜리 한개밖에안왔는데요?</td>
				      <td>gildong</td>
				      <td>N</td>
				    </tr>
				    <tr style="cursor:pointer" onclick="gotoDetail();">
				      <th scope="row">2</th>
				      <td>환불요청합니다.</td>
				      <td>test1</td>
				      <td>Y</td>
				    </tr>
				    <tr style="cursor:pointer" onclick="gotoDetail();">
				      <th scope="row">2</th>
				      <td>환불요청합니다.</td>
				      <td>test1</td>
				      <td>Y</td>
				    </tr>
			 </tbody>
			</table>
		</div>
		<div id="btnDiv">
			<button type="button" class="btn btn-primary" id="btn" onclick="javascript:history.back();">뒤로</button>
		</div>
		<div id="pagination">
		<nav aria-label="...">
		  <ul class="pagination">
		    <li class="page-item disabled">
		      <a class="page-link" href="#" tabindex="-1" aria-disabled="true">Previous</a>
		    </li>
		    <li class="page-item"><a class="page-link" href="#">1</a></li>
		    <li class="page-item active" aria-current="page">
		      <a class="page-link" href="#">2 <span class="sr-only">(current)</span></a>
		    </li>
		    <li class="page-item"><a class="page-link" href="#">3</a></li>
		    <li class="page-item">
		      <a class="page-link" href="#">Next</a>
		    </li>
		  </ul>
		</nav>
		</div>
	</div>
</div>

</body>
</html>