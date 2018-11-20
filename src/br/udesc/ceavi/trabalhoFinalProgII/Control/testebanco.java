/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.trabalhoFinalProgII.Control;

import br.udesc.ceavi.trabalhoFinalProgII.Model.Categoria;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Cidade;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Endereco;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Fornecedor;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Item;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Tipo;
import br.udesc.ceavi.trabalhoFinalProgII.Model.UF;
import br.udesc.ceavi.trabalhoFinalProgII.dao.core.DAO;
import br.udesc.ceavi.trabalhoFinalProgII.dao.core.JPADAO;

//somente usado para pequenos testes aparentemente funcional 
/**
 *
 * @author José Vargas Nolli
 */
public class testebanco {
    
   
    public static void main(String[] args) throws Exception {
        Cidade cid = new Cidade("ABraconxix","AB", UF.DF);
        Endereco end = new Endereco(555, "cana braba", "ja deu", "666666");
        Fornecedor ford = new Fornecedor(666666,"coisas", "555555", "Combo estrela");
        Tipo tip = new Tipo(5555, "Coisa", "coisas comuns", Categoria.HIGIENE);
        Item it = new Item("Coisinha", "Sucesso");
       
        
       end.setCidade(cid);
       ford.setEndereco(end);
       it.setTipo(tip);
       it.setFornecedor(ford);
       DAO dao = new JPADAO();
        
        try {
            
            dao.inserir(it);
        } catch (Exception e) {
            
            System.out.print("Deu erro");
        }
        
        
 
    }
    
}
