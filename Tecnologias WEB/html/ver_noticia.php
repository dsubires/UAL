<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
    <title>Ver noticia</title>
	 <style>
	 .imgA{
		position:relative;
		float:left;
		width:30%;
		margin-top:2%;
		margin-left:2%;
		margin-right:2%;
		padding:5px;
	}
	fieldset span{
		position:relative;
		float:left;
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
	
	.articuloC{
		border-color:black;
		border-style:solid;
	}

	
	.fav{
		width:2%;
		float:right;
		position:absolute;
		bottom:5px;
		right:10px;
	}
	.share{
		width:2%;
		float:right;
	    position:absolute;
		bottom:5px;
		right:15px;
	}
	
	
	.noticia{
		border-color:black;
		border-style:solid;
	}
	#twitterS{
		position:absolute;
		bottom:1px;
		right:130px;
	}
	
	#faceS{
		position:absolute;
		bottom:5px;
		right:45px;
	}
	
	 </style>
	 <link rel="stylesheet" href="../css/lightbox.min.css">
  </head>
  <body>
  
  <script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=p+'://platform.twitter.com/widgets.js';fjs.parentNode.insertBefore(js,fjs);}}(document, 'script', 'twitter-wjs');</script>
  <script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/es_ES/sdk.js#xfbml=1&version=v2.5";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>
  
  			<?php
				include ('../db/conexion.php');		// con esta línea puedo hacer uso en esta página php de funciones o variables definidas en otra pagina php (conexion.php)
				
				$id = $_GET["id"];				
				settype($id, "int"); 
				
				if($id == 0){
					echo "Noticia no encontrada";
				}else{
					
						// enviamos consulta
						$result = mysql_query("SELECT * FROM noticias where id_noticia=$id");
						if (mysql_num_rows($result)==0){
							echo "Noticia no encontrada";
						//la consulta ha devuelto datos, los formateamos y los mostramos
						}else{
							$row = mysql_fetch_row($result);
							$titulo = $row[1];
							$descripcion = $row[2];
							$imagen = $row[3];
							$fecha = $row[4];
							echo "<h2>T&iacutetulo: $titulo</h2>";
							echo "<h2>Fecha: $fecha</h2>";
							echo "<a href='../images/noticias/$imagen' data-lightbox='image-1' data-title='$titulo'><img src='../images/noticias/$imagen' alt='$nombre' class='imgA'/></a>";
							echo "<div class='descripcionNoticia'>$descripcion</div>";
//							echo "<a href=''><img src='../images/iconos/share.png' alt='compartir' class='share' /></a>";
							mysql_free_result($result);
							
							//redes sociales
							$actual_link =  "http://subires.no-ip.org/index.php?noticia=$row[0]";
							echo '
									<div id="twitterS"><a href="https://twitter.com/share" class="twitter-share-button"{count} data-url="'.$actual_link.'" data-text="Echa un vistazo a esta noticia!">Tweet</a></div>
									<div class="fb-share-button" id="faceS" data-href="'.$actual_link.'" data-layout="button"></div>
							';	

// 						descomentar si se implementa contador de visitas en las noticias							
//						mysql_query("update noticias set contador_visitas = contador_visitas + 1 where id_noticia = $id");
						
					
						}
				}
			$temp= "onClick=";
			$temp.="top.window.history.pushState('data','Titulo','index.php');";
			echo "<br/><br/><div id='volver'><a href='./noticias.php' ".$temp.">Volver</a></div>";
			?>		

	<script src="../js/lightbox-plus-jquery.min.js"></script>	  		
  </body>
</html>	