
package br.udesc.ceavi.trabalhoFinalProgII.Listeners;

import br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios.FrameCRUDitem;
import java.awt.Dimension;
import java.awt.event.ActionEvent;


/**
 *
 * @author José Vargas Nolli
 */
public class GerarItem extends Gerar{

     Dimension tamanho = new Dimension(350, 250);
     CancelarListener liste;
    FrameCRUDitem frame = null;
    FrameCRUDitem frame2 = null;
     
     
    @Override
    public void actionPerformed(ActionEvent e) {
        
         if (frame == null && frame2 == null) {
        
        frame = new FrameCRUDitem("Cadastro de Itens", tamanho);
            liste = new CancelarListener(frame);
            frame.getPanelBotoes().getBtCancelar().addActionListener(liste);
            frame2 = null;
            frame.setVisible(true);
        } else if (frame2 == null) {

            frame.setVisible(false);
            frame = null;

            frame2 = new FrameCRUDitem("Cadastro de Itens", tamanho);
            liste = new CancelarListener(frame2);
            frame2.getPanelBotoes().getBtCancelar().addActionListener(liste);

            frame2.setVisible(true);
        } else if (frame == null) {
            frame2.setVisible(false);
            frame = new FrameCRUDitem("Cadastro de Itens", tamanho);
            liste = new CancelarListener(frame);
            frame.getPanelBotoes().getBtCancelar().addActionListener(liste);
            frame2 = null;
            frame.setVisible(true);
        
    }
    }
}

    

