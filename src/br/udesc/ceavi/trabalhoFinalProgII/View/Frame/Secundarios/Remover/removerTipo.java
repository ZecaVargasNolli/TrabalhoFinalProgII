package br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios.Remover;

import br.udesc.ceavi.trabalhoFinalProgII.Listeners.CancelarListener;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Tipo;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Item;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Usuario;
import br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios.Alterar.FrameAlterarTipo;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.ItemDAO;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.TipoDAO;
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
 * Classe responsavel pelo Jframe remover e alterar deTipo
 *
 * @author Giancarlo Pandini
 * @author Gustavo José
 * @author José Vargas Nolli
 * @since 29/11/2018
 * @version 1.0
 */
public class removerTipo extends FrameRemover {

    private Label lbTipo;
    private JComboBox cbTipoR;
    private LayoutManager layout;
    private JPanel paneR;
    private GridBagConstraints cons;

    public removerTipo(String titulo, Dimension tamanho) {
        super(titulo, tamanho);

        initCom();
        iniCombo();
        add();
        addListener();
    }

    private void initCom() {
        lbTipo = new Label("TIPOS: ");
        paneR = new JPanel();
        layout = new GridBagLayout();
    }

    private void iniCombo() {
        cbTipoR = new JComboBox();
        TipoDAO dao = new TipoDAO();

        List<Tipo> Tipos;

        Tipos = dao.buscarTipo();

        for (int i = 0; i < Tipos.size(); i++) {
            cbTipoR.addItem(Tipos.get(i).getNome());

        }
        cbTipoR.setSelectedIndex(-1);
    }

    private void add() {

        paneR.setLayout(layout);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 0;
        cons.ipadx = 50;
        cons.fill = GridBagConstraints.HORIZONTAL;
        paneR.add(lbTipo, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 0;
        cons.gridwidth = 2;
        cons.ipadx = 70;
        cons.fill = GridBagConstraints.HORIZONTAL;
        paneR.add(cbTipoR, cons);

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
        ActionListener actionAlterar = new AlterarTipo();
        bt = getPaneBotoes().getBtAlterar();
        bt.addActionListener(actionAlterar);
    }

    public class Remover implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // instanciando DAO nessessarias 
            ItemDAO eDAO = new ItemDAO();
            TipoDAO cDAO = new TipoDAO();

            //obtendo as Tipos do banco
            List<Tipo> todosTipos = null;
            todosTipos = cDAO.buscarTipo();
            //selecionando a fornecedor desejada
            Tipo it = null;
            for (Tipo c : todosTipos) {
                if (c.getNome() == cbTipoR.getSelectedItem()) {
                    it = c;
                }
            }

            //obtendo todos os enderecos que possuem relacionamento com a fornecedor celecionada
            List<Item> todosItems = null;
            todosItems = eDAO.buscarItemPorTipo(it);

            //desasociando a fornecedor selecionada de todos os enderecos
            for (Item end : todosItems) {
                end.setTipo(null);
            }

            try {
                //atualizando os enderecos no banco
                for (Item end : todosItems) {
                    eDAO.atualizar(end);
                }
                //finalmente removendo a fornecedor 
                cDAO.deletar(it);
                JOptionPane.showMessageDialog(null, "Tipo deletado com sucesso");
            } catch (Exception ex) {

            }

        }

    }
    public class AlterarTipo implements ActionListener{

       TipoDAO cDAO = new TipoDAO();
        List<Tipo> todosTipos = cDAO.buscarTipo();
        
        Dimension tamanho = new Dimension(400, 400);
        JFrame frame = null;
        JFrame frame2 = null;
        UsuarioDAO userDAO = new UsuarioDAO();
        Usuario user = userDAO.buscarUsuarioLogado();
        Tipo cid;
        

        @Override
        public void actionPerformed(ActionEvent e) {

           
            for (Tipo c : todosTipos) {
                if (c.getNome() == cbTipoR.getSelectedItem()) {
                    cid = c;
                }
            }

            if (user.isMaster() == true) {

                if (frame == null && frame2 == null) {

                    frame = new FrameAlterarTipo("Visualizar Tipo", tamanho, cid);

                    frame2 = null;
                    frame.setVisible(true);
                } else if (frame2 == null) {

                    frame.setVisible(false);
                    frame = null;

                    frame2 = new FrameAlterarTipo("Visualizar Tipo", tamanho, cid);

                    frame2.setVisible(true);
                } else if (frame == null) {
                    frame2.setVisible(false);

                    frame = new FrameAlterarTipo("Visualizar Tipo", tamanho, cid);
                    frame2 = null;
                    frame.setVisible(true);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Você não tem permissão para isso");
            }
        }

        
    }
}
