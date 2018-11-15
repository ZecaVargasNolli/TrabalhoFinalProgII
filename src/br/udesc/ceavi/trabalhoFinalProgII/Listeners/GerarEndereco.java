
package br.udesc.ceavi.trabalhoFinalProgII.Listeners;

import br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios.FrameCRUDendereco;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *Classe responsável por gerar o JFrame de endereço.
 * 
 * @author José Vargas Nolli
 */
public class GerarEndereco  implements ActionListener,Runnable{

    @Override
    public void actionPerformed(ActionEvent e) {
        GerarEndereco teste = new GerarEndereco();
        Thread t = new Thread(teste);
        
        t.start();
    }

    @Override
    public void run() {
       Dimension tamanho = new Dimension(250, 200);
        JFrame frame = new FrameCRUDendereco("Cadastro de Endereço",tamanho);
        frame.setVisible(true);
    }
    
}
