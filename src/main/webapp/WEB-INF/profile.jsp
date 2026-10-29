<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="parts/header.jsp" %>

<h1>Профиль</h1>

<c:if test="${not empty sessionScope.user}">
    <p>Логин: ${sessionScope.user.login}</p>
    <p>Номер игрока: ${sessionScope.user.id}</p>
</c:if>

<c:if test="${empty sessionScope.user}">
    <p>Чтобы увидеть профиль, нужно <a href="login">войти</a>.</p>
</c:if>

<%@ include file="parts/footer.jsp" %>