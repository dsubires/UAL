<!DOCTYPE html>
<html lang=”es-ES”>

	<head> 
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    </head>
    <body>
	<span style="float:left">Usted est&aacute aqu&iacute: <a href="main.php">Inicio</a> > <a href="products.php">Gesti&oacuten de productos</a> > <a href="addproducts.php"> A&ntildeadir producto</a></span><br/>
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
			move_uploaded_file($file_tmp,"/var/www/buybuyauctions/src/images/articulos/".$file_name);
			$nombre = $_POST["nombre"];
			$descripcion = $_POST["descripcion"];
			$precio = $_POST["precio"];
			$categoria = $_POST["categoria"];

			$sql = "INSERT INTO articulos(nombre, descripcion, precio, imagen, categoria)
			VALUES ('$nombre', '$descripcion', $precio, '$file_name', '$categoria')";

			mysql_query($sql);
		?>
			Art&iacuteculo a&ntildeadido correctamente<br/>
			<form action='products.php'>
			<input type='submit' value='Volver'/>
			</form>
		<?php
		}else{
			
			?>
			El art&iacuteculo no se ha podido a&ntildeadir<br/>
			
			<?php
			print_r($errors);
			echo "<br/>";
			echo "<form action='products.php'>";
			echo "<input type='submit' value='Volver'/>";
			echo "</form>";
		}
	}
	

	
?>


	
	</center>
</body>
</html>