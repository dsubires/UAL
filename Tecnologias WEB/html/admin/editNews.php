<!DOCTYPE html>
<?php

	include ('../../db/conexion.php');		// con esta línea puedo hacer uso en esta página php de funciones o variables definidas en otra pagina php (conexion.php)
	
	//obtenemos datos del articulo para mostrarlos por pantalla y poder modificarlos
	$idNoticia = $_POST['idNoticia'];
	$result = mysql_query("select * from noticias where id_noticia='$idNoticia'");
	$array = mysql_fetch_array($result);
	$titulo = $array['titulo'];
	$descripcion = $array['descripcion'];
	$imagen = $array['imagen'];
?>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Gestionar Clientes</title>
	<link href="../../css/adminStyle.css" rel="stylesheet" type="text/css">
  </head>
	<body>
	<span style="float:left">Usted est&aacute aqu&iacute: <a href="main.php">Inicio</a> > <a href="news.php">Gesti&oacuten de noticias</a> > Editar noticia</span><br/>
			<fieldset style="border-color:black;border-style:solid;">
			<legend>Gestionar Clientes</legend>
				<form action="editNews2.php" method="POST" enctype="multipart/form-data">
					<?php
					echo "<input type='hidden' name='idNoticia' value='$idNoticia'/>";
					echo "<img alt='Foto a editar' src='../../images/noticias/$imagen' style='float:left' width='30%' />";				
					?>
					<label>Titulo:</label>
					<input type="text" id="titulo" name="titulo" value="<?php echo $titulo; ?>" required/><br/>
					<textarea id="descripcion" name="descripcion" COLS=40 ROWS=6 required><?php echo $descripcion; ?></textarea><br/>
					<input type="submit" value="Guardar" /> 
				</form>
					<form action="news.php">
						<input type="submit" value="Descartar cambios">
					</form>
</html>