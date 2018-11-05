
package br.udesc.ceavi.trabalhoFinalProgII.View.Frame.principal;

import br.udesc.ceavi.trabalhoFinalProgII.Listeners.TesteFornecedor;
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
 *
 * @author José Vargas Nolli
 */
public class Menus extends JPanel {
    
    private static Menus instancia;
    
    
    
    private JMenu Cadastro;
    private JMenu Pesquisa;
    private JMenu Ajuda;
    private JMenuBar menu;
    private JMenuItem CadastroFornecedor;
    private JMenuItem CadastroProduto;
    private JMenuItem CadastroEndereco;
    private JMenuItem CadastroCidade;
    private JMenuItem CadastroSetor;
    
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
        CadastroProduto = new JMenuItem("Cadastro de Produtos");
        CadastroSetor = new JMenuItem("Cadastro de Setor");
   
    }

    private void addCom() {
    menu.add(Ajuda);
    menu.add(Pesquisa);
   //arrumar os cadastros
    Cadastro.add(CadastroCidade);
    Cadastro.add(CadastroEndereco);
    Cadastro.add(CadastroFornecedor);
    Cadastro.add(CadastroProduto);
    Cadastro.add(CadastroSetor);
    
    menu.setSize(dimensao);
    menu.setLayout(layout);
    menu.add(Cadastro,FlowLayout.CENTER);
    
    this.add(menu);
    
    }

    private void addListener() {
        
       ActionListener actionFornecedor = new TesteFornecedor();
       CadastroFornecedor.addActionListener(actionFornecedor);
       
           
   
    
    
    
    
}
}

