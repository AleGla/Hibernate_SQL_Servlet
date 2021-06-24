<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado Personas</title>
        <link href="<c:url value='recursos/estilosLista.css'/>" rel="stylesheet"/>
        <script type="text/javascript" src="recursos/funcion.js"></script>
    </head>
    <body>
        
        <h1 id="texto">Lista de Alumnos</h1>
        <table class="container">
            <thead>
            <tr>
            <th><h1>Alumno ID</h1></th>
            <th><h1>Nombre</h1></th>
            <th><h1>Domicilio</h1></th>
            <th><h1>Email</h1></th>
            <th><h1>Telefono</h1></th>
            <th><h1>Borrar</h1></th>
        </tr>
             </thead>
        
             <tbody>
        <c:forEach var="personas" items="${personas}">
                <tr>
                    <td style="text-align: center"> <a >${personas.idAlumno}</a> </td>
                    <td>${personas.nombre} ${personas.apellido}</td>
                    <td>${personas.domicilio.calle} ${personas.domicilio.noCalle} ${personas.domicilio.pais}</td>
                    <td>${personas.contacto.email}</td>
                    <td>${personas.contacto.telefono}</td>
                <form>
                    <td id="boton"><button type="submit" onclick="return eliminar(this)" name="borrar" id="borrar" value="${personas.idAlumno}">X</button></td>
                </form>
                </tr>
            </c:forEach>
             </tbody>   
    </table>
</body>
</html>
