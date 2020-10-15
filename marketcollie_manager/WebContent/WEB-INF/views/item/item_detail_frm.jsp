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
		
			if($("#item_img").val()==""){
				alert("물건명을 입력해주세요"); 
				return;
			}//end if
			
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
				$("#item_guide").focus();
				return;
			}//end if
			
			if($("#detail_img1").val().trim()==""){
				alert("디테일 이미지를 입력해주세요");
				return;
			}//end if
			
	       
		$("#insertFrm").submit();
			
	});//click
	
	var windowObj;
	
	var popupWidth = 200;
	var popupHeight = 300;

	var popupX = (window.screen.width / 2) - (popupWidth / 2);
	// 만들 팝업창 width 크기의 1/2 만큼 보정값으로 빼주었음

	var popupY= (window.screen.height / 2) - (popupHeight / 2);
	// 만들 팝업창 height 크기의 1/2 만큼 보정값으로 빼주었음
	
	/* 아이템 이미지 변경  */
	$("#addImgBtn").click(function(){
		
		var popUrl = "add_item_image.do";	//팝업창에 출력될 페이지 URL

		var popOption = "width=370, height=250, resizable=no, scrollbars=no, status=no, left="+popupX+", top="+popupY+";"    //팝업창 옵션(optoin)

			windowObj = window.open(popUrl,"",popOption);

	});//click
	/* 디테일 이미지 변경 */
	$("#modifyDetailBtn").click(function(){
		
		var popUrl = "add_detail_image.do";	//팝업창에 출력될 페이지 URL

		var popOption = "width=370, height=300, resizable=no, scrollbars=no, status=no;";    //팝업창 옵션(optoin)

			windowObj = window.open(popUrl,"",popOption);

	});//click
	
	$("#detail_img1").change(function(){
		var imgSrc = document.getElementById("detail_img1").files[0].name; ;
		document.getElementById("addDiv1").innerHTML = "<img src='http://localhost/mgr/common/images/item/"+imgSrc+"' width='150' height='150' />";
	});//onchange
	
	$("#detail_img2").change(function(){
		var imgSrc = document.getElementById("detail_img2").files[0].name; ;
		document.getElementById("addDiv2").innerHTML = "<img src='http://localhost/mgr/common/images/item/"+imgSrc+"' width='150' height='150' />";
	});//onchange
	
	$("#detail_img3").change(function(){
		var imgSrc = document.getElementById("detail_img3").files[0].name; ;
		document.getElementById("addDiv3").innerHTML = "<img src='http://localhost/mgr/common/images/item/"+imgSrc+"' width='150' height='150' />";
	});//onchange
	
	$("#detail_img4").change(function(){
		var imgSrc = document.getElementById("detail_img4").files[0].name; ;
		document.getElementById("addDiv4").innerHTML = "<img src='http://localhost/mgr/common/images/item/"+imgSrc+"' width='150' height='150' />";
	});//onchange
	
});//ready

/* var count = 0;
var idx=2;
function addForm(){

    var addedFormDiv = document.getElementById("addedFormDiv");

   
    var str = "";
    alert(idx);
    str+="<img src='http://localhost/mgr/common/images/item/${ midd.detail_img }' width='150' height='150'/>";
    str+="이미지 <input type='file' id='detail_img' name='detail_img'/>";
    str+="<input type='button' value='삭제' onclick='delForm()''/><br>";
    // 추가할 폼(에 들어갈 HTML)

   

    var addedDiv = document.createElement("div"); // 폼 생성

    addedDiv.id = "added_"+count; // 폼 Div에 ID 부여 (삭제를 위해)

    addedDiv.innerHTML  = str; // 폼 Div안에 HTML삽입

    addedFormDiv.appendChild(addedDiv); // 삽입할 DIV에 생성한 폼 삽입


    count++;

    // 다음 페이지에 몇개의 폼을 넘기는지 전달하기 위해 히든 폼에 카운트 저장

} */

function delForm(){

    var addedFormDiv = document.getElementById("addedFormDiv");



    if(count >0){ // 현재 폼이 두개 이상이면

               var addedDiv = document.getElementById("added_"+(--count));

               // 마지막으로 생성된 폼의 ID를 통해 Div객체를 가져옴

               addedFormDiv.removeChild(addedDiv); // 폼 삭제 

    }else{ // 마지막 폼만 남아있다면


    }

}

	// 이벤트를 바인딩해서 input에 파일이 올라올때 위의 함수를 this context로 실행합니다.
	function processImg(img){
		var imgSrc = document.insertFrm.item_img.value;
		if( img != ""){
			document.getElementById("changeVal").innerHTML = "<img src='http://localhost/mgr/common/images/item/"+imgSrc+"' width='150' height='150' />";
		}//end if			
	}//processImg
	
	// 이벤트를 바인딩해서 input에 파일이 올라올때 위의 함수를 this context로 실행합니다.
		
	function processDetailImg(img){
		var detail = document.insertFrm.detailVal.value;
		if( img != ""){
			document.getElementById("receiveDetail").value = detail; 
			document.getElementById("tab_img").innerHTML = "<img src='http://localhost/mgr/common/images/item/"+document.getElementById("receiveDetail").value+"' width='150' height='150' />";
		}//end if			
	}//processImg
	
	
	
</script>
</head>
<body style="font-family: nanumbarungothic">

