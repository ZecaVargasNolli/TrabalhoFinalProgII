package br.udesc.ceavi.trabalhoFinalProgII.Listeners.FramePrincipal;

import br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios.FrameCRUDGenerico;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

/**
 * Listener que acaba com o processo ,unica saida do sistema.
 *
 * @author José Vargas Nolli
 * @author Gustavo José
 * @author Giancarlo Pandini
 * @since 29/11/2018
 * @version 1.0
 */
public class Sair implements ActionListener {

    private FrameCRUDGenerico frame;

    @Override
    public void actionPerformed(ActionEvent e) {

        int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente fechar o programa?",
                "Fechar o programa",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if (resposta == JOptionPane.YES_OPTION) {

            System.exit(0);
        }

    }

}
