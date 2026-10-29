<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Регистрация — Проклятый гримуар</title>
</head>
<body>
<h1>Регистрация</h1>

<c:if test="${param.error == 'taken'}">
    <p>Такой логин уже занят.</p>
</c:if>

<form method="post" action="signup">
    <p>
        <label for="login">Логин</label><br>
        <input id="login" name="login" type="text" required>
    </p>
    <p>
        <label for="password">Пароль</label><br>
        <input id="password" name="password" type="password" required>
    </p>
    <button type="submit">Создать аккаунт</button>
</form>

<p>Уже есть аккаунт? <a href="login">Войти</a></p>
</body>
</html>