<div id="wrap">
	
	<jsp:include page="/header.do" />
	
	<div id="container">
	<div style="text-align: left">
	<div style="margin-left:590px ; font-size: 30px" class="subtitle">상품 조회</div>
	<hr style="border: 1px solid #285943; width:1000px"/>
	</div>
		<div >
		<div>
		<form id="insertFrm" name="insertFrm" action="modify_item.do" method="post" >
		<div>
		<div style="margin-left: 220px; float:left">
  				 <div id="changeVal"><img src="http://localhost/mgr/common/images/item/${ midd.item_img }"  width='150' height='150'/></div>
			   <div style="font-size: 18px; text-align:center; background-color:#77AF9C; width: 150px; border: 1px solid #333" class="collie_font">대표 이미지</div>
			   <div><input type="text" id="item_img" name="item_img" value="${ midd.item_img }" class="form-horizon" readonly="readonly" style="width: 150px; height: 35px"/>
			   <input type="button" id="addImgBtn" style="padding: 10px 10px 6px 6px; margin-left: 20px; border: 1px solid #333" class="collieBtnMain" value="이미지 추가" /></div>
		</div>
		</div>
		<div style="margin-left: 750px; margin-top: 80px">
		<table>
		<tr>
		<td><span  style="width:80px; font-size: 18px" class="collie_font">카테고리</span></td>
		<td><select style="width: 120px" id="cate_num" name="cate_num"  class="form-control" >
			<option value=10 <c:if test="${midd.cate_num eq 10}">selected="selected"</c:if>>채소
			<option value=20 <c:if test="${midd.cate_num eq 20}">selected="selected"</c:if>>정육
			<option value=30 <c:if test="${midd.cate_num eq 30}">selected="selected"</c:if>>과일
			<option value=40 <c:if test="${midd.cate_num eq 40}">selected="selected"</c:if>>빵
			<option value=50 <c:if test="${midd.cate_num eq 50}">selected="selected"</c:if>>유제품
		</select></td>
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
		<div style="margin-top: 40px; margin-left: 180px">
		<div style="margin-left: 400px; font-size: 25px" class="subtitle">상품상세설명</div>
		
		<!-- 상세 이미지 들어갈 곳 -->
		<c:if test="${ midd.detail_img[0] ne null  }">
		<div id="tab_img" style="margin-left:  400px"><img src="http://localhost/mgr/common/images/item/${ midd.detail_img[0] }"  width="150" height="150'"></div>
		</c:if>
		<div style="margin-left:  330px; margin-top:30px">
		<div id="tab_img" style="margin-left:  50px"></div>
		<div style="margin-top: 30px"><input type="text" name="detail_img" id="receiveDetail" value="${ midd.detail_img[0] }" readonly="readonly" class="form-horizon" style="height: 40px" /><input type="button" id="modifyDetailBtn" value=" 이미지 수정" class="collieBtnMain" style="padding: 10px 10px 10px 10px; margin-left: 20px"/></div></div>
		<input type="hidden" name="detailVal" id="detailVal"/>
		<table style="margin-top: 130px; margin-bottom: 50px">
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
			<input type="button" id="modifyBtn" value="수정" class="collieBtnMain" style="padding: 10px 100px 10px 100px; text-align: right;"/> 
			<div style="margin-left: 400px; margin-top: 80px"><input type="button" value="사진추가" onclick="addForm()" class="collieBtnMain" style="padding: 10px 10px 10px 10px;"/></div>
		</div>
		<div style="margin-left: 200px">
	<!-- 	<div style="font-size: 25px; margin-bottom: 90px; margin-left: 420px" class="subtitle">이미지 선택</div> -->
		<c:if test="${ midd.detail_img[1] ne null  }">
		<div style="margin-left:  400px" id="addDiv1"><img src="http://localhost/mgr/common/images/item/${ midd.detail_img[1] }"  width='150' height='150'/></div>
		</c:if>
		<div style="margin-left:  400px" id="addDiv1"></div>
		<div>이미지 <input type="file" id ="detail_img1" name="detail_img"/></div>
		<c:if test="${ midd.detail_img[2] ne null  }">
		<div style="margin-left:  400px" id="addDiv2"><img src="http://localhost/mgr/common/images/item/${ midd.detail_img[2] }"  width='150' height='150'/></div>
		</c:if>
		<div style="margin-left:  400px" id="addDiv2"></div>
		<div>이미지 <input type="file" id ="detail_img2" name="detail_img"/></div>
		<c:if test="${ midd.detail_img[3] ne null  }">
		<div style="margin-left:  400px" id="addDiv3"><img src="http://localhost/mgr/common/images/item/${ midd.detail_img[3] }"  width='150' height='150'/></div>
		</c:if>
		<div style="margin-left:  400px" id="addDiv3"></div>
		<div>이미지 <input type="file" id ="detail_img3" name="detail_img"/></div>
		<c:if test="${ midd.detail_img[4] ne null  }">
		<div style="margin-left:  400px" id="addDiv4"><img src="http://localhost/mgr/common/images/item/${ midd.detail_img[4] }"  width='150' height='150'/></div>
		</c:if>
		<div style="margin-left:  400px" id="addDiv4"></div>
		<div>이미지 <input type="file" id ="detail_img4" name="detail_img"/></div>
		<div id="addedFormDiv"></div>
		</div>
		</form>
		
		</div>
		</div>
		</div>
		<hr style="border: 1px solid #285943; width:1100px"/>
		<div style="height: 80px"></div>
	</div>
	
	

</body>
</html>	