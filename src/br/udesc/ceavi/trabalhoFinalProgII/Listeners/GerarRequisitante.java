
package br.udesc.ceavi.trabalhoFinalProgII.Listeners;

import br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios.FrameCRUDrequisitante;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;

/**
 *
 * @author José Vargas Nolli
 */
public class GerarRequisitante extends Gerar {

    @Override
    public void actionPerformed(ActionEvent e) {
       
        GerarRequisitante teste = new GerarRequisitante();
        Thread t = new Thread(teste);
        
        t.start();
        
    }

    @Override
    public void run() {
        
        Dimension tamanho = new Dimension(250, 200);
        JFrame frame = new FrameCRUDrequisitante("Cadastro de Requisitante",tamanho);
        frame.setVisible(true);
       
    }
    
}
