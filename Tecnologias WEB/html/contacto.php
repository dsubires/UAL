<?php
session_start();
?>

<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
	<link href="../css/contacto.css" rel="stylesheet" type="text/css">
    <title>Contacta con nosotros</title>
	
  </head>
  <body>


    <center>
	<fieldset style="border-color:black;border-style:solid;">
		<legend>Contacta con nosotros:</legend>
				<form action="mail_contacto.php" id="contacto" method="post" name="contacto" class="contact-form">

<?php				
				if(!isset($_SESSION['userAuth']))
				{
						echo	'<p class="comment-form-author"><label>Tu nombre:</label>
					    	    	<input type="text" name="nombre" class="textbox" placeholder="Escribe tu nombre..." required/>
						    	</p>
						        <p class="comment-form-author"><label>Email:</label>
						     	   <input type="text" name="email" class="textbox" placeholder="Escribe tu email..." required/>
						        </p>';
				}	
?>								  
						        <p class="comment-form-author"><label>Mensaje:</label>
						    	  <textarea name="mensaje" placeholder="Escribe tu mensaje"  required></textarea>
						        </p>
						        <input name="submit" type="submit" id="submit" value="Enviar"/>
				</form>		
				<div id="msgError"></div>
	
	</fieldset>
	</center>
  </body>
</html>