
package br.udesc.ceavi.trabalhoFinalProgII.view.Panel;

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
public class PanelCadastro  extends JPanel{
    
    //ATRIBUTOS
    public JButton btCadastrar;
    public JButton btCancelar;
    public JButton btAtualizar;
    
    private LayoutManager layout;
    
    private Dimension dimensaoBotao;
    private Dimension dimensaoPanel;
    
    private Container contem;
    private JPanel panel;

    //METODO CONSTRUTOR DA CLASSE
    public PanelCadastro(Container contem) {
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
    
        btCadastrar = new JButton("Cadastrar");
        btCancelar = new JButton("Cancelar");
        btAtualizar = new JButton("Atualizar");
        panel = new JPanel(layout);
        
        
        
        dimensaoBotao = new Dimension(80,30);
        dimensaoPanel = new Dimension(contem.getWidth(),50);
        
        btCadastrar.setSize(dimensaoBotao);
        btCancelar.setSize(dimensaoBotao);
        btAtualizar.setSize(dimensaoBotao);
        
        
    
    }

    //METODO PARA ADICIONAR OS COMPONENTES AO FRAME
    private void addCom() {
    panel.setSize(dimensaoPanel);
    panel.add(btCadastrar);
    panel.add(btCancelar);
    panel.add(btAtualizar);
    this.add(panel);
    
    
    
    
    }

    //GETTERS AND SETTERS
    public JButton getBtCadastrar() {
        return btCadastrar;
    }

  

    public JButton getBtCancelar() {
        return btCancelar;
    }

    public JButton getBtAtualizar() {
        return btAtualizar;
    }

 
  
    
    

   
    
    
    
    
    
    
}


