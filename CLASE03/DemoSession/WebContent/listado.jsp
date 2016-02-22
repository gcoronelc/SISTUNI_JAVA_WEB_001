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
  <jsp:include page="cabecera.jsp"/>
  <c:if test="${sessionScope.carrito == null}">
    <p>Aun no existe el carrito</p>
  </c:if>
  <c:if test="${sessionScope.carrito != null}">
  
	  <c:if test="${empty sessionScope.carrito.lista}">
	    <p>El carrito esta vacío</p>
	  </c:if>
  
    <c:if test="${not empty sessionScope.carrito.lista}">
      <table border="1">
      
        <tr>
          <th>NOMBRE</th>
          <th>PRECIO</th>
          <th>CANT</th>
          <th>IMPORTE</th>
        </tr>
      
        <c:forEach items="${sessionScope.carrito.lista}" var="r">
        <tr>
          <td>${r.nombre}</td>
          <td>${r.precio}</td>
          <td>${r.cant}</td>
          <td>${r.importe}</td>
        </tr>
        </c:forEach>
        
      </table>
      <p>Total: ${sessionScope.carrito.total}</p>
    </c:if>
  
  </c:if>
</body>
</html>