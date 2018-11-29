package br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios.Alterar;

import br.udesc.ceavi.trabalhoFinalProgII.Listeners.CancelarListener;
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
 * Frame responsavel por alterar os dados de Tipo
 *
 * @author Giancarlo Pandini
 * @author Gustavo José
 * @author José Vargas Nolli
 * @since 29/11/2018
 * @version 1.0
 */
public class FrameAlterarTipo extends FrameAlterar {

    //ATRIBUTOS
    private Label lbDescriscao;
    private Label lbNome;
    private Label lbCategorias;
    private Label lbCategoria;

    private Tipo tipo;

    private JTextField tfDescricao;
    private JTextField tfNome;

    private JComboBox cbCategoria;

    private JPanel panelFormulario;

    private LayoutManager layout;
    private GridBagConstraints cons;

    //CONSTRUTOR DA CLASSE
    public FrameAlterarTipo(String titulo, Dimension tamanho, Tipo tipo) {
        super(titulo, tamanho);
        this.tipo = tipo;

        initializeComponents();
        addComponents();
        addTipo();
        addDados();
    }

    //METODO QUE INICALIZA OS COMPONENTES
    private void initializeComponents() {
        lbDescriscao = new Label("Descrição: ");
        lbNome = new Label("Nome: ");
        lbCategorias = new Label("Categoria Atual: ");
        lbCategoria = new Label(tipo.getCategoria().toString());

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
        panelFormulario.add(lbCategoria, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 3;
        cons.gridwidth = 2;
        cons.ipadx = 100;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(cbCategoria, cons);

        super.addFormulario(panelFormulario);
    }

    //METODO QUE ADICONA OS LISTENER NOS BOTOES
    private void addTipo() {
        JButton bt;

        bt = getPaneBotoes().getBtCancelar();
        ActionListener actionCancelar = new CancelarListener(this);
        bt.addActionListener(actionCancelar);
        bt = getPaneBotoes().getBtOK();
        ActionListener actionAlterar = new AlterarTipoOk();
        bt.addActionListener(actionAlterar);

    }

    private void addDados() {

        tfDescricao.setText(tipo.getDescricao());
        tfNome.setText(tipo.getNome());

    }

    public class AlterarTipoOk implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            TipoDAO dao = new TipoDAO();
            tipo.setCategoria((Categoria) cbCategoria.getSelectedItem());
            tipo.setDescricao(tfDescricao.getText());
            tipo.setNome(tfNome.getText());

            try {
                dao.atualizar(tipo);
                JOptionPane.showMessageDialog(null, "Tipo alterada com sucesso");
            } catch (Exception ex) {
                Logger.getLogger(FrameAlterarTipo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
