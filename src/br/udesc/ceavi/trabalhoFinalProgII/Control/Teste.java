package br.udesc.ceavi.trabalhoFinalProgII.Control;

import br.udesc.ceavi.trabalhoFinalProgII.Model.Usuario;
import br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios.FrameLogin;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.UsuarioDAO;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * classe principal onde tudo começa
 *
 * @author José Vargas Nolli
 * @author Gustavo José
 * @author Giancarlo pandini
 * @since 29/11/2018
 * @version 1.0
 */
public class Teste implements Runnable {

    public static void main(String[] args) {

        Teste telaPrincipal = new Teste();
        Thread thread = new Thread(telaPrincipal);

        thread.start();
    }

    @Override
    public void run() {

        FrameLogin frame1 = new FrameLogin();
        UsuarioDAO admin = new UsuarioDAO();
        Usuario user1 = new Usuario();
        user1.setNome("admin");
        user1.setSenha("admin");
        user1.setMaster(true);
        try {
            admin.inserir(user1);
        } catch (Exception ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }
        frame1.setVisible(true);

    }

}
