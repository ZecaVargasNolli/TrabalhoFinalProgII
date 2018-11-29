package br.udesc.ceavi.trabalhoFinalProgII.Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Classe Usuario responsável por manter os dados do usuário do aplicativo,para
 * poder relacionalo com o cadastro de emprestimos.
 *
 * @author José Vargas Nolli
 * @author Giancarlo Pandini
 * @author Gustavo José
 * @version 1.0
 * @since 18/08/2018
 */
@Entity
@Table(name = "usuario")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NamedQueries({
    @NamedQuery(name = "buscarUsuario", query = "SELECT us FROM Usuario us")
    ,
    @NamedQuery(name = "buscarUsuarioLogado", query = "SELECT us FROM Usuario us WHERE us.logado = :logado")

})
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_usuario")
    private int codigo; //chave artificial

    @Column(name = "nome", unique = true)// LEMBRAR QUE É NECESSÁRIO TRY CATCH
    private String nome;

    @Column(name = "senha")
    private String senha;

    @Column(name = "gerente")
    private boolean master;

    @Column(name = "logado")
    private boolean logado;

    public Usuario(String nome, String senha) {
        super();
        this.nome = nome;
        this.senha = senha;
        this.codigo = 0; // sempre zero porque o id esta com valor gerado automaticamente.
        this.master = false;
        this.logado = false;
    }

    public Usuario() {
        super();
        this.nome = "";
        this.senha = "";
        this.codigo = 0;
        this.logado = false;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isMaster() {
        return master;
    }

    public void setMaster(boolean master) {
        this.master = master;
    }

    public boolean isLogado() {
        return logado;
    }

    public void setLogado(boolean logado) {
        this.logado = logado;
    }

    @Override
    public String toString() {
        return "Usuario{" + "codigo=" + codigo + ", nome=" + nome + ", senha=" + senha + ", master=" + master + '}';
    }

}
