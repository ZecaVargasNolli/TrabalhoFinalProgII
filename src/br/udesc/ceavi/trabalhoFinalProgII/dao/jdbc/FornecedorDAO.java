package br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc;

import br.udesc.ceavi.trabalhoFinalProgII.Model.Fornecedor;
import br.udesc.ceavi.trabalhoFinalProgII.dao.core.JPADAO;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Endereco;
import java.util.List;
import javax.persistence.Query;

/**
 * Esta classe e responsavel pelas funções básicas de inserçao, consulta,
 * alteração e exclusão de ojetos do tipo Fornecedor utilizando o padrão JPA
 *
 * @author Giancarlo Pandini
 * @author Gustavo José
 * @author José Vargas Nolli
 * @since 29/11/2018
 * @version 1.0
 */
public class FornecedorDAO extends JPADAO<Fornecedor> {

    public List<Fornecedor> buscarFornecedor() {
        List<Fornecedor> itens = null;
        Query query = em.createNamedQuery("buscarFornecedor", Fornecedor.class);
        itens = query.getResultList();
        return itens;
    }

    public List<Fornecedor> buscarFornecedorPorEndereco(Endereco cid) {
        List<Fornecedor> itens = null;
        Query query = em.createNamedQuery("buscarFornecedorporEndereco", Fornecedor.class);
        query.setParameter("endereco", cid);
        itens = query.getResultList();
        return itens;
    }

}
