package br.udesc.ceavi.trabalhoFinalProgII.View.Frame.principal.JMenus;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import br.udesc.ceavi.trabalhoFinalProgII.Listeners.GerarCidade;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.GerarEndereco;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.GerarFornecedor;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.GerarItem;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.GerarTipo;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.Jtable.AtualizarTable;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.Jtable.gerarTableFornecedor;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.Jtable.gerarTableItem;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.Visualizar.GerarVCidade;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.Visualizar.GerarVEndereco;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.Visualizar.GerarVFornecedor;
import br.udesc.ceavi.trabalhoFinalProgII.View.Frame.principal.JTableAparencia.JFrameTable;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author José Vargas Nolli
 */
public class MenuFornecedor  extends Menu{
    
    private JFrameTable frame;
    
    private JMenu Cadastros;
    private JMenu Visualizar;
    private JMenu acoes;
    
    
    
    private JMenuItem CadastroCidade;
    private JMenuItem CadastroEndereco;
    private JMenuItem CadastroFornecedor;
    
    private JMenuItem VisualizarCidade;
    private JMenuItem VisualizarEndereco;
    private JMenuItem VisualizarFornecedor;   
    
    private JMenuItem Atualizar;
    private JMenuItem Voltar;
    
    private LayoutManager layout;

    public MenuFornecedor(JFrameTable frame) {
        this.frame = frame;
        iniCom();
        add();
        addListener();
    }

    private void iniCom() {
       
        layout = new FlowLayout(FlowLayout.LEFT);
        
        
        CadastroCidade = new JMenuItem("Cadastro de Cidade");
        CadastroEndereco = new JMenuItem("Cadastro de Endereço");
        CadastroFornecedor = new JMenuItem("Cadastro de Fornecedor");
        
        VisualizarCidade = new JMenuItem("Visualizar Cidade");
        VisualizarEndereco = new JMenuItem("Visualizar Endereço");
        VisualizarFornecedor = new JMenuItem("Visualizar Fornecedor");
       
        Atualizar = new JMenuItem("Atualizar");
        Voltar = new JMenuItem("Voltar");
        
        acoes =  new JMenu("Ações");
        Visualizar = new JMenu("Visualizar");
        Cadastros = new JMenu("Cadastros");
    }

    private void add() {
        super.setLayout(layout);
        Cadastros.add(CadastroCidade);
        Cadastros.add(CadastroEndereco);
        Cadastros.add(CadastroFornecedor);
        
        super.add(Cadastros);
        
        Visualizar.add(VisualizarCidade);
        Visualizar.add(VisualizarEndereco);
        Visualizar.add(VisualizarFornecedor);
        
        
        super.add(Visualizar);
        
        acoes.add(Atualizar);
        acoes.add(Voltar);
        
        super.add(acoes);
        
        
    }

    private void addListener() {
        ActionListener actionCidade = new GerarCidade();
        ActionListener actionEndereco = new GerarEndereco();
        ActionListener actionFornecedor = new GerarFornecedor();
        ActionListener actionAt = new AtualizarTable(frame);
        ActionListener actionAtualizar = new gerarTableFornecedor(frame);
        ActionListener actionVisualizarC = new GerarVCidade();
        ActionListener actionVisualizarE = new GerarVEndereco();
        ActionListener actionVisualizarF = new GerarVFornecedor();
        
        CadastroCidade.addActionListener(actionCidade);
        CadastroEndereco.addActionListener(actionEndereco);
        CadastroFornecedor.addActionListener(actionFornecedor);
        Atualizar.addActionListener(actionAt);
        Atualizar.addActionListener(actionAtualizar);
        VisualizarCidade.addActionListener(actionVisualizarC);
        VisualizarEndereco.addActionListener(actionVisualizarE);
        VisualizarFornecedor.addActionListener(actionVisualizarF);
    }

    public JMenuItem getVoltar() {
        return Voltar;
    }
    
    
    
    
    
    
}
