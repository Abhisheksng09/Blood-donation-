<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8"/>
  <title>Community Blood Donation</title>
  <link rel="stylesheet" href="static/css/styles.css"/>
  <script defer src="static/js/app.js"></script>
</head>
<body>
<header>
  <h1>Community Blood Donation</h1>
  <nav>
    <a href="register.jsp">Register</a>
    <a href="login.jsp">Login</a>
    <a href="requests">Find Requests</a>
  </nav>
</header>

<section class="banner">
  <div id="aemBanner">Loading announcements...</div>
</section>

<section class="hero">
  <h2>Donate blood, save lives.</h2>
  <p>Connect donors with those in need, quickly and safely.</p>
</section>

<footer>
  <p>&copy; <script>document.write(new Date().getFullYear())</script> Community Blood Donation</p>
</footer>
</body>
</html>
