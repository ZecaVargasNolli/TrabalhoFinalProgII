package br.udesc.ceavi.trabalhoFinalProgII.Listeners.Visualizar;

import br.udesc.ceavi.trabalhoFinalProgII.Listeners.Gerar;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Usuario;
import br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios.Remover.removerRequisitante;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.UsuarioDAO;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * Classe responsavel por gerar o frame de alterar e remover de Requisitante.
 *
 * @author Giancarlo Pandini
 * @author Gustavo José
 * @author José Vargas Nolli
 * @since 29/11/2018
 * @version 1.0
 */
public class GerarVRequisitante extends Gerar {

    Dimension tamanho = new Dimension(350, 250);
    JFrame frame = null;
    JFrame frame2 = null;
    UsuarioDAO userDAO = new UsuarioDAO();
    Usuario user = userDAO.buscarUsuarioLogado();

    @Override
    public void actionPerformed(ActionEvent e) {

        if (user.isMaster() == true) {

            if (frame == null && frame2 == null) {

                frame = new removerRequisitante("Visualizar Requisitante", tamanho);

                frame2 = null;
                frame.setVisible(true);
            } else if (frame2 == null) {

                frame.setVisible(false);
                frame = null;

                frame2 = new removerRequisitante("Visualizar Requisitante", tamanho);

                frame2.setVisible(true);
            } else if (frame == null) {
                frame2.setVisible(false);

                frame = new removerRequisitante("Visualizar Requisitante", tamanho);
                frame2 = null;
                frame.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Você não tem permissão para isso");
        }
    }
}
