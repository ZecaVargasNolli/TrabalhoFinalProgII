package br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios;

import br.udesc.ceavi.trabalhoFinalProgII.Model.Categoria;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.LayoutManager;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 * esta Classe define o formulario do tipo CRUD para fornecedor
 *
 * @author Giancarlo
 * @since 07/09/18
 * @version 1.0
 */
public class FrameCRUDfornecedor  extends FrameCRUDGenerico{ 

    private Label lbEmpresa;
    private Label lbCNPJ;
    private Label lbEndereco;
    private Label lbTipoProduto;
    private Label lbContato;
   
    

   
    private JTextField tfEmpresa;
    private JTextField tfCNPJ;
    private JTextField tfEndereco;
    private JTextField tfContato;

    private JComboBox cbTipoProduto;

    private JPanel panelFormulario;

    private static final Dimension dimensao = new Dimension(500, 300);
    private LayoutManager layout;
    private GridBagConstraints cons;

    public FrameCRUDfornecedor(String titulo)throws HeadlessException {
        super(titulo,dimensao);

        initializeComponents();
        addComponents();
       
    }

    private void initializeComponents() {
        lbEmpresa = new Label("Empresa: ");
        lbCNPJ = new Label("CNPJ: ");
        lbEndereco = new Label("Endereço: ");
        lbTipoProduto = new Label("Categoria: ");
        lbContato = new Label("Contato: ");
       
       
        tfEmpresa = new JTextField();
        tfCNPJ = new JTextField();
        tfEndereco = new JTextField();
        tfContato = new JTextField();

        cbTipoProduto = new JComboBox(Categoria.values());
        cbTipoProduto.setSelectedIndex(-1);

        layout = new GridBagLayout();
        panelFormulario = new JPanel(layout);
        panelFormulario.setBorder(BorderFactory.createTitledBorder("Cadastro de Fornecedor"));
        

    }

    private void addComponents() {
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 0;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbEmpresa, cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 0;
        cons.gridwidth = 2;
        cons.ipadx = 100;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(tfEmpresa, cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 1;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbCNPJ, cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 1;
        cons.gridwidth = 2;
        cons.ipadx = 100;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(tfCNPJ, cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 2;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbEndereco, cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 2;
        cons.gridwidth = 2;
        cons.ipadx = 100;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(tfEndereco, cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 3;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbTipoProduto, cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 3;
        cons.gridwidth = 1;
        cons.ipadx = 100;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(cbTipoProduto, cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 4;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbContato, cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 4;
        cons.gridwidth = 4;
        cons.gridheight = 4;
        cons.ipadx = 300;
        cons.ipady = 50;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(tfContato, cons);
        
        super.addFormulario(panelFormulario);
        
    }
     

}
