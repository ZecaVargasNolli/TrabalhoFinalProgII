
package br.udesc.ceavi.trabalhoFinalProgII.View.Frame.principal;

import br.udesc.ceavi.trabalhoFinalProgII.Listeners.GerarCidade;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.GerarEmprestimos;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.GerarEndereco;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.GerarFornecedor;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.GerarItem;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.GerarRequisitante;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.GerarTipo;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.GerarUsuario;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.gerarTable;
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
    private JMenuItem CadastroEmprestimo;
    private JMenuItem TabelaItem;
    
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
        CadastroEndereco = new JMenuItem("Cadastro de Endereço");
        CadastroFornecedor = new JMenuItem("Cadastro de Fornecedor");
        CadastroItem = new JMenuItem("Cadastro de Item");
        CadastroRequsitante = new JMenuItem("Cadastro de Requisitante");
        CadastroUsuario = new JMenuItem("Cadastro de Usuário");
        CadastroTipo = new JMenuItem("Cadastro de Tipo de Item");
        CadastroEmprestimo = new JMenuItem("Cadastro de Emprestimo");
        TabelaItem = new JMenuItem("Tabela de Item");
   
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
    Cadastro.add(CadastroEmprestimo);
    
    Pesquisa.add(TabelaItem);
    
    menu.setSize(dimensao);
    menu.setLayout(layout);
    menu.add(Cadastro);
    
    this.add(menu);
    
    }

    private void addListener() {
        
       ActionListener actionFornecedor = new GerarFornecedor();
       ActionListener actionTipo = new GerarTipo();
       ActionListener actionCidade = new GerarCidade();
       ActionListener actionEndereco = new GerarEndereco();
       ActionListener actionItem = new GerarItem();
       ActionListener actionRequisitante = new GerarRequisitante();
       ActionListener actionUsuario = new GerarUsuario();
       ActionListener actionEmprestimo = new GerarEmprestimos();
       ActionListener actionTable = new gerarTable();
       CadastroFornecedor.addActionListener(actionFornecedor);
       CadastroTipo.addActionListener(actionTipo);
       CadastroCidade.addActionListener(actionCidade);
       CadastroEndereco.addActionListener(actionEndereco);
       CadastroItem.addActionListener(actionItem);
       CadastroRequsitante.addActionListener(actionRequisitante);
       CadastroUsuario.addActionListener(actionUsuario);
       CadastroEmprestimo.addActionListener(actionEmprestimo);
       TabelaItem.addActionListener(actionTable);
   
    
    
    
    
}
}

