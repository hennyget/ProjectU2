<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="parts/header.jsp" %>

<h1>Выбери гримуар</h1>

<c:forEach var="quest" items="${requestScope.quests}">
    <article class="card">
        <h2>${quest.name}</h2>
        <p>${quest.description}</p>
        <a class="btn" href="play-game?questId=${quest.id}">Начать</a>
    </article>
</c:forEach>

<%@ include file="parts/footer.jsp" %>