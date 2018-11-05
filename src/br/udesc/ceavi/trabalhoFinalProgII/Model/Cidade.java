package br.udesc.ceavi.trabalhoFinalProgII.Model;

/**
 * Classe cidade referente aos dados relacionados a cidade ,presentes em
 * endereço.
 *
 * @author José Vargas Nolli
 * @version 1.0
 * @since 18/08/2018
 */
public class Cidade {

    private String nomeCidade;
    private String sigla;
    private UF uf;

    public Cidade(String nomeCidade, String sigla, UF uf) {
        super();
        this.nomeCidade = nomeCidade;
        this.sigla = sigla;
        this.uf = uf;
    }

    @Override
    public String toString() {
        return "Cidade:" + "\n nomeCidade: " + nomeCidade + "\n sigla: " + sigla + "\n uf: " + uf;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public UF getUf() {
        return uf;
    }

    public void setUf(UF uf) {
        this.uf = uf;
    }

  

}
