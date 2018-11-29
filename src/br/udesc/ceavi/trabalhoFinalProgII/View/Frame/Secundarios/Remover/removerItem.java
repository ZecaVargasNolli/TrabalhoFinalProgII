package br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios.Remover;

import br.udesc.ceavi.trabalhoFinalProgII.Listeners.CancelarListener;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Emprestimo;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Item;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Usuario;
import br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios.Alterar.FrameAlterarItem;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.CidadeDAO;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.EmprestimoDAO;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.ItemDAO;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.UsuarioDAO;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Classe responsavel pelo Jframe remover e alterar de Item
 *
 * @author Giancarlo Pandini
 * @author Gustavo José
 * @author José Vargas Nolli
 * @since 29/11/2018
 * @version 1.0
 */
public class removerItem extends FrameRemover {

    private Label lbItem;
    private JComboBox cbItemR;
    private LayoutManager layout;
    private JPanel paneR;
    private GridBagConstraints cons;

    public removerItem(String titulo, Dimension tamanho) {
        super(titulo, tamanho);

        initCom();
        iniCombo();
        add();
        addListener();
    }

    private void initCom() {
        lbItem = new Label("Itens: ");
        paneR = new JPanel();
        layout = new GridBagLayout();
    }

    private void iniCombo() {
        cbItemR = new JComboBox();
        ItemDAO dao = new ItemDAO();

        List<Item> itens;

        itens = dao.buscarItem();

        for (int i = 0; i < itens.size(); i++) {
            cbItemR.addItem(itens.get(i).getNome());

        }
        cbItemR.setSelectedIndex(-1);
    }

    private void add() {

        paneR.setLayout(layout);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 0;
        cons.ipadx = 50;
        cons.fill = GridBagConstraints.HORIZONTAL;
        paneR.add(lbItem, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 0;
        cons.gridwidth = 2;
        cons.ipadx = 70;
        cons.fill = GridBagConstraints.HORIZONTAL;
        paneR.add(cbItemR, cons);

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
        ActionListener actionAlterar= new AlterarItem();
        bt.addActionListener(actionAlterar);
    }

    public class Remover implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // instanciando DAO nessessarias 
            ItemDAO eDAO = new ItemDAO();
            EmprestimoDAO cDAO = new EmprestimoDAO();

            List<Item> todosItem;
            todosItem = eDAO.buscarItem();
            Item it = null;
            for (Item end : todosItem) {
                it = end;
            }

            List<Emprestimo> todosEmprestimo = null;
            todosEmprestimo = cDAO.buscarEmprestimoPorItem(it);

           
            for (Emprestimo end : todosEmprestimo) {
                end.setItem(null);
            }
            try {

                for (Emprestimo nog : todosEmprestimo) {
                    cDAO.atualizar(nog);
                }

                //finalmente removendo a fornecedor 
                eDAO.deletar(it);
                JOptionPane.showMessageDialog(null, "Item deletado com sucesso");
            } catch (Exception ex) {

            }

        }

    }
    public class AlterarItem implements ActionListener{
        ItemDAO cDAO = new ItemDAO();
        List<Item> todosItens = cDAO.buscarItem();
        
        Dimension tamanho = new Dimension(400, 400);
        JFrame frame = null;
        JFrame frame2 = null;
        UsuarioDAO userDAO = new UsuarioDAO();
        Usuario user = userDAO.buscarUsuarioLogado();
        Item cid;
        

        @Override
        public void actionPerformed(ActionEvent e) {

           
            for (Item c : todosItens) {
                if (c.getNome() == cbItemR.getSelectedItem()) {
                    cid = c;
                }
            }

            if (user.isMaster() == true) {

                if (frame == null && frame2 == null) {

                    frame = new FrameAlterarItem("Visualizar Item", tamanho, cid);

                    frame2 = null;
                    frame.setVisible(true);
                } else if (frame2 == null) {

                    frame.setVisible(false);
                    frame = null;

                    frame2 = new FrameAlterarItem("Visualizar Item", tamanho, cid);

                    frame2.setVisible(true);
                } else if (frame == null) {
                    frame2.setVisible(false);

                    frame = new FrameAlterarItem("Visualizar Item", tamanho, cid);
                    frame2 = null;
                    frame.setVisible(true);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Você não tem permissão para isso");
            }
        }

    }
}
