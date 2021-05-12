/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.dao;
import com.emergentes.conexion.ConexionDB;
import com.emergentes.modelo.Usuarios;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author CristhianFriasJaldin
 */
public class usuariosdaoimpl extends ConexionDB implements usuariosdao{

    @Override
    public boolean autenticar(Usuarios usuarios) throws Exception {
        
        
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT usuario, password FROM usuarios WHERE usuario=? and password=?");
            ps.setString(1, usuarios.getUsuario());
            ps.setString(2, usuarios.getPassword());
            ResultSet rs=ps.executeQuery();
            if (rs.absolute(1)) {
                return true;
            }
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
        return false;
    }}