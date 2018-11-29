package br.udesc.ceavi.trabalhoFinalProgII.Listeners;

import br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios.FrameCRUDemprestimo;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

/**
 * Classe responsavel por gerar um frame de cadastro de emprestimo
 *
 * @author José Vargas Nolli
 * @author Gustavo José
 * @author Giancarlo Pandini
 * @since 29/11/2018
 * @version 1.0
 */
public class GerarEmprestimos extends Gerar {

    Dimension tamanho = new Dimension(350, 250);
    CancelarListener liste;
    FrameCRUDemprestimo frame = null;
    FrameCRUDemprestimo frame2 = null;

    @Override
    public void actionPerformed(ActionEvent e) {

        if (frame == null && frame2 == null) {

            frame = new FrameCRUDemprestimo("Cadastro de Emprestimo", tamanho);
            liste = new CancelarListener(frame);
            frame.getPanelBotoes().getBtCancelar().addActionListener(liste);
            frame2 = null;
            frame.setVisible(true);
        } else if (frame2 == null) {

            frame.setVisible(false);
            frame = null;

            frame2 = new FrameCRUDemprestimo("Cadastro de Emprestimo", tamanho);
            liste = new CancelarListener(frame2);
            frame2.getPanelBotoes().getBtCancelar().addActionListener(liste);

            frame2.setVisible(true);
        } else if (frame == null) {
            frame2.setVisible(false);
            frame = new FrameCRUDemprestimo("Cadastro de Emprestimo", tamanho);
            liste = new CancelarListener(frame);
            frame.getPanelBotoes().getBtCancelar().addActionListener(liste);
            frame2 = null;
            frame.setVisible(true);

        }

    }

}
