/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import conexao.ConexaoDB;
import exception.NomeVazioException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Produto;

/**
 *
 * @author Willey
 */
public class ProdutoController {
    private String sql;
    private ConexaoDB connection;
    private PreparedStatement stmt;
    private ResultSet rs;
    private Produto produtoSelecionado;
    
    public void cadastrarProduto(String nome, String descricao, String categoria, double preco) {
        
        Produto produto = new Produto(nome,descricao,categoria,preco);
        try {
            connection = new ConexaoDB();
            sql = "insert into produtos(nome, descricao, categoria, preco) values(?,?,?,?)";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setString(3, produto.getCategoria());
            stmt.setDouble(4, produto.getPreco());
            stmt.executeUpdate();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void produtoSelect(int id,String nome, String descricao, String categoria, double preco) {
        produtoSelecionado = new Produto(id,nome,descricao,categoria,preco);
    }
    
    public void produtoSelect() {
        produtoSelecionado = null;
    }
    
    public Produto infoProdutoSelect() {
        return produtoSelecionado;
    }
    
    public void editarProduto(String nome, String descricao, String categoria, double preco) throws Exception {
        if(produtoSelecionado == null) {
            throw new Exception("Selecione um produto para editar!");
        }
        descricao = (descricao.trim().isEmpty()) ? null : descricao;
        categoria = (categoria.trim().isEmpty()) ? null : categoria;
        
        try {
            connection = new ConexaoDB();
            sql = "update produtos set nome = ?, descricao = ?, categoria = ?, preco = ? where id = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, descricao);
            stmt.setString(3, categoria);
            stmt.setDouble(4, preco);
            stmt.setInt(5, produtoSelecionado.getId());
            stmt.executeUpdate();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void excluirProduto() throws Exception {
        if(produtoSelecionado == null) {
            throw new Exception("Selecione um produto para excluir!");
        }
        try {
            connection = new ConexaoDB();
            sql = "delete from produtos where id = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, produtoSelecionado.getId());
            stmt.executeUpdate();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
