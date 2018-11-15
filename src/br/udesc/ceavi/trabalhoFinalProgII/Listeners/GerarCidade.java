
package br.udesc.ceavi.trabalhoFinalProgII.Listeners;

import br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios.FrameCRUDcidade;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *Classe listener responsável por gerar o JFrame que corresponde ao cadastro de cidade.
 * 
 * @author José Vargas Nolli
 */
public class GerarCidade  implements ActionListener,Runnable{

    @Override
    public void actionPerformed(ActionEvent e) {
       
        GerarCidade teste = new GerarCidade();
        Thread t = new Thread(teste);
        
        t.start();
    
    }

    @Override
    public void run() {
        Dimension tamanho = new Dimension(300,200);
         JFrame frame = new FrameCRUDcidade("Cadastro de Cidade",tamanho);
       
         frame.setVisible(true);
        
    }
    
}
