<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Task2_JavaEE</title>
</head>
<body>
<h1>CRUD Operations With Spring DI</h1>
<br/>

<ol>
    <li>
        <form method="get" action="create">
            <a href="create">Create User</a>
        </form>

    </li>
    <li>
        <form method="get" action="update">
            <a href="update">Update User</a>
        </form>

    </li>
    <li>
        <form method="get" action="show">
            <a href="show">Show User</a>
        </form>
        </li>
    <li>
        <form method="get" action="delete">
            <a href="delete">Delete User</a>
        </form>
    </li>
</ol>
<br>
<p>${userCreated}</p>
<p>${userUpdated}</p>
<p>${userDeleted}</p>
<p>${allUsersDeleted}</p>


</body>
</html>