<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 
    Document   : login
    Created on : 08-05-2021, 08:22:14 PM
    Author     : CristhianFriasJaldin
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LOGIN</title>
    </head>
    <body>
        <div >

        <h1>LOGIN</h1>
        
        <table border="0" style="margin: 0 auto;" bgcolor="orange" >
        <td rowspan="20"> </tr>
        <tr><td><b>PRACTICA 5 EL BLOG </b></td>  
        <tr><td><b>Nombre:  </b></td> <td>Cristhian Jaime Frias Jaldin</td> 
        <tr><td><b>Ci:  </b></td> <td >10072610 lp</td>
         <tr><td><b>email:  </b></td> <td>friasyoyo@gmail.com </td> 
        <tr><td><b>celular|whatsapp:  </b></td> <td>60122932 </td>
       </table>
        
        <c:if test="${adelante==0}">
            <p>Usuario / Password Incorrecto <p></c:if>
        <form action="temporal" method="post">
            <table border="0" style="margin: 0 auto;" bgcolor="yellow" >
                <tr>
                    <th><b>Usuario</b></th>
                    <td><input type="text" name="usuario" size="15" /></td>
                </tr>
                <tr>
                    <th><b>Password</b></th>
                    <td><input type="password" name="password" size="15" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Ingresar" /></td>
                </tr>
            </table>
        </form>    
        </div>
    </body>
</html>
