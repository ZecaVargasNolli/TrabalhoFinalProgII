package br.udesc.ceavi.trabalhoFinalProgII.Model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Classe Fornecedor recebe os dados das empresas que são responsáveis pela
 * produção dos produtos no estoque ,essa classe possui como atributo a classe
 * Endereco,que por sua vez está associada a cidade.
 *
 * mapedo por Giancarlo Pandini
 *
 * @author José Vargas Nolli
 * @version 1.0
 * @since 18/08/2018
 */
@Entity
@Table(name = "fornecedor")
@NamedQueries({
    @NamedQuery(name ="buscarFornecedor", query = "SELECT forn FROM Fornecedor forn")
})
public class Fornecedor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="id_fornecedor")
    private int codigo; // chave artificial
   
  
    
    @Column (name = "produtosFornecidos")
    private String produtosFornecidos;
   
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;
    
    @Column (name = "cnpj")
    private String cnpj;
    
    @Column (name = "nome")
    private String nomeDaEmpresa;

    public Fornecedor(long valorDosProdutos, String produtosFornecidos,String cnpj, String nomeDaEmpresa) {
       
        this.produtosFornecidos = produtosFornecidos;
        //this.endereco = endereco;
        this.cnpj = cnpj;
        this.nomeDaEmpresa = nomeDaEmpresa;
        this.codigo = 0;
    }

    public Fornecedor() {
        super();
        this.codigo = 0;
        this.cnpj = "";
        
        this.produtosFornecidos = "";
        this.nomeDaEmpresa = "";
    }

    @Override
    public String toString() {
        return getNomeDaEmpresa();
    }

   
   

    public String getProdutosFornecidos() {
        return produtosFornecidos;
    }

    public void setProdutosFornecidos(String produtosFornecidos) {
        this.produtosFornecidos = produtosFornecidos;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeDaEmpresa() {
        return nomeDaEmpresa;
    }

    public void setNomeDaEmpresa(String nomeDaEmpresa) {
        this.nomeDaEmpresa = nomeDaEmpresa;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    
}
