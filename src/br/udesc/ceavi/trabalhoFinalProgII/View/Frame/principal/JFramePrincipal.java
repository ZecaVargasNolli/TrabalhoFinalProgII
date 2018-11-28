/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.trabalhoFinalProgII.View.Frame.principal;

import br.udesc.ceavi.trabalhoFinalProgII.Listeners.FramePrincipal.Relogin;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.FramePrincipal.Sair;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.Jtable.gerarTableEmprestimo;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.Jtable.gerarTableFornecedor;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.Jtable.gerarTableItem;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author José Vargas Nolli
 */
public class JFramePrincipal extends JFrame {

    private LayoutManager layout;
    private JPanel panelP;

    private JButton btSair;
    private JButton btTrocarUsuario;
    private JButton btTabelaEmprestimo;
    private JButton btTabelaFornecedor;
    private JButton btItem;
    private JButton btAjuda;

    private Label lbB;

    Dimension tamanhoBT;
    Dimension tamanhoF;

    GridBagConstraints cons;

    public JFramePrincipal() {

        initCom();
        addCom();
      addLIstener();
        super.setSize(tamanhoF);
        super.setLayout(layout);
        super.setTitle("CELLA");
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        super.setVisible(true);
    }

    private void initCom() {
        tamanhoF = new Dimension(400, 400);
        lbB = new Label();
        lbB.setSize(200, 30);

        btAjuda = new JButton("AJUDA");
        btItem = new JButton("TABELA DE ITENS");
        btSair = new JButton("SAIR");
        btTabelaEmprestimo = new JButton("TABELA DE EMPRÉSTIMOS");
        btTabelaFornecedor = new JButton("TABELA DE FORNECEDORES");
        btTrocarUsuario = new JButton("TROCAR USUÁRIO");

        tamanhoBT = new Dimension(100, 50);

        layout = new GridBagLayout();

        panelP = new JPanel(layout);
        panelP.setSize(tamanhoF);
    }

    private void addCom() {
        btAjuda.setSize(tamanhoBT);
        btItem.setSize(tamanhoBT);
        btSair.setSize(tamanhoBT);
        btTabelaEmprestimo.setSize(tamanhoBT);
        btTabelaFornecedor.setSize(tamanhoBT);
        btTrocarUsuario.setSize(tamanhoBT);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 6;

        cons.fill = GridBagConstraints.HORIZONTAL;
        panelP.add(btTrocarUsuario, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 7;

        cons.fill = GridBagConstraints.HORIZONTAL;
        panelP.add(lbB, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 8;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelP.add(btAjuda, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 9;

        cons.fill = GridBagConstraints.HORIZONTAL;
        panelP.add(lbB, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 10;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelP.add(btSair, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 5;

        cons.fill = GridBagConstraints.HORIZONTAL;
        panelP.add(lbB, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 0;

        cons.fill = GridBagConstraints.HORIZONTAL;
        panelP.add(btItem, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 1;
        cons.ipadx = 100;
        cons.ipady = 50;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelP.add(lbB, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 2;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelP.add(btTabelaEmprestimo, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 3;

        cons.fill = GridBagConstraints.HORIZONTAL;
        panelP.add(lbB, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 4;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelP.add(btTabelaFornecedor, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 5;

        cons.fill = GridBagConstraints.HORIZONTAL;
        panelP.add(lbB, cons);

        super.add(panelP);

    }

    private void addLIstener() {
        ActionListener actionSair = new Sair();
        btSair.addActionListener(actionSair);
        ActionListener actionItem = new gerarTableItem();
        btItem.addActionListener(actionItem);
        ActionListener actionFornecedor = new gerarTableFornecedor();
        btTabelaFornecedor.addActionListener(actionFornecedor);
        ActionListener actionS = new Relogin(this);
        btTrocarUsuario.addActionListener(actionS);
        ActionListener actionEmprestimo = new  gerarTableEmprestimo();
        btTabelaEmprestimo.addActionListener(actionEmprestimo);
        
    }

}
