/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.trabalhoFinalProgII.Listeners.Visualizar;

import br.udesc.ceavi.trabalhoFinalProgII.Listeners.CancelarListener;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.Gerar;
import br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios.FrameCRUDcidade;
import br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios.removerCidade;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;

/**
 *
 * @author José Vargas Nolli
 */
public class GerarVCidade  extends Gerar{
    
    Dimension tamanho = new Dimension(300, 250);
    JFrame frame = null;

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(frame == null){ 
       frame = new removerCidade("Visualizar Cidade", tamanho);
       
       
       }     
       
         frame.setVisible(true);

  
    }
}
