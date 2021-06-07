/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.model;

/**
 *
 * @author naldo
 */
public class Cliente {
    private int id_cliente;
    private String nome;
    private String tipo_cliente;
    private String cpf_cnpj;    
    private String registro_geral;    
    private String razao_social;    
    private String email;    
    private String cep;    
    private String logradouro;    
    private int numero_res;    
    private String complemento;    
    private String bairro;    
    private String cidade;    
    private String pais;   
    private String numero_telefone;    
    private String tipo_telefone;  

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo_cliente() {
        return tipo_cliente;
    }

    public void setTipo_cliente(String tipo_cliente) {
        this.tipo_cliente = tipo_cliente;
    }

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public String getRegistro_geral() {
        return registro_geral;
    }

    public void setRegistro_geral(String registro_geral) {
        this.registro_geral = registro_geral;
    }

    public String getRazao_social() {
        return razao_social;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero_res() {
        return numero_res;
    }

    public void setNumero_res(int numero_res) {
        this.numero_res = numero_res;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getNumero_telefone() {
        return numero_telefone;
    }

    public void setNumero_telefone(String numero_telefone) {
        this.numero_telefone = numero_telefone;
    }

    public String getTipo_telefone() {
        return tipo_telefone;
    }

    public void setTipo_telefone(String tipo_telefone) {
        this.tipo_telefone = tipo_telefone;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id_cliente=" + id_cliente + ", nome=" + nome + ", tipo_cliente=" + tipo_cliente + ", cpf_cnpj=" + cpf_cnpj + ", registro_geral=" + registro_geral + ", razao_social=" + razao_social + ", email=" + email + ", cep=" + cep + ", logradouro=" + logradouro + ", numero_res=" + numero_res + ", complemento=" + complemento + ", bairro=" + bairro + ", cidade=" + cidade + ", pais=" + pais + ", numero_telefone=" + numero_telefone + ", tipo_telefone=" + tipo_telefone + '}';
    }
    
    
    
}
