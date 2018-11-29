/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios.Alterar;

import br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios.Remover.*;
import br.udesc.ceavi.trabalhoFinalProgII.View.Panel.PanelMoldar;
import br.udesc.ceavi.trabalhoFinalProgII.View.Panel.PanelOK;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author José Vargas Nolli
 */
public  abstract class FrameAlterar extends JFrame {
    
    
    
    
     private JPanel panelPrincipal;
     
     private Dimension tamanho;
     
     private PanelOK paneBotoes;

     private LayoutManager layout;

    public FrameAlterar(String titulo,Dimension tamanho) {
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

       paneBotoes = new PanelOK(this);

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

    public PanelOK getPaneBotoes() {
        return paneBotoes;
    }
     
     
}
