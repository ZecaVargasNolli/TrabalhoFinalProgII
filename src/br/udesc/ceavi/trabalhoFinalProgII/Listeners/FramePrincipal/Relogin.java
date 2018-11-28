/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.trabalhoFinalProgII.Listeners.FramePrincipal;

import br.udesc.ceavi.trabalhoFinalProgII.Listeners.GerarUsuario;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Usuario;
import br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios.FrameLogin;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.UsuarioDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author José Vargas Nolli
 */
public class Relogin implements ActionListener {

    JFrame frame;
    UsuarioDAO uDAO = new UsuarioDAO();

    public Relogin(JFrame frame) {
        this.frame = frame;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
            Usuario user = uDAO.buscarUsuarioLogado();

        user.setLogado(false);
        try {
            uDAO.atualizar(user);
        } catch (Exception ex) {
            Logger.getLogger(GerarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        frame.dispose();
        FrameLogin log = new FrameLogin();
        log.setVisible(true);
       
    }
    
}
