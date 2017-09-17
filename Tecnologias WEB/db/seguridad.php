
<?php
//if(!isset($_SESSION['userAuth']) && !isset($_SESSION['usrType']))
//{
	//if (isset($_SESSION['usrAuth']))
	
	
	
	
	if( (!isset($_SESSION['secError'])) || ($_SESSION['secError'] != 0) )
	{
		echo '
		<!DOCTYPE html>
		<html lang=”es-ES”>
		<head>
			<link href="./css/secureLogin.css" rel="stylesheet" type="text/css">
		</head>
		<body>
			<form id="adminAuth" action="../html/login.php" method="post">
				<input type="hidden" name="redirurl" value="../admin.php" />
				<table align="center" width="250" cellspacing="2" cellpadding="2" border="0">
					<tr>
						<td id="secLoginLabel">
							<b>Identificacion</b>
						</td>
						<tr>
						</tr>
					</tr>
					<tr>
						<td id="secLoginLabel">
							<b>Usuario:</b>
						</td>
						<td>
							<input type="text" name="id" size="12" maxlength="40">
						</td>
					</tr>
					<tr>
						<td id="secLoginLabel">
							<span style="color:5a2172"><b>Contrase&ntilde;a:</b></span>
						</td>
						<td>
							<input id=adminPwd" type="password" name="pwd" size="12" maxlength="8">
						</td>
					</tr>
					<tr>
					</tr>
					
					<tr>
						<td colspan="2" align="center">
							<input type="submit" name="adminSec" id="adminSec" value="Iniciar sesi&oacute;n">
						</td>
					</tr>
					';
		switch ($_SESSION['secError']){
			
			case 1:
		 
				echo 	'
							<div colspan="2" align="center"bgcolor=#cc0000>
								<span style="color:ffffff"><b>Sin Permisos de Administrador</b></span>
							</div>
						';
				break;
			
			case 2:
		 
				echo 	'<div colspan="2" align="center"bgcolor=#cc0000>
								<span style="color:ffffff"><b>Credenciales Incorrectas</b></span>
						</div>';
				break;
				
			case 3:
		 
				echo 	'<div colspan="2" align="center"bgcolor=#cc0000>
								<span style="color:ffffff"><b>Vulneración de Permisos</b></span>
						</div>';
				break;
				
			
		}
		echo '	</form>
				</body>
				</html>';
		
		
	}
?>