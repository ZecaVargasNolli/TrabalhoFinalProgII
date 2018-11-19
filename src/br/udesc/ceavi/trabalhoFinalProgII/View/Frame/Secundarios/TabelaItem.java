package br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios;

import br.udesc.ceavi.trabalhoFinalProgII.dao.core.JPADAO;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.sql.Connection;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author José Vargas Nolli
 */
public class TabelaItem extends JFrame {

    private JTable table;

    private JPanel panelTabela;

    private JScrollPane sroll;

    public TabelaItem(Dimension tamanho, String titulo) {

        comP();

        super.setSize(tamanho);
        super.setTitle(titulo);
        super.setResizable(false);
        super.setLocationRelativeTo(null);
        super.setVisible(true);

    }

    private void comP() {

        Object[][] dados = { //    {"coisa",1234,"23/04/2018"}
        };

        String[] colunas = {"Nome", "Tipo", "Fornecedor"};

        panelTabela = new JPanel();
        panelTabela.setLayout(new GridLayout(1, 1));

        table = new JTable(dados, colunas);

        sroll = new JScrollPane(table);

        panelTabela.add(sroll);
        super.add(panelTabela);

    }

   

}
