<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Gestionar Productos</title>
	<link href="../../css/adminStyle.css" rel="stylesheet" type="text/css">
  </head>
	<body>
	<span style="float:left">Usted est&aacute aqu&iacute: <a href="main.php">Inicio</a> > <a href="news.php">Gesti&oacuten de noticias</a> > Eliminar noticia</span><br/>
	<center>
	<div>
<?php
	include ('../../db/conexion.php');		// con esta línea puedo hacer uso en esta página php de funciones o variables definidas en otra pagina php (conexion.php)
	
	$idNoticia = $_POST['idNoticia'];
	
	mysql_query("delete from noticias where id_noticia='$idNoticia'");
	
?>


	<h2>Noticia eliminada correctamente</h2>
	<form action="news.php">
	<input type="submit" value="Volver"/>
	</form>
	</div>
	</center>
	  </body>
</html>