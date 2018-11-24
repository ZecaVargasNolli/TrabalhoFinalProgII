
package br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc;

import br.udesc.ceavi.trabalhoFinalProgII.Model.Endereco;
import br.udesc.ceavi.trabalhoFinalProgII.dao.core.JPADAO;
import java.util.List;
import javax.persistence.Query;

/**
 * Esta classe e responsavel pelas funções básicas de inserçao, consulta,
 * alteração e exclusão de ojetos do tipo Endereco utilizando o padrão JPA
 *
 * @author Giancarlo Pandini
 * @since 20/11/2018
 * @version 1.0
 */
public class EnderecoDAO extends JPADAO<Endereco> {
    
     public List<Endereco> buscarEndereco() {
        List<Endereco> itens = null;
        Query query = em.createNamedQuery("buscarEndereco", Endereco.class);
        itens = query.getResultList();
        return itens;
    }
    
}
