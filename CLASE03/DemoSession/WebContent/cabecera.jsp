<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<c:if test="${sessionScope.usuario == null}">
  <jsp:forward page="index.jsp"/>
</c:if>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <table>
    <tr>
      <td><img alt="" width="70" height="70" src="img/login.png"> </td>
      <td>
        Nombre: ${sessionScope.usuario.nombre}<br/>
        Apellido: ${sessionScope.usuario.apellido}
      </td>
    </tr>
  </table>
  <div style="width: 100%;">
    <a href="addProducto.jsp">Agregar Producto</a>&nbsp;&nbsp;
    <a href="listado.jsp">Listado</a>&nbsp;&nbsp;
  </div>
  <hr/>
</body>
</html>