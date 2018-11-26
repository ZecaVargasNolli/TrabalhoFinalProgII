/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.trabalhoFinalProgII.Listeners;

import br.udesc.ceavi.trabalhoFinalProgII.View.Frame.principal.FornecedorTable;
import br.udesc.ceavi.trabalhoFinalProgII.View.Frame.principal.ItemTable;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

/**
 *
 * @author José Vargas Nolli
 */
public class gerarTableFornecedor extends Gerar {

    private static final Dimension tamanho = new Dimension(800, 800);
    FornecedorTable frame = null;
    FornecedorTable frame2 = null;

    @Override
    public void actionPerformed(ActionEvent e) {

        if (frame == null && frame2 == null) {

            frame = new FornecedorTable("Tabela de Fornecedores", tamanho);

            frame2 = null;
            frame.setVisible(true);
        } else if (frame2 == null) {

            frame.setVisible(false);
            frame = null;

            frame2 = new FornecedorTable("Tabela de Itens", tamanho);

            frame2.setVisible(true);
        } else if (frame == null) {
            frame2.setVisible(false);
            frame = new FornecedorTable("Tabela de Itens", tamanho);

            frame2 = null;
            frame.setVisible(true);

        }
    }

}
