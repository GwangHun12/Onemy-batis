<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
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
	<h1>마이페이지</h1>
	<main id="main">
		<form action="/member/update.do" method="post" id="text_area">
			<fieldset>
					<legend>회원 상세 정보</legend>
					<ul>
						<li>
							<label for="memberId">아이디</label>
							<input type="text" id="memberId" name="memberId" value="${memberId }" readonly> <!-- 기능을 위한 id, 쿼리스트링 생성을 위한 name -->
						</li>
						<li>
							<label for="pass">비밀번호</label>
							<input type="password" id="pass" name="pass">
						</li>
					</ul>
				</fieldset>
				<div>
					<button type="submit">수정하기</button>
					<a href="javascript:void(0)" onclick="checkDelete();">탈퇴하기</a>
					<%-- <a href="/member/delete.do?memberId=${sessionScope.memberId }">탈퇴하기</a> --%>
					<!-- <button>탈퇴하기</button> -->
				</div>
			</form>
		</main>
			<script>
				function checkDelete(){
					if(confirm("탈퇴하시겠습니까?")){
						location.href = "/member/delete.do?memberId=${memberId}";
					}
				}
			</script>
	</body>
</html>