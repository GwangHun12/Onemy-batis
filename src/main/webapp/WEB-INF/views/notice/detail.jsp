<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>공지사항 상세조회</title>
		<link rel="stylesheet" href="../resources/css/detail.css">
		<style>
			display: flex;
    		justify-content: space-evenly;
   			font-size: 24px;
   			padding-top : 90px;
   			main {
   				font-size : 30px;
   			}
		</style>
	</head>
	<body>
	<div id="container"></div>
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
                </header>
	 <main id="main">
		<h1>공지사항 상세</h1>
		<ul>
			<li>
				<label>글번호</label>
				<span>${requestScope.notice.noticeNo }</span>
			</li>
			<li>
				<label>작성일</label>
				<span>${requestScope.notice.noticeDate }</span>
			</li>
			<li>
				<label>글쓴이</label>
				<span>${requestScope.notice.noticeWriter }</span>
			</li>
			<li>
				<label>제목</label>
				<span>${notice.noticeSubject }</span>
			</li>
			<li>
				<label>상품명</label>
				<span>${notice.noticeProduct }</span>
			</li>
			<li>
				<label>내용</label>
				<p>${notice.noticeContent }</p>
			</li>
		</ul>
	 </main>
	 <div class="change">
		<a href="/notice/list.do">목록으로 이동</a><br>
		<a href="/notice/modify.do?noticeNo=${notice.noticeNo }">수정하기</a><br>
<!-- 		DELETE FROM NOTICE_TBL WHERE NOTICE_NO = ? -->
		<a href="javascript:void(0)" onclick="deleteCheck();">삭제하기</a><br>
<!-- 		<button id="" onclick="">삭제하기</button> -->
		<script>
			const deleteCheck = () => {
				const noticeNo = '${notice.noticeNo }';
				if(confirm("증말루 삭제할거에요?")) {
					location.href = "/notice/delete.do?noticeNo="+noticeNo;
				}
			}
		</script>
	 </div>
	</body>
</html>