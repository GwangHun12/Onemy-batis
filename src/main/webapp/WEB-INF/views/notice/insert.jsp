<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>공지사항 작성</title>
		<link rel="stylesheet" href="../resources/css/insert.css">
		<style>
			display: flex;
    		justify-content: space-evenly;
   			font-size: 24px;
   			padding-top : 90px;
		</style>
	</head>
	<body>
	 <div id="container"></div>
                <input type="hidden" name="memberId" value="${sessionScope.memberId}" />

            <header>
                <div id="header">
                    <div id="header1">
                        <a href="../index.jsp">
                        <img src="../img/emisLOGO.svg" alt="One로고"></a>
                    </div>
                    <!-- <div id="header2"><img src="../img/bar.png" alt="햄버거 바"></div> -->
                    <input type="checkbox" id="icon">
                    <label for="icon">  <!--label은 인라인 스타일-->
                        <span></span>
                        <span></span>
                        <span></span>
                    </label>
                    <div id="header2">
                        <ul>
                        <c:if test="${memberId eq null }">
                            <li><a href="/member/register.do">로그인</a></li>
                            </c:if>
                        <c:if test="${memberId ne null }">
                            <li><a href="/member/logout.do">로그아웃</a></li>
                            </c:if>
                            <li><a href="../One/Info_Page.html">홈페이지 정보</a></li>
                            <li><a href="/member/myInfo.do">마이페이지</a></li>
                            <li><a href="/notice/list.do?currentPage=1">게시판</a></li>
                        </ul>
                    </div>
                </div>
                <style>
                    .info {
                        font-size: 30px;
                    }
                </style>
              </header>
		<h1>공지사항 작성</h1>
		<main id="main">
		<form action="/notice/insert.do" method="post" id="text_area">
			<fieldset>
				<legend>공지사항 작성</legend>
				<ul>
					<li>
						<label>제목</label>
						<input type="text" id="" name="noticeSubject">
					</li>
					<li>
						<label>상품명</label>
						<input type="text" id="" name="noticeProduct">
					</li>
					<li>
						<label>내용</label>
						 <textarea rows="30" cols="40" id="" name="noticeContent"></textarea>
					</li>
				</ul>
			</fieldset>
			<div>
				<input type="submit" value="작성">
				<input type="reset" value="초기화">
			</div>
		</form>
		</main>
	</body>
</html>