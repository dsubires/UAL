<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
    <title>Login</title>
	 
  </head>
  <body>
		<?php
			session_start();
			$_SESSION['usrAuth'] = 0;
			$_SESSION['secError'] = 101;
			$_SESSION['errorLog'] = false;
			include_once "../db/conexion.php";

			function verificar_login($email,$password,&$result) 
			{
				$sql = "SELECT * FROM usuarios WHERE mail = '".$email."' and password = '".$password."'";
				
				$rec = mysql_query($sql);
				$count = 0;

				while($row = mysql_fetch_object($rec))
				{
					$count++;
					$result = $row;
				}

				if($count == 1)
				{
					return 1;
				}

				else
				{
					return 0;
				}
			}
			
			if(isset($_POST['login']) || isset($_POST['adminSec']))
			{
				if(verificar_login($_POST['id'],$_POST['pwd'],$result) == 1)
				{
					$_SESSION['emailid'] = $result->mail;
					$_SESSION['userName'] = $result->nombre;
					$_SESSION['userAuth'] = true;
					$_SESSION['errorLog'] = false;
					$_SESSION['usrType'] = $result->admin;
					if($_SESSION['usrType'] == 1)
					{
						$_SESSION['secError'] = 0;					//Error 0: Login Correcto Administrador
					}
					else
					{
						$_SESSION['secError'] = 1;					//Error 1: Login Correcto Usuario (Sin Permisos)
					}
					
					//if($_POST['redirurl'] == "../admin.php"){
						header("location:".$_POST['redirurl']);
					//}
					
				}
				else
				{
					$_SESSION['errorLog'] = true;
					if($_POST['redirurl'] == "../admin.php"){
						if(!isset($_SESSION['userAuth']) || ($_SESSION['userAuth'] == 0))
						{
							$_SESSION['secError'] = 2; 			//Usuario y/o Contraseña Invalido
						}
						elseif($_SESSION['usrType'] == 1)
						{
							$_SESSION['secError'] = 3;			//Vulneración de Permisos
						}
						
						header("location:../admin.php");
					}else{
						header("location:../index.php");

					}
					
				}
			}
							
		?>
		
  </body>
</html>