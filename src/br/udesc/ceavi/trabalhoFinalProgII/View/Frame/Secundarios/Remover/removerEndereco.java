/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios.Remover;

import br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios.Remover.FrameRemover;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.CancelarListener;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Endereco;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Fornecedor;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.EnderecoDAO;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.FornecedorDAO;
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


/**
 *
 * @author José Vargas Nolli
 */
public class removerEndereco extends FrameRemover{
    
    private Label lbEndereco;
    private JComboBox cbCEnderecoR;
    private LayoutManager layout;
    private JPanel paneR;
    private GridBagConstraints cons;
    
    
    public removerEndereco(String titulo, Dimension tamanho) {
        super(titulo, tamanho);
        
        initCom();
        iniCombo();
        add();
        addListener();
    }

    private void initCom() {
        lbEndereco = new Label("ENDEREÇOS: ");
        paneR = new JPanel();
        layout = new GridBagLayout();
    }

    private void iniCombo() {
        cbCEnderecoR = new JComboBox();
        EnderecoDAO dao = new EnderecoDAO();

        List<Endereco> endereco;

        endereco = dao.buscarEndereco();

        for (int i = 0; i < endereco.size(); i++) {
            cbCEnderecoR.addItem(endereco.get(i).getCep());

        }
           cbCEnderecoR.setSelectedIndex(-1);
    }

    private void add() {
        
        paneR.setLayout(layout);
        
        
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 0;
        cons.ipadx = 50;
        cons.fill = GridBagConstraints.HORIZONTAL;
        paneR.add(lbEndereco,cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 0;
        cons.gridwidth = 2;
        cons.ipadx = 70;
        cons.fill = GridBagConstraints.HORIZONTAL;
        paneR.add(cbCEnderecoR,cons);
        
        
        
        
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
           EnderecoDAO cDAO = new EnderecoDAO();
            FornecedorDAO eDAO = new FornecedorDAO();
            
            List<Endereco> endereco = cDAO.buscarEndereco();
            Endereco end = null;
            for (Endereco enderecos : endereco) {
                if (enderecos.getCep() == cbCEnderecoR.getSelectedItem()) {
                    end = enderecos;
                }
            }
            
            List<Fornecedor> TodosFornecedores = null;
            TodosFornecedores = eDAO.buscarFornecedorPorEndereco(end);

           
           for (Fornecedor fod : TodosFornecedores) {
               fod.setEndereco(null);
           }
            try {
               for (Fornecedor fog : TodosFornecedores) {
               eDAO.atualizar(fog);
           }
               cDAO.deletar(end);
                JOptionPane.showMessageDialog(null,"Endereço deletado com sucesso");
            } catch (Exception ex) {
                Logger.getLogger(removerEndereco.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
}
