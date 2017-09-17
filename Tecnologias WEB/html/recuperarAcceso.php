<?php
	session_start();
	include_once "../db/conexion.php";

	//Funciones
	function verificarMail($email,&$result) 
	{
		$sql = "SELECT * FROM usuarios WHERE mail = '".$email."'";
					
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
				
	function get_random_string($valid_chars, $length)
	{
		// start with an empty random string
		$random_string = "";

		// count the number of chars in the valid chars string so we know how many choices we have
		$num_valid_chars = strlen($valid_chars);

		// repeat the steps until we've created a string of the right length
		for ($i = 0; $i < $length; $i++)
		{
			// pick a random number from 1 up to the number of valid chars
			$random_pick = mt_rand(1, $num_valid_chars);

			// take the random character out of the string of valid chars
			// subtract 1 from $random_pick because strings are indexed starting at 0, and we started picking at 1
			$random_char = $valid_chars[$random_pick-1];

			// add the randomly-chosen char onto the end of our string so far
			$random_string .= $random_char;
		}

		// return our finished random string
		return $random_string;
	}

	//Ejecucion
	if(verificarMail($_POST['id'],$result) == 1)
				{			
					include_once "../db/recoveryMail.php";
					$mailUsr = $_POST['id'];
					$nameUsr = $result->nombre;
					$recCode = get_random_string("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890", 16);
					$mail->AddAddress($mailUsr, $nameUsr);

					$mail->WordWrap = 50;  

					$mail->IsHTML(true);                                  // set email format to HTML
					$mail->Subject = "Codigo de Recuperacion de Acceso de BuyBuyAuctions";
					$mail->Body    = "Use el siguiente codigo de acceso para acceder a su cuenta y cambiar la contraseña por una más segura.<br/>
										Para cambiar la contraseña, inicie sesion y dirigase a Mi Cuenta, una vez dentro seleccione Gestionar Datos Usuario.<br/><br/>
										Codigo de Recuperacion: ".$recCode."<br />";
					$mail->AltBody = "This is the body in plain text for non-HTML mail clients";
					
					$recSql = "UPDATE `usuarios` SET `password` = '".$recCode."' WHERE `usuarios`.`mail` = '".$mailUsr."'";
					//$recSql = "UPDATE 'usuarios' SET 'password' = 'patoganso' WHERE 'usuarios'.'mail' = 'joselu.br93@gmail.com'"; 
					$sqlSuccess = mysql_query($recSql);
					
					if(!$mail->Send())
					{
					   echo "Message could not be sent. <p>";
					   echo "Mailer Error: " . $mail->ErrorInfo;
					   exit;
					}
					else
					{
						echo "Message has been sent";
					
						echo "Code has been set";
					}

					
				}
?>