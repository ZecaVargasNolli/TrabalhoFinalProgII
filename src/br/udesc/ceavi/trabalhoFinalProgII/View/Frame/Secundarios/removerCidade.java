/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios;

import br.udesc.ceavi.trabalhoFinalProgII.Model.Cidade;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.CidadeDAO;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.LayoutManager;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicSplitPaneUI;

/**
 *
 * @author José Vargas Nolli
 */
public class removerCidade extends FrameRemover{
    
    private Label lbCidade;
    private JComboBox cbCidadeR;
    private LayoutManager layout;
    private JPanel paneR;
    private GridBagConstraints cons;
    
    
    public removerCidade(String titulo, Dimension tamanho) {
        super(titulo, tamanho);
        
        initCom();
        iniCombo();
        add();
    }

    private void initCom() {
        lbCidade = new Label("CIDADES: ");
        paneR = new JPanel();
        layout = new GridBagLayout();
    }

    private void iniCombo() {
        cbCidadeR = new JComboBox();
        CidadeDAO dao = new CidadeDAO();

        List<Cidade> cidades;

        cidades = dao.buscarCidade();

        for (int i = 0; i < cidades.size(); i++) {
            cbCidadeR.addItem(cidades.get(i).getNomeCidade());

        }
           cbCidadeR.setSelectedIndex(-1);
    }

    private void add() {
        
        paneR.setLayout(layout);
        
        
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 0;
        cons.ipadx = 50;
        cons.fill = GridBagConstraints.HORIZONTAL;
        paneR.add(lbCidade,cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 0;
        cons.ipadx = 100;
        cons.fill = GridBagConstraints.HORIZONTAL;
        paneR.add(cbCidadeR,cons);
        
        
        
        
        super.add(paneR);
    }
    
}
