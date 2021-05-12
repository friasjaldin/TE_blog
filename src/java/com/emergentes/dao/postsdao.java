/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.dao;
import com.emergentes.modelo.Posts;
import java.util.List;
/**
 *
 * @author CristhianFriasJaldin
 */
public interface postsdao {
    public void insert(Posts posts) throws Exception;
    public void update(Posts posts) throws Exception;
    public void delete(int id) throws Exception;
    public Posts getById(int id) throws Exception;
    public List<Posts> getAll() throws Exception;
}