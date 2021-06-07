/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package motorista.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import util.Conexao2;

/**
 *
 * @author naldo
 */
public class MotoristaDaoDelete {
    private Connection conexao;
    
    public MotoristaDaoDelete(){
        
        conexao = Conexao2.getConexao();

    }
    
    public void DeleteEmail(int email_PK){  
        
        String sql = "delete from email where email_pk=?";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            
            preparedStatement.setInt(1, email_PK);
                        
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void DeleteCategoriaCNH(int categoria_CNH_PK){  
        
        String sql = "delete from categoria_cnh where categoria_cnh_PK=?";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            
            preparedStatement.setInt(1, categoria_CNH_PK);
                        
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void DeleteEndereco(int endereco_PK){  
        
        String sql = "delete from endereco where endereco_pk=?";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            
            preparedStatement.setInt(1, endereco_PK);
                        
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void DeleteMotoristaLocacao(int endereco_PK){  
        
        String sql = "delete from motorista_locacao where id_motorista=?";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            
            preparedStatement.setInt(1, endereco_PK);
                        
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
