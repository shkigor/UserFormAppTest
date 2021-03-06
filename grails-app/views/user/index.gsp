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
%{--<g:hasErrors>--}%
    %{--<div class="errors">--}%
        %{--<g:renderErrors bean="${user}" as="list"/>--}%
    %{--</div>--}%
%{--</g:hasErrors>--}%
<g:if test="${flash.message}">
    <div class="flash">${flash.message}</div>
</g:if>


<g:form action="calc">
    <fieldset class="form">
        <div class="fieldcontain required ${hasErrors(bean:user,field:'userLogin', 'error')}">
            <label for="userLogin">User login</label>
            <g:textField name="userLogin" value="${user?.userLogin}"/>
            <g:hasErrors bean="${user}" field="userLogin">
                <g:eachError bean="${user}" field="userLogin">
                    <p style="color: red;"><g:message error="${it}"/></p>
                </g:eachError>
            </g:hasErrors>
        </div>

        <div class="fieldcontain required ${hasErrors(bean:user,field:'userEmail', 'error')} ">
            <label for="userEmail">User email</label>
            <g:textField name="userEmail" value="${user?.userEmail}"/>

            <g:hasErrors bean="${user}" field="userEmail">

                %{--<g:if test="${error in org.springframework.validation.FieldError}">--}%
                    %{--<span style="border-color: red;">--}%
                    %{--<g:textField name="userEmail" value="${user?.userEmail}"/>--}%
                    %{--</span>--}%
                %{--</g:if>--}%

                %{--<p class="error"><g:fieldError bean="${user}" field="userEmail" /></p>--}%
                <g:eachError bean="${user}" field="userEmail">
                    <p style="color: red;"><g:message error="${it}"/></p>
                </g:eachError>
            </g:hasErrors>

            %{--<g:hasErrors bean="${user}">--}%
                %{--<ul class="errors" role="alert">--}%
                    %{--<g:eachError bean="${user}" var="error">--}%
                        %{--<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message--}%
                                %{--error="${error}"/></li>--}%
                    %{--</g:eachError>--}%
                %{--</ul>--}%
            %{--</g:hasErrors>--}%

        </div>

        <div class="fieldcontain required ${hasErrors(bean:user,field:'seniority', 'error')}">
            <label for="seniority">User seniority</label>
            <g:textField name="seniority" value="${user?.seniority}"/>
            <g:hasErrors bean="${user}" field="seniority">
                <g:eachError bean="${user}" field="seniority">
                    <p style="color: red;"><g:message error="${it}"/></p>
                </g:eachError>
            </g:hasErrors>
        </div>

        <div class="fieldcontain ${hasErrors(bean:user,field:'commission', 'error')}">
            <label for="commission">User commission</label>
            <g:textField name="commission" value="${user?.commission}"/>
            <g:hasErrors bean="${user}" field="commission">
                <g:eachError bean="${user}" field="commission">
                    <p style="color: red;"><g:message error="${it}"/></p>
                </g:eachError>
            </g:hasErrors>
        </div>

        <div class="fieldcontain required ${hasErrors(bean:user,field:'sum', 'error')}">
            <label for="sum">User sum</label>
            <g:textField name="sum" value="${user?.sum}"/>
            <g:hasErrors bean="${user}" field="sum">
                <g:eachError bean="${user}" field="sum">
                    <p style="color: red;"><g:message error="${it}"/></p>
                </g:eachError>
            </g:hasErrors>
        </div>

    </fieldset>
    <fieldset class="buttons">
        <g:submitButton name="calculate" value="Calculate"/>
    </fieldset>
</g:form>

</body>
</html>