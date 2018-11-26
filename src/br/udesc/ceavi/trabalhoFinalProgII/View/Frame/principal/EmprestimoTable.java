/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.trabalhoFinalProgII.View.Frame.principal;

import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.CidadeDAO;
import javax.swing.JTable;
import java.util.List;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Cidade;
import br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios.FrameCRUDGenerico;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.FornecedorDAO;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.ScrollPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Fornecedor;


//NÃO UTILIZAR AINDA PORQUE PRECISA SER FEITO.




/**
 *
 * @author José Vargas Nolli
 */
public class EmprestimoTable extends JFrameTable{
    
    private JTable tabela;
    private  JPanel panel;
    private JScrollPane pane;
   private DefaultTableModel dtm;  
    
  
    
    
    
        
        public EmprestimoTable(String titulo, Dimension tamanho) {
        super(titulo, tamanho);
    

    initCom();
    addTable();
    
    
    }

   

    private void initCom() {
        tabela = new JTable();
        tabela.setModel(new javax.swing.table.DefaultTableModel(
         new Object[][]{
             
         },
                 new String[]{
                     "Data do Emprestimo","Item","Usuario","Quem Emprestou"
                 }
         
         ));
         
        dtm = (DefaultTableModel) tabela.getModel();
        panel = new JPanel();
        panel.setLayout(new GridLayout(1,1));
        pane = new JScrollPane(tabela);
        FornecedorDAO dao = new FornecedorDAO();
        List<Fornecedor> cid = dao.buscarFornecedor();
        for(int i = 0;i<cid.size();i++){
            
            String NomeEmpresa = cid.get(i).getNomeDaEmpresa();
            String CNPJ = cid.get(i).getCnpj();
            String Endereco = cid.get(i).getEndereco().toString();
            
           dtm.addRow(new String[]{NomeEmpresa,CNPJ,Endereco});
            
            
            
            
        }
        
    }

    private void addTable() {
        panel.add(pane);
        super.add(panel);
    }

    
    
    
    
    
    
}
