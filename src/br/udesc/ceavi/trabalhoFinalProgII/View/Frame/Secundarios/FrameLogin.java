/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author José Vargas Nolli
 */
public class FrameLogin extends JFrame {
    
    
    private JPanel panelPrincipal;
    private JButton Login;
    private JLabel lbLogin;
    private JLabel lbPassword;
    private JTextField txLogin;
    
    private JLabel lbBranco;
    private JLabel lbBranco2;
    private JLabel lbBranco3;
    private JLabel lbBranco4;
    
   
    private JPasswordField txPassword;
    Dimension tamanho = new Dimension(250,170);
    Dimension BotaoTamanho;
    
    LayoutManager layout ;
    
    GridBagConstraints cons;

    public FrameLogin() {
        
        initCom();
        addCom();
        
        super.setSize(tamanho);       
        super.setTitle("Login do Sistema Cella");
        super.setLayout(layout);
       super.setResizable(false);
       super.setLocationRelativeTo(null);
       
    }
    
   

    private void initCom() {
       txLogin = new  JTextField("Usuário");
       txPassword = new JPasswordField();
       lbLogin = new JLabel("USUÁRIO: ");
       lbPassword = new JLabel("SENHA: ");
       Login = new JButton("LOGIN");
       BotaoTamanho = new Dimension(100,30);
       layout = new GridBagLayout();
       
       
       
       panelPrincipal = new JPanel(layout);
       
       
       lbBranco = new JLabel();
       lbBranco2 = new JLabel();
       lbBranco3 = new JLabel();
       lbBranco4 = new JLabel();
       
       
       
       
       
    }

    private void addCom() {
       
        
        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 0;
        cons.gridwidth = 1;
        cons.gridheight = 1;
        cons.ipadx = 50;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelPrincipal.add(lbLogin,cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 2;
        cons.gridy = 0;
        cons.gridwidth = 2;
        cons.gridheight = 2;
        cons.ipadx = 50;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelPrincipal.add(txLogin,cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 2;
        cons.ipadx = 100;
        cons.ipady = 10;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelPrincipal.add(lbBranco,cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 2;
        cons.gridy = 2;
        cons.ipadx = 100;
        cons.ipady = 10;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelPrincipal.add(lbBranco2,cons);
        
        
        
        
        
        
        
        
        
        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 3;
        cons.gridwidth = 2;
        cons.gridheight = 1;
        cons.ipadx =50;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelPrincipal.add(lbPassword,cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 2;
        cons.gridy = 3;
        cons.gridwidth = 2;
        cons.gridheight = 2;
        cons.ipadx =50;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelPrincipal.add(txPassword,cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 4;
        cons.gridwidth = 3;
        cons.gridheight = 2;
        cons.ipadx = 200;
        cons.ipady = 100;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelPrincipal.add(lbBranco3,cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 2;
        cons.gridy = 4;
        cons.gridwidth = 3;
        cons.gridheight = 2;
        cons.ipadx = 200;
        cons.ipady = 100;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelPrincipal.add(lbBranco4,cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 5;
        cons.gridwidth = 3;
        cons.gridheight = 2;
        cons.ipady = 30;
        cons.ipadx = 200;
        cons.fill = GridBagConstraints.SOUTH;
        panelPrincipal.add(Login,cons);
        
        
        
        super.add(panelPrincipal);
    }

    public JTextField getTxLogin() {
        return txLogin;
    }

    public void setTxLogin(JTextField txLogin) {
        this.txLogin = txLogin;
    }

    public JPasswordField getTxPassword() {
        return txPassword;
    }

    public void setTxPassword(JPasswordField txPassword) {
        this.txPassword = txPassword;
    }

    public JButton getLogin() {
        return Login;
    }

    public void setLogin(JButton Login) {
        this.Login = Login;
    }
    
    
    
    
}