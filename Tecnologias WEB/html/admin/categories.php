<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Gestionar Categorias</title>
	<link href="../../css/adminStyle.css" rel="stylesheet" type="text/css">
  </head>
	<body>
	<span style="float:left">Usted est&aacute aqu&iacute: <a href="main.php">Inicio</a> > <a href="products.php">Gesti&oacuten de productos</a> > <a href="categories.php"> Gesti&oacuten de categorias</a></span><br/>
		<section id="centralSection">
			<fieldset style="border-color:black;border-style:solid;">
			<legend>Gestionar Categorias</legend>

					<?php
					include ('../../db/conexion.php');
					// sending query
					$result = mysql_query("SELECT * FROM categorias");
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
					echo "<td>Acciones</td>";
					echo "</tr>\n";
					// printing table rows
					while($row = mysql_fetch_row($result))
					{
						echo "<tr>";
					
						// $row is array... foreach( .. ) puts every element
						// of $row to $cell variable
						$cat = "";
						foreach($row as $cell){
							echo "<td>$cell</td>";
								$cat = $cell;
							
						}
							//editar y eliminar articulo
							echo "<td><form action='editCategory.php' method='post'>";
							echo "<input type='hidden' name='categoria' value='$cat'/>";
							echo "<input type='submit' value='Editar'/></form>";
							echo "<form action='deleteCategory.php' method='post'>";
							echo "<input type='hidden' name='categoria' value='$cat'/>";
							echo "<input type='submit' value='Eliminar'/></form><td/>";
							
							echo "</tr>\n";
					}
					echo "</table>";
					mysql_free_result($result);
					?>
	
			</fieldset>
		</section>
		<aside id="operationsMenu">
		<fieldset style="border-color:black;border-style:solid;">
			<legend>Operaciones</legend>
		<table>
			<tr>
				<td>
					<select id="orderType">
						<option value="Alfabetico">Alfabetico</option>
						<option value="Alfabetico-reverse">Alfabetico Inverso</option>
						<option value="Fecha-registro-recents">Fecha Registro (Mas reciente)</option>
						<option value="Fecha-registro-older">Fecha Registro (Mas tardia)</option>
					</select> 
				</td>
			</tr>
			<tr>
				<td>
					<form action="addcategories.php">
						<input type="submit" value="Añadir categoria"/>
					</form>
				</td>
			</tr>	
			<tr>
				<td>
					<form action="products.php">
						<input type="submit" value="Atras">
					</form>
				</td>
			</tr>	
		</table>
		</fieldset>
	</aside>
  </body>
</html>