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

    HIGIENE_PERECIVEL("higiene perecível"),
    HIGIENE_NAO_PERECIVEL("higiene nâo perecível"),
    ELETRONICO_PERECIVEL("eletrônico percível"),
    ELETRONICO_NAO_PERECIVEL("eletrônico nâo perecível"),
    LIMPEZA_PERECIVEL("limpeza perecível"),
    LIMPEZA_NAO_PERECIVEL("limpeza não perecível"),
    MOVEIS("moveis"),
    MATERIAIS("materiais"),
    ALIMENTOS("alimentos"),
    PEÇAS("peças"),
    PRODUTO_QUIMICO("produto quimíco");

    private String escolhaCategoria;

    Categoria(String escolhaCategoria) {
        this.escolhaCategoria = escolhaCategoria;
    }

    @Override
    public String toString() {
        return escolhaCategoria;
    }

}
