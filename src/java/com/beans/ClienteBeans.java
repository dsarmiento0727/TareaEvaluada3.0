/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.beans;

import com.dao.CrudCliente;
import com.modelo.Cliente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author hp
 */
@ManagedBean
@ViewScoped

//Agregar el implemets SERIALIZABLE
public class ClienteBeans implements Serializable{
   
    private Cliente cli = new Cliente();
    private Cliente selCli = new Cliente();
    private List<Cliente> lista = new ArrayList<>();
    private CrudCliente cc = new CrudCliente();

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }

    public Cliente getSelCli() {
        return selCli;
    }

    public void setSelCli(Cliente selCli) {
        this.selCli = selCli;
    }

    public List<Cliente> getLista() {
        return lista;
    }

    public void setLista(List<Cliente> lista) {
        this.lista = lista;
    }

    public CrudCliente getCc() {
        return cc;
    }

    public void setCc(CrudCliente cc) {
        this.cc = cc;
    }

 
    
    public void select()
    {
        cli = selCli;
    }
    public void insertar() throws Exception {
        try {
            cc.registrarCliente(cli);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Gestionar", "Cliente Ingresado Correctamente"));
            lista = cc.listarClientes();
            limpiar();
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.toString()));
            throw e;
        }
    }
    
    public void modificar() throws Exception
    {
        try {
            cc.modificarCliente(selCli);
            FacesContext context= FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Gestion","Cliente Modificado Correctamente"));
            lista = cc.listarClientes();
        } catch (Exception e) {
             FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.toString()));
            throw e;
        }
    }
    public void limpiar(){
     cli = new Cliente();
     }
    public ClienteBeans() throws Exception {
        lista = cc.listarClientes();
    }
    
}
