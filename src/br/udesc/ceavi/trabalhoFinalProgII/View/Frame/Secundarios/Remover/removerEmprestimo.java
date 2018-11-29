package br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios.Remover;

import br.udesc.ceavi.trabalhoFinalProgII.Listeners.CancelarListener;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.EmprestimoDAO;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Emprestimo;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Item;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.ItemDAO;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Usuario;
import br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios.Alterar.FrameAlterarEmprestimo;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.UsuarioDAO;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Classe responsavel pelo Jframe remover e alterar de Emprestimo
 *
 * @author Giancarlo Pandini
 * @author Gustavo José
 * @author José Vargas Nolli
 * @since 29/11/2018
 * @version 1.0
 */
public class removerEmprestimo extends FrameRemover {

    private Label lbEmprestimo;
    private JComboBox cbCEmprestimoR;
    private LayoutManager layout;
    private JPanel paneR;
    private GridBagConstraints cons;

    public removerEmprestimo(String titulo, Dimension tamanho) {
        super(titulo, tamanho);

        initCom();
        iniCombo();
        add();
        addListener();
    }

    private void initCom() {
        lbEmprestimo = new Label("EMPRÉSTIMOS: ");
        paneR = new JPanel();
        layout = new GridBagLayout();
    }

    private void iniCombo() {
        cbCEmprestimoR = new JComboBox();
        EmprestimoDAO dao = new EmprestimoDAO();

        List<Emprestimo> emprestimo;

        emprestimo = dao.buscarEmprestimo();

        for (int i = 0; i < emprestimo.size(); i++) {
            cbCEmprestimoR.addItem(emprestimo.get(i).getRequisitante().getNome());

        }
        cbCEmprestimoR.setSelectedIndex(-1);
    }

    private void add() {

        paneR.setLayout(layout);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 0;
        cons.ipadx = 50;
        cons.fill = GridBagConstraints.HORIZONTAL;
        paneR.add(lbEmprestimo, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 0;
        cons.gridwidth = 2;
        cons.ipadx = 70;
        cons.fill = GridBagConstraints.HORIZONTAL;
        paneR.add(cbCEmprestimoR, cons);

        super.add(paneR);
    }

    private void addListener() {
        JButton bt;
        bt = getPaneBotoes().getBtRemover();
        ActionListener actionRemove = new Remover();
        bt.addActionListener(actionRemove);
        bt = getPaneBotoes().getBtCancelar();
        ActionListener actionCancelar = new CancelarListener(this);
        bt.addActionListener(actionCancelar);
        bt = getPaneBotoes().getBtAlterar();
        ActionListener actionAlterar = new AlterarEmprestimo();
        bt.addActionListener(actionAlterar);
    }

    public class Remover implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            EmprestimoDAO cDAO = new EmprestimoDAO();
            ItemDAO dao = new ItemDAO();
            Item it = null;

            List<Emprestimo> emprestimo = cDAO.buscarEmprestimo();
            Emprestimo end = null;
            for (Emprestimo emp : emprestimo) {
                if (emp.getRequisitante().getNome() == cbCEmprestimoR.getSelectedItem()) {
                    end = emp;
                                    }
                
            }
           if( end.getItem() == null){
               JOptionPane.showMessageDialog(null, "erro");
           }else{
                   it = end.getItem();
           }
            it.setEmEstoque(true);
            
            
            

            try {
                end.setItem(null);
                end.setRequisitante(null);
                dao.atualizar(it);
                cDAO.atualizar(end);
                cDAO.deletar(end);
                JOptionPane.showMessageDialog(null, "Emprestimo deletado com sucesso");
            } catch (Exception ex) {
                Logger.getLogger(removerEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    public class AlterarEmprestimo implements ActionListener{
        
         EmprestimoDAO cDAO = new EmprestimoDAO();
        List<Emprestimo> todasCidades = cDAO.buscarEmprestimo();
        
        Dimension tamanho = new Dimension(400, 400);
        JFrame frame = null;
        JFrame frame2 = null;
        UsuarioDAO userDAO = new UsuarioDAO();
        Usuario user = userDAO.buscarUsuarioLogado();
        Emprestimo cid;
        

        @Override
        public void actionPerformed(ActionEvent e) {

           
            for (Emprestimo c : todasCidades) {
                if (c.getRequisitante().getNome() == cbCEmprestimoR.getSelectedItem()) {
                    cid = c;
                }
            }

            if (user.isMaster() == true) {

                if (frame == null && frame2 == null) {

                    frame = new FrameAlterarEmprestimo("Visualizar Emprestimo", tamanho, cid);

                    frame2 = null;
                    frame.setVisible(true);
                } else if (frame2 == null) {

                    frame.setVisible(false);
                    frame = null;

                    frame2 = new FrameAlterarEmprestimo("Visualizar Emprestimo", tamanho, cid);

                    frame2.setVisible(true);
                } else if (frame == null) {
                    frame2.setVisible(false);

                    frame = new FrameAlterarEmprestimo("Visualizar Emprestimo", tamanho, cid);
                    frame2 = null;
                    frame.setVisible(true);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Você não tem permissão para isso");
            }
        }
    }
}
