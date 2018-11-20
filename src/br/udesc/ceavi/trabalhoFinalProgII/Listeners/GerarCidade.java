package br.udesc.ceavi.trabalhoFinalProgII.Listeners;

import br.udesc.ceavi.trabalhoFinalProgII.Model.Cidade;
import br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios.FrameCRUDcidade;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;

/**
 * Classe listener responsável por gerar o JFrame que corresponde ao cadastro de
 * cidade. e tambem o evento associado ao JMenuItem que representa o cadastro de
 * Cidade
 *
 * @author José Vargas Nolli
 * 
 * @since 17/11/2018
 */


public class GerarCidade extends Gerar {

    Dimension tamanho = new Dimension(300, 200);
    FrameCRUDcidade frame = null;
    
    

    @Override//EVENTOS RESPONSÁVEL PELO  EVENTO
    public void actionPerformed(ActionEvent e) {

        GerarCidade teste = new GerarCidade();
        Thread t = new Thread(teste);

        t.start();

    }

    @Override//METODO QUE CRIA E PERMITE VER O FRAME DE CIDADE
    public void run() {
       
         
          
           frame = new FrameCRUDcidade("Cadastro de Cidade", tamanho);
            
         
           
           frame.setVisible(true);

           
    }
}
