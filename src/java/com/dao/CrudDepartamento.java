/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;

import com.conexion.Conexion;

/**
 * Nombre de la clase:CrudDepartamento
 * Versión:1.0 
 * Fecha:2/10/2017 
 * Copyright:ITCA-FEPADE
 * @author Karen Escobar
 */
public class CrudDepartamento extends Conexion{
    public void registrarDepartamento() throws Exception{
        try {
            this.conectar();
            String sql="insert into(nombre, cantidadEmpleado) values(?,?)";
        } catch (Exception e) {
            throw e;
        }finally{
        this.desconectar();
        }
    }
}
