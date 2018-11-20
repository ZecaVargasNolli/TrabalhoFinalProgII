package br.udesc.ceavi.trabalhoFinalProgII.Model;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * Classe item que representa os dados de todos os itens no sistema.
 *
 * mapeado por Giancarlo Pandini
 *
 * @author José Vargas Nolli
 * @version 2.0
 * @since 27/10/2018
 */
@Entity
@Table(name = "item")
@NamedQueries({
    @NamedQuery(name = "buscarItem", query = "SELECT i FROM Item i")
    ,
    @NamedQuery(name = "buscarItemPorTipo", query = "SELECT i FROM Item i WHERE i.tipo = :tipo")
    ,
    @NamedQuery(name = "buscarItemPorNome", query = "SELECT i FROM Item i WHERE i.nome = :nome")
    , 
    @NamedQuery(name = "buscarItemPorFornecedor" , query = "SELECT i FROM Item i WHERE i.fornecedor = :fornecedor")
})
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_item")
    private long codigo;

    @ManyToOne(cascade = CascadeType.ALL)
    private Tipo tipo;

    @Column(name = "dataAquisicao")
    private String DatadeAquisicao;

    @Column(name = "emEstoque")
    private boolean emEstoque;

    @Column(name = "nome")
    private String nome;

    @ManyToOne(cascade = CascadeType.ALL)
    private Fornecedor fornecedor;

    public Item( String DatadeAquisicao, String nome) {
        super();
      //  this.tipo = tipo;
        this.DatadeAquisicao = DatadeAquisicao;
        this.codigo = 0;
        this.nome = nome;
       // this.fornecedor = fornecedor;
        this.emEstoque = true;
    }

    public Item() {
        super();
        this.codigo = 0;
        this.DatadeAquisicao = "";
        this.nome = "";
        this.emEstoque = true;
    }

    @Override
    public String toString() {
        return "Item{" + "tipo=" + tipo + ", DatadeAquisicao=" + DatadeAquisicao + ", codigo=" + codigo + ", nome=" + nome + ", fornecedor=" + fornecedor + '}';
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getDatadeAquisicao() {
        return DatadeAquisicao;
    }

    public void setDatadeAquisicao(String DatadeAquisicao) {
        this.DatadeAquisicao = DatadeAquisicao;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public boolean isEmEstoque() {
        return emEstoque;
    }

    public void setEmEstoque(boolean emEstoque) {
        this.emEstoque = emEstoque;
    }

}
