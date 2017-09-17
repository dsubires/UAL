<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Gestionar Productos</title>
	<link href="../../css/adminStyle.css" rel="stylesheet" type="text/css">
  </head>
	<body>
	<span style="float:left">Usted est&aacute aqu&iacute: <a href="main.php">Inicio</a> > <a href="products.php">Gesti&oacuten de productos</a> > <a href="categories.php">Gesti&oacuten de categorias</a> > Eliminar categoria</span><br/>
	<center>
	<h2>Vas a eliminar la siguiente categor&iacutea:</h2>
<?php
	include ('../../db/conexion.php');		// con esta línea puedo hacer uso en esta página php de funciones o variables definidas en otra pagina php (conexion.php)
	
	$cat = $_POST['categoria'];
	
	$result = mysql_query("select * from categorias where nombre='$cat'");
	
		$fields_num = mysql_num_fields($result);
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
			foreach($row as $cell)
				echo "<td>$cell</td>";
		}
		echo "</table>";
		mysql_free_result($result);
?>

	<br/><br/><br/>
	<h2>&iquestEstas seguro que deseas eliminarla?</h2>
	<h3>En caso de que alg&uacuten art&iacuteculo tenga asignada esta categor&iacutea, <span font-color="red">se le asignar&aacute la categor&iacutea Otros</span></h3>
	<table>
	<tr><td>
	<form action="deleteCategory2.php" method='post'>
	<input type='hidden' name='categoria' value='<?php echo $cat; ?>'/>
	<input type="submit" value="Si"/>
	</form>
	
	<form action="categories.php">
	<input type="submit" value="No"/>
	</form>
	
	</td></tr>
	</table>
	
	</center>
	  </body>
</html>