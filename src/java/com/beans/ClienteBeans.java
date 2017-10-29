/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.beans;

import com.dao.CrudCliente;
import com.modelo.Cliente;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author hp
 */
@ManagedBean
@ViewScoped
public class ClienteBeans {
    private Cliente cli = new Cliente();
    private List<Cliente>listaclientes;

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }

    public List<Cliente> getListaclientes() {
        return listaclientes;
    }

    public void setListaclientes(List<Cliente> listaclientes) {
        this.listaclientes = listaclientes;
    }
    
    public void registrar() throws Exception
    {
        try {
            CrudCliente dao = new CrudCliente();
            dao.registrarCliente(cli);
            this.listarC();
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void listarC() throws Exception
    {
        try {
            CrudCliente dao = new CrudCliente();
            listaclientes = dao.listarClientes();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void leerId(Cliente cli) throws Exception
    {
        Cliente var;
        try {
            CrudCliente dao =new CrudCliente();
            var = dao.leerId(cli);
            if(var!=null)
            {
                this.cli=var;
            }
            
        } catch (Exception e) {
            throw e;
        }
    }       
    public void modificar() throws Exception
    {
        try {
            CrudCliente dao = new CrudCliente();
            dao.modificarCliente(cli);
            this.listarC();
        } catch (Exception e) {
            throw e;
        }
    }
    public void eliminar(Cliente cli) throws Exception
    {
        try {
            CrudCliente dao = new CrudCliente();
            dao.eliminarCliente(cli);
            this.listarC();
        } catch (Exception e) {
            throw e;
        }
    }
    /**
     * Creates a new instance of ClienteBeans
     */
    public ClienteBeans() {
    }
    
}
