/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios.Remover;

import br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios.Remover.FrameRemover;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.CancelarListener;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Cidade;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Endereco;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.CidadeDAO;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.EnderecoDAO;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.FornecedorDAO;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Requisitante;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Emprestimo;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Fornecedor;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Item;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.EmprestimoDAO;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.ItemDAO;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.RequisitanteDAO;
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
public class removerRequisitante extends FrameRemover {

    private Label lbRequisitante;
    private JComboBox cbRequisitanteR;
    private LayoutManager layout;
    private JPanel paneR;
    private GridBagConstraints cons;

    public removerRequisitante(String titulo, Dimension tamanho) {
        super(titulo, tamanho);

        initCom();
        iniCombo();
        add();
        addListener();
    }

    private void initCom() {
        lbRequisitante = new Label("REQUISITANTES: ");
        paneR = new JPanel();
        layout = new GridBagLayout();
    }

    private void iniCombo() {
        cbRequisitanteR = new JComboBox();
        RequisitanteDAO dao = new RequisitanteDAO();

        List<Requisitante> requisitantes;

        requisitantes = dao.buscarRequisitante();

        for (int i = 0; i < requisitantes.size(); i++) {
            cbRequisitanteR.addItem(requisitantes.get(i).getNome());

        }
        cbRequisitanteR.setSelectedIndex(-1);
    }

    private void add() {

        paneR.setLayout(layout);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 0;
        cons.ipadx = 50;
        cons.fill = GridBagConstraints.HORIZONTAL;
        paneR.add(lbRequisitante, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 0;
        cons.gridwidth = 2;
        cons.ipadx = 70;
        cons.fill = GridBagConstraints.HORIZONTAL;
        paneR.add(cbRequisitanteR, cons);

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

    public class Remover implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // instanciando DAO nessessarias 
            RequisitanteDAO eDAO = new RequisitanteDAO();
            EmprestimoDAO cDAO = new EmprestimoDAO();

            //obtendo as requisitantes do banco
            List<Requisitante> todosRequisitante = null;
            todosRequisitante = eDAO.buscarRequisitante();
            //selecionando a requisitante desejada
            Requisitante requisitante = null;
            for (Requisitante c : todosRequisitante) {
                if (c.getNome()== cbRequisitanteR.getSelectedItem()) {
                    requisitante = c;
                }
            }

            //obtendo todos os enderecos que possuem relacionamento com a requisitante celecionada
            List<Emprestimo> todosEmprestimos = null;
            todosEmprestimos = cDAO.buscarEmprestimoPorRequisitante(requisitante);

            //desasociando a requisitante selecionada de todos os enderecos
            for (Emprestimo end : todosEmprestimos) {
              end.setRequisitante(null);
           }

            try {
                //atualizando os enderecos no banco
                for (Emprestimo emp : todosEmprestimos) {
                   cDAO.atualizar(emp);
                }
                //finalmente removendo a requisitante 
                eDAO.deletar(requisitante);
                JOptionPane.showMessageDialog(null, "Requisitante deletado com sucesso");
            } catch (Exception ex) {

            }

        }

    }
}
