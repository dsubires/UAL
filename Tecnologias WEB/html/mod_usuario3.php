<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Gestionar mis datos</title>
  </head>
<body>
<?php
	session_start();
	include ('../db/conexion.php');		// con esta línea puedo hacer uso en esta página php de funciones o variables definidas en otra pagina php (conexion.php)
	
	//obtenemos datos que el usuario proporcionó en el formulario y los actualizamos en nuestra BD
	
	
	$mail = $_SESSION['emailid'];
	
	$passwd = $_POST['passwd'];
	$nombre = $_POST['nombre'];
	$apellidos = $_POST['apellidos'];
	$tfn = $_POST['tfn'];
	$direccion = $_POST['direccion'];
	$cp = $_POST['cp'];
	$poblacion = $_POST['poblacion'];
	$pais = $_POST['pais'];
	
	
	
	$sql = "UPDATE usuarios SET password='$passwd', nombre='$nombre', apellidos='$apellidos' , telefono='$tfn', direccion='$direccion', cp='$cp', poblacion='$poblacion' , pais='$pais' WHERE mail='$mail'";
	mysql_query($sql);
	
?>
			Actializaci&oacuten de datos realizada correctamente<br/>

	<form action="mod_usuario.php">
	<input type="submit" value="Volver"/>
	</form>
	
	</center>
</body>
</html>