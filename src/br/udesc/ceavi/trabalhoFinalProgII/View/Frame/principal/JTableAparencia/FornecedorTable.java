package br.udesc.ceavi.trabalhoFinalProgII.View.Frame.principal.JTableAparencia;

import br.udesc.ceavi.trabalhoFinalProgII.Listeners.Jtable.Voltar;
import javax.swing.JTable;
import java.util.List;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Endereco;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.FornecedorDAO;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Fornecedor;
import br.udesc.ceavi.trabalhoFinalProgII.View.Frame.principal.JMenus.MenuFornecedor;

import java.awt.BorderLayout;

import javax.swing.JMenuItem;

/**
 *
 * Classe responsavel pela formatação da tabela fe fornecedor
 *
 * @author José Vargas Nolli
 * @author Giancarlo Pandini
 * @author Gustavo josé
 * @since 29/11/2018
 * @version 1.0
 */
public class FornecedorTable extends JFrameTable {

    private JTable tabela;
    private JPanel panel;
    private JScrollPane pane;
    private DefaultTableModel dtm;
    private MenuFornecedor barra;

    public FornecedorTable(String titulo, Dimension tamanho) {
        super(titulo, tamanho);

        initCom();
        addTable();
        addListener();

    }

    private void initCom() {
        barra = new MenuFornecedor(this);
        tabela = new JTable();
        tabela.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null}

                },
                new String[]{
                    "Nome da Empresa", "CNPJ", "Endereço_Cep"
                }
        ));

        dtm = (DefaultTableModel) tabela.getModel();
        panel = new JPanel();
        panel.setLayout(new GridLayout(1, 1));
        pane = new JScrollPane(tabela);
        FornecedorDAO dao = new FornecedorDAO();
        List<Fornecedor> cid = dao.buscarFornecedor();
        Endereco endereco = null;

        String NomeEmpresa, CNPJ, end = null;
        for (int i = 0; i < cid.size(); i++) {

            NomeEmpresa = cid.get(i).getNomeDaEmpresa();
            CNPJ = cid.get(i).getCnpj();
            endereco = cid.get(i).getEndereco();
            if (endereco == null) {
            } else {
                end = endereco.getCep();
            }

            dtm.addRow(new String[]{NomeEmpresa, CNPJ, end});

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
