/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import cliente.dao.ClienteDao;
import cliente.dao.ClienteDaoAdd;
import cliente.dao.ClienteDaoDelete;
import java.util.Arrays;
import java.util.Scanner;
import cliente.model.Cliente;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import util.Conexao;
/**
 *
 * @author naldo
 */
public class ViewCliente {
    public static void main(String[] args) {
        
        
        Scanner entrada = new Scanner(System.in);
        
        Cliente cliente = new Cliente();
        
        
        //CADASTRAR CLIENTE
        System.out.println("******CADASTRAR CLIENTE******");
        
        System.out.println("Informe o ID cliente: ");
        cliente.setId_cliente(Integer.parseInt(entrada.nextLine()));
        
        System.out.println("Informe o nome do cliente:");
        cliente.setNome(entrada.nextLine());
        
        System.out.println("Tipo de cliente:");
        cliente.setTipo_cliente(entrada.nextLine());
        
        System.out.println("CPF ou CNPJ:");
        cliente.setCpf_cnpj(entrada.nextLine());
        
        System.out.println("Registro Geral:");
        cliente.setRegistro_geral(entrada.nextLine());
        
        System.out.println("Razão Social:");
        cliente.setRazao_social(entrada.nextLine());
        
        System.out.println("Email:");
        cliente.setEmail(entrada.nextLine());
        
        System.out.println("cep:");
        cliente.setCep(entrada.nextLine());
        
        System.out.println("logradouro:");
        cliente.setLogradouro(entrada.nextLine());
        
        System.out.println("Numero Residencia:");
        cliente.setNumero_res(Integer.parseInt(entrada.nextLine()));
        
        System.out.println("Complemento:");
        cliente.setComplemento(entrada.nextLine());
        
        System.out.println("Bairro:");
        cliente.setBairro(entrada.nextLine());
        
        System.out.println("Cidade:");
        cliente.setCidade(entrada.nextLine());
        
        System.out.println("País:");
        cliente.setPais(entrada.nextLine());
        
        System.out.println("Numero telefone:");
        cliente.setNumero_telefone(entrada.nextLine());
        
        System.out.println("Tipo telefone:");
        cliente.setTipo_telefone(entrada.nextLine());
        
        
        //Adicionar Cliente
        /*
        ClienteDaoAdd cAdd = new ClienteDaoAdd();
        cAdd.AddCliente(cliente);
        cAdd.getIDTableCliente(cliente);
        cAdd.AddClientePessoaFisica(cliente);
        cAdd.AddClientePessoaJuridica(cliente);
        cAdd.AddEmailCliente(cliente);
        cAdd.AddEnderecoCliente(cliente);
        cAdd.AddTelefoneCLiente(cliente);
        */
        
        //DELETAR CLIENTE
        /*
        ClienteControllerDelete cDel = new ClienteControllerDelete();
        cDel.DeleteClientePessoaFis(7);
        cDel.DeleteClientePessoaJur(7);
        cDel.DeleteEmailCliente(7);
        cDel.DeleteEnderecoCliente(7);
        cDel.DeleteTelefoneCliente(7);
        cDel.DeleteCliente(7);
        */
        
        //Update valores
        /*
        ClienteDao cc = new ClienteDao();
        cc.updateCliente(cliente);
        cc.updateClientePessoaFis(cliente);
        cc.updateClientePessoaJur(cliente);
        cc.updateEmailCliente(cliente);
        cc.updateEnderecoCliente(cliente);
        cc.updateTelefoneCliente(cliente);
        */
        
        //Mostrar cadastro a partir de id
      /*  ClienteController cc = new ClienteController();
        cc.getClienteById(9);
        System.out.println("ID Cliente: " + cc.getClienteById(9).getId_cliente());
        System.out.println("Nome: " + cc.getClienteById(9).getNome());
        System.out.println("Tipo Cliente: " + cc.getClienteById(9).getTipo_cliente());
        System.out.println("CPF ou CNPJ: " + cc.getClienteById(9).getCpf_cnpj());
        System.out.println("Registro Geral: " + cc.getClienteById(9).getRegistro_geral());
        System.out.println("Razão Social: " + cc.getClienteById(9).getRazao_social());
        System.out.println("Email: " + cc.getClienteById(9).getEmail());
        System.out.println("CEP: " + cc.getClienteById(9).getCep());
        System.out.println("Logradouro: " + cc.getClienteById(9).getLogradouro());
        System.out.println("Número Residencia: " + cc.getClienteById(9).getNumero_res());
        System.out.println("Complemento: " + cc.getClienteById(9).getComplemento());
        System.out.println("Bairro: " + cc.getClienteById(9).getBairro());
        System.out.println("Cidade: " + cc.getClienteById(9).getCidade());
        System.out.println("Pais: " + cc.getClienteById(9).getPais());
        System.out.println("Numero Telefone: " + cc.getClienteById(9).getNumero_telefone());
        System.out.println("Tipo Telefone: " + cc.getClienteById(9).getTipo_telefone());
        */
        
      
        //Mostrar Cliente por um ID
     /*   ClienteDao cd = new ClienteDao();
        
        Cliente c = cd.getClienteById(8);
        
        System.out.println("ID CLiente: " + c.getId_cliente());
        System.out.println("Nome: " + c.getNome());
        System.out.println("Tipo Cliente: " + c.getTipo_cliente());
        System.out.println("CPF/CNPJ: " + c.getCpf_cnpj());
        System.out.println("Regsitro Geral: " + c.getRegistro_geral());
        System.out.println("Razao social: " + c.getRazao_social());
        System.out.println("Email: " + c.getEmail());
        System.out.println("cep: " + c.getCep());
        System.out.println("logradouro: " + c.getLogradouro());
        System.out.println("Numero Res: " + c.getNumero_res());
        System.out.println("Complemento: " + c.getComplemento());
        System.out.println("Bairro: " + c.getBairro());
        System.out.println("Cidade: " + c.getCidade());
        System.out.println("Pais: " + c.getPais());
        System.out.println("Nmero Telefone: " + c.getNumero_telefone());
        System.out.println("Tipo Telefone: " + c.getTipo_telefone());
        */
        
        //Mostrar Todos os clientes
     /*
        ClienteDao cd = new ClienteDao();
        List<Cliente> clientes = cd.getAllClientes();
   
        clientes.forEach(System.out::println);
       */
    
    
    }
    
}
