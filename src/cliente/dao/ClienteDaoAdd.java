/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.dao;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import cliente.model.Cliente;

/**
 *
 * @author naldo
 */
public class ClienteDaoAdd {
    private Connection conexao;
    
    public ClienteDaoAdd(){
        
        conexao = Conexao.getConexao();

    }
    
    public void AddCliente(Cliente cliente){
        
        String sql = "insert into cliente(nome, tipo_cliente, cpf_cnpj) values(?, ?, ?)";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            
            preparedStatement.setString(1,cliente.getNome());
            preparedStatement.setString(2,cliente.getTipo_cliente());
            preparedStatement.setString(3,cliente.getCpf_cnpj());
                        
            preparedStatement.executeUpdate();
               
        } catch (SQLException e) {  
            e.printStackTrace();
        }
        
    }
        
    public void getIDTableCliente(Cliente cliente){    
        try {
            PreparedStatement preparedStatement = conexao.
                            prepareStatement("select * from cliente where cpf_cnpj=?");
            preparedStatement.setString(1, cliente.getCpf_cnpj());

            ResultSet rs = preparedStatement.executeQuery();
            
            if (rs.next()) {
                cliente.setId_cliente(rs.getInt("id_cliente"));
            }
            
                    
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void AddClientePessoaFisica(Cliente cliente){
        String sql = "insert into clientepessoafisica(id_cliente, registro_geral) values(?, ?)";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            
            preparedStatement.setInt(1,cliente.getId_cliente());
            preparedStatement.setString(2,cliente.getRegistro_geral());
                        
            preparedStatement.executeUpdate();
               
        } catch (SQLException e) {      
            e.printStackTrace();
        }
    }
    
    public void AddClientePessoaJuridica(Cliente cliente){
        String sql = "insert into clientepessoajuridica(id_cliente, razao_social) values(?, ?)";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            
            preparedStatement.setInt(1,cliente.getId_cliente());
            preparedStatement.setString(2,cliente.getRazao_social());
                        
            preparedStatement.executeUpdate();
               
        } catch (SQLException e) {  
            e.printStackTrace();
        }
     }
    
    public void AddEmailCliente(Cliente cliente){
        String sql = "insert into emailcliente(id_cliente, email) values(?, ?)";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            
            preparedStatement.setInt(1,cliente.getId_cliente());
            preparedStatement.setString(2,cliente.getEmail());
                        
            preparedStatement.executeUpdate();
               
        } catch (SQLException e) {  
            e.printStackTrace();
        }
    }        
    
    public void AddEnderecoCliente(Cliente cliente){
            String sql = "insert into enderecocliente(id_cliente, cep, logradouro, numero_res, complemento, bairro, cidade, pais) values(?, ?, ?, ?, ?, ?, ?, ?)";      
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            
            preparedStatement.setInt(1,cliente.getId_cliente());
            preparedStatement.setString(2,cliente.getCep());
            preparedStatement.setString(3,cliente.getLogradouro());
            preparedStatement.setInt(4,cliente.getNumero_res());
            preparedStatement.setString(5,cliente.getComplemento());
            preparedStatement.setString(6,cliente.getBairro());
            preparedStatement.setString(7,cliente.getCidade());
            preparedStatement.setString(8,cliente.getPais());
                        
            preparedStatement.executeUpdate();
               
        } catch (SQLException e) {  
            e.printStackTrace();
        }
    }
      
    public void AddTelefoneCLiente(Cliente cliente){
        String sql = "insert into telefonecliente(id_cliente, numero_telefone, tipo_telefone) values(?, ?, ?)";      
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            
            preparedStatement.setInt(1,cliente.getId_cliente());
            preparedStatement.setString(2,cliente.getNumero_telefone());
            preparedStatement.setString(3,cliente.getTipo_telefone());
            preparedStatement.executeUpdate();
               
        } catch (SQLException e) {  
            e.printStackTrace();
        }
    }    
}
