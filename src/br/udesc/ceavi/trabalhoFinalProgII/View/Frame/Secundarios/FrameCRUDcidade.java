package br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios;

import br.udesc.ceavi.trabalhoFinalProgII.Model.Cidade;
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
 * Formulario da classe cidade, responsável por seu cadastro. esta classe
 * extende a classe generica FrameCRUDGenerico.
 *
 * @author José Vargas Nolli
 * @version 1.0
 * @since 09/11/2018
 */
public class FrameCRUDcidade extends FrameCRUDGenerico {

    //ATRIBUTOS-----------------
    private JLabel lbNome;
    private JLabel lbSigla;
    private JLabel lbUF;

    private JTextField txNome;
    private JTextField txSigla;

    private JComboBox cbUF;

    private JPanel panelFormulario;

    private LayoutManager layout;
    private GridBagConstraints cons;
//-----------------------------------------

    //CONSTRUTOR DA CLASSE FrameCRUDcidade
    public FrameCRUDcidade(String titulo, Dimension tamanho) {
        super(titulo, tamanho);

        initCom();
        addCom();
    }

    //METODO RESPONSÁVEL POR INICIAR OS COMPONENTES DO FORMULARIO DA CLASSE
    private void initCom() {
        lbNome = new JLabel("Nme: ");
        lbSigla = new JLabel("Sigla: ");
        lbUF = new JLabel("UF: ");

        txNome = new JTextField();
        txSigla = new JTextField();

        cbUF = new JComboBox(UF.values());
        cbUF.setSelectedIndex(-1);

        layout = new GridBagLayout();

        panelFormulario = new JPanel(layout);

    }

    //METODO RESPONSAVEL POR ADICIONAR OS COMPNENTES DO FORMULARIO DA CLASSE
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
        panelFormulario.add(lbSigla, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 1;
        cons.gridwidth = 2;
        cons.ipadx = 100;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(txSigla, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 2;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbUF, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 2;
        cons.gridwidth = 2;
        cons.ipadx = 100;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(cbUF, cons);

        super.add(panelFormulario);
    }

    //Getters and setters.
    public JTextField getTxNome() {
        return txNome;
    }

    public void setTxNome(JTextField txNome) {
        this.txNome = txNome;
    }

    public JTextField getTxSigla() {
        return txSigla;
    }

    public void setTxSigla(JTextField txSigla) {
        this.txSigla = txSigla;
    }

    public JComboBox getCbUF() {
        return cbUF;
    }

    public void setCbUF(JComboBox cbUF) {
        this.cbUF = cbUF;
    }

    
    
   
   
}
