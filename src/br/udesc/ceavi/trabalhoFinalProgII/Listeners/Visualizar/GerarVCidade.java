/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.trabalhoFinalProgII.Listeners.Visualizar;


import br.udesc.ceavi.trabalhoFinalProgII.Listeners.FramePrincipal.LoginListener;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.Gerar;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Usuario;
import br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios.removerCidade;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.UsuarioDAO;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author José Vargas Nolli
 */
public class GerarVCidade  extends Gerar{
    
    Dimension tamanho = new Dimension(300, 250);
    JFrame frame = null;
    JFrame frame2 = null;
    UsuarioDAO userDAO = new UsuarioDAO();
    Usuario user = userDAO.buscarUsuarioLogado();
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (user.isMaster() == true) {
            
        
        
        if (frame == null && frame2 == null) {

            frame = new removerCidade("Visualizar Cidade", tamanho);
            
            frame2 = null;
            frame.setVisible(true);
        } else if (frame2 == null) {

            frame.setVisible(false);
            frame = null;

            frame2 = new removerCidade("Visualizar Cidade", tamanho);
            

            frame2.setVisible(true);
        } else if (frame == null) {
            frame2.setVisible(false);
            
            frame = new removerCidade("Visualizar Cidade", tamanho);
            frame2 = null;
            frame.setVisible(true);
        }
        } else {
            JOptionPane.showMessageDialog(null,"Você não tem permissão para isso");
        }
}
}