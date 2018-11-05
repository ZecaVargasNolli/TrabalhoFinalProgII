
package br.udesc.ceavi.trabalhoFinalProgII.view.Panel;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author José Vargas Nolli
 */
public class PanelGenerico  extends JPanel{
    
    
    private JButton btCadastrar;
    private JButton btCancelar;
    
    private LayoutManager layout;
    
    private Dimension dimensaoBotao;
    private Dimension dimensaoPanel;
    
    private Container contem;

    public PanelGenerico(Container contem) {
        this.contem = contem;
        layout = new FlowLayout();
        
        initCom();
        addCom();
        
        super.setLayout(layout);
        super.setVisible(true);
        super.setSize(dimensaoPanel);
    }

    private void initCom() {
    
        btCadastrar = new JButton("Cadastrar");
        btCancelar = new JButton("Cancelar");
        
        
        dimensaoBotao = new Dimension(80,30);
        dimensaoPanel = new Dimension(contem.getWidth(),50);
        
        btCadastrar.setSize(dimensaoBotao);
        btCancelar.setSize(dimensaoBotao);
        
        
    
    }

    private void addCom() {
    this.add(btCadastrar);
    this.add(btCancelar);
    
    
    
    
    }
    
    
    
    
    
}
