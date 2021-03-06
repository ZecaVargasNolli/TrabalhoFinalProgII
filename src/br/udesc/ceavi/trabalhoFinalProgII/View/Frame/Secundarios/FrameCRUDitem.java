package br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios;

import br.udesc.ceavi.trabalhoFinalProgII.Listeners.AtuliazarListener;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.GerarFornecedor;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.GerarItem;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.GerarTipo;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.FornecedorDAO;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Fornecedor;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Item;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Tipo;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.ItemDAO;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.TipoDAO;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

/**
 * Classe responsável pelo formato do formulário que gera os cadastros de itens.
 *
 * @author José Vargas Nolli
 * @author Giancarlo Pandini
 * @author Gustavo José
 * @since 29/11/2018
 * @version 1.0
 */
public class FrameCRUDitem extends FrameCRUDGenerico {

    //ATRIBUTOS
    private JLabel lbNome;
    private JLabel lbTipo;
    private JLabel lbFornecedor;
    private JLabel lbDataAquisicao;

    private JTextField txNome;
    private JTextField txData;
    private JButton jbTipo;
    private JButton jbFornecedor;

    private JComboBox cbFornecedor;

    private JComboBox cbTipo;

    private LayoutManager layout;

    private GridBagConstraints cons;

    private Dimension tamanhoButton;

    private JPanel panelFormulario;

    //CONSTRUTOR DA CLASSE 
    public FrameCRUDitem(String titulo, Dimension tamanho) {
        super(titulo, tamanho);

        initCom();
        initCombo();
        addCom();
        addListeners();
    }

    //METODO QUE INICIA OS COMPONENTES
    private void initCom() {
        tamanhoButton = new Dimension(100, 50);
        lbFornecedor = new JLabel("Fornecedor: ");
        lbNome = new JLabel("Nome: ");
        lbTipo = new JLabel("Tipo: ");
        lbDataAquisicao = new JLabel("Data de Aquisição: ");

        cbFornecedor = new JComboBox();
        ;

        txNome = new JTextField();

        jbTipo = new JButton("ADICIONAR");
        jbTipo.setSize(tamanhoButton);

        jbFornecedor = new JButton("ADICIONAR");
        jbFornecedor.setSize(tamanhoButton);

        MaskFormatter mask = null;

        try {
            mask = new MaskFormatter("  ##/##/####  ");
            mask.setPlaceholderCharacter(' ');

        } catch (ParseException e) {
            e.printStackTrace();
        }

        txData = new JFormattedTextField(mask);

        cbTipo = new JComboBox();

        layout = new GridBagLayout();
        panelFormulario = new JPanel(layout);
    }
//METODO QUE ADICONA OS COMPONENTES

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

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 5;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbDataAquisicao, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 5;
        cons.gridwidth = 2;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(txData, cons);

        super.add(panelFormulario);

    }

    //METODO QUE ADICIONA OS LISTENERS AOS BOTOES
    private void addListeners() {
        ActionListener actionFornecedor = new GerarFornecedor();
        ActionListener actionTipo = new GerarTipo();
        jbFornecedor.addActionListener(actionFornecedor);
        jbTipo.addActionListener(actionTipo);
        ActionListener actionGravar = new GravarItem();
        JButton bt;
        bt = getPanelBotoes().getBtCadastrar();
        bt.addActionListener(actionGravar);
        bt = getPanelBotoes().getBtAtualizar();
        ActionListener actionCriar = new GerarItem();
        ActionListener actionAtualizar = new AtuliazarListener(this);
        bt.addActionListener(actionCriar);
        bt.addActionListener(actionAtualizar);

    }

    //METODO QUE ADICONA  OS DADOS NO COMBO BOX
    private void initCombo() {
        TipoDAO dao = new TipoDAO();
        FornecedorDAO daof = new FornecedorDAO();

        List<Fornecedor> ford;
        List<Tipo> tip;

        ford = daof.buscarFornecedor();
        tip = dao.buscarTipo();

        for (int i = 0; i < tip.size(); i++) {

            cbTipo.addItem(tip.get(i).getNome());

        }
        cbTipo.setSelectedIndex(-1);
        for (int j = 0; j < ford.size(); j++) {
            cbFornecedor.addItem(ford.get(j).getNomeDaEmpresa());

        }
        cbFornecedor.setSelectedIndex(-1);

    }

    /**
     *
     * Classe interna do fram item que tem como função gravar um item no banco.
     * esta classe implementa a interface action listener
     *
     * @author José Vargas Nolli
     * @author Giancarlo Pandini
     * @author Gustavo José
     * @since 29/11/2018
     * @version 1.0
     */
    public class GravarItem implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            FornecedorDAO fDAO = new FornecedorDAO();
            TipoDAO tDAO = new TipoDAO();

            List<Tipo> tipos;
            tipos = tDAO.buscarTipo();

            List<Fornecedor> fornecedores;
            fornecedores = fDAO.buscarFornecedor();

            Fornecedor fod = new Fornecedor();
            Tipo tip = new Tipo();

            ItemDAO dao = new ItemDAO();
            Item item = new Item();

            for (Fornecedor fornecedor : fornecedores) {
                if (cbFornecedor.getSelectedItem() == fornecedor.getNomeDaEmpresa()) {
                    fod = fornecedor;

                }

            }

            for (Tipo tipo : tipos) {
                if (tipo.getNome() == cbTipo.getSelectedItem()) {
                    tip = tipo;
                }
            }
            item.setNome(txNome.getText());
            item.setDatadeAquisicao(txData.getText());

            try {
                dao.inserir(item);
                item.setFornecedor(fod);
                item.setTipo(tip);
                dao.atualizar(item);
                JOptionPane.showMessageDialog(null, "Item cadastrado com sucesso");
            } catch (Exception ex) {
                Logger.getLogger(FrameCRUDendereco.class.getName()).log(Level.SEVERE, null, ex);

            }

            LimparCampos();

        }

    }

    @Override//METODO PARA LIMPAR CAMPOS ERDADO DA CLASSE MÃE DE FrameCRUDitem
    public void LimparCampos() {

        txData.setText("");
        txNome.setText("");
        cbFornecedor.setSelectedIndex(-1);
        cbTipo.setSelectedIndex(-1);
    }

}
