<!DOCTYPE html>
<html lang=”es-ES”>

	<head> 
		<meta charset="UTF-8" />
        <meta name=”description” content=”Web de articulos de segunda mano”	/>
        <meta name=”keywords” content=”HTML5, CSS3, Javascript”	/>
        <meta name="viewport" content="width=device-width">
        
		<?php
			session_start();
			$_SESSION["secError"] = 101;
		?>
    </head>
	    
    <body>

				<div class="error">Su usuario y/o contraseña son invalidos, intentelo de nuevo.</div>
				<div>
				Para solicitar de nuevo un código de acceso, introduzca el email de su cuenta:
					<form action="./recuperarAcceso.php" method="post">
						<input type="hidden" name="redirurl" value="../index.php" />
							<fieldset>
								<label name="email">Email</label>
								<input name="id" type="email" value="example@example.com" />
								<input name="recpwd" type="submit" value="Solicitar codigo acceso" />			 
							</fieldset>
					</form>
					<form action="./principal.php" method="post">
						<input name="volver" type="submit" value="Volver" />
					</form>
				</div>

	</body>
</html>	