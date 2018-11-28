/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.trabalhoFinalProgII.Listeners.FramePrincipal;


import br.udesc.ceavi.trabalhoFinalProgII.Model.Usuario;
import br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios.FrameLogin;
import br.udesc.ceavi.trabalhoFinalProgII.View.Frame.principal.JFramePrincipal;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.UsuarioDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo
 */
public class LoginListener implements ActionListener{

    UsuarioDAO admin = new UsuarioDAO();
    FrameLogin fram;
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Usuario user = admin.getUsuario(fram.getTxLogin().getText(),fram.getTxPassword().getText());
        
        if(user != null){
            
             JFrame frame = new JFramePrincipal();
             fram.setVisible(false);
             fram = null;
             
        } else {
            JOptionPane.showMessageDialog(null, "Usuário não existente");
        }
        
    }

    public LoginListener(FrameLogin fram) {
        this.fram = fram;
    }
    
}
