<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>CONSULTA DE MOVIMIENTOS</h1>
<form id="form1">
<p>
  Cuenta:<input type="text" name="cuenta"/>
  <input type="button" id="btnBuscar" value="..." />
  <input type="button" id="btnConsultar" class="btnProcesar" value="Consultar" />
  <input type="button" id="btnConsultar2" class="btnProcesar" value="Consultar2" />
</p>
</form>
<hr/>
<div id="divMovimientos"></div>
<script type="text/javascript">

  $("#btnConsultar").click(function(){
	  var param = $("#form1").serialize();
	  $.post("TraerMovimientos1",param,function(paginaHTML){
		  $("#divMovimientos").html(paginaHTML);
	  });
  });
  
  $("#btnConsultar2").click(function(){
	    var param = $("#form1").serialize();
	    $.post("TraerMovimientos2",param,function(arrayJson){
	    	var textoHTML = "<h1>LISTADO DE MOVIMENTOS</h1>";
	    	if(arrayJson.length == 0){
	    		textoHTML += "<p class='msgError'>No hay datos.</p>"
	    	} else {
	    		textoHTML += "<table>";
	    		
	    		textoHTML += "<tr class='tablaCabecera'>";
	    		textoHTML += "<th>NRO.MOV.</th>";
	    		textoHTML += "<th>FECHA</th>";
	    		textoHTML += "<th>TIPO</th>";
	    		textoHTML += "<th>IMPORTE</th>";
	        textoHTML += "<tr/>";
	        
	        for (index = 0; index < arrayJson.length; ++index) {
	          
	          var r = arrayJson[index];
	        	console.log(r.TIPONOMBRE);
	            textoHTML += "<tr class='tablaFila1'>";
	            textoHTML += "<td>" + r.MOVINUMERO + "</td>";
	            textoHTML += "<td>" + r.MOVIFECHA + "</td>";
	            textoHTML += "<td>" + r.TIPONOMBRE + "</td>";
	            textoHTML += "<td>" + r.MOVIIMPORTE + "</td>";
	            textoHTML += "<tr/>";
	          }
	          
	        
	        textoHTML += "</table>";
	    		
	    	}
	      $("#divMovimientos").html(textoHTML);
	    });
	  });
  

</script>
</body>
</html>