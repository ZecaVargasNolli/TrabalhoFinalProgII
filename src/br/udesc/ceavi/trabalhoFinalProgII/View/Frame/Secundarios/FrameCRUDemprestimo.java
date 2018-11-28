package br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios;

import br.udesc.ceavi.trabalhoFinalProgII.Listeners.AtuliazarListener;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.GerarEmprestimos;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.GerarItem;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.GerarRequisitante;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Emprestimo;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Item;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Requisitante;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.EmprestimoDAO;
import java.util.List;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.ItemDAO;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.RequisitanteDAO;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.UsuarioDAO;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
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
 *
 * @author José Vargas Nolli
 */
public class FrameCRUDemprestimo extends FrameCRUDGenerico {

    private JLabel lbData;
    private JLabel lbItem;
    private JLabel lbRequisitante;


    private JButton btItem;
    private JButton btRequisitante;
  

    private JTextField txData;

    private JComboBox cbItem;
    private JComboBox cbRequisitante;
   

    private LayoutManager layout;

    private Dimension btTamanho;

    private JPanel panelFormulario;

    private GridBagConstraints cons;

    public FrameCRUDemprestimo(String titulo, Dimension tamanho) {
        super(titulo, tamanho);

        initCom();
        initCombo();
        addCom();
        addListeners();
    }

    private void initCom() {
        btTamanho = new Dimension(80, 40);

        lbData = new JLabel("Data:  ");
        lbItem = new JLabel("Item:  ");
        lbRequisitante = new JLabel("Requisitante:  ");
       
        //verificar como funciona para usar a classe presente no banco.
        cbItem = new JComboBox();
       
        cbRequisitante = new JComboBox();
        
        

        String add = "ADICIONAR";

        btItem = new JButton(add);
        btItem.setSize(btTamanho);
        btRequisitante = new JButton(add);
        btRequisitante.setSize(btTamanho);
      

        MaskFormatter mask = null;

        try {
            mask = new MaskFormatter("  ##/##/####  ");
            mask.setPlaceholderCharacter(' ');

        } catch (ParseException e) {
            e.printStackTrace();
        }
        txData = new JFormattedTextField(mask);

        layout = new GridBagLayout();

        panelFormulario = new JPanel(layout);

    }

    private void addCom() {

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 0;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbData, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 0;
        cons.gridwidth = 2;
        cons.ipadx = 60;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(txData, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 1;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbItem, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 1;
        cons.gridwidth = 2;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(btItem, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 2;
        cons.gridwidth = 2;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(cbItem, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 3;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbRequisitante, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 3;
        cons.gridwidth = 2;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(btRequisitante, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 4;
        cons.gridwidth = 2;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(cbRequisitante, cons);

        super.add(panelFormulario);

    }

    private void initCombo() {

        ItemDAO idao = new ItemDAO();
        List<Item> itens = idao.buscarItem();
        RequisitanteDAO rdao = new RequisitanteDAO();
        List<Requisitante> requis = rdao.buscarRequisitante();

        for (int i = 0; i < itens.size(); i++) {
            cbItem.addItem(itens.get(i).getNome());
        }
        cbItem.setSelectedIndex(-1);
        for (int i = 0; i < requis.size(); i++) {
            cbRequisitante.addItem(requis.get(i).getNome());
        }
        cbRequisitante.setSelectedIndex(-1);
    }

    private void addListeners() {

        ActionListener actionRequisitante = new GerarRequisitante();

        ActionListener actionItem = new GerarItem();
        
        ActionListener actionCriar = new GerarEmprestimos();
        ActionListener actionAtualizar = new AtuliazarListener(this);

        btItem.addActionListener(actionItem);
        btRequisitante.addActionListener(actionRequisitante);
        
        JButton bt;
        
        bt = getPanelBotoes().getBtCadastrar();
        ActionListener actionGravar = new GravarEmprestimo();
        bt.addActionListener(actionGravar);
        bt = getPanelBotoes().getBtAtualizar();
        bt.addActionListener(actionAtualizar);
        bt.addActionListener(actionCriar);

    }

    @Override
    public void LimparCampos() {
        super.LimparCampos();
        txData.setText("");
        cbItem.setSelectedIndex(-1);
        cbRequisitante.setSelectedIndex(-1);
        
    }

    public class GravarEmprestimo implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            //criando o emprestimo e setando a data 
            Emprestimo emprestimo = new Emprestimo();
            emprestimo.setData(txData.getText());

            //instanciando os DAOs nessessarios
            EmprestimoDAO eDAO = new  EmprestimoDAO();
            ItemDAO iDAO = new ItemDAO();
            RequisitanteDAO rDAO = new RequisitanteDAO();
            UsuarioDAO uDAO = new UsuarioDAO();

            //encontrando o item desejado no banco, e setando no emprestimo
            List<Item> todosItens = null;
            todosItens = iDAO.buscarItem();
            Item item = null;

            for (Item i : todosItens) {
                if (i.getNome() == cbItem.getSelectedItem()) {
                    item = i;
                }
            }
            emprestimo.setItem(item);
            item.setEmEstoque(false);
            
            //encontrando o requisitante desejado no banco, e setando no emprestimo
            List<Requisitante> todosRequisitantes = null;
            todosRequisitantes = rDAO.buscarRequisitante();
            Requisitante requisitante = null;
            
            for (Requisitante r : todosRequisitantes) {
                if(r.getNome()==cbRequisitante.getSelectedItem()){
                    requisitante = r;
                }
            }
            emprestimo.setRequisitante(requisitante);
            
           
           
            
            
             //adicionando o novo emprestimo ao banco
            try {   
                iDAO.atualizar(item);
                eDAO.inserir(emprestimo);
                 JOptionPane.showMessageDialog(null, "Emprestimo cadastrado com sucesso");
            } catch (Exception ex) {
                Logger.getLogger(FrameCRUDemprestimo.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Erro ao cadastrar o emprestimo");
            }
            
            LimparCampos();
        }
    }
}
