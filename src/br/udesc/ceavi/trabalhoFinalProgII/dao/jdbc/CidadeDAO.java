
package br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc;

import br.udesc.ceavi.trabalhoFinalProgII.Model.Cidade;
import br.udesc.ceavi.trabalhoFinalProgII.dao.core.JPADAO;
import java.util.List;
import javax.persistence.Query;

/**
 * Esta classe e responsavel pelas funções básicas de inserçao, consulta,
 * alteração e exclusão de ojetos do tipo Cidade utilizando o padrão JPA
 *
 * @author Giancarlo Pandini
 * @since 20/11/2018
 * @version 1,0
 */
public class CidadeDAO extends JPADAO<Cidade> {
    
     public List<Cidade> buscarItem() {
        List<Cidade> itens = null;
        Query query = em.createNamedQuery("buscarCidade", Cidade.class);
        itens = query.getResultList();
        return itens;
    }
}
