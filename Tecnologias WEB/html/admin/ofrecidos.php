<!DOCTYPE html>
<html>
  <head>
	 <meta charset="UTF-8" />
    <title>Gestionar Clientes</title>
	<link href="../../css/adminStyle.css" rel="stylesheet" type="text/css">
  </head>
	<body>
	<span style="float:left">Usted est&aacute aqu&iacute: <a href="main.php">Inicio</a> > <a href="clients.php">Gesti&oacuten de clientes</a> > <a href="ofrecidos.php">Productos ofrecidos por clientes</a></span><br/>
		<section id="centralSection">
			<fieldset style="border-color:black;border-style:solid;">
			<legend>Gestionar Clientes</legend>
					<?php
					include ('../../db/conexion.php'); // con esta línea puedo hacer uso en esta página php de funciones o variables definidas en otra pagina php (conexion.php);
						
					// sending query
					$result = mysql_query("SELECT * FROM articulosofrecidos");
					if (!$result) {
						die("Error en la consulta");
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
					echo "</tr>\n";
					// printing table rows
					while($row = mysql_fetch_row($result))
					{
						echo "<tr>";
					
						// $row is array... foreach( .. ) puts every element
						// of $row to $cell variable

						foreach($row as $cell){
							echo "<td>$cell</td>";
						}
							echo "</tr>";
					}
					echo "</table>";
					mysql_free_result($result);
					?>
	
	<aside id="operationsMenu">
		<fieldset style="border-color:black;border-style:solid;">
			<legend>Operaciones</legend>


					<form action="clients.php">
						<input type="submit" value="Atras">
					</form>
		</fieldset>
	</aside>
  </body>
</html>