<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html><head>
  <meta charset="UTF-8">
  <title>Login</title>
  <link rel="stylesheet" href="static/css/styles.css"/>
</head>
<body>
  <h2>Login</h2>
  <c:if test="${param.registered == '1'}"><div class="success">Registration successful. Please login.</div></c:if>
  <c:if test="${not empty error}"><div class="error">${error}</div></c:if>
  <form method="post" action="login" class="card">
    <label>Email</label><input type="email" name="email" required/>
    <label>Password</label><input type="password" name="password" required/>
    <button type="submit">Login</button>
  </form>
</body></html>
