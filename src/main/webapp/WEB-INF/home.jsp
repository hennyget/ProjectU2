<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="parts/header.jsp" %>

<h1>Проклятый гримуар</h1>
<p>Ты открыла книгу, которую нельзя было открывать. Пройди по главам гримуара
    и сними проклятие, пока оно не дописало последнюю страницу.</p>

<c:if test="${not empty sessionScope.user}">
    <p>Вы вошли как ${sessionScope.user.login}</p>
</c:if>

<%@ include file="parts/footer.jsp" %>