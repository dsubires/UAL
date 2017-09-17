<!DOCTYPE html>
<html>
  <head>
     <meta charset="UTF-8">
    <title>Gestionar Noticias</title>
	<link href="../../css/adminStyle.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" href="../../css/lightbox.min.css">
  </head>
	<body>
	<span style="float:left">Usted est&aacute aqu&iacute: <a href="main.php">Inicio</a> > <a href="news.php">Gesti&oacuten de noticias</a></span><br/>
		<section id="centralSection">
			<fieldset style="border-color:black;border-style:solid;">
			<legend>Gestionar Noticias</legend>
					<?php
					include ('../../db/conexion.php'); // con esta línea puedo hacer uso en esta página php de funciones o variables definidas en otra pagina php (conexion.php)
					$boton = $_REQUEST["resetFilter"];
					$orden = $_POST["ord"];
					
				//no se ha seleccionado filtro alguno, por tanto ejecutamos la consulta por defecto
				if(is_null($orden) or $orden == "--Orden--" or $boton == "Eliminar filtro" )
				{					
					// sending query
					$result = mysql_query("SELECT * FROM noticias");
					if (!$result) {
						die("Error en la consulta");
					}
					
					
				//Se han seleccionado un filtro orden, por tanto ejecutamos la consulta oportuna
				}else if($orden != "--Orden--"){
					
					switch ($orden) {
						case "Alfabetico":
							// sending query
							$result = mysql_query("SELECT * FROM noticias order by titulo ASC");
							if (!$result) {
								die("Error en la consulta");
							}
							break;
						case "Alfabetico Inverso":
							// sending query
							$result = mysql_query("SELECT * FROM noticias order by titulo DESC");
							if (!$result) {
								die("Error en la consulta");
							}
							break;
						case "Fecha Registro (Mas reciente)":
							// sending query
							$result = mysql_query("SELECT * FROM noticias order by fecha DESC, titulo");
							if (!$result) {
								die("Error en la consulta");
							}
							break;
						case "Fecha Registro (Menos reciente)":
							// sending query
							$result = mysql_query("SELECT * FROM noticias order by fecha ASC, titulo");
							if (!$result) {
								die("Error en la consulta");
							}
							break;
					}

				}
					
					
					
					

				// una vez tenemos los datos proporcionados por la consulta correcta, los formateamos e imprimimos 	
					$fields_num = mysql_num_fields($result);
					//sumamos uno para la columna Acciones
				
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
						$idNoticia = 0;
						$titulo = "";
						$imagen = "";
						foreach($row as $cell){
							if($cont == 1){
								$idNoticia = $cell;
								echo "<td>$cell</td>";
							}else if($cont == 2){
								$titulo = $cell;
								echo "<td>$cell</td>";
							}else if($cont == 4){
								$imagen = $cell;
								echo "<td><a href='../../images/articulos/$imagen' data-lightbox='image-$idNoticia' data-title='$titulo' >$cell</a></td>";
							}else{
								echo "<td>$cell</td>";
							}
							$cont += 1;
							
						}
							//editar y eliminar articulo
							echo "<td><form action='editNews.php' method='post'>";
							echo "<input type='hidden' name='idNoticia' value='$idNoticia'/>";
							echo "<input type='submit' value='Editar'/></form>";
							echo "<form action='deleteNews.php' method='post'>";
							echo "<input type='hidden' name='idNoticia' value='$idNoticia'/>";
							echo "<input type='submit' value='Eliminar'/></form><td/>";
							
							echo "</tr>\n";
					}
					echo "</table>";
					mysql_free_result($result);
					?>
		</section>
	
	<aside id="operationsMenu">
		<fieldset style="border-color:black;border-style:solid;">
			<legend>Operaciones</legend>
					<form action="news.php" method="post">
				
				<?php
				//no se ha seleccionado filtro alguno, por tanto imprimimos el select por defecto	
				if(is_null($orden) or $orden == "--Orden--" or $boton == "Eliminar filtro" )
				{					

					echo "<select name='ord'>";
					echo "<option selected>--Orden--</option>";
					echo "<option>Alfabetico</option>";
					echo "<option>Alfabetico Inverso</option>";
					echo "<option>Fecha Registro (Mas reciente)</option>";
					echo "<option>Fecha Registro (Menos reciente)</option>";
					echo "</select> ";				
					echo "<input type='submit' value='Mostrar'/>";
					
					
				//Se han seleccionado un filtro orden, por tanto imprimimos el select con la opcion seleccionada marcada como selected
				}else if($orden != "--Orden--"){
					
					switch ($orden) {
						case "Alfabetico":
							echo "<select name='ord'>";
							echo "<option>--Orden--</option>";
							echo "<option selected>Alfabetico</option>";
							echo "<option>Alfabetico Inverso</option>";
							echo "<option>Fecha Registro (Mas reciente)</option>";
							echo "<option>Fecha Registro (Menos reciente)</option>";
							echo "</select> ";				
							echo "<input type='submit' value='Mostrar'/>";
							break;
						case "Alfabetico Inverso":
							echo "<select name='ord'>";
							echo "<option>--Orden--</option>";
							echo "<option>Alfabetico</option>";
							echo "<option selected>Alfabetico Inverso</option>";
							echo "<option>Fecha Registro (Mas reciente)</option>";
							echo "<option>Fecha Registro (Menos reciente)</option>";
							echo "</select> ";				
							echo "<input type='submit' value='Mostrar'/>";
							break;
						case "Fecha Registro (Mas reciente)":
							echo "<select name='ord'>";
							echo "<option>--Orden--</option>";
							echo "<option>Alfabetico</option>";
							echo "<option>Alfabetico Inverso</option>";
							echo "<option selected>Fecha Registro (Mas reciente)</option>";
							echo "<option>Fecha Registro (Menos reciente)</option>";
							echo "</select> ";				
							echo "<input type='submit' value='Mostrar'/>";
							break;
						case "Fecha Registro (Menos reciente)":
							echo "<select name='ord'>";
							echo "<option>--Orden--</option>";
							echo "<option selected>Alfabetico</option>";
							echo "<option>Alfabetico Inverso</option>";
							echo "<option>Fecha Registro (Mas reciente)</option>";
							echo "<option selected>Fecha Registro (Menos reciente)</option>";
							echo "</select> ";				
							echo "<input type='submit' value='Mostrar'/>";
							break;
					}
					echo "<br/>";
					echo "<form action='news.php'>";
					echo "<input type='submit' name='resetFilter' value='Eliminar filtro'/>";
					echo "</form>";
				}
					?>
					</form>
					<form action="addnews.php">
						<input type="submit" value="Añadir noticia"/>
					</form>

					<form action="main.php">
						<input type="submit" value="Atras">
					</form>

	</aside>
	<script src="../../js/lightbox-plus-jquery.min.js"></script>	
  </body>
</html>