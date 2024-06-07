/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Willey
 */
public class VendaItem {
    private int idItem;
    private int idVenda;
    private int idProduto;
    private int qtde;

    public VendaItem(int idVenda, int idProduto, int qtde) {
        this.idVenda = idVenda;
        this.idProduto = idProduto;
        this.qtde = qtde;
    }

    public VendaItem(int idItem, int idVenda, int idProduto, int qtde) {
        this.idItem = idItem;
        this.idVenda = idVenda;
        this.idProduto = idProduto;
        this.qtde = qtde;
    }

    public VendaItem(int idItem, int qtde) {
        this.idItem = idItem;
        this.qtde = qtde;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    
    
    
}
