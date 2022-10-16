<%-- 
    Document   : shoppingList
    Created on : 12-Oct-2022, 10:49:30 AM
    Author     : Aster
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>Shopping List</title>
    </head>
    <body>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <h1>Shopping List</h1><br>
        <span>${message} </span><a href="/Week6Lab_ShoppingList/register" action="logout">Logout</a><br>
        Add item: <input type="text" id="item"><button action="add">Add</button><br>
        <ul>
            <c:if test="${groceries != null}">
            <c:forEach items="${groceries}" var="groceryItem">
                <input type="radio" name="listitem" id="${groceries[i].name}"> ${groceries[i].name} <br>
            </c:forEach>
            </c:if>
        </ul>
    </body>
</html>
