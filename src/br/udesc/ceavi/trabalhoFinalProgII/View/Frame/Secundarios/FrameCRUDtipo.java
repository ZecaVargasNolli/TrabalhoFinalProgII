package br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios;

import br.udesc.ceavi.trabalhoFinalProgII.Model.Categoria;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Tipo;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.TipoDAO;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * esta Classe define o formulario do tipo CRUD para Tipo.
 *
 * @author Giancarlo Pandini
 * @author José Vargas Nolli
 * @author Gustavo José
 * @since 07/09/2018
 * @version 1.0
 */
public class FrameCRUDtipo extends FrameCRUDGenerico {

    //ATRIBUTOS
    private Label lbDescriscao;
    private Label lbNome;
    private Label lbCategorias;

    private JTextField tfDescricao;
    private JTextField tfNome;

    private JComboBox cbCategoria;

    private JPanel panelFormulario;

    private static final Dimension dimensao = new Dimension(500, 300);
    private LayoutManager layout;
    private GridBagConstraints cons;

    //CONSTRUTOR DA CLASSE
    public FrameCRUDtipo(String titulo, Dimension tamanho) {
        super(titulo, tamanho);

        initializeComponents();
        addComponents();
        addTipo();
    }

    //METODO QUE INICALIZA OS COMPONENTES
    private void initializeComponents() {
        lbDescriscao = new Label("Descrição: ");
        lbNome = new Label("Nome: ");
        lbCategorias = new Label("Categoria: ");

        tfDescricao = new JTextField();
        tfNome = new JTextField();

        cbCategoria = new JComboBox(Categoria.values());
        cbCategoria.setSelectedIndex(-1);

        layout = new GridBagLayout();
        panelFormulario = new JPanel(layout);

    }

    //METODO QUE ADICONA OS COMPONENTES
    private void addComponents() {
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
        panelFormulario.add(tfNome, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 1;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbDescriscao, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 1;
        cons.gridwidth = 2;
        cons.ipadx = 100;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(tfDescricao, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 2;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbCategorias, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 2;
        cons.gridwidth = 2;
        cons.ipadx = 100;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(cbCategoria, cons);

        super.addFormulario(panelFormulario);
    }

    @Override//METODO PARA LIMPAR OS CAMPOS DO FRAME
    public void LimparCampos() {
        super.LimparCampos();
        cbCategoria.setSelectedIndex(-1);
        tfDescricao.setText("");
        tfNome.setText("");
    }

    //METODO QUE ADICONA OS LISTENER NOS BOTOES
    private void addTipo() {

        ActionListener actionGravar = new GravarTipo();
        JButton bt;
        bt = getPanelBotoes().getBtCadastrar();
        bt.addActionListener(actionGravar);
        bt = getPanelBotoes().getBtAtualizar();
        bt.setVisible(false);
    }

    /**
     * Classe interna responsável por gravar os dadso de tipo no banco
     *
     * @author José Vargas Nolli
     * @author Giancarlo pandini
     * @author Gustavo José
     * @since 29/11/2018
     * @version 1.0
     */
    public class GravarTipo implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            TipoDAO dao = new TipoDAO();

            Tipo tip = new Tipo();

            tip.setCategoria((Categoria) cbCategoria.getSelectedItem());

            tip.setDescricao(tfDescricao.getText());
            tip.setNome(tfNome.getText());

            try {
                dao.inserir(tip);
                JOptionPane.showMessageDialog(null, "Tipo cadastrado com sucesso");
            } catch (Exception ex) {
                Logger.getLogger(FrameCRUDcidade.class.getName()).log(Level.SEVERE, null, ex);

            }

            LimparCampos();

        }

    }
}
