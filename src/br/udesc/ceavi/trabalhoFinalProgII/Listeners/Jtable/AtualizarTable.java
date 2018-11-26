/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.trabalhoFinalProgII.Listeners.Jtable;

import br.udesc.ceavi.trabalhoFinalProgII.View.Frame.principal.JTableAparencia.JFrameTable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author José Vargas Nolli
 */
public class AtualizarTable  implements ActionListener{
    
    JFrameTable table;

    public AtualizarTable(JFrameTable table) {
        this.table = table;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        table.dispose();
       
    }
    
}
