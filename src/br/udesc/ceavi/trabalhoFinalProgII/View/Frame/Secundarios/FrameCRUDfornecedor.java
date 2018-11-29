package br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios;

import br.udesc.ceavi.trabalhoFinalProgII.Listeners.AtuliazarListener;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.GerarEndereco;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.GerarFornecedor;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.EnderecoDAO;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.LayoutManager;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.util.List;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Endereco;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Fornecedor;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.FornecedorDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 * esta Classe define o formulario do tipo CRUD para fornecedor
 *
 * @author Giancarlo
 * @since 07/09/18
 * @version 1.0
 */
public class FrameCRUDfornecedor extends FrameCRUDGenerico {

    //ATRIBUTOS
    private Label lbEmpresa;
    private Label lbCNPJ;
    private Label lbEndereco;

    private JButton Adicionar;
    private JComboBox cbEndereco;

    private Label lbValorItens;

    private JTextField tfEmpresa;
    private JTextField tfCNPJ;

    private JTextField tfItensFornecidos;

    private JPanel panelFormulario;

    private LayoutManager layout;
    private GridBagConstraints cons;

    //CONSTRUTOR DA CLASSE
    public FrameCRUDfornecedor(String titulo, Dimension tamanho) throws HeadlessException {
        super(titulo, tamanho);

        initializeComponents();
        initCombo();
        addComponents();
        addListener();

    }

    //METODO QUE INICIALIZA OS COMPONENTES
    private void initializeComponents() {
        lbEmpresa = new Label("Empresa: ");
        lbCNPJ = new Label("CNPJ: ");
        lbEndereco = new Label("Endereço: ");
        Adicionar = new JButton("ADICIONAR");
        cbEndereco = new JComboBox();

        lbValorItens = new Label("Itens Fornecidos: ");

        tfEmpresa = new JTextField();
        tfCNPJ = new JTextField();

        tfItensFornecidos = new JTextField();

        layout = new GridBagLayout();
        panelFormulario = new JPanel(layout);

    }

    //METODOQUE ADICIONA OS COMPONENTES
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
        cons.gridy = 6;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbValorItens, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 6;
        cons.gridwidth = 4;
        cons.gridheight = 4;
        cons.ipadx = 100;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(tfItensFornecidos, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 4;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbEndereco, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 4;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(Adicionar, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 5;
        cons.ipadx = 100;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(cbEndereco, cons);

        super.addFormulario(panelFormulario);

    }

    //METODO QUE INICIALIZA OS VALORES DO COMBO BOX
    private void initCombo() {

        EnderecoDAO dao = new EnderecoDAO();

        List<Endereco> enderecos;

        enderecos = dao.buscarEndereco();

        for (int i = 0; i < enderecos.size(); i++) {

            cbEndereco.addItem(enderecos.get(i).getCep());
        }
        cbEndereco.setSelectedIndex(-1);
    }

    @Override//METODO SUBSCRITO DA CLASSE MÃE QUE INICIA OS COMPONENTES
    public void LimparCampos() {
        tfCNPJ.setText("");
        tfEmpresa.setText("");
        tfItensFornecidos.setText("");
        cbEndereco.setSelectedIndex(-1);
    }

    //METODO QUE ADICONA OS LISTENERS AOS BOTOES
    private void addListener() {
        ActionListener actionAdicionar = new GerarEndereco();
        Adicionar.addActionListener(actionAdicionar);
        ActionListener actionGravar = new GravarFornecedor();
        ActionListener actionCriar = new GerarFornecedor();
        ActionListener actionAtualizar = new AtuliazarListener(this);
        JButton bt;

        bt = getPanelBotoes().getBtCadastrar();
        bt.addActionListener(actionGravar);

        bt = getPanelBotoes().getBtAtualizar();
        bt.addActionListener(actionCriar);
        bt.addActionListener(actionAtualizar);
    }

    /**
     *
     * Classe interna a classe que cria o frame de cadastro de fornecedor ,e tem
     * como função gravar os dados no banco
     *
     * @author José Vargas Nolli
     * @author Giancarlo Pandini
     * @author Gustavo José
     * @since 29/11/2018
     * @version 1.0
     */
    public class GravarFornecedor implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            FornecedorDAO dao = new FornecedorDAO();
            EnderecoDAO DAO = new EnderecoDAO();
            Endereco end = new Endereco();

            List<Endereco> enderecos = null;

            Fornecedor fornecedor = new Fornecedor();

            fornecedor.setCnpj(tfCNPJ.getText());

            fornecedor.setNomeDaEmpresa(tfEmpresa.getText());
            fornecedor.setProdutosFornecidos(tfItensFornecidos.getText());

            enderecos = DAO.buscarEndereco();
            for (Endereco endereco : enderecos) {
                if (endereco.getCep() == cbEndereco.getSelectedItem()) {
                    end = endereco;
                }

            }

            fornecedor.setEndereco(end);

            try {
                dao.inserir(fornecedor);
                JOptionPane.showMessageDialog(null, "Fornecedor cadastrado com sucesso");

            } catch (Exception ex) {

                Logger.getLogger(FrameCRUDendereco.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("deu problema no inserir no banco");
            }
            LimparCampos();
        }
    }

}
