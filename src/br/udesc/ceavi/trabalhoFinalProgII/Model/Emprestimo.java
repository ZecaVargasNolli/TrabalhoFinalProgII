/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.trabalhoFinalProgII.Model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Classe emprestimo, é a matriz do sistema pois parte do que é importante é
 * feito aqui.
 *
 * mapeado por Giancarlo Pandini
 *
 * @author José Vargas Nolli
 * @version 1.0
 * @since 27/10/2018
 */
@Entity
@Table(name = "emprestimo")
@NamedQueries({
    @NamedQuery(name = "buscarEmprestimos", query = "SELECT e FROM Emprestimo e")
})
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    private Item item;

    @ManyToOne(cascade = CascadeType.ALL)
    private Requisitante requisitante;


    @Column(name = "data")
    private String data;

    public Emprestimo() {

    }

    //o construtor se ve nescessário pois essa funcção é feita pelos métodos.
    public Emprestimo(Item item, Requisitante requisitante, String data) {
        this.item = item;
        this.requisitante = requisitante;
        
        this.data = data;
    }

    @Override
    public String toString() {
        return "Emprestimo{" + "item=" + item + ", requisitante=" + requisitante + ", data=" + data + '}';
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

   
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
