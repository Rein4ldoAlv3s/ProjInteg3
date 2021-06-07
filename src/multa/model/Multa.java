/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multa.model;

import java.util.Date;

/**
 *
 * @author naldo
 */
public class Multa {
    private int id_multa;
    private int id_locacao;
    private String descricao;
    private Date data_autuacao;
    private String gravidade;
    private float valor;

    public int getId_multa() {
        return id_multa;
    }

    public void setId_multa(int id_multa) {
        this.id_multa = id_multa;
    }

    public int getId_locacao() {
        return id_locacao;
    }

    public void setId_locacao(int id_locacao) {
        this.id_locacao = id_locacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData_autuacao() {
        return data_autuacao;
    }

    public void setData_autuacao(Date data_autuacao) {
        this.data_autuacao = data_autuacao;
    }

    public String getGravidade() {
        return gravidade;
    }

    public void setGravidade(String gravidade) {
        this.gravidade = gravidade;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Multa{" + "id_multa=" + id_multa + ", id_locacao=" + id_locacao + ", descricao=" + descricao + ", data_autuacao=" + data_autuacao + ", gravidade=" + gravidade + ", valor=" + valor + '}';
    }
    
    
}
