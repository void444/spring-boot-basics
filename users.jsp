<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table>
<tr><th>ID</th><th>Name</th><th>Email</th><th>action</th></tr>
<c:forEach items="${data }" var="obj">
<tr><td>${obj.id }</td><td>${obj.name}</td><td>${obj.email }</td>
<td><a href="userdelete?id=${obj.id }">delete</a>
    <a href="useredit?id=${obj.id }">edit</a>    
</td>
</tr>
</c:forEach>

</table>

