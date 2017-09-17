<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Añadir categoria</title>
	<link href="../../css/adminStyle.css" rel="stylesheet" type="text/css">
  </head>
	<body>
		<span style="float:left">Usted est&aacute aqu&iacute: <a href="main.php">Inicio</a> > <a href="products.php">Gesti&oacuten de productos</a> > <a href="categories.php"> Gesti&oacuten de categorias</a> > <a href="addcategories.php">A&ntildeadir categoria</a></span><br/>
			<fieldset style="border-color:black;border-style:solid;">
			<legend>Gestionar Categorias</legend>
				<form action="addcategories2.php" method="POST">
					<label>Categoria:</label>
					<input type="text" id="categoria" name="categoria" placeholder="Categoria" required/><br/>
					<input type="submit" value="Añadir" /> 
				</form>
					<form action="categories.php">
						<input type="submit" value="Atras">
					</form>
</html>