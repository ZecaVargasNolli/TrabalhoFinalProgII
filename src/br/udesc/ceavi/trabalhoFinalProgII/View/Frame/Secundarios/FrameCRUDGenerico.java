
package br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios;

import br.udesc.ceavi.trabalhoFinalProgII.Model.Panel.PanelGenerico;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

/**
 *
 * @author José Vargas Nolli
 */
public abstract class FrameCRUDGenerico  extends JFrame{
    
    
    
    private JPanel panelPrincipal;
    private JPanel panelBotoes;
    
    
    private Dimension tamanho;
    
    private LayoutManager layout;

    public FrameCRUDGenerico(String titulo,Dimension tamanho) {
        this.tamanho = tamanho;
        
        InitCom();
        addCom();
        
        super.setSize(tamanho);
        super.setTitle(titulo);
        super.setLayout(layout);
        super.setResizable(false);
        
        
        
    }

    private void InitCom() {
       panelPrincipal = new JPanel();
       panelPrincipal.setSize(tamanho);
       
       panelBotoes = new PanelGenerico(this);
       
       layout = new BorderLayout();
       
       panelPrincipal.setLayout(layout);
       
       
    }

    private void addCom() {
        this.setContentPane(panelPrincipal);
        panelPrincipal.add(panelBotoes,BorderLayout.SOUTH);
        
       
    }
    
     public void addFormulario(Container parent){
            panelPrincipal.add(parent,BorderLayout.CENTER);
        }
    
    
}
