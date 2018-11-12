package br.udesc.ceavi.trabalhoFinalProgII.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Classe Gerente erda a classe Usuario ,tendo como diferença o atributo que
 * remete a uma senha que permite acesso completo ao sistema , somente ao
 * gerente ,relacionado a questões do cadastro do produto.
 *
 * mapeado por Giancarlo Pandini
 * 
 * @author José Vargas Nolli
 * @version 1.0
 * @since 18/08/2018
 */
@Entity
@Table(name = "gerente")
public class Gerente extends Usuario {
    
    @Column(name ="senhaMestre")
    private String senhaMestre;

    @Override
    public String toString() {
        return "Gerente: " + "\n Senha mestre: " + senhaMestre + "\n" + super.toString();
    }

    public Gerente(String senhaMestre, String nome, long senha) {
        super(nome, senha);
        this.senhaMestre = senhaMestre;
    }

    public Gerente() {
    super();
    this.senhaMestre = "";
    }
    
    

    public String getSenhaMestre() {
        return senhaMestre;
    }

    public void setSenhaMestre(String senhaMestre) {
        this.senhaMestre = senhaMestre;
    }

}
