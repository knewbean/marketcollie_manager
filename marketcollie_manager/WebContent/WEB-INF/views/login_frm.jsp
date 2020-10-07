<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="관리자 로그인 페이지" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마켓 컬리 관리자 메인 페이지</title>

<!-- Google CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<link rel="stylesheet" href="common/css/common.css" >

<style type="text/css">
#wrap{ margin: 0px auto; position: relative;}
#container{ min-height: 600px; display: flex; flex-direction: column; justify-content: center;}
.login-frm { display: inline-block; width: 30%;}
.frm_div {text-align: center; width: -webkit-fill-available;}
.col-form-label {text-align:left; padding-left: 0px; padding-right: 0px;}
.logo-div {text-align: center; padding: 50px;}
#btnDiv{padding-left: 0px; padding-right: 15px;}
#loginBtn {background-color: #17462B; border: 1px solid #17462B; color:#fff}
</style>

<script type="text/javascript">

$(function() {
	$("#loginBtn").click(function() {
		//id 유효성검사
		if($("#mgr_id").val().trim().length == 0) {
			alert("아이디를 입력해주세요.");
			$("#mgr_id").focus();
			return;
		}
		//pass 유효성 검사
		if($("#mgr_pass").val().trim().length == 0) {
			alert("비밀번호를 입력해주세요.");
			$("#mgr_pass").focus();
			return;
		}
		
		$("#loginFrm").submit();
	});
});
</script>

</head>
<body style="font-family: 'NanumBarunGothic'">
<div id="wrap">
	<div id="header"></div>
	<div id="container">
		<div class="logo-div">
			<img src="common/images/logo_green.png"/>
		</div>
		<div class="frm_div">
			<form id="loginFrm" action="login.do" method="post" class="login-frm">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">아이디</label>
				    <div class="col-sm-10">
						<input type="text" name="id" id="mgr_id" class="form-control"/>
				    </div>
				</div>
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">비밀번호</label>
				    <div class="col-sm-10">
						<input type="password" name="pass" id="mgr_pass" class="form-control"/>
				    </div>
				</div>
				<div id="btnDiv" class="form-group row">
					<input type="button" value="LOGIN" id="loginBtn" class="form-control"/>
				</div>
			</form>
		</div>
	</div>
</div>
</body>
</html>