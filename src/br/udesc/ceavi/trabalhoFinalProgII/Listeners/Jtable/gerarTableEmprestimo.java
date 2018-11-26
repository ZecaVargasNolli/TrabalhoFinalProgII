/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.trabalhoFinalProgII.Listeners.Jtable;

import br.udesc.ceavi.trabalhoFinalProgII.Listeners.Gerar;
import br.udesc.ceavi.trabalhoFinalProgII.View.Frame.principal.JTableAparencia.EmprestimoTable;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

/**
 *
 * @author José Vargas Nolli
 */
public class gerarTableEmprestimo extends Gerar {

    
    private  EmprestimoTable frame = null;
    private EmprestimoTable frame2 = null;
    
    Dimension tamanho = new Dimension(800, 800);
    @Override
    public void actionPerformed(ActionEvent e) {
        
        
  
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
