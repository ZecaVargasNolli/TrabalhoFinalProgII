/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.trabalhoFinalProgII.Listeners.FramePrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author José Vargas Nolli
 */
public class Ajuda  implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {

        JOptionPane.showMessageDialog(null,"Em caso de problemas, entrar em contato com o suporte \n através do email: suporte.cella@udesc.br \n ou telefone: (47)999233104");
    }
    
}
