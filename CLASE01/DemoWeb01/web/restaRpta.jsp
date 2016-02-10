<%-- 
    Document   : newjsp
    Created on : 10/02/2016, 11:29:07 AM
    Author     : Gustavo Coronel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <h1>RESTA</h1>
    <p>Número 1: <%= request.getAttribute("num1") %></p>
    <p>Número 2: <%= request.getAttribute("num2") %></p>
    <p>Resta: <%= request.getAttribute("resta") %></p>
  </body>
</html>
