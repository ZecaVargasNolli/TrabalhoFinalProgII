/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.trabalhoFinalProgII.Model;

import java.util.Date;

/**
 * Classe emprestimo, é a matrix do sistema pois parte do que é importante é
 * feito aqui.
 *
 * @author José Vargas Nolli
 * @version 1.0
 * @since 27/10/2018
 */
public class Emprestimo {

    private Item item;
    private Requisitante requisitante;
    private Usuario usuario;
    private Date data;

    public Emprestimo() {

    }

    //o construtor se ve nescessário pois essa funcção é feita pelos métodos.
    public Emprestimo(Item item, Requisitante requisitante, Usuario usuario, Date data) {
        this.item = item;
        this.requisitante = requisitante;
        this.usuario = usuario;
        this.data = data;
    }

    public void Emprestar(Item item, Requisitante requisitante, Usuario usuario, Date data) {

        this.data = data;
        this.item = item;
        this.requisitante = requisitante;
        this.usuario = usuario;
    }

    public void Devolucao(Item item, Requisitante requisitante, Usuario usuario, Date data) {

        this.data = data;
        this.item = item;
        this.requisitante = requisitante;
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Emprestimo{" + "item=" + item + ", requisitante=" + requisitante + ", usuario=" + usuario + ", data=" + data + '}';
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Requisitante getRequisitante() {
        return requisitante;
    }

    public void setRequisitante(Requisitante requisitante) {
        this.requisitante = requisitante;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

}
