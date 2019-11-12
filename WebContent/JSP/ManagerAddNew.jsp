<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.Date" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="model.Book" %>
<%@page import="dao.DataAccess" %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Page</title>
</head>
<body>
<%
	String title = request.getParameter("title");
	Date dateTemp = new Date(System.currentTimeMillis());
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	String date = dateFormat.format(dateTemp.getTime());
	
	String description = request.getParameter("description");
	String detail = request.getParameter("detail");
	String category = request.getParameter("category");
	String image = request.getParameter("image");
	
	Book b = new Book(0, title, date, description, detail, category, image);
	DataAccess da = new DataAccess();
	da.addBook(b);
	
	response.sendRedirect("/BookRep/AllPost");
	
%>

</body>
</html>