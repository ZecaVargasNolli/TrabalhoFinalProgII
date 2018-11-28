/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.trabalhoFinalProgII.Listeners.Jtable;

import br.udesc.ceavi.trabalhoFinalProgII.Listeners.Gerar;
import br.udesc.ceavi.trabalhoFinalProgII.View.Frame.principal.JTableAparencia.FornecedorTable;
import br.udesc.ceavi.trabalhoFinalProgII.View.Frame.principal.JTableAparencia.ItemTable;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;

/**
 *
 * @author José Vargas Nolli
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
