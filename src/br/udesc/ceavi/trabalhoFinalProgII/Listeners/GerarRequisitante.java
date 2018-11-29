package br.udesc.ceavi.trabalhoFinalProgII.Listeners;

import br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios.FrameCRUDrequisitante;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

/**
 * Classe responsável por gerar o JFrame do cadastro de Requisitante
 *
 * @author José Vargas Nolli
 * @author Gustavo José
 * @author Giancarlo Pandini
 * @since 29/11/2018
 * @version 1.0
 */
public class GerarRequisitante extends Gerar {

    Dimension tamanho = new Dimension(350, 250);
    CancelarListener liste;
    FrameCRUDrequisitante frame = null;
    FrameCRUDrequisitante frame2 = null;

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (frame == null && frame2 == null) {

            frame = new FrameCRUDrequisitante("Cadastro de Requisitante", tamanho);
            liste = new CancelarListener(frame);
            frame.getPanelBotoes().getBtCancelar().addActionListener(liste);
            frame2 = null;
            frame.setVisible(true);
        } else if (frame2 == null) {

            frame.setVisible(false);
            frame = null;

            frame2 = new FrameCRUDrequisitante("Cadastro de Requisitante", tamanho);
            liste = new CancelarListener(frame2);
            frame2.getPanelBotoes().getBtCancelar().addActionListener(liste);

            frame2.setVisible(true);
        } else if (frame == null) {
            frame2.setVisible(false);
            frame = new FrameCRUDrequisitante("Cadastro de Requisitante", tamanho);
            liste = new CancelarListener(frame);
            frame.getPanelBotoes().getBtCancelar().addActionListener(liste);
            frame2 = null;
            frame.setVisible(true);

        }
    }

}
