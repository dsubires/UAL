<!DOCTYPE html>
<html lang=”es-ES”>

	<head> 
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    </head>
    <body>
	<span style="float:left">Usted est&aacute aqu&iacute: <a href="main.php">Inicio</a> > <a href="products.php">Gesti&oacuten de productos</a> > <a href="categories.php"> Gesti&oacuten de categorias</a> > <a href="addcategories">A&ntildeadir categoria</a></span><br/>
	<center>

<?php

	include ('../../db/conexion.php');		// con esta línea puedo hacer uso en esta página php de funciones o variables definidas en otra pagina php (conexion.php)
	
			$cat = $_POST["categoria"];

			$sql = "INSERT INTO categorias(nombre)
			VALUES ('$cat')";

			mysql_query($sql);
		?>
			Categoria a&ntildeadida correctamente<br/>
			<form action="categories.php">
				<input type="submit" value="Volver"/>
			</form>


	
	</center>
</body>
</html>