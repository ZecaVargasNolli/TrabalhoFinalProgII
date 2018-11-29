package br.udesc.ceavi.trabalhoFinalProgII.Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 * Listener responsável por atualizar os frames e capturar os novos dados
 * cadastrados no banco
 *
 * @author José Vargas Nolli
 * @author Gustavo José
 * @author Giancarlo pandini
 * @since 29/11/2018
 * @version 1.0
 */
public class AtuliazarListener implements ActionListener {

    JFrame frame;

    public AtuliazarListener(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        frame.dispose();
    }

}
