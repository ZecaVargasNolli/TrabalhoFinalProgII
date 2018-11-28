/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios;

import br.udesc.ceavi.trabalhoFinalProgII.Listeners.CancelarListener;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Cidade;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.CidadeDAO;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
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
        addListener();
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
        cons.gridwidth = 2;
        cons.ipadx = 70;
        cons.fill = GridBagConstraints.HORIZONTAL;
        paneR.add(cbCidadeR,cons);
        
        
        
        
        super.add(paneR);
    }

    private void addListener() {
        JButton bt;
        bt = getPaneBotoes().getBtRemover();
        ActionListener actionRemove = new Remover();
        bt.addActionListener(actionRemove);
        bt = getPaneBotoes().getBtCancelar();
        ActionListener actionCancelar = new CancelarListener(this);
        bt.addActionListener(actionCancelar);
    }
 
    
    public class Remover implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           CidadeDAO cDAO = new CidadeDAO();
            
            List<Cidade> cidades = cDAO.buscarCidade();
            Cidade cid = null;
            for (Cidade cidade : cidades) {
                if (cidade.getNomeCidade()== cbCidadeR.getSelectedItem()) {
                    cid=cidade;
                }
            }
            try {
                cDAO.deletar(cid);
                JOptionPane.showMessageDialog(null,"Cidade deletada com sucesso");
            } catch (Exception ex) {
                Logger.getLogger(removerCidade.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
}
