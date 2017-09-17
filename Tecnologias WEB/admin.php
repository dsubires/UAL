<?php
session_start();
include("./db/seguridad.php");

if( (isset($_SESSION['secError'])) && ($_SESSION['secError'] == 0) )
{
	echo '
		<!DOCTYPE html>
		<html lang=”es-ES”>


			<head> 
			 <meta charset="UTF-8">
		<!--			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />-->
				<meta charset="UTF-8" />
				<meta name=”description” content=”Web de articulos de segunda mano”	/>
				<meta name=”keywords” content=”HTML5, CSS3, Javascript”	/>
				<meta name="viewport" content="width=device-width">
				<title>Buy-Buy Webshop</title>
				
				<link href="./css/adminPage.css" rel="stylesheet" type="text/css">
				<link href="./css/login.css" rel="stylesheet" type="text/css">
				<link href="./css/searchbar.css" rel="stylesheet" type="text/css">
				
				<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
				
				<script language="javascript">
					<!--Ajusta el tamaño de un iframe al de su contenido interior para evitar scroll-->
						function autofitIframe(id){
							if (!window.opera && document.all && document.getElementById){
								id.style.height=id.contentWindow.document.body.scrollHeight;
							} else if(document.getElementById) {
								id.style.height=id.contentDocument.body.scrollHeight+50+"px";
							}
						}
					
						function redimensionar() {
							autofitIframe("pframe");
							alert("Ejemplo de alerta al redimensionar");
							}
				</script>
			
			</head>
				
			<body>
				
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
								<h2><a href="./html/admin/main.php" target="pframe" id="MiCuenta">Administracion</a> | <a href="./html/logout.php" >Logout</a></h2>
								<div class="login">
								  <div class="arrow-up"></div>
									  <div class="formholder">
										<div class="randompad">
										   <fieldset>
											 <label name="email">Email</label>
											 <input type="email" value="example@example.com" />
											 <label name="password">Password</label>
											 <input type="password" />
											 <input type="submit" value="Login" />
							 
											</fieldset>
										</div>
									</div>
								</div>
						</div>
						<script src="js/login.js"></script>
					</header>
					
					<nav id="nav">
						<ul>
							<li><a href="./html/admin/main.php" target="pframe">Menu</a></li> 
							<li><a href="./index.php">Tienda</a></li> 
						</ul>
						
						<form id="searchBar">
								<input id="sBarText" type="text" placeholder="Buscar en la página" required>
								<input id="sBarButton" type="button" value="Search">
						</form>
						
						
					</nav>
					
					
					<section id="mainContent" onresize="autofitIframe(pframe);">	
						
						<script language="JavaScript">
							
						</script>
						
						<iframe src="./html/admin/main.php" id="pframe" name="pframe" frameborder="0" allowfullscreen onload="autofitIframe(this);" scrolling=no ></iframe>
							
							
						
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
		';
}
?>