package br.udesc.ceavi.trabalhoFinalProgII.dao.core;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * Esta classe e responsavel pelas funções básicas de inserçao, consulta,
 * alteração e exclusão de objetos utilizando o padrão JPA
 *
 * @author Giancarlo Pandini
 * @version 1.0
 */
public class JPADAO<Object> implements DAO<Object> {

    public static EntityManagerFactory emf;
    public static EntityManager em;

    public JPADAO() {
        super();
        emf = javax.persistence.Persistence.createEntityManagerFactory("TrabalhoFinalProgIIPU");
        em = emf.createEntityManager();
    }

    @Override
    public boolean inserir(Object obj) throws Exception {
        em.getTransaction().begin();

        try {
            em.persist(obj);
            em.getTransaction().commit();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }

        return false;
    }

    @Override
    public boolean atualizar(Object obj) throws Exception {
        em.getTransaction().begin();
        try {
            em.merge(obj);
            em.getTransaction().commit();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }

        return false;
    }

    @Override
    public boolean deletar(Object obj) throws Exception {
        em.getTransaction().begin();
        try {
            em.remove(obj);
            em.getTransaction().commit();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }

        return false;
    }

    @Override
    public Object pesquisarPorId(Class tipo, long id) throws Exception {
        Object object = null;
        em.getTransaction().begin();

        try {
            object = (Object) em.find(tipo, id);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }

        return object;
    }

}
