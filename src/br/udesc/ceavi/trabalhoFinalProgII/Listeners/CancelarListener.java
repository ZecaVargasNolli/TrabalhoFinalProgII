package br.udesc.ceavi.trabalhoFinalProgII.Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * desliga um frame que esta sendo utilizado ,por isso recebe um frame como
 * parametro na sua construção
 *
 * @author José Vargas Nolli
 * @author Gustavo José
 * @author Giancarlo Pandini
 * @since 29/11/2018
 * @version 1.0
 */
public class CancelarListener implements ActionListener {

    private JFrame frame;

    public CancelarListener(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente fechar a janela?",
                "Confirmar Fechamento",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if (resposta == JOptionPane.YES_OPTION) {

            frame.dispose();
        }

    }

}
