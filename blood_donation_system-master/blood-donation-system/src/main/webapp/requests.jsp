<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html><head>
  <meta charset="UTF-8">
  <title>Open Requests</title>
  <link rel="stylesheet" href="static/css/styles.css"/>
</head>
<body>
  <h2>Open Blood Requests</h2>
  <c:if test="${not empty success}"><div class="success">${success}</div></c:if>
  <div class="list">
    <c:forEach var="r" items="${requests}">
      <div class="card">
        <h3>${r.patientName} needs ${r.bloodGroup}</h3>
        <p>City: ${r.city} | Hospital: ${r.hospital}</p>
        <p>Contact: ${r.contact} | Status: ${r.status}</p>
      </div>
    </c:forEach>
    <c:if test="${empty requests}">
      <p>No open requests yet. Be the first to post.</p>
    </c:if>
  </div>

  <c:if test="${not empty matches}">
    <h2>Matching Donors</h2>
    <div class="list">
      <c:forEach var="d" items="${matches}">
        <div class="card">
          <p>Donor #${d.id} | Group: ${d.bloodGroup} | City: ${d.city} | Phone: ${d.phone}</p>
        </div>
      </c:forEach>
      <c:if test="${empty matches}">
        <p>No matching donors found.</p>
      </c:if>
    </div>
  </c:if>
</body></html>
