<?php
	session_start();
	include ('../db/conexion.php');		// con esta línea puedo hacer uso en esta página php de funciones o variables definidas en otra pagina php (conexion.php)
	
	//idArt1 --> marcar favorito
	//idArt2 --> eliminar favorito
	
	$idArt1 = $_POST['idToFav1'];
	$idArt2 = $_POST['idToFav2'];
	$urlToBack = $_POST['urlToBack'];
	$mail = $_SESSION['emailid'];
	$boton = $_REQUEST["addFav"];
	
	if(is_null($idArt2)){
		$sql = "INSERT INTO articulosfavsclientes(mail, id_articulo)
			VALUES ('$mail', '$idArt1')";
		mysql_query($sql);
	}else if(is_null($idArt1)){
		$sql = "delete from articulosfavsclientes where mail = '$mail' and id_articulo = '$idArt2'";
		mysql_query($sql);
	}
	
	header("location:".$urlToBack);
	
	
	//$sql = "UPDATE usuarios SET password='$passwd', nombre='$nombre', apellidos='$apellidos' , telefono='$tfn', direccion='$direccion', cp='$cp', poblacion='$poblacion' , pais='$pais' WHERE mail='$mail'";
	//mysql_query($sql);
	
?>
</html>