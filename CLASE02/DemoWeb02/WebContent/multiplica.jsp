<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <h1>MULTIPLICA</h1>
  <h2>Tabla de Multiplicar</h2>
  <form method="post" action="multiplica.jsp">
    <label>Qué tabla quieres?</label>
    <input type="text" name="n" width="5" size="5"/>
    <input type="submit" value="Procesar" />  
  </form>
  
  <c:if test="${param.n != null}">
  
    <h2>Tabla del ${param.n}</h2>
    
    <table>
      <c:forEach var="i" begin="1" end="12">
      <tr>
        <td>${i}</td>
        <td>*</td>
        <td>${param.n}</td>
        <td>=</td>
        <td>${i * param.n}</td>
      </tr>
      </c:forEach>
    </table>
  
  </c:if>
</body>
</html>