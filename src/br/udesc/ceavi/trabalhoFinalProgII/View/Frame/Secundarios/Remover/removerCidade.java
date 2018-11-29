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
public class removerCidade extends FrameRemover {

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
        paneR.add(lbCidade, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 0;
        cons.gridwidth = 2;
        cons.ipadx = 70;
        cons.fill = GridBagConstraints.HORIZONTAL;
        paneR.add(cbCidadeR, cons);

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
            EnderecoDAO eDAO = new EnderecoDAO();
            CidadeDAO cDAO = new CidadeDAO();

            //obtendo as cidades do banco
            List<Cidade> todasCidades = null;
            todasCidades = cDAO.buscarCidade();
            //selecionando a cidade desejada
            Cidade cidade = null;
            for (Cidade c : todasCidades) {
                if (c.getNomeCidade() == cbCidadeR.getSelectedItem()) {
                    cidade = c;
                }
            }

            //obtendo todos os enderecos que possuem relacionamento com a cidade celecionada
            List<Endereco> todosEnderecos = null;
            todosEnderecos = eDAO.buscarEnderecoPorCidade(cidade);

            //desasociando a cidade selecionada de todos os enderecos
            for (Endereco end : todosEnderecos) {
                end.setCidade(null);
            }

            try {
                //atualizando os enderecos no banco
                for (Endereco end : todosEnderecos) {
                    eDAO.atualizar(end);
                }
                //finalmente removendo a cidade 
                cDAO.deletar(cidade);
                JOptionPane.showMessageDialog(null, "cidade deletada com sucesso");
            } catch (Exception ex) {

            }

        }

    }
}
