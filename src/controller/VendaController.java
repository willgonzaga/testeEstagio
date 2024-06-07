/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import conexao.ConexaoDB;
import java.sql.PreparedStatement;
import java.util.Date;
import model.Venda;

/**
 *
 * @author Willey
 */
public class VendaController {
    private ConexaoDB connection;
    private String sql;
    private PreparedStatement stmt;
    private Venda vendaSelecionada;
    
    public void salvarVenda(int idcliente, Date datavenda, String formapagamento) {
        Venda venda = new Venda(idcliente, datavenda, formapagamento);
        try {
            java.sql.Date dataFormatada = new java.sql.Date(venda.getDatavenda().getTime());
            connection = new ConexaoDB();
            sql = "insert into vendas(idcliente,datavenda,formadepagamento) values(?,?,?)";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, venda.getIdcliente());
            stmt.setDate(2, dataFormatada);
            stmt.setString(3, venda.getFormapagamento());
            stmt.executeUpdate();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void editarVenda(int idcliente, Date dataFormatada, String formapagamento, int idvenda) {
        try {
            connection = new ConexaoDB();
            sql = "update vendas set idcliente = ?, datavenda = ?, formadepagamento = ? where id = ?";
            java.sql.Date dataFormatadaSQL = new java.sql.Date(dataFormatada.getTime());
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idcliente);
            stmt.setDate(2, dataFormatadaSQL);
            stmt.setString(3, formapagamento);
            stmt.setInt(4, idvenda);
            stmt.executeUpdate();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void excluirVenda() throws Exception {
        if(vendaSelecionada == null) {
            throw new Exception("Selecione uma venda para excluir");
        }
        try {
            connection = new ConexaoDB();
            sql = "delete from vendas where id = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, vendaSelecionada.getId());
            stmt.executeUpdate();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void vendaSelect(Date datavenda, int id, String formapagamento) {
        vendaSelecionada = new Venda(datavenda, id, formapagamento);
    }
    
    public void vendaSelect() {
        vendaSelecionada = null;
    }
}
