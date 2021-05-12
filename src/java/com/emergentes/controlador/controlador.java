/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.controlador;
import com.emergentes.dao.postsdao;
import com.emergentes.dao.postsdaoimpl;
import com.emergentes.modelo.Posts;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author CristhianFriasJaldin
 */
@WebServlet(name = "controlador", urlPatterns = {"/controlador"})
public class controlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            postsdao dao = new postsdaoimpl();
            int id;
            Posts post = new Posts();
            String action = (request.getParameter("action") != null ? request.getParameter("action"):"view");
            
            switch(action){
                case "add":
                    request.setAttribute("post", post);
                    request.getRequestDispatcher("nuevo_post.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    post = dao.getById(id);
                    System.out.println(post);
                    request.setAttribute("post", post);
                    
                    request.getRequestDispatcher("nuevo_post.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect(request.getContextPath()+"/controlador");
                    break;
                case "view":
                    List<Posts> lista = dao.getAll();
                    request.setAttribute("post", lista);
                    request.getRequestDispatcher("blog.jsp").forward(request, response);
                default:
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Error " +ex.getMessage());
        }
        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        String fecha = request.getParameter("fecha");
        String titulo = request.getParameter("titulo");
        String contenido = request.getParameter("contenido");
        
        Posts avi = new Posts();
        avi.setId(id);
        avi.setFecha(fecha);
        avi.setTitulo(titulo);
        avi.setContenido(contenido);
        
        if(id == 0){
            try {
                postsdao dao = new postsdaoimpl();
                dao.insert(avi);
                response.sendRedirect(request.getContextPath()+"/controlador");
            } catch (Exception ex) {
                System.out.println("Error "+ ex.getMessage());
            }
        }else{
            try {
                postsdao dao = new postsdaoimpl();
                dao.update(avi);
                response.sendRedirect(request.getContextPath()+"/controlador");
            } catch (Exception ex) {
                System.out.println("Error " +ex.getMessage());
            }
        }
        
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
