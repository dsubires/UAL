<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Gestionar Clientes</title>
	<link href="../../css/adminStyle.css" rel="stylesheet" type="text/css">
  </head>
	<body>
	<span style="float:left">Usted est&aacute aqu&iacute: <a href="main.php">Inicio</a> > <a href="clients.php">Gesti&oacuten de clientes</a> > Dar permisos administrador</span><br/>
	<center>
	<div>
	
<?php
	include ('../../db/conexion.php');		// con esta línea puedo hacer uso en esta página php de funciones o variables definidas en otra pagina php (conexion.php)
	
	$idCliente = $_POST['idCliente'];	
	$result = mysql_query("select admin from usuarios where mail = '$idCliente' ");
	$fila = mysql_fetch_row($result);
	$admin = $fila[0];

	
	if($admin == 1){
		mysql_query("update usuarios set admin = false where mail = '$idCliente'");
	}else{
		mysql_query("update usuarios set admin = true where mail = '$idCliente'");
	}
	
	

	

	

	
?>


	<h2>Permisos modificados correctamente</h2>
	<form action="clients.php">
	<input type="submit" value="Volver"/>
	</form>
	</div>
	</center>
	  </body>
</html>