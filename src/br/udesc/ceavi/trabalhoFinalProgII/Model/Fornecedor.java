package br.udesc.ceavi.trabalhoFinalProgII.Model;

/**
 * Classe Fornecedor recebe os dados das empresas que são responsáveis pela
 * produção dos produtos no estoque ,essa classe possui como atributo a classe
 * Endereco,que por sua vez está associada a cidade.
 *
 *
 * @author José Vargas Nolli
 * @version 1.0
 * @since 18/08/2018
 */
public class Fornecedor {

    private long valorDosProdutos;
    private String produtosFornecidos;
    private Endereco endereco;
    private String cnpj;
    private String nomeDaEmpresa;

    public Fornecedor(long valorDosProdutos, String produtosFornecidos, Endereco endereco, String cnpj, String nomeDaEmpresa) {
        this.valorDosProdutos = valorDosProdutos;
        this.produtosFornecidos = produtosFornecidos;
        this.endereco = endereco;
        this.cnpj = cnpj;
        this.nomeDaEmpresa = nomeDaEmpresa;
    }

    @Override
    public String toString() {
        return "Fornecedor: " + "\n Valor dos produtos: " + valorDosProdutos + "\n Produtos fornecidos: " + produtosFornecidos + "\n Endereço: " + endereco.toString() + "\n CNPJ: " + cnpj + "\n Nome da empresa: " + nomeDaEmpresa;
    }

    public long getValorDosProdutos() {
        return valorDosProdutos;
    }

    public void setValorDosProdutos(long valorDosProdutos) {
        this.valorDosProdutos = valorDosProdutos;
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

}
