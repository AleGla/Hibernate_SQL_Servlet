<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Alumno</title>
        <link href="<c:url value='recursos/estilos.css'/>" rel="stylesheet"/>
        <script type="text/javascript" src="recursos/funcionModificar.js"></script>
    </head>
    <body>
        <p class="texto">Modificar Alumno</p>
        <div class="Registro">
        
        <form onsubmit="return modificar(this)">

        <span class="fontawesome-user"></span>    
        <input type="number" id="id" name="id" placeholder="Introduce ID del alumno" value=0/>
        
        <span class="fontawesome-user"></span>
        <input type="text" id="nombre" name="nombre" value="" placeholder="Nombre del Alumno"/>

        <span class="fontawesome-user"></span>
        <input type="text" id="apellido" name="apellido" value="" placeholder="Apellido del Alumno"/>
        
        <span class="fontawesome-user"></span>
        <input type="text" id="calle" name="calle" value="" placeholder="Calle"/>

        <span class="fontawesome-user"></span>
        <input type="text" id="noCalle" name="noCalle" value="" placeholder="Numero de Calle"/>

        <span class="fontawesome-user"></span>
        <input type="text" id="pais" name="pais" value="" placeholder="Pais"/>
        
        <span class="fontawesome-user"></span>
        <input type="text" id="email" name="email" value="" placeholder="Email"/>

        <span class="fontawesome-user"></span>
        <input type="text" id="telefono" name="telefono" value="" placeholder="Telefono"/>

        <input type="submit" value="Modificar" />
        
        </form>
        
    </body>
</html>
