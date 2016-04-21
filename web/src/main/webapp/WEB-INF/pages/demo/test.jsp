<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="#" method="post" commandName="patient">
    <table>
        <tr>
            <td>Name:</td><td><form:input path="name"/></td>
        </tr>

        <tr>
            <td colspan="2"><input type="submit" value="提交"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
