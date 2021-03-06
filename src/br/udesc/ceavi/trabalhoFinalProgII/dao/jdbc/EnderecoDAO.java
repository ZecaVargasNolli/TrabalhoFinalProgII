package br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc;

import br.udesc.ceavi.trabalhoFinalProgII.Model.Cidade;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Endereco;
import br.udesc.ceavi.trabalhoFinalProgII.dao.core.JPADAO;
import static br.udesc.ceavi.trabalhoFinalProgII.dao.core.JPADAO.em;
import java.util.List;
import javax.persistence.Query;

/**
 * Esta classe e responsavel pelas funções básicas de inserçao, consulta,
 * alteração e exclusão de ojetos do tipo Endereco utilizando o padrão JPA
 *
 * @author Giancarlo Pandini
 * @author Gustavo José
 * @author José Vargas Nolli
 * @since 29/11/2018
 * @version 1.0
 */
public class EnderecoDAO extends JPADAO<Endereco> {

    public List<Endereco> buscarEndereco() {
        List<Endereco> itens = null;
        Query query = em.createNamedQuery("buscarEndereco", Endereco.class);
        itens = query.getResultList();
        return itens;
    }

    public List<Endereco> buscarEnderecoPorCidade(Cidade cid) {
        List<Endereco> itens = null;
        Query query = em.createNamedQuery("buscarEnderecoPorCidade", Endereco.class);
        query.setParameter("cidade", cid);
        itens = query.getResultList();
        return itens;
    }
}
