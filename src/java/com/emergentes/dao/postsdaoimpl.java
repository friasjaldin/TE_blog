/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.dao;
import com.emergentes.conexion.ConexionDB;
import com.emergentes.modelo.Posts;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author CristhianFriasJaldin
 */
public class postsdaoimpl extends ConexionDB implements postsdao{

    @Override
    public void insert(Posts posts) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("insert into posts (fecha ,titulo, contenido) values (?,?,?)");
            ps.setString(1, posts.getFecha());
            ps.setString(2, posts.getTitulo());
            ps.setString(3, posts.getContenido());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
    }

    @Override
    public void update(Posts posts) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("update posts set fecha=?, titulo=?, contenido=? where id = ?");
            ps.setString(1, posts.getFecha());
            ps.setString(2, posts.getTitulo());
            ps.setString(3, posts.getContenido());
            ps.setInt(4, posts.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("delete from posts where id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
    }

    @Override
    public Posts getById(int id) throws Exception {
        Posts post=new Posts();
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("select * from posts where id= ? limit 1");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                
                post.setId(rs.getInt("id"));
                post.setFecha(rs.getString("fecha"));
                post.setTitulo(rs.getString("titulo"));
                post.setContenido(rs.getString("contenido"));
                
            }
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
        return post;
    }

    @Override
    public List<Posts> getAll() throws Exception {
         List<Posts> lista = null;
        
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM posts ORDER BY fecha DESC;");
            ResultSet rs = ps.executeQuery();
            
            lista = new ArrayList<Posts>();
            while (rs.next()) {                
                Posts post = new Posts();
                post.setId(rs.getInt("id"));
                post.setFecha(rs.getString("fecha"));
                post.setTitulo(rs.getString("titulo"));
                post.setContenido(rs.getString("contenido"));
                lista.add(post);
            }
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
        return lista;
    }
    
}