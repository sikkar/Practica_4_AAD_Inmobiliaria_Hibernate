<%-- 
    Document   : addImagen
    Created on : 01-feb-2015, 16:48:46
    Author     : AngelakaMogu
--%>

<%@page import="com.izv.hibernate.Inmueble"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Inmueble inm =(Inmueble)request.getAttribute("inmueble");
    
 %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Subir Archivo</h1>
        <form action="control" method="post" enctype="multipart/form-data">
            <input type="text" name="descripcion" />
            <input type="file" name="archivo" />
            <input type="hidden" name="id" value="<%= inm.getId()%>" />
            <input type="hidden" name="target" value="inmobiliaria" />
            <input type="hidden" name="op" value="imagen" />
            <input type="hidden" name="action" value="op" />
            <input type="submit" value="Subir" />
            
        </form>
    </body>
</html>
