/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.trabalhoFinalProgII.View.Frame.principal.JTableAparencia;

import br.udesc.ceavi.trabalhoFinalProgII.Listeners.Jtable.Voltar;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Emprestimo;
import br.udesc.ceavi.trabalhoFinalProgII.View.Frame.principal.JMenus.Menu;
import br.udesc.ceavi.trabalhoFinalProgII.View.Frame.principal.JMenus.MenuEmprestimo;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.EmprestimoDAO;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author José Vargas Nolli
 */
public class EmprestimoTable extends JFrameTable {

    private JTable tabela;
    private JPanel panel;
    private JScrollPane pane;
    private DefaultTableModel dtm;
    private MenuEmprestimo barra;
    

    public EmprestimoTable(String titulo, Dimension tamanho) {
        super(titulo, tamanho);

        initCom();
        addTable();
        addListener();

    }

    private void initCom() {
        barra = new MenuEmprestimo(this);
        tabela = new JTable();
        tabela.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null,}

                },
                new String[]{
                    "Data do Emprestimo", "Item", "Requisitante"
                }
        ));

        dtm = (DefaultTableModel) tabela.getModel();
        panel = new JPanel();
        panel.setLayout(new GridLayout(1, 1));
        pane = new JScrollPane(tabela);
        //obtendo fornecedores do banco
        EmprestimoDAO eDAO = new EmprestimoDAO();
        List<Emprestimo> todosEmprestimos = null;
        todosEmprestimos = eDAO.buscarEmprestimo();

        String data,item,requisitante = null;
        for (Emprestimo e : todosEmprestimos) {
            //obtendo os dados
            data = e.getData();
            item = e.getItem().getNome();
            
            requisitante = e.getRequisitante().getNome();
            //adicionando na tabela
            String[] linhaDaTabela = new String[]{data, item, requisitante};
            dtm.addRow(linhaDaTabela);
        }

    }

    private void addTable() {
       
        panel.add(pane);
        super.add(panel);
        super.add(barra,BorderLayout.NORTH);
    
    }

    private void addListener() {
        JMenuItem it;
        ActionListener actionVoltar = new Voltar(this);
        it = barra.getVoltar();
        it.addActionListener(actionVoltar);
    }

}
