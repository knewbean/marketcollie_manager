<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="관리자 메인 페이지"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<style type="text/css">

.subtitle {color:#77AF9C; margin: 0px auto; width:70%; text-align: center; font-weight: bold; font-size:1.5rem; padding-top:3rem;}
.tab-div {margin: 0px auto; width:80%; padding: 1rem;}
.table{ width: 800px; margin: 0px auto; }
.table td, .table th{ vertical-align: middle; }
.thead-collie {color:#285943; background-color: #77AF9C; border-color: #77AF9C; text-align:center;}
.tbody-collie {text-align:center;}
.btn-div {margin: 0px auto; width:400px; padding: 10px 0px 10px 0px; text-align: right;}
.collieBtnMain{ border: 1px solid #77AF9C; padding: 5px 5px 5px 5px; color: #285943; font-size: 12px; font-weight: bold; background-color: #77AF9C }

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

var c_page=1;
function movePage(current_page){
	c_page=	current_page;
	$.ajax({
		url:"move_order_list.do",
		type:"POST",
		data:"current_page="+c_page,
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
	      		tab+='<th style="width: 100px; ">주문 번호</th>';
	      		tab+='<th style="width: 100px; ">회원 번호</th>';
	      		tab+='<th style="width: 150px; ">주문 금액</th>';
	      		tab+='<th style="width: 150px; ">배송 여부</th>';
	      		tab+='<th style="width: 150px; ">주문 일자</th>';
	      		tab+='<th style="width: 150px; "></th>';
	      		tab+='</tr>';
	      		tab+='</thead>';
	      		tab+='<tbody class="tbody-collie">';
	      		$.each(jsonObj.order_list,function(i, json){
		      		tab+='<tr onclick="orderDetail('+json.order_num+')" style="cursor: pointer;">';
		      		tab+='<td>';
		      		tab+=json.order_num;
		      		tab+='</td>';
		      		tab+='<td>';
		      		tab+=json.member_num;
		      		tab+='</td>';
		      		tab+='<td>';
		      		tab+=(json.total_price * 1).toLocaleString();
		      		tab+='</td>';
		      		tab+='<td>';
		      		tab+=json.shipping_flag;
		      		tab+='</td>';
		      		tab+='<td>';
		      		tab+=json.input_date;
		      		tab+='</td>';
		      		tab+='<td>';
		      		tab+='<input type="button" value="배송정보 변경" onclick="modifyShipping('+json.order_num+')" class="collieBtnMain"/>';
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

function modifyShipping(orderNum){
	location.href="modify_shipping_form.do?order_num="+orderNum+"&current_page="+c_page;
}//modifyShipping

function orderDetail(orderNum){
	location.href="detail.do?order_num="+orderNum+"&current_page="+c_page;
}//modifyShipping

</script>
</head>
<body>
	
<div id="wrap">

	<c:import url="/header.do" /> 

	<div id="container">
		
		<div class="subtitle">
			주문 관리
		</div>
		
		<div class="tab-div" id="cateTableDiv">
			<table class="table">
			  <thead class="thead-collie">
			    <tr>
			      <th style="width: 100px; ">주문 번호</th>
			      <th style="width: 100px; ">회원 번호</th>
			      <th style="width: 150px; ">주문 금액</th>
			      <th style="width: 150px; ">배송 여부</th>
			      <th style="width: 150px; ">주문 일자</th>
			      <th style="width: 150px; "></th>
			    </tr>
			  </thead>
			  <tbody class="tbody-collie">
			  	<c:forEach var="order" items="${ order_list }">
				    <tr onclick="orderDetail(${order.order_num})" style="cursor: pointer;">
				      <td>
				      <c:out value="${ order.order_num }"/>
				      </td>
				      <td><c:out value="${ order.member_num }"/></td>
				      <td><fmt:formatNumber pattern="#,###" value="${ order.total_price }"/></td>
				      <td><c:out value="${ order.shipping_flag }"/></td>
				      <td><c:out value="${ order.input_date }"/></td>
				      <td>
				      	<input type="button" value="배송정보 변경" onclick="modifyShipping(${ order.order_num })" class="collieBtnMain"/>
				      </td>
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