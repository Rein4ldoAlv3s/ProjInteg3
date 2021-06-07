    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import multa.model.Multa;
import util.Conexao;

/**
 *
 * @author naldo
 */
public class MultaDao {
    private Connection conexao;
    
    public MultaDao(){
        
        conexao = Conexao.getConexao();

    }
    
    public void AddMulta(Multa multa){
        
        String sql = "insert into multa(id_locacao, descricao, data_autuacao, gravidade, valor) values(?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            
            preparedStatement.setInt(1, multa.getId_locacao());
            preparedStatement.setString(2, multa.getDescricao());
            preparedStatement.setDate(3, new java.sql.Date(multa.getData_autuacao().getTime()));
            preparedStatement.setString(4, multa.getGravidade());
            preparedStatement.setFloat(5, multa.getValor());
                        
            preparedStatement.executeUpdate();
               
        } catch (SQLException e) {  
            e.printStackTrace();
        }
        
    }
    
    public void deleteMulta(int id_multa) {
        try {
                PreparedStatement preparedStatement = conexao
                                .prepareStatement("delete from multa where id_multa=?");
                // Parameters start with 1
                preparedStatement.setInt(1, id_multa);
                preparedStatement.executeUpdate();

        } catch (SQLException e) {
                e.printStackTrace();
        }
    }
    
    public void updateMulta(Multa multa) {
        try {
                PreparedStatement preparedStatement = conexao
                                    .prepareStatement("update multa set id_locacao=?, descricao=?, data_autuacao=?, gravidade=?, valor=?" +
                                                "where id_multa=?");
                // Parameters start with 1
                preparedStatement.setInt(1, multa.getId_locacao());
                preparedStatement.setString(2, multa.getDescricao());
                preparedStatement.setDate(3, new java.sql.Date(multa.getData_autuacao().getTime()));
                preparedStatement.setString(4, multa.getGravidade());
                preparedStatement.setFloat(5, multa.getValor());
                preparedStatement.setInt(6, multa.getId_multa());

                preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Multa> getAllMultas() {
            List<Multa> multas = new ArrayList<Multa>();
            try {
                    Statement statement = conexao.createStatement();
                    ResultSet rs = statement.executeQuery("select * from multa");
                    while (rs.next()) {
                            Multa multa = new Multa();
                            multa.setId_multa(rs.getInt("id_multa"));
                            multa.setId_locacao(rs.getInt("id_locacao"));
                            multa.setDescricao(rs.getString("descricao"));
                            multa.setData_autuacao(rs.getDate("data_autuacao"));
                            multa.setGravidade(rs.getString("gravidade"));
                            multa.setValor(rs.getFloat("valor"));
                            multas.add(multa);
                    }
            } catch (SQLException e) {
                    e.printStackTrace();
            }
            
            return multas;
    }
    
    public Multa getMultaById(int id_multa) {
        Multa multa = new Multa();
        try {
                PreparedStatement preparedStatement = conexao.
                                prepareStatement("select * from multa where id_multa=?");
                preparedStatement.setInt(1, id_multa);

                ResultSet rs = preparedStatement.executeQuery();

                if (rs.next()) {
                    multa.setId_multa(rs.getInt("id_multa"));
                    multa.setId_locacao(rs.getInt("id_locacao"));
                    multa.setDescricao(rs.getString("descricao"));
                    multa.setData_autuacao(rs.getDate("data_autuacao"));
                    multa.setGravidade(rs.getString("gravidade"));
                    multa.setValor(rs.getFloat("valor"));
                }
        } catch (SQLException e) {
                e.printStackTrace();
        }

        return multa;
    }
        
}
