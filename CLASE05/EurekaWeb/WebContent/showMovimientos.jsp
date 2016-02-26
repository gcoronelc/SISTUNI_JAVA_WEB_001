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
<h1>LISTA DE MOVIMIENTOS</h1>
<table>

  <tr class="tablaCabecera">
    <th>NRO.MOV.</th>
    <th>FECHA</th>
    <th>TIPO</th>
    <th>IMPORTE</th>
  </tr>
  
  <c:set var="n" value="1" />
  
  <c:forEach items="${movimientos}" var="r">
  
    <tr class="tablaFila${n}">
      <td>${r.MOVINUMERO}</td>
      <td>${r.MOVIFECHA}</td>
      <td>${r.TIPONOMBRE}</td>
      <td>${r.MOVIIMPORTE}</td>
    </tr>

    <c:set var="n" value="${n + 1}" />
    
    <c:if test="${n == 3 }">
      <c:set var="n" value="1"/>
    </c:if>
    
  
  </c:forEach>

</table>
</body>
</html>