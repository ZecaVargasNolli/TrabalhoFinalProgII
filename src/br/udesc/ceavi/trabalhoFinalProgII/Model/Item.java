
package br.udesc.ceavi.trabalhoFinalProgII.Model;

import java.util.Date;

/**
 *
 * Classe item que representa os dados de todos os itens no sistema.
 * 
 * @author José Vargas Nolli
 * @version 2.0
 * @since 27/10/2018
 */
public class Item {
    
    private Tipo tipo;
    private Date DatadeAquisicao;
    private long codigo;
    private String nome;
    private Fornecedor fornecedor;

    public Item(Tipo tipo, Date DatadeAquisicao, long codigo, String nome, Fornecedor fornecedor) {
        this.tipo = tipo;
        this.DatadeAquisicao = DatadeAquisicao;
        this.codigo = codigo;
        this.nome = nome;
        this.fornecedor = fornecedor;
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

    public Date getDatadeAquisicao() {
        return DatadeAquisicao;
    }

    public void setDatadeAquisicao(Date DatadeAquisicao) {
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
