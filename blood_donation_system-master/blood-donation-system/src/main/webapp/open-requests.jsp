<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Open Blood Requests</title>
    <style>
        table { width: 80%; margin: auto; border-collapse: collapse; }
        th, td { border: 1px solid #ddd; padding: 10px; text-align: center; }
        th { background-color: #f44336; color: white; }
        .btn { padding: 6px 12px; background: green; color: white; border: none; cursor: pointer; }
    </style>
</head>
<body>
    <h2 align="center">Open Blood Requests</h2>
    <table>
        <tr>
            <th>Patient</th>
            <th>Blood Group</th>
            <th>City</th>
            <th>Hospital</th>
            <th>Contact</th>
            <th>Status</th>
        </tr>
        <c:forEach var="req" items="${requests}">
            <tr>
                <td>${req.patientName}</td>
                <td>${req.bloodGroup}</td>
                <td>${req.city}</td>
                <td>${req.hospital}</td>
                <td>${req.contact}</td>
                <td>${req.status}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
