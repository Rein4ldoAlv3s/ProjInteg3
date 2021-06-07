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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import motorista.model.Categoria_CNH;
import motorista.model.Email;
import motorista.model.Endereco;
import motorista.model.Motorista_Locacao;
import util.Conexao2;

/**
 *
 * @author naldo
 */
public class MotoristaDao {
    private Connection conexao;
    
    public MotoristaDao(){
        
        conexao = Conexao2.getConexao();

    }
    
    public void updateEmail(Email email) {
            try {
                    PreparedStatement preparedStatement = conexao
                                    .prepareStatement("update email set email=?" +             
                                                    "where email_pk=?");
                    // Parameters start with 1
                    preparedStatement.setString(1, email.getEmail());
                    preparedStatement.setInt(2, email.getEmail_PK());

                    preparedStatement.executeUpdate();

            } catch (SQLException e) {
                    e.printStackTrace();
            }
    }
    
    public void updateCategCNH(Categoria_CNH cat) {
            try {
                    PreparedStatement preparedStatement = conexao
                                    .prepareStatement("update categoria_cnh set categoria_cnh=?" +             
                                                    "where categoria_cnh_pk=?");
                    // Parameters start with 1
                    preparedStatement.setString(1, cat.getCategoria_CNH());
                    preparedStatement.setInt(2, cat.getCategoria_CNH_PK());

                    preparedStatement.executeUpdate();

            } catch (SQLException e) {
                    e.printStackTrace();
            }
    }
    
    public void updateEndereco(Endereco end) {
            try {
                    PreparedStatement preparedStatement = conexao
                                    .prepareStatement("update endereco set numero=?, logradouro=?, pais=?, bairro=?, cep=?,"
                                            + "complemento=?, cidade=?, estado=? where endereco_pk=?");
                    // Parameters start with 1
                    preparedStatement.setInt(1, end.getNumero());
                    preparedStatement.setString(2, end.getLogradouro());
                    preparedStatement.setString(3, end.getPais());
                    preparedStatement.setString(4, end.getBairro());
                    preparedStatement.setString(5, end.getCep());
                    preparedStatement.setString(6, end.getComplemento());
                    preparedStatement.setString(7, end.getCidade());
                    preparedStatement.setString(8, end.getEstado());
                    preparedStatement.setInt(9, end.getEndereco_PK());

                    preparedStatement.executeUpdate();

            } catch (SQLException e) {
                    e.printStackTrace();
            }
    }
    
    public void updateMotoristaLocacao(Motorista_Locacao mot) {
            try {
                    PreparedStatement preparedStatement = conexao
                                    .prepareStatement("update motorista_locacao set telefone=?, cpf=?, nome=?, registro_geral=?, data_nascimento=?,"
                                            + "registro_cnh=?, data_validade=?, foto_url=?, data_retirada=?, data_devolucao=?, valor_seguro=?,"
                                            + "valor_calcao=?, valor_final=?, status=?, fk_email=?, fk_categoria=?, fk_endereco=? where id_motorista=?");
                    // Parameters start with 1
                    preparedStatement.setString(1, mot.getTelefone());
                    preparedStatement.setString(2, mot.getCpf());
                    preparedStatement.setString(3, mot.getNome());
                    preparedStatement.setString(4, mot.getRegistroGeral());
                    preparedStatement.setDate(5, new java.sql.Date(mot.getDataNascimento().getTime()));
                    preparedStatement.setString(6, mot.getRegistroCnh());
                    preparedStatement.setDate(7, new java.sql.Date(mot.getDataValidade().getTime()));
                    preparedStatement.setString(8, mot.getFotoUrl());
                    preparedStatement.setDate(9, new java.sql.Date(mot.getData_retirada().getTime()));
                    preparedStatement.setDate(10, new java.sql.Date(mot.getData_devolucao().getTime()));
                    preparedStatement.setFloat(11, mot.getValorSeguro());
                    preparedStatement.setFloat(12, mot.getValorCalcao());
                    preparedStatement.setFloat(13, mot.getValorFinal());
                    preparedStatement.setString(14, mot.getStatus());
                    preparedStatement.setInt(15, mot.getFkEmail());
                    preparedStatement.setInt(16, mot.getFkCategoria());
                    preparedStatement.setInt(17, mot.getFkEndereco());
                    preparedStatement.setInt(18, mot.getIdMotorista());

                    preparedStatement.executeUpdate();

            } catch (SQLException e) {
                    e.printStackTrace();
            }
    }
    
