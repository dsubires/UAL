<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Gestionar Clientes</title>
	<link href="../../css/adminStyle.css" rel="stylesheet" type="text/css">
  </head>
	<body>
	<span style="float:left">Usted est&aacute aqu&iacute: <a href="main.php">Inicio</a> > <a href="clients.php">Gesti&oacuten de clientes</a> > Eliminar cliente</span><br/>
	<center>
	<h2>Vas a eliminar el siguiente cliente:</h2>
<?php
	include ('../../db/conexion.php');		// con esta línea puedo hacer uso en esta página php de funciones o variables definidas en otra pagina php (conexion.php)
	
	$idCliente = $_POST['idCliente'];
	
	$result = mysql_query("select * from usuarios where mail='$idCliente'");
	
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
	<h2>&iquestEstas seguro que deseas eliminarlo?</h2>
	<table>
	<tr><td>
	<form action="deleteClient2.php" method='post'>
	<input type='hidden' name='idCliente' value='<?php echo $idCliente; ?>'/>
	<input type="submit" value="Si"/>
	</form>
	
	<form action="clients.php">
	<input type="submit" value="No"/>
	</form>
	
	</td></tr>
	</table>
	
	</center>
	  </body>
</html>