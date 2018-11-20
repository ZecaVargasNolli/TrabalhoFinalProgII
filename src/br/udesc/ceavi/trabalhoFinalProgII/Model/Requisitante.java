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
 * Representação do responsavel por aquele produto, no periodo que ele se
 * encontra fora do deposito do almoxarifado
 *
 * mapeado por Giancarlo Pandini
 *
 * @author José Vargas Nolli
 * @version 1.0
 * @since 27/10/2018
 */
@Entity
@Table(name = "requisitante")
@NamedQueries({
    @NamedQuery(name = "buscarRequisitante", query = "SELECT req FROM Requisitante req")
})
public class Requisitante {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="id_requisitante")
    private int codigo;
    
    @Column(name = "nome")
    private String nome;

    @Column(name = "setor")
    private String setor;

    @Column(name = "cpf")
    private long cpf;

    @Column(name = "rg")
    private long rg;

    public Requisitante(String nome, String setor, long cpf, long rg) {
        super();
        this.nome = nome;
        this.setor = setor;
        this.cpf = cpf;
        this.rg = rg;
        this.codigo = 0;
    }

    public Requisitante() {
        super();
        this.nome = "";
        this.setor = "";
        this.cpf = 0l;
        this.rg = 0l;
        this.codigo = 0;
    }

    @Override
    public String toString() {
        return "Requisitante{" + "nome=" + nome + ", setor=" + setor + ", cpf=" + cpf + ", rg=" + rg + '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public long getRg() {
        return rg;
    }

    public void setRg(long rg) {
        this.rg = rg;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

}
