/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.trabalhoFinalProgII.View.Frame.principal;

import br.udesc.ceavi.trabalhoFinalProgII.Listeners.GerarCidade;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.GerarEndereco;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.GerarFornecedor;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.GerarItem;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.GerarTipo;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.gerarTableItem;
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

    public MenuFornecedor() {
        
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
        
        ActionListener actionAtualizar = new gerarTableItem();
        
        CadastroCidade.addActionListener(actionCidade);
        CadastroEndereco.addActionListener(actionEndereco);
        CadastroFornecedor.addActionListener(actionFornecedor);
        
        Atualizar.addActionListener(actionAtualizar);
    }
    
    
    
    
    
    
}
