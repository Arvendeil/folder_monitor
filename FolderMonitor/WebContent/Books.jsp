<%@ page import="java.io.*,java.util.Date,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ page import="com.epam.nulp.database.DataBaseEditor"%>
<%@ page import="com.epam.nulp.parser.FileWorker"%>
<%@page contentType="text/html" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<html>
<head>
<title>Monitor Folder</title>
</head>
<body>

	<%@page contentType="text/html" import="java.util.*"%>
	<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/Books" user="arven" password="12345" />

	<sql:query dataSource="${snapshot}" var="result">
SELECT * from Books.Books;
</sql:query>

	<table border="1" width="100%">
		<tr>
			<th>Author</th>
			<th>Title</th>
			<th>Genre</th>
			<th>Price</th>
			<th>Year</th>
			<th>Publication</th>
			<th>Review</th>
		</tr>
		<c:forEach var="row" items="${result.rows}">
			<tr>
				<td><c:out value="${row.author}" /></td>
				<td><c:out value="${row.title}" /></td>
				<td><c:out value="${row.genre}" /></td>
				<td><c:out value="${row.price}" /></td>
				<td><c:out value="${row.year}" /></td>
				<td><c:out value="${row.publication}" /></td>
				<td><c:out value="${row.review}" /></td>
			</tr>
		</c:forEach>
	</table>
	<form method="get" action="ServleT">
		<input type="submit" value="Update">
	</form>
</body>
</html>