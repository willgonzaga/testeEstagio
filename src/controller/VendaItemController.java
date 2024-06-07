/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import conexao.ConexaoDB;
import java.sql.PreparedStatement;
import model.VendaItem;

/**
 *
 * @author Willey
 */
public class VendaItemController {
    private VendaItem itemSelecionado;
    private ConexaoDB connection;
    private String sql;
    private PreparedStatement stmt;
    
    public void salvarItemVenda(int idVenda, int idProduto, int qtde) {
        VendaItem vendaItem = new VendaItem(idVenda, idProduto, qtde);
        try {
            connection = new ConexaoDB();
            sql = "insert into vendas_item("
                    + "idvenda, "
                    + "idproduto, "
                    + "qtde"
                    + ") "
                    + "values (?,?,?)";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idVenda);
            stmt.setInt(2, idProduto);
            stmt.setInt(3, qtde);
            stmt.executeUpdate();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void editarItemVenda(int idItem, int idVenda, int idProduto, int qtde) {
        try {
            connection = new ConexaoDB();
            sql = "update vendas_item "
                    + "set "
                    + "idProduto = ?, "
                    + "qtde = ? "
                    + "where iditem = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idProduto);
            stmt.setInt(2, qtde);
            stmt.setInt(3, idItem);
            stmt.executeUpdate();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void excluirItemVenda() {
        try {
            connection = new ConexaoDB();
            sql = "delete from vendas_item where iditem = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, itemSelecionado.getIdItem());
            stmt.executeUpdate();
            stmt.close();
        } catch(NullPointerException e) {
            throw new NullPointerException();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void itemSelect(int idItem, int qtde) {
        itemSelecionado = new VendaItem(idItem, qtde);
    }
    
    public void itemSelect() {
        itemSelecionado = null;
    }
    
    public VendaItem infoItemSelect() {
        return itemSelecionado;
    }
}
