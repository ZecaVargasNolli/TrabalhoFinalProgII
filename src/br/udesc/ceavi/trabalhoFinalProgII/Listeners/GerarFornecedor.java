/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.trabalhoFinalProgII.Listeners;

import br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios.FrameCRUDfornecedor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author José Vargas Nolli
 */
public class GerarFornecedor implements ActionListener,Runnable{

    @Override
    public void actionPerformed(ActionEvent e) {
    
        GerarFornecedor teste = new GerarFornecedor();
        Thread t = new Thread(teste);
        
        t.start();
       
    }

    @Override
    public void run() {
        Dimension d = new Dimension(400, 300);
        JFrame frame = new FrameCRUDfornecedor("Cadastro de Fornecedor",d);
        frame.setVisible(true);
    }
    
    
}
