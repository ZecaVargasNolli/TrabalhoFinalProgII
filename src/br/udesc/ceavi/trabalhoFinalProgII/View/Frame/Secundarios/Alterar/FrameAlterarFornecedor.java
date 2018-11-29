package br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios.Alterar;

import br.udesc.ceavi.trabalhoFinalProgII.Listeners.CancelarListener;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.EnderecoDAO;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
public class FrameAlterarFornecedor extends FrameAlterar {

    //ATRIBUTOS
    private Label lbEmpresa;
    private Label lbCNPJ;
    private Label lbEndereco;
    
    private Fornecedor fornecedor;

    private Label lbENderecoF;
    private JComboBox cbEndereco;

    private Label lbValorItens;

    private JTextField tfEmpresa;
    private JTextField tfCNPJ;

    private JTextField tfItensFornecidos;

    private JPanel panelFormulario;

    private LayoutManager layout;
    private GridBagConstraints cons;

    //CONSTRUTOR DA CLASSE
    public FrameAlterarFornecedor(String titulo, Dimension tamanho,Fornecedor fornecedor) {
        super(titulo, tamanho);
        this.fornecedor = fornecedor;

        initializeComponents();
        initCombo();
        addComponents();
        addDados();
        addListener();

    }

    //METODO QUE INICIALIZA OS COMPONENTES
    private void initializeComponents() {
        lbEmpresa = new Label("Empresa: ");
        lbCNPJ = new Label("CNPJ: ");
        lbEndereco = new Label("Endereço Atual: ");
        lbENderecoF = new Label(fornecedor.getEndereco().getCep());
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
        panelFormulario.add(lbENderecoF, cons);

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

    
    //METODO QUE ADICONA OS LISTENERS AOS BOTOES
    private void addListener() {
        JButton bt;
        
bt = getPaneBotoes().getBtCancelar();
        ActionListener actionCancelar = new CancelarListener(this);
        bt.addActionListener(actionCancelar);
        ActionListener actionAlterar = new AlterarFornecedorOK();
        bt = getPaneBotoes().getBtOK();
        bt.addActionListener(actionAlterar);
       
    }

    private void addDados() {
        tfCNPJ.setText(fornecedor.getCnpj());
        tfEmpresa.setText(fornecedor.getNomeDaEmpresa());
        tfItensFornecidos.setText(fornecedor.getProdutosFornecidos());
    }

  public class AlterarFornecedorOK implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            FornecedorDAO dao = new FornecedorDAO();
            EnderecoDAO edao = new EnderecoDAO();
            List<Endereco> enderecos = null;
            Endereco end =  null;
            enderecos= edao.buscarEndereco();
            fornecedor.setCnpj(tfCNPJ.getText());
            fornecedor.setNomeDaEmpresa(tfEmpresa.getText());
            fornecedor.setProdutosFornecidos(tfItensFornecidos.getText());
            
             for (Endereco endereco : enderecos) {
                if (endereco.getCep() == cbEndereco.getSelectedItem()) {
                    end = endereco;
                }

            }

            fornecedor.setEndereco(end);
            
            
            try {
                dao.atualizar(fornecedor);
                JOptionPane.showMessageDialog(null, "Fornecedor alterada com sucesso");
            } catch (Exception ex) {
                Logger.getLogger(FrameAlterarFornecedor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
      
      
  } 
          

}
