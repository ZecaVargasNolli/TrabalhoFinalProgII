package br.udesc.ceavi.trabalhoFinalProgII.Listeners.FramePrincipal;

import br.udesc.ceavi.trabalhoFinalProgII.Listeners.GerarUsuario;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Usuario;
import br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios.FrameLogin;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.UsuarioDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 * Listener utilizado para fazer o relogin no sistema e trocar o usuario
 *
 * @author José Vargas Nolli
 * @author Giancarlo Pandini
 * @author GUstavo José
 * @since 29/11/2018
 * @version 1.0
 */
public class Relogin implements ActionListener {

    JFrame frame;
    UsuarioDAO uDAO = new UsuarioDAO();

    public Relogin(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Usuario user = uDAO.buscarUsuarioLogado();

        user.setLogado(false);
        try {
            uDAO.atualizar(user);
        } catch (Exception ex) {
            Logger.getLogger(GerarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

        frame.dispose();
        FrameLogin log = new FrameLogin();
        log.setVisible(true);

    }

}
