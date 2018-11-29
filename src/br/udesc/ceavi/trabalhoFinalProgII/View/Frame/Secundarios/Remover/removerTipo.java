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
import br.udesc.ceavi.trabalhoFinalProgII.Model.Tipo;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Fornecedor;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Item;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.ItemDAO;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.TipoDAO;
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
public class removerTipo extends FrameRemover {

    private Label lbTipo;
    private JComboBox cbTipoR;
    private LayoutManager layout;
    private JPanel paneR;
    private GridBagConstraints cons;

    public removerTipo(String titulo, Dimension tamanho) {
        super(titulo, tamanho);

        initCom();
        iniCombo();
        add();
        addListener();
    }

    private void initCom() {
        lbTipo = new Label("TIPOS: ");
        paneR = new JPanel();
        layout = new GridBagLayout();
    }

    private void iniCombo() {
        cbTipoR = new JComboBox();
        TipoDAO dao = new TipoDAO();

        List<Tipo> Tipos;

        Tipos = dao.buscarTipo();

        for (int i = 0; i < Tipos.size(); i++) {
            cbTipoR.addItem(Tipos.get(i).getNome());

        }
        cbTipoR.setSelectedIndex(-1);
    }

    private void add() {

        paneR.setLayout(layout);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 0;
        cons.ipadx = 50;
        cons.fill = GridBagConstraints.HORIZONTAL;
        paneR.add(lbTipo, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 0;
        cons.gridwidth = 2;
        cons.ipadx = 70;
        cons.fill = GridBagConstraints.HORIZONTAL;
        paneR.add(cbTipoR, cons);

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
            TipoDAO cDAO = new TipoDAO();

            //obtendo as Tipos do banco
            List<Tipo> todosTipos = null;
            todosTipos = cDAO.buscarTipo();
            //selecionando a fornecedor desejada
            Tipo it = null;
            for (Tipo c : todosTipos) {
                if (c.getNome()== cbTipoR.getSelectedItem()) {
                  it = c;
                }
            }

            //obtendo todos os enderecos que possuem relacionamento com a fornecedor celecionada
            List<Item> todosItems = null;
            todosItems = eDAO.buscarItemPorTipo(it);

            //desasociando a fornecedor selecionada de todos os enderecos
            for (Item end : todosItems) {
                end.setTipo(null);
            }

            try {
                //atualizando os enderecos no banco
                for (Item end : todosItems) {
                    eDAO.atualizar(end);
                }
                //finalmente removendo a fornecedor 
                cDAO.deletar(it);
                JOptionPane.showMessageDialog(null, "Tipo deletado com sucesso");
            } catch (Exception ex) {

            }

        }

    }
}
