<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rental Agreements</title>
</head>
<body>
    <h1>Rental Agreements</h1>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Agreement Date</th>
                <th>Account ID</th>
                <th>Property ID</th>
                <th>Rental Amount</th>
                <th>Status</th>
            </tr>
        </thead>
        <tbody>
    <c:forEach var="agreement" items="${agreements}">
        <tr>
            <td>${agreement.id}</td>
            <td>${agreement.agreementDate}</td>
            <td>${agreement.accountID}</td>
            <td>${agreement.propertyID}</td>
            <td>${agreement.rentalAmount}</td>
            <td>${agreement.status}</td>
        </tr>
    </c:forEach>
</tbody>
    </table>
</body>
</html>```
