package otica;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Rico Azeredo
 */
public class ConexaoBanco {
    public Statement Stm; //Inclusão, alteração, exclusão do BD
    public ResultSet Rs; //Retorna uma Pesquisa.
    
     // Elementos obrigatórios para o BD
      
    private String Driver = "org.postgresql.Driver"; // controlador Postgreslq
    private String Caminho = "jdbc:postgresql://localhost:5432/otica"; // O caminho//porta/ nome do arquivo
    private String Usuario = "postgres"; // Superusuário Postgres
    private String Senha = "07031981";
    
    public Connection Conn;
    
    public void conexao(){
        try{
            System.setProperty("jdbc.Drivers", Driver); // indica qual driver está utilizando: postgresql
            Conn = DriverManager.getConnection(Caminho,Usuario,Senha);
            JOptionPane.showMessageDialog(null,"Conectado");
        }catch(SQLException ex){
            Logger.getLogger(ConexaoBanco.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    public void executaSQL(String sql){
        try {
            Stm = Conn.createStatement(Rs.TYPE_SCROLL_INSENSITIVE,Rs.CONCUR_READ_ONLY);
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void desconecta(){
        try {
            Conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
