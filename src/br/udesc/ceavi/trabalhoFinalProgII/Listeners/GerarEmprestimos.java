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
 Dimension tamanho = new Dimension(350, 500);

    @Override
    public void actionPerformed(ActionEvent e) {
     
        JFrame frame = new FrameCRUDemprestimo("Cadastro de Emprestimo",tamanho);
       
         frame.setVisible(true);
    }

   

}
