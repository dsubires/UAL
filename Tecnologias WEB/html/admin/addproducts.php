<!DOCTYPE html>
<html>
  <head>
     <meta charset="UTF-8">
    <title>Gestionar Productos</title>
	<link href="../../css/adminStyle.css" rel="stylesheet" type="text/css">
  </head>
	<body>
	<span style="float:left">Usted est&aacute aqu&iacute: <a href="main.php">Inicio</a> > <a href="products.php">Gesti&oacuten de productos</a> > <a href="addproducts.php"> A&ntildeadir producto</a></span><br/>
			<fieldset style="border-color:black;border-style:solid;">
			<legend>Gestionar Productos</legend>
				<form action="addproducts2.php" method="POST" enctype="multipart/form-data">
					<label>Nombre:</label>
					<input type="text" id="nombre" name="nombre" placeholder="nombre..." required/><br/>
					<label>Categoria:</label>
					<select id="categoria" name="categoria">
					<?php
						include ('../../db/conexion.php');		// con esta línea puedo hacer uso en esta página php de funciones o variables definidas en otra pagina php (conexion.php)
						$result = mysql_query("SELECT * FROM categorias");
						while($row = mysql_fetch_row($result))
					{
							foreach($row as $cell){
								$cat = $cell;
								echo "<option value='$cat'>$cat</option>";
							}
					}
					?>
					</select><br/>
					<textarea id="descripcion" name="descripcion" COLS=40 ROWS=6 placeholder="Descripcion...." required></textarea><br/>
					<label>Foto</label>
					<input type="file" name="image" id="image" required/><br/>
					<label>Precio</label>
					<input type="number" id="precio" step="any" name="precio" placeholder="precio..." required/><br/>
					<input type="submit" value="Añadir" /> 
				</form>
					<form action="products.php">
						<input type="submit" value="Atras">
					</form>
</html>	