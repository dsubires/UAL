<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
    <title>Register</title>
	 
  </head>
  <body>
	<?php	
		session_start();
		include_once "../db/conexion.php";
		
		
		if(isset($_POST['register']))
		{
			echo $_POST['email'];
			
						$fecha_actual = new DateTime();
						$fecha = $fecha_actual->format("Y/m/d");
			
			mysql_query("INSERT INTO usuarios(mail, password, nombre, apellidos, telefono, direccion, cp, poblacion, pais, fechaRegistro, admin) VALUES ('".$_POST['email']."', '".$_POST['passwd']."', '".$_POST['usrName']."', '".$_POST['surname']."', '".$_POST['phone']."', '".$_POST['address']."', '".$_POST['cpCode']."', '".$_POST['poblacion']."', '".$_POST['country']."','".$fecha."', 'NULL')")  or die("MySQL ERROR: ".mysql_error());
		}
		
	?>
	Registrado correctamente. Inicia sesion<br/>
			<a href="principal.php">Volver</a>
  </body>