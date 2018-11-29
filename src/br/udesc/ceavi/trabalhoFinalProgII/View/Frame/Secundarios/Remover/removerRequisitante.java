package br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios.Remover;

import br.udesc.ceavi.trabalhoFinalProgII.Listeners.CancelarListener;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Requisitante;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Emprestimo;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Usuario;
import br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios.Alterar.FrameAlterarRequisitante;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.EmprestimoDAO;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.RequisitanteDAO;
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
 * Classe responsavel pelo Jframe remover e alterar de Requisitante
 *
 * @author Giancarlo Pandini
 * @author Gustavo José
 * @author José Vargas Nolli
 * @since 29/11/2018
 * @version 1.0
 */
public class removerRequisitante extends FrameRemover {

    private Label lbRequisitante;
    private JComboBox cbRequisitanteR;
    private LayoutManager layout;
    private JPanel paneR;
    private GridBagConstraints cons;

    public removerRequisitante(String titulo, Dimension tamanho) {
        super(titulo, tamanho);

        initCom();
        iniCombo();
        add();
        addListener();
    }

    private void initCom() {
        lbRequisitante = new Label("REQUISITANTES: ");
        paneR = new JPanel();
        layout = new GridBagLayout();
    }

    private void iniCombo() {
        cbRequisitanteR = new JComboBox();
        RequisitanteDAO dao = new RequisitanteDAO();

        List<Requisitante> requisitantes;

        requisitantes = dao.buscarRequisitante();

        for (int i = 0; i < requisitantes.size(); i++) {
            cbRequisitanteR.addItem(requisitantes.get(i).getNome());

        }
        cbRequisitanteR.setSelectedIndex(-1);
    }

    private void add() {

        paneR.setLayout(layout);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 0;
        cons.ipadx = 50;
        cons.fill = GridBagConstraints.HORIZONTAL;
        paneR.add(lbRequisitante, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 0;
        cons.gridwidth = 2;
        cons.ipadx = 70;
        cons.fill = GridBagConstraints.HORIZONTAL;
        paneR.add(cbRequisitanteR, cons);

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
        ActionListener actionAlterar = new AlterarRequisitante();
        bt.addActionListener(actionAlterar);
    }

    public class Remover implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // instanciando DAO nessessarias 
            RequisitanteDAO eDAO = new RequisitanteDAO();
            EmprestimoDAO cDAO = new EmprestimoDAO();

            //obtendo as requisitantes do banco
            List<Requisitante> todosRequisitante = null;
            todosRequisitante = eDAO.buscarRequisitante();
            //selecionando a requisitante desejada
            Requisitante requisitante = null;
            for (Requisitante c : todosRequisitante) {
                if (c.getNome() == cbRequisitanteR.getSelectedItem()) {
                    requisitante = c;
                }
            }

            //obtendo todos os enderecos que possuem relacionamento com a requisitante celecionada
            List<Emprestimo> todosEmprestimos = null;
            todosEmprestimos = cDAO.buscarEmprestimoPorRequisitante(requisitante);

            //desasociando a requisitante selecionada de todos os enderecos
            for (Emprestimo end : todosEmprestimos) {
                end.setRequisitante(null);
            }

            try {
                //atualizando os enderecos no banco
                for (Emprestimo emp : todosEmprestimos) {
                    cDAO.atualizar(emp);
                }
                //finalmente removendo a requisitante 
                eDAO.deletar(requisitante);
                JOptionPane.showMessageDialog(null, "Requisitante deletado com sucesso");
            } catch (Exception ex) {

            }

        }

    }
    public class AlterarRequisitante implements ActionListener{
        RequisitanteDAO cDAO = new RequisitanteDAO();
        List<Requisitante> todasEnderecos = cDAO.buscarRequisitante();

        Dimension tamanho = new Dimension(400, 400);
        JFrame frame = null;
        JFrame frame2 = null;
        UsuarioDAO userDAO = new UsuarioDAO();
        Usuario user = userDAO.buscarUsuarioLogado();
        Requisitante cid;

        @Override
        public void actionPerformed(ActionEvent e) {
            for (Requisitante c : todasEnderecos) {
                if (c.getNome() == cbRequisitanteR.getSelectedItem()) {
                    cid = c;
                }
            }

            if (user.isMaster() == true) {

                if (frame == null && frame2 == null) {

                    frame = new FrameAlterarRequisitante("Visualizar Requisitante", tamanho, cid);

                    frame2 = null;
                    frame.setVisible(true);
                } else if (frame2 == null) {

                    frame.setVisible(false);
                    frame = null;

                    frame2 = new FrameAlterarRequisitante("Visualizar Requisitante", tamanho, cid);

                    frame2.setVisible(true);
                } else if (frame == null) {
                    frame2.setVisible(false);

                    frame =  new FrameAlterarRequisitante("Visualizar Requisitante", tamanho, cid);
                    frame2 = null;
                    frame.setVisible(true);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Você não tem permissão para isso");
            }
        }
    }
}
