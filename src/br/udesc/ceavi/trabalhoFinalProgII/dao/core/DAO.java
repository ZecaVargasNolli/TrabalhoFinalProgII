package br.udesc.ceavi.trabalhoFinalProgII.dao.core;

/**
 * Esta Interface define as funçõe sbásicas ce inserçao, consulta, alteração e exclusão de objetos
 * @author Márcio José Mantau
 * @version 1.0
 */
public interface DAO<X> {
    
    
    boolean inserir(X obj) throws Exception;
    boolean atualizar(X obj)throws Exception;
    boolean deletar(X obj) throws Exception;
    public Object pesquisarPorId(Class tipo, long id) throws Exception;
    
    
    
}
