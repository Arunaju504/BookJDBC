<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:forEach items="${book}" var="eachbook" >
<c:out value="${eachbook.bookId}" />
<c:out value="${eachbook.bookName}" />
<c:out value="${eachbook.authorName}" />
<c:out value="${eachbook.price}" />
</c:forEach>
</body>
</html>