package br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios.Alterar;

import br.udesc.ceavi.trabalhoFinalProgII.Listeners.CancelarListener;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Cidade;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Endereco;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.CidadeDAO;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.EnderecoDAO;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
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
 * Frame responsavel por alterar os dados de endereço
 *
 * @author Giancarlo Pandini
 * @author Gustavo José
 * @author José Vargas Nolli
 * @since 29/11/2018
 * @version 1.0
 */
public class FrameAlterarEndereco extends FrameAlterar {
    
    private JLabel lbNumero;
    private JLabel lbBairro;
    private JLabel lbComplemento;
    private JLabel lbCep;
    private JLabel lbCidade;
    private Label lbCidadeA;
    
    private Endereco endereco;
    
    private JTextField txNumero;
    private JTextField txBairro;
    private JTextField txComplemento;
    private JTextField txCep;
    
    private LayoutManager layout;
    
    private JPanel panelFormulario;
    
    private GridBagConstraints cons;
    
    private JComboBox cbCidade;
    
    public FrameAlterarEndereco(String titulo, Dimension tamanho, Endereco endereco) {
        super(titulo, tamanho);
        this.endereco = endereco;
        
        initCom();
        initCombo();
        addCom();
        addDados();
        addListener();
    }
    
    private void initCom() {
        lbBairro = new JLabel("Bairro: ");
        lbCep = new JLabel("CEP: ");
        lbComplemento = new JLabel("Complemento: ");
        lbNumero = new JLabel("Rua: ");
        lbCidade = new JLabel("Cidade Atual: ");
        lbCidadeA = new Label(null);
       
        if (endereco.getCidade() != null) {
            lbCidadeA.setText(endereco.getCidade().getNomeCidade());
        }
        
        txNumero = new JTextField();
        txBairro = new JTextField();
        txComplemento = new JTextField();
        txCep = new JTextField();
        
        cbCidade = new JComboBox();
        
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
        panelFormulario.add(lbCidadeA, cons);
        
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
        JButton bt;
        ActionListener actionCancelar = new CancelarListener(this);
        bt = getPaneBotoes().getBtCancelar();
        bt.addActionListener(actionCancelar);
        ActionListener actionAlterar = new AlterarEndrecoOK();
        bt = getPaneBotoes().getBtOK();
        bt.addActionListener(actionAlterar);
        
    }
    
    private void addDados() {
        
        txBairro.setText(endereco.getBairro());
        txCep.setText(endereco.getCep());
        txComplemento.setText(endereco.getComplemento());
        txNumero.setText(endereco.getNumero());
    }
    
    public class AlterarEndrecoOK implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            EnderecoDAO dao = new EnderecoDAO();
            CidadeDAO cDAO = new CidadeDAO();
            List<Cidade> cidades = cDAO.buscarCidade();
            Cidade cid = null;
            for (Cidade cidade : cidades) {
                if (cidade.getNomeCidade() == cbCidade.getSelectedItem()) {
                    cid = cidade;
                }
            }
            endereco.setCidade(cid);
            endereco.setBairro(txBairro.getText());
            endereco.setCep(txCep.getText());
            endereco.setComplemento(txComplemento.getText());
            endereco.setNumero(txNumero.getText());
            
            try {
                dao.atualizar(endereco);
                JOptionPane.showMessageDialog(null, "Endereço alterada com sucesso");
            } catch (Exception ex) {
                Logger.getLogger(FrameAlterarEndereco.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
}
