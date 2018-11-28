/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.trabalhoFinalProgII.Listeners;

import br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios.FrameCRUDtipo;
import java.awt.Dimension;
import java.awt.event.ActionEvent;


/**
 *
 * @author José Vargas Nolli
 */
public class GerarTipo  extends Gerar{

    
    Dimension tamanho = new Dimension(350, 250);
    CancelarListener liste;
    FrameCRUDtipo frame = null;
    FrameCRUDtipo frame2 = null;
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (frame == null && frame2 == null) {
        
        frame = new FrameCRUDtipo("Cadastre o tipo", tamanho);
            liste = new CancelarListener(frame);
            frame.getPanelBotoes().getBtCancelar().addActionListener(liste);
            frame2 = null;
            frame.setVisible(true);
        } else if (frame2 == null) {

            frame.setVisible(false);
            frame = null;

            frame2 = new FrameCRUDtipo("Cadastre o tipo", tamanho);
            liste = new CancelarListener(frame2);
            frame2.getPanelBotoes().getBtCancelar().addActionListener(liste);

            frame2.setVisible(true);
        } else if (frame == null) {
            frame2.setVisible(false);
            frame = new FrameCRUDtipo("Cadastre o tipo", tamanho);
            liste = new CancelarListener(frame);
            frame.getPanelBotoes().getBtCancelar().addActionListener(liste);
            frame2 = null;
            frame.setVisible(true);
        
    }
       
    }

    
    
}
