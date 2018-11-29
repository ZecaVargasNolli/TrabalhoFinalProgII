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
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Fornecedor;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Item;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.ItemDAO;
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
public class removerFornecedor extends FrameRemover {

    private Label lbFornecedor;
    private JComboBox cbFornecedorR;
    private LayoutManager layout;
    private JPanel paneR;
    private GridBagConstraints cons;

    public removerFornecedor(String titulo, Dimension tamanho) {
        super(titulo, tamanho);

        initCom();
        iniCombo();
        add();
        addListener();
    }

    private void initCom() {
        lbFornecedor = new Label("FORNECEDORES: ");
        paneR = new JPanel();
        layout = new GridBagLayout();
    }

    private void iniCombo() {
        cbFornecedorR = new JComboBox();
        FornecedorDAO dao = new FornecedorDAO();

        List<Fornecedor> fornecedores;

        fornecedores = dao.buscarFornecedor();

        for (int i = 0; i < fornecedores.size(); i++) {
            cbFornecedorR.addItem(fornecedores.get(i).getNomeDaEmpresa());

        }
        cbFornecedorR.setSelectedIndex(-1);
    }

    private void add() {

        paneR.setLayout(layout);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 0;
        cons.ipadx = 50;
        cons.fill = GridBagConstraints.HORIZONTAL;
        paneR.add(lbFornecedor, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 0;
        cons.gridwidth = 2;
        cons.ipadx = 70;
        cons.fill = GridBagConstraints.HORIZONTAL;
        paneR.add(cbFornecedorR, cons);

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
            ItemDAO eDAO = new ItemDAO();
            FornecedorDAO cDAO = new FornecedorDAO();

            //obtendo as fornecedores do banco
            List<Fornecedor> todosFornecedores = null;
            todosFornecedores = cDAO.buscarFornecedor();
            //selecionando a fornecedor desejada
            Fornecedor fornecedor = null;
            for (Fornecedor c : todosFornecedores) {
                if (c.getNomeDaEmpresa()== cbFornecedorR.getSelectedItem()) {
                    fornecedor = c;
                }
            }

            //obtendo todos os enderecos que possuem relacionamento com a fornecedor celecionada
            List<Item> todosItems = null;
            todosItems = eDAO.buscarItemPorFornecedor(fornecedor);

            //desasociando a fornecedor selecionada de todos os enderecos
            for (Item end : todosItems) {
                end.setFornecedor(null);
            }

            try {
                //atualizando os enderecos no banco
                for (Item end : todosItems) {
                    eDAO.atualizar(end);
                }
                //finalmente removendo a fornecedor 
                cDAO.deletar(fornecedor);
                JOptionPane.showMessageDialog(null, "Fornecedor deletado com sucesso");
            } catch (Exception ex) {

            }

        }

    }
}
