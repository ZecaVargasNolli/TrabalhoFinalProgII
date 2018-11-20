/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.trabalhoFinalProgII.Listeners;

import br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios.viewTable;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;

/**
 *
 * @author José Vargas Nolli
 */
public class GerarTable extends Gerar {

    @Override
    public void actionPerformed(ActionEvent e) {
       
        GerarTable teste = new GerarTable();
        Thread t = new Thread(teste);
        
        t.start();
    }

    @Override
    public void run() {
        JFrame frame = new viewTable();
       
         frame.setVisible(true);
    }
    
}
