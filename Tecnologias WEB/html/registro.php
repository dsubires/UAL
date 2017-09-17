<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
    <title>Registro Usuarios</title>
	 <script src="../js/validar.js"></script> 
  </head>
  <body>
    <center>
		<fieldset style="border-color:black;border-style:solid;">
		<legend>Formulario de registro</legend>
				<form action="register.php" name="register" id="register" method="post" onsubmit="return validar()"></br>
				<table>
				<tr>
					<td>
						<label>Nombre</label>
					</td>
					<td>
						<input name="usrName" id="nombre" size="30" type="text">
					</td>
				</tr>	
				<tr>	
					<td>
						<label>Apellidos</label>
					</td>
					<td>
						<input name="surname" id="apellidos" size="30" type="text">
					</td>
				</tr>
				<tr>
					<td>
						<label>Tel&eacutefono</label>
					</td>
					<td>
						<input name="phone" id="tfn" size="30" type="text">
					</td>
				</tr>
				<tr>
					<td>
						<label>E-Mail</label>
					</td>
					<td>
						<input name="email" id="mail" size="30" type="text">
					</td>
				</tr>
				<tr>
					<td>
						<label>Contrase&ntildea</label>
					</td>
					<td>
						<input name="passwd" id="pass" size="30" type="password">
					</td>
				</tr>
				<tr>
					<td>
						<label>Repetir Contrase&ntildea</label>
					</td>
					<td>
						<input name="checkPass" id="rpass" size="30" type="password">
					</td>
				</tr>
				<tr>
					<td>
						<label>Direcci&oacuten </label>
					</td>
					<td>
						<input name="address" id="direccion" size="30" type="text">
					</td>
				</tr>
				<tr>
					<td>
						<label>Poblaci&oacuten </label>
					</td>
					<td>
						<input name="poblacion" id="poblacion" size="30" type="text">
					</td>
				</tr>
				<tr>
					<td>
						<label>C&oacutedigo Postal</label>
					</td>
					<td>
						<input name="cpCode" id="cp" size="30" type="text">
					</td>
				</tr>
				<tr>
					<td>
						<label>Pa&iacutes </label>
					</td>
					<td>
						<input name="country" id="pais" size="30" type="text"></br>
					</td>
				</tr>		
				<tr>
					<td>
						<center><input name="register" value="Enviar" type="submit"></center>
					</td>
					<td>
						 <center><input value="Borrar" type="reset"></center>
					</td>
				</tr>
				</form>																
				</table>				
				<div id="msgError"></div>
	</center>
  </body>
</html>