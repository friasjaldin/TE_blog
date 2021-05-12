/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.dao;
import com.emergentes.modelo.Usuarios;
/**
 *
 * @author CristhianFriasJaldin
 */
public interface usuariosdao {
    public boolean autenticar(Usuarios usuarios) throws Exception;
}
