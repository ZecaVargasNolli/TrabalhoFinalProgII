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
import br.udesc.ceavi.trabalhoFinalProgII.View.Frame.principal.FrameMenu;
import br.udesc.ceavi.trabalhoFinalProgII.dao.core.DAO;
import br.udesc.ceavi.trabalhoFinalProgII.dao.core.JPADAO;
import javax.swing.JFrame;

/**
 * classe principal
 * @author José Vargas Nolli
 */
public class Teste  implements Runnable{
    
     public static void main(String[] args) {
       Cidade cid = new Cidade("ABraconxix","AB", UF.DF);
        Endereco end = new Endereco(555, "cana braba", "ja deu", "666666");
        Fornecedor ford = new Fornecedor(666666,"coisas", "555555", "Combo estrela");
        Tipo tip = new Tipo(5555, "Coisa", "coisas comuns", Categoria.HIGIENE);
        Item it = new Item("Coisinha", "Sucesso");
        Item et = new Item("Banco","Bless");
       
        
       end.setCidade(cid);
       ford.setEndereco(end);
       et.setTipo(tip);
       et.setFornecedor(ford);
       it.setTipo(tip);
       it.setFornecedor(ford);
       DAO dao = new JPADAO();
        
        try {
            
            dao.inserir(it);
            dao.inserir(et);
        } catch (Exception e) {
            
            System.out.print("Deu erro");
        }
        
         
         
        Teste telaPrincipal = new Teste();
        Thread thread = new Thread(telaPrincipal);
        
        thread.start();
    }

    @Override
    public void run() {
        JFrame frame = new FrameMenu();
        
        frame.setVisible(true);
    }
    
}

