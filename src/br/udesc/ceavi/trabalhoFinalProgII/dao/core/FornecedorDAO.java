
package br.udesc.ceavi.trabalhoFinalProgII.dao.core;

import br.udesc.ceavi.trabalhoFinalProgII.Model.Fornecedor;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author José Vargas Nolli
 */
public class FornecedorDAO  implements DAO<Fornecedor>{
    
    
    public static EntityManagerFactory emf;
    public static EntityManager em;

    
    
    
    public List<Fornecedor> Carregar(){
        
        List<Fornecedor>fornecedores = new ArrayList<Fornecedor>();
        em.getTransaction().begin();
        
        
        try {
            
          Query query = em.createQuery("SELECT * FROM fornecedor");
          fornecedores = query.getResultList();
          
            
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        
      return fornecedores;
    }

    @Override
    public boolean inserir(Fornecedor obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean atualizar(Fornecedor obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deletar(Fornecedor obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object pesquisarPorId(Class tipo, long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       
       
}
