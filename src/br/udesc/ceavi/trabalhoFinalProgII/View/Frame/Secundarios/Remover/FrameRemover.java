
package br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios.Remover;

import br.udesc.ceavi.trabalhoFinalProgII.View.Panel.PanelMoldar;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * Frame do remover e alterar generico, super classe extendida usada como expelho
 * 
 * @author Giancarlo Pandini
 * @author Gustavo José
 * @author José Vargas Nolli
 * @since 29/11/2018
 * @version 1.0
 */
public  abstract class FrameRemover extends JFrame {
    
    
    
    
     private JPanel panelPrincipal;
     
     private Dimension tamanho;
     
     private PanelMoldar paneBotoes;

     private LayoutManager layout;

    public FrameRemover(String titulo,Dimension tamanho) {
        this.tamanho = tamanho;
        
        initCom();
        addCom();
        
        
         super.setSize(tamanho);
         super.setTitle(titulo);
         super.setLayout(layout);
         super.setResizable(false);
         super.setLocationRelativeTo(null);
         super.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }

    private void initCom() {
       
        panelPrincipal = new JPanel();
        panelPrincipal.setSize(tamanho);

       paneBotoes = new PanelMoldar(this);

        layout = new BorderLayout();

        panelPrincipal.setLayout(layout);
    }

    private void addCom() {
        panelPrincipal.add(paneBotoes,BorderLayout.SOUTH);
        this.setContentPane(panelPrincipal);
    }
     
     
     public void addFormulario(Container parent) {
        panelPrincipal.add(parent, BorderLayout.CENTER);
    }

    public PanelMoldar getPaneBotoes() {
        return paneBotoes;
    }
     
     
}
