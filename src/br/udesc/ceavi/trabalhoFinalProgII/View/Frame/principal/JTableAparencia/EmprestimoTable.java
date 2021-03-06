package br.udesc.ceavi.trabalhoFinalProgII.View.Frame.principal.JTableAparencia;

import br.udesc.ceavi.trabalhoFinalProgII.Listeners.Jtable.Voltar;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Emprestimo;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Requisitante;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Item;

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
 * Esta classe é responsavl pela formatação da tabela de emprestimo
 *
 * @author José Vargas Nolli
 * @author Giancarlo Pandini
 * @author Gustavo josé
 * @since 29/11/2018
 * @version 1.0
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
        Item it = null;
        Requisitante requi = null;
        String data = null, item = null, requisitante = null;
        for (Emprestimo e : todosEmprestimos) {
            //obtendo os dados
            data = e.getData();
            it = e.getItem();
            if (it == null) {

            } else {
                item = it.getNome();
            }

            requi = e.getRequisitante();
            if (requi == null) {

            } else {
                requisitante = requi.getNome();
            }
            //adicionando na tabela
            String[] linhaDaTabela = new String[]{data, item, requisitante};
            dtm.addRow(linhaDaTabela);
        }

    }

    private void addTable() {

        panel.add(pane);
        super.add(panel);
        super.add(barra, BorderLayout.NORTH);

    }

    private void addListener() {
        JMenuItem it;
        ActionListener actionVoltar = new Voltar(this);
        it = barra.getVoltar();
        it.addActionListener(actionVoltar);
    }

}
