package br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc;

import br.udesc.ceavi.trabalhoFinalProgII.Model.Fornecedor;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Item;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Tipo;
import br.udesc.ceavi.trabalhoFinalProgII.dao.core.JPADAO;
import java.util.List;
import javax.persistence.Query;

/**
 * Esta classe e responsavel pelas funções básicas de inserçao, consulta,
 * alteração e exclusão de ojetos do tipo item utilizando o padrão JPA
 *
 * @author Giancarlo Pandini
 * @since 18/11/2018
 * @version 1,0
 */
public class ItemDAO extends JPADAO<Item> {

    public List<Item> buscarItem() {
        List<Item> itens = null;
        Query query = em.createNamedQuery("buscarItem", Item.class);
        itens = query.getResultList();
        return itens;
    }

    public List<Item> buscarItemPorTipo(Tipo tipo) {
        List<Item> itens = null;
        Query query = em.createNamedQuery("buscarItemPorTipo", Item.class);
        query.setParameter("tipo", tipo);
        itens = query.getResultList();
        return itens;
    }

    public List<Item> buscarItemPorNome(String nome) {
        List<Item> itens = null;;
        Query query = em.createNamedQuery("buscarItemPorNome", Item.class);
        query.setParameter("nome", nome);
        itens = query.getResultList();
        return itens;

    }
    
    public List<Item> buscarItemPorFornecedor(Fornecedor fornecedor) {
        List<Item> itens = null;
        Query query = em.createNamedQuery("buscarItemPorFornecedor", Item.class);
        query.setParameter("fornecedor", fornecedor);
        itens = query.getResultList();
        return itens;
    }
}
