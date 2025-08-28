<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.community.blood.model.User" %>
<%
  User user = (User) session.getAttribute("user");
  if (user == null) {
    response.sendRedirect("login.jsp");
    return;
  }
%>
<!DOCTYPE html>
<html><head>
  <meta charset="UTF-8">
  <title>Dashboard</title>
  <link rel="stylesheet" href="static/css/styles.css"/>
</head>
<body>
  <header>
    <h2>Welcome, <%= user.getName() %></h2>
    <nav>
      <a href="donor_form.jsp">Become a Donor</a>
      <a href="request_form.jsp">Post a Request</a>
      <a href="requests">Open Requests</a>
      <a href="logout">Logout</a>
    </nav>
  </header>
  <main>
    <div class="grid">
      <div class="card">
        <h3>Your Actions</h3>
        <ul>
          <li>Register as a donor with blood group & city</li>
          <li>Post a blood requirement request</li>
          <li>Find matching donors</li>
        </ul>
      </div>
      <div class="card">
        <h3>Stats</h3>
        <p>Live requests and donors grow as your community joins.</p>
      </div>
    </div>
  </main>
</body></html>
