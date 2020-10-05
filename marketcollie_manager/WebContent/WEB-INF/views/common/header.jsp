<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="로그인 완료 후 관리자 메인 페이지"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div id="header" style="font-family: 'NanumBarunGothic'">
	<ul class="nav justify-content-end">
		<c:if test="${empty mgr_info}">
		  <li class="nav-item">
		    <a class="nav-link active" href="/collie_user/login_form.do" style="color: #000000">로그인</a>
		  </li>
		</c:if>
		<c:if test="${not empty mgr_info}">
			<li class="nav-item">
			    <a class="nav-link active" href="/collie_user/logout.do" style="color: #000000">로그아웃</a>
			</li>
		</c:if>
	</ul>
	
	<div id="logo">
		<a href="/mgr/main.do"><img src="/mgr/common/images/logo_green.png" style="width: 200px"/></a>
	</div>
	<div id="header_menu">
	<nav class="navbar navbar-collie">
	  <a class="navbar-brand" href="#">카테고리 관리</a>
	  <a class="navbar-brand" href="#">상품 관리</a>
	  <a class="navbar-brand" href="#">주문 관리</a>
	  <a class="navbar-brand" href="/mgr/qna/list.do">1:1 문의 관리</a>
	  <a class="navbar-brand" href="#">회원 관리</a>
	  <a class="navbar-brand" href="#">공지 관리</a>
	</nav>
	</div>
</div>
