function validar(){
	
	//VALIDAR TAMAÑO DE CAMPOS (NOMBRE, ETC, ETC)
 
 
	//RECOGEMOS LOS CAMPOS EN VARIABLES
	var titulo = document.getElementById("titulo").value;
	var descripcion = document.getElementById("descripcion").value;
	var precio = document.getElementById("precio").value;

	
	var msgError = document.getElementById("msgError"); 

 

	//COMPROBAR QUE LOS CAMPOS NO ESTAN VACIOS
	if( titulo == null || titulo.length == 0 || /^\s+$/.test(titulo) ) {
		msgError.innerHTML = "<font color='red'>Debes introducir el titulo</font>"; 
		return false;
	}else if( descripcion == null || descripcion.length == 0 || /^\s+$/.test(descripcion) ) {
		msgError.innerHTML = "<font color='red'>Debes introducir la descripcion</font>"; 
		return false;
		return false;
	}else if( precio == null || precio.length == 0 || /^\s+$/.test(precio) ) {
		msgError.innerHTML = "<font color='red'>Debes introducir el precio</font>"; 
		return false;
	}else if(isNaN(precio)){
		msgError.innerHTML = "<font color='red'>El precio debe ser num&eacuterico</font>" ;
		return false;
	}
	msgError.innerHTML = ""; 
	return true;
}
