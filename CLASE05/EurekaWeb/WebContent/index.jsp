<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/estilos.css">
<style type="text/css">
  #LOGON{
    margin: 5px auto;
    background-color: #FFFFFF;
    width: 300px;
    padding: 5px;
  }

</style>
<title>Insert title here</title>
</head>
<body>
  <div id="LOGON">
  <h1>INICIO DE SESION</h1>
  
  <c:if test="${error != null}">
    <p class="msgError">${error}</p>
  </c:if>
  
  <form method="post" action="Ingresar">
    <fieldset style="padding: 10px;">
      <legend>Datos de Logueo</legend>
      <table>
        <tr>
          <td>Usuario</td>
          <td><input type="text" name="usuario"/></td>
        </tr>
        <tr>
          <td>Clave</td>
          <td><input type="password" name="clave"/></td>
        </tr>
      </table>
      <input type="submit" value="Ingresar" 
      style="width: 150px; height: 40px; margin: 10px;" />
    </fieldset>
  </form>
  </div>
</body>
</html>