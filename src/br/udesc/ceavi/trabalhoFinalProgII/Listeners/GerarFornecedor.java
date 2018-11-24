
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
public class GerarFornecedor extends Gerar{

     
    CancelarLIstener liste;
    FrameCRUDfornecedor frame = null;
    FrameCRUDfornecedor frame2 = null;

    @Override
    public void actionPerformed(ActionEvent e) {
        
        Dimension tamanho = new Dimension(350, 250);

        if (frame == null && frame2 == null) {

            frame = new FrameCRUDfornecedor("Cadastro de fornecedor", tamanho);
            liste = new CancelarLIstener(frame);
            frame.getPanelBotoes().getBtCancelar().addActionListener(liste);
            frame2 = null;
            frame.setVisible(true);
        } else if (frame2 == null) {

            frame.setVisible(false);
            frame = null;

            frame2 = new FrameCRUDfornecedor("Cadastro do fornecedor", tamanho);
            liste = new CancelarLIstener(frame2);
            frame2.getPanelBotoes().getBtCancelar().addActionListener(liste);

            frame2.setVisible(true);
        } else if (frame == null) {
            frame2.setVisible(false);
            frame = new FrameCRUDfornecedor("Cadastro do fornecedor", tamanho);
            liste = new CancelarLIstener(frame);
            frame.getPanelBotoes().getBtCancelar().addActionListener(liste);
            frame2 = null;
            frame.setVisible(true);
        }

    }
    
    

    
    
}
