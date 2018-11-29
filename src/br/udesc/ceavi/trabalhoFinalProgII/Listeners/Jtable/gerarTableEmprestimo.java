
package br.udesc.ceavi.trabalhoFinalProgII.Listeners.Jtable;

import br.udesc.ceavi.trabalhoFinalProgII.Listeners.Gerar;
import br.udesc.ceavi.trabalhoFinalProgII.View.Frame.principal.JTableAparencia.EmprestimoTable;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;

/**
 * Listener responsável por gerar uma tabela com todos emprestimos no banco
 *
 * @author José Vargas Nolli
 * @author Giancarlo Pandini
 * @author Gustavo José
 * @since 29/11/2018
 * @version 1.0
 *
 */
public class gerarTableEmprestimo extends Gerar {

    private JFrame frameP;
    private EmprestimoTable frame = null;
    private EmprestimoTable frame2 = null;

    Dimension tamanho = new Dimension(800, 800);

    public gerarTableEmprestimo(JFrame frameP) {
        this.frameP = frameP;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        frameP.dispose();

        if (frame == null && frame2 == null) {

            frame = new EmprestimoTable("Tabela de Fornecedores", tamanho);

            frame2 = null;
            frame.setVisible(true);
        } else if (frame2 == null) {

            frame.setVisible(false);
            frame = null;

            frame2 = new EmprestimoTable("Tabela de Empréstimos", tamanho);

            frame2.setVisible(true);
        } else if (frame == null) {
            frame2.setVisible(false);
            frame = new EmprestimoTable("Tabela de Empréstimos", tamanho);

            frame2 = null;
            frame.setVisible(true);

        }
    }

}