    public List<Email> getAllEmail() {
        List<Email> emails = new ArrayList<Email>();
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery("select * from email");

            Email email = new Email();
            
                while (rs.next()) {
                    email.setEmail_PK(rs.getInt("email_pk"));
                    email.setEmail(rs.getString("email"));

                    emails.add(email);
                }
                
        } catch (SQLException e) {
                e.printStackTrace();
        }

        return emails;
    }
    
    public List<Categoria_CNH> getAllCategoriaCNH() {
        List<Categoria_CNH> cats = new ArrayList<Categoria_CNH>();
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery("select * from categoria_cnh");

            Categoria_CNH cat = new Categoria_CNH();
            
                while (rs.next()) {
                    cat.setCategoria_CNH_PK(rs.getInt("categoria_cnh_pk"));
                    cat.setCategoria_CNH(rs.getString("categoria_cnh"));

                    cats.add(cat);
                }
                
        } catch (SQLException e) {
                e.printStackTrace();
        }

        return cats;
    }
    
    public List<Endereco> getAllEndereco() {
        List<Endereco> ends = new ArrayList<Endereco>();
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery("select * from endereco");

            Endereco end = new Endereco();
            
                while (rs.next()) {
                    end.setEndereco_PK(rs.getInt("endereco_pk"));
                    end.setNumero(rs.getInt("numero"));
                    end.setLogradouro(rs.getString("logradouro"));
                    end.setPais(rs.getString("pais"));
                    end.setBairro(rs.getString("bairro"));
                    end.setCep(rs.getString("cep"));
                    end.setComplemento(rs.getString("complemento"));
                    end.setCidade(rs.getString("cidade"));
                    end.setEstado(rs.getString("estado"));

                    ends.add(end);
                }
                
        } catch (SQLException e) {
                e.printStackTrace();
        }

        return ends;
    }
    
    public List<Motorista_Locacao> getAllMotoristaLoc() {
        List<Motorista_Locacao> mots = new ArrayList<Motorista_Locacao>();
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery("select * from motorista_locacao");

            Motorista_Locacao mot = new Motorista_Locacao();
            
                while (rs.next()) {
                    mot.setTelefone(rs.getString("telefone"));
                    mot.setCpf(rs.getString("cpf"));
                    mot.setNome(rs.getString("nome"));
                    mot.setRegistroGeral(rs.getString("registro_geral"));
                    mot.setIdMotorista(rs.getInt("id_motorista"));
                    mot.setDataNascimento(rs.getDate("data_nascimento"));
                    mot.setRegistroCnh(rs.getString("registro_cnh"));
                    mot.setDataValidade(rs.getDate("data_validade"));
                    mot.setFotoUrl(rs.getString("foto_url"));
                    mot.setIdLocacao(rs.getInt("id_locacao"));
                    mot.setData_retirada(rs.getDate("data_retirada"));
                    mot.setData_devolucao(rs.getDate("data_devolucao"));
                    mot.setValorSeguro(rs.getFloat("valor_seguro"));
                    mot.setValorCalcao(rs.getFloat("valor_calcao"));
                    mot.setValorFinal(rs.getFloat("valor_final"));
                    mot.setStatus(rs.getString("status"));
                    mot.setFkEmail(rs.getInt("fk_email"));
                    mot.setFkCategoria(rs.getInt("fk_categoria"));
                    mot.setFkEndereco(rs.getInt("fk_endereco"));

                    mots.add(mot);
                }
                
        } catch (SQLException e) {
                e.printStackTrace();
        }

        return mots;
    }
    
    
}
