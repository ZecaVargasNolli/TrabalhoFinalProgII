
package br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *Frame CRUD responsável pelo formulário de requisitante.
 * 
 * @author José Vargas Nolli
 */
public class FrameCRUDrequisitante extends FrameCRUDGenerico {
    
   private JLabel lbNome;
   private JLabel lbSetor;
   private JLabel lbCpf;
   private JLabel lbRg;
   
   private JTextField txNome;
   private JTextField txSetor;
   private JTextField txCpf;
   private JTextField txRg;
   
   private LayoutManager layout;
    
   private GridBagConstraints cons;
   
   private JPanel panelFormulario;
    
    
    public FrameCRUDrequisitante(String titulo, Dimension tamanho) {
        super(titulo, tamanho);
        
        initCom();
        addCom();
    }

    private void initCom() {
        
        lbCpf = new JLabel("CPF: ");
        lbNome = new JLabel("Nome: ");
        lbRg = new JLabel("RG: ");
        lbSetor = new JLabel("Setor: ");
        
        txCpf = new JTextField();
        txNome = new JTextField();
        txRg = new JTextField();
        txSetor = new JTextField();
        
        layout = new GridBagLayout();
        
        panelFormulario = new JPanel(layout);
    }

    private void addCom() {
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 0;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbNome, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 0;
        cons.gridwidth = 2;
        cons.ipadx = 100;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(txNome, cons);
        
         cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 1;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbCpf, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 1;
        cons.gridwidth = 2;
        cons.ipadx = 100;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(txCpf, cons);
        
         cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 2;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbRg, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 2;
        cons.gridwidth = 2;
        cons.ipadx = 100;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(txRg, cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 4;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbSetor, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 4;
        cons.gridwidth = 2;
        cons.ipadx = 100;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(txSetor, cons);

        super.add(panelFormulario);



    }
    
}
