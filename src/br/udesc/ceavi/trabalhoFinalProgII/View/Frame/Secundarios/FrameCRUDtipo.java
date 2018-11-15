package br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios;

import br.udesc.ceavi.trabalhoFinalProgII.Model.Categoria;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.LayoutManager;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * esta Classe define o formulario do tipo CRUD para Tipo.
 *
 * @author Giancarlo
 * @since 07/09/2018
 * @version 1.0
 */
public class FrameCRUDtipo extends FrameCRUDGenerico {

    private Label lbCodigo;
    private Label lbNome;
    private Label lbCategorias;

    private JTextField tfCodigo;
    private JTextField tfNome;
    

    private JComboBox cbCategoria;

    private JPanel panelFormulario; //esse panel sera adicionado ao painel principal do frameCRUD pelo metodo super.addFormulario.

    private static final Dimension dimensao = new Dimension(500, 300);
    private LayoutManager layout;
    private GridBagConstraints cons;

    public FrameCRUDtipo(String titulo,Dimension tamanho) {
        super(titulo,tamanho);

        initializeComponents();
        addComponents();
    }

    private void initializeComponents() {
        lbCodigo = new Label("Codigo: ");
        lbNome = new Label("Nome: ");
        lbCategorias = new Label("Categoria: ");

        tfCodigo = new JTextField();
        tfNome = new JTextField();
      

        cbCategoria = new JComboBox(Categoria.values());
        cbCategoria.setSelectedIndex(-1);

        layout = new GridBagLayout();
        panelFormulario = new JPanel(layout);
        //panelFormulario.setBorder(BorderFactory.createTitledBorder("Cadastro de Tipo"));
    }

    private void addComponents() {
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
        panelFormulario.add(tfNome, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 1;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbCodigo, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 1;
        cons.gridwidth = 2;
        cons.ipadx = 100;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(tfCodigo, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 2;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbCategorias, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 2;
        cons.gridwidth = 2;
        cons.ipadx = 100;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(cbCategoria, cons);

       

        super.addFormulario(panelFormulario);
    }

}
