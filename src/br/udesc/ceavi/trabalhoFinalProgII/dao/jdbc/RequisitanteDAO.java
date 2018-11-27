
package br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc;

import br.udesc.ceavi.trabalhoFinalProgII.Model.Requisitante;
import br.udesc.ceavi.trabalhoFinalProgII.dao.core.JPADAO;
import java.util.List;
import javax.persistence.Query;

/**
 * Esta classe e responsavel pelas funções básicas de inserçao, consulta,
 * alteração e exclusão de ojetos do tipo Requisitante utilizando o padrão JPA
 *
 * @author Giancarlo Pandini
 * @since 20/11/2018
 * @version 1.0
 */

public class RequisitanteDAO extends JPADAO<Requisitante> {
    
    
    public List<Requisitante> buscarRequisitante() {
        List<Requisitante> itens = null;
        Query query = em.createNamedQuery("buscarRequisitante", Requisitante.class);
        itens = query.getResultList();
        return itens;
    }
    
}
