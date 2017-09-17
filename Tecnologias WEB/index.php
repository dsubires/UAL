<!DOCTYPE html>
<html lang=”es-ES”>

	<head> 
		<meta charset="UTF-8" />
        <meta name=”description” content=”Web de articulos de segunda mano”	/>
        <meta name=”keywords” content=”HTML5, CSS3, Javascript”	/>
        <meta name="viewport" content="width=device-width">
        <title>Buy-Buy Webshop</title>
        
		<link href="./css/buybuyStyle.css" rel="stylesheet" type="text/css">
		<link href="./css/login.css" rel="stylesheet" type="text/css">
		<link href="./css/searchbar.css" rel="stylesheet" type="text/css">
		
    	<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
		<script type="text/javascript" src="./js/func_busqueda.js"></script>
		
        <script language="javascript">
			<!--Ajusta el tamaño de un iframe al de su contenido interior para evitar scroll-->
				function autofitIframe(id){
					if (!window.opera && document.all && document.getElementById){
						id.style.height=id.contentWindow.document.body.scrollHeight;
					} else if(document.getElementById) {
						id.style.height=id.contentDocument.body.scrollHeight+50+"px";
					}
				}
		</script>
		<script language="javascript">	
				function redimensionar() {
					autofitIframe("pframe");
					alert('Ejemplo de alerta al redimensionar');
    				}
		</script>
		
			<!--	$(document).ready(function() {
						$('li').click(function () {
							var url = $(this).attr('rel');
							$('#pframe').attr('src', url);
							$('#pframe').reload();
						});
				});-->
		<!--<script language="javascript">
			$(document).ready(function(){
				$("#mostrar").on( "click", function() {
						$('#resultado').show(); //muestro mediante id
						$('.target').show(); //muestro mediante clase
				});
				$("#ocultar").on( "click", function() {
						$('#resultado').hide(); //oculto mediante id
						$('.target').hide(); //muestro mediante clase
				});
			});
		</script>	-->	
		
		<?php
			session_start();
			
		?>
    </head>
	    
    <body onresize="window.frames['pframe'].location.reload();">
		
        <header id="headerPag">
			<img src="./img/HeaderLogoV1.png" alt="Buy-Buy"/>		
			<div id="tituloPag">
			
				<h1>
					Buy-Buy Auctions
				</h1>
				<h2>
					Tu tienda de 2ª mano
				</h2>
			</div>
			
			<div id="barsHeader">
					<?php	
						
						
						/*
						if (version_compare(phpversion(), '5.4.0', '<')) {
							 if(session_id() == '') {
								session_start();
							 }
						 }
						 else
						 {
							if (session_status() == PHP_SESSION_NONE) {
								session_start();
							}
						 }
						*/
						$url="window.history.pushState('data','Titulo','index.php')";
						if(isset($_SESSION['userAuth']))
						{	
							if($_SESSION['usrType'] == 0 || $_SESSION['usrType'] == null)
							{
								echo '<h2><a href="./html/micuenta.php" target="pframe" id="MiCuenta" onClick="'.$url.'">Mi Cuenta</a> | <a href="./html/logout.php" >Logout</a></h2>';
							}
							else{
								echo '<h2><a href="./admin.php" id="MiCuenta">Administracion</a> | <a href="./html/micuenta.php" target="pframe" id="MiCuenta" onClick="'.$url.'">Mi Cuenta</a> | <a href="./html/logout.php" >Logout</a></h2>';
							}
						}
						else
						{
							
							echo '<h2><a href="#" id="loginform">Login</a> | <a href="./html/registro.php" target="pframe" onClick="'.$url.'">Register</a></h2>';
							echo '<div class="login">
							  <div class="arrow-up"></div>
								  <div class="formholder">
									<div class="randompad">
										<form action="./html/login.php" method="post">
											<input type="hidden" name="redirurl" value="../index.php" />
										   <fieldset>
												 <label name="email">Email</label>
												 <input name="id" type="email" value="example@example.com" />
												 <label name="password">Password</label>
												 <input name="pwd" type="password" />
												 <input name="login" type="submit" value="Login" />
							 
											</fieldset>
										</form>
									</div>
								</div>
							</div>';
						}
					?>	
			</div>
			<script src="js/login.js"></script>
        </header>
        
        <nav id="nav">
        	<ul>
            	<li><a href="./html/principal.php" target="pframe" onClick="window.history.pushState('data','Titulo','index.php');">Inicio</a></li>
                <li><a href="./html/catalogo.php" target="pframe" onClick="window.history.pushState('data','Titulo','index.php');">Catálogo</a></li>
                <li><a href="./html/noticias.php" target="pframe" onClick="window.history.pushState('data','Titulo','index.php');">Noticias</a></li>
                <li><a href="./html/vender.php" target="pframe" onClick="window.history.pushState('data','Titulo','index.php');">Quiero Vender</a></li>
				<li><a href="./html/nosotros.php" target="pframe" onClick="window.history.pushState('data','Titulo','index.php');">Nosotros</a></li>
				<li><a href="./html/contacto.php" target="pframe" onClick="window.history.pushState('data','Titulo','index.php');">Contacto</a></li>
			</ul>
			
			<form id="searchBar" name="frmbusqueda" action="buscarDato(); return false" onsubmit="buscarDato(); return false">
					<input id="sBarText" name="dato" type="text" placeholder="Buscar articulo" required>
					<input id="sBarButton" type="button"  onClick="buscarDato(); return false" value="Search">
			</form>
			
			
        </nav>
        
        
		<section id="mainContent" onresize="autofitIframe(pframe);">	
			
			<script language="JavaScript">
				
			</script>
			
			<fieldset>
				<center><div id="resultado"></div></center>
			</fieldset>
			
			<?php
			if((isset($_SESSION['errorLog'])) && ($_SESSION['errorLog'])==true )
			{
				//if(isset($_SESSION['secError']) && $_SESSION['usrAuth']){ se muestra si distinto de 0, 1 y null
					echo '<iframe src="./html/form_recuperacion.php" id="pframe" name="pframe" frameborder="0" allowfullscreen onload="autofitIframe(this);" onresize="autofitIframe(pframe);" scrolling=no ></iframe>';
					$_SESSION['errorLog']=false;
				//}
			}else{
				if(isset($_GET['item'])){
					$verProdPframe = '<iframe src="./html/ver_producto.php?id='.$_GET['item'].'" id="pframe" name="pframe" frameborder="0" allowfullscreen onload="autofitIframe(this);" onresize="autofitIframe(pframe);" scrolling=no ></iframe>';
					echo $verProdPframe;
				}elseif(isset($_GET['noticia'])){
					$verProdPframe = '<iframe src="./html/ver_noticia.php?id='.$_GET['noticia'].'" id="pframe" name="pframe" frameborder="0" allowfullscreen onload="autofitIframe(this);" onresize="autofitIframe(pframe);" scrolling=no ></iframe>';
					echo $verProdPframe;
				}else{
					echo '<iframe src="./html/principal.php" id="pframe" name="pframe" frameborder="0" allowfullscreen onload="autofitIframe(this);" onresize="autofitIframe(pframe);" scrolling=no ></iframe>';
				}
			}
			?>
			
			<aside id="col_der">
			<h2>Noticias</h2>
			<?php	
				include ('db/conexion.php');		// con esta línea puedo hacer uso en esta página php de funciones o variables definidas en otra pagina php (conexion.php)
				// sending query
				$result = mysql_query("SELECT * FROM noticias order by fecha DESC, titulo");
				if (!$result) {
					die("Error en la consulta");
				}
				
				
				
				// para cada fila, obtenemos los datos y los imprimimos con el formato oportuno
				// solo mostramos las tres noticias más recientes
				$count = 0;
				while($row = mysql_fetch_row($result) and $count < 3)
				{
					$titulo = $row[1];
					$descripcion = $row[2];
					$fecha = $row[4];
					
					$temp= "onClick=";
					$temp.="top.window.history.pushState('data','Titulo','index.php?noticia=".$row[0]."');";

	
					echo "<article id='articulo'>";
					echo "<h3><a href='./html/ver_noticia.php?id=$row[0]' $temp target='pframe'>$titulo - $fecha</a></h3>";
					echo "<p>$descripcion</p>";
					echo "</article>";					
					$count = $count + 1;

				}
				mysql_free_result($result);	
			?>
			</aside>
			

