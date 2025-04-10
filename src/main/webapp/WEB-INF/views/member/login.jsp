<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>로그인</title>
</head>
<body>
<h2>로그인</h2>
<form action="/auth/login-form" method="post">
    <label for="email">이메일:</label>
    <input type="email" id="email" name="email" required>
    <label for="password">비밀번호:</label>
    <input type="password" id="password" name="password" required>
    <button type="submit">로그인</button>
</form>

<c:if test="${not empty error}">
    <p style="color:red;">${error}</p>
</c:if>

<p>아직 회원이 아니신가요?
    <a href="/auth/signup">회원가입</a>
</p>
</body>
</html>