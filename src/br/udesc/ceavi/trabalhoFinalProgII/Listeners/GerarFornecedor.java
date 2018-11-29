package br.udesc.ceavi.trabalhoFinalProgII.Listeners;

import br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios.FrameCRUDfornecedor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

/**
 * Classe respon´savel por gerar o JFrame do cadastro de fornecedor.
 *
 * @author José Vargas Nolli
 * @author Giancarlo Pandini
 * @author Gustavo José
 * @since 29/11/2018
 * @version 1.0
 */
public class GerarFornecedor extends Gerar {

    CancelarListener liste;
    FrameCRUDfornecedor frame = null;
    FrameCRUDfornecedor frame2 = null;

    @Override
    public void actionPerformed(ActionEvent e) {

        Dimension tamanho = new Dimension(350, 250);

        if (frame == null && frame2 == null) {

            frame = new FrameCRUDfornecedor("Cadastro de fornecedor", tamanho);
            liste = new CancelarListener(frame);
            frame.getPanelBotoes().getBtCancelar().addActionListener(liste);
            frame2 = null;
            frame.setVisible(true);
        } else if (frame2 == null) {

            frame.setVisible(false);
            frame = null;

            frame2 = new FrameCRUDfornecedor("Cadastro do fornecedor", tamanho);
            liste = new CancelarListener(frame2);
            frame2.getPanelBotoes().getBtCancelar().addActionListener(liste);

            frame2.setVisible(true);
        } else if (frame == null) {
            frame2.setVisible(false);
            frame = new FrameCRUDfornecedor("Cadastro do fornecedor", tamanho);
            liste = new CancelarListener(frame);
            frame.getPanelBotoes().getBtCancelar().addActionListener(liste);
            frame2 = null;
            frame.setVisible(true);
        }

    }

}
