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
public class FrameCRUDfornecedor extends FrameCRUDGenerico {

    private Label lbEmpresa;
    private Label lbCNPJ;

    private Label lbValorItens;

    private JTextField tfEmpresa;
    private JTextField tfCNPJ;

    private JTextField lbItensFornecidos;

    private JPanel panelFormulario;

    private LayoutManager layout;
    private GridBagConstraints cons;

    public FrameCRUDfornecedor(String titulo, Dimension tamanho) throws HeadlessException {
        super(titulo, tamanho);

        initializeComponents();
        addComponents();

    }

    private void initializeComponents() {
        lbEmpresa = new Label("Empresa: ");
        lbCNPJ = new Label("CNPJ: ");

        lbValorItens = new Label("Itens Fornecidos: ");

        tfEmpresa = new JTextField();
        tfCNPJ = new JTextField();

        lbItensFornecidos = new JTextField();

        layout = new GridBagLayout();
        panelFormulario = new JPanel(layout);
        //ver se é relevante // panelFormulario.setBorder(BorderFactory.createTitledBorder("Cadastro de Fornecedor"));

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
        cons.gridy = 4;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbValorItens, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 4;
        cons.gridwidth = 4;
        cons.gridheight = 4;
        cons.ipadx = 300;
        cons.ipady = 20;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbItensFornecidos, cons);

        super.addFormulario(panelFormulario);

    }

}
