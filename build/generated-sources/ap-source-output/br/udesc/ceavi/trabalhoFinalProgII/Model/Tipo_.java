package br.udesc.ceavi.trabalhoFinalProgII.Model;

import br.udesc.ceavi.trabalhoFinalProgII.Model.Categoria;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-18T16:53:14")
@StaticMetamodel(Tipo.class)
public class Tipo_ { 

    public static volatile SingularAttribute<Tipo, String> Descricao;
    public static volatile SingularAttribute<Tipo, Long> codigo;
    public static volatile SingularAttribute<Tipo, Categoria> categoria;
    public static volatile SingularAttribute<Tipo, String> nome;

}