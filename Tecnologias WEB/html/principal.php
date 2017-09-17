<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="iso-8859-1" />
	<meta name="" content="" />
	<meta name="keywords" content="" />
	<meta name="viewport" content="width=device-width">
	
	<link rel="stylesheet" href="../css/slippry.css">
	
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script src="../js/slippry.min.js"></script>
            
</head>

<body>
	
	
	<!-- Slideshow  -->
        <ul id="slider">
			<li>
				<a href="#slide1">
					<img src="../images/a.jpg" alt="¡¡¡Bienvenidos a la web de BuyBuyAuctions!!!<br>Ven a visitarnos. ¡Mira donde estamos <a href='./nosotros.php'>aqui</a>!">
				</a>
			</li>
			<li>
				<a href="#slide2">
					<img src="../images/b.jpg"  alt="¡¡¡Compramos y vendemos articulos de todo tipo!!!">
				</a>
			</li>
			<li>
				<a href="#slide3">
					<img src="../images/c.jpg" alt="¡¡¡No dudes venir a vernos!!!">
				</a>
			</li>
			<li>
				<a href="#slide3">
					<img src="../images/d.jpg" alt="¡¡¡Precios increibles!!!">
				</a>
			</li>
		</ul>
		<script>
			$(function() {
				var slider = $("#slider").slippry({
					// transition: 'fade',
					// useCSS: true,
					// speed: 1000,
					// pause: 3000,
					// auto: true,
					// preload: 'visible',
					// autoHover: false
				});
			});
		</script>
		
		
</body>
</html>