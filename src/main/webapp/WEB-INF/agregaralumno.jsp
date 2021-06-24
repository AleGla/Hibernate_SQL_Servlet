<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Alumno</title>
        <link href="<c:url value='recursos/estilos.css'/>" rel="stylesheet"/>
        <script type="text/javascript" src="<c:url value='recursos/funciones.js'/>"></script>
    </head>
    <body>
        
        <p class="texto">Agregar Alumno</p>
        <div class="Registro">
        <form onsubmit="validarAlumno(this)">

        <span class="fontawesome-user"></span>  
        <input type="text" placeholder="Nombre del Alumno" id="nombre" name="nombre"/>
        </br>
        <span class="fontawesome-user"></span>
        <input type="text" placeholder="Apellido del Alumno" id="apellido" name="apellido"/>
        </br>       
        <span class="fontawesome-user"></span>
        <input type="text" placeholder="Calle" id="calle" name="calle"/>
        </br>
        <span class="fontawesome-user"></span>
        <input type="text" placeholder="No.Calle" id="noCalle" name="noCalle"/>
        </br>
        <span class="fontawesome-user"></span>
        <input type="text" placeholder="Pais" id="pais" name="pais"/>
        </br>
        <span class="fontawesome-user"></span>
        <input type="text" placeholder="Email"id="email" name="email"/>
        </br>
        <span class="fontawesome-user"></span>
        <input type="text" placeholder="Telefono" id="telefono" name="telefono"/>
        </br>

        <input type="submit" value="Agregar" />
        
        </form>
        </div>
        
    </body>
</html>
