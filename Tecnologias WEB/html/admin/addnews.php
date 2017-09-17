<!DOCTYPE html>
<html>
  <head>
     <meta charset="UTF-8">
    <title>Gestionar Noticias</title>
	<link href="../../css/adminStyle.css" rel="stylesheet" type="text/css">
  </head>
	<body>
	<span style="float:left">Usted est&aacute aqu&iacute: <a href="main.php">Inicio</a> > <a href="news.php">Gesti&oacuten de noticias</a> > <a href="addnews.php">A&ntildeadir noticia</a></span><br/>
			<fieldset style="border-color:black;border-style:solid;">
			<legend>Gestionar Noticias</legend>
				<form action="addnews2.php" method="POST" enctype="multipart/form-data">
					<label>T&iacutetulo:</label>
					<input type="text" id="titulo" name="titulo" placeholder="titulo..." required/><br/>
					<label>Descripci&oacuten:</label>
					<textarea id="descripcion" name="descripcion" COLS=40 ROWS=6 placeholder="descripcion...." required></textarea><br/>
					<label>Foto</label>
					<input type="file" name="image" id="image" required/><br/>
					<?php
						$fecha_actual = new DateTime();
//						$cadena_fecha_actual = $fecha_actual->format("d/m/Y");
						$cadena_fecha_actual = $fecha_actual->format("Y/m/d");
						echo "<input type='hidden' id='fecha' name='fecha' value='$cadena_fecha_actual'><br/>";
					?>
					
					<input type="submit" value="Añadir" /> 
				</form>
					<form action="news.php">
						<input type="submit" value="Atras">
					</form>
</html>