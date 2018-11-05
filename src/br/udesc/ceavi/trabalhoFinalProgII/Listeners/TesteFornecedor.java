/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.trabalhoFinalProgII.Listeners;

import br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios.FrameCRUDfornecedor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author José Vargas Nolli
 */
public class TesteFornecedor implements ActionListener,Runnable{

    @Override
    public void actionPerformed(ActionEvent e) {
    
        TesteFornecedor teste = new TesteFornecedor();
        Thread t = new Thread(teste);
        
        t.start();
       
    }

    @Override
    public void run() {
      
        JFrame frame = new FrameCRUDfornecedor("Cadastro de Fornecedor");
        frame.setVisible(true);
    }
    
    
}
