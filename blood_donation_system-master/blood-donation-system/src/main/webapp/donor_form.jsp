<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.community.blood.model.User" %>
<%
  User user = (User) session.getAttribute("user");
  if (user == null) { response.sendRedirect("login.jsp"); return; }
%>
<!DOCTYPE html>
<html><head>
  <meta charset="UTF-8">
  <title>Become a Donor</title>
  <link rel="stylesheet" href="static/css/styles.css"/>
</head>
<body>
  <h2>Become a Donor</h2>
  <form method="post" action="become-donor" class="card">
    <label>Blood Group</label>
    <select name="bloodGroup" required>
      <option value="">Select</option>
      <option>O+</option><option>O-</option><option>A+</option><option>A-</option>
      <option>B+</option><option>B-</option><option>AB+</option><option>AB-</option>
    </select>
    <label>City</label><input name="city" required/>
    <label>Phone</label><input name="phone" required pattern="\d{10,}"/>
    <button type="submit">Save</button>
  </form>
</body></html>
