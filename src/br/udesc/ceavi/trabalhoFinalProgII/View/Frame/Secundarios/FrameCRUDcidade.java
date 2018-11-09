/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *Formulario da classe cidade, responsável por seu cadastro.
 * 
 * @author José Vargas Nolli
 * @version 1.0
 * @since 09/11/2018
 */
public class FrameCRUDcidade extends FrameCRUDGenerico {
    
    
    private  JLabel lbCodigo;
    private  JLabel lbSigla;
    
    private JTextField txCodigo;
    private JTextField txSigla;
    
     private JComboBox cbUF;

    private JPanel panelFormulario;
    
    private LayoutManager layout;
    private GridBagConstraints cons;
    
    private final Dimension tamanho = new Dimension(500, 300);
    
    public FrameCRUDcidade(String titulo, Dimension tamanho) {
        super(titulo, tamanho);
        
        
        initCom();
        addCom();
    }

    private void initCom() {
       lbCodigo = new JLabel("Código: ");
       lbSigla =  new JLabel("Sigla: ");
       
       txCodigo = new JTextField();
       txSigla = new JTextField();
       
       layout = new GridBagLayout();
       
       panelFormulario = new JPanel(layout);
       
       
       
       
    }

    private void addCom() {
        
    }
    
}
