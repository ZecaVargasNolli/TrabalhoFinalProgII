
package br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 *
 * @author José Vargas Nolli
 */
public class viewTable extends JFrame {
    
    
    private JPanel panelTable;
    private LayoutManager layout;
    private Dimension tamanho;
    private JTable tableItem;

    public viewTable() {
      initCom();
      
        
       table t = new table();
       tableItem.setModel(t);
       addCom();
       super.setSize(tamanho);
       super.setVisible(true);
        
        
    }

    private void initCom() {
       
       tableItem = new JTable();
       tamanho = new Dimension(500, 500);
       layout = new GridLayout(1, 1);
       panelTable = new JPanel(layout);
    }

    private void addCom() {
        panelTable.add(tableItem);
        super.add(panelTable);
    }
    
   
    
}
