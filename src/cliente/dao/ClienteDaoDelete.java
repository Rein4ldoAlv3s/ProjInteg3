/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.dao;

import java.sql.Connection;
import util.Conexao;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author naldo
 */
public class ClienteDaoDelete {
    private Connection conexao;
    
    public ClienteDaoDelete(){
        
        conexao = Conexao.getConexao();

    }
    public void DeleteClientePessoaFis(int id_cliente){  
        
        String sql = "delete from clientepessoafisica where id_cliente=?";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            
            preparedStatement.setInt(1, id_cliente);
                        
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void DeleteClientePessoaJur(int id_cliente){
        String sql = "delete from clientepessoajuridica where id_cliente=?";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            
            preparedStatement.setInt(1, id_cliente);
                        
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void DeleteEmailCliente(int id_cliente){
        String sql = "delete from emailcliente where id_cliente=?";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            
            preparedStatement.setInt(1, id_cliente);
                        
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void DeleteEnderecoCliente(int id_cliente){
        String sql = "delete from enderecocliente where id_cliente=?";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            
            preparedStatement.setInt(1, id_cliente);
                        
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void DeleteTelefoneCliente(int id_cliente){
        String sql = "delete from telefonecliente where id_cliente=?";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            
            preparedStatement.setInt(1, id_cliente);
                        
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void DeleteCliente(int id_cliente){
        String sql = "delete from cliente where id_cliente=?";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            
            preparedStatement.setInt(1, id_cliente);
                        
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
