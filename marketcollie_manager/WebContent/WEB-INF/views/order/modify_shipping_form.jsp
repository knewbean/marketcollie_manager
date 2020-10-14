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
	
	$("#modifyBtn").click(function(){
		
		if($("#invoice_no").val().trim()==""){
			alert("운송장번호를 입력해주세요");
			$("#invoice_no").focus();
			return;
		}//end if
		if($("#invoice_no").val().replace(/[0-9]/g, "") != ""){
			alert("운송장번호는 숫자만 입력 가능합니다.");
			$("#invoice_no").val("");
			$("#invoice_no").focus();
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
			배송상태 변경
		</div>
		
		<div class="tab-div" id="cateTableDiv">
	      <form action="add_cate_process.do?currnet_page=${param.current_page}" method="post" id="cateAddFrm">
	      <input type="hidden" name="order_num" value="${ param.order_num }"/>
	      <input type="hidden" name="current_page" value="${ current_page }"/>
			<table class="table">
			  <tbody class="tbody-collie">
			    <tr>
			    <th style="width: 250px; padding-top: 18px">주문번호</th>
			    <td><c:out value="${ param.order_num }"/></td>
			    </tr>
			    <tr>
			    <th style="width: 250px; padding-top: 18px">배송상태</th>
			    <td><c:out value="${ shipping.shipping_flag }"/></td>
			    </tr>
			    <tr>
			      <th style="width: 250px; padding-top: 18px">택배사</th>
			      <td style="width: 200px; ">
			      <select name="company">
			      	<option value="01"<c:if test="${ shipping.company eq '01' }"> selected="selected"</c:if>>우체국택배</option>
			      	<option value="04"<c:if test="${ shipping.company eq '04' }"> selected="selected"</c:if>>대한통운</option>
			      	<option value="05"<c:if test="${ shipping.company eq '05' }"> selected="selected"</c:if>>한진택배</option>
			      	<option value="06"<c:if test="${ shipping.company eq '06' }"> selected="selected"</c:if>>로젠택배</option>
			      	<option value="08"<c:if test="${ shipping.company eq '08' }"> selected="selected"</c:if>>롯데택배</option>
			      </select>
			      </td>
			    </tr>
			    <tr>
			      <th style="padding-top: 18px">운송장번호</th>
			      <td>
			      <input type="text" id="invoice_no" name="invoice_no" value="${ shipping.invoice_no }"/>
			      </td>
			    </tr>
			 </tbody>
			</table>
	      </form>
		</div>
		
		<div class="btn-div">
		<input type="button" value="변경" id="modifyBtn" class="collieBtnMain">
		</div>
		
	</div>
</div>

</body>
</html>