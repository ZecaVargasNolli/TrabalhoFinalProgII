package br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios;

import br.udesc.ceavi.trabalhoFinalProgII.Model.UF;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Formulario da classe cidade, responsável por seu cadastro.
 *
 * @author José Vargas Nolli
 * @version 1.0
 * @since 09/11/2018
 */
public class FrameCRUDcidade extends FrameCRUDGenerico {

    private JLabel lbCodigo;
    private JLabel lbSigla;
    private JLabel lbUF;

    private JTextField txCodigo;
    private JTextField txSigla;

    private JComboBox cbUF;

    private JPanel panelFormulario;

    private LayoutManager layout;
    private GridBagConstraints cons;

    

    public FrameCRUDcidade(String titulo, Dimension tamanho) {
        super(titulo, tamanho);

        initCom();
        addCom();
    }

    private void initCom() {
        lbCodigo = new JLabel("Código: ");
        lbSigla = new JLabel("Sigla: ");
        lbUF = new JLabel("UF: ");

        txCodigo = new JTextField();
        txSigla = new JTextField();
        
        cbUF = new JComboBox(UF.values());
        cbUF.setSelectedIndex(-1);

        layout = new GridBagLayout();

        panelFormulario = new JPanel(layout);

    }

    private void addCom() {

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 0;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbCodigo, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 0;
        cons.gridwidth = 2;
        cons.ipadx = 100;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(txCodigo, cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 1;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbSigla,cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 1;
        cons.gridwidth = 2;
        cons.ipadx = 100;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(txSigla,cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 2;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbUF,cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 2;
        cons.gridwidth = 2;
        cons.ipadx = 100;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(cbUF,cons);
        
        super.add(panelFormulario);
    }

}
