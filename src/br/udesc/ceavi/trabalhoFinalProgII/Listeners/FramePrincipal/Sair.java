/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.trabalhoFinalProgII.Listeners.FramePrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author José Vargas Nolli
 */
public class Sair  implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        
       System.exit(0);
        
        
    }
    
}
