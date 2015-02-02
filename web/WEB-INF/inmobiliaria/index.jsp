<%-- 
    Document   : index
    Created on : 30-ene-2015, 10:43:11
    Author     : AngelakaMogu
--%>

<%@page import="java.util.List"%>
<%@page import="com.izv.hibernate.Inmueble"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" />
        <title>Inmobiliaria Zaidin Vergeles</title>
    </head>
    <body>
        <h1>Listado de Inmuebles</h1>
        <h2>
            <a href="control?target=inmobiliaria&op=insert&action=view">insertar registro</a>
        </h2>
        
        <div class="tabla" >
            <table >
                <tr>
                    <td>
                        id
                    </td>
                    <td >
                        Localidad
                    </td>
                    <td>
                        Direccion
                    </td>
                    <td>
                        Tipo
                    </td>
                    <td>
                        Precio
                    </td>
                    <td>
                        Usuario
                    </td>
                    <td>
                        Añadida
                    </td>
                    <td>
                       
                    </td>
                    <td>
                       
                    </td>
                    <td>
                       
                    </td>
                    <td>
                       
                    </td>
                </tr>
                 <%
                    List<Inmueble> lista = (List) request.getAttribute("datos");
                    for (Inmueble inm : lista) {
                %>
                <tr>
                    <td><%= inm.getId()%></td>
                    <td><%= inm.getLocalidad()%></td>
                    <td><%= inm.getDireccion()%></td>
                    <td><%= inm.getTipo()%></td>
                    <td><%= inm.getPrecio()%></td>
                    <td><%= inm.getUsuario()%></td>
                    <td><%= inm.getFechaalta().toString()%></td>
                    <td><a href="control?target=inmobiliaria&op=imagen&action=view&id=<%= inm.getId()%>">Añadir Imagen</a></td>
                    <td><a href="control?target=inmobiliaria&op=imagenes&action=view&id=<%= inm.getId()%>">Ver Imagenes</a></td>
                    <td><a href="control?target=inmobiliaria&op=delete&action=op&id=<%= inm.getId()%>">Borrar</a></td>
                    <td><a href="control?target=inmobiliaria&op=edit&action=view&id=<%= inm.getId()%>">Editar</a></td>
                </tr>
                <%
                    }
                %>
            </table>
        </div>

    </body>
</html>
