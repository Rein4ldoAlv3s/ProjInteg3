/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import motorista.dao.MotoristaDao;
import motorista.dao.MotoristaDaoAdd;
import motorista.model.Categoria_CNH;
import motorista.model.Email;
import motorista.model.Endereco;
import motorista.model.Motorista_Locacao;

/**
 *
 * @author naldo
 */
public class ViewMotorista {
    public static void main(String[] args) throws ParseException {
        Scanner entrada = new Scanner(System.in);
        Email email = new Email();
        Categoria_CNH cat = new Categoria_CNH();
        Endereco end = new Endereco();
        MotoristaDao motDAO = new MotoristaDao();
        Motorista_Locacao motLoc = new Motorista_Locacao();
        
        System.out.println("Informe o email:");
        email.setEmail(entrada.nextLine());
        System.out.println("Categoria CNH:");
        cat.setCategoria_CNH(entrada.nextLine());
        System.out.println("Numero Residencial");
        end.setNumero(Integer.parseInt(entrada.nextLine()));
        System.out.println("Logradouro");
        end.setLogradouro(entrada.nextLine());
        System.out.println("Pais");
        end.setPais(entrada.nextLine());
        System.out.println("Bairro");
        end.setBairro(entrada.nextLine());
        System.out.println("CEP");
        end.setCep(entrada.nextLine());
        System.out.println("Complemento");
        end.setComplemento(entrada.nextLine());
        System.out.println("Cidade");
        end.setCidade(entrada.nextLine());
        System.out.println("Estado");
        end.setEstado(entrada.nextLine());
        
        MotoristaDaoAdd md = new MotoristaDaoAdd();
        md.AddEmail(email);
        md.AddCategoriaCNH(cat);
        md.AddEndereco(end);
        md.getFKTabelas(email, cat, end, motLoc);
       
        /*
        System.out.println("Telefone");
        motLoc.setTelefone(entrada.nextLine());
        System.out.println("CPF");
        motLoc.setCpf(entrada.nextLine());
        System.out.println("Nome");
        motLoc.setNome(entrada.nextLine());
        System.out.println("Registro Geral");
        motLoc.setRegistroGeral(entrada.nextLine());
        //Formatar data e settar o atributo
        System.out.println("Data de nascimento");
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        motLoc.setDataNascimento(formato.parse(entrada.nextLine()));
        //
        System.out.println("Registro CNH");
        motLoc.setRegistroCnh(entrada.nextLine());
        System.out.println("Data de Validade");
        motLoc.setDataValidade(formato.parse(entrada.nextLine()));
        System.out.println("Foto URL");
        motLoc.setFotoUrl(entrada.nextLine());
        System.out.println("Data Retirada");
        motLoc.setData_retirada(formato.parse(entrada.nextLine()));
        System.out.println("Data Devolução");
        motLoc.setData_devolucao(formato.parse(entrada.nextLine()));
        System.out.println("Valor Seguro");
        motLoc.setValorSeguro(Float.parseFloat(entrada.nextLine()));
        System.out.println("Valor Calção");
        motLoc.setValorCalcao(Float.parseFloat(entrada.nextLine()));
        System.out.println("Valor Final");
        motLoc.setValorFinal(Float.parseFloat(entrada.nextLine()));
        System.out.println("Status");
        motLoc.setStatus(entrada.nextLine());
        System.out.println("FK Email");
        motLoc.setFkEmail(Integer.parseInt(entrada.nextLine()));
        System.out.println("FK Categoria");
        motLoc.setFkCategoria(Integer.parseInt(entrada.nextLine()));
        System.out.println("FK Endereco");
        motLoc.setFkEndereco(Integer.parseInt(entrada.nextLine()));
        
        
        
    //    md.AddEmail(email);
    //    md.AddCategoriaCNH(cat);
    //    md.AddEndereco(end);
        
        md.AddMotoristaLocacao(motLoc);
        */
    }
}
