package br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios;

import br.udesc.ceavi.trabalhoFinalProgII.Listeners.GerarItem;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.GerarRequisitante;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.GerarUsuario;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author José Vargas Nolli
 */
public class FrameCRUDemprestimo extends FrameCRUDGenerico {

    private JLabel lbData;
    private JLabel lbItem;
    private JLabel lbRequisitante;
    private JLabel lbUsuario;

    private JButton btItem;
    private JButton btRequisitante;
    private JButton btUsuario;

    private JTextField txData;

    private JComboBox cbItem;
    private JComboBox cbRequisitante;
    private JComboBox cbUsuario;

    private LayoutManager layout;
    
    private Dimension btTamanho;

    private JPanel panelFormulario;

    private GridBagConstraints cons;

    public FrameCRUDemprestimo(String titulo, Dimension tamanho) {
        super(titulo, tamanho);

        initCom();
        addCom();
        addListeners();
    }

    private void initCom() {
        btTamanho = new Dimension(80, 40);
        
        lbData = new JLabel("Data:  ");
        lbItem = new JLabel("Item:  ");
        lbRequisitante = new JLabel("Requisitante:  ");
        lbUsuario = new JLabel("Usuário:  ");
        //verificar como funciona para usar a classe presente no banco.
        cbItem = new JComboBox();
        cbRequisitante = new JComboBox();
        cbUsuario = new JComboBox();
        
        String add = "ADICIONAR";
        
        btItem = new JButton(add);
        btItem.setSize(btTamanho);
        btRequisitante = new JButton(add);
        btRequisitante.setSize(btTamanho);
        btUsuario = new JButton(add);
        btUsuario.setSize(btTamanho);

        MaskFormatter mask = null;

        try {
            mask = new MaskFormatter("  ##/##/####  ");
            mask.setPlaceholderCharacter(' ');

        } catch (ParseException e) {
            e.printStackTrace();
        }
        txData = new JFormattedTextField(mask);

        layout = new GridBagLayout();

        panelFormulario = new JPanel(layout);

    }

    private void addCom() {

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 0;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbData, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 0;
        cons.gridwidth = 2;
        cons.ipadx = 60;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(txData, cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 1;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbItem,cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 1;
        cons.gridwidth = 2;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(btItem,cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 2;
        cons.gridwidth = 2;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(cbItem,cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 3;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbRequisitante, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 3;
        cons.gridwidth = 2;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(btRequisitante, cons);

        cons =new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 4;
        cons.gridwidth = 2;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(cbRequisitante,cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 5;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbUsuario, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 5;
        cons.gridwidth = 2;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(btUsuario, cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 6;
        cons.gridwidth = 2;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(cbUsuario,cons);
        
        super.add(panelFormulario);

    }

    private void addListeners() {
      
        ActionListener actionRequisitante = new GerarRequisitante();
        ActionListener actionUsuario = new GerarUsuario();
        ActionListener actionItem = new GerarItem();
        
        btItem.addActionListener(actionItem);
        btRequisitante.addActionListener(actionRequisitante);
        btUsuario.addActionListener(actionUsuario);
    }

}
