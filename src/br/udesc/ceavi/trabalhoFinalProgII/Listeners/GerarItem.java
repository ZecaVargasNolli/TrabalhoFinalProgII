
package br.udesc.ceavi.trabalhoFinalProgII.Listeners;

import br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios.FrameCRUDitem;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author José Vargas Nolli
 */
public class GerarItem implements ActionListener,Runnable {

    @Override
    public void actionPerformed(ActionEvent e) {
        GerarItem teste = new GerarItem();
        Thread t = new Thread(teste);
        
        t.start();
    }

    @Override
    public void run() {
         Dimension tamanho = new Dimension(350, 250);
        JFrame frame = new FrameCRUDitem("Cadastro de Item",tamanho);
        frame.setVisible(true);
    }
    
}
