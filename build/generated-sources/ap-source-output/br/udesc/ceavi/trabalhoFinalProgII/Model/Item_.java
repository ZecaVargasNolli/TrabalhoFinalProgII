package br.udesc.ceavi.trabalhoFinalProgII.Model;

import br.udesc.ceavi.trabalhoFinalProgII.Model.Fornecedor;
import br.udesc.ceavi.trabalhoFinalProgII.Model.Tipo;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-18T16:53:14")
@StaticMetamodel(Item.class)
public class Item_ { 

    public static volatile SingularAttribute<Item, Long> codigo;
    public static volatile SingularAttribute<Item, Tipo> tipo;
    public static volatile SingularAttribute<Item, Boolean> emEstoque;
    public static volatile SingularAttribute<Item, String> nome;
    public static volatile SingularAttribute<Item, Fornecedor> fornecedor;
    public static volatile SingularAttribute<Item, String> DatadeAquisicao;

}