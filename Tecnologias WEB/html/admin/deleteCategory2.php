<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Gestionar Productos</title>
	<link href="../../css/adminStyle.css" rel="stylesheet" type="text/css">
  </head>
	<body>
	<span style="float:left">Usted est&aacute aqu&iacute: <a href="main.php">Inicio</a> > <a href="products.php">Gesti&oacuten de productos</a> > <a href="categories.php">Gesti&oacuten de categorias</a> > Eliminar categoria</span><br/>
	<center>
	<div>
<?php
	include ('../../db/conexion.php');		// con esta línea puedo hacer uso en esta página php de funciones o variables definidas en otra pagina php (conexion.php)
	
	$cat = $_POST['categoria'];	

	mysql_query("UPDATE articulos SET categoria='Otros' WHERE categoria='$cat'");

	
	mysql_query("delete from categorias where nombre='$cat'");
	
?>


	<h2>Categor&iacutea eliminada correctamente</h2>
	<form action="categories.php">
	<input type="submit" value="Volver"/>
	</form>
	</div>
	</center>
	  </body>
</html>