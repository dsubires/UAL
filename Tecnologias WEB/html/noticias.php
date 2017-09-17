<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
    <title>Ver catalogo</title>
	<link rel="stylesheet" href="../css/elmView.css">

	<!-- <style>
	 .imgA{
		position:relative;
		float:left;
		width:15%;
		margin-top:2%;
		margin-left:2%;
		padding:5px;
	}
	fieldset span{
		position:relative;
		
		margin-left:2%;
		padding:5px;
	}
	
	fieldset span h3{
		position:relative;
		float:left;

		
		padding:5px;
		
	}
	
	fieldset h3 a{
		text-decoration:none;
		color:black;
	}
	
	.noticia{
		border-color:black;
		border-style:solid;
	}
	.fav{
		width:2%;
		float:right;
	}
	.share{
		width:2%;
		float:right;
	}
	 </style> -->
  </head>
  <body>
  <h2>Noticias:</h2>
    <center>
		
		<form action="noticias.php" method="post">
			<?php
				include ('../db/conexion.php');		// con esta línea puedo hacer uso en esta página php de funciones o variables definidas en otra pagina php (conexion.php)
				
				$boton = $_REQUEST["resetFilter"];
				$orden = $_POST["ord"];
				
				
				//no se ha seleccionado filtro alguno, por tanto imprimimos el select por defecto	
				if(is_null($orden) or $orden == "--Orden--" or $boton == "Eliminar filtro" )
				{					

					echo "<select name='ord'>";
					echo "<option selected>--Orden--</option>";
					echo "<option>Alfabetico</option>";
					echo "<option>Alfabetico Inverso</option>";
					echo "<option>Fecha Registro (Mas reciente)</option>";
					echo "<option>Fecha Registro (Menos reciente)</option>";
					echo "</select> ";				
					echo "<input type='submit' value='Mostrar'/>";
					
					
				//Se han seleccionado un filtro orden, por tanto imprimimos el select con la opcion seleccionada marcada como selected
				}else if($orden != "--Orden--"){
					
					switch ($orden) {
						case "Alfabetico":
							echo "<select name='ord'>";
							echo "<option>--Orden--</option>";
							echo "<option selected>Alfabetico</option>";
							echo "<option>Alfabetico Inverso</option>";
							echo "<option>Fecha Registro (Mas reciente)</option>";
							echo "<option>Fecha Registro (Menos reciente)</option>";
							echo "</select> ";				
							echo "<input type='submit' value='Mostrar'/>";
							break;
						case "Alfabetico Inverso":
							echo "<select name='ord'>";
							echo "<option>--Orden--</option>";
							echo "<option>Alfabetico</option>";
							echo "<option selected>Alfabetico Inverso</option>";
							echo "<option>Fecha Registro (Mas reciente)</option>";
							echo "<option>Fecha Registro (Menos reciente)</option>";
							echo "</select> ";				
							echo "<input type='submit' value='Mostrar'/>";
							break;
						case "Fecha Registro (Mas reciente)":
							echo "<select name='ord'>";
							echo "<option>--Orden--</option>";
							echo "<option>Alfabetico</option>";
							echo "<option>Alfabetico Inverso</option>";
							echo "<option selected>Fecha Registro (Mas reciente)</option>";
							echo "<option>Fecha Registro (Menos reciente)</option>";
							echo "</select> ";				
							echo "<input type='submit' value='Mostrar'/>";
							break;
						case "Fecha Registro (Menos reciente)":
							echo "<select name='ord'>";
							echo "<option>--Orden--</option>";
							echo "<option selected>Alfabetico</option>";
							echo "<option>Alfabetico Inverso</option>";
							echo "<option>Fecha Registro (Mas reciente)</option>";
							echo "<option selected>Fecha Registro (Menos reciente)</option>";
							echo "</select> ";				
							echo "<input type='submit' value='Mostrar'/>";
							break;
					}
					echo "<br/>";
					echo "<form action='noticias.php'>";
					echo "<input type='submit' name='resetFilter' value='Eliminar filtro'/>";
					echo "</form>";
				}

			?>			
		
		</form>
		
		
					<?php

					
				//no se ha seleccionado filtro alguno, por tanto ejecutamos la consulta por defecto
				if(is_null($orden) or $orden == "--Orden--" or $boton == "Eliminar filtro" )
				{					
					// sending query
					$result = mysql_query("SELECT * FROM noticias");
					if (!$result) {
						die("Error en la consulta");
					}
					
					
				//Se han seleccionado un filtro orden, por tanto ejecutamos la consulta oportuna
				}else if($orden != "--Orden--"){
					
					switch ($orden) {
						case "Alfabetico":
							// sending query
							$result = mysql_query("SELECT * FROM noticias order by titulo ASC");
							if (!$result) {
								die("Error en la consulta");
							}
							break;
						case "Alfabetico Inverso":
							// sending query
							$result = mysql_query("SELECT * FROM noticias order by titulo DESC");
							if (!$result) {
								die("Error en la consulta");
							}
							break;
						case "Fecha Registro (Mas reciente)":
							// sending query
							$result = mysql_query("SELECT * FROM noticias order by fecha DESC, titulo");
							if (!$result) {
								die("Error en la consulta");
							}
							break;
						case "Fecha Registro (Menos reciente)":
							// sending query
							$result = mysql_query("SELECT * FROM noticias order by fecha ASC, titulo");
							if (!$result) {
								die("Error en la consulta");
							}
							break;
					}

				}
					
					// para cada fila, obtenemos los datos y los imprimimos con el formato oportuno
					while($row = mysql_fetch_row($result))
					{
						$titulo = $row[1];
						$descripcion = $row[2];
						$imagen = $row[3];
						$fecha = $row[4];
						
						$temp= "onClick=";
						$temp.="top.window.history.pushState('data','Titulo','index.php?noticia=".$row[0]."');";

	
						
						echo "<fieldset class='noticia'>";
						echo "<legend>$titulo  $fecha</legend>";
						echo "<div id='imgNotDiv'><img src='../images/noticias/$imagen' alt='$titulo' class='imgNot'/></div><span>";
						echo "<span><h2><a href='ver_noticia.php?id=$row[0]' $temp>$titulo</a></h2></br><h3>$descripcion</h3></span>";
//						echo "<a href=''><img src='../images/iconos/share.png' alt='compartir' class='share' /></a>";
						echo "</fieldset>";
					}
					mysql_free_result($result);
	?>					
	</center>
  </body>
</html>	