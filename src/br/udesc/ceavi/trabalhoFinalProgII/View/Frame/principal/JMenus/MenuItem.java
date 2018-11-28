package br.udesc.ceavi.trabalhoFinalProgII.View.Frame.principal.JMenus;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import br.udesc.ceavi.trabalhoFinalProgII.View.Frame.principal.JTableAparencia.JFrameTable;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.Jtable.AtualizarTable;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.GerarCidade;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.GerarEndereco;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.GerarFornecedor;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.GerarItem;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.GerarTipo;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.Jtable.gerarTableItem;
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
public class MenuItem  extends Menu{
    
    private JFrameTable table;
    
    private JMenu Cadastros;
    private JMenu Visualizar;
    private JMenu acoes;
    
    
    
    private JMenuItem CadastroTipo;
    private JMenuItem CadastroItem;
    
    private JMenuItem VisualizarTipo;
    private JMenuItem VisualizarItem;
   
    
    private JMenuItem Atualizar;
    private JMenuItem Voltar;
    
    private LayoutManager layout;

    public MenuItem(JFrameTable table) {
        this.table = table;
        iniCom();
        add();
        addListener();
    }

    private void iniCom() {
       
        layout = new FlowLayout(FlowLayout.LEFT);
        
        CadastroItem = new JMenuItem("Cadastro de Item");
        CadastroTipo = new JMenuItem("Cadastro de Tipo");
        
        VisualizarItem = new JMenuItem("Visualizar Item");
        VisualizarTipo = new JMenuItem("Visualizar Tipo");
        
       
        Atualizar = new JMenuItem("Atualizar");
        Voltar = new JMenuItem("Voltar");
        
        acoes =  new JMenu("Ações");
        Visualizar = new JMenu("Visualizar");
        Cadastros = new JMenu("Cadastros");
    }

    private void add() {
        super.setLayout(layout);
        Cadastros.add(CadastroItem);
        Cadastros.add(CadastroTipo);
        
        
        super.add(Cadastros);
        
        Visualizar.add(VisualizarItem);
        Visualizar.add(VisualizarTipo);
        
        
        super.add(Visualizar);
        
        acoes.add(Atualizar);
        acoes.add(Voltar);
        
        super.add(acoes);
        
        
    }

    private void addListener() {
        ActionListener actionItem = new GerarItem();
        ActionListener actionTipo = new GerarTipo();
        
        
        ActionListener actionAtualizar = new AtualizarTable(table);
        ActionListener Criar = new gerarTableItem(table);
        
        CadastroTipo.addActionListener(actionTipo);
        CadastroItem.addActionListener(actionItem);
        
        Atualizar.addActionListener(actionAtualizar);
        Atualizar.addActionListener(Criar);
    }

    public JMenuItem getVoltar() {
        return Voltar;
    }
    
    
    
    
    
    
}
