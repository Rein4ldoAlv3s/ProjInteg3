/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import multa.dao.MultaDao;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import multa.model.Multa;

/**
 *
 * @author naldo
 */
public class ViewMulta {
    public static void main(String[] args) throws ParseException {
        
        //Inserir dados
        /*
        Scanner entrada = new Scanner(System.in);
        Multa multa = new Multa();
        
        System.out.println("Informe o ID Locação");
        multa.setId_locacao(Integer.parseInt(entrada.nextLine()));
        
        System.out.println("Descricao");
        multa.setDescricao(entrada.nextLine());
        
        System.out.println("Data Autuação yyyy/mm/dd");
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        String data = entrada.nextLine();
        Date data1 = formato.parse(data);
      
        multa.setData_autuacao(data1);
    
        System.out.println("Gravidade");
        multa.setGravidade(entrada.nextLine());
        
        System.out.println("Valor");
        multa.setValor(Float.parseFloat(entrada.nextLine()));
        
        MultaDao mc = new MultaDao();
        
        mc.AddMulta(multa);
        */
        
        //Deletar Dados
    //    MultaDao md = new MultaDao();
    //    md.deleteMulta(4);
        
        //Update Multa
        /*
        MultaDao md = new MultaDao();
        Multa m = new Multa();
        m.setId_multa(3);
        m.setId_locacao(8);
        m.setDescricao("Dirigir com CNH Vencida");
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        m.setData_autuacao(formato.parse("2020/09/15"));
        m.setGravidade("gravissima");
        m.setValor(1400);
        
        md.updateMulta(m);
        */
        
        //Imprimir todas as multas
     //   MultaDao multa = new MultaDao();
     //   List<Multa> multas = multa.getAllMultas();
   
     //   multas.forEach(System.out::println);
        
        //Imprimir multa por ID
        MultaDao multadao = new MultaDao();
        Multa multas = multadao.getMultaById(3);
        System.out.println(multas);
        
    }  
}
