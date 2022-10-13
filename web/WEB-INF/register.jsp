<%-- 
    Document   : register
    Created on : 12-Oct-2022, 10:49:02 AM
    Author     : Aster
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
    </head>
    <body>
        <h1>Shopping List</h1><br>
        <form method="post" action="register">
        Username: <input type="text" id="username" name="username">
        <input type="submit" value="Register name"><br>
        <p>${message}</p>
        </form>
    </body>
</html>
