package br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios;

import br.udesc.ceavi.trabalhoFinalProgII.Model.Cidade;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * Classe resprosável pela montagem do frame do cadastro de endereço.
 *
 * @author José Vargas Nolli
 */
public class FrameCRUDendereco extends FrameCRUDGenerico {

    private JLabel lbNumero;
    private JLabel lbBairro;
    private JLabel lbComplemento;
    private JLabel lbCep;
    private JLabel lbCidade;

    private JTextField txNumero;
    private JTextField txBairro;
    private JTextField txComplemento;
    private JTextField txCep;

    private LayoutManager layout;

    private JPanel panelFormulario;

    private GridBagConstraints cons;

    private JComboBox cbCidade;//verificar se vai dar certo

    public FrameCRUDendereco(String titulo, Dimension tamanho) {
        super(titulo, tamanho);

        initCom();
        addCom();
    }

    private void initCom() {
        lbBairro = new JLabel("Bairro: ");
        lbCep = new JLabel("CEP: ");
        lbComplemento = new JLabel("Complemento: ");
        lbNumero = new JLabel("Número: ");
        lbCidade = new JLabel("Cidade: ");

        txNumero = new JTextField();
        txBairro = new JTextField();
        txComplemento = new JTextField();
        txCep = new JTextField();

        cbCidade = new JComboBox();
        cbCidade.setSelectedIndex(-1);

        layout = new GridBagLayout();
        panelFormulario = new JPanel(layout);

    }

    private void addCom() {

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 0;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbNumero, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 0;
        cons.gridwidth = 2;
        cons.ipadx = 100;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(txNumero, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 1;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbBairro, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 1;
        cons.gridwidth = 2;
        cons.ipadx = 100;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(txBairro, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 2;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbCep, cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 2;
        cons.gridwidth = 2;
        cons.ipadx = 100;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(txCep,cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 3;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbComplemento,cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 3;
        cons.gridwidth = 2;
        cons.ipadx = 100;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(txComplemento,cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 4;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbCidade,cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 4;
        cons.gridwidth = 2;
        cons.ipadx = 100;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(cbCidade,cons);
        
        super.add(panelFormulario);
    }

}
