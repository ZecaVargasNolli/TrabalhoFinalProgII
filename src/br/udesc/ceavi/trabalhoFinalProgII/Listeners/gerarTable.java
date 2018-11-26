/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.trabalhoFinalProgII.Listeners;

import br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios.Table;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

/**
 *
 * @author José Vargas Nolli
 */
public class gerarTable extends Gerar {
 private static  Dimension tamanho = new Dimension(500, 800);
    @Override
    public void actionPerformed(ActionEvent e) {
        
       Table ta = new Table("Lista de Cidades", tamanho);
       ta.setVisible(true);
    }
    
}
