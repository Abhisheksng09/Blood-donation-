<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html><head>
  <meta charset="UTF-8">
  <title>Register</title>
  <link rel="stylesheet" href="static/css/styles.css"/>
</head>
<body>
  <h2>Create Account</h2>
  <c:if test="${not empty error}"><div class="error">${error}</div></c:if>
  <form method="post" action="register" class="card">
    <label>Name</label><input name="name" required/>
    <label>Email</label><input type="email" name="email" required/>
    <label>Password</label><input type="password" name="password" required minlength="6"/>
    <button type="submit">Register</button>
    <p>Already have an account? <a href="login.jsp">Login</a></p>
  </form>
</body></html>
