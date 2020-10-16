<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마켓콜리</title> 
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/mgr/common/css/common.css">

<style type="text/css"> 
#container{ width: 70%; margin: 0px auto; min-height: 700px; margin-top:50px; }
.collie_font {color:#285943; border-color: #77AF9C; }
hr{ margin-top: 40px; }
td{ width:100px; font-size: 18px; height:50px }
.form-control{ width: 170px; }
.subtitle {color:#77AF9C; margin: 0px auto;  font-weight: bold; font-size:1.5rem; padding-top:3rem;}
.collieBtnMain{ border: 1px solid #77AF9C; padding: 25px 25px 25px 25px; text-align:right;  margin-left:50px ; color: #285943; font-size: 15px; background-color: #77AF9C; }
</style>
<!-- Google CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<script type="text/javascript">
$(function(){
	
	$("#modifyBtn").click(function(){
		
			if($("#item_name").val().trim()==""){
				alert("물건명을 입력해주세요");
				$("#item_name").focus();
				return;
			}//end if
			
			if($("#item_price").val().trim()==""){
				alert("가격을 입력해주세요");
				$("#item_price").focus();
				return;
			}//end if
			
		
	      if($("#item_price").val().replace(/[0-9A-Za-z]/g, "") != ""){
	    	  alert("가격은 숫자만 가능합니다.");
	          $("#item_price").focus();
	          return;
	       }//end if
	       
			if($("#item_weight").val().trim()==""){
				alert("중량/용량을 입력해주세요");
				$("#item_weight").focus();
				return;
			}//end if
	       
			if($("#item_unit").val().trim()==""){
				alert("판매단위를 입력해주세요");
				$("#item_unit").focus();
				return;
			}//end if
			
			if($("#item_stock").val().trim()==""){
				alert("재고를 입력해주세요");
				$("#item_stock").focus();
				return;
			}//end if
	       
	      if($("#item_stock").val().replace(/[0-9A-Za-z]/g, "") != ""){
	    	  alert("재고는 숫자만 가능합니다.");
	          $("#item_stock").focus();
	          return;
	       }//end if
	       
			if($("#item_guide").val().trim()==""){
				alert("안내사항을 입력해주세요");
				$("#item_guide").focus();
				return;
			}//end if
			
			if($("#item_img").val().trim()==""){
				alert("이미지를 입력해주세요");
				return;
			}//end if
			
			if($("#detail_img0").val().trim()==""){
				alert("디테일 이미지를 입력해주세요");
				return;
			}//end if
			
	       
		$("#insertFrm").submit();
			
	});//click
	
	$("#mtqBtn").click(function(){
		
		location.href="";
		
	})//click
	
	$("#item_img").change(function(){
		document.getElementById("changeVal").innerHTML = "<img src='http://localhost/mgr/upload_file/'"+imgSrc+"/>";
	});
});//ready

var count = 100;

function addForm(){
    var addedFormDiv = document.getElementById("addedFormDiv");
    var str = "";
    str+="<div><img id='image_section"+count+"' /></div>";
    str+="<div style='margin-left: 380px; margin-top: 50px'><input type='file' id='detail_img"+count+"' name='detail_img"+count+"' style='border: 1px solid #333; width: 190px''/>";
    str+="<input type='button' value='삭제' onclick='delForm("+count+")'/></div>";
    
    // 추가할 폼(에 들어갈 HTML)
    var addedDiv = document.createElement("div"); // 폼 생성
    addedDiv.id = "added_"+count; // 폼 Div에 ID 부여 (삭제를 위해)
    addedDiv.innerHTML  = str; // 폼 Div안에 HTML삽입
    addedFormDiv.appendChild(addedDiv); // 삽입할 DIV에 생성한 폼 삽입
    count++;
}//addForm

function delForm(count){
    var addedFormDiv = document.getElementById("addedFormDiv");
    if(count >0){ // 현재 폼이 두개 이상이면
		var addedDiv = document.getElementById("added_"+count);
		// 마지막으로 생성된 폼의 ID를 통해 Div객체를 가져옴
		addedFormDiv.removeChild(addedDiv); // 폼 삭제 
    }//end if
}//delForm

function itemQna(item_num) {
	location.href="../item_qna/list.do?item_num="+item_num;
}

</script>
</head>
<body style="font-family: nanumbarungothic">

<div id="wrap">
	
	<jsp:include page="/header.do" />
	
	<div id="container">
	<div style="text-align: left">
	<span style="margin-left:685px ; font-size: 30px" class="subtitle">상품 조회</span>
	<input type="button" id="mtqBtn" value="상품문의" onclick="itemQna(${ param.item_num });" style="margin-left: 300px; padding: 10px 10px 6px 6px;" class="collieBtnMain" />
	<hr style="border: 1px solid #285943; width:1000px"/>
	</div>
		<div >
		<div>
		<form id="insertFrm" name="insertFrm" action="modify_item.do" method="post" enctype="multipart/form-data">
		<div style="margin-left: 150px">
		<div style="margin-left: 220px; float:left">
  				 <div id="changeVal"><img src="/common/images/item/${ midd.item_img }"  width='190' height='190'/></div>
			   <div style="font-size: 18px; text-align:center; background-color:#77AF9C; width: 190px; border: 1px solid #333" class="collie_font">대표 이미지</div>
			<div>
			<input type="file" id="item_img" name="item_img"/>
			</div>
		</div>
		</div>
		<div style="margin-left: 780px; margin-top: 80px">
		<table>
		<tr>
		<td><span  style="width:80px; font-size: 18px" class="collie_font">카테고리</span></td>
		<td>
		<select style="width: 120px" id="cate_num" name="cate_num"  class="form-control" >
		<c:forEach var="cate" items="${ cate_list }">
			<option value="${ cate.cate_num }" <c:if test="${midd.cate_num eq cate.cate_num}">selected="selected"</c:if>><c:out value="${ cate.cate_name }"/>
		</c:forEach>
		</select>
		</td>
		<tr>
		<td class="collie_font">상품명</td> <td><input type="text" id="item_name" name="item_name" class="form-control" value="${ midd.item_name }"/></td>
		</tr>
		<tr>
		<td  class="collie_font">가격</td> <td><input type="text" id="item_price" name="item_price" class="form-control" value="${ midd.item_price }"/></td>
		</tr>
		<tr>
		<td class="collie_font">중량/용량</td> <td><input type="text" id="item_weight" name="item_weight" class="form-control" value="${ midd.item_weight }"/></td>
		</tr>
		<tr>
		<td class="collie_font">판매단위</td> <td><input type="text" id="item_unit" name="item_unit" class="form-control" value="${ midd.item_unit }"/></td>
		</tr>
		<tr>
		<td class="collie_font">재고</td> <td><input type="text" id="item_stock" name="item_stock" class="form-control" value="${ midd.item_stock}"/></td>
		</tr>
		<tr>
		<td class="collie_font">안내사항</td> <td><textarea id="item_guide" name="item_guide" class="form-control" style="resize: none; width: 300px; height: 200px" ><c:out value="${ midd.item_guide }"></c:out></textarea></td>
		</tr>
		</table>
		</div>
		<hr style="border: 1px solid #285943; width:1000px"/>
		<div style="margin-top: 40px; margin-left: 240px">
		<div style="margin-left: 450px; font-size: 25px" class="subtitle">상품상세설명</div>
		
		<!-- 상세 이미지 들어갈 곳 -->
		<table style="margin-top: 50px; margin-bottom: 50px">
		<tr>
		<td><input type="email" id="item_title" name="item_title" class="form-control" style="width: 1000px" value="${ midd.item_title }"/></td>
		</tr>
		<tr>
		<td><input type="email" id="item_subtitle" name="item_subtitle" class="form-control" style="width: 1000px" value="${ midd.item_subtitle}"/></td>
		</tr>
		<tr> 
		<td><textarea id="item_detail" name="item_detail" class="form-control" style="resize: none; width: 1000px; height: 250px">${ midd.item_detail }</textarea></td>
		</tr>
		</table> 
		</div>
		<div style="margin-left: 520px; margin-top: 80px">
			<input type="hidden" name="count" value="0"/>
			<!-- 파라미터로 item_num 받아놓은거 -->
			<input type="hidden"  name="item_num" value="${ param.item_num }" /> 
			<input type="button" id="modifyBtn" value="수정" class="collieBtnMain" style="padding: 10px 100px 10px 100px; margin-left: 138px;"/>  
			<div style="margin-left: 550px; margin-top: 80px"><input type="button" value="사진추가" onclick="addForm()" class="collieBtnMain" style="padding: 10px 10px 10px 10px;"/></div>
		</div>
		<div style="margin-left: 300px; margin-top: 100px"> 
		<div id="addDiv0">
		<div style="margin-left: 380px"><img src="/common/images/item/${ midd.detail_img[0] }" id='image_section0' width="190" height="150'"/></div>
		<div style="margin-left: 380px;" class="font"><input type='file' id='detail_img0' name='detail_img0' value="${ midd.detail_img[0] } " style="border: 1px solid #333; width: 190px" /></div>
		</div>
		<div id="addedFormDiv">
		<c:forEach var="i" begin="1" end="${ midd.detail_img.size()-1 }" step="1">
		<div style="" id="added_${ i }">
		<div style="margin-left: 380px; margin-top: 50px"><img src="/common/images/item/${ midd.detail_img[i] }" id='image_section${ i }' width="190" height="150'"/></div>
		<div style="margin-left: 380px"><input type='file' id='detail_img${ i }' name='detail_img${ i }' value="${ midd.detail_img[i] }"  style="border: 1px solid #333; width: 190px" />
		<input type='button' value='삭제' onclick='delForm(${ i })'/></div>
		</div>
		</c:forEach>
		</div>
		
		</div>
		</form>
		
		</div>
		</div>
		</div>
		<hr style="border: 1px solid #285943; width:1000px"/>
		<div style="height: 200px"></div>
	</div>
	
	

</body>
</html>	