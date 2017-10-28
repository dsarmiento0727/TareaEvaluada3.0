/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.conexion;
    import java.sql.*;
/**
 *Nombre de la clase:Conexion
 * Versión:1.0
 * Fecha:2/10/2017
 * Copyright:ITCA-FEPADE
 * @author Karen Escobar
 */
public class Conexion {
    private  Connection con;

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    
    public void conectar() throws Exception{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection
        ("jdbc:mysql://localhost:3306/crudjsf?user=root&password=karen22");
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void desconectar() throws Exception{
        try {
            if (con!=null) {
                if (con.isClosed()==false) {
                    con.close();
                }
            }
        } catch (Exception e) {
        }
    }
}
