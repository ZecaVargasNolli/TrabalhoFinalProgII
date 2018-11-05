/**
 * Classe responsavel por ser a representacao de um tipo,
 * no qual é responsavel por apresentar caracteristicas comuns sobre o tipo,
 * tal que cada Item devera possuir um Tipo.
 *
 * @author Giancarlo
 * @version 1.0
 * @since 18/08/2018
 */
package br.udesc.ceavi.trabalhoFinalProgII.Model;

public class Tipo {

    private long codigo;
    private String nome;
    private String Descricao;
    private Categoria categoria;

    public Tipo() {
        super();
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
