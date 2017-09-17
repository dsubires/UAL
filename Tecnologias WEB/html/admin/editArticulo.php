<!DOCTYPE html>
<?php

	include ('../../db/conexion.php');		// con esta línea puedo hacer uso en esta página php de funciones o variables definidas en otra pagina php (conexion.php)
	
	//obtenemos datos del articulo para mostrarlos por pantalla y poder modificarlos
	$idArticulo = $_POST['idArticulo'];
	$result = mysql_query("select * from articulos where id_articulo='$idArticulo'");
	$array = mysql_fetch_array($result);
	$nombre = $array['nombre'];
	$categoria = $array['categoria'];
	$descripcion = $array['descripcion'];
	$imagen = $array['imagen'];
	$precio = $array['precio'];
?>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Gestionar Productos</title>
	<link href="../../css/adminStyle.css" rel="stylesheet" type="text/css">
  </head>
	<body>
	<span style="float:left">Usted est&aacute aqu&iacute: <a href="main.php">Inicio</a> > <a href="products.php">Gesti&oacuten de productos</a> >  Editar producto</span><br/>
			<fieldset style="border-color:black;border-style:solid;">
			<legend>Gestionar Productos</legend>
				<form action="editArticulo2.php" method="POST" enctype="multipart/form-data">
					<?php
					echo "<input type='hidden' name='idArticulo' value='$idArticulo'/>";
					echo "<img alt='Foto a editar' src='../../images/articulos/$imagen' style='float:left' width='30%' />";				
					?>
					<label>Nombre:</label>
					<input type="text" id="nombre" name="nombre" value="<?php echo $nombre; ?>" required/><br/>
					<label>Categoria:</label>
					<select id="categoria" name="categoria">
					<?php
						$result = mysql_query("SELECT * FROM categorias");
						while($row = mysql_fetch_row($result))
					{
							foreach($row as $cell){
								$cat = $cell;
								if($cat == $categoria){
									echo "<option value='$cat' selected>$cat</option>";
								}else{
									echo "<option value='$cat'>$cat</option>";
								}
								
							}
					}
					?>
					</select><br/>
					<textarea id="descripcion" name="descripcion" COLS=40 ROWS=6 required><?php echo $descripcion; ?></textarea><br/>
 					<label>Precio</label>
					<input type="number" id="precio" name="precio" step="any" value="<?php echo $precio; ?>" required/><br/>
					<input type="submit" value="Guardar" /> 
				</form>
					<form action="products.php">
						<input type="submit" value="Descartar cambios">
					</form>
</html>