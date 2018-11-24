package br.udesc.ceavi.trabalhoFinalProgII.Listeners;

import br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios.FrameCRUDendereco;
import java.awt.Dimension;
import java.awt.event.ActionEvent;


/**
 * Classe responsável por gerar o JFrame de endereço.
 *
 * @author José Vargas Nolli
 * @since 24/11/2018
 * @version 1.0
 */
public class GerarEndereco extends Gerar {

    Dimension tamanho = new Dimension(350, 250);
    CancelarLIstener liste;
    FrameCRUDendereco frame = null;
    FrameCRUDendereco frame2 = null;

    @Override
    public void actionPerformed(ActionEvent e) {

        if (frame == null && frame2 == null) {

            frame = new FrameCRUDendereco("Cadastro de Endereço", tamanho);
            liste = new CancelarLIstener(frame);
            frame.getPanelBotoes().getBtCancelar().addActionListener(liste);
            frame2 = null;
            frame.setVisible(true);
        } else if (frame2 == null) {

            frame.setVisible(false);
            frame = null;

            frame2 = new FrameCRUDendereco("Cadastro de Endereço", tamanho);
            liste = new CancelarLIstener(frame2);
            frame2.getPanelBotoes().getBtCancelar().addActionListener(liste);

            frame2.setVisible(true);
        } else if (frame == null) {
            frame2.setVisible(false);
            frame = new FrameCRUDendereco("Cadastro de Endereço", tamanho);
            liste = new CancelarLIstener(frame);
            frame.getPanelBotoes().getBtCancelar().addActionListener(liste);
            frame2 = null;
            frame.setVisible(true);
        }

    }

}
