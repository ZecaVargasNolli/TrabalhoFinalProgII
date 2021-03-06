package br.udesc.ceavi.trabalhoFinalProgII.Listeners;

import br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios.FrameCRUDcidade;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

/**
 * Classe listener responsável por gerar o JFrame que corresponde ao cadastro de
 * cidade. e tambem o evento associado ao JMenuItem que representa o cadastro de
 * Cidade
 *
 * @author José Vargas Nolli
 * @author Gustavo José
 * @author Giancarlo Pandini
 *
 * @since 17/11/2018
 * @version 1.0
 */
public class GerarCidade extends Gerar {

    Dimension tamanho = new Dimension(350, 250);
    FrameCRUDcidade frame = null;

    @Override//EVENTOS RESPONSÁVEL PELO  APARECIMENTO DA TELA CADASTRO CIDADE
    public void actionPerformed(ActionEvent e) {

        if (frame == null) {
            frame = new FrameCRUDcidade("Cadastro de Cidade", tamanho);

            CancelarListener liste = new CancelarListener(frame);

            frame.getPanelBotoes().getBtCancelar().addActionListener(liste);
        }

        frame.setVisible(true);

    }

}
