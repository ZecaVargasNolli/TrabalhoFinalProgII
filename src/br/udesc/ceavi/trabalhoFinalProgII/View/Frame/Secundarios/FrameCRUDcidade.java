package br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios;

import br.udesc.ceavi.trabalhoFinalProgII.Model.Cidade;
import br.udesc.ceavi.trabalhoFinalProgII.Model.UF;
import br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios.FrameCRUDcidade.GravarCidade;
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

   protected JTextField txNome;
   protected JTextField txSigla;

   protected JComboBox cbUF;

    private JPanel panelFormulario;

    private LayoutManager layout;
    private GridBagConstraints cons;
//-----------------------------------------

   
    
    //CONSTRUTOR DA CLASSE FrameCRUDcidade
    public FrameCRUDcidade(String titulo, Dimension tamanho) {
        super(titulo, tamanho);

        initCom();
        addCom();
        addCRUD();

    }

    //METODO RESPONSÁVEL POR INICIAR OS COMPONENTES DO FORMULARIO DA CLASSE
    private void initCom() {
        lbNome = new JLabel("Nome: ");
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

    public JPanel getPanelFormulario() {
        return panelFormulario;
    }

    public void setPanelFormulario(JPanel panelFormulario) {
        this.panelFormulario = panelFormulario;
    }

  
    

    private void addCRUD(){
        JButton bt;
        
        bt = getPanelBotoes().getBtCadastrar();
        ActionListener actionGravarcidade = new GravarCidade();
        bt.addActionListener(actionGravarcidade);
        bt = getPanelBotoes().getBtAtualizar();
        bt.setVisible(false);
       
    }

    
    
    
    
    /**
     *
     * Classe interna da classe  FrameCRUDcidade qe funcina como o listener que associa 
     * a ação de salvar cidade no banco ao panelGenerico.
     * 
     * @author José Vargas Nolli
     * @since 24/11/2018
     * @version 1.0
     */
   public class GravarCidade implements ActionListener{

        @Override//AÇÃO QUE GRAVA A CIDADE NO BANCO DE DADOS.
        public void actionPerformed(ActionEvent e) {
            CidadeDAO dao = new CidadeDAO();
            
            Cidade cid = new Cidade();
            
            cid.setNomeCidade(txNome.getText());
            cid.setSigla(txSigla.getText());
            cid.setUf((UF) cbUF.getSelectedItem());
            try {
                dao.inserir(cid);
                JOptionPane.showMessageDialog(null, "Cidade cadastrada com sucesso");
            } catch (Exception ex) {
                Logger.getLogger(FrameCRUDcidade.class.getName()).log(Level.SEVERE, null, ex);
                //criar a exepcion para isso.
            }
            
           
            
            LimparCampos();
            
               
            
            
        }
        
    
}
     
    @Override//METODO RESPONSAVEL  OR LIMPAR OS CAMPOS DO JFRAME CIDADE
    public void LimparCampos() {
        super.LimparCampos();
        
        txNome.setText("");
        txSigla.setText("");
        cbUF.setSelectedIndex(-1);
        
        
    }
   
  
   
            
   }
   

