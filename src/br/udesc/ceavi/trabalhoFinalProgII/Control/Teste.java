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

