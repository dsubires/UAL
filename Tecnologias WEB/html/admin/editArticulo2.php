<!DOCTYPE html>
<html lang=”es-ES”>

	<head> 
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    </head>
    <body>
	<span style="float:left">Usted est&aacute aqu&iacute: <a href="main.php">Inicio</a> > <a href="products.php">Gesti&oacuten de productos</a> >  Editar producto</span><br/>
	<center>

<?php

	include ('../../db/conexion.php');		// con esta línea puedo hacer uso en esta página php de funciones o variables definidas en otra pagina php (conexion.php)
	
			$id = $_POST["idArticulo"];
			$nombre = $_POST["nombre"];
			$descripcion = $_POST["descripcion"];
			$precio = $_POST["precio"];
			$categoria = $_POST["categoria"];

			
			$sql = "UPDATE articulos SET nombre='$nombre', descripcion='$descripcion', precio='$precio', categoria='$categoria' WHERE id_articulo='$id'";

			mysql_query($sql);
		?>
			Art&iacuteculo modificado correctamente<br/>

	<form action="products.php">
	<input type="submit" value="Volver"/>
	</form>
	
	</center>
</body>
</html>