/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.trabalhoFinalProgII.View.Frame.principal;

import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.CidadeDAO;
import javax.swing.JTable;
import java.util.List;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Cidade;
import br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios.FrameCRUDGenerico;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.FornecedorDAO;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.ScrollPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Fornecedor;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.ItemDAO;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Item;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;

/**
 *
 * @author José Vargas Nolli
 */
public class ItemTable extends JFrameTable {

    private JTable tabela;
    private JPanel panel;
    private JScrollPane pane;
    private DefaultTableModel dtm;
    private JMenuBar barra;

    public ItemTable(String titulo, Dimension tamanho) {
        super(titulo, tamanho);

        initCom();

        addTable();

    }

    private void initCom() {
        barra = new MenuItem(this);
        tabela = new JTable();
        tabela.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{  {null,null,null,null,null}
                
                },
                new String[]{
                    "Nome", "Data de Aquisição", "Em Estoque", "Tipo", "Nome do Fornecedor"
                }
        ));

        dtm = (DefaultTableModel) tabela.getModel();
        panel = new JPanel();
        panel.setLayout(new GridLayout(1, 1));
        pane = new JScrollPane(tabela);
        ItemDAO dao = new ItemDAO();
        List<Item> cid = dao.buscarItem();
        
        
        for (int i = 0; i < cid.size(); i++) {

            String Nome = cid.get(i).getNome();
            String dataDeAquisicao = cid.get(i).getDatadeAquisicao();
            String fornecedor = "Fornecido";
            String tipo = "coisa";
            String estado = null;
            if (cid.get(i).isEmEstoque() == true) {
                estado = "Em Estoque";
            } else if (cid.get(i).isEmEstoque() == false) {
                estado = "Emprestado";
            }

            dtm.addRow(new String[]{Nome, dataDeAquisicao, estado,tipo, fornecedor});

        }

    }

    private void addTable() {
        panel.add(pane);
        super.add(panel);
        super.add(barra, BorderLayout.NORTH);
    }

   
}