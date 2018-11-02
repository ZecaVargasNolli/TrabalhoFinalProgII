package br.udesc.ceavi.trabalhoFinalProgII.View.Frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.LayoutManager;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Esta classe representa o menu principal, apenas o prototipo.
 *
 * @author José Vargas Nolli
 */
public class FrameMenu extends JFrame {

    private JLabel Menu;
    private JPanel panelPrincipal;
    private JLabel label;
    private LayoutManager layout;

    private Dimension dimensao;
    private Dimension dimensao2;
    
    private static String titulo = "Cella";
    
    private Menus menu = new Menus(this);

    public FrameMenu() {

        dimensao = new Dimension(900, 900);
        dimensao2 = new Dimension(850,850);
        
        layout = new BorderLayout();

        InitComponentes();

        addCom();

        super.setVisible(true);
        super.setTitle(titulo);
        super.setSize(dimensao);
        super.setLayout(layout);
        super.setResizable(true);
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
       
    }

    private void InitComponentes() {
       
   panelPrincipal = new JPanel();
  ImageIcon ico = new  ImageIcon("C:\\Users\\José Vargas Nolli\\Documents\\NetBeansProjects\\TrabalhoFinalProgII\\src\\br\\udesc\\ceavi\\trabalhoFinalProgII\\maxresdefault.jpg");
  
  Menu = new JLabel(ico);
  Menu.setSize(dimensao2);
   panelPrincipal.setLayout(layout);
   panelPrincipal.add(Menu);
   
  
   
    
    }

    private void addCom() {
        this.setContentPane(panelPrincipal);
        panelPrincipal.add(menu,BorderLayout.NORTH);
        
    
    }

}