/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.conexion.*;
import com.modelo.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Nombre de la clase:Cliente 
 * Versión:1.0 
 * Fecha:28/10/2017 
 * Copyright:ITCA-FEPADE
 * @author Karen Escobar
 */
public class CrudCliente extends Conexion {

    public void registrarCliente(Cliente c) throws Exception {
        try {
            this.conectar();
            String sql = "insert into (nombre,genero) values(?,?)";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, c.getNombre());
            pre.setString(2, c.getGenero());
            pre.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }
    
    public void modificarCliente(Cliente c) throws Exception{
        try {
            this.conectar();
            String sql="update cliente set nombre=?, genero=? where codigoCliente=?";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setString(1, c.getNombre());
            pre.setString(2, c.getGenero());
            pre.setInt(3, c.getCodigoCliente());
            pre.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
        this.desconectar();
        }
    }
    
    public void eliminarCliente(Cliente c) throws Exception{
        try {
            this.conectar();
            String sql="delete from cliente where codigoCliente=?";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, c.getCodigoCliente());
            pre.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
        this.desconectar();
        }
    }
    
    public List<Cliente> listarClientes() throws Exception{
        ResultSet res;
        List<Cliente> lista; 
        try {
            this.conectar();
            String sql="select * from cliente";
            PreparedStatement pre=this.getCon().prepareCall(sql);
            res=pre.executeQuery();
            lista = new ArrayList();
            while (res.next()) {                
                Cliente c= new Cliente();
                c.setCodigoCliente(res.getInt("codigoCliente"));
                c.setNombre(res.getString("nombre"));
                c.setGenero(res.getString("genero"));
                lista.add(c);
            }
        } catch (Exception e) {
            throw e;
        }finally{
        this.desconectar();
        }
        return lista;
    }
    
    public Cliente leerId(Cliente c) throws Exception{
        Cliente cl= null;
        ResultSet res;
        try {
            this.conectar();
            String sql="select * from cliente where codigoCliente=?";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, cl.getCodigoCliente());
            res=pre.executeQuery();
            while (res.next()) {                
                cl= new Cliente();
                cl.setCodigoCliente(res.getInt("codigoCliente"));
                cl.setNombre(res.getString("nombre"));
                cl.setGenero(res.getString("genero"));
            }
        } catch (Exception e) {
            throw e;
        }finally {
        this.desconectar();
        }
        return cl;
    }
}
