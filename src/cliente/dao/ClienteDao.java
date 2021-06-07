/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import cliente.model.Cliente;
import util.Conexao;

/**
 *
 * @author naldo
 */
public class ClienteDao {
    private Connection conexao;
    
    public ClienteDao(){
        
        conexao = Conexao.getConexao();

    }
    
    public void updateCliente(Cliente cliente) {
            try {
                    PreparedStatement preparedStatement = conexao
                                    .prepareStatement("update cliente set nome=?, tipo_cliente=?, cpf_cnpj=?" +             
                                                    "where id_cliente=?");
                    // Parameters start with 1
                    preparedStatement.setString(1, cliente.getNome());
                    preparedStatement.setString(2, cliente.getTipo_cliente());
                    preparedStatement.setString(3, cliente.getCpf_cnpj());
                    preparedStatement.setInt(4, cliente.getId_cliente());

                    preparedStatement.executeUpdate();

            } catch (SQLException e) {
                    e.printStackTrace();
            }
    }
    
    public void updateClientePessoaFis(Cliente cliente) {
        try {
                PreparedStatement preparedStatement = conexao
                                .prepareStatement("update clientepessoafisica set registro_geral=?" +             
                                                "where id_cliente=?");
                // Parameters start with 1
                preparedStatement.setString(1, cliente.getRegistro_geral());
                preparedStatement.setInt(2, cliente.getId_cliente());
                preparedStatement.executeUpdate();

        } catch (SQLException e) {
                e.printStackTrace();
        }
    }
    
    public void updateClientePessoaJur(Cliente cliente) {
        try {
                PreparedStatement preparedStatement = conexao
                                .prepareStatement("update clientepessoajuridica set razao_social=?" +             
                                                "where id_cliente=?");
                // Parameters start with 1
                preparedStatement.setString(1, cliente.getRazao_social());
                preparedStatement.setInt(2, cliente.getId_cliente());
                preparedStatement.executeUpdate();

        } catch (SQLException e) {
                e.printStackTrace();
        }
    }
    
    public void updateEmailCliente(Cliente cliente) {
        try {
                PreparedStatement preparedStatement = conexao
                                .prepareStatement("update emailcliente set email=?" +             
                                                "where id_cliente=?");
                // Parameters start with 1
                preparedStatement.setString(1, cliente.getEmail());
                preparedStatement.setInt(2, cliente.getId_cliente());
                preparedStatement.executeUpdate();

        } catch (SQLException e) {
                e.printStackTrace();
        }
    }
    
    public void updateEnderecoCliente(Cliente cliente) {
        try {
                PreparedStatement preparedStatement = conexao
                                .prepareStatement("update enderecocliente set cep=?, logradouro=?, numero_res=?, complemento=?, bairro=?, cidade=?, pais=?" +             
                                                "where id_cliente=?");
                // Parameters start with 1
                preparedStatement.setString(1, cliente.getCep());
                preparedStatement.setString(2, cliente.getLogradouro());
                preparedStatement.setInt(3, cliente.getNumero_res());
                preparedStatement.setString(4, cliente.getComplemento());
                preparedStatement.setString(5, cliente.getBairro());
                preparedStatement.setString(6, cliente.getCidade());
                preparedStatement.setString(7, cliente.getPais());
                preparedStatement.setInt(8, cliente.getId_cliente());
                preparedStatement.executeUpdate();

        } catch (SQLException e) {
                e.printStackTrace();
        }
    }
    
    public void updateTelefoneCliente(Cliente cliente) {
        try {
                PreparedStatement preparedStatement = conexao
                                .prepareStatement("update telefonecliente set numero_telefone=?, tipo_telefone=?" +             
                                                "where id_cliente=?");
                // Parameters start with 1
                preparedStatement.setString(1, cliente.getNumero_telefone());
                preparedStatement.setString(2, cliente.getTipo_telefone());
                preparedStatement.setInt(3, cliente.getId_cliente());
                preparedStatement.executeUpdate();

        } catch (SQLException e) {
                e.printStackTrace();
        }
    }
    
