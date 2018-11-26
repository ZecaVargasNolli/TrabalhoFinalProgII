/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.trabalhoFinalProgII.Listeners;

import br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios.FrameCRUDGenerico;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author José Vargas Nolli
 */
public class CancelarLIstener implements ActionListener {

    private FrameCRUDGenerico frame;

    public CancelarLIstener(FrameCRUDGenerico frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int resposta = JOptionPane.showConfirmDialog(null, "Você realmente desejá fechar a janela?",
                "Confirmar Fechamento",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if (resposta == JOptionPane.YES_OPTION) {

            frame.dispose();
        }

    }

}
