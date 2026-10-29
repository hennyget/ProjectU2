<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Вход — Проклятый гримуар</title>
</head>
<body>
<h1>Вход</h1>

<c:if test="${param.error == 'wrong'}">
    <p>Неверный логин или пароль.</p>
</c:if>

<form method="post" action="login">
    <p>
        <label for="login">Логин</label><br>
        <input id="login" name="login" type="text" required>
    </p>
    <p>
        <label for="password">Пароль</label><br>
        <input id="password" name="password" type="password" required>
    </p>
    <button type="submit">Войти</button>
</form>

<p>Нет аккаунта? <a href="signup">Зарегистрироваться</a></p>
</body>
</html>