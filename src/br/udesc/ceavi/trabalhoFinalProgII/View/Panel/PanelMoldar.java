
package br.udesc.ceavi.trabalhoFinalProgII.View.Panel;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * Botões que est]ão presentes nos Frames  que todos os usuarios podem acessar
 * tem a função cadastrar o item no banco e cancelar (sair) do frame.
 * 
 * @author José Vargas Nolli
 * @since 24/11/2018
 * @version  1.0
 */
public class PanelMoldar  extends JPanel{
    
    //ATRIBUTOS
    public JButton btAlterar;
    public JButton btCancelar;
    public JButton btRemover;
    
    private LayoutManager layout;
    
    private Dimension dimensaoBotao;
    private Dimension dimensaoPanel;
    
    private Container contem;
    private JPanel panel;

    //METODO CONSTRUTOR DA CLASSE
    public PanelMoldar(Container contem) {
        this.contem = contem;
        layout = new FlowLayout();
        
        initCom();
        addCom();
        
        super.setLayout(layout);
        super.setVisible(true);
       super.setSize(dimensaoPanel);
    }

    //METODO RESPONSAVEL POR INICIAR OS COMPONENTES DO PANEL
    private void initCom() {
    
        btAlterar = new JButton("Alterar");
        btCancelar = new JButton("Cancelar");
        btRemover = new JButton("Remover");
        panel = new JPanel(layout);
        
        
        
        dimensaoBotao = new Dimension(80,30);
        dimensaoPanel = new Dimension(contem.getWidth(),50);
        
        btAlterar.setSize(dimensaoBotao);
        btCancelar.setSize(dimensaoBotao);
        btRemover.setSize(dimensaoBotao);
        
        
    
    }

    //METODO PARA ADICIONAR OS COMPONENTES AO FRAME
    private void addCom() {
    panel.setSize(dimensaoPanel);
    panel.add(btAlterar);
    panel.add(btCancelar);
    panel.add(btRemover);
    this.add(panel);
    
    
    
    
    }

    //GETTERS AND SETTERS
    public JButton getBtAlterar() {
        return btAlterar;
    }

  

    public JButton getBtCancelar() {
        return btCancelar;
    }

    public JButton getBtRemover() {
        return btRemover;
    }

 
  
    
    

   
    
    
    
    
    
    
}


