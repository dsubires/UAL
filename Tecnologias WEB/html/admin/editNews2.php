<!DOCTYPE html>
<html lang=”es-ES”>

	<head> 
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    </head>
    <body>
	<span style="float:left">Usted est&aacute aqu&iacute: <a href="main.php">Inicio</a> > <a href="news.php">Gesti&oacuten de noticias</a> > Editar noticia</span><br/>
	<center>

<?php

	include ('../../db/conexion.php');		// con esta línea puedo hacer uso en esta página php de funciones o variables definidas en otra pagina php (conexion.php)
	
			$id = $_POST["idNoticia"];
			$titulo = $_POST["titulo"];
			$descripcion = $_POST["descripcion"];

			
			$sql = "UPDATE noticias SET titulo='$titulo', descripcion='$descripcion' WHERE id_noticia='$id'";

			mysql_query($sql);
		?>
			Noticia modificado correctamente<br/>
			<form action="news.php">
				<input type="submit" value="Volver"/>
			</form>


	
	</center>
</body>
</html>