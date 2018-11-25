
package br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc;

import br.udesc.ceavi.trabalhoFinalProgII.Model.Cidade;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Tipo;
import br.udesc.ceavi.trabalhoFinalProgII.dao.core.JPADAO;
import static br.udesc.ceavi.trabalhoFinalProgII.dao.core.JPADAO.em;
import java.util.List;
import javax.persistence.Query;

/**
 * Esta classe e responsavel pelas funções básicas de inserçao, consulta,
 * alteração e exclusão de ojetos do tipo tipo utilizando o padrão JPA
 *
 * @author Giancarlo Pandini
 * @since 24/11/2018
 * @version 1,0
 */
public class TipoDAO extends JPADAO<Tipo> {
    
    public List<Tipo> buscarTipo() {
        List<Tipo> tipos = null;
        Query query = em.createNamedQuery("buscarTipo", Tipo.class);
        tipos = query.getResultList();
        return tipos;
    }
}
