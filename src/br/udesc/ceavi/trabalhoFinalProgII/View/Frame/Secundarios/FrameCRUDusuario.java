package br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios;

import br.udesc.ceavi.trabalhoFinalProgII.Model.Usuario;
import br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc.UsuarioDAO;
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
 * Classe responsável por construir o formulário de usuario
 *
 * @author José Vargas Nolli
 * @author Giancarlo Pandini
 * @author Gustavo José
 *
 * @since 29/11/2018
 * @version 1.0
 */
public class FrameCRUDusuario extends FrameCRUDGenerico {

    //ATRIBUTOS
    private JLabel lbNome;

    private JLabel lbSenha;

    private JTextField txNome;

    private JTextField txSenha;

    private LayoutManager layout;

    private GridBagConstraints cons;
    private JPanel panelFormulario;

    //CONSTRUTOR DA CLASSE
    public FrameCRUDusuario(String titulo, Dimension tamanho) {
        super(titulo, tamanho);

        initCom();
        addCom();
        addListener();
    }

    //METODO QUE INICA OS COMPONETES
    private void initCom() {
        lbNome = new JLabel("Nome: ");
        lbSenha = new JLabel("Senha: ");
        txNome = new JTextField();
        txSenha = new JTextField();
        layout = new GridBagLayout();
        panelFormulario = new JPanel(layout);

    }

    //METODO QUE ADICIONA OS COMPONENTES
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

        //------------------
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 1;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbSenha, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 1;
        cons.gridwidth = 2;
        cons.ipadx = 100;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(txSenha, cons);

        super.add(panelFormulario);

    }

    @Override//METODO QUE LIMPA O CAMPO DOS FORMULARIOS
    public void LimparCampos() {

        txNome.setText("");
        txSenha.setText("");

    }

    //METODO QUE ADIONA OS LISTENERS
    private void addListener() {
        ActionListener actionGravar = new GravarUsuario();
        JButton bt;
        bt = getPanelBotoes().getBtCadastrar();
        bt.addActionListener(actionGravar);
        bt = getPanelBotoes().getBtAtualizar();
        bt.setVisible(false);
    }

    /**
     * Classe interna respon´savel pelo cadastro de usuario no banco
     *
     * @author José Vargas Nolli
     * @author Giancarlo Pandini
     * @author Gustavo José
     * @since 29/11/2018
     * @version 1.0
     */
    public class GravarUsuario implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            UsuarioDAO uDAO = new UsuarioDAO();
            Usuario user = new Usuario();
            user.setNome(txNome.getText());
            user.setSenha(txSenha.getText());

            try {
                uDAO.inserir(user);
                JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso!");
            } catch (Exception ex) {
                Logger.getLogger(FrameCRUDendereco.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Erro ao cadastrar usuario");
            }

            LimparCampos();
        }

    }

}
