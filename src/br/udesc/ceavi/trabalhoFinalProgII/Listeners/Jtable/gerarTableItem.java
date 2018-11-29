package br.udesc.ceavi.trabalhoFinalProgII.Listeners.Jtable;

import br.udesc.ceavi.trabalhoFinalProgII.Listeners.Gerar;
import br.udesc.ceavi.trabalhoFinalProgII.View.Frame.principal.JTableAparencia.ItemTable;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;

/**
 * Listener responsável por gerar uma tabela com todos os itens no banco
 *
 * @author José Vargas Nolli
 * @author Gustavo José
 * @author Giancarlo Pandini
 * @since 29/11/2018
 * @version 1.0
 */
public class gerarTableItem extends Gerar {

    private static final Dimension tamanho = new Dimension(800, 800);
    private ItemTable frame = null;
    private ItemTable frame2 = null;
    private JFrame frameP;

    public gerarTableItem(JFrame frameP) {
        this.frameP = frameP;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        frameP.dispose();

        if (frame == null && frame2 == null) {

            frame = new ItemTable("Tabela de Itens", tamanho);

            frame2 = null;
            frame.setVisible(true);
        } else if (frame2 == null) {

            frame.setVisible(false);
            frame = null;

            frame2 = new ItemTable("Tabela de Itens", tamanho);

            frame2.setVisible(true);
        } else if (frame == null) {
            frame2.setVisible(false);
            frame = new ItemTable("Tabela de Itens", tamanho);

            frame2 = null;
            frame.setVisible(true);

        }
    }

}
