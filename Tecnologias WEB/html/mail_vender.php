<?php
session_start();
include_once "../db/sellerMail.php";
include_once "../db/conexion.php";

$sql = "SELECT * FROM usuarios WHERE mail = '".$_SESSION["emailid"]."'";

$rec = mysql_query($sql);
$row = mysql_fetch_object($rec);
/*				
$nombre_archivo = $_FILES['pic']['name'];
$tipo_archivo = $_FILES['pic']['type'];
$tamano_archivo = $_FILES['pic']['size'];
*/

$mail->AddAddress("buybuyauctions@gmail.com", "BuyBuyAuctions");
$mail->AddAddress($_SESSION["emailid"], $row->nombre." ".$row->apellidos);


$mail->WordWrap = 50;                                 // set word wrap to 50 characters
$mail->AddAttachment($_FILES['file']['tmp_name'], "product.jpg");         // add attachments

$mail->IsHTML(true);                                  // set email format to HTML
$mail->Subject = "Venta:".$_POST['articulo'];
$mail->Body    = "Usuario: ".$_SESSION["emailid"]."<br />
					Telefono: ".$row->telefono."<br />
					Articulo: ".$_POST["articulo"]."<br />
					Descripción: ".$_POST["descripcion"]."<br />
					Precio: ".$_POST["precio"]."<br />";
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

		
//insert into articulosofrecidos

$mail = $_SESSION['emailid'];
$articulo = $_POST['articulo'];
$descripcion = $_POST['descripcion'];
$precio = $_POST["precio"];

				$sql = "INSERT INTO articulosofrecidos(mail, articulo, descripcion, precio)
						VALUES ('$mail', '$articulo', '$descripcion', $precio)";

			mysql_query($sql);


/*
//Sentencias mysql recuperar datos usuario usando $_SESSION['mail']

$MESSAGE_BODY  = "Usuario: ".$_SESSION["mail"]."<br />";
$MESSAGE_BODY .= "Telefono: ".$_POST["telefono"]."<br />";
$MESSAGE_BODY .= "Articulo: ".$_POST["articulo"]."<br />";
$MESSAGE_BODY .= "Descripción: ".$_POST["descripcion"]."<br />";
$MESSAGE_BODY .= "Precio: ".$_POST["precio"]."<br />";

$email        = "ventas@buybuyauction.site88.net";

$asunto     = "Venta:".$_POST['articulo'];
$mensaje    = utf8_decode($MESSAGE_BODY);
$nombref    = $_FILES["pic"]["name"];

$cabeceras     = "From: ".$_SESSION["mail"]."\n";
$cabeceras .= "Reply-To: ".$_SESSION["mail"]."\n";
$cabeceras .= "MIME-version: 1.0n";
$cabeceras .= "Content-type: multipart/mixed; ";
$cabeceras .= "boundary=Message-Boundary"."\n";
$cabeceras .= "Content-transfer-encoding: 7BIT"."\n";
$cabeceras .= "X-attachments: ".$nombref;

$body_top  = "--Message-Boundary"."\n";
$body_top .= "Content-type: text/html; charset=US-ASCII"."\n";
$body_top .= "Content-transfer-encoding: 7BIT"."\n";
$body_top .= "Content-description: Mail message body"."\n";

$cuerpo = $body_top.$mensaje;

if($tamano_archivo>0)
{
//Leo el fichero
   $oFichero = fopen($_FILES["pic"]["tmp_name"], 'r'); 
   $sContenido = fread($oFichero, filesize($_FILES["pic"]["tmp_name"]));
   $sAdjuntos .= chunk_split(base64_encode($sContenido));
   fclose($oFichero);
   //Adjunto el fichero
   $cuerpo .= "\n\n"."--Message-Boundary"."\n";
   $cuerpo .= "Content-type: Binary; name=".$nombref."\n";
   $cuerpo .= "Content-Transfer-Encoding: BASE64"."\n";
   $cuerpo .= "Content-disposition: attachment; filename=".$nombref."\n";
   $cuerpo .= $sAdjuntos."\n";
   $cuerpo .= "--Message-Boundary--";
}
//Envío el correo
mail($email, $asunto, $cuerpo, $cabeceras);
*/
?>