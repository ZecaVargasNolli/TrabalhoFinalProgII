package br.udesc.ceavi.trabalhoFinalProgII.Model;

/**
 * Classe enumeration Categoria, rsponsável por indicar as predifinições de
 * categorias para a classe tipo.
 *
 * esta classe nao precisa ser mapeada
 *
 * @author José Vargas Nolli
 * @author Giancarlo Pandini
 * @author Gustavo José 
 * @version 1.0
 * @since 18/08/2018
 */
public enum Categoria {

    HIGIENE_PERECIVEL("higiene perecivel"),
    HIGIENE_NAO_PERECIVEL("higiene nao perecivel"),
    ELETRONICO_PERECIVEL("eletrônico percivel"),
    ELETRONICO_NAO_PERECIVEL("eletronico nao perecivel"),
    LIMPEZA_PERECIVEL("limpeza perecivel"),
    LIMPEZA_NAO_PERECIVEL("limpeza nao perecivel"),
    MOVEIS("moveis"),
    MATERIAIS("materiais"),
    ALIMENTOS("alimentos"),
    PEÇAS("peças"),
    PRODUTO_QUIMICO("produto quimico");

    private String escolhaCategoria;

    Categoria(String escolhaCategoria) {
        this.escolhaCategoria = escolhaCategoria;
    }

    @Override
    public String toString() {
        return escolhaCategoria;
    }

}
