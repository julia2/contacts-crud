<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Contacts</title>
</head>
<body>

<h1>Edit Person</h1>

<c:url var="saveUrl" value="/persons/edit?id=${person.id}" />
<form:form modelAttribute="person" method="POST" action="${saveUrl}">
  <table>
    <tr>
      <td><form:label path="id">Id:</form:label></td>
      <td><form:input path="id" disabled="true"/></td>
    </tr>

    <tr>
      <td><form:label path="firstName">First Name:</form:label></td>
      <td><form:input path="firstName"/></td>
    </tr>

    <tr>
      <td><form:label path="lastName">Last Name</form:label></td>
      <td><form:input path="lastName"/></td>
    </tr>

    <tr>
      <td><form:label path="email">Email</form:label></td>
      <td><form:input path="email"/></td>
    </tr>

    <tr>
      <td><form:label path="birthDate">Birth Date</form:label></td>
      <td><form:input path="birthDate"/></td>
    </tr>

    <tr>
      <td><form:label path="phone">Phone</form:label></td>
      <td><form:input path="phone"/></td>
    </tr>
  </table>

  <input type="submit" value="Save" />
</form:form>

</body>
</html>
