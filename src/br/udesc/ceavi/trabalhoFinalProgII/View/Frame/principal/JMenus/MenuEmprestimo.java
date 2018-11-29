package br.udesc.ceavi.trabalhoFinalProgII.View.Frame.principal.JMenus;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import br.udesc.ceavi.trabalhoFinalProgII.View.Frame.principal.JTableAparencia.JFrameTable;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.Jtable.AtualizarTable;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.GerarCidade;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.GerarEmprestimos;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.GerarEndereco;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.GerarFornecedor;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.GerarItem;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.GerarRequisitante;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.GerarTipo;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.GerarUsuario;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.Jtable.gerarTableEmprestimo;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.Jtable.gerarTableFornecedor;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.Jtable.gerarTableItem;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.Visualizar.GerarVEmprestimo;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.Visualizar.GerarVRequisitante;
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
public class MenuEmprestimo  extends Menu{
    
    private JFrameTable table;
    
    private JMenu Cadastros;
    private JMenu Visualizar;
    private JMenu acoes;
    
    
    
    private JMenuItem CadastroEmprestimo;
    private JMenuItem CadastroRequisitante;
    
    
    private JMenuItem VisualizarEmprestimo;
    private JMenuItem VisualizarRequisitante;
      
    
    private JMenuItem Atualizar;
    private JMenuItem Voltar;
    
    private LayoutManager layout;

    public MenuEmprestimo(JFrameTable table) {
        this.table = table;
        iniCom();
        add();
        addListener();
    }

    private void iniCom() {
       
        layout = new FlowLayout(FlowLayout.LEFT);
        
        CadastroEmprestimo= new JMenuItem("Cadastro de Empréstimo");
        CadastroRequisitante = new JMenuItem("Cadastro de Requisitante");
        
        
        VisualizarEmprestimo = new JMenuItem("Visualizar Empréstimo");
        VisualizarRequisitante = new JMenuItem("Visualizar Requisistante");
       
       
        Atualizar = new JMenuItem("Atualizar");
        Voltar = new JMenuItem("Voltar");
        
        acoes =  new JMenu("Ações");
        Visualizar = new JMenu("Visualizar");
        Cadastros = new JMenu("Cadastros");
    }

    private void add() {
        super.setLayout(layout);
        Cadastros.add(CadastroEmprestimo);
        Cadastros.add(CadastroRequisitante);
     
        
        
        super.add(Cadastros);
        
        Visualizar.add(VisualizarEmprestimo);
        Visualizar.add(VisualizarRequisitante);
       
        
        super.add(Visualizar);
        
        acoes.add(Atualizar);
        acoes.add(Voltar);
        
        super.add(acoes);
        
        
    }

    private void addListener() {
        ActionListener actionEmprestimo = new GerarEmprestimos();
        ActionListener actionRequisitante = new GerarRequisitante();
       
        ActionListener actionVisualizarE = new GerarVEmprestimo();
        ActionListener actionVisualizarR = new GerarVRequisitante();
        
        
        ActionListener actionAtualizar = new AtualizarTable(table);

        ActionListener Criar = new gerarTableEmprestimo(table);

        
        CadastroEmprestimo.addActionListener(actionEmprestimo);
        CadastroRequisitante.addActionListener(actionRequisitante);
        VisualizarEmprestimo.addActionListener(actionVisualizarE);
        VisualizarRequisitante.addActionListener(actionVisualizarR);
        
        
        Atualizar.addActionListener(actionAtualizar);
        Atualizar.addActionListener(Criar);
    }

    public JMenuItem getVoltar() {
        return Voltar;
    }
    
    
    
    
    
    
}
