<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>회원가입</title>
</head>
<body>
<h2>회원가입</h2>
<form method="post" action="/auth/signup">
  <label>이메일: <input type="email" name="email"/></label><br/>
  <label>비밀번호: <input type="password" name="password"/></label><br/>
  <label>이름: <input type="text" name="username"/></label><br/>
  <button type="submit">가입하기</button>
</form>

<c:if test="${not empty error}">
  <p style="color:red;">${error}</p>
</c:if>

<p><a href="/auth/login">로그인으로 돌아가기</a></p>
</body>
</html>