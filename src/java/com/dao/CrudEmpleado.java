/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;

import com.conexion.Conexion;
import com.modelo.Empleado;
import java.sql.*;

/**
 * Nombre de la clase:CrudEmpleado
 * Versión:1.0 
 * Fecha:29/10/2017 
 * Copyright:ITCA-FEPADE
 * @author Karen Escobar
 */
public class CrudEmpleado extends Conexion{
     public void registrarEmpleado(Empleado em) throws Exception{
        try {
            this.conectar();
            String sql="insert into empleado(nombre, genero, intereses,edad,direccion, cargo, codigoDeparatento) values(?,?,?,?,?,?,?)";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, em.getNombre());
            pre.setString(2, em.getGenero());
            pre.setArray(3, em.getIntereses());
            pre.setInt(4, em.getEdad());
            pre.setString(5, em.getDireccion());
            pre.setString(6, em.getCargo());
            pre.setInt(7, em.getCodigoDepartamento());
            pre.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
        this.desconectar();
        }
     }  
     
     public void modificarEmpleado(Empleado em) throws Exception{
     try {
            this.conectar();
            String sql="update empleado set nombre=?,genero=?,intereses=?,edad=?,direccion=?,cargo=?,codigoDeparatento=? where codigoEmpleado=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, em.getNombre());
            pre.setString(2, em.getGenero());
            pre.setArray(3, em.getIntereses());
            pre.setInt(4, em.getEdad());
            pre.setString(5, em.getDireccion());
            pre.setString(6, em.getCargo());
            pre.setInt(7, em.getCodigoDepartamento());
            pre.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
        this.desconectar();
        }
     }
        
}
