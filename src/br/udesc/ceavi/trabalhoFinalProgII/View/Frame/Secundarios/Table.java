/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios;

import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.CidadeDAO;
import javax.swing.JTable;
import java.util.List;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Cidade;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.ScrollPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;







/**
 *
 * @author José Vargas Nolli
 */
public class Table extends FrameCRUDGenerico{
    
    private JTable tabela;
    private  JPanel panel;
    private JScrollPane pane;
   private DefaultTableModel dtm;  
    
  
    
    
    
        
        public Table(String titulo, Dimension tamanho) {
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
                     "Nome da Cidade","Sigla","UF"
                 }
         
         ));
         
        dtm = (DefaultTableModel) tabela.getModel();
        panel = new JPanel();
        panel.setLayout(new GridLayout(1,1));
        pane = new JScrollPane(tabela);
        CidadeDAO dao = new CidadeDAO();
        List<Cidade> cid = dao.buscarCidade();
        for(int i = 0;i<cid.size();i++){
            
            String nome = cid.get(i).getNomeCidade();
            String Sigla = cid.get(i).getSigla();
            String UF = cid.get(i).getUf().toString();
            
           dtm.addRow(new String[]{nome,Sigla,UF});
            
            
            
            
        }
        
    }

    private void addTable() {
        panel.add(pane);
        super.add(panel);
    }

    
    
    
    
    
    
}
