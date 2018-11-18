package br.udesc.ceavi.trabalhoFinalProgII.Listeners;

import br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios.FrameCRUDemprestimo;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;

/**
 *
 * @author José Vargas Nolli
 */
public class GerarEmprestimos extends Gerar {

    @Override
    public void actionPerformed(ActionEvent e) {
        GerarEmprestimos teste = new GerarEmprestimos();
        Thread t = new Thread(teste);

        t.start();

    }

    public void run() {
        
         Dimension tamanho = new Dimension(350,250);
         JFrame frame = new FrameCRUDemprestimo("Cadastro de Emprestimo",tamanho);
       
         frame.setVisible(true);
    }

}
