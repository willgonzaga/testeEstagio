/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Willey
 */
public class Venda {
    private int id;
    private int idcliente;
    private double totalvenda;
    private Date datavenda;
    private String formapagamento;

    public Venda(Date datavenda, int id, String formapagamento) {
        this.datavenda = datavenda;
        this.id = id;
        this.formapagamento = formapagamento;
    }
    
    public Venda(int idcliente, Date datavenda, String formapagamento) {
        this.idcliente = idcliente;
        this.datavenda = datavenda;
        this.formapagamento = formapagamento;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public double getTotalvenda() {
        return totalvenda;
    }

    public void setTotalvenda(double totalvenda) {
        this.totalvenda = totalvenda;
    }

    public Date getDatavenda() {
        return datavenda;
    }

    public void setDatavenda(Date datavenda) {
        this.datavenda = datavenda;
    }

    public String getFormapagamento() {
        return formapagamento;
    }

    public void setFormapagamento(String formapagamento) {
        this.formapagamento = formapagamento;
    }
    
    
}
