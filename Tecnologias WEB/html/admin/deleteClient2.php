<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Gestionar Clientes</title>
	<link href="../../css/adminStyle.css" rel="stylesheet" type="text/css">
  </head>
	<body>
	<span style="float:left">Usted est&aacute aqu&iacute: <a href="main.php">Inicio</a> > <a href="clients.php">Gesti&oacuten de clientes</a> > Eliminar cliente</span><br/>
	<center>
	<div>
<?php
	include ('../../db/conexion.php');		// con esta línea puedo hacer uso en esta página php de funciones o variables definidas en otra pagina php (conexion.php)
	
	$idCliente = $_POST['idCliente'];	

	mysql_query("delete from articulosofrecidos WHERE mail='$idCliente'");
	mysql_query("delete from articulosfavsclientes WHERE mail='$idCliente'");
	mysql_query("delete from usuarios where mail='$idCliente'");
	
?>


	<h2>Cliente eliminado correctamente</h2>
	<form action="clients.php">
	<input type="submit" value="Volver"/>
	</form>
	</div>
	</center>
	  </body>
</html>