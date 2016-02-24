<div class="menu">
	<ul>
	
		<li><a href="#" >Home</a></li>
		
		<li><a href="#">Procesos</a>
			<ul>
				<li><a href="#">Crear cuenta</a></li>
				<li><a href="javascript: fnLoadPage('deposito.jsp');">Depósito</a></li>
				<li><a href="#">Retiro</a></li>
				<li><a href="#">Transferencia</a></li>
		   </ul>
	  </li>

    <li><a href="#">Tablas</a>
      <ul>
        <li><a href="#">Clientes</a></li>
        <li><a href="#">Sucursales</a></li>
        <li><a href="#">Empleados</a></li>
       </ul>
    </li>

    <li><a href="#">Consultas</a>
      <ul>
        <li><a href="#">Movimientos</a></li>
        <li><a href="#">Clientes</a></li>
       </ul>
    </li>

    <li><a href="#">Reportes</a>
      <ul>
        <li><a href="#">Movimientos</a></li>
        <li><a href="#">Clientes</a></li>
       </ul>
    </li>

	</ul>
</div>

<script type="text/javascript">

  function fnLoadPage(pagina){
    $("#divWORK").load(pagina);
  }

</script>
