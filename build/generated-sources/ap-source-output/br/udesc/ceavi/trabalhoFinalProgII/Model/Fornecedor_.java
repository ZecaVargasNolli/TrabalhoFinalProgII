package br.udesc.ceavi.trabalhoFinalProgII.Model;

import br.udesc.ceavi.trabalhoFinalProgII.Model.Endereco;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-18T16:53:14")
@StaticMetamodel(Fornecedor.class)
public class Fornecedor_ { 

    public static volatile SingularAttribute<Fornecedor, String> produtosFornecidos;
    public static volatile SingularAttribute<Fornecedor, Integer> codigo;
    public static volatile SingularAttribute<Fornecedor, Endereco> endereco;
    public static volatile SingularAttribute<Fornecedor, Long> valorDosProdutos;
    public static volatile SingularAttribute<Fornecedor, String> nomeDaEmpresa;
    public static volatile SingularAttribute<Fornecedor, String> cnpj;

}