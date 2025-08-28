<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html><head>
  <meta charset="UTF-8">
  <title>Post Blood Request</title>
  <link rel="stylesheet" href="static/css/styles.css"/>
</head>
<body>
  <h2>Post a Blood Request</h2>
  <form method="post" action="post-request" class="card">
    <label>Patient Name</label><input name="patientName" required/>
    <label>Blood Group</label>
    <select name="bloodGroup" required>
      <option value="">Select</option>
      <option>O+</option><option>O-</option><option>A+</option><option>A-</option>
      <option>B+</option><option>B-</option><option>AB+</option><option>AB-</option>
    </select>
    <label>City</label><input name="city" required/>
    <label>Hospital</label><input name="hospital" required/>
    <label>Contact (Phone)</label><input name="contact" required pattern="\d{10,}"/>
    <button type="submit">Submit Request</button>
  </form>
</body></html>
