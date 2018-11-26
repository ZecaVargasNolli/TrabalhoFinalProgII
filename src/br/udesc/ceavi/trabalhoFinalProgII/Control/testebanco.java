/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.trabalhoFinalProgII.Control;

import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.FornecedorDAO;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.ItemDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Item;
        


//somente usado para pequenos testes aparentemente funcional 
/**
 *
 * @author José Vargas Nolli
 */
public class testebanco  implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        ItemDAO dao = new ItemDAO();
        
        List<Item> lis;
        lis = dao.buscarItem();
        for(int i =0;i< lis.size();i++){
        System.out.println(lis.get(i).getFornecedor().toString());
    }
    }
    
   
    
    
        
        
   
 
        
        
        
       
    
       
        
        
       
        
      
       
        
        
 
    }
    

