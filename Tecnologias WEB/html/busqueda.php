<?php
require('../db/conexion.php');

$busqueda=$_POST['busqueda'];
// DEBO PREPARAR LOS TEXTOS QUE VOY A BUSCAR si la cadena existe
if ($busqueda<>''){
	//CUENTA EL NUMERO DE PALABRAS
	//$trozos=explode(" ",$busqueda);
	//$numero=count($trozos);
	/*if ($numero==1) {
		//SI SOLO HAY UNA PALABRA DE BUSQUEDA SE ESTABLECE UNA INSTRUCION CON LIKE
		$cadbusca="SELECT * FROM articulos WHERE NOMBRE LIKE '%$busqueda%' OR DESCRIPCION LIKE '%$busqueda%' LIMIT 10;";
	} elseif ($numero>1) {
		//SI HAY UNA FRASE SE UTILIZA EL ALGORTIMO DE BUSQUEDA AVANZADO DE MATCH AGAINST
		//busqueda de frases con mas de una palabra y un algoritmo especializado
		$cadbusca="SELECT * , MATCH ( NOMBRE, DESCRIPCION ) AGAINST ( '$busqueda' ) FROM articulos WHERE MATCH ( TITULO, DESCRIPCION ) AGAINST ( '$busqueda' ) ORDER BY id_articulo DESC LIMIT 50;";
	}*/
	$cadbusca="SELECT * FROM articulos WHERE NOMBRE LIKE '%$busqueda%' OR DESCRIPCION LIKE '%$busqueda%' LIMIT 10;";
	
	function limitarPalabras($cadena, $longitud, $elipsis = "..."){
		$palabras = explode(' ', $cadena);
		if (count($palabras) > $longitud)
			return implode(' ', array_slice($palabras, 0, $longitud)) . $elipsis;
		else
			return $cadena;
	}
?>
	<table style="width:50%;" border="0px"> 
	<tbody>
		<tr>
			<td class="titulo"><h2>Resultados Busqueda de Articulos:</h2></td>			
		</tr>
<?php
	$result=mysql_query($cadbusca);
	$i=1;
	while ($row = mysql_fetch_array($result)){
		$temp= "onClick=";
		$temp.="top.window.history.pushState('data','Titulo','index.php?item=".$row[0]."');";
		echo "
			<tr>				
				<td class=\"contenido\"><a href='./html/ver_producto.php?id=$row[0]' ".$temp." target='pframe'>".limitarPalabras($row['nombre'],20)."</a></td>				
			</tr>";
		$i++;
	}
	if($i == 1){
		echo "
			<tr>				
				<td class=\"contenido\">No hay resultados para '".$busqueda."'.</td>				
			</tr>";
	}
	
}
?>
	<tr>
		<td class=\"contenido\"><input type='button' onclick=clearBox('resultado') value='Limpiar Busqueda' /></td>
	</tr>
	</tbody>
	</table>