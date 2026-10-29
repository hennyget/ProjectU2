<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Проклятый гримуар</title>
</head>
<body>
<h1>Проклятый гримуар</h1>
<p>Каркас работает!</p>

<c:if test="${not empty sessionScope.user}">
    <p>Вы вошли как ${sessionScope.user.login}</p>
    <p><a href="profile">Профиль</a></p>
    <form method="post" action="logout">
        <button type="submit">Выйти</button>
    </form>
</c:if>

<c:if test="${empty sessionScope.user}">
    <p><a href="login">Войти</a> · <a href="signup">Регистрация</a></p>
</c:if>
</body>
</html>