package br.udesc.ceavi.trabalhoFinalProgII.Model;

/**
 * Classe enumeration Categoria, rsponsável por indicar as predifinições de
 * categorias para a classe tipo.
 * 
 * esta classe nao precisa ser mapeada
 *
 * @author José Vargas Nolli
 * @version 1.0
 * @since 18/08/2018
 */
public enum Categoria {

    HIGIENE("higiene"), ELETRONICO("eletrônico"), PERECIVEL("Perecivel"), NAOPERECIVEL("não perecivel");

    private String escolhaCategoria;

    Categoria(String escolhaCategoria) {
        this.escolhaCategoria = escolhaCategoria;
    }

    @Override
    public String toString() {
        return escolhaCategoria;
    }

}
