function validarAlumno(forma){
  
    var nombre = forma.nombre;
    if(nombre.value === ""){
        alert("Debes Proporcionar un Nombre");
        nombre.focus();
        nombre.select();
        return false;
    }    
    
    var apellido = forma.apellido;
    if(apellido.value === ""){
        alert("Debes proporcionar un Apellido");
        apellido.focus();
        apellido.select();
        return false;
    }
    
    var calle = forma.calle;
    if(calle.value === ""){
        alert("Debes proporcionar una calle");
        calle.focus();
        calle.select();
        return false;
    }
    
    var noCalle = forma.noCalle;
    if(noCalle.value === ""){
        alert("Debes proporcionar un Numero de Calle");
        noCalle.focus();
        noCalle.select();
        return false;
    }
    
    var pais = forma.pais;
    if(pais.value === ""){
        alert("Debes proporcionar un Pais");
        pais.focus();
        pais.select();
        return false;
    }
    
    var email = forma.email;
    if(email.value === ""){
        alert("Debes proporcionar un Email");
        email.focus();
        email.select();
        return false;
    }
    
    var telefono = forma.telefono;
    if(telefono.value() === ""){
        alert("Deber proporcionar un Telefono");
        telefono.focus();
        telefono.select();
        return false;
    }
    //FORMULARIO VALIDO
    alert("El Registro del Alumno Ha Sido Registrado");
    return true;
    
}


