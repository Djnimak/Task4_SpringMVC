<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show Users</title>
</head>
<body>
<h1>Show User</h1>
<form method="post" action="shown">
    <table>
        <tr>User Email:</tr>
        <td><input name="email" required placeholder="Enter email"
        oninvalid="this.setCustomValidity('Please enter User Email')"
        oninput="this.setCustomValidity('')"/></td>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form>

<br>
<form method="post" action="shown">
    <input type="submit" name="showAllUsers" value="Show All Users"/>
</form>

<br>
<form method="get" action="/">
    <button><a href="/">Back</a></button>
</form>
<br>
<br>
<p>${noSuchUser}</p>
</body>
</html>
