<%-- 
    Document   : edit
    Created on : 30-ene-2015, 10:57:18
    Author     : AngelakaMogu
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.izv.hibernate.Inmueble"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Inmueble inm = (Inmueble) request.getAttribute("inmueble");
    SimpleDateFormat formato = new SimpleDateFormat();
    formato.applyPattern("yyyy-dd-MM");
    String fecha = formato.format(inm.getFechaalta());
%>
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
                <input class="form-field" type="text" name="localidad" value="<%= inm.getLocalidad()%>" /><br />
                <div class="form-title">Direccion</div>
                <input class="form-field" type="text" name="direccion" value="<%= inm.getDireccion()%>" /><br />
                <div class="form-title">Tipo</div>
                <input class="form-field" type="text" name="tipo" value="<%= inm.getTipo()%>" /><br />
                <div class="form-title">Precio</div>
                <input class="form-field" type="text" name="precio" value="<%= inm.getPrecio()%>" /><br />
                <div class="form-title">Precio</div>
                <input class="form-field" type="text" name="usuario" value="<%= inm.getUsuario()%>" /><br />
                <input type="hidden" name="target" value="inmobiliaria" />
                <input type="hidden" name="op" value="edit" />
                <input type="hidden" name="action" value="op" />
                <input type="hidden" name="fecha" value="<%= fecha%>" />   
                <input type="hidden" name="id" value="<%= inm.getId()%>" />
                <div class="submit-container">
                    <input class="submit-button" type="submit" value="Editar" />
                </div>
            </form>
        </div>
    </body>
</html>
