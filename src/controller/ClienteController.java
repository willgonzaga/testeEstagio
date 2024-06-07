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
import model.Cliente;

/**
 *
 * @author Willey
 */
public class ClienteController {
    
    private String sql;
    private ConexaoDB connection;
    private PreparedStatement stmt;
    private Cliente clienteSelecionado;
    
    public void cadastrarCliente(String nome, String cpf, String endereco, String telefone, String email) {
        
        Cliente cliente = new Cliente(nome,cpf,endereco,telefone,email);
        try {
            connection = new ConexaoDB();
            sql = "insert into clientes(nome, cpf, endereco, telefone, email) values(?,?,?,?,?)";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getEndereco());
            stmt.setString(4, cliente.getTelefone());
            stmt.setString(5, cliente.getEmail());
            stmt.executeUpdate();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void clienteSelect(int id, String nome, String cpf, String endereco, String telefone, String email) {
        clienteSelecionado = new Cliente(id, nome, cpf, endereco, telefone, email);
    }
    
    public void clienteSelect() {
        clienteSelecionado = null;
    }
    
    public Cliente infoClienteSelect() {
        return clienteSelecionado;
    }
    
    public void editarCliente(String nome, String cpf, String endereco, String telefone, String email) throws Exception {
        if(clienteSelecionado == null) {
            throw new Exception("Selecione um cliente para editar!");
        }
        if(nome.trim().isEmpty()) {
            throw new NomeVazioException();
        }
       
        cpf = (cpf.trim().isEmpty()) ? null : cpf;
        endereco = (endereco.trim().isEmpty()) ? null : endereco;
        telefone = (telefone.trim().isEmpty()) ? null : telefone;
        email = (email.trim().isEmpty()) ? null : email;
        
        try {
            connection = new ConexaoDB();
            sql = "update clientes set nome = ?, cpf = ?, endereco = ?, telefone = ?, email = ? where id = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, cpf);
            stmt.setString(3, endereco);
            stmt.setString(4, telefone);
            stmt.setString(5, email);
            stmt.setInt(6, clienteSelecionado.getId());
            stmt.executeUpdate();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void excluirCliente() throws Exception {
        if(clienteSelecionado == null) {
            throw new Exception("Selecione um cliente para excluir!");
        }
        try {
            connection = new ConexaoDB();
            sql = "delete from clientes where id = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, clienteSelecionado.getId());
            stmt.executeUpdate();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
