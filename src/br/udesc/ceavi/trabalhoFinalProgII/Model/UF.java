
package br.udesc.ceavi.trabalhoFinalProgII.Model;

/**
 *Essa classe representa os UFs decidade somente setado para os brasileiros.
 * Para fins de teste.
 * 
 * @author José Vargas Nolli
 * @version 1.0
 * @since 27/10/2018
 */
public enum UF {
    
    
    AC("AC"),AL("AL"),AM("AM"),AP("AP"),BA("BA"),CE("CE"),DF("DF"),ES("ES"),GO("GO"),MA("MA"),MG("MG"),MS("MT"),
    MT("MT"),PA("PA"),PB("PB"),PE("PE"),PI("PI"),PR("PR"),RJ("RJ"),RN("RN"),RO("RO"),RR("RR"),RS("RS"),SC("SC"),SE("SE")
    ,SP("SP"),TO("TO");
   
    private String escolhaUF;

    UF(String escolhaUF) {
        this.escolhaUF = escolhaUF;
    }

    @Override
    public String toString() {
        return escolhaUF;
    }
}
