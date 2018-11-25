package br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios;

import br.udesc.ceavi.trabalhoFinalProgII.Listeners.GerarFornecedor;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.GerarTipo;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.FornecedorDAO;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Fornecedor;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.RequisitanteDAO;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Tipo;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.TipoDAO;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Classe responsável pelo formato do formulário que gera os cadastros de itens.
 *
 * @author José Vargas Nolli
 */
public class FrameCRUDitem extends FrameCRUDGenerico {

    private JLabel lbNome;
    private JLabel lbTipo;
    private JLabel lbFornecedor;

    private JTextField txNome;
    private JButton jbTipo;
    private JButton jbFornecedor;

    private JComboBox<Fornecedor> cbFornecedor;

    private JComboBox cbTipo;

    private LayoutManager layout;

    private GridBagConstraints cons;

    private Dimension tamanhoButton;

    private JPanel panelFormulario;

    public FrameCRUDitem(String titulo, Dimension tamanho) {
        super(titulo, tamanho);

        initCom();
       initCombo();
        addCom();
        addListeners();
    }

    private void initCom() {
        tamanhoButton = new Dimension(100, 50);
        lbFornecedor = new JLabel("Fornecedor: ");
        lbNome = new JLabel("Nome: ");
        lbTipo = new JLabel("Tipo: ");

        cbFornecedor = new JComboBox();

        txNome = new JTextField();

        jbTipo = new JButton("ADICIONAR");
        jbTipo.setSize(tamanhoButton);

        jbFornecedor = new JButton("ADICIONAR");
        jbFornecedor.setSize(tamanhoButton);

        cbTipo = new JComboBox();
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
        panelFormulario.add(lbFornecedor, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 3;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbTipo, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 1;
        cons.gridwidth = 2;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(jbFornecedor, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 2;
        cons.gridwidth = 2;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(cbFornecedor, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 3;
        cons.gridwidth = 2;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(jbTipo, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 4;
        cons.gridwidth = 2;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(cbTipo, cons);

        super.add(panelFormulario);

    }

    private void addListeners() {
        ActionListener actionFornecedor = new GerarFornecedor();
        ActionListener actionTipo = new GerarTipo();
        jbFornecedor.addActionListener(actionFornecedor);
        jbTipo.addActionListener(actionTipo);
    }

    private void initCombo() {
        TipoDAO dao = new TipoDAO();
       FornecedorDAO daof = new FornecedorDAO();
       
       List<Fornecedor> ford;
       List<Tipo> tip;
       
       ford = daof.buscarFornecedor();
       tip = dao.buscarTipo();
       
       for(int i = 0;i<tip.size();i++){
           
           cbTipo.addItem(tip.get(i).getNome());
           
       }
       for(int j = 0;j<ford.size();j++){
           cbFornecedor.addItem(ford.get(j));
           
       }
       
        
    }
    
    

}
