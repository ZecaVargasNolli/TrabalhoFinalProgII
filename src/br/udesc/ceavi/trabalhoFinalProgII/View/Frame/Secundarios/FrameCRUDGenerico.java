package br.udesc.ceavi.trabalhoFinalProgII.View.Frame.Secundarios;

import br.udesc.ceavi.trabalhoFinalProgII.view.Panel.PanelCadastro;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Classe genérica para a criação de frames,onde serão efetuados os cadastros.
 *
 * @author José Vargas Nolli
 * @author Gustavo José
 * @author Giancarlo Pandini
 * @version 1.0
 * @since 09/11/2018
 */
public abstract class FrameCRUDGenerico extends JFrame {

    //atributos-------------
    private JPanel panelPrincipal;
    protected PanelCadastro panelBotoes;

    private Dimension tamanho;

    private LayoutManager layout;
//----------------------------

    //CONSTROTOR DA CLASSE.
    public FrameCRUDGenerico(String titulo, Dimension tamanho) {
        this.tamanho = tamanho;

        InitCom();
        addCom();

        super.setSize(tamanho);
        super.setTitle(titulo);
        super.setLayout(layout);
        super.setResizable(false);
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

    }
//METODO CHAMADO NO CONSTRUTOR TEM COMO OBJETIVO INICIAR OS COMPONENTES DO FRAME

    private void InitCom() {
        panelPrincipal = new JPanel();
        panelPrincipal.setSize(tamanho);

        panelBotoes = new PanelCadastro(this);

        layout = new BorderLayout();

        panelPrincipal.setLayout(layout);

    }
//METODO CHAMADO NO CONSTRUTOR TEM COMO OBJETIVO ADICIONAR OS COMPONENTES AO FRAME

    private void addCom() {
        panelPrincipal.add(panelBotoes, BorderLayout.SOUTH);
        this.setContentPane(panelPrincipal);

    }
//METODO USADO PARA ADICIONAR UM FORMULARIO NO MEIO DO FRAME.

    public void addFormulario(Container parent) {
        panelPrincipal.add(parent, BorderLayout.CENTER);
    }

    //GETTERS
    public PanelCadastro getPanelBotoes() {
        return panelBotoes;
    }

    public void setPanelBotoes(PanelCadastro panelBotoes) {
        this.panelBotoes = panelBotoes;
    }

    //METODO DE LIMPEZA USADO  IMPLEMENTADO APENAS NAS CLASSES FILHAS.
    public void LimparCampos() {

    }

}
