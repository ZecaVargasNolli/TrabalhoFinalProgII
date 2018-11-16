
package br.udesc.ceavi.trabalhoFinalProgII.Listeners;

import br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios.FrameCRUDrequisitante;
import br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios.FrameCRUDusuario;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;

/**
 *
 * @author José Vargas Nolli
 */
public class GerarUsuario extends Gerar {

    @Override
    public void actionPerformed(ActionEvent e) {
        GerarUsuario teste = new GerarUsuario();
        Thread t = new Thread(teste);
        
        t.start();
    }

    @Override
    public void run() {
        Dimension tamanho = new Dimension(200,150);
        JFrame frame = new FrameCRUDusuario("Cadastro de Usuário",tamanho);
        frame.setVisible(true);
    }
    
}
