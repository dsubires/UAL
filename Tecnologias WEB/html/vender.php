<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
    <title>Registro Usuarios</title>
  </head>
  <body>
<?php
	session_start();
	if(!isset($_SESSION['userAuth']))
	{
		echo 'No se puede vender un artículo sin hacer login. Inicie sesión. <br/> Si no tiene cuenta registrese <a href="registro.php">aquí</a>';
	}
	else
	{
		echo '<center>
	<fieldset style="border-color:black;border-style:solid;">
		<legend>Quiero vender</legend>
				<form action="mail_vender.php" id="vender" method="post" name="vender"  enctype="multipart/form-data"></br>
				<table>
					<tr>
						<td rowspan="3" align="center">
							<img src="../images/upload-img.png" alt="articulo" width="20%" /><br/><br/>
							<input type="file" name="file" id="pic" required>
						</td>
						<td>
							<input type="text" name="articulo" id="titulo" placeholder="Título del artículo" size="60%" required/>
						</td>
					</tr>
					<tr>
						<td>
							<textarea id="descripcion" name="descripcion" rows="8" cols="45" style="resize:none;" placeholder="Descripción del artículo, tipo, detalles....." required></textarea>
						</td>
					</tr>
					<tr>
						<td>  
							<input type="number" name="precio" id="precio" placeholder="Precio..(€)" required/>
						</td>
					</tr>
					<tr>
						<td colspan ="2" align="center">
						<br/>	<input type="submit" value="Enviar solicitud"/>
						</td>
					</tr>					
				</form>																
				</table>				
				<div id="msgError"></div>
	
	</fieldset>
	</center>';
	}
?>
    
  </body>
</html>