<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : blog
    Created on : 08-05-2021, 08:21:39 PM
    Author     : CristhianFriasJaldin
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>Blog</title>
    </head>
    <body>
       
        <h3 style="text-align: right; margin-right:70px;">          
               Administrador 
                <a href="login.jsp" >Salir</a>
         </h3>   
        
        <h1 style="text-align: center;"><b>BLOG DE SALUD</b></h1>
        <h3><a href="controlador?action=add" style="margin-left: 70px">Nueva Entrada</a></h3><br>
        <c:forEach var="item" items="${post}">

            <table style="margin-left: 50px; margin-right: 50px;text-align: left;">
                <tr>
                    <td>${item.fecha}</td>
                </tr>
                <tr>
                    <th><h2>${item.titulo}</h2></th>
                </tr>
                <tr>
                    <td>${item.contenido}</td>
                </tr>
                <tr style="text-align: right;">
        
                    <td><a href="controlador?action=edit&id=${item.id}">Editar</a></td>
                    <td><a href="controlador?action=delete&id=${item.id}" onclick="return(confirm('Quiere Borrar la Entrada?'))">Eliminar</a></td>
                    
                </tr>

            </table>
            <hr>
            <br>
        </c:forEach>    
</body>
</html>
