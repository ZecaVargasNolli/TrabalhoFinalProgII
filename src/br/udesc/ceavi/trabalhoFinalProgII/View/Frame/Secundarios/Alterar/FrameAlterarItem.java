package br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios.Alterar;

import br.udesc.ceavi.trabalhoFinalProgII.Listeners.CancelarListener;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.FornecedorDAO;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Fornecedor;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Item;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Tipo;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.ItemDAO;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.TipoDAO;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
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
 * Frame responsavel por alterar os dados de Item
 *
 * @author Giancarlo Pandini
 * @author Gustavo José
 * @author José Vargas Nolli
 * @since 29/11/2018
 * @version 1.0
 */
public class FrameAlterarItem extends FrameAlterar {

    //ATRIBUTOS
    private JLabel lbNome;
    private JLabel lbTipo;
    private JLabel lbFornecedor;
    private JLabel lbDataAquisicao;

    private JTextField txNome;
    private JTextField txData;
    private Label lbTipoF;
    private Label lbFornecedorF;

    private JComboBox cbFornecedor;

    private JComboBox cbTipo;

    private LayoutManager layout;

    private GridBagConstraints cons;

    private JPanel panelFormulario;

    private Item item;

    //CONSTRUTOR DA CLASSE 
    public FrameAlterarItem(String titulo, Dimension tamanho, Item item) {
        super(titulo, tamanho);
        this.item = item;

        initCom();
        initCombo();
        addCom();
        addDados();
        addListeners();
    }

    //METODO QUE INICIA OS COMPONENTES
    private void initCom() {

        lbFornecedor = new JLabel("Fornecedor Atual: ");
        lbNome = new JLabel("Nome: ");
        lbTipo = new JLabel("Tipo Atual: ");
        lbDataAquisicao = new JLabel("Data de Aquisição: ");

        cbFornecedor = new JComboBox();
        ;

        txNome = new JTextField();

        lbTipoF = new Label(null);
        if (item.getTipo() != null) {
            lbTipoF.setText(item.getTipo().getNome());
        } 

        lbFornecedorF = new Label(null);
        if (item.getFornecedor() != null) {
            lbFornecedorF.setText(item.getFornecedor().getNomeDaEmpresa());
        }

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
        panelFormulario.add(lbFornecedorF, cons);

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
        panelFormulario.add(lbTipoF, cons);

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
        JButton bt;
        bt = getPaneBotoes().getBtCancelar();
        ActionListener actionCancelar = new CancelarListener(this);
        bt.addActionListener(actionCancelar);
        bt = getPaneBotoes().getBtOK();
        ActionListener actionAtulaizar = new AlterarItemOk();
        bt.addActionListener(actionAtulaizar);

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

    private void addDados() {
        txData.setText(item.getDatadeAquisicao());
        txNome.setText(item.getNome());
    }

    public class AlterarItemOk implements ActionListener {

        ItemDAO dao = new ItemDAO();
        TipoDAO Tdao = new TipoDAO();
        FornecedorDAO Fdao = new FornecedorDAO();

        List<Fornecedor> fornecedores = Fdao.buscarFornecedor();
        Fornecedor fod = null;
        List<Tipo> tipos = Tdao.buscarTipo();
        Tipo tip = null;

        @Override
        public void actionPerformed(ActionEvent e) {
            item.setDatadeAquisicao(txData.getText());
            item.setEmEstoque(false);
            item.setNome(txNome.getText());

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

            item.setFornecedor(fod);
            item.setTipo(tip);

            try {
                dao.atualizar(item);
                JOptionPane.showMessageDialog(null, "Item alterada com sucesso");
            } catch (Exception ex) {
                Logger.getLogger(FrameAlterarItem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
