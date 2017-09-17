<!DOCTYPE html>
<html lang=”es-ES”>

	<head> 
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    </head>
    <body>
	<span style="float:left">Usted est&aacute aqu&iacute: <a href="main.php">Inicio</a> > <a href="news.php">Gesti&oacuten de noticias</a> > <a href="addnews.php">A&ntildeadir noticia</a></span><br/>
	<center>

<?php

	include ('../../db/conexion.php');		// con esta línea puedo hacer uso en esta página php de funciones o variables definidas en otra pagina php (conexion.php)
	
	if(isset($_FILES['image'])){
		$errors= array();
		$file_name = $_FILES['image']['name'];
		$file_size =$_FILES['image']['size'];
		$file_tmp =$_FILES['image']['tmp_name'];
		$file_type=$_FILES['image']['type'];   
		$file_ext=strtolower(end(explode('.',$_FILES['image']['name'])));
		
		$expensions= array("jpeg","jpg","png"); 		
		if(in_array($file_ext,$expensions)=== false){
			$errors[]="Extension no valida, solo se permite jpeg, jpg o png.";
		}
		if($file_size > 2097152){
		$errors[]='La imagen no puede ser mayor de 2 MB';
		}				
		if(empty($errors)==true){
			move_uploaded_file($file_tmp,"/var/www/buybuyauctions/src/images/noticias/".$file_name);

			$titulo = $_POST["titulo"];
			$descripcion = $_POST["descripcion"];
			$fecha = $_POST["fecha"];

			$sql = "INSERT INTO noticias(titulo, descripcion, imagen, fecha)
			VALUES ('$titulo', '$descripcion', '$file_name', '$fecha')";

			mysql_query($sql);
		?>
			Noticia a&ntildeadida correctamente<br/>
			<form action='news.php'>
			<input type='submit' value='Volver'/>
			</form>
		<?php
		}else{
			
			?>
			La noticia no se ha podido a&ntildeadir<br/>
			
			<?php
			print_r($errors);
			echo "<br/>";
			echo "<form action='news.php'>";
			echo "<input type='submit' value='Volver'/>";
			echo "</form>";
		}
	}
	

	
?>


	
	</center>
</body>
</html>