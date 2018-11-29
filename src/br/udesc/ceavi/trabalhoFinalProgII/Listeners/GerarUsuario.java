package br.udesc.ceavi.trabalhoFinalProgII.Listeners;

import br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios.FrameCRUDusuario;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

/**
 * Classe Responsavel por gerar o cadastro de usuario.
 *
 * @author José Vargas Nolli
 * @author Giancarlo Pandini
 * @author Gustavo José
 * @since 29/11/2018
 * @version 1.0
 */
public class GerarUsuario extends Gerar {

    Dimension tamanho = new Dimension(350, 250);
    CancelarListener liste;
    FrameCRUDusuario frame = null;
    FrameCRUDusuario frame2 = null;

    @Override
    public void actionPerformed(ActionEvent e) {

        if (frame == null && frame2 == null) {

            frame = new FrameCRUDusuario("Cadastro de Usuario", tamanho);
            liste = new CancelarListener(frame);
            frame.getPanelBotoes().getBtCancelar().addActionListener(liste);
            frame2 = null;
            frame.setVisible(true);
        } else if (frame2 == null) {

            frame.setVisible(false);
            frame = null;

            frame2 = new FrameCRUDusuario("Cadastro de Usuario", tamanho);
            liste = new CancelarListener(frame2);
            frame2.getPanelBotoes().getBtCancelar().addActionListener(liste);

            frame2.setVisible(true);
        } else if (frame == null) {
            frame2.setVisible(false);
            frame = new FrameCRUDusuario("Cadastro de Usuario", tamanho);
            liste = new CancelarListener(frame);
            frame.getPanelBotoes().getBtCancelar().addActionListener(liste);
            frame2 = null;
            frame.setVisible(true);

        }
    }

}
