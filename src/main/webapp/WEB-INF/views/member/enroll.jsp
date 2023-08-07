<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원가입</title>
		<style>
			ul {
				list-style-type : none;	
			}
			li {
				margin : 10px;
			}
			ul label {
				width : 80px;
				text-align : left;
				float : left;
			}
		</style>
	</head>
	<body>
		<h1>회원가입</h1>
		<h3>회원정보를 입력하세요.</h3>
		<form action="/member/register.do" method="post">
<!-- 		<form action="/member/register.do" method="post"> -->
<!-- 		post -> doGet => 쿼리스트링 사라짐 => 주소표시줄 길이를 줄여줌 -->
			<fieldset>
				<legend>회원가입</legend>
				<ul>
					<li>
					<label for="member_id">아이디</label>
					<input type="text" id="member_id" name="member_id" placeholder="아이디를 입력하세요." > <!-- 기능을 위한 id, 쿼리스트링 생성을 위한 name -->
					</li>
					<li>
					<label for="member_pw">비밀번호</label>
					<input type="password" id="member_pw" name="member_pw" placeholder="비밀번호를 입력하세요.">
					</li>
					<li>
					<label for="member_name">이름</label>
					<input type="text" id="member_name" name="member_name">
					</li>
					<li>
					<label for="age">나이</label>
					<input type="text" id="age" name="age">
					</li>
					<li>
					<label for="gender">성별</label>
					남<input type="radio" id="gender" name="gender" value="M">
					여<input type="radio" id="gender" name="gender" value="F">
					</li>
					<li>
					<label for="email">이메일</label>
					<input type="text" id="email" name="email">
					</li>
					<li>
					<label for="phone">전화번호</label>
					<input type="text" id="phone" name="phone">
					</li>
					<li>
					<label for="address">주소</label>
					<input type="text" id="address" name="address">
					</li>
					<li>
					<label for="hobby">취미</label>
					<input type="text" id="hobby" name="hobby">
					</li>
				</ul>
					<input type="submit" value="가입하기">
					<input type="reset" value="초기화">
			</fieldset>
		</form>
	</body>
</html>