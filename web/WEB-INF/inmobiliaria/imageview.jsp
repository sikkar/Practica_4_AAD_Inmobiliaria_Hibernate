<%-- 
    Document   : imageview
    Created on : 01-feb-2015, 21:11:12
    Author     : AngelakaMogu
--%>

<%@page import="com.izv.modelo.ModeloFoto"%>
<%@page import="com.izv.hibernate.Inmueble"%>
<%@page import="com.izv.hibernate.Fotos"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Inmueble inm =(Inmueble)request.getAttribute("inmueble");
    String id= String.valueOf(inm.getId());
    List <Fotos> lista = ModeloFoto.getAll(id);
    String carpeta =  "fotos/";
 %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Visor de Imagenes</title>
    </head>
    <body>
        <table border="1">
            <h1>Fotos del inmueble</h1>
            <tbody>
                <%
                   for(Fotos f: lista){
                %>
                <tr>
                    <td><img src="<%=carpeta+f.getNombre()%>"></td>
                    <td><a href="control?target=inmobiliaria&op=deletefoto&action=op&id=<%=f.getId()%>">Borrar</a></td>
                </tr>
                <%
                    }
                %>
                
            </tbody>
        </table>
    </body>
</html>
