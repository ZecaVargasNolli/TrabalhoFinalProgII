
package br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc;

import br.udesc.ceavi.trabalhoFinalProgII.Model.Fornecedor;
import br.udesc.ceavi.trabalhoFinalProgII.dao.core.JPADAO;
import java.util.List;
import javax.persistence.Query;

/**
 * Esta classe e responsavel pelas funções básicas de inserçao, consulta,
 * alteração e exclusão de ojetos do tipo Fornecedor utilizando o padrão JPA
 *
 * @author Giancarlo Pandini
 * @since 20/11/2018
 * @version 1.0
 */
public class FornecedorDAO extends JPADAO<Fornecedor> {
    
    public List<Fornecedor> buscarFornecedor() {
        List<Fornecedor> itens = null;
        Query query = em.createNamedQuery("buscarFornecedor", Fornecedor.class);
        itens = query.getResultList();
        return itens;
    }
    
}
