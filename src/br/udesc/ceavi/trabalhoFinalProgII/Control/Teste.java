/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.trabalhoFinalProgII.Control;

import br.udesc.ceavi.trabalhoFinalProgII.View.Frame.principal.FrameMenu;
import javax.swing.JFrame;

/**
 *
 * @author José Vargas Nolli
 */
public class Teste  implements Runnable{
    
     public static void main(String[] args) {
        Teste telaPrincipal = new Teste();
        Thread thread = new Thread(telaPrincipal);
        
        thread.start();
    }

    @Override
    public void run() {
        JFrame frame = new FrameMenu();
        
        frame.setVisible(true);
    }
    
}

