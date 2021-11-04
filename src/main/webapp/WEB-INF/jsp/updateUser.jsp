<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update User</title>
</head>
<body>
<h1>Update User</h1>
<form method="post" action="updated">
    <table>
        <tr>
            <td>Email:</td>
            <td><input name="email" required placeholder="Enter email"
                       oninvalid="this.setCustomValidity('Please enter User Email')"
                       oninput="this.setCustomValidity('')"/></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input name="password" type="password" required placeholder="Enter password"
                       oninvalid="this.setCustomValidity('Please enter Password')"
                       oninput="this.setCustomValidity('')"/></td>
        </tr>
        <tr>
            <td>New Email:</td>
            <td><input name="newEmail" required placeholder="Enter new email"
                       oninvalid="this.setCustomValidity('Please enter new User Email')"
                       oninput="this.setCustomValidity('')"/></td>
        </tr>
        <tr>
            <td>New Password:</td>
            <td><input name="newPassword" type="password" required placeholder="Enter new password"
                       oninvalid="this.setCustomValidity('Please enter new Password')"
                       oninput="this.setCustomValidity('')"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"></td>
        </tr>
    </table>
    <br>
    <form method="get" action="/">
        <button><a href="/">Back</a></button>
    </form>
    <br>
    <p>${userNotUpdated}</p>
</form>
</body>
</html>
