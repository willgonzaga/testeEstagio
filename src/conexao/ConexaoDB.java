/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Willey
 */
public class ConexaoDB {
    
    private String url = "jdbc:postgresql://localhost:5432/testeEstagio";
    private String user = "postgres";
    private String password = "XLIVE281";
    private Connection connection;
    
    public ConexaoDB() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
            
            System.out.println("Conexão com banco de dados estabelecida com sucesso!");
        } catch (ClassNotFoundException  | SQLException e) {
            e.printStackTrace();
        }
    }
    
    public int executaSQL(String sql) {
        try {
            Statement stm = connection.createStatement();
            int res = stm.executeUpdate(sql);
            connection.close();
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public PreparedStatement prepareStatement(String sql) throws SQLException {
        return connection.prepareStatement(sql);
    }
}
