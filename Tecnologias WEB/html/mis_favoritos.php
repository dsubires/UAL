<!DOCTYPE html>
<html>
  <head>
	 <meta charset="UTF-8" />
    <title>Gestionar Clientes</title>
	<style>
	 .imgA{
		position:relative;
		float:left;
		width:15%;
		margin-top:2%;
		margin-left:2%;
		padding:5px;
	}
	fieldset span{
		position:relative;
		float:left;
		margin-left:2%;
		padding:5px;
	}
	
	fieldset span h3{
		position:relative;
		float:left;

		
		padding:5px;
		
	}
	
	fieldset h3 a{
		text-decoration:none;
		color:black;
	}
	
	.articuloC{
		border-color:black;
		border-style:solid;
	}
	.fav{
		width:2%;
		float:right;
	}
	.share{
		width:2%;
		float:right;
	}
	 </style>
  </head>
	<body>
  <h2>Mis favoritos:</h2>
    <center>

		
		<form action="mis_favoritos.php" method="post">
			<?php
				session_start();
				include ('../db/conexion.php');		// con esta línea puedo hacer uso en esta página php de funciones o variables definidas en otra pagina php (conexion.php)
				
				$boton = $_REQUEST["resetFilter"];
				$categoria = $_POST["cat"];
				$orden = $_POST["ord"];
				$mailID = $_SESSION['emailid'];		
		
		
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
					echo "<form action='mis_favoritos.php'>";
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
					echo "<form action='mis_favoritos.php'>";
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
					echo "<form action='mis_favoritos.php'>";
					echo "<input type='submit' name='resetFilter' value='Eliminar filtros'/>";
					echo "</form>";
					

				}

			?>			
		
		</form>
		<?php		
						if(is_null($categoria) and is_null($orden) or $categoria == "--Categoria--" and $orden == "--Orden--" or $boton == "Eliminar filtros")
						{					
							// Consulta por defecto
							$result = mysql_query("SELECT * FROM articulos NATURAL JOIN articulosfavsclientes WHERE mail = '$mailID'");
							if (!$result) {
								die("Error en la consulta");
							}
						}else{
							//segun el criterio de ordenacion seleccionado, ejecutamos una consulta sql u otra
							if($categoria != "--Categoria--" and $orden != "--Orden--"){
								switch ($orden) {
									case "Alfabetico":
										// enviamos consulta
										$result = mysql_query("SELECT * FROM articulos NATURAL JOIN articulosfavsclientes WHERE mail = '$mailID' and categoria='$categoria' order by nombre ASC");
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
										$result = mysql_query("SELECT * FROM articulos NATURAL JOIN articulosfavsclientes WHERE mail = '$mailID' and categoria='$categoria' order by precio ASC");
										if (!$result) {
											die("Error en la consulta");
										}
										break;
									case "Precio (descendente)":
										// enviamos consulta
										$result = mysql_query("SELECT * FROM articulos NATURAL JOIN articulosfavsclientes WHERE mail = '$mailID' and categoria='$categoria' order by precio DESC");
										if (!$result) {
											die("Error en la consulta");
										}
										break;
								}
							}else if($categoria != "--Categoria--"){
										$result = mysql_query("SELECT * FROM articulos NATURAL JOIN articulosfavsclientes WHERE mail = '$mailID' and categoria='$categoria'");
										if (!$result) {
											die("Error en la consulta");
										}
							}else if($orden != "--Orden--"){
								switch ($orden) {
									case "Alfabetico":
										// enviamos consulta
										$result = mysql_query("SELECT * FROM articulos NATURAL JOIN articulosfavsclientes WHERE mail = '$mailID' order by nombre ASC");
										if (!$result) {
											die("Error en la consulta");
										}
										break;
									case "Alfabetico inverso":
										// enviamos consulta
										$result = mysql_query("SELECT * FROM articulos NATURAL JOIN articulosfavsclientes WHERE mail = '$mailID' order by nombre DESC");
										if (!$result) {
											die("Error en la consulta");
										}
										break;
									case "Precio (ascendente)":
										// enviamos consulta
										$result = mysql_query("SELECT * FROM articulos NATURAL JOIN articulosfavsclientes WHERE mail = '$mailID' order by precio ASC");
										if (!$result) {
											die("Error en la consulta");
										}
										break;
									case "Precio (descendente)":
										// enviamos consulta
										$result = mysql_query("SELECT * FROM articulos NATURAL JOIN articulosfavsclientes WHERE mail = '$mailID' order by precio DESC");
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
							while($row = mysql_fetch_row($result))
							{
								$nombre = $row[1];
								$descripcion = $row[2];
								$precio = $row[3];
								$imagen = $row[4];
								$categoria = $row[7];								
								echo "<fieldset class='articuloC'>";
								echo "<legend>$nombre</legend>";
								echo "<img src='../images/articulos/$imagen' alt='$nombre' class='imgA'/><br/><span>";
								//$temp= "onClick=";
								//$temp .= '"top.window.location.href=';
								//$temp .= "'index.php?item=".$row[0]."';";
								//$temp .= '"';
								$temp= "onClick=";
								$temp.="top.window.history.pushState('data','Titulo','index.php?item=".$row[0]."');";
								
								echo "<h3><a href='ver_producto.php?id=$row[0]' ".$temp.">$nombre    Precio:$precio €    Categor&iacutea: $categoria</a></h3> <br/><br/><br/><br/>$descripcion</span><br/><br/><br/><br/><br/><br/><br/>";
								//echo "<h3><a href='ver_producto.php?id=$row[0]'>$nombre    Precio:$precio €    Categor&iacutea: $categoria</a></h3> <br/><br/><br/><br/>$descripcion</span><br/><br/><br/><br/><br/><br/><br/>";
								
								echo "</fieldset>";
							}
							mysql_free_result($result);
						}
						
		?>			
					<form action="micuenta.php">
						<input type="submit" value="Atras">
					</form>
	</center>
  </body>
</html>