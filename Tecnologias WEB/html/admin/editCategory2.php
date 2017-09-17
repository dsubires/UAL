<!DOCTYPE html>
<html lang=”es-ES”>

	<head> 
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    </head>
    <body>
	<span style="float:left">Usted est&aacute aqu&iacute: <a href="main.php">Inicio</a> > <a href="products.php">Gesti&oacuten de productos</a> > <a href="categories.php"> Gesti&oacuten de categorias</a> > Editar categoria</span><br/>
	<center>

<?php

	include ('../../db/conexion.php');		// con esta línea puedo hacer uso en esta página php de funciones o variables definidas en otra pagina php (conexion.php)
	
			$cat = $_POST["categoria"];			
			$catN = $_POST["categoriaNueva"];			
			
			
			//Para modificar una categoria, que ya está asignada como foreign key a articulos,
			//añado una categoria temporal, la asigno a dichos productos, modifico la categoria deseada, y asigno la nueva categoria ya modificada a todos los productos
			//que tengan la categoria temporal asignada. Por ultimo eliminamos la categoria temporal
			
			$sql = "INSERT INTO categorias(nombre)
			VALUES ('temporal')";
			mysql_query($sql);
			
			$sql = "UPDATE articulos SET categoria='temporal' WHERE categoria='$cat'";
			mysql_query($sql);
			
			$sql = "UPDATE categorias SET nombre='$catN' WHERE nombre='$cat'";
			mysql_query($sql);
			
			$sql = "UPDATE articulos SET categoria='$catN' WHERE categoria='temporal'";
			mysql_query($sql);
			
			mysql_query("delete from categorias where nombre='temporal'");
			
			
		?>
			Categor&iacutea modificada correctamente<br/>
				<form action="categories.php">
					<input type="submit" value="Volver"/>
				</form>


	
	</center>
</body>
</html>