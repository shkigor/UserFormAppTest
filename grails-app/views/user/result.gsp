<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 18.11.15
  Time: 10:29
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Result</title>
    <meta name="layout" content="main"/>
</head>

<body>
<h1>Result page for User</h1>
<g:if test="${flash.message}">
    <div class="flash">${flash.message}</div>
</g:if>

<p>${user?.userLogin}</p>
<p>${user?.userEmail}</p>
<p>${user?.userCalc}</p>

</body>
</html>