    public List<Cliente> getAllClientes() {
        
        List<Cliente> clientes = new ArrayList<Cliente>();
        try {
            Statement statement = conexao.createStatement();
            ResultSet rsCliente = statement.executeQuery("select * from cliente");
            statement = conexao.createStatement();
            ResultSet rsClientePF = statement.executeQuery("select * from clientepessoafisica");
            statement = conexao.createStatement();
            ResultSet rsClientePJ = statement.executeQuery("select * from clientepessoajuridica");
            statement = conexao.createStatement();
            ResultSet rsEmailCliente = statement.executeQuery("select * from emailcliente");
            statement = conexao.createStatement();
            ResultSet rsEnderCliente = statement.executeQuery("select * from enderecocliente");
            statement = conexao.createStatement();
            ResultSet rsTelCliente = statement.executeQuery("select * from telefonecliente");

            
            
            while (rsCliente.next()) {
                Cliente cliente = new Cliente();
                cliente.setId_cliente(rsCliente.getInt("id_cliente"));
                cliente.setNome(rsCliente.getString("nome"));
                cliente.setTipo_cliente(rsCliente.getString("tipo_cliente"));
                cliente.setCpf_cnpj(rsCliente.getString("cpf_cnpj"));
                
                if (rsClientePF.next()) {
                    cliente.setRegistro_geral(rsClientePF.getString("registro_geral"));
                }
                if (rsClientePJ.next()) {
                    cliente.setRazao_social(rsClientePJ.getString("razao_social"));
                }
                if (rsEmailCliente.next()) {
                    cliente.setEmail(rsEmailCliente.getString("email"));
                }
                if (rsEnderCliente.next()) {
                    cliente.setCep(rsEnderCliente.getString("cep"));
                    cliente.setLogradouro(rsEnderCliente.getString("logradouro"));
                    cliente.setNumero_res(rsEnderCliente.getInt("numero_res"));
                    cliente.setComplemento(rsEnderCliente.getString("complemento"));
                    cliente.setBairro(rsEnderCliente.getString("bairro"));
                    cliente.setCidade(rsEnderCliente.getString("cidade"));
                    cliente.setPais(rsEnderCliente.getString("pais"));
                }
                if (rsTelCliente.next()) {
                    cliente.setNumero_telefone(rsTelCliente.getString("numero_telefone"));
                    cliente.setTipo_telefone(rsTelCliente.getString("tipo_telefone"));
                }
                
                clientes.add(cliente);
            }
                
        } catch (SQLException e) {
                e.printStackTrace();
        }

        return clientes;
    }
        
    
    public Cliente getClienteById(int clienteId) {
        Cliente cliente = new Cliente();
        try {
                PreparedStatement preparedStatement = conexao.
                                prepareStatement("select * from cliente where id_cliente=?");
                preparedStatement.setInt(1, clienteId);
                ResultSet rsCliente = preparedStatement.executeQuery();
                
                preparedStatement = conexao.
                                prepareStatement("select * from clientepessoafisica where id_cliente=?");
                preparedStatement.setInt(1, clienteId);
                ResultSet rsClientePF = preparedStatement.executeQuery();
                
                preparedStatement = conexao.
                                prepareStatement("select * from clientepessoajuridica where id_cliente=?");
                preparedStatement.setInt(1, clienteId);
                ResultSet rsClientePJ = preparedStatement.executeQuery();
                
                preparedStatement = conexao.
                                prepareStatement("select * from emailcliente where id_cliente=?");
                preparedStatement.setInt(1, clienteId);
                ResultSet rsEmailCliente = preparedStatement.executeQuery();
                
                preparedStatement = conexao.
                                prepareStatement("select * from enderecocliente where id_cliente=?");
                preparedStatement.setInt(1, clienteId);
                ResultSet rsEnderCliente = preparedStatement.executeQuery();
                
                preparedStatement = conexao.
                                prepareStatement("select * from telefonecliente where id_cliente=?");
                preparedStatement.setInt(1, clienteId);
                ResultSet rsTelCliente = preparedStatement.executeQuery();
                

                while(rsCliente.next()) {
                    cliente.setId_cliente(rsCliente.getInt("id_cliente"));
                    cliente.setNome(rsCliente.getString("nome"));
                    cliente.setTipo_cliente(rsCliente.getString("tipo_cliente"));
                    cliente.setCpf_cnpj(rsCliente.getString("cpf_cnpj"));
                }
                
                while (rsClientePF.next()) {
                    cliente.setRegistro_geral(rsClientePF.getString("registro_geral"));
                }
                
                while (rsClientePJ.next()) {
                    cliente.setRazao_social(rsClientePJ.getString("razao_social"));
                }
                
                while(rsEmailCliente.next()){
                   cliente.setEmail(rsEmailCliente.getString("email")); 
                }
                
                while (rsEnderCliente.next()) {
                    cliente.setCep(rsEnderCliente.getString("cep"));
                    cliente.setLogradouro(rsEnderCliente.getString("logradouro"));
                    cliente.setNumero_res(rsEnderCliente.getInt("numero_res"));
                    cliente.setComplemento(rsEnderCliente.getString("complemento"));
                    cliente.setBairro(rsEnderCliente.getString("bairro"));
                    cliente.setCidade(rsEnderCliente.getString("cidade"));
                    cliente.setPais(rsEnderCliente.getString("pais"));
                }
                
                while (rsTelCliente.next()) {
                    cliente.setNumero_telefone(rsTelCliente.getString("numero_telefone"));
                    cliente.setTipo_telefone(rsTelCliente.getString("tipo_telefone"));
                }
                
        } catch (SQLException e) {
                e.printStackTrace();
        }

        return cliente;
    }
    
}
