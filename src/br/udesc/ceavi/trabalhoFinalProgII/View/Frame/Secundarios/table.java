/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios;

import br.udesc.ceavi.trabalhoFinalProgII.Model.Item;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.ItemDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author José Vargas Nolli
 */
public class table extends AbstractTableModel {

    private ItemDAO dao = new ItemDAO();
    private List<Item> itens = new ArrayList<>();
    
    private final String[] colunas = {"Nome","Fornecedor","Data de Aquisição","Tipo"};
    
    @Override
    public int getRowCount() {
        itens = dao.buscarItem();
        return itens.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch(coluna){
            case 0:
                return itens.get(linha).getNome();
                
                
            case 1:
                return itens.get(linha).getFornecedor().getNomeDaEmpresa();
               
            case 2:
                return itens.get(linha).getDatadeAquisicao();
                
            case 3:
                return itens.get(linha).getTipo().getNome();
                
        }
       return null;
    }

 //   @Override
  //  public String getColumnName(int column) {
  //      return colunas[column];
   // }

   
    
    
    
 
    
}
