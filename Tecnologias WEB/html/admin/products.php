<!DOCTYPE html>
<html>
  <head>
     <meta charset="UTF-8">
    <title>Gestionar Productos</title>
	<link href="../../css/adminStyle.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" href="../../css/lightbox.min.css">
  </head>
	<body>
	<span style="float:left">Usted est&aacute aqu&iacute: <a href="main.php">Inicio</a> > <a href="products.php">Gesti&oacuten de productos</a></span>
		<section id="centralSection">
			<fieldset style="border-color:black;border-style:solid;">
			<legend>Gestionar Productos</legend>

					<?php
					include ('../../db/conexion.php');
					
					$boton = $_REQUEST["resetFilter"];
					$categoria = $_POST["cat"];
					$orden = $_POST["ord"];
								
						if(is_null($categoria) and is_null($orden) or $categoria == "--Categoria--" and $orden == "--Orden--" or $boton == "Eliminar filtros")
						{					
							// Consulta por defecto
							$result = mysql_query("SELECT * FROM articulos");
							if (!$result) {
								die("Error en la consulta");
							}
						}else{
							//segun el criterio de ordenacion seleccionado, ejecutamos una consulta sql u otra
							if($categoria != "--Categoria--" and $orden != "--Orden--"){
								switch ($orden) {
									case "Alfabetico":
										// enviamos consulta
										$result = mysql_query("SELECT * FROM articulos where categoria='$categoria' order by nombre ASC");
										if (!$result) {
											die("Error en la consulta");
										}
										break;
									case "Alfabetico inverso":
										// enviamos consulta
										$result = mysql_query("SELECT * FROM articulos where categoria='$categoria' order by nombre DESC");
										if (!$result) {
											die("Error en la consulta");
										}
										break;
									case "Precio (ascendente)":
										// enviamos consulta
										$result = mysql_query("SELECT * FROM articulos where categoria='$categoria' order by precio ASC");
										if (!$result) {
											die("Error en la consulta");
										}
										break;
									case "Precio (descendente)":
										// enviamos consulta
										$result = mysql_query("SELECT * FROM articulos where categoria='$categoria' order by precio DESC");
										if (!$result) {
											die("Error en la consulta");
										}
										break;
								}
							}else if($categoria != "--Categoria--"){
										$result = mysql_query("SELECT * FROM articulos where categoria='$categoria'");
										if (!$result) {
											die("Error en la consulta");
										}
							}else if($orden != "--Orden--"){
								switch ($orden) {
									case "Alfabetico":
										// enviamos consulta
										$result = mysql_query("SELECT * FROM articulos order by nombre ASC");
										if (!$result) {
											die("Error en la consulta");
										}
										break;
									case "Alfabetico inverso":
										// enviamos consulta
										$result = mysql_query("SELECT * FROM articulos order by nombre DESC");
										if (!$result) {
											die("Error en la consulta");
										}
										break;
									case "Precio (ascendente)":
										// enviamos consulta
										$result = mysql_query("SELECT * FROM articulos order by precio ASC");
										if (!$result) {
											die("Error en la consulta");
										}
										break;
									case "Precio (descendente)":
										// enviamos consulta
										$result = mysql_query("SELECT * FROM articulos order by precio DESC");
										if (!$result) {
											die("Error en la consulta");
										}
										break;
								}
							}
						}
						// la consulta no ha devuelto datos
						if (mysql_num_rows($result)==0){
							echo "<br/><center>No hay productos que mostrar</center>";
						//la consulta ha devuelto datos, los formateamos y los mostramos
						}else{
							$fields_num = mysql_num_fields($result);
				
							echo "<table id='productsTable'><tr>";
							// printing table headers
							for($i=0; $i<$fields_num; $i++)
							{
								$field = mysql_fetch_field($result);
								echo "<td>{$field->name}</td>";
							}
							echo "<td>Acciones</td>";
							echo "</tr>\n";
							// printing table rows
							while($row = mysql_fetch_row($result))
							{
								echo "<tr>";
							
								// $row is array... foreach( .. ) puts every element
								// of $row to $cell variable
								$cont = 1;
								$idArticulo = 0;
								$nombre = "";
								$imagen = "";
								foreach($row as $cell){
									if($cont == 1){
										$idArticulo = $cell;
										echo "<td>$cell</td>";
									}else if($cont == 2){
										$nombre = $cell;
										echo "<td>$cell</td>";
									}else if($cont == 5){
										$imagen = $cell;
										echo "<td><a href='../../images/articulos/$imagen' data-lightbox='image-$idArticulo' data-title='$nombre' >$cell</a></td>";
									}else{
										echo "<td>$cell</td>";
									}
									$cont += 1;
									
								}
									//editar y eliminar articulo
									echo "<td><form action='editArticulo.php' method='post'>";
									echo "<input type='hidden' name='idArticulo' value='$idArticulo'/>";
									echo "<input type='submit' value='Editar'/></form>";
									echo "<form action='deleteArticulo.php' method='post'>";
									echo "<input type='hidden' name='idArticulo' value='$idArticulo'/>";
									echo "<input type='submit' value='Eliminar'/></form><td/>";
									
									echo "</tr>\n";
							}
							echo "</table>";
							mysql_free_result($result);
						}
					?>
	
			</fieldset>
		</section>
		<aside id="operationsMenu">
		<fieldset style="border-color:black;border-style:solid;">
			<legend>Operaciones</legend>
				<form action="products.php" method="post">
				<?php

				//no se ha seleccionado filtro alguno, por tanto imprimimos los selects por defecto
				if(is_null($categoria) and is_null($orden) or $categoria == "--Categoria--" and $orden == "--Orden--" or $boton == "Eliminar filtros" )
				{					
					echo "<select name='cat'>";
					echo "<option selected>--Categoria--</option>";
					$result = mysql_query("SELECT * FROM categorias");
					while($row = mysql_fetch_row($result))
					{
						foreach($row as $cell){
							$cat = $cell;
							echo "<option value='$cat'>$cat</option>";
						}
					}
				
					echo "</select>";
					echo "<select name='ord'>";
					echo "<option selected>--Orden--</option>";
					echo "<option>Alfabetico</option>";
					echo "<option>Alfabetico inverso</option>";
					echo "<option>Precio (ascendente)</option>";
					echo "<option>Precio (descendente)</option>";
					echo "</select> ";				
					echo "<input type='submit' value='Mostrar'/>";
				
				//Se han seleccionado dos filtros, por tanto imprimimos los selects con la opcion seleccionada marcada como selected
				}else if($categoria != "--Categoria--" and $orden != "--Orden--"){
					echo "<select name='cat'>";
					echo "<option>--Categoria--</option>";
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
					echo "</select>";
					
					switch ($orden) {
						case "Alfabetico":
							echo "<select name='ord'>";
							echo "<option>--Orden--</option>";
							echo "<option selected>Alfabetico</option>";
							echo "<option>Alfabetico inverso</option>";
							echo "<option>Precio (ascendente)</option>";
							echo "<option>Precio (descendente)</option>";
							echo "</select> ";				
							echo "<input type='submit' value='Mostrar'/>";
							break;
						case "Alfabetico inverso":
							echo "<select name='ord'>";
							echo "<option>--Orden--</option>";
							echo "<option>Alfabetico</option>";
							echo "<option selected>Alfabetico inverso</option>";
							echo "<option>Precio (ascendente)</option>";
							echo "<option>Precio (descendente)</option>";
							echo "</select> ";				
							echo "<input type='submit' value='Mostrar'/>";
							break;
						case "Precio (ascendente)":
							echo "<select name='ord'>";
							echo "<option>--Orden--</option>";
							echo "<option>Alfabetico</option>";
							echo "<option>Alfabetico inverso</option>";
							echo "<option selected>Precio (ascendente)</option>";
							echo "<option>Precio (descendente)</option>";
							echo "</select> ";				
							echo "<input type='submit' value='Mostrar'/>";
							break;
						case "Precio (descendente)":
							echo "<select name='ord'>";
							echo "<option>--Orden--</option>";
							echo "<option>Alfabetico</option>";
							echo "<option>Alfabetico inverso</option>";
							echo "<option>Precio (ascendente)</option>";
							echo "<option selected>Precio (descendente)</option>";
							echo "</select> ";				
							echo "<input type='submit' value='Mostrar'/>";
							break;
					}
					echo "<br/>";
					echo "<form action='products.php'>";
					echo "<input type='submit' name='resetFilter' value='Eliminar filtros'/>";
					echo "</form>";
					
				//Se ha seleccionado el filtro categoria, por tanto imprimimos los selects con la opcion seleccionada marcada como selected	
				}else if($categoria != "--Categoria--"){								
					echo "<select name='cat'>";
					echo "<option>--Categoria--</option>";
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
				
					echo "</select>";
					echo "<select name='ord'>";
					echo "<option selected>--Orden--</option>";
					echo "<option>Alfabetico</option>";
					echo "<option>Alfabetico inverso</option>";
					echo "<option>Precio (ascendente)</option>";
					echo "<option>Precio (descendente)</option>";
					echo "</select> ";				
					echo "<input type='submit' value='Mostrar'/>";
					
					
					echo "<br/>";
					echo "<form action='products.php'>";
					echo "<input type='submit' name='resetFilter' value='Eliminar filtros'/>";
					echo "</form>";
				
				//Se ha seleccionado el filtro Orden, por tanto imprimimos los selects con la opcion seleccionada marcada como selected	
				}else if($orden != "--Orden--"){
					
					echo "<select name='cat'>";
					echo "<option selected>--Categoria--</option>";
					$result = mysql_query("SELECT * FROM categorias");
					while($row = mysql_fetch_row($result))
					{
						foreach($row as $cell){
							$cat = $cell;
							echo "<option value='$cat'>$cat</option>";
						}
					}
					echo "</select>";
					
					switch ($orden) {
						case "Alfabetico":
							echo "<select name='ord'>";
							echo "<option>--Orden--</option>";
							echo "<option selected>Alfabetico</option>";
							echo "<option>Alfabetico inverso</option>";
							echo "<option>Precio (ascendente)</option>";
							echo "<option>Precio (descendente)</option>";
							echo "</select> ";				
							echo "<input type='submit' value='Mostrar'/>";
							break;
						case "Alfabetico inverso":
							echo "<select name='ord'>";
							echo "<option>--Orden--</option>";
							echo "<option>Alfabetico</option>";
							echo "<option selected>Alfabetico inverso</option>";
							echo "<option>Precio (ascendente)</option>";
							echo "<option>Precio (descendente)</option>";
							echo "</select> ";				
							echo "<input type='submit' value='Mostrar'/>";
							break;
						case "Precio (ascendente)":
							echo "<select name='ord'>";
							echo "<option>--Orden--</option>";
							echo "<option>Alfabetico</option>";
							echo "<option>Alfabetico inverso</option>";
							echo "<option selected>Precio (ascendente)</option>";
							echo "<option>Precio (descendente)</option>";
							echo "</select> ";				
							echo "<input type='submit' value='Mostrar'/>";
							break;
						case "Precio (descendente)":
							echo "<select name='ord'>";
							echo "<option>--Orden--</option>";
							echo "<option>Alfabetico</option>";
							echo "<option>Alfabetico inverso</option>";
							echo "<option>Precio (ascendente)</option>";
							echo "<option selected>Precio (descendente)</option>";
							echo "</select> ";				
							echo "<input type='submit' value='Mostrar'/>";
							break;
					}
					
										
					echo "<br/>";
					echo "<form action='products.php'>";
					echo "<input type='submit' name='resetFilter' value='Eliminar filtros'/>";
					echo "</form>";
					

				}

				?>
					</form>

					<form action="addproducts.php">
						<input type="submit" value="Añadir producto"/>
					</form>

					<form action="categories.php">
					<input name="submit" value="Administrar Categorias" type="submit">
					</form>

					<form action="main.php">
						<input type="submit" value="Atras">
					</form>

		</fieldset>
	</aside>
	<script src="../../js/lightbox-plus-jquery.min.js"></script>	
  </body>
</html>