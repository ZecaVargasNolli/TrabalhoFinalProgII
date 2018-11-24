package br.udesc.ceavi.trabalhoFinalProgII.Model;

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
 * mapeamento feito por Giancarlo Pandini
 *
 * @author José Vargas Nolli
 * @version 1.0
 * @since 18/08/2018
 */
@Entity
@Table(name = "usuario")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NamedQueries({
    @NamedQuery(name = "buscarUsuario", query = "SELECT us FROM Usuario us")
})
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_usuario")
    private int codigo; //chave artificial

    @Column(name = "nome")
    private String nome;

    @Column(name = "senha")
    private long senha;

    public Usuario(String nome, long senha) {
        super();
        this.nome = nome;
        this.senha = senha;
        this.codigo = 0; // sempre zero porque o id esta com valor gerado automaticamente.
    }

    public Usuario() {
        super();
        this.nome = "";
        this.senha = 0l;
        this.codigo = 0;
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

    public long getSenha() {
        return senha;
    }

    public void setSenha(long senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nome=" + nome + ", senha=" + senha + '}';
    }
}
