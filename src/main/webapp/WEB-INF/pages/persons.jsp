<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Contacts</title>
  <script language="JavaScript">

    function confirmDelete() {
      if (confirm("Удалить контакт?")) {
        return true;
      } else {
        return false;
      }
    }

  </script>
</head>
<h1>Contacts</h1>

<c:url var="addUrl" value="/persons/add" />
<table style="width: 500px; border: solid; text-align:center; " cellpadding="0" cellspacing="0">
  <thead style="background: #dddddd;">
  <tr>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Email</th>
    <th>Birth Date</th>
    <th>Phone</th>
    <th colspan="5"></th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${persons}" var="person">
    <c:url var="editUrl" value="edit?id=${person.id}" />
    <c:url var="deleteUrl" value="delete?id=${person.id}" />
    <tr>
      <td><c:out value="${person.firstName}" /></td>
      <td><c:out value="${person.lastName}" /></td>
      <td><c:out value="${person.email}" /></td>
      <td><fmt:formatDate pattern="dd.MM.yyyy" value="${person.birthDate}"/></td>
      <td><c:out value="${person.phone}" /></td>
      <td><a href="${editUrl}">Edit</a></td>
      <td><a href="${deleteUrl}" onclick="return confirmDelete();">Delete</a></td>
      <td><a href="${addUrl}">Add</a></td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<br />
<c:if test="${empty persons}">
  <form action="${addUrl}">
    <button type="submit">Add person</button>
  </form>
</c:if>

</body>
</html>
