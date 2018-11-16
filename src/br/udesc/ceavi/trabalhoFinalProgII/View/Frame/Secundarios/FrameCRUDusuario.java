
package br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author José Vargas Nolli
 */
public class FrameCRUDusuario extends FrameCRUDGenerico {
    
   
    private JLabel lbNome;
    
    
    private JTextField txNome;
    
    private LayoutManager layout;
    
    private GridBagConstraints cons;
    private JPanel panelFormulario;
   
    
    
    public FrameCRUDusuario(String titulo, Dimension tamanho) {
        super(titulo, tamanho);
        
        initCom();
        addCom();
    }

    private void initCom() {
        lbNome = new JLabel("Nome: ");
        txNome = new JTextField();
        layout= new GridBagLayout();
        panelFormulario = new JPanel(layout);
        
    }

    private void addCom() {
    
 cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 0;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbNome, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 0;
        cons.gridwidth = 2;
        cons.ipadx = 100;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(txNome, cons);     
        
        super.add(panelFormulario);
    }
    
}
