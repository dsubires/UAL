<!DOCTYPE html>
<?php

	include ('../../db/conexion.php');		// con esta línea puedo hacer uso en esta página php de funciones o variables definidas en otra pagina php (conexion.php)
	
	//obtenemos datos del articulo para mostrarlos por pantalla y poder modificarlos
	$cat = $_POST['categoria'];
?>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Gestionar Categorias</title>
	<link href="../../css/adminStyle.css" rel="stylesheet" type="text/css">
  </head>
	<body>
	<span style="float:left">Usted est&aacute aqu&iacute: <a href="main.php">Inicio</a> > <a href="products.php">Gesti&oacuten de productos</a> > <a href="categories.php"> Gesti&oacuten de categorias</a> > Editar categoria</span><br/>
			<fieldset style="border-color:black;border-style:solid;">
			<legend>Gestionar Productos</legend>
				<form action="editCategory2.php" method="POST">
					<?php
					echo "<input type='hidden' name='categoria' value='$cat'/>";
					?>
					<label>Categoria:</label>
					<input type="text" id="categoria" name="categoriaNueva" value="<?php echo $cat; ?>" required/><br/>
					<input type="submit" value="Guardar" /> 
				</form>
					<form action="categories.php">
						<input type="submit" value="Descartar cambios">
					</form>
</html>