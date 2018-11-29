package br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios.Alterar;

import br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios.*;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.AtuliazarListener;
import br.udesc.ceavi.trabalhoFinalProgII.Listeners.CancelarListener;
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
public class FrameAlterarEmprestimo extends FrameAlterar {

    private JLabel lbData;
    private JLabel lbItem;
    private JLabel lbRequisitante;


    private JLabel lbItemF;
    private JLabel lbRequisitanteF;
    
    private Emprestimo emprestimo;
  

    private JTextField txData;

    private JComboBox cbItem;
    private JComboBox cbRequisitante;
   

    private LayoutManager layout;

    private Dimension btTamanho;

    private JPanel panelFormulario;

    private GridBagConstraints cons;

    public FrameAlterarEmprestimo(String titulo, Dimension tamanho,Emprestimo emprestimo) {
        super(titulo, tamanho);

        this.emprestimo = emprestimo;
        initCom();
        initCombo();
        addCom();
        addDados();
        addListeners();
    }

    private void initCom() {
        btTamanho = new Dimension(80, 40);

        lbData = new JLabel("Data:  ");
        lbItem = new JLabel("Item Atual:  ");
        lbRequisitante = new JLabel("Requisitante Atual:  ");
       
        
        cbItem = new JComboBox();
       
        cbRequisitante = new JComboBox();
        
        


        lbItemF = new JLabel(emprestimo.getItem().getNome());
        lbItemF.setSize(btTamanho);
        lbRequisitanteF = new JLabel(emprestimo.getRequisitante().getNome());
        lbRequisitanteF.setSize(btTamanho);
      

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
        panelFormulario.add(lbItemF, cons);

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
        panelFormulario.add(lbRequisitanteF, cons);

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
           JButton bt;
           
           bt = getPaneBotoes().getBtCancelar();
           ActionListener actionCancelar = new CancelarListener(this);
           bt.addActionListener(actionCancelar);
           bt = getPaneBotoes().getBtOK();
           ActionListener actionAlterar = new AlterarEmprestimoOK();
           bt.addActionListener(actionAlterar);

      

        
       
        
       
    }

    private void addDados() {
        txData.setText(emprestimo.getData());
    }

   
    public class AlterarEmprestimoOK implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           EmprestimoDAO dao = new EmprestimoDAO();
            ItemDAO iDAO = new ItemDAO();
            RequisitanteDAO rDAO = new RequisitanteDAO();
            
            List<Item> todosItens = null;
            todosItens = iDAO.buscarItem();
            Item item = null;

            for (Item i : todosItens) {
                if (i.getNome() == cbItem.getSelectedItem()) {
                    item = i;
                }
            }
           emprestimo.setItem(item);
            
           
            List<Requisitante> todosRequisitantes = null;
            todosRequisitantes = rDAO.buscarRequisitante();
            Requisitante requisitante = null;
            
            for (Requisitante r : todosRequisitantes) {
                if(r.getNome()==cbRequisitante.getSelectedItem()){
                    requisitante = r;
                }
            }
            emprestimo.setRequisitante(requisitante);
            
            emprestimo.setData(txData.getText());
            
            try {
                dao.atualizar(emprestimo);
                JOptionPane.showMessageDialog(null, "Emprestimo alterada com sucesso");
            } catch (Exception ex) {
                Logger.getLogger(FrameAlterarEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
        }
        
    }
    

    
}
