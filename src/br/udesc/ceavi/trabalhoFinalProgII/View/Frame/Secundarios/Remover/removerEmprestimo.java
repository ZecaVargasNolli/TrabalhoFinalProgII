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
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.EmprestimoDAO;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.EnderecoDAO;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.FornecedorDAO;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Emprestimo;
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
public class removerEmprestimo extends FrameRemover{
    
    private Label lbEmprestimo;
    private JComboBox cbCEmprestimoR;
    private LayoutManager layout;
    private JPanel paneR;
    private GridBagConstraints cons;
    
    
    public removerEmprestimo(String titulo, Dimension tamanho) {
        super(titulo, tamanho);
        
        initCom();
        iniCombo();
        add();
        addListener();
    }

    private void initCom() {
        lbEmprestimo = new Label("EMPRÉSTIMOS: ");
        paneR = new JPanel();
        layout = new GridBagLayout();
    }

    private void iniCombo() {
        cbCEmprestimoR = new JComboBox();
        EmprestimoDAO dao = new EmprestimoDAO();

        List<Emprestimo> emprestimo;

        emprestimo = dao.buscarEmprestimo();

        for (int i = 0; i < emprestimo.size(); i++) {
            cbCEmprestimoR.addItem(emprestimo.get(i).getData());

        }
           cbCEmprestimoR.setSelectedIndex(-1);
    }

    private void add() {
        
        paneR.setLayout(layout);
        
        
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 0;
        cons.ipadx = 50;
        cons.fill = GridBagConstraints.HORIZONTAL;
        paneR.add(lbEmprestimo,cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 0;
        cons.gridwidth = 2;
        cons.ipadx = 70;
        cons.fill = GridBagConstraints.HORIZONTAL;
        paneR.add(cbCEmprestimoR,cons);
        
        
        
        
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
           EmprestimoDAO cDAO = new EmprestimoDAO();
            
            
            List<Emprestimo> emprestimo = cDAO.buscarEmprestimo();
            Emprestimo end = null;
            for (Emprestimo emp : emprestimo) {
                if (emp.getData() == cbCEmprestimoR.getSelectedItem()) {
                    end = emp;
                }
            }
            //obtendo todos os emp que possuem relacionamento com a fornecedor celecionada
            //List<Fornecedor> TodosFornecedores = null;
           // TodosFornecedores = eDAO.bu(fornecedor);

            //desasociando a fornecedor selecionada de todos os emp
          //  for (Item end : TodosFornecedores) {
          //      end.setFornecedor(null);
          //  }
            try {
                cDAO.deletar(end);
                JOptionPane.showMessageDialog(null,"Emprestimo deletado com sucesso");
            } catch (Exception ex) {
                Logger.getLogger(removerEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
}
