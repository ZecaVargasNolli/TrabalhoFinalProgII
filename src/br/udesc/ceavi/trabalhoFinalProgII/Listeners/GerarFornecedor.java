
package br.udesc.ceavi.trabalhoFinalProgII.Listeners;

import br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios.FrameCRUDfornecedor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *Classe respon´savel por gerar o JFrame do cadastro de fornecedor.
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
        Dimension d = new Dimension(250, 200);
        JFrame frame = new FrameCRUDfornecedor("Cadastro de Fornecedor",d);
        frame.setVisible(true);
    }
    
    
}
