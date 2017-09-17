<?php

	// este archivo se encarga de crear un acceso con la base de datos
	// cada vez que queramos hacer una consulta a la base de datos basta con incluir este archivo que  ya se encarga de crear la conexión (include('conexion.php'))
	
	include ('credenciales.php');		//en este archivo se hace uso de unas variables que no estan definidas aqui,
								// si no que estan definidas en 'credenciales.php', por eso se incluyen y pueden ser utilizadas en esta página php 
								//(de la misma forma que si estuvieran definidas aqui)
	$conexion = mysql_connect($host, $user, $pass);		// abrimos una conexion con la base de datos, necesitamos saber el host, el usuario que se conecta y su contraseña
								// esos valores estan en 'credenciales.php' y se conoce su valor gracias al include('credenciales.php')
	mysql_select_db($db, $conexion);	// elegimos la base de datos con la que queramos interactuar, usamos la conexion que abrimos en la linea de codigo anterior.
	
	// Check connection
if ($conexion->connect_error) {
    die("Connection failed: " . $conexion->connect_error);
}
?>