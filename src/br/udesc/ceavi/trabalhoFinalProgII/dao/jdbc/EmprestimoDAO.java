
package br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc;

import br.udesc.ceavi.trabalhoFinalProgII.Model.Cidade;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Emprestimo;
import br.udesc.ceavi.trabalhoFinalProgII.dao.core.JPADAO;
import java.util.List;
import javax.persistence.Query;

/**
 * Esta classe e responsavel pelas funções básicas de inserçao, consulta,
 * alteração e exclusão de ojetos do tipo Emprestimo utilizando o padrão JPA
 *
 * @author Giancarlo Pandini
 * @since 26/11/2018
 * @version 1.0
 */
public class EmprestimoDAO extends JPADAO<Emprestimo> {
    
    public List<Emprestimo> buscarEmprestimo() {
        List<Emprestimo> itens = null;
        Query query = em.createNamedQuery("buscarEmprestimos", Emprestimo.class);
        itens = query.getResultList();
        return itens;
    }
     
}
