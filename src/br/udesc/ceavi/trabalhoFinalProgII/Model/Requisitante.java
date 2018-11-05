
package br.udesc.ceavi.trabalhoFinalProgII.Model;

/**
 *Representação  do responsavel por aquele produto, no periodo que ele 
 * se encontra fora do deposito do almoxarifado
 * 
 * @author José Vargas Nolli
 * @version 1.0
 * @since 27/10/2018
 */
public class Requisitante {
    
    private String nome;
    private String setor;
    private long cpf;
    private long rg;

    public Requisitante(String nome, String setor, long cpf, long rg) {
        this.nome = nome;
        this.setor = setor;
        this.cpf = cpf;
        this.rg = rg;
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
    
    
    
    
    
}
