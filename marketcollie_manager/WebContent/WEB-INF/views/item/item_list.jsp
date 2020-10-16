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

.item-tab-div {margin: 0px auto; width:70%; padding: 1rem; display: flex;}
.item-subtitle {color:#77AF9C; margin: 0px auto; width:70%; text-align: center; font-weight: bold; font-size:1.5rem; padding-top:3rem;}
.thead-collie {color:#285943; background-color: #77AF9C; border-color: #77AF9C; text-align:center;}
.tbody-collie {text-align:center;}
.search {	display: flex; justify-content: space-between; width:70%; margin: 0px auto;}
.cate {	padding-left: 20px;
   	   	padding-top: 20px;}
.type {	height: 40px;}
.collieBtnMain{ border: 1px solid #77AF9C; padding: 10px 10px 10px 10px;color: #285943; font-size: 15px; background-color: #77AF9C }
.collieBtnItem{ border: 1px solid #77AF9C; text-align:center; padding: 10px 10px 10px 10px;color: #285943; font-size: 15px; background-color: #77AF9C }
.collieBtnR{ border: 1px solid #77AF9C; text-align:center; color: #285943; font-size: 18px; background-color: #77AF9C }
.itemName{width: 450px;}
.btn
#searchBox{	display:flex; 
			margin-left: inherit;
    		padding-top: 20px}
#search_word{width: 240px;     
			 height: 40px;
    		 margin-right: 5px;
    		 margin-left: 5px; }
#searchBtn{	height: 40px;
			margin-right: 20px;}
#addDiv { width: 70%;
   		  margin: 0px auto;
		  text-align: right;
		  margin-bottom: 50px;
}	
</style>

<!-- Google CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<script type="text/javascript">
$(function(){
	
	
	
});//ready
	

function searchItem(current_page){
	
	var cate_name = $("#cate_name option:selected").val();
	var search_word = $("#search_word").val();
	
      $.ajax({ /* async:false, */
          url:"item_search_list.do",
          type:"GET",
          data:"cate_name="+cate_name+"&search_word="+search_word+"&current_page="+current_page,
          dataType:"JSON",
          error:function(xhr){
             alert("에러" + xhr.status + " / " + xhr.statusText);
             console.log(xhr.status+" / "+xhr.statusText);
          },

		success:function(jsonObj){
			if(jsonObj.flag=="success"){
				var table='<table class="table">';
					table+='<thead class="thead-collie">';
					table+='<tr>';
					table+='<th scope="col" style="width:116px ">카테고리</th>';
					table+='<th scope="col" style="width:111px ">상품번호</th>';
					table+='<th scope="col" style="width:457px">상품명</th>';
					table+='<th scope="col" style="width:100px">가격</th>';
					table+='<th scope="col" style="width: 150px">중량/용량</th>';
					table+='<th scope="col" style="width:117px">판매단위</th>';
					table+='<th scope="col" style="width: 80px">재고</th>';
					table+='<th scope="col" style="width: 169px">등록날짜</th>';
					table+='<th scope="col" style="width: 103px"></th>';
					table+='</tr>';
					table+='</thead>';
					table+='<tbody class="tbody-collie">';
					
					$.each(jsonObj.item_list, function(i,json) {
						table+='<tr>';
						table+='<td>'+json.cate_name+'</td>';
						table+='<td>'+json.item_num+'</td>';
						table+='<td style="cursor:pointer" onclick="togoDetail('+json.item_num+')">'+json.item_name+'</td>';
						table+='<td>'+json.item_price+'</td>';
						table+='<td>'+json.item_weight+'</td>';
						table+='<td>'+json.item_unit+'</td>';
						table+='<td>'+json.item_stock+'</td>';
						table+='<td>'+json.input_date+'</td>';
						table+='<td class="btn"><input type="button" id="reviewBtn" value="상품후기" class="collieBtnR" onclick="itemReview(${item.item_num})" ></td>';
						table+='</tr>';
					})//each						
					
					table+='</tbody>';
			        table+='</table>';
			        $(".item-tab-div").html(table);
					$("#pagination").html(jsonObj.paging)
			}//end if
		
		}//success	
	});//ajax
}//searchItem

function movePage(current_page){
	searchItem(current_page);
}//movePage

function togoDetail(item_num){
	location.href="detail.do?item_num="+item_num;
}

function addItem() {
	location.href="add_form.do";
	
}

function itemReview(item_num) {
		location.href="../review/list.do?item_num="+item_num;
}


</script>
</head>
<body style="font-family: 'NanumBarunGothic'">
	
<div id="wrap">

	<c:import url="/header.do" /> 

	<div id="container">
		<div class="item-subtitle">
			<img src="../common/images/icons/icon_qna_32.png"> 상품관리 
		</div>
		
		<div id="contentwrap">
		<div class="search">
			<div class="cate">
				
					<select class="form-control" id="cate_name" name="cate_name">
					<option value="">전체</option>
					<c:forEach items="${ cate_list }" var="cate">
						<option value="${ cate.cate_name }"><c:out value="${ cate.cate_name }"/></option>
					</c:forEach>
					</select>
			</div>
			
			<div id="searchBox" style="display:flex; ">
				<select class="form-control .type" style="width: 120px; margin-top: 1px">
					<option>상품 이름</option>
				</select>
				
				<input type="text" id="search_word" name="search_word" class="form-control">
				<input type="button" id="searchBtn" class="collieBtnMain" value="검색" onclick="searchItem(${ empty param.currnet_page ? '1':param.currnet_page })">
			</div>			
		</div>
		
		<div class="item-tab-div">
			<table class="table">
			  <thead class="thead-collie">
			    <tr>
			      <th scope="col" style="width:116px ">카테고리</th>
			      <th scope="col" style="width:111px ">상품번호</th>
			      <th scope="col" style="width:457px">상품명</th>
			      <th scope="col" style="width:100px ">가격</th>
			      <th scope="col" style="width: 150px">중량/용량</th>
			      <th scope="col" style="width:117px ">판매단위</th>
			      <th scope="col" style="width: 80px">재고</th>
			      <th scope="col" style="width: 169px">등록날짜</th>
			      <th scope="col" style="width: 103px"></th>
			    </tr>
			  </thead>
			  <tbody class="tbody-collie">
			  	<c:forEach var="item" items="${ item_list}">
				    <tr>
				      <td><c:out value="${item.cate_name}"/></td>
				      <td><c:out value="${item.item_num}"/></td>
				      <td style="cursor:pointer" onclick="togoDetail(${ item.item_num })"><c:out value="${item.item_name}"/></td>
				      <td><c:out value="${item.item_price}"/></td>
				      <td><c:out value="${item.item_weight}"/></td>
				      <td><c:out value="${item.item_unit}"/></td>
				      <td><c:out value="${item.item_stock}"/></td>
				      <td><c:out value="${item.input_date}"/></td>
				      <td class="btn"><input type="button" id="reviewBtn" value="상품후기" class="collieBtnR" onclick="itemReview(${item.item_num})" ></td>
				    </tr>
			  	</c:forEach>
			 </tbody>
			</table>
			
			<div>
			</div>
		</div>
		<div id="addDiv">
			<input type="button" id="addBtn" value="등록" class="collieBtnItem" onclick="addItem()" >
		</div>
		
		<div id="pagination">
		<c:out value="${ paging }" escapeXml="false"/>
		</div>
			
		</div>
	</div>
</div>

</body>
</html>