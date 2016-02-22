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
  <form method="post" action="Login">
    <p><img alt="" height="40" width="40" src="img/login.png"> </p>
    <p style="color: red;">${error}</p>
    <fieldset style="width: 300px;">
      <legend>Dato de Identificación</legend>
      <table>
        <tr>
          <td>Nombre:</td>
          <td><input type="text" name="nombre"/></td>
        </tr>
        <tr>
          <td>Apellido:</td>
          <td><input type="text" name="apellido"/></td>
        </tr>
      </table>
    </fieldset>
    <br/>
    <input style="width: 100px; height: 40px;" 
      type="submit" value="Ingresar" />
  </form>
</body>
</html>