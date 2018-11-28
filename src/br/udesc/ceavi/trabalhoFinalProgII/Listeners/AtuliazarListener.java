/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.trabalhoFinalProgII.Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author José Vargas Nolli
 */
public class AtuliazarListener  implements ActionListener{

    JFrame frame;

    public AtuliazarListener(JFrame frame) {
        this.frame = frame;
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
       
        frame.dispose();
    }
    
}
