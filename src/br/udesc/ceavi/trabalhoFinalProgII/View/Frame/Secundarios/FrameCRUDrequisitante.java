package br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios;

import br.udesc.ceavi.trabalhoFinalProgII.Model.Requisitante;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.RequisitanteDAO;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Frame CRUD responsável pelo formulário de requisitante.
 *
 *
 * @author José Vargas Nolli
 * @author Giancarlo Pandini
 * @author Gustavao José
 * @since 29/11/2018
 * @version 1.0
 *
 */
public class FrameCRUDrequisitante extends FrameCRUDGenerico {

    //ATRIBUTOS
    private JLabel lbNome;
    private JLabel lbSetor;
    private JLabel lbCpf;
    private JLabel lbRg;

    private JTextField txNome;
    private JTextField txSetor;
    private JTextField txCpf;
    private JTextField txRg;

    private LayoutManager layout;

    private GridBagConstraints cons;

    private JPanel panelFormulario;

    //CONSTRUTOR DA CLASSE
    public FrameCRUDrequisitante(String titulo, Dimension tamanho) {
        super(titulo, tamanho);

        initCom();
        addCom();
        addListener();
    }

    //METODO QUE INICIA OS COMPONENTES NO FRAME
    private void initCom() {

        lbCpf = new JLabel("CPF: ");
        lbNome = new JLabel("Nome: ");
        lbRg = new JLabel("RG: ");
        lbSetor = new JLabel("Setor: ");

        txCpf = new JTextField();
        txNome = new JTextField();
        txRg = new JTextField();
        txSetor = new JTextField();

        layout = new GridBagLayout();

        panelFormulario = new JPanel(layout);
    }

    //METODO QUE ADICONA OS COMPONENTES NO FRAME
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
        panelFormulario.add(lbCpf, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 1;
        cons.gridwidth = 2;
        cons.ipadx = 100;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(txCpf, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 2;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbRg, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 2;
        cons.gridwidth = 2;
        cons.ipadx = 100;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(txRg, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 4;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbSetor, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 4;
        cons.gridwidth = 2;
        cons.ipadx = 100;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(txSetor, cons);

        super.add(panelFormulario);

    }

    @Override//METODO QUE LIMPA OS CAMPOS DO FRAME
    public void LimparCampos() {
        super.LimparCampos();

        txCpf.setText("");
        txNome.setText("");
        txRg.setText("");
        txSetor.setText("");
    }

    //METODO PARA ADICIONAR OS LISTENER NOS BOTOES
    private void addListener() {
        ActionListener actionGravar = new GravarRequisitante();
        JButton bt;
        bt = getPanelBotoes().getBtCadastrar();
        bt.addActionListener(actionGravar);
        bt = getPanelBotoes().getBtAtualizar();
        bt.setVisible(false);
    }

    /**
     *
     * Classe interna do frame requisitante e tem como função gravar os dados em
     * banco
     *
     * @author José Vargas Nolli
     * @author Giancarlo Pandini
     * @author Gustavo José
     * @since 29/11/2018
     * @version 1.0
     */
    public class GravarRequisitante implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            RequisitanteDAO dao = new RequisitanteDAO();

            Requisitante requi = new Requisitante();

            requi.setCpf(txCpf.getText());
            requi.setNome(txNome.getText());
            requi.setRg(txRg.getText());
            requi.setSetor(txSetor.getText());

            try {
                dao.inserir(requi);
                JOptionPane.showMessageDialog(null, "Requisitante cadastrado com sucesso");
            } catch (Exception ex) {

                Logger.getLogger(FrameCRUDcidade.class.getName()).log(Level.SEVERE, null, ex);
            }

            LimparCampos();
        }

    }
}
