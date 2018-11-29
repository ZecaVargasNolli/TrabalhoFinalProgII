package br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios.Alterar;

import br.udesc.ceavi.trabalhoFinalProgII.Listeners.CancelarListener;
import br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios.*;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Cidade;
import br.udesc.ceavi.trabalhoFinalProgII.Model.UF;
import br.udesc.ceavi.trabalhoFinalProgII.dao.core.JPADAO;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.CidadeDAO;
import br.udesc.ceavi.trabalhoFinalProgII.view.Panel.PanelCadastro;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * Frame responsavel por alterar os dados de cidade
 *
 * @author Giancarlo Pandini
 * @author Gustavo José
 * @author José Vargas Nolli
 * @since 29/11/2018
 * @version 1.0
 */
public class FrameAlterarCidade extends FrameAlterar {

    //ATRIBUTOS-----------------
    private JLabel lbNome;
    private JLabel lbSigla;
    private JLabel lbUF;
    private JLabel lbAUF;
    // private JLabel lbInfo;
    // private JLabel lbInfo2;

    protected JTextField txNome;
    protected JTextField txSigla;

    protected JComboBox cbUF;

    private JPanel panelFormulario;

    private LayoutManager layout;
    private GridBagConstraints cons;
    private Cidade cidade;
//-----------------------------------------

    //CONSTRUTOR DA CLASSE FrameCRUDcidade
    public FrameAlterarCidade(String titulo, Dimension tamanho, Cidade cidade) {
        super(titulo, tamanho);
        this.cidade = cidade;

        initCom();
        addCom();
        addDados();
        addListener();

    }

    //METODO RESPONSÁVEL POR INICIAR OS COMPONENTES DO FORMULARIO DA CLASSE
    private void initCom() {
        lbNome = new JLabel("Nome: ");
        lbSigla = new JLabel("Sigla: ");
        lbUF = new JLabel("UF Atual: ");
        //lbInfo= new JLabel("Favor sempre alterar o ");
        //lbInfo2 = new JLabel("UF para a opção desejada.");
        lbAUF = new JLabel(cidade.getUf().toString());

        txNome = new JTextField();
        txSigla = new JTextField();

        cbUF = new JComboBox(UF.values());

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
        cons.gridheight = 1;
        cons.ipadx = 100;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbAUF, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 3;
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

    public JPanel getPanelFormulario() {
        return panelFormulario;
    }

    public void setPanelFormulario(JPanel panelFormulario) {
        this.panelFormulario = panelFormulario;
    }

    private void addDados() {

        txNome.setText(cidade.getNomeCidade());
        txSigla.setText(cidade.getSigla());

    }

    private void addListener() {
        JButton bt;
        ActionListener actionOk = new AlterarCidadeOK();
        ActionListener actionCancelar = new CancelarListener(this);
        bt = getPaneBotoes().getBtOK();
        bt.addActionListener(actionOk);
        bt = getPaneBotoes().getBtCancelar();
        bt.addActionListener(actionCancelar);

    }

    public class AlterarCidadeOK implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            CidadeDAO dao = new CidadeDAO();
            cidade.setNomeCidade(txNome.getText());
            cidade.setSigla(txSigla.getText());
            cidade.setUf((UF) cbUF.getSelectedItem());

            try {
                dao.atualizar(cidade);
                JOptionPane.showMessageDialog(null, "Cidade alterada com sucesso");
            } catch (Exception ex) {
                Logger.getLogger(FrameAlterarCidade.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
