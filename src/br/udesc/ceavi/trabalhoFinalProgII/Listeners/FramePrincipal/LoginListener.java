package br.udesc.ceavi.trabalhoFinalProgII.Listeners.FramePrincipal;

import br.udesc.ceavi.trabalhoFinalProgII.Model.Usuario;
import br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios.FrameLogin;
import br.udesc.ceavi.trabalhoFinalProgII.View.Frame.principal.JFramePrincipal;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.UsuarioDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * Listener responsável pelo login do usuario no sistema.
 *
 * @author Gustavo José
 * @author Giancarlo Pandini
 * @author José Vargas Nolli
 * @since 29/11/2018
 * @version 1.0
 */
public class LoginListener implements ActionListener {

    private UsuarioDAO admin = new UsuarioDAO();
    private FrameLogin fram;
    private String us;

    @Override
    public void actionPerformed(ActionEvent ae) {
        Usuario user = admin.getUsuario(fram.getTxLogin().getText(), fram.getTxPassword().getText());

        if (user != null) {

            us = fram.getTxLogin().getText();
            JFrame frame = new JFramePrincipal();
            fram.setVisible(false);
            user.setLogado(true);
            try {
                admin.atualizar(user);
            } catch (Exception ex) {
                Logger.getLogger(LoginListener.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Usuário não existente");
        }

    }

    public LoginListener(FrameLogin fram) {
        this.fram = fram;
    }

}
