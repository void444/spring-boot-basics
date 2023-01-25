<h1>edit user</h1>
<form method="post" action="edituserdb">
name:<input type = "text" name="name" value="${user.name}">
Email:<input type ="text" name="email" value="${user.email}">
<input type="hidden" value="${user.id}" name="id" >
<input type ="submit"value="ok">
</form>