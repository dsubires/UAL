<?php
session_start();
include_once "../db/sellerMail.php";

if(isset($_SESSION['userAuth']))
{
	$mailUsr = $_SESSION['emailid'];
	$nameUsr = $_SESSION['userName'];
}
else
{
	$mailUsr = $_POST['email'];
	$nameUsr = $_POST['nombre'];
}

$mail->AddAddress($mailUsr, $nameUsr);


$mail->WordWrap = 50;  


$mail->IsHTML(true);                                  // set email format to HTML
$mail->Subject = "Contacto: ".$_POST['nombre'];
$mail->Body    = "Mensaje: ".$_POST['mensaje']."<br />";

/*
$MESSAGE_BODY  = "Usuario: ".$_POST['nombre']."<br />";
$MESSAGE_BODY .= "E-mail: ".$_POST['email']."<br />";
$MESSAGE_BODY .= "Mensaje: ".$_POST['mensaje']."<br />";
*/
$mail->AltBody = "This is the body in plain text for non-HTML mail clients";

if(!$mail->Send())
{
   echo "Message could not be sent. <p>";
   echo "Mailer Error: " . $mail->ErrorInfo;
   exit;
}
else
{
	echo "Message has been sent";
}



/*
$email        = "info@buybuyauction.site88.net";

$asunto     = "Contacto: ".$_POST['nombre'];
$mensaje    = utf8_decode($MESSAGE_BODY);

$cabeceras     = "From: ".$_POST['email']."\n";
$cabeceras .= "Reply-To: ".$_POST['email']."\n";
$cabeceras .= "MIME-version: 1.0n";
$cabeceras .= "Content-type: multipart/mixed; ";
$cabeceras .= "boundary=Message-Boundary"."\n";
$cabeceras .= "Content-transfer-encoding: 7BIT"."\n";
//$cabeceras .= "X-attachments: ".$nombref;

$body_top  = "--Message-Boundary"."\n";
$body_top .= "Content-type: text/html; charset=US-ASCII"."\n";
$body_top .= "Content-transfer-encoding: 7BIT"."\n";
$body_top .= "Content-description: Mail message body"."\n";

$cuerpo = $body_top.$mensaje;

//Envío el correo
mail($email, $asunto, $cuerpo, $cabeceras);

header("location:principal.html");*/

?>