package br.udesc.ceavi.trabalhoFinalProgII.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Classe cidade referente aos dados relacionados a cidade ,presentes em
 * endereço.
 *
 * mapeado por Giancarlo Pandini
 *
 * @author José Vargas Nolli
 * @version 1.0
 * @since 18/08/2018
 */
@Entity
@Table(name = "cidade")
@NamedQueries({
    @NamedQuery(name = "buscarCidade", query = "SELECT cid FROM Cidade cid")
})
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_cidade")
    private int codigo;
   
    @Column(name ="nomeCidade")
    private String nomeCidade;
    
    @Column(name ="sigla")
    private String sigla;
    
    @Column(name ="uf")
    private UF uf; // enum

    public Cidade(String nomeCidade, String sigla, UF uf) {
        super();
        this.nomeCidade = nomeCidade;
        this.sigla = sigla;
        this.uf = uf;
        this.codigo = 0;
    }

    public Cidade() {
        super();
        this.nomeCidade="";
        this.codigo =0;
        this.sigla = "";
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

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

}
