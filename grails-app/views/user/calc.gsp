<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 17.11.15
  Time: 16:01
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Calculate</title>
    <meta name="layout" content="main"/>
</head>

<body>
<h1>Calculate User</h1>
<g:hasErrors>
    <div class="errors">
        <g:renderErrors bean="${user}" as="list"/>
    </div>
</g:hasErrors>
<g:if test="${flash.message}">
    <div class="flash">${flash.message}</div>
</g:if>


<g:form action="calc">
    <fieldset class="form">
        <div class="fieldcontain required">
            <label for="userLogin">User login</label>
            <g:textField name="userLogin" value="${user?.userLogin}"/>
        </div>

        <div class="fieldcontain required">
            <label for="userEmail">User email</label>
            <g:textField name="userEmail" value="${user?.userEmail}"/>
        </div>

        <div class="fieldcontain required">
            <label for="seniority">User seniority</label>
            <g:textField name="seniority" value="${user?.seniority}"/>
        </div>

        <div class="fieldcontain required">
            <label for="commission">User commission</label>
            <g:textField name="commission" value="${user?.commission}"/>
        </div>

        <div class="fieldcontain required">
            <label for="sum">User sum</label>
            <g:textField name="sum" value="${user?.sum}"/>
        </div>

    </fieldset>
    <fieldset class="buttons">
        <g:submitButton name="calculate" value="Calculate"/>
    </fieldset>
</g:form>

</body>
</html>