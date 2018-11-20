package br.udesc.ceavi.trabalhoFinalProgII.Model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Classe Endereco responsável pela representação dos dados de endereço
 * referente a fornecedor,possuindo a classe Cidade como um de seus atributos.
 * 
 * mapeado por Giancarlo Pandini
 *
 * @author José Vargas Nolli
 * @version 1.0
 * @since 18/08/2018
 */
@Entity
@Table(name = "endereco")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="id_endereco")
    private int codigo;// chave artificial
    
    @Column(name ="numero")
    private int numero;
    
    @Column(name ="bairro")
    private String bairro;
    
    @Column(name ="complemento")
    private String complemento;
    
    @Column(name ="cep")
    private String cep;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Cidade cidade;

    public Endereco() {
        super();
        this.numero = 0;
        this.bairro = "";
        this.complemento = "";
        this.cep = "";
        this.codigo = 0;
    
    }

    
    public Endereco(int numero, String bairro, String complemento, String cep) 
    {
        super();
        this.numero = numero;
        this.bairro = bairro;
        this.complemento = complemento;
        this.cep = cep;
       
        this.codigo =0;
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

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
}
