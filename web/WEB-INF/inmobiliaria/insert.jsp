<%-- 
    Document   : insert
    Created on : 30-ene-2015, 11:00:06
    Author     : AngelakaMogu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" />
        <title>Inmobiliaria Zaidin Vergeles</title>
    </head>
    <body>
        <div class="container">
            <form class="form-container" action="control" method="POST">
                <div class="form-title"><h2>Insertar</h2></div>
                <div class="form-title">Localidad</div>
                <input class="form-field" type="text" name="localidad" value="" /><br />
                <div class="form-title">Direccion</div>
                <input class="form-field" type="text" name="direccion" value="" /><br />
                <div class="form-title">Tipo</div>
                <input class="form-field" type="text" name="tipo" value="" /><br />
                <div class="form-title">Precio</div>
                <input class="form-field" type="text" name="precio" value="" /><br />
                <div class="form-title">Usuario</div>
                <input class="form-field" type="text" name="usuario" value="" /><br />
                <input type="hidden" name="target" value="inmobiliaria" />
                <input type="hidden" name="op" value="insert" />
                <input type="hidden" name="action" value="op" />
                <div class="submit-container">
                    <input class="submit-button" type="submit" value="insertar" />
                </div>
            </form>
        </div>
    </body>
</html>
