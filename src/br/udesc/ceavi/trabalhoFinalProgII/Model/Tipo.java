/**
 * Classe responsavel por ser a representacao de um tipo,
 * no qual é responsavel por apresentar caracteristicas comuns sobre o tipo,
 * tal que cada Item devera possuir um Tipo.
 * 
 * mapeada por Giancarlo Pandini
 *
 * @author Giancarlo
 * @version 1.0
 * @since 18/08/2018
 */
package br.udesc.ceavi.trabalhoFinalProgII.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo")
public class Tipo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="id_codigo")
    private long codigo;
   
    @Column(name = "nome")
    private String nome;
   
    @Column(name = "descricao")
    private String Descricao;
    
    @Column (name = "categoria")
    private Categoria categoria; //enum

    public Tipo() {
        super();
        this.codigo = 0;
        this.nome = "";
        this.Descricao = "";
        }

    public Tipo(long codigo, String nome, String CaracteristicasComuns, Categoria categoria) {
        super();
        this.codigo = codigo;
        this.nome = nome;
        this.Descricao = CaracteristicasComuns;
        this.categoria = categoria;
    }
    

    @Override
    public String toString() {
        return "Tipo : \n" + "codigo=" + codigo + "\n nome=" + nome + "\n CaracteristicasComuns=" + Descricao + "\n categoria=" + categoria;
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

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

}
