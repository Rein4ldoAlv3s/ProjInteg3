/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package motorista.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import motorista.model.Categoria_CNH;
import motorista.model.Email;
import motorista.model.Endereco;
import motorista.model.Motorista_Locacao;
import util.Conexao2;

/**
 *
 * @author naldo
 */
public class MotoristaDaoAdd {
    private Connection conexao;
    
    public MotoristaDaoAdd(){
        
        conexao = Conexao2.getConexao();

    }
    
    public void AddEmail(Email email_PK, Email email){
        
        String sql = "insert into email (email_PK, email) "
                + "values(?, ?)";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            
            preparedStatement.setInt(1,email.getEmail_PK());
            preparedStatement.setString(2,email.getEmail());
                        
            preparedStatement.executeUpdate();
               
        } catch (SQLException e) {  
            e.printStackTrace();
        }
    }
    
    public void AddCategoriaCNH(Categoria_CNH catCNH){
        
        String sql = "insert into categoria_cnh (categoria_cnh) "
                + "values(?)";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            
            preparedStatement.setString(1,catCNH.getCategoria_CNH());
                        
            preparedStatement.executeUpdate();
               
        } catch (SQLException e) {  
            e.printStackTrace();
        }
        
    }
    
    public void AddEndereco(Endereco endereco){
        
        String sql = "insert into endereco (numero, logradouro, pais, bairro, cep, complemento, cidade, estado) "
                + "values(?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            
            preparedStatement.setInt(1,endereco.getNumero());
            preparedStatement.setString(2,endereco.getLogradouro());
            preparedStatement.setString(3,endereco.getPais());
            preparedStatement.setString(4,endereco.getBairro());
            preparedStatement.setString(5,endereco.getCep());
            preparedStatement.setString(6,endereco.getComplemento());
            preparedStatement.setString(7,endereco.getCidade());
            preparedStatement.setString(8,endereco.getEstado());
                        
            preparedStatement.executeUpdate();
               
        } catch (SQLException e) {  
            e.printStackTrace();
        }
        
    }
    
    
    //Pegar chaves estrangeiras das tabelas
    public void getFKTabelas(Email email, Categoria_CNH c, Endereco end, Motorista_Locacao mot){    
        try {
            PreparedStatement preparedStatement = conexao.
                            prepareStatement("select * from email where email_pk=?");
            preparedStatement.setInt(1, email.getEmail_PK());
            
            ResultSet rsEmail = preparedStatement.executeQuery();

            conexao.prepareStatement("select * from categoria_cnh where categoria_cnh_pk=?");
            preparedStatement.setInt(1, c.getCategoria_CNH_PK());
            
            ResultSet rsCategoriaCNH = preparedStatement.executeQuery();
            
            conexao.prepareStatement("select * from endereco where endereco_pk=?");
            preparedStatement.setInt(1, end.getEndereco_PK());
            
            ResultSet rsEndereco = preparedStatement.executeQuery(); 
            
            if (rsEmail.next()) {
                mot.setFkEmail(rsEmail.getInt("email_pk"));
            }
            
            if (rsCategoriaCNH.next()) {
                mot.setFkCategoria(rsCategoriaCNH.getInt("categoria_cnh_pk"));
            }        
            
            if (rsEndereco.next()) {
                mot.setFkEndereco(rsEndereco.getInt("endereco_pk"));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void AddMotoristaLocacao(Motorista_Locacao motorisLoc){
        
        String sql = "insert into motorista_locacao (telefone, cpf, nome, registro_geral, data_nascimento, registro_cnh, data_validade, "
                + "foto_url, data_retirada, data_devolucao, valor_seguro, valor_calcao, valor_final, status, FK_email, FK_categoria, FK_endereco) "
                + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            
            preparedStatement.setString(1,motorisLoc.getTelefone());
            preparedStatement.setString(2,motorisLoc.getCpf());
            preparedStatement.setString(3,motorisLoc.getNome());
            preparedStatement.setString(4,motorisLoc.getRegistroGeral());
            preparedStatement.setDate(5, new java.sql.Date(motorisLoc.getDataNascimento().getTime()));
            preparedStatement.setString(6,motorisLoc.getRegistroCnh());
            preparedStatement.setDate(7, new java.sql.Date(motorisLoc.getDataValidade().getTime()));
            preparedStatement.setString(8,motorisLoc.getFotoUrl());
            preparedStatement.setDate(9, new java.sql.Date(motorisLoc.getData_retirada().getTime()));
            preparedStatement.setDate(10, new java.sql.Date(motorisLoc.getData_devolucao().getTime()));
            preparedStatement.setFloat(11,motorisLoc.getValorSeguro());
            preparedStatement.setFloat(12,motorisLoc.getValorCalcao());
            preparedStatement.setFloat(13,motorisLoc.getValorFinal());
            preparedStatement.setString(14,motorisLoc.getStatus());
            preparedStatement.setInt(15,motorisLoc.getFkEmail());
            preparedStatement.setInt(16,motorisLoc.getFkCategoria());
            preparedStatement.setInt(17,motorisLoc.getFkEndereco());
            
            preparedStatement.executeUpdate();
               
        } catch (SQLException e) {  
            e.printStackTrace();
        }
        
    }
}
