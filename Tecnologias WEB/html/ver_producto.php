<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
    <title>Ver producto</title>
	 <link rel="stylesheet" href="../css/lightbox.min.css">
	 <link rel="stylesheet" href="../css/elmView.css">
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
				session_start();
				include ('../db/conexion.php');		// con esta línea puedo hacer uso en esta página php de funciones o variables definidas en otra pagina php (conexion.php)
				
				$id = $_GET["id"];				
				settype($id, "int"); 
				
				if($id == 0){
					echo "Producto no encontrado";
				}else{
					
						// enviamos consulta
						$result = mysql_query("SELECT * FROM articulos where id_articulo=$id");
						if (mysql_num_rows($result)==0){
							echo "Producto no encontrado";
						//la consulta ha devuelto datos, los formateamos y los mostramos
						}else{
							$row = mysql_fetch_row($result);
							$nombre = $row[1];
							$descripcion = $row[2];
							$precio = $row[3];
							$imagen = $row[4];
							$categoria = $row[7];		
							echo "<h2>Producto: $nombre</h2>";
							echo "<h2>Precio: $precio €</h2>";
							echo "<h2>Categor&iacutea: $categoria</h3>";
							echo "<a href='../images/articulos/$imagen' data-lightbox='image-1' data-title='$nombre'><img src='../images/articulos/$imagen' alt='$nombre' class='imgA'/></a>";
							echo "<div class='descripcionArticulo'>$descripcion</div>";
							
							
							

							$urlToBack = "ver_producto.php?id=$row[0]";
							
							if(!isset($_SESSION['userAuth']))
							{
									// usuario no logeado, no puede marcar favorito
									echo "<img src='../images/iconos/nofav.png' alt='favorito' class='fav' />";
							}else{
									//usuario logeado
								$mail = $_SESSION['emailid'];
								$idArt = $row[0];
									//usuario logeado, no tiene marcado este producto como favorito								
								$sql = "select * from articulosfavsclientes where mail = '$mail' and id_articulo = '$idArt'";
								$existeFav = mysql_query($sql);
								
								if (mysql_num_rows($existeFav)==0){
								echo '<form action="editFav.php" method="post">
										<input type="hidden" name="idToFav1" value="'.$idArt.'">
										<input type="hidden" name="urlToBack" value="'.$urlToBack.'">
										<input type="image"  src="../images/iconos/nofav.png" class="fav" alt="Submit">
									  </form>
									';
									
									
								}else{
									//usuario logeado, tiene marcado este producto como favorito
								echo '<form action="editFav.php" method="post">
										<input type="hidden" name="idToFav2" value="'.$idArt.'">
										<input type="hidden" name="urlToBack" value="'.$urlToBack.'">
										<input type="image"  src="../images/iconos/fav.png" class="fav" alt="Submit">
									  </form>
									';
								}
							}
							
						//	echo "<a href=''><img src='../images/iconos/share.png' alt='compartir' class='share' /></a>";
							
							
							//redes sociales
							$actual_link =  "http://subires.no-ip.org/index.php?item=$row[0]";
							echo '
									<div id="twitterS"><a href="https://twitter.com/share" class="twitter-share-button"{count} data-url="'.$actual_link.'" data-text="Echa un vistazo a este producto!">Tweet</a></div>
									<div class="fb-share-button" id="faceS" data-href="'.$actual_link.'" data-layout="button"></div>
							';
							
//							echo $actual_link;
							mysql_free_result($result);
						
						    mysql_query("update articulos set contador_visitas = contador_visitas + 1 where id_articulo = $id");
						
					
						}
				}
			$temp= "onClick=";
			$temp.="top.window.history.pushState('data','Titulo','index.php');";
			echo "<br/><br/><div id='volver'><a href='./catalogo.php' ".$temp.">Volver al Catalogo</a></div>";
			?>		

	<script src="../js/lightbox-plus-jquery.min.js"></script>	  		
  </body>
</html>	