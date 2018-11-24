
package br.udesc.ceavi.trabalhoFinalProgII.dao.jdbc;

import br.udesc.ceavi.trabalhoFinalProgII.Model.Usuario;
import br.udesc.ceavi.trabalhoFinalProgII.dao.core.JPADAO;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 * Esta classe e responsavel pelas funções básicas de inserçao, consulta,
 * alteração e exclusão de ojetos do tipo Usuario utilizando o padrão JPA
 *
 * @author Giancarlo Pandini
 * @since 20/11/2018
 * @version 1.0
 */


public class UsuarioDAO extends JPADAO<Usuario> {
    
    public Usuario getUsuario(String nomeUsuario, String senha) {
  
            try {
                  Usuario usuario = (Usuario) em
                             .createQuery(
                                         "SELECT u from Usuario u where u.nome = :nome and u.senha = :senha")
                             .setParameter("nome", nomeUsuario)
                             .setParameter("senha", senha).getSingleResult();
  
                  return usuario;
            } catch (NoResultException e) {
                  return null;
            }
      }
    
    
     public List<Usuario> buscarUsuario() {
        List<Usuario> itens = null;
        Query query = em.createNamedQuery("buscarUsuario", Usuario.class);
        itens = query.getResultList();
        return itens;
    }
    
}
