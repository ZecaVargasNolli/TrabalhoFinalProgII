package br.udesc.ceavi.trabalhoFinalProgII.Model;

import java.io.Serializable;

/**
 * Classe Endereco responsável pela representação dos dados de endereço
 * referente a fornecedor,possuindo a classe Cidade como um de seus atributos.
 *
 * @author José Vargas Nolli
 * @version 1.0
 * @since 18/08/2018
 */
public class Endereco {

    private int numero;
    private String bairro;
    private String complemento;
    private String cep;
    private Cidade cidade;

    public Endereco() {
        super();
        this.numero = numero;
        this.bairro = bairro;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;
    
    }

    
    public Endereco(int numero, String bairro, String complemento, String cep, Cidade cidade) {
        super();
        this.numero = numero;
        this.bairro = bairro;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "Endereco:" + "\n Número: " + numero
                + "\n Bairro: " + bairro + "\n Complemento: " + complemento
                + "\n CEP: " + cep + "\n" + cidade.toString();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

}
