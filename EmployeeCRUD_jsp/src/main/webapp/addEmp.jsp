<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Added</h2>

<p>number: <%= request.getParameter("no") %></p>
<p>Name: <%= request.getParameter("name") %></p>
<p>job: <%= request.getParameter("job") %></p>
</body>
</html>