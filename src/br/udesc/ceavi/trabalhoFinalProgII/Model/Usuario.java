package br.udesc.ceavi.trabalhoFinalProgII.Model;

/**
 * Classe Usuario responsável por manter os dados do usuário do aplicativo,para
 * poder relacionalo com o cadastro de emprestimos.
 *
 * @author José Vargas Nolli
 * @version 1.0
 * @since 18/08/2018
 */
public class Usuario {

    private String nome;
    private long senha;

    @Override
    public String toString() {
        return "Usuario{" + "nome=" + nome + ", senha=" + senha + '}';
    }

    
    
    public Usuario(String nome, long senha) {
        this.nome = nome;
        this.senha = senha;
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

   
}
