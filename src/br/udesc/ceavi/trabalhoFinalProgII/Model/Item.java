package br.udesc.ceavi.trabalhoFinalProgII.Model;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
public class Item {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="id_item")
    private long codigo;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Tipo tipo;
    
    @Column(name = "dataAquisicao")
    private String DatadeAquisicao; //era um tipo Date, alterei para string para facl utilizacao @Giancarlo Pandini
    
    @Column(name = "nome")
    private String nome;
    
    @ManyToOne (cascade = CascadeType.ALL)
    private Fornecedor fornecedor;

    public Item(Tipo tipo, String DatadeAquisicao, long codigo, String nome, Fornecedor fornecedor) {
        super();
        this.tipo = tipo;
        this.DatadeAquisicao = DatadeAquisicao;
        this.codigo = codigo;
        this.nome = nome;
        this.fornecedor = fornecedor;
    }

    public Item() {
        super();
        this.codigo = 0;
        this.DatadeAquisicao = "";
        this.nome = "";
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

}
