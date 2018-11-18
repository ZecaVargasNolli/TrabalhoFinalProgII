package br.udesc.ceavi.trabalhoFinalProgII.Model;

import br.udesc.ceavi.trabalhoFinalProgII.Model.Item;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Requisitante;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-18T16:53:14")
@StaticMetamodel(Emprestimo.class)
public class Emprestimo_ { 

    public static volatile SingularAttribute<Emprestimo, Item> item;
    public static volatile SingularAttribute<Emprestimo, String> data;
    public static volatile SingularAttribute<Emprestimo, Requisitante> requisitante;
    public static volatile SingularAttribute<Emprestimo, Usuario> usuario;
    public static volatile SingularAttribute<Emprestimo, Integer> id;

}