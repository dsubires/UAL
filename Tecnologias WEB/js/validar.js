function validar(){
	
	//VALIDAR TAMAÑO DE CAMPOS (NOMBRE, ETC, ETC)
 
 
	//RECOGEMOS LOS CAMPOS EN VARIABLES
	var nombre = document.getElementById("nombre").value;
	var apellidos = document.getElementById("apellidos").value;
	var telefono = document.getElementById("tfn").value;
	var email  = document.getElementById("mail").value;
	var direccion = document.getElementById("direccion").value;
	var poblacion = document.getElementById("poblacion").value;
	var cp = document.getElementById("cp").value;
	var pais = document.getElementById("pais").value;
	var pass = document.getElementById("pass").value;
	var rpass = document.getElementById("rpass").value;
	

	
	var msgError = document.getElementById("msgError"); 

 
	//LAS LETRAS SON PARA COMPROBAR EL DNI
	var letras = ['T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N','J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E', 'T'];
 
	//COMPROBAR QUE LOS CAMPOS NO ESTAN VACIOS
	if( nombre == null || nombre.length == 0 || /^\s+$/.test(nombre) ) {
		msgError.innerHTML = "<font color='red'>Debes introducir tu nombre</font>"; 
		return false;
	}else if( apellidos == null || apellidos.length == 0 || /^\s+$/.test(apellidos) ) {
		msgError.innerHTML = "<font color='red'>Debes introducir tus apellidos</font>"; 
		return false;
	}else if( telefono == null || telefono.length == 0 || /^\s+$/.test(telefono) ) {
		msgError.innerHTML = "<font color='red'>Debes introducir tu telefono</font>"; 
		return false;
	}else if( email == null || email.length == 0 || /^\s+$/.test(email) ) {
		msgError.innerHTML = "<font color='red'>Debes introducir tu email</font>"; 
		return false;	
	}else if( direccion == null || direccion.length == 0 || /^\s+$/.test(direccion) ) {
		msgError.innerHTML = "<font color='red'>Debes introducir tu direccion</font>"; 
		return false;	
	}else if( poblacion == null || poblacion.length == 0 || /^\s+$/.test(poblacion) ) {
		msgError.innerHTML = "<font color='red'>Debes introducir tu poblacion</font>"; 
		return false;	
	}else if( cp == null || cp.length == 0 || /^\s+$/.test(cp) ) {
		msgError.innerHTML = "<font color='red'>Debes introducir tu codigo postal</font>"; 
		return false;	
	}else if( pais == null || pais.length == 0 || /^\s+$/.test(pais) ) {
		msgError.innerHTML = "<font color='red'>Debes introducir tu pais</font>"; 
		return false;	
	}else if( pass == null || pass.length == 0 || /^\s+$/.test(pass) ) {
		msgError.innerHTML = "<font color='red'>Debes introducir tu contrase&ntildea</font>"; 
		return false;	
	}else if( rpass == null || rpass.length == 0 || /^\s+$/.test(rpass) ) {
		msgError.innerHTML = "<font color='red'>Debes de repetir tu contrase&ntildea</font>"; 
		return false;			
		
	//COMPROBAR  QUE EL TELEFONO ES CORRECTO	
	}else if( isNaN(telefono)){
		msgError.innerHTML = "<font color='red'>El telefono no puede contener letras</font>" ;
		return false;
	}else if( !(/^\d{9}$/.test(telefono)) ) {
		msgError.innerHTML = "<font color='red'>El telefono debe tener 9 digitos</font>" ;
		return false;
	//COMPROBAR QUE EL DNI CORRECTO
	}else if(dni.charAt(8).toUpperCase()  != letras[(dni.substring(0, 8))%23]) {
		msgError.innerHTML = "<font color='red'>El DNI no es correcto</font>" ;
		return false;
	}else if( email == null || email.length == 0 || /^\s+$/.test(email) ) {
		msgError.innerHTML = "<font color='red'>Debes introducir tu E-mail</font>"; 
		return false;
	//COMPROBAR QUE EL FORMATO DEL E-MAIL ES CORRECTO
	}else if(!(/[\w-\.]{3,}@([\w-]{2,}\.)*([\w-]{2,}\.)[\w-]{2,4}/.test(email)) ){
		msgError.innerHTML = "<font color='red'>El E-mail no es correcto</font>";
		return false
	//COMPROBAR  QUE EL CODIGO POSTAL ES CORRECTO	
	}else if( isNaN(cp)){
		msgError.innerHTML = "<font color='red'>El codigo postal no puede contener letras</font>" ;
		return false;
	//COMPROBAR QUE EL CODIGO POSTAL ES CORRECTO
	}else if( !(/^\d{5}$/.test(cp)) ) {
		msgError.innerHTML = "<font color='red'>El codigo postal debe tener 5 digitos</font>" ;
		return false;
	//COMPROBAR  QUE LAS CONTRASEÑAS COINCIDEN
	}else if(pass != rpass){
		msgError.innerHTML = "<font color='red'>Las contraseñas introducidas no coinciden</font>" ;
		return false;
	}
	msgError.innerHTML = ""; 
	return true;
}