<!--		<aside id="col_der">
				<h2>
					Noticias
				</h2>
                <article id="articulo">
					<h3>
						Titular de la noticia
					</h3>
					<p>
                        Un dia vi una vaca vestida de uniforme. 
                        Un dia vi una vaca vestida de uniforme. 
                        Un dia vi una vaca vestida de uniforme. 
                        Un dia vi una vaca vestida de uniforme.
                        Un dia vi una vaca vestida de uniforme. 
                        Un dia vi una vaca vestida de uniforme. 
                        Un dia vi una vaca vestida de uniforme. 
                        Un dia vi una vaca vestida de uniforme. 
                        Un dia vi una vaca vestida de uniforme.
                        Un dia vi una vaca vestida de uniforme.
                        Un dia vi una vaca vestida de uniforme. 
                        Un dia vi una vaca vestida de uniforme. 	
					</p>
				</article>
				<article id="articulo">
           			<h3>
						Titular de la noticia
					</h3>
					<p>
                        Esto es una prueba. Esto es una prueba.
                        Esto es una prueba. Esto es una prueba.
                        Esto es una prueba. Esto es una prueba.
                        Esto es una prueba. Esto es una prueba.
                        Esto es una prueba. Esto es una prueba.
                        Esto es una prueba. Esto es una prueba.
                        Esto es una prueba. Esto es una prueba.
                    </p>	
				</article>
            </aside>
			-->
        </section>
        
        
        <footer id="pie">    
        	Derechos Reservados &copy; 2015
        </footer> 
        <script src="./js/jquery.dropotron.min.js"></script>
		<script src="./js/skel.min.js"></script>
		<script src="./js/util.js"></script>
		<script src="./js/main.js"></script>
    </body>
    
</html>
