function modificar(forma){
    
    var id = forma.id;
    
    if(id.value===null | id.value===0 || id.value==="" || id.value==="0"){
        alert("Debes Introducir el ID del Alumno para Modificar su Registro");
        id.focus();
        id.select();
        return false;
    }
    
    //SI SE AGREGA EL ID ES TRUE    
    alert("Se han modificado correctamente los datos del registro del alumno");
    return true;
}

