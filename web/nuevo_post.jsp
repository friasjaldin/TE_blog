<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : nuevo_post
    Created on : 08-05-2021, 08:22:38 PM
    Author     : CristhianFriasJaldin
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo Post</title>
    </head>
       
    <body>
        
        <h1>
        <c:if test="${post.id == 0}">Nuevo </c:if>
        <c:if test="${post.id != 0}">Editar</c:if>
        posts
        
        </h1>
            <form action="controlador" method="post">
                <input type="hidden" name="id" value="${post.id}"/>
                <table border="0" style="margin: 0 auto;" bgcolor="orange">
                    <tr>
                        <td><h3><b>Fecha</b></h3></td>
                        <td><input type="date" name="fecha" value="${post.fecha}"/></td>
                    </tr>
                    <tr>
                        <td><h3><b>Titulo</b></h3></td>
                        
                        <td>
                            <input type="text" name="titulo" value="${post.titulo}"/></td>
                    </tr>
                    
                    <tr>
                        <td><h3><b>Contenido</b></h3></td>
                        <td><textarea name="contenido" rows="10" cols="80">
                                ${post.contenido}
                            </textarea></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit"/></td>
                    </tr>
                </table>
            </form>

    </body>
</html>
