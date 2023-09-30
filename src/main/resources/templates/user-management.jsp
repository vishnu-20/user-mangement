<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Management</title>
</head>
<body>
    <h2>User Management</h2>

    <table border="1">
        <thead>
            <tr>
                <th>User ID</th>
                <th>Name</th>
                <th>Roles</th>
                <th>Location</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.userId}</td>
                    <td>${user.name}</td>
                    <td>${user.roles}</td>
                    <td>${user.location}</td>
                    <td><a href="<c:url value='/user/delete/' />${user.id}">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <form action="<c:url value='/user/add' />" method="post">
        <h3>Add User</h3>
        <label>User ID: <input type="text" name="userId" required></label>
        <label>Name: <input type="text" name="name" required></label>
        <label>Roles: <input type="text" name="roles" required></label>
        <label>Location: <input type="text" name="location" required></label>
        <button type="submit">Add User</button>
    </form>
</body>
</html>
