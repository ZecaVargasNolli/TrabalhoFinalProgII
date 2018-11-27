/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.trabalhoFinalProgII.View.Frame.principal.JTableAparencia;

import br.udesc.ceavi.trabalhoFinalProgII.Model.Emprestimo;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.EmprestimoDAO;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

//NÃO UTILIZAR AINDA PORQUE PRECISA SER FEITO.
/**
 *
 * @author José Vargas Nolli
 */
public class EmprestimoTable extends JFrameTable {

    private JTable tabela;
    private JPanel panel;
    private JScrollPane pane;
    private DefaultTableModel dtm;
    

    public EmprestimoTable(String titulo, Dimension tamanho) {
        super(titulo, tamanho);

        initCom();
        addTable();

    }

    private void initCom() {
        tabela = new JTable();
        tabela.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null}

                },
                new String[]{
                    "Data do Emprestimo", "Item", "Usuario", "Requisitante"
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

        for (Emprestimo e : todosEmprestimos) {
            //obtendo os dados
            String data = e.getData();
            String item = e.getItem().getNome();
            String usuario = e.getUsuario().getNome();
            String requisitante = e.getRequisitante().getNome();
            //adicionando na tabela
            String[] linhaDaTabela = new String[]{data, item, usuario, requisitante};
            dtm.addRow(linhaDaTabela);
        }

    }

    private void addTable() {
        panel.add(pane);
        super.add(panel);
    }

}
