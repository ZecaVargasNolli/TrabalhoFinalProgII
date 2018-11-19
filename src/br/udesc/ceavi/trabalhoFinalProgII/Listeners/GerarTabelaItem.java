/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.trabalhoFinalProgII.Listeners;

import br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios.TabelaItem;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;

/**
 *
 * @author José Vargas Nolli
 */
public class GerarTabelaItem  extends Gerar{

    @Override
    public void actionPerformed(ActionEvent e) {
       GerarTabelaItem teste = new GerarTabelaItem();
        Thread t = new Thread(teste);

        t.start();
    }

    @Override
    public void run() {
       
        Dimension tamanho = new Dimension(550,550);
         JFrame frame = new TabelaItem(tamanho, "Tabela de Itens");
       
         frame.setVisible(true);
    }
    
}
