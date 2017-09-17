<!DOCTYPE html>
<?php
	session_start();
	include ('../db/conexion.php');		// con esta línea puedo hacer uso en esta página php de funciones o variables definidas en otra pagina php (conexion.php)
	
	//obtenemos datos del usuario para mostrarlos por pantalla y poder modificarlos
	$mail = $_SESSION['emailid'];
	$result = mysql_query("select * from usuarios where mail='$mail'");
	$array = mysql_fetch_array($result);
	$passwd = $array['password'];
	$nombre = $array['nombre'];
	$apellidos = $array['apellidos'];
	$tfn = $array['telefono'];
	$direccion = $array['direccion'];
	$cp = $array['cp'];
	$poblacion = $array['poblacion'];
	$pais = $array['pais'];
	$fecha = $array['fechaRegistro'];
	$admin = $array['admin'];	
?>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Gestionar mis datos</title>
  </head>
	<body>
	<!--<span style="float:left">Usted est&aacute aqu&iacute: <a href="main.php">Inicio</a> > <a href="products.php">Gesti&oacuten de productos</a> >  Editar producto</span><br/>-->
			<fieldset style="border-color:black;border-style:solid;">
			<legend>Modificar mis datos</legend>
			<center>
				<form action="mod_usuario3.php" method="POST">
					<table>
					<tr><td>
					<label>Mail:</label>
					</td>
					<td>
					<input type="text" id="mail" name="mail" value="<?php echo $mail; ?>" disabled/>
					</td></tr>
					<tr><td>
					<label>Contrase&ntildea: </label>
					</td>
					<td>
					<input type="text" id="passwd" name="passwd" value="<?php echo $passwd; ?>" required/>
					</td></tr>
					<tr><td>
					<label>Nombre:</label>
					</td><td>
					<input type="text" id="nombre" name="nombre" value="<?php echo $nombre; ?>" required/>
					</td></tr>
					<tr><td>
					<label>Apellidos:</label>
					</td><td>
					<input type="text" id="apellidos" name="apellidos" value="<?php echo $apellidos; ?>" required/>
					</td></tr>
					<tr><td>
					<label>Tel&eacutefono: </label>
					</td><td>
					<input type="number" id="tfn" name="tfn" value="<?php echo $tfn; ?>" required/>
					</td></tr>
					<tr><td>
					<label>Direcci&oacuten: </label>
					</td><td>
					<input type="text" id="direccion" name="direccion" value="<?php echo $direccion; ?>" required/>
					</td></tr>
					<tr><td>
					<label>CP:</label>
					</td><td>
					<input type="number" id="cp" name="cp" value="<?php echo $cp; ?>" required/>
					</td></tr>
					<tr><td>
					<label>Poblaci&oacuten: </label>
					</td><td>
					<input type="text" id="poblacion" name="poblacion" value="<?php echo $poblacion; ?>" required/>
					</td></tr>
					<tr><td>
					<label>Pais:</label>
					</td><td>
					<input type="text" id="pais" name="pais" value="<?php echo $pais; ?>" required/>
					</td></tr>
					<tr><td>
					<label>Fecha Registro:</label>
					</td><td>
					<input type="text" id="fecha" name="fecha" value="<?php echo $fecha; ?>" disabled/>
					</td></tr>
					<tr><td colspan="2">
					<center><input type="submit" value="Modificar" /> 
					</form>
					<form action="mod_usuario.php">
						<input type="submit" value="Descartar cambios">
					</form>
					</center>
					</td><tr>
					</table>
			</center>
			</fieldset>
</body>
</html>