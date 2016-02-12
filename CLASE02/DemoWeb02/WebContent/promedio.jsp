<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!-- No es recomendable usar declaraciones -->
<%!
int n1, n2, n3, pr;
%>

<%
  // Datos
  n1 = Integer.parseInt(request.getParameter("num1"));
  n2 = Integer.parseInt(request.getParameter("num2"));
  n3 = Integer.parseInt(request.getParameter("num3"));
  // Proceso
  pr = (n1 + n2 + n3) / 3;
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <h1>PROMEDIO</h1>
  <p>Número 1: <%= n1 %></p>
  <p>Número 2: <%= n2 %></p>
  <p>Número 3: <%= n3 %></p>
  <p>Promedio: <%= pr %></p>
  <a href="promedio.html">Retornar</a>
</body>
</html>