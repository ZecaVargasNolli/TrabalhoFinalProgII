package br.udesc.ceavi.trabalhoFinalProgII.Model;

import br.udesc.ceavi.trabalhoFinalProgII.Model.Cidade;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-18T16:53:14")
@StaticMetamodel(Endereco.class)
public class Endereco_ { 

    public static volatile SingularAttribute<Endereco, Integer> codigo;
    public static volatile SingularAttribute<Endereco, Cidade> cidade;
    public static volatile SingularAttribute<Endereco, String> complemento;
    public static volatile SingularAttribute<Endereco, Integer> numero;
    public static volatile SingularAttribute<Endereco, String> bairro;
    public static volatile SingularAttribute<Endereco, String> cep;

}