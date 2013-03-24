/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.interfaces;

import ohtu.verkkokauppa.Tuote;
import ohtu.verkkokauppa.Tuote;

/**
 *
 * @author ville
 */
public interface OstoskoriInterface {

    int hinta();

    void lisaa(Tuote t);

    void poista(Tuote t);
    
}
