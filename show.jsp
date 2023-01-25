<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Name:${NAME }</h1>
<h1>email:${EMAIL }</h1>
<c:if test="${isadmin }">
<a href="delete">delete</a>
</c:if>
<h1>course</h1>
<ul>
<c:forEach items="${data }" var="obj">
<li>${obj }</li>
</c:forEach>
</ul>