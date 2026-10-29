<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Профиль — Проклятый гримуар</title>
</head>
<body>
<h1>Профиль</h1>

<c:if test="${not empty sessionScope.user}">
    <p>Логин: ${sessionScope.user.login}</p>
    <p>Номер игрока: ${sessionScope.user.id}</p>
</c:if>

<c:if test="${empty sessionScope.user}">
    <p>Чтобы увидеть профиль, нужно <a href="login">войти</a>.</p>
</c:if>

<p><a href="home">На главную</a></p>
</body>
</html>