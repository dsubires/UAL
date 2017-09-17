<!DOCTYPE html>
<html>
  <head>
	 <meta charset="UTF-8" />
    <title>Gestionar Clientes</title>
	<link href="../../css/adminStyle.css" rel="stylesheet" type="text/css">
  </head>
	<body>
	<span style="float:left">Usted est&aacute aqu&iacute: <a href="main.php">Inicio</a> > <a href="clients.php">Gesti&oacuten de clientes</a></span><br/>
		<section id="centralSection">
			<fieldset style="border-color:black;border-style:solid;">
			<legend>Gestionar Clientes</legend>
					<?php
					include ('../../db/conexion.php'); // con esta línea puedo hacer uso en esta página php de funciones o variables definidas en otra pagina php (conexion.php)
					$boton = $_REQUEST["resetFilter"];
					$orden = $_POST["ord"];
					
				//no se ha seleccionado filtro alguno, por tanto ejecutamos la consulta por defecto
				if(is_null($orden) or $orden == "--Orden--" or $boton == "Eliminar filtro" )
				{					
					// sending query
					$result = mysql_query("SELECT * FROM usuarios");
					if (!$result) {
						die("Error en la consulta");
					}

					
					
				//Se han seleccionado un filtro orden, por tanto ejecutamos la consulta oportuna
				}else if($orden != "--Orden--"){
					
					switch ($orden) {
						case "Alfabetico":
							// sending query
							$result = mysql_query("SELECT * FROM usuarios order by nombre ASC");
							if (!$result) {
								die("Error en la consulta");
							}
							break;
						case "Alfabetico inverso":
							// sending query
							$result = mysql_query("SELECT * FROM usuarios order by nombre DESC");
							if (!$result) {
								die("Error en la consulta");
							}
							break;
						case "Fecha Registro (Mas reciente)":
							// sending query
							$result = mysql_query("SELECT * FROM usuarios order by fechaRegistro DESC");
							if (!$result) {
								die("Error en la consulta");
							}
							break;
						case "Fecha Registro (Menos reciente)":
							// sending query
							$result = mysql_query("SELECT * FROM usuarios order by fechaRegistro ASC");
							if (!$result) {
								die("Error en la consulta");
							}
							break;
					}

				}
					

					
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
						$idCliente = 0;
						foreach($row as $cell){
							echo "<td>$cell</td>";
							if($cont == 1){
								$idCliente = $cell;
							}
							$cont += 1;
							
						}
							//dar permisos admin
							echo "<td>";
							echo "<form action='adminClient.php' method='post'>";
							echo "<input type='hidden' name='idCliente' value='$idCliente'/>";
							echo "<input type='submit' value='Modificar permisos'/></form>";
							echo "</form>";
							
							//eliminar cliente
							echo "<form action='deleteClient.php' method='post'>";
							echo "<input type='hidden' name='idCliente' value='$idCliente'/>";
							echo "<input type='submit' value='Eliminar'/></form>";
							echo "<td/>";
							echo "</tr>\n";
					}
					echo "</table>";
					mysql_free_result($result);
					?>
	
	<aside id="operationsMenu">
		<fieldset style="border-color:black;border-style:solid;">
			<legend>Operaciones</legend>

					<form action="clients.php" method="post">
					
					<?php
					
				//no se ha seleccionado filtro alguno, por tanto imprimimos el select por defecto	
				if(is_null($orden) or $orden == "--Orden--" or $boton == "Eliminar filtro" )
				{					

					echo "<select name='ord'>";
					echo "<option selected>--Orden--</option>";
					echo "<option>Alfabetico</option>";
					echo "<option>Alfabetico inverso</option>";
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
							echo "<option>Alfabetico inverso</option>";
							echo "<option>Fecha Registro (Mas reciente)</option>";
							echo "<option>Fecha Registro (Menos reciente)</option>";
							echo "</select> ";				
							echo "<input type='submit' value='Mostrar'/>";
							break;
						case "Alfabetico inverso":
							echo "<select name='ord'>";
							echo "<option>--Orden--</option>";
							echo "<option>Alfabetico</option>";
							echo "<option selected>Alfabetico inverso</option>";
							echo "<option>Fecha Registro (Mas reciente)</option>";
							echo "<option>Fecha Registro (Menos reciente)</option>";
							echo "</select> ";				
							echo "<input type='submit' value='Mostrar'/>";
							break;
						case "Fecha Registro (Mas reciente)":
							echo "<select name='ord'>";
							echo "<option>--Orden--</option>";
							echo "<option>Alfabetico</option>";
							echo "<option>Alfabetico inverso</option>";
							echo "<option selected>Fecha Registro (Mas reciente)</option>";
							echo "<option>Fecha Registro (Menos reciente)</option>";
							echo "</select> ";				
							echo "<input type='submit' value='Mostrar'/>";
							break;
						case "Fecha Registro (Menos reciente)":
							echo "<select name='ord'>";
							echo "<option>--Orden--</option>";
							echo "<option>Alfabetico</option>";
							echo "<option>Alfabetico inverso</option>";
							echo "<option>Fecha Registro (Mas reciente)</option>";
							echo "<option selected>Fecha Registro (Menos reciente)</option>";
							echo "</select> ";				
							echo "<input type='submit' value='Mostrar'/>";
							break;
					}
					echo "<br/>";
					echo "<form action='catalogo.php'>";
					echo "<input type='submit' name='resetFilter' value='Eliminar filtro'/>";
					echo "</form>";
				}
					?>
					

					
					
					</form>
					<form action="favs.php">
						<input type="submit" value="Ver favoritos clientes">
					</form>				
					<form action="ofrecidos.php">
						<input type="submit" value="Ver ofertas clientes">
					</form>
					<form action="main.php">
						<input type="submit" value="Atras">
					</form>

	</aside>
  </body>
</html>