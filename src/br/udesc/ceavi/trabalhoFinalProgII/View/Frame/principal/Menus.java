
package br.udesc.ceavi.trabalhoFinalProgII.View.Frame.principal;

import br.udesc.ceavi.trabalhoFinalProgII.Listeners.GerarCidade;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.GerarFornecedor;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.GerarTipo;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *Classe que é a barra de menu da aplicação, responsavel por controlar todos os itens de menu associados 
 * a classe principal.
 * 
 * @author José Vargas Nolli
 */
public class Menus extends JPanel {
    

    
    
    
    private JMenu Cadastro;
    private JMenu Pesquisa;
    private JMenu Ajuda;
    private JMenuBar menu;
    private JMenuItem CadastroFornecedor;
    private JMenuItem CadastroItem;
    private JMenuItem CadastroEndereco;
    private JMenuItem CadastroCidade;
    private JMenuItem CadastroRequsitante;
    private JMenuItem CadastroUsuario;
    private JMenuItem CadastroTipo;
    
    private static FrameMenu frame;
    
    private Container parent;
    private LayoutManager layout;
    
    private Dimension dimensao;
    
    private FrameMenu frameM;

    public FrameMenu getFrame() {
        return frameM;
    }

    public Menus(Container parent) {
      this.parent = parent;  
        
        InitCom();
        addCom();
        addListener();
        super.setVisible(true);
        
    }
    
     
    private void InitCom() {
        Ajuda = new JMenu("AJUDA");
        Pesquisa = new JMenu("PESQUISA");
        Cadastro = new JMenu("CADASTROS");
        
        menu = new  JMenuBar();
        dimensao = new Dimension(950, 20);
        layout = new FlowLayout();
         

        CadastroCidade = new JMenuItem("Cadastro de Cidades");
        CadastroEndereco = new JMenuItem("Cadastro de Endereços");
        CadastroFornecedor = new JMenuItem("Cadastro de Fornecedor");
        CadastroItem = new JMenuItem("Cadastro de Item");
        CadastroRequsitante = new JMenuItem("Cadastro de Requisitante");
        CadastroUsuario = new JMenuItem("Cadastro de Usuários válidos");
        CadastroTipo = new JMenuItem("Cadostro de Tipo válidos");
        
   
    }

    private void addCom() {
    menu.add(Ajuda);
    menu.add(Pesquisa);
  
    Cadastro.add(CadastroCidade);
    Cadastro.add(CadastroEndereco);
    Cadastro.add(CadastroFornecedor);
    Cadastro.add(CadastroItem);
    Cadastro.add(CadastroRequsitante);
    Cadastro.add(CadastroUsuario);
    Cadastro.add(CadastroTipo);
    
    menu.setSize(dimensao);
    menu.setLayout(layout);
    menu.add(Cadastro,FlowLayout.CENTER);
    
    this.add(menu);
    
    }

    private void addListener() {
        
       ActionListener actionFornecedor = new GerarFornecedor();
       ActionListener actionTipo = new GerarTipo();
       ActionListener actionCidade = new GerarCidade();
       CadastroFornecedor.addActionListener(actionFornecedor);
       CadastroTipo.addActionListener(actionTipo);
       CadastroCidade.addActionListener(actionCidade);
       
           
   
    
    
    
    
}
}

