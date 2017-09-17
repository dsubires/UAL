<?php

include("class.phpmailer.php");
include("class.smtp.php");

$mail = new PHPMailer();
$mail->SMTPDebug  = 2;                     // enables SMTP debug information (for testing)
$mail->IsSMTP();                                      // set mailer to use SMTP
$mail->SMTPAuth   = true;                  // enable SMTP authentication
$mail->SMTPSecure = "tls";                 // sets the prefix to the servier
$mail->Host       = "smtp.gmail.com";      // sets GMAIL as the SMTP server
$mail->Port       = 587;                   // set the SMTP port for the GMAIL server
$mail->Username = "buybuyauctions@gmail.com";  // SMTP username
$mail->Password = "123buybuy"; // SMTP password

$mail->SetFrom('buybuyauctions@gmail.com', 'BuyBuyAuctions Ventas');
$mail->AddReplyTo("buybuyauctions@gmail.com","BuyBuyAuctions");
$mail->AddAddress("buybuyauctions@gmail.com", "BuyBuyAuctions");
?>