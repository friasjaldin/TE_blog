/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.controlador;

import com.emergentes.dao.usuariosdaoimpl;
import com.emergentes.modelo.Usuarios;
import com.emergentes.dao.usuariosdao;
import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author CristhianFriasJaldin
 */
@WebServlet(name = "temporal", urlPatterns = {"/temporal"})
public class temporal extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int adelante=0;
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        
        Usuarios us=new Usuarios();
        
        us.setUsuario(usuario);
        us.setPassword(password);
        try {
            usuariosdao dao=new usuariosdaoimpl();
            if (dao.autenticar(us)) {
                response.sendRedirect(request.getContextPath()+"/controlador");
            }else{
                request.setAttribute("adelante", adelante);
                
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
            
        } catch (Exception ex) {
            System.out.println("Error " +ex.getMessage());
        }
        
        System.out.println("usuario: "+usuario+" password: "+password);
 
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}