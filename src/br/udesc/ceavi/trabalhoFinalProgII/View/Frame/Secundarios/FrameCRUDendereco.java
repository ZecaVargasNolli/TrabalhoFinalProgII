package br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios;

import br.udesc.ceavi.trabalhoFinalProgII.Listeners.AtuliazarListener;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.GerarCidade;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.GerarEndereco;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Cidade;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Endereco;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.CidadeDAO;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.EnderecoDAO;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * Classe resprosável pela montagem do frame do cadastro de endereço. classe
 * filha da classe FrameCRUDGenerico
 *
 * @author José Vargas Nolli
 * @author Giancarlo Pandini
 * @author Gustavo José
 * @since 29/11/2018
 * @version 1.0
 */
public class FrameCRUDendereco extends FrameCRUDGenerico {

    //ATRIBUTOS
    private JLabel lbNumero;
    private JLabel lbBairro;
    private JLabel lbComplemento;
    private JLabel lbCep;
    private JLabel lbCidade;

    private JButton jbCidade;

    private JTextField txNumero;
    private JTextField txBairro;
    private JTextField txComplemento;
    private JTextField txCep;

    private LayoutManager layout;

    private JPanel panelFormulario;

    private GridBagConstraints cons;

    private JComboBox cbCidade;

    //CONSTRUTOR DA CLASSE
    public FrameCRUDendereco(String titulo, Dimension tamanho) {
        super(titulo, tamanho);

        initCom();
        initCombo();
        addCom();
        addListener();
    }

    //METODO QUE INICIA OS COMPONENETES DO FRAME
    private void initCom() {
        lbBairro = new JLabel("Bairro: ");
        lbCep = new JLabel("CEP: ");
        lbComplemento = new JLabel("Complemento: ");
        lbNumero = new JLabel("Rua: ");
        lbCidade = new JLabel("Cidade: ");

        jbCidade = new JButton("ADICIONAR");

        txNumero = new JTextField();
        txBairro = new JTextField();
        txComplemento = new JTextField();
        txCep = new JTextField();

        cbCidade = new JComboBox();

        layout = new GridBagLayout();
        panelFormulario = new JPanel(layout);

    }

    //METODO QUE ADICONA OS COMPONENETES AO FRAME
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
        panelFormulario.add(txCep, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 3;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbComplemento, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 3;
        cons.gridwidth = 2;
        cons.ipadx = 100;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(txComplemento, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 4;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbCidade, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 4;
        cons.gridwidth = 2;
        cons.ipadx = 100;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(jbCidade, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 5;
        cons.gridwidth = 2;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(cbCidade, cons);

        super.add(panelFormulario);
    }

    public JComboBox getCbCidade() {
        return cbCidade;
    }

    public void setCbCidade(JComboBox cbCidade) {
        this.cbCidade = cbCidade;
    }

    //METODO QUE INICA O COMBO BOX
    private void initCombo() {
        CidadeDAO dao = new CidadeDAO();

        List<Cidade> cidades;

        cidades = dao.buscarCidade();

        for (int i = 0; i < cidades.size(); i++) {
            cbCidade.addItem(cidades.get(i).getNomeCidade());

        }
        cbCidade.setSelectedIndex(-1);
    }

    private void addListener() {
        ActionListener actionCidade = new GerarCidade();
        jbCidade.addActionListener(actionCidade);

        JButton bt;

        bt = getPanelBotoes().getBtCadastrar();
        ActionListener actionGravar = new GravarEndereco();
        bt.addActionListener(actionGravar);
        bt = getPanelBotoes().getBtAtualizar();
        ActionListener actionCriar = new GerarEndereco();
        ActionListener actionAtualizar = new AtuliazarListener(this);
        bt.addActionListener(actionCriar);
        bt.addActionListener(actionAtualizar);
    }

    @Override//METODO PARA LIMPAR CAMPOS SUBSCRITO DA CLASSE PRINCIPAL
    public void LimparCampos() {
        super.LimparCampos();

        txBairro.setText("");
        txCep.setText("");
        txComplemento.setText("");
        txNumero.setText("");
        cbCidade.setSelectedIndex(-1);

    }

    /**
     *
     * Classe interna da classe FrameCRUDendereco qe funcina como o listener que
     * associa a ação de salvar endereco no banco ao panelGenerico.
     *
     * @author Giancarlo Pandini
     * @author José Vargas Nolli
     * @author Gustavo José
     * @since 24/11/2018
     * @version 1.0
     */
    public class GravarEndereco implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            EnderecoDAO eDAO = new EnderecoDAO();
            CidadeDAO cDAO = new CidadeDAO();

            Endereco endereco = new Endereco();
            endereco.setBairro(txBairro.getText());
            endereco.setCep(txCep.getText());
            endereco.setComplemento(txComplemento.getText());
            endereco.setNumero(txNumero.getText());

            List<Cidade> cidades = cDAO.buscarCidade();
            Cidade cid = null;
            for (Cidade cidade : cidades) {
                if (cidade.getNomeCidade() == cbCidade.getSelectedItem()) {
                    cid = cidade;
                }
            }
            endereco.setCidade(cid);
            try {
                eDAO.inserir(endereco);
                JOptionPane.showMessageDialog(null, "Enderço cadastrado com sucesso");
            } catch (Exception ex) {
                Logger.getLogger(FrameCRUDendereco.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Ocorreu um erro ao inserir no banco");
            }

            LimparCampos();
        }

    }

